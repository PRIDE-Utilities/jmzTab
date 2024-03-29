package uk.ac.ebi.pride.jmztab.utils.parser;

import org.junit.After;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import uk.ac.ebi.pride.jmztab.model.MZTabColumnFactory;
import uk.ac.ebi.pride.jmztab.model.Metadata;
import uk.ac.ebi.pride.jmztab.model.Reliability;
import uk.ac.ebi.pride.jmztab.model.Section;
import uk.ac.ebi.pride.jmztab.utils.errors.*;

import java.io.FileNotFoundException;
import java.net.URL;

import static org.junit.Assert.assertTrue;

/**
 * @author qingwei
 * @since 16/09/13
 */
public class ProteinValidateTest {
    private Logger logger = LoggerFactory.getLogger(ProteinValidateTest.class);

    private MZTabErrorList errorList;
    private PRTLineParser prtParser;
    private MZTabColumnFactory prhFactory;

    public ProteinValidateTest() throws Exception {
        MTDLineParserTest test = new MTDLineParserTest();
        String fileName = "testset/mtdFile.txt";
        Metadata metadata;

        URL uri = ProteinValidateTest.class.getClassLoader().getResource(fileName);
        if(uri != null) {
            metadata = test.parseMetadata(uri.getFile());
        } else {
            throw new FileNotFoundException(fileName);
        }

        errorList = new MZTabErrorList(MZTabErrorType.Level.Warn);

        PRHLineParser prhParser = new PRHLineParser(metadata);
        String headerLine = "PRH\t" +
            "accession\t" +
            "description\t" +
            "taxid\t" +
            "species\t" +
            "database\t" +
            "database_version\t" +
            "search_engine\t" +
            "best_search_engine_score[1]\t" +
            "search_engine_score[1]_ms_run[1]\t" +
            "search_engine_score[1]_ms_run[2]\t" +
            "reliability\t" +
            "num_psms_ms_run[1]\t" +
            "num_peptides_distinct_ms_run[1]\t" +
            "num_peptides_unique_ms_run[1]\t" +
            "ambiguity_members\t" +
            "modifications\t" +
            "uri\t" +
            "go_terms\t" +
            "protein_coverage\t" +
            "protein_abundance_assay[1]\t" +
            "protein_abundance_assay[2]\t" +
            "protein_abundance_study_variable[1]\t" +
            "protein_abundance_stdev_study_variable[1]\t" +
            "protein_abundance_std_error_study_variable[1]\t" +
            "opt_assay[1]_my_value\t" +
            "opt_global_cv_MS:1002217_decoy_peptide";
        prhParser.parse(1, headerLine, errorList);
        prhFactory = prhParser.getFactory();
        prtParser = new PRTLineParser(prhFactory, new PositionMapping(prhFactory, headerLine), metadata, errorList);
    }

    @After
    public void tearDown() throws Exception {
        for (MZTabError mzTabError : errorList.getErrorList()) {
            logger.debug(mzTabError.toString());
        }
        errorList.clear();
    }

    private void assertError(MZTabErrorType errorType) {
        assertTrue(errorList.getError(errorList.size() - 1).getType() == errorType);
    }

    @Test
    public void testAccession() throws Exception {
        assertTrue(prtParser.checkAccession(prhFactory.findColumnByHeader("accession"), "P12345").equals("P12345"));
        // duplicate define protein accession.
        assertTrue(prtParser.checkAccession(prhFactory.findColumnByHeader("accession"), "P12345") == null);
        assertError(LogicalErrorType.DuplicationAccession);
        // accession not allow set "null" value.
        assertTrue(prtParser.checkAccession(prhFactory.findColumnByHeader("accession"), "null").equals("null"));
        assertError(LogicalErrorType.NotNULL);
    }

    @Test
    public void testParameterList() throws Exception {
        assertTrue(prtParser.checkSearchEngine(prhFactory.findColumnByHeader("search_engine"), "[MS,MS:1001207,,]").size() == 0);
        assertError(FormatErrorType.ParamList);
//        assertTrue(prtParser.checkBestSearchEngineScore(prhFactory.findColumnByHeader("best_search_engine_score"), "[MS,MS:1001207,Mascot,]|[MS,MS:1001208,,]").size() == 0);
        assertError(FormatErrorType.ParamList);
        assertTrue(prtParser.checkSearchEngine(prhFactory.findColumnByHeader("search_engine"), "[MS,MS:1001207,Mascot,]/[MS,MS:1001208,Sequest,]").size() == 0);
        assertError(FormatErrorType.ParamList);
    }

    @Test
    public void testReliability() throws Exception {
        assertTrue(prtParser.checkReliability(prhFactory.findColumnByHeader("reliability"), "1") == Reliability.High);
        assertTrue(prtParser.checkReliability(prhFactory.findColumnByHeader("reliability"), "0") == null);
        assertError(FormatErrorType.Reliability);
    }

    @Test
    public void testModifications() throws Exception {
        prtParser.section = Section.Protein;
        assertTrue(prtParser.checkModifications(prhFactory.findColumnByHeader("modifications"),
                "8-MOD:00412, " +
                "8[MS,MS:1001876, modification probability, 0.3]-MOD:00412, ")
            .size() == 2);
        // case 1. If the software has determined that there are no modifications to a given protein "0" MUST be used
        assertTrue(prtParser.checkModifications(prhFactory.findColumnByHeader("modifications"),"0").size() == 0);
        // case 2. Ambiguity of modification position MUST NOT be reported at the Protein level.
        assertTrue(prtParser.checkModifications(prhFactory.findColumnByHeader("modifications"),"3|4|8-MOD:00412").size() == 1);
        assertError(LogicalErrorType.AmbiguityMod);
        // case 3. for proteins and peptides modifications SHOULD be reported using either UNIMOD or PSI-MOD accessions
        assertTrue(prtParser.checkModifications(prhFactory.findColumnByHeader("modifications"),"CHEMMOD:-18.0913").size() == 1);
        assertError(LogicalErrorType.CHEMMODS);
    }

    @Test
    public void testProteinCoverage() throws Exception {
        assertTrue(prtParser.checkProteinCoverage(prhFactory.findColumnByHeader("protein_coverage"), "NaN").equals(Double.NaN));
        // protein coverage value between 0 and 1.
        assertTrue(prtParser.checkProteinCoverage(prhFactory.findColumnByHeader("protein_coverage"), "1.2") == null);
        assertError(LogicalErrorType.ProteinCoverage);
    }

    @Test
    public void testDecoyPeptide() throws Exception {
        // The last item is decoy_peptide which value should be Boolan (0/1).
        String dataLine = "PRT\t" +
            "P12345\t" +
            "Aspartate aminotransferase, mitochondrial\t" +
            "10116\t" +
            "Rattus norvegicus (Rat)\t" +
            "UniProtKB\t2011_11\t" +
            "[MS, MS:1001207, Mascot, ]\t" +
            "50\t" +
            "null\t" +
            "null\t" +
            "1\t" +
            "4\t" +
            "3\t" +
            "2\t" +
            "P12347,P12348\t" +
            "3-MOD:00412,8-MOD:00412\t" +
            "http://www.ebi.ac.uk/pride/url/to/P12345\t" +
            "GO:0006457|GO:0005759|GO:0005886|GO:0004069\t" +
            "0.4\t" +
            "0.4\t" +
            "0.2\t" +
            "0.1\t" +
            "0.4\t" +
            "0.03\t" +
            "My value about assay[1]\t" +
            "false";

        prtParser.parse(1, dataLine, errorList);
        assertError(FormatErrorType.MZBoolean);
    }

}
