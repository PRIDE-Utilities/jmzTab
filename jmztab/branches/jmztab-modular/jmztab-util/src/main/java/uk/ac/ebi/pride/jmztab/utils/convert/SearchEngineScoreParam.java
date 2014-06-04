package uk.ac.ebi.pride.jmztab.utils.convert;

import uk.ac.ebi.pride.jmztab.model.CVParam;

/**
 * User: qingwei
 * Date: 25/11/13
 */
public enum SearchEngineScoreParam {

    //TODO: Map synonyms and sort
    // coming from children terms of MS:1001153 (search engine specific score)
    SEARCH_ENGINE_SPECIFIC_SCORE(SearchEngineParam.ANALYSIS_SOFTWARE, "MS", "MS:1001153", "search engine specific score", null),

    ASCORE_ASCORE(SearchEngineParam.ASCORE, "MS", "MS:1001985", "Ascore:Ascore", null),
    BYONIC__PEPTIDE_ABSLOGPROB(SearchEngineParam.BYONIC, "MS", "MS:1002309", "Byonic: Peptide AbsLogProb", null),
    BYONIC__PEPTIDE_ABSLOGPROB2D(SearchEngineParam.BYONIC, "MS", "MS:1002311", "Byonic: Peptide AbsLogProb2D", null),
    BYONIC__PROTEIN_ABSLOGPROB(SearchEngineParam.BYONIC, "MS", "MS:1002310", "Byonic: Protein AbsLogProb", null),
    BYONIC_BEST_LOGPROB(SearchEngineParam.BYONIC, "MS", "MS:1002268", "Byonic:Best LogProb", null),
    BYONIC_BEST_SCORE(SearchEngineParam.BYONIC, "MS", "MS:1002269", "Byonic:Best Score", null),
    BYONIC_DELTA_SCORE(SearchEngineParam.BYONIC, "MS", "MS:1002263", "Byonic:Delta Score", null),
    BYONIC_DELTAMOD_SCORE(SearchEngineParam.BYONIC, "MS", "MS:1002264", "Byonic:DeltaMod Score", null),
    BYONIC_PEP(SearchEngineParam.BYONIC, "MS", "MS:1002265", "Byonic:PEP", null),
    BYONIC_PEPTIDE_LOGPROB(SearchEngineParam.BYONIC, "MS", "MS:1002266", "Byonic:Peptide LogProb", null),
    BYONIC_PROTEIN_LOGPROB(SearchEngineParam.BYONIC, "MS", "MS:1002267", "Byonic:Protein LogProb", null),
    BYONIC_SCORE(SearchEngineParam.BYONIC, "MS", "MS:1002262", "Byonic:Score", null),
    COMBINED_FDRSCORE(SearchEngineParam.ANALYSIS_SOFTWARE, "MS", "MS:1002125", "combined FDRScore", null),
    COMET_DELTACN(SearchEngineParam.COMET, "MS", "MS:1002253", "Comet:deltacn", null),
    COMET_DELTACNSTAR(SearchEngineParam.COMET, "MS", "MS:1002254", "Comet:deltacnstar", null),
    COMET_EXPECTATION_VALUE(SearchEngineParam.COMET, "MS", "MS:1002257", "Comet:expectation value", null),
    COMET_MATCHED_IONS(SearchEngineParam.COMET, "MS", "MS:1002258", "Comet:matched ions", null),
    COMET_SPRANK(SearchEngineParam.COMET, "MS", "MS:1002256", "Comet:sprank", null),
    COMET_SPSCORE(SearchEngineParam.COMET, "MS", "MS:1002255", "Comet:spscore", null),
    COMET_TOTAL_IONS(SearchEngineParam.COMET, "MS", "MS:1002259", "Comet:total ions", null),
    COMET_XCORR(SearchEngineParam.COMET, "MS", "MS:1002252", "Comet:xcorr", null),
    DEBUNKER_SCORE(SearchEngineParam.DEBUNKER, "MS", "MS:1001974", "DeBunker:score", null),
    FDRSCORE(SearchEngineParam.ANALYSIS_SOFTWARE, "MS", "MS:1001874", "FDRScore", null),
    HIGHER_SCORE_BETTER(SearchEngineParam.ANALYSIS_SOFTWARE, "MS", "MS:1002108", "higher score better", null),
    IDENTITYE_SCORE(SearchEngineParam.ANALYSIS_SOFTWARE, "MS", "MS:1001569", "IdentityE Score", null),
    LOWER_SCORE_BETTER(SearchEngineParam.ANALYSIS_SOFTWARE, "MS", "MS:1002109", "lower score better", null),
    MASCOT_EXPECTATION_VALUE(SearchEngineParam.MASCOT, "MS", "MS:1001172", "Mascot:expectation value", null),
    MASCOT_HOMOLOGY_THRESHOLD(SearchEngineParam.MASCOT, "MS", "MS:1001370", "Mascot:homology threshold", null),
    MASCOT_IDENTITY_THRESHOLD(SearchEngineParam.MASCOT, "MS", "MS:1001371", "Mascot:identity threshold", null),
    MASCOT_MATCHED_IONS(SearchEngineParam.MASCOT, "MS", "MS:1001173", "Mascot:matched ions", null),
    MASCOT_PTM_SITE_ASSIGNMENT_CONFIDENCE(SearchEngineParam.MASCOT, "MS", "MS:1002012", "Mascot:PTM site assignment confidence", null),
    MASCOT_SCORE(SearchEngineParam.MASCOT, "MS", "MS:1001171", "Mascot:score", null),
    MASCOT_TOTAL_IONS(SearchEngineParam.MASCOT, "MS", "MS:1001174", "Mascot:total ions", null),
    MAXQUANT_P_SITE_LOCALIZATION_PROBABILITY(SearchEngineParam.MAXQUANT, "MS", "MS:1001982", "MaxQuant:P-site localization probability", null),
    MAXQUANT_PHOSPHO__STY__PROBABILITIES(SearchEngineParam.MAXQUANT, "MS", "MS:1001980", "MaxQuant:Phospho (STY) Probabilities", null),
    MAXQUANT_PHOSPHO__STY__SCORE_DIFFS(SearchEngineParam.MAXQUANT, "MS", "MS:1001981", "MaxQuant:Phospho (STY) Score Diffs", null),
    MAXQUANT_PTM_DELTA_SCORE(SearchEngineParam.MAXQUANT, "MS", "MS:1001983", "MaxQuant:PTM Delta Score", null),
    MAXQUANT_PTM_SCORE(SearchEngineParam.MAXQUANT, "MS", "MS:1001979", "MaxQuant:PTM Score", null),
    MRMAID_PEPTIDE_SCORE(SearchEngineParam.ANALYSIS_SOFTWARE, "MS", "MS:1002221", "MRMaid:peptide score", null),
    MS_GF_DENOVOSCORE(SearchEngineParam.MS_GF, "MS", "MS:1002050", "MS-GF:DeNovoScore", null),
    MS_GF_ENERGY(SearchEngineParam.MS_GF, "MS", "MS:1002051", "MS-GF:Energy", null),
    MS_GF_EVALUE(SearchEngineParam.MS_GF, "MS", "MS:1002053", "MS-GF:EValue", null),
    MS_GF_PEP(SearchEngineParam.MS_GF, "MS", "MS:1002056", "MS-GF:PEP", null),
    MS_GF_PEPQVALUE(SearchEngineParam.MS_GF, "MS", "MS:1002055", "MS-GF:PepQValue", null),
    MS_GF_QVALUE(SearchEngineParam.MS_GF, "MS", "MS:1002054", "MS-GF:QValue", null),
    MS_GF_RAWSCORE(SearchEngineParam.MS_GF, "MS", "MS:1002049", "MS-GF:RawScore", null),
    MS_GF_SPECEVALUE(SearchEngineParam.MS_GF, "MS", "MS:1002052", "MS-GF:SpecEValue", null),
    MSFIT_MOWSE_SCORE(SearchEngineParam.ANALYSIS_SOFTWARE, "MS", "MS:1001501", "MSFit:Mowse score", null),
    MSQUANT_PTM_SCORE(SearchEngineParam.MSQUANT, "MS", "MS:1001978", "MSQuant:PTM-score", null),
    MYRIMATCH_MVH(SearchEngineParam.MYRIMATCH, "MS", "MS:1001589", "MyriMatch:MVH", null),
    MYRIMATCH_MZFIDELITY(SearchEngineParam.MYRIMATCH, "MS", "MS:1001590", "MyriMatch:mzFidelity", null),
    MYRIMATCH_NMATCHS(SearchEngineParam.MYRIMATCH, "MS", "MS:1001121", "number of matched peaks", null),
    MYRIMATCH_NOMATCHS(SearchEngineParam.MYRIMATCH, "MS", "MS:1001362", "number of unmatched peaks", null),
    OMSSA_EVALUE(SearchEngineParam.OMSSA, "MS", "MS:1001328", "OMSSA:evalue", null),
    OMSSA_PVALUE(SearchEngineParam.OMSSA, "MS", "MS:1001329", "OMSSA:pvalue", null),
    PARAGON_CONFIDENCE(SearchEngineParam.ANALYSIS_SOFTWARE, "MS", "MS:1001167", "Paragon:confidence", null),
    PARAGON_CONTRIB(SearchEngineParam.ANALYSIS_SOFTWARE, "MS", "MS:1001170", "Paragon:contrib", null),
    PARAGON_EXPRESSION_CHANGE_P_VALUE(SearchEngineParam.ANALYSIS_SOFTWARE, "MS", "MS:1001169", "Paragon:expression change p-value", null),
    PARAGON_EXPRESSION_ERROR_FACTOR(SearchEngineParam.ANALYSIS_SOFTWARE, "MS", "MS:1001168", "Paragon:expression error factor", null),
    PARAGON_SCORE(SearchEngineParam.ANALYSIS_SOFTWARE, "MS", "MS:1001166", "Paragon:score", null),
    PARAGON_TOTAL_PROTSCORE(SearchEngineParam.ANALYSIS_SOFTWARE, "MS", "MS:1001165", "Paragon:total protscore", null),
    PARAGON_UNUSED_PROTSCORE(SearchEngineParam.ANALYSIS_SOFTWARE, "MS", "MS:1001164", "Paragon:unused protscore", null),
    PEAKS_PEPTIDESCORE(SearchEngineParam.PEAKS_STUDIO, "MS", "MS:1001950", "PEAKS:peptideScore", null),
    PEAKS_PROTEINSCORE(SearchEngineParam.PEAKS_STUDIO, "MS", "MS:1001951", "PEAKS:proteinScore", null),
    PEPTIDESHAKER_PSM_SCORE(SearchEngineParam.ANALYSIS_SOFTWARE,"MS", "MS:1002466", "PeptideShaker: PSM Score", null),
    PEPTIDESHAKER_PSM_CONFIDENCE(SearchEngineParam.ANALYSIS_SOFTWARE,"MS", "MS:1002467", "PeptideShaker: PSM Confidence", null),
    PEPTIDESHAKER_PROTEIN_SCORE(SearchEngineParam.ANALYSIS_SOFTWARE,"MS", "MS:1002470", "PeptideShaker: Protein Score", null),
    PEPTIDESHAKER_PROTEIN_CONFIDENCE(SearchEngineParam.ANALYSIS_SOFTWARE,"MS", "MS:1002471", "PeptideShake: Protein Confidence", null),
    PERCOLATOR_PEP(SearchEngineParam.PERCOLATOR, "MS", "MS:1001493", "percolator:PEP", null),
    PERCOLATOR_Q_VALUE(SearchEngineParam.PERCOLATOR, "MS", "MS:1001491", "percolator:Q value", null),
    PERCOLATOR_SCORE(SearchEngineParam.PERCOLATOR, "MS", "MS:1001492", "percolator:score", null),
    PHENYX_AC(SearchEngineParam.PHENYX, "MS", "MS:1001388", "Phenyx:AC", null),
    PHENYX_AUTO(SearchEngineParam.PHENYX, "MS", "MS:1001393", "Phenyx:Auto", null),
    PHENYX_ID(SearchEngineParam.PHENYX, "MS", "MS:1001389", "Phenyx:ID", null),
    PHENYX_MODIF(SearchEngineParam.PHENYX, "MS", "MS:1001398", "Phenyx:Modif", null),
    PHENYX_NUMBEROFMC(SearchEngineParam.PHENYX, "MS", "MS:1001397", "Phenyx:NumberOfMC", null),
    PHENYX_PEPPVALUE(SearchEngineParam.PHENYX, "MS", "MS:1001396", "Phenyx:PepPvalue", null),
    PHENYX_PEPTIDES1(SearchEngineParam.PHENYX, "MS", "MS:1001391", "Phenyx:Peptides1", null),
    PHENYX_PEPTIDES2(SearchEngineParam.PHENYX, "MS", "MS:1001392", "Phenyx:Peptides2", null),
    PHENYX_PEPZSCORE(SearchEngineParam.PHENYX, "MS", "MS:1001395", "Phenyx:Pepzscore", null),
    PHENYX_SCORE(SearchEngineParam.PHENYX, "MS", "MS:1001390", "Phenyx:Score", null),
    PHENYX_USER(SearchEngineParam.PHENYX, "MS", "MS:1001394", "Phenyx:User", null),
    PROFOUND_CLUSTER(SearchEngineParam.ANALYSIS_SOFTWARE, "MS", "MS:1001499", "Profound:Cluster", null),
    PROFOUND_CLUSTERRANK(SearchEngineParam.ANALYSIS_SOFTWARE, "MS", "MS:1001500", "Profound:ClusterRank", null),
    PROFOUND_Z_VALUE(SearchEngineParam.ANALYSIS_SOFTWARE, "MS", "MS:1001498", "Profound:z value", null),
    PROTEINEXTRACTOR_SCORE(SearchEngineParam.PROTEINEXTRACTOR, "MS", "MS:1001507", "ProteinExtractor:Score", null),
    PROTEINLYNX_LADDER_SCORE(SearchEngineParam.PROTEINLYNX_GLOBAL_SERVER, "MS", "MS:1001571", "ProteinLynx:Ladder Score", null),
    PROTEINLYNX_LOG_LIKELIHOOD(SearchEngineParam.PROTEINLYNX_GLOBAL_SERVER, "MS", "MS:1001570", "ProteinLynx:Log Likelihood", null),
    PROTEINPROSPECTOR_EXPECTATION_VALUE(SearchEngineParam.PROTEINPROSPECTOR, "MS", "MS:1002045", "ProteinProspector:expectation value", null),
    PROTEINPROSPECTOR_SCORE(SearchEngineParam.PROTEINPROSPECTOR, "MS", "MS:1002044", "ProteinProspector:score", null),
    PROTEINSCAPE_INTENSITYCOVERAGE(SearchEngineParam.PROTEINSCAPE, "MS", "MS:1001505", "ProteinScape:IntensityCoverage", null),
    PROTEINSCAPE_PFFSOLVEREXP(SearchEngineParam.PROTEINSCAPE, "MS", "MS:1001503", "ProteinScape:PFFSolverExp", null),
    PROTEINSCAPE_PFFSOLVERSCORE(SearchEngineParam.PROTEINSCAPE, "MS", "MS:1001504", "ProteinScape:PFFSolverScore", null),
    PROTEINSCAPE_PROFOUNDPROBABILITY(SearchEngineParam.PROTEINSCAPE, "MS", "MS:1001497", "ProteinScape:ProfoundProbability", null),
    PROTEINSCAPE_SEARCHEVENTID(SearchEngineParam.PROTEINSCAPE, "MS", "MS:1001496", "ProteinScape:SearchEventId", null),
    PROTEINSCAPE_SEARCHRESULTID(SearchEngineParam.PROTEINSCAPE, "MS", "MS:1001495", "ProteinScape:SearchResultId", null),
    PROTEINSCAPE_SEQUESTMETASCORE(SearchEngineParam.PROTEINSCAPE, "MS", "MS:1001506", "ProteinScape:SequestMetaScore", null),
    SCAFFOLD_PEPTIDE_PROBABILITY(SearchEngineParam.SCAFFOLD, "MS", "MS:1001568", "Scaffold:Peptide Probability", null),
    SCAFFOLD_PROTEIN_PROBABILITY(SearchEngineParam.SCAFFOLD, "MS", "MS:1001579", "Scaffold:Protein Probability", null),
    SEQUEST_CONSENSUS_SCORE(SearchEngineParam.SEQUEST, "MS", "MS:1001163", "SEQUEST:consensus score", null),
    SEQUEST_DELTACN(SearchEngineParam.SEQUEST, "MS", "MS:1001156", "SEQUEST:deltacn", null),
    SEQUEST_DELTACNSTAR(SearchEngineParam.SEQUEST, "MS", "MS:1002250", "SEQUEST:deltacnstar", null),
    SEQUEST_EXPECTATION_VALUE(SearchEngineParam.SEQUEST, "MS", "MS:1001159", "SEQUEST:expectation value", null),
    SEQUEST_MATCHED_IONS(SearchEngineParam.SEQUEST, "MS", "MS:1001161", "SEQUEST:matched ions", null),
    SEQUEST_PEPTIDEIDNUMBER(SearchEngineParam.SEQUEST, "MS", "MS:1001219", "SEQUEST:PeptideIdnumber", null),
    SEQUEST_PEPTIDENUMBER(SearchEngineParam.SEQUEST, "MS", "MS:1001218", "SEQUEST:PeptideNumber", null),
    SEQUEST_PEPTIDERANKSP(SearchEngineParam.SEQUEST, "MS", "MS:1001217", "SEQUEST:PeptideRankSp", null),
    SEQUEST_PEPTIDESP(SearchEngineParam.SEQUEST, "MS", "MS:1001215", "SEQUEST:PeptideSp", null),
    SEQUEST_PROBABILITY(SearchEngineParam.SEQUEST, "MS", "MS:1001154", "SEQUEST:probability", null),
    SEQUEST_SEQUENCES(SearchEngineParam.SEQUEST, "MS", "MS:1001372", "SEQUEST:Sequences", null),
    SEQUEST_SF(SearchEngineParam.SEQUEST, "MS", "MS:1001160", "SEQUEST:sf", null),
    SEQUEST_SP(SearchEngineParam.SEQUEST, "MS", "MS:1001157", "SEQUEST:sp", null),
    SEQUEST_SPRANK(SearchEngineParam.SEQUEST, "MS", "MS:1002249", "SEQUEST:sprank", null),
    SEQUEST_SPSCORE(SearchEngineParam.SEQUEST, "MS", "MS:1002248", "SEQUEST:spscore", null),
    SEQUEST_SUM(SearchEngineParam.SEQUEST, "MS", "MS:1001374", "SEQUEST:Sum", null),
    SEQUEST_TIC(SearchEngineParam.SEQUEST, "MS", "MS:1001373", "SEQUEST:TIC", null),
    SEQUEST_TOTAL_IONS(SearchEngineParam.SEQUEST, "MS", "MS:1001162", "SEQUEST:total ions", null),
    SEQUEST_UNIQ(SearchEngineParam.SEQUEST, "MS", "MS:1001158", "SEQUEST:Uniq", null),
    SEQUEST_XCORR(SearchEngineParam.SEQUEST, "MS", "MS:1001155", "SEQUEST:xcorr", null),
    SONAR_SCORE(SearchEngineParam.ANALYSIS_SOFTWARE, "MS", "MS:1001502", "Sonar:Score", null),
    SPECTRAST_DELTA(SearchEngineParam.SPECTRAST, "MS", "MS:1001420", "SpectraST:delta", null),
    SPECTRAST_DISCRIMINANT_SCORE_F(SearchEngineParam.SPECTRAST, "MS", "MS:1001419", "SpectraST:discriminant score F", null),
    SPECTRAST_DOT_BIAS(SearchEngineParam.SPECTRAST, "MS", "MS:1001418", "SpectraST:dot_bias", null),
    SPECTRAST_DOT(SearchEngineParam.SPECTRAST, "MS", "MS:1001417", "SpectraST:dot", null),
    SPECTRUMMILL_DISCRIMINANT_SCORE(SearchEngineParam.SPECTRUM_MILL_FOR_MASSHUNTER_WORKSTATION, "MS", "MS:1001580", "SpectrumMill:Discriminant Score", null),
    SPECTRUMMILL_SCORE(SearchEngineParam.SPECTRUM_MILL_FOR_MASSHUNTER_WORKSTATION, "MS", "MS:1001572", "SpectrumMill:Score", null),
    SPECTRUMMILL_SPI(SearchEngineParam.SPECTRUM_MILL_FOR_MASSHUNTER_WORKSTATION, "MS", "MS:1001573", "SpectrumMill:SPI", null),
    SQID_DELTASCORE(SearchEngineParam.SQID, "MS", "MS:1001888", "SQID:deltaScore", null),
    SQID_PROTEIN_SCORE(SearchEngineParam.SQID, "MS", "MS:1001889", "SQID:protein score", null),
    SQID_SCORE(SearchEngineParam.SQID, "MS", "MS:1001887", "SQID:score", null),
    X_TANDEM_EXPECT(SearchEngineParam.X_TANDEM, "MS", "MS:1001330", "X!Tandem:expect", null),
    X_TANDEM_HYPERSCORE(SearchEngineParam.X_TANDEM, "MS", "MS:1001331", "X!Tandem:hyperscore", null),
    ZCORE_PROBSCORE(SearchEngineParam.ANALYSIS_SOFTWARE, "MS", "MS:1001952", "ZCore:probScore", null),

    // PRIDE Ontology: children of PRIDE:0000049 (Peptide search engine output parameter)
    PRIDE_MASCOT_EXPECT_VALUE(SearchEngineParam.MASCOT, "PRIDE", "PRIDE:0000212", "Mascot expect value", null),
    PRIDE_MASCOT_SCORE(SearchEngineParam.MASCOT, "PRIDE", "PRIDE:0000069", "Mascot score", null),
    PRIDE_OMSSA_E_VALUE(SearchEngineParam.OMSSA, "PRIDE", "PRIDE:0000185", "OMSSA E-value", null),
    PRIDE_OMSSA_P_VALUE(SearchEngineParam.OMSSA, "PRIDE", "PRIDE:0000186", "OMSSA P-value", null),
    PRIDE_PEPTIDE_PROPHET_DISCRIMINANT_SCORE(SearchEngineParam.ANALYSIS_SOFTWARE, "PRIDE", "PRIDE:0000138", "Discriminant score", null),
    PRIDE_PEPTIDE_PROPHET_PROBABILITY(SearchEngineParam.ANALYSIS_SOFTWARE, "PRIDE", "PRIDE:0000099", "PeptideProphet probability score", null),
    PRIDE_SEQUEST_CN(SearchEngineParam.SEQUEST, "PRIDE", "PRIDE:0000052", "Cn", null),
    PRIDE_SEQUEST_DELTA_CN(SearchEngineParam.SEQUEST, "PRIDE", "PRIDE:0000012", "Delta Cn", null),
    PRIDE_SEQUEST_SCORE(SearchEngineParam.SEQUEST,"PRIDE", "PRIDE:0000053", "Sequest score", null),
    PRIDE_SPECTRUM_MILL_PEPTIDE_SCORE(SearchEngineParam.SPECTRUM_MILL_FOR_MASSHUNTER_WORKSTATION, "PRIDE", "PRIDE:0000177", "Spectrum Mill peptide score", null),
    PRIDE_X_CORRELATION(SearchEngineParam.SEQUEST ,"PRIDE", "PRIDE:0000013", "X correlation", null),
    PRIDE_X_TANDEM_HYPERSCORE(SearchEngineParam.X_TANDEM, "PRIDE", "PRIDE:0000176", "X!Tandem Hyperscore", null),
    PRIDE_XTANDEM_EXPECTANCY_SCORE(SearchEngineParam.X_TANDEM, "PRIDE", "PRIDE:0000183", "X|Tandem expectancy score", null),
    PRIDE_XTANDEM_ZSCORE(SearchEngineParam.X_TANDEM, "PRIDE", "PRIDE:0000182", "X|Tandem Z score", null);

    private SearchEngineParam searchEngineParam;
    private String cvLabel;
    private String accession;
    private String name;
    private String score;

    private SearchEngineScoreParam(SearchEngineParam searchEngineParam, String cvLabel, String accession, String name, String score) {
        this.cvLabel = cvLabel;
        this.accession = accession;
        this.name = name;
        this.score = score;
        this.searchEngineParam = searchEngineParam;
    }

    public CVParam toCVParam(String score) {
        return new CVParam(cvLabel, accession, name, score);
    }

    public static SearchEngineScoreParam getSearchEngineScoreParamByName(String searchEngineName) {
        SearchEngineParam searchEngineParam = SearchEngineParam.findParamByName(searchEngineName);

        if (SearchEngineParam.MASCOT.equals(searchEngineParam)) {
            return SearchEngineScoreParam.MASCOT_SCORE;
        } else if (SearchEngineParam.OMSSA.equals(searchEngineParam)) {
            return SearchEngineScoreParam.OMSSA_EVALUE;
        } else if (SearchEngineParam.SEQUEST.equals(searchEngineParam)) {
            return SearchEngineScoreParam.SEQUEST_CONSENSUS_SCORE;
        } else if (SearchEngineParam.SPECTRUM_MILL_FOR_MASSHUNTER_WORKSTATION.equals(searchEngineParam)) {
            return SearchEngineScoreParam.SPECTRUMMILL_SCORE;
        } else if (SearchEngineParam.X_TANDEM.equals(searchEngineParam)) {
            return SearchEngineScoreParam.X_TANDEM_HYPERSCORE;
        } else if (SearchEngineParam.ASCORE.equals(searchEngineParam)) {
            return SearchEngineScoreParam.ASCORE_ASCORE;
        } else if (SearchEngineParam.BYONIC.equals(searchEngineParam)) {
            return SearchEngineScoreParam.BYONIC_BEST_SCORE;
        } else if (SearchEngineParam.PERCOLATOR.equals(searchEngineParam)) {
            return SearchEngineScoreParam.PERCOLATOR_SCORE;
        }

        if (searchEngineParam != null) {
            return SearchEngineScoreParam.SEARCH_ENGINE_SPECIFIC_SCORE;
        }

        return null;
    }

    public static SearchEngineScoreParam getSearchEngineScoreParamByAccession(String accession) {
        for (SearchEngineScoreParam scoreParam : SearchEngineScoreParam.values()) {
            if (scoreParam.accession.equalsIgnoreCase(accession)) {
                return scoreParam;
            }
        }

        return null;
    }

    public SearchEngineParam getSearchEngineParam() {
        return searchEngineParam;
    }
}
