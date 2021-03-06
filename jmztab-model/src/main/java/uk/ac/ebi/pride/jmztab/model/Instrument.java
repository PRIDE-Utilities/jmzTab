package uk.ac.ebi.pride.jmztab.model;

import java.util.ArrayList;
import java.util.List;

import static uk.ac.ebi.pride.jmztab.model.MZTabConstants.NEW_LINE;
import static uk.ac.ebi.pride.jmztab.model.MetadataProperty.*;

/**
 * Define a MS instrument.
 * The name of the instrument used in the experiment. Multiple instruments are numbered 1..n
 * The instrument's source used in the experiment. Multiple instruments are numbered 1..n
 * The instrument's analyzer type used in the experiment. Multiple instruments are enumerated 1..n
 * The instrument's detector type used in the experiment. Multiple instruments are numbered 1..n
 *
 * @author qingwei
 * @since 23/05/13
 */
public class Instrument extends IndexedElement {
    private Param name;
    private Param source;
    private List<Param> analyzerList = new ArrayList<Param>();
    private Param detector;

    /**
     * Define a MS instrument.
     *
     * @param id SHOULD BE non-negative integer.
     */
    public Instrument(int id) {
        super(MetadataElement.INSTRUMENT, id);
    }

    /**
     * The name of the instrument used in the experiment. Multiple instruments are numbered 1..n.
     */
    public Param getName() {
        return name;
    }

    /**
     * The name of the instrument used in the experiment. Multiple instruments are numbered 1..n.
     */
    public void setName(Param name) {
        this.name = name;
    }

    /**
     * The instrument's source used in the experiment. Multiple instruments are numbered 1..n
     */
    public Param getSource() {
        return source;
    }

    /**
     * The instrument's source used in the experiment. Multiple instruments are numbered 1..n
     */
    public void setSource(Param source) {
        this.source = source;
    }

    /**
     * The instrument's analyzer type used in the experiment. Multiple instruments are enumerated 1..n
     */
    public List<Param> getAnalyzerList() {
        return analyzerList;
    }

    /**
     * The instrument's analyzer type used in the experiment. Multiple instruments are enumerated 1..n
     */
    public void addAnalyzer(Param analyzer) {
        this.analyzerList.add(analyzer);
    }

    /**
     * The instrument's detector type used in the experiment. Multiple instruments are numbered 1..n
     */
    public Param getDetector() {
        return detector;
    }

    /**
     * The instrument's detector type used in the experiment. Multiple instruments are numbered 1..n
     */
    public void setDetector(Param detector) {
        this.detector = detector;
    }

    /**
     * Print MS instrument into a String:
     * <ul>
     *     <li>MTD	instrument[1]-name	[MS, MS:100049, LTQ Orbitrap, ]</li>
     *     <li>MTD	instrument[1]-source	[MS, MS:1000073, ESI, ]</li>
     *     <li>MTD	instrument[1]-analyzer[1]	[MS, MS:1000291, linear ion trap, ]</li>
     *     <li>MTD	instrument[1]-detector	[MS, MS:1000253, electron multiplier, ]</li>
     * </ul>
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        if (name != null) {
            sb.append(printProperty(INSTRUMENT_NAME, name)).append(NEW_LINE);
        }
        if (source != null) {
            sb.append(printProperty(INSTRUMENT_SOURCE, source)).append(NEW_LINE);
        }
        if (analyzerList != null) {
            printList(analyzerList, INSTRUMENT_ANALYZER, sb);
        }
        if (detector != null) {
            sb.append(printProperty(INSTRUMENT_DETECTOR, detector)).append(NEW_LINE);
        }

        return sb.toString();
    }

    /**
     * When analyzer, detector, name and source are equals, the MS instrument are equal.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Instrument that = (Instrument) o;

        if (analyzerList != null ? !analyzerList.equals(that.analyzerList) : that.analyzerList != null) return false;
        if (detector != null ? !detector.equals(that.detector) : that.detector != null) return false;
        return name.equals(that.name) && (source != null ? source.equals(that.source) : that.source == null);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + (source != null ? source.hashCode() : 0);
        result = 31 * result + (analyzerList != null ? analyzerList.hashCode() : 0);
        result = 31 * result + (detector != null ? detector.hashCode() : 0);
        return result;
    }
}
