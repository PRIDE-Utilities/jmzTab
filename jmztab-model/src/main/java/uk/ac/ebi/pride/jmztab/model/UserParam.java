package uk.ac.ebi.pride.jmztab.model;

/**
 * user parameters that only contain a name and a value.
 *
 * @author qingwei
 * @author jgriss
 * @since 04/02/13
 */
public class UserParam extends Param {
    public UserParam(String name, String value) {
        super(name, value);
    }

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }
}
