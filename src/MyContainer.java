import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;


@XmlRootElement(name = "Container")
//public class MyContainer extends MySubContainer {
public class MyContainer {

    private String name;
    private int containerValue;
    private ObservableList<MySubContainer> children = FXCollections.observableArrayList();

    public MyContainer() {
        this.name = null;
    }
    public MyContainer(String name) {
        this.name = name;
    }

    @XmlAttribute(name = "name", required = false)
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @XmlAttribute(name = "containerValue", required = false)
    public int getSubContainerValue() {
        return containerValue;
    }
    public void setSubContainerValue(int subContainerValue) {
        this.containerValue = subContainerValue;
    }

    @XmlElements({ @XmlElement(name = "SubContainer", type = MySubContainer.class) })
    public List<MySubContainer> getChildren() {
        return children;
    }


    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append("name: " + name + " value: " + containerValue + "\n");

        for (MySubContainer node : children) {
            sb.append("  SubContainer, " + node.toString() + "\n");
        }

        //sb.append("\n\nCoucou ;-) ..");

        return sb.toString();

    }
}
