import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "Object")
public class MyObject {

    private String value1;
    private String value2;

    @XmlAttribute (name = "value1", required = false)
    public String getValue1() {
        return value1;
    }

    public void setValue1(String value1) {
        this.value1 = value1;
    }

    @XmlAttribute (name = "value2", required = false)
    public String getValue2() {
        return value2;
    }

    public void setValue2(String value2) {
        this.value2 = value2;
    }

    public String toString() {
        return "value1 - " + value1 + ", value2 - " + value2;
    }
}