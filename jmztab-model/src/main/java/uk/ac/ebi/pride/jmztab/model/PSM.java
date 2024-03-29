package uk.ac.ebi.pride.jmztab.model;

import java.net.URI;
import static uk.ac.ebi.pride.jmztab.model.MZTabConstants.BAR;
import static uk.ac.ebi.pride.jmztab.model.MZTabConstants.COMMA;
import static uk.ac.ebi.pride.jmztab.model.MZTabConstants.TAB;
import static uk.ac.ebi.pride.jmztab.model.MZTabUtils.isEmpty;
import static uk.ac.ebi.pride.jmztab.model.MZTabUtils.parseDouble;
import static uk.ac.ebi.pride.jmztab.model.MZTabUtils.parseDoubleList;
import static uk.ac.ebi.pride.jmztab.model.MZTabUtils.parseInteger;
import static uk.ac.ebi.pride.jmztab.model.MZTabUtils.parseModificationList;
import static uk.ac.ebi.pride.jmztab.model.MZTabUtils.parseParam;
import static uk.ac.ebi.pride.jmztab.model.MZTabUtils.parseParamList;
import static uk.ac.ebi.pride.jmztab.model.MZTabUtils.parseSpectraRefList;
import static uk.ac.ebi.pride.jmztab.model.MZTabUtils.parseString;
import static uk.ac.ebi.pride.jmztab.model.MZTabUtils.parseURI;

/**
 * The PSM section is table-based. The PSM section MUST always come after the metadata section,
 * peptide section and or protein section if they are present in the file. All table columns MUST
 * be tab separated. Missing values MUST be reported using "null". Most columns are mandatory.
 * The order of columns is not specified although for ease of human interpretation, it is RECOMMENDED
 * to follow the order specified below.
 *
 * @author qingwei
 * @since 23/05/13
 */
public class PSM extends MZTabRecord {
    private Metadata metadata;

    /**
     * Create a PSM record based on structure defined by {@link MZTabColumnFactory}
     *
     * @param factory SHOULD NOT set null.
     * @param metadata SHOULD NOT set null.
     */
    public PSM(MZTabColumnFactory factory, Metadata metadata) {
        super(factory);
        this.metadata = metadata;
    }

    /**
     * The peptide's sequence corresponding to the PSM
     */
    public String getSequence() {
        return getString(PSMColumn.SEQUENCE.getLogicPosition());
    }

    /**
     * The peptide's sequence corresponding to the PSM
     */
    public void setSequence(String sequence) {
        setValue(PSMColumn.SEQUENCE.getLogicPosition(), parseString(sequence));
    }

    /**
     * A unique identifier for a PSM within the file. If a PSM can be matched to multiple proteins,
     * the same PSM should be represented on multiple rows with different accessions and the same PSM_ID.
     */
    public String getPSM_ID() {
        return ""+getInteger(PSMColumn.PSM_ID.getLogicPosition());
    }

    /**
     * A unique identifier for a PSM within the file. If a PSM can be matched to multiple proteins,
     * the same PSM should be represented on multiple rows with different accessions and the same PSM_ID.
     */
    public void setPSM_ID(Integer psmId) {
        setValue(PSMColumn.PSM_ID.getLogicPosition(), psmId);
    }

    /**
     * A unique identifier for a PSM within the file. If a PSM can be matched to multiple proteins,
     * the same PSM should be represented on multiple rows with different accessions and the same PSM_ID.
     *
     * @param psmIdLabel parsed by {@link MZTabUtils#parseInteger(String)}
     */
    public void setPSM_ID(String psmIdLabel) {
        setValue(PSMColumn.PSM_ID.getLogicPosition(), parseInteger(psmIdLabel));
    }

    /**
     * The protein's accession the corresponding peptide sequence (coming from the PSM) is associated with.
     * In case no protein section is present in the file or the peptide was not assigned to a protein the
     * field should be filled with "null". If the PSM can be assigned to more than one protein, the same
     * PSM should be represented on multiple rows with the same unique identifier.
     */
    public String getAccession() {
        return getString(PSMColumn.ACCESSION.getLogicPosition());
    }

    /**
     * The protein's accession the corresponding peptide sequence (coming from the PSM) is associated with.
     * In case no protein section is present in the file or the peptide was not assigned to a protein the
     * field should be filled with "null". If the PSM can be assigned to more than one protein, the same
     * PSM should be represented on multiple rows with the same unique identifier.
     */
    public void setAccession(String accession) {
        setValue(PSMColumn.ACCESSION.getLogicPosition(), parseString(accession));
    }

    /**
     * Indicates whether the peptide sequence (coming from the PSM) is unique for this protein in respect to
     * the searched database. Boolean (0/1)
     */
    public MZBoolean getUnique() {
        return getMZBoolean(PSMColumn.UNIQUE.getLogicPosition());
    }

    /**
     * Indicates whether the peptide sequence (coming from the PSM) is unique for this protein in respect to
     * the searched database. Boolean (0/1)
     */
    public void setUnique(MZBoolean unique) {
        setValue(PSMColumn.UNIQUE.getLogicPosition(), unique);
    }

    /**
     * Indicates whether the peptide sequence (coming from the PSM) is unique for this protein in respect to
     * the searched database. Boolean (0/1)
     *
     * @param uniqueLabel parsed by {@link MZBoolean#findBoolean(String)}
     */
    public void setUnique(String uniqueLabel) {
        setUnique(MZBoolean.findBoolean(uniqueLabel));
    }

    /**
     * The protein database used for the search (could theoretically come from a different species) and the
     * peptide sequence comes from.
     */
    public String getDatabase() {
        return getString(PSMColumn.DATABASE.getLogicPosition());
    }

    /**
     * The protein database used for the search (could theoretically come from a different species) and the
     * peptide sequence comes from.
     */
    public void setDatabase(String database) {
        setValue(PSMColumn.DATABASE.getLogicPosition(), parseString(database));
    }

    /**
     * The protein database's version - in case there is no version available (custom build) the creation
     * download (e.g., for NCBI nr) date should be given. Additionally, the number of entries in the database
     * MAY be reported in round brackets after the version in the format: {version} ({#entries} entries),
     * for example "2011-11 (1234 entries)".
     */
    public String getDatabaseVersion() {
        return getString(PSMColumn.DATABASE_VERSION.getLogicPosition());
    }

    /**
     * The protein database's version - in case there is no version available (custom build) the creation
     * download (e.g., for NCBI nr) date should be given. Additionally, the number of entries in the database
     * MAY be reported in round brackets after the version in the format: {version} ({#entries} entries),
     * for example "2011-11 (1234 entries)".
     */
    public void setDatabaseVersion(String databaseVersion) {
        setValue(PSMColumn.DATABASE_VERSION.getLogicPosition(), parseString(databaseVersion));
    }

    /**
     * A "|" delimited list of search engine(s) used to create the PSM. Search engines must be supplied as parameters.
     */
    public SplitList<Param> getSearchEngine() {
        return getSplitList(PSMColumn.SEARCH_ENGINE.getLogicPosition());
    }

    /**
     * Add a search engine used to create the PSM. Search engines must be supplied as parameters.
     */
    public boolean addSearchEngineParam(Param param) {
        if (param == null) {
            return false;
        }

        SplitList<Param> params = getSearchEngine();
        if (params == null) {
            params = new SplitList<Param>(BAR);
            setSearchEngine(params);
            params.add(param);
        } else if (! params.contains(param)) {
            params.add(param);
        }

        return true;
    }

    /**
     * Add a search engine used to create the PSM. Search engines must be supplied as parameters.
     *
     * @param paramLabel parsed by {@link MZTabUtils#parseParam(String)}
     */
    public boolean addSearchEngineParam(String paramLabel) {
        return !isEmpty(paramLabel) && addSearchEngineParam(parseParam(paramLabel));
    }

    /**
     * A "|" delimited list of search engine(s) used to create the PSM. Search engines must be supplied as parameters.
     */
    public void setSearchEngine(SplitList<Param> searchEngine) {
        setValue(PSMColumn.SEARCH_ENGINE.getLogicPosition(), searchEngine);
    }

    /**
     * A "|" delimited list of search engine(s) used to create the PSM. Search engines must be supplied as parameters.
     *
     * @param searchEngineLabel parsed by {@link MZTabUtils#parseParamList(String)}
     */
    public void setSearchEngine(String searchEngineLabel) {
        setSearchEngine(parseParamList(searchEngineLabel));
    }

    /**
     * The search engine score for the given protein in the defined ms run. The type of score
     * MUST be defined in the metadata section. If the protein was not identified by the specified
     * search engine “null” must be reported
     *
     * @param id search_engine_score[id] which MUST be defined in the metadata section.
     */
    public Double getSearchEngineScore(Integer id) {
        return getDouble(getLogicalPosition(PSMColumn.SEARCH_ENGINE_SCORE, id, null));
    }

    /**
     * The search engine score for the given protein in the defined ms run. The type of score
     * MUST be defined in the metadata section. If the protein was not identified by the specified
     * search engine “null” must be reported
     *
     * @param id search_engine_score[id] which MUST be defined in the metadata section.
     */
    public void setSearchEngineScore(Integer id, Double searchEngineScore) {
        setValue(getLogicalPosition(PSMColumn.SEARCH_ENGINE_SCORE, id, null), searchEngineScore);
    }

    /**
     * The search engine score for the given protein in the defined ms run. The type of score
     * MUST be defined in the metadata section. If the protein was not identified by the specified
     * search engine “null” must be reported
     *
     * @param id search_engine_score[id] which MUST be defined in the metadata section.
     */
    public void setSearchEngineScore(Integer id, String paramsLabel) {
        setSearchEngineScore(id, parseDouble(paramsLabel));
    }

    /**
     * The reliability of the given PSM. This must be supplied by the resource and has to be one of the following values:
     * <ol>
     *     <li>high reliability</li>
     *     <li>medium reliability</li>
     *     <li>poor reliability</li>
     * </ol>
     */
    public Reliability getReliability() {
        return getReliability(PSMColumn.RELIABILITY.getLogicPosition());
    }

    /**
     * The reliability of the given PSM. This must be supplied by the resource and has to be one of the following values:
     * <ol>
     *     <li>high reliability</li>
     *     <li>medium reliability</li>
     *     <li>poor reliability</li>
     * </ol>
     */
    public void setReliability(Reliability reliability) {
        setValue(PSMColumn.RELIABILITY.getLogicPosition(), reliability);
    }

    /**
     * The reliability of the given PSM. This must be supplied by the resource and has to be one of the following values:
     * <ol>
     *     <li>high reliability</li>
     *     <li>medium reliability</li>
     *     <li>poor reliability</li>
     * </ol>
     */
    public void setReliability(String reliabilityLabel) {
        setReliability(Reliability.findReliability(reliabilityLabel));
    }

    /**
     * The peptide's (coming from the PSM) modifications or substitutions. To further distinguish peptide terminal modifications,
     * these SHOULD be reported at position 0 or peptide size + 1 respectively. For detailed information see the modifications
     * section in the protein table. If substitutions are reported, the "sequence" column MUST contain the original, unaltered
     * sequence. Note that in contrast to the PRT and PEP section all modifications (variable and fixed modifications, including
     * those induced by quantification reagents) MUST BE reported in the PSM section.
     */
    public SplitList<Modification> getModifications() {
        return getSplitList(PSMColumn.MODIFICATIONS.getLogicPosition());
    }

    /**
     * The peptide's (coming from the PSM) modifications or substitutions. To further distinguish peptide terminal modifications,
     * these SHOULD be reported at position 0 or peptide size + 1 respectively. For detailed information see the modifications
     * section in the protein table. If substitutions are reported, the "sequence" column MUST contain the original, unaltered
     * sequence. Note that in contrast to the PRT and PEP section all modifications (variable and fixed modifications, including
     * those induced by quantification reagents) MUST BE reported in the PSM section.
     */
    public boolean addModification(Modification modification) {
        if (modification == null) {
            return false;
        }

        SplitList<Modification> modList = getModifications();
        if (modList == null) {
            modList = new SplitList<Modification>(COMMA);
            setModifications(modList);
        }

        return modList.add(modification);
    }

    /**
     * The peptide's (coming from the PSM) modifications or substitutions. To further distinguish peptide terminal modifications,
     * these SHOULD be reported at position 0 or peptide size + 1 respectively. For detailed information see the modifications
     * section in the protein table. If substitutions are reported, the "sequence" column MUST contain the original, unaltered
     * sequence. Note that in contrast to the PRT and PEP section all modifications (variable and fixed modifications, including
     * those induced by quantification reagents) MUST BE reported in the PSM section.
     */
    public void setModifications(SplitList<Modification> modifications) {
        setValue(PSMColumn.MODIFICATIONS.getLogicPosition(), modifications);
    }

    /**
     * The peptide's (coming from the PSM) modifications or substitutions. To further distinguish peptide terminal modifications,
     * these SHOULD be reported at position 0 or peptide size + 1 respectively. For detailed information see the modifications
     * section in the protein table. If substitutions are reported, the "sequence" column MUST contain the original, unaltered
     * sequence. Note that in contrast to the PRT and PEP section all modifications (variable and fixed modifications, including
     * those induced by quantification reagents) MUST BE reported in the PSM section.
     *
     * @param modificationsLabel parsed by {@link MZTabUtils#parseModificationList(Section, String)}
     */
    public void setModifications(String modificationsLabel) {
        setModifications(parseModificationList(Section.PSM, modificationsLabel));
    }

    /**
     * The retention time of the spectrum. A '|'-separated list of multiple time points is allowed in case multiple spectra
     * were combined by the search engine to make the PSM. It MUST be reported in seconds. Otherwise, the units MUST be reported
     * in the Metadata Section ('columnit_psm').
     */
    public SplitList<Double> getRetentionTime() {
        return getSplitList(PSMColumn.RETENTION_TIME.getLogicPosition());
    }

    /**
     * The retention time of the spectrum. A '|'-separated list of multiple time points is allowed in case multiple spectra
     * were combined by the search engine to make the PSM. It MUST be reported in seconds. Otherwise, the units MUST be reported
     * in the Metadata Section ('columnit_psm').
     */
    public boolean addRetentionTime(Double rt) {
        if (rt == null) {
            return false;
        }

        SplitList<Double> rtList = getRetentionTime();
        if (rtList == null) {
            rtList = new SplitList<Double>(BAR);
            setRetentionTime(rtList);
        }

        return rtList.add(rt);
    }

    /**
     * The retention time of the spectrum. A '|'-separated list of multiple time points is allowed in case multiple spectra
     * were combined by the search engine to make the PSM. It MUST be reported in seconds. Otherwise, the units MUST be reported
     * in the Metadata Section ('columnit_psm').
     *
     * @param rtLabel parsed by {@link MZTabUtils#parseDouble(String)}
     */
    public boolean addRetentionTime(String rtLabel) {
        return !isEmpty(rtLabel) && addRetentionTime(parseDouble(rtLabel));
    }

    /**
     * The retention time of the spectrum. A '|'-separated list of multiple time points is allowed in case multiple spectra
     * were combined by the search engine to make the PSM. It MUST be reported in seconds. Otherwise, the units MUST be reported
     * in the Metadata Section ('columnit_psm').
     */
    public void setRetentionTime(SplitList<Double> retentionTime) {
        setValue(PSMColumn.RETENTION_TIME.getLogicPosition(), retentionTime);
    }

    /**
     * The retention time of the spectrum. A '|'-separated list of multiple time points is allowed in case multiple spectra
     * were combined by the search engine to make the PSM. It MUST be reported in seconds. Otherwise, the units MUST be reported
     * in the Metadata Section ('columnit_psm').
     *
     * @param retentionTimeLabel parsed by {@link MZTabUtils#parseDoubleList(String)}
     */
    public void setRetentionTime(String retentionTimeLabel) {
        setRetentionTime(parseDoubleList(retentionTimeLabel));
    }

    /**
     * The charge assigned by the search engine/software.
     */
    public Integer getCharge() {
        return getInteger(PSMColumn.CHARGE.getLogicPosition());
    }

    /**
     * The charge assigned by the search engine/software.
     */
    public void setCharge(Integer charge) {
        setValue(PSMColumn.CHARGE.getLogicPosition(), charge);
    }

    /**
     * The charge assigned by the search engine/software.
     *
     * @param chargeLabel parsed by {@link MZTabUtils#parseInteger(String)}
     */
    public void setCharge(String chargeLabel) {
        setCharge(parseInteger(chargeLabel));
    }

    /**
     * The PSM's experimental mass to charge (m/z).
     */
    public Double getExpMassToCharge() {
        return getDouble(PSMColumn.EXP_MASS_TO_CHARGE.getLogicPosition());
    }

    /**
     * The PSM's experimental mass to charge (m/z).
     */
    public void setExpMassToCharge(Double expMassToCharge) {
        setValue(PSMColumn.EXP_MASS_TO_CHARGE.getLogicPosition(), expMassToCharge);
    }

    /**
     * The PSM's experimental mass to charge (m/z).
     *
     * @param expMassToChargeLabel parsed by {@link MZTabUtils#parseDouble(String)}
     */
    public void setExpMassToCharge(String expMassToChargeLabel) {
        setExpMassToCharge(parseDouble(expMassToChargeLabel));
    }

    /**
     * The PSM's calculated (theoretical) mass to charge (m/z).
     */
    public Double getCalcMassToCharge() {
        return getDouble(PSMColumn.CALC_MASS_TO_CHARGE.getLogicPosition());
    }

    /**
     * The PSM's calculated (theoretical) mass to charge (m/z).
     */
    public void setCalcMassToCharge(Double calcMassToCharge) {
        setValue(PSMColumn.CALC_MASS_TO_CHARGE.getLogicPosition(), calcMassToCharge);
    }

    /**
     * The PSM's calculated (theoretical) mass to charge (m/z).
     *
     * @param calcMassToChargeLabel parsed by {@link MZTabUtils#parseDouble(String)}
     */
    public void setCalcMassToCharge(String calcMassToChargeLabel) {
        setCalcMassToCharge(parseDouble(calcMassToChargeLabel));
    }

    /**
     * A URI pointing to the PSM's entry in the experiment it was identified in (e.g., the peptide's PRIDE entry).
     */
    public URI getURI() {
        return getURI(PSMColumn.URI.getLogicPosition());
    }

    /**
     * A URI pointing to the PSM's entry in the experiment it was identified in (e.g., the peptide's PRIDE entry).
     */
    public void setURI(URI uri) {
        setValue(PSMColumn.URI.getLogicPosition(), uri);
    }

    /**
     * A URI pointing to the PSM's entry in the experiment it was identified in (e.g., the peptide's PRIDE entry).
     *
     * @param uriLabel parsed by {@link MZTabUtils#parseURI(String)}
     */
    public void setURI(String uriLabel) {
        setURI(parseURI(uriLabel));
    }

    /**
     * Reference to spectra in a spectrum file. It is expected that spectra_ref SHOULD only be used for MS2-based
     * quantification approaches, in which retention time values cannot identify the spectra used for quantification.
     * The reference must be in the format ms_run[1-n]:{SPECTRA_REF} where SPECTRA_REF MUST follow the format defined in 5.2.
     * Multiple spectra MUST be referenced using a "|" delimited list.
     */
    public SplitList<SpectraRef> getSpectraRef() {
        return getSplitList(PSMColumn.SPECTRA_REF.getLogicPosition());
    }

    /**
     * Reference to spectra in a spectrum file. It is expected that spectra_ref SHOULD only be used for MS2-based
     * quantification approaches, in which retention time values cannot identify the spectra used for quantification.
     * The reference must be in the format ms_run[1-n]:{SPECTRA_REF} where SPECTRA_REF MUST follow the format defined in 5.2.
     * Multiple spectra MUST be referenced using a "|" delimited list.
     *
     * @see SpectraRef
     */
    public boolean addSpectraRef(SpectraRef specRef) {
        if (specRef == null) {
            return false;
        }

        SplitList<SpectraRef> specRefs = getSpectraRef();
        if (specRefs == null) {
            specRefs = new SplitList<SpectraRef>(BAR);
            setSpectraRef(specRefs);
        }

        return specRefs.add(specRef);
    }

    /**
     * Reference to spectra in a spectrum file. It is expected that spectra_ref SHOULD only be used for MS2-based
     * quantification approaches, in which retention time values cannot identify the spectra used for quantification.
     * The reference must be in the format ms_run[1-n]:{SPECTRA_REF} where SPECTRA_REF MUST follow the format defined in 5.2.
     * Multiple spectra MUST be referenced using a "|" delimited list.
     */
    public void setSpectraRef(SplitList<SpectraRef> spectraRef) {
        setValue(PSMColumn.SPECTRA_REF.getLogicPosition(), spectraRef);
    }

    /**
     * Reference to spectra in a spectrum file. It is expected that spectra_ref SHOULD only be used for MS2-based
     * quantification approaches, in which retention time values cannot identify the spectra used for quantification.
     * The reference must be in the format ms_run[1-n]:{SPECTRA_REF} where SPECTRA_REF MUST follow the format defined in 5.2.
     * Multiple spectra MUST be referenced using a "|" delimited list.
     *
     * @param spectraRefLabel parsed by {@link MZTabUtils#parseSpectraRefList(Metadata, String)}
     */
    public void setSpectraRef(String spectraRefLabel) {
        setSpectraRef(parseSpectraRefList(metadata, spectraRefLabel));
    }

    /**
     * Amino acid preceding the peptide (coming from the PSM) in the protein sequence. If unknown "null" MUST be used,
     * if the peptide is N-terminal "-" MUST be used.
     */
    public String getPre() {
        return getString(PSMColumn.PRE.getLogicPosition());
    }

    /**
     * Amino acid preceding the peptide (coming from the PSM) in the protein sequence. If unknown "null" MUST be used,
     * if the peptide is N-terminal "-" MUST be used.
     */
    public void setPre(String pre) {
        setValue(PSMColumn.PRE.getLogicPosition(), parseString(pre));
    }

    /**
     * Amino acid following the peptide (coming from the PSM) in the protein sequence. If unknown "null" MUST be used,
     * if the peptide is C-terminal "-" MUST be used.
     */
    public String getPost() {
        return getString(PSMColumn.POST.getLogicPosition());
    }

    /**
     * Amino acid following the peptide (coming from the PSM) in the protein sequence. If unknown "null" MUST be used,
     * if the peptide is C-terminal "-" MUST be used.
     */
    public void setPost(String post) {
        setValue(PSMColumn.POST.getLogicPosition(), parseString(post));
    }

    /**
     * The start position of the peptide (coming from the PSM) within the protein, counting 1 as the N-terminus of the protein.
     */
    public Integer getStart() {
        return getInteger(PSMColumn.START.getLogicPosition());
    }

    /**
     * The start position of the peptide (coming from the PSM) within the protein, counting 1 as the N-terminus of the protein.
     */
    public void setStart(Integer start) {
        setValue(PSMColumn.START.getLogicPosition(), start);
    }

    /**
     * The start position of the peptide (coming from the PSM) within the protein, counting 1 as the N-terminus of the protein.
     */
    public void setStart(String start) {
        setValue(PSMColumn.START.getLogicPosition(), parseInteger(start));
    }

    /**
     * The end position of the peptide (coming from the PSM) within the protein, counting 1 as the N-terminus of the protein.
     */
    public Integer getEnd() {
        return getInteger(PSMColumn.END.getLogicPosition());
    }

    /**
     * The end position of the peptide (coming from the PSM) within the protein, counting 1 as the N-terminus of the protein.
     */
    public void setEnd(Integer end) {
        setValue(PSMColumn.END.getLogicPosition(), end);
    }

    /**
     * The end position of the peptide (coming from the PSM) within the protein, counting 1 as the N-terminus of the protein.
     */
    public void setEnd(String end) {
        setValue(PSMColumn.END.getLogicPosition(), parseInteger(end));
    }

    /**
     * Print PSM record to a tab-split string.
     *
     * PEP  value1  value2  value3  ...
     */
    @Override
    public String toString() {
        return Section.PSM.getPrefix() + TAB + super.toString();
    }
}
