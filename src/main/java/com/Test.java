package com;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.apache.log4j.Logger;

import java.io.*;
import java.util.Properties;

public class Test {

    private static final Logger logger = Logger.getLogger(Test.class);

    public static void main(String[] args) {

        logger.info("Start program");
        Person person = new Person();
        ObjectMapper mapper = new ObjectMapper();
        Properties properties = new Properties();
        XmlMapper xmlMapper = new XmlMapper();

        loadProperties(properties);
        person.setName(properties.getProperty("USERNAME"));
        String currentFormat = properties.getProperty("INDEX");

        if (currentFormat.equals("json")) {
            try {
                String json = mapper.writeValueAsString(person);
                logger.info(json);
            } catch (JsonProcessingException e) {
                logger.error("Error, when convert string to json", e);
            }
        } else if (currentFormat.equals("xml")) {
            String xml;
            try {
                xml = xmlMapper.writeValueAsString(person);
                logger.info(xml);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
                logger.error("Error, when convert string to xml", e);
            }
        }
        logger.info("End program");
    }

    private static void loadProperties(Properties properties) {
        try (FileInputStream fileInputStream = new FileInputStream(new File("prop.properties"))) {
            properties.load(fileInputStream);
        } catch (IOException e) {
            logger.error("Error in method \"loadProperties()\"", e);
        }
    }
}
