import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import java.util.List;


public class MySubContainer extends MyObject {

    private String name;
    private int subContainerValue;
    private ObservableList<MyObject> children = FXCollections.observableArrayList();

    public MySubContainer() {
        this.name = null;
    }
    public MySubContainer(String name) {
        this.name = name;
    }

    @XmlAttribute(name = "name", required = false)
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @XmlAttribute(name = "subContainerValue", required = false)
    public int getSubContainerValue() {
        return subContainerValue;
    }
    public void setSubContainerValue(int subContainerValue) {
        this.subContainerValue = subContainerValue;
    }

    @XmlElements({ @XmlElement(name = "Object", type = MyObject.class) })
    public List<MyObject> getChildren() {
        return children;
    }


    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append("name: " + name + " value: " + subContainerValue + "\n");
        sb.append("    Object:");

        for (MyObject node : children) {
            sb.append("\n");
            sb.append("      " + node.toString());
        }

        return sb.toString();

    }
}