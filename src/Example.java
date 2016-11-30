import java.io.File;
import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class Example {
    public static void main(String[] args) {

        // create container with list
        MyContainer container = new MyContainer();

        // add objects
        MyObject object;

        object = new MyObject();
        object.setvalue("A");
        container.getChildren().add( object);

        object = new MyObject();
        object.setvalue("B");
        container.getChildren().add( object);

        // marshal
        String baseXml = marshal( container);

        // unmarshal
        container = unmarshal(baseXml);

        System.out.println("Container:\n" + container);


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