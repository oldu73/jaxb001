import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "Object")
public class MyObject {

    private String value;

    @XmlAttribute (name = "value", required = false)
    public String getvalue() {
        return value;
    }

    public void setvalue(String value) {
        this.value = value;
    }


    public String toString() {
        return "value=" + value;
    }
}