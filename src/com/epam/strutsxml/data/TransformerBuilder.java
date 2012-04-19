package com.epam.strutsxml.data;

import resources.ConfigurationManager;

import javax.xml.transform.*;
import javax.xml.transform.stream.StreamSource;


/**
 * Created by IntelliJ IDEA.
 * User: Stepanov Dmitriy
 * Date: 4/4/12
 * Time: 6:53 AM
 */
public class TransformerBuilder {
    private static final String VALIDATE_WITHOUT_ADD_XSL = "VALIDATE_WITHOUT_ADD_XSL";
    private static final TransformerBuilder ourInstance = new TransformerBuilder();
    private static final TransformerFactory transformerFactory = TransformerFactory.newInstance();
    private static Templates validateXSLT;
    private static Templates addXSLT;
    private static Templates fulAddXSLT;
    private static Templates allXSLT;


    private static final String ADD_WITHOUT_VALIDATE_XSL = "ADD_WITHOUT_VALIDATE_XSL";

    private static final String ADD_XSL = "ADD_XSL";

    private static final String ALL_XSL = "ALL_XSL";

    static {
        try {
            validateXSLT = transformerFactory.newTemplates(
                    new StreamSource(ConfigurationManager.getProperty(VALIDATE_WITHOUT_ADD_XSL)));
            addXSLT = transformerFactory.newTemplates(
                    new StreamSource(ConfigurationManager.getProperty(ADD_WITHOUT_VALIDATE_XSL)));
            fulAddXSLT = transformerFactory.newTemplates(
                    new StreamSource(ConfigurationManager.getProperty(ADD_XSL)));
            allXSLT = transformerFactory.newTemplates(
                    new StreamSource(ConfigurationManager.getProperty(ALL_XSL)));

        } catch (TransformerException e) {
            e.printStackTrace();
        }


    }


    public static TransformerBuilder getInstance() {
        return ourInstance;
    }

    public static Transformer getValTransform() throws TransformerException {
        return validateXSLT.newTransformer();
    }

    public static Transformer getAddTransform() throws TransformerConfigurationException {
        return addXSLT.newTransformer();
    }


    public static Transformer getFullAddTransform() throws TransformerConfigurationException {
        return fulAddXSLT.newTransformer();
    }

    public static Transformer getAllTransform() throws TransformerConfigurationException {
        return allXSLT.newTransformer();
    }

    private TransformerBuilder() {
    }
}
