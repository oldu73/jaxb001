import java.io.File;
import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class Example {
    public static void main(String[] args) {

        // create container with list
        MyContainer container = new MyContainer("Container 1");
        container.setSubContainerValue(18);

        MySubContainer mySubContainer1 = new MySubContainer("subc1");
        MySubContainer mySubContainer2 = new MySubContainer("subc2");

        container.getChildren().add(mySubContainer1);
        container.getChildren().add(mySubContainer2);

        // add objects
        MyObject object;

        object = new MyObject();
        object.setValue1("A");
        object.setValue2("A2");
        mySubContainer1.getChildren().add( object);

        object = new MyObject();
        object.setValue1("B");
        object.setValue2("BB");
        mySubContainer1.getChildren().add( object);

        object = new MyObject();
        object.setValue1("C");
        object.setValue2("CCC");
        mySubContainer2.getChildren().add( object);

        object = new MyObject();
        object.setValue1("Dex");
        object.setValue2("Dexter");
        mySubContainer2.getChildren().add( object);

        // marshal
        String baseXml = marshal( container);

        // unmarshal
        container = unmarshal(baseXml);

        System.out.print("Container, " + container);


        System.exit(0);
    }

    public static String marshal( MyContainer base) {

        File file = new File("C:\\Users\\oldu7\\Desktop\\test2.xml");

        try {

            JAXBContext jaxbContext = JAXBContext.newInstance(MyContainer.class);

            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            jaxbMarshaller.marshal(base, file);

            StringWriter stringWriter = new StringWriter();
            jaxbMarshaller.marshal(base, stringWriter);
            String xml = stringWriter.toString();

            System.out.println("XML:\n" + xml);

            return xml;

        } catch (Exception e) {
            throw new RuntimeException( e);
        }

    }

    public static MyContainer unmarshal( String xml) {

        try {

            JAXBContext jaxbContext = JAXBContext.newInstance(MyContainer.class);

            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            StringReader stringReader = new StringReader(xml);

            MyContainer container = (MyContainer) jaxbUnmarshaller.unmarshal(stringReader);

            return container;

        } catch (Exception e) {
            throw new RuntimeException( e);
        }

    }
}