package com.app.execution.environment;

import com.sun.org.apache.xerces.internal.impl.PropertyManager;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Properties;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.OutputStream;
import java.io.InputStream;
import java.nio.file.Path;

public class ManageProperties {

    public static void main(String[] args) {
        sysInfo();
//        props();
//        loadProps();
//        storePropsAsXml();
//        loadPropsFromXML();
//        loadPropsFromClassResources();
    }

    static public void sysInfo() {
        System.out.println(System.getProperty("user.name"));
        System.out.println(System.getProperty("user.home"));
        System.out.println(System.getProperty("os.arch"));
        System.out.println(System.getProperty("java.vendor"));
        System.out.println(System.getenv().get("SystemRoot"));
        System.out.println(System.getenv().get("COMPUTERNAME"));
    }

    static public void props() {
        Properties props = new Properties();
        props.setProperty("displayName", "Monteiro");
        String name = props.getProperty("displayName");
        System.out.println(name);
        System.out.println(props.getProperty("someProp"));

        try(BufferedWriter bw = Files.newBufferedWriter(Paths.get("xyz.properties"))) {
            props.store(bw, "My Comment");
        } catch(IOException e) {
            System.out.println(e.getClass().getSimpleName() + " - " + e.getMessage());
        }
    }

    static public void loadProps() {
        Properties props = new Properties();
        try(BufferedReader br = Files.newBufferedReader(Paths.get("myapp.properties"))) {
            props.load(br);
            String val1 = props.getProperty("val1");
            System.out.println(val1);
            System.out.println(props.getProperty("val2"));
            System.out.println(props.getProperty("val3"));
            System.out.println(props.getProperty("val4"));
        } catch(IOException e) {
            System.out.println(e.getClass().getSimpleName() + " - " + e.getMessage());
        }
    }

    static public void storePropsAsXml() {
        Properties props = new Properties();
        props.setProperty("displayName", "Monteiro");
        String name = props.getProperty("displayName");
        System.out.println(name);

        try(OutputStream bw = Files.newOutputStream(Paths.get("xyz.properties.xml"))) {
            props.storeToXML(bw, "My Comment");
        } catch(IOException e) {
            System.out.println(e.getClass().getSimpleName() + " - " + e.getMessage());
        }
    }

    static public void loadPropsFromXML() {
        Properties props = new Properties();
        try(InputStream br = Files.newInputStream(Paths.get("xyz.properties.xml"))) {
            props.loadFromXML(br);
            String val1 = props.getProperty("displayName");
            System.out.println(val1);
        } catch(IOException e) {
            System.out.println(e.getClass().getSimpleName() + " - " + e.getMessage());
        }
    }

    static public void loadPropsFromClassResources() {
        try(InputStream is = ManageProperties.class.getResourceAsStream("mydefaultvalues.xml")) {
            Properties props = new Properties();
            props.loadFromXML(is);

            Properties userProp = new Properties(props);
            loadPropsUserProps(userProp);

            System.out.println(userProp.getProperty("displayName"));
        } catch(IOException e) {
            System.out.println(e.getClass().getSimpleName() + " - " + e.getMessage());
        }
    }

    static public Properties loadPropsUserProps(Properties props) throws IOException {
        Path userFile = Paths.get("xyz.properties.xml");
        if(Files.exists(userFile)) {
            InputStream is = Files.newInputStream(userFile);
            props.loadFromXML(is);
            return props;
        }
        return null;
    }
}
