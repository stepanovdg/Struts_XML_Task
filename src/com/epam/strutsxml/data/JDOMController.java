package com.epam.strutsxml.data;

import com.epam.strutsxml.model.Goods;
import com.epam.strutsxml.util.wrapper.Element;
import com.sun.xml.internal.ws.util.ByteArrayBuffer;
import org.jdom2.Document;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.XMLOutputter;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicReference;

/**
 * Created by IntelliJ IDEA.
 * User: Stepanov Dmitriy
 * Date: 4/11/12
 * Time: 7:51 AM
 */
public class JDOMController {
    private static final String CATEGORY_NAME = "categoryName";
    private static final String SUB_CATEGORY_NAME = "subCategoryName";
    private static final String UNIT_NAME = "unitName";
    private static final String UNIT_PRODUCER = "unitProducer";
    private static final String UNIT_MODEL = "unitModel";
    private static final String UNIT_DATE = "unitDate";
    private static final String UNIT_COLOR = "unitColor";
    private static final String UNIT_STOCK = "unitStock";
    private static final String UNIT_PRICE = "unitPrice";

    private static JDOMController ourInstance = new JDOMController();
    private static SAXBuilder parser = new SAXBuilder();
    private AtomicReference<Element> element = new AtomicReference<>();
    private String currentPath;


    private JDOMController() {
        TransformerBuilder.getInstance();
    }

    public static JDOMController getInstance() {
        return ourInstance;
    }

    public void parse(String message) {
        currentPath = message;
        try {
            Document document = parser.build(message);
            org.jdom2.Element rootElement = document.getRootElement();
            element.set(new Element(rootElement));
        } catch (JDOMException | IOException e) {
            e.printStackTrace();
        }
    }

    public void save(Goods goods) {
        Transformer transformer = null;
        try {
            transformer = TransformerBuilder.getAddTransform();
            settingParameters(goods, transformer);
            ByteArrayBuffer buff = new ByteArrayBuffer();
            ByteArrayBuffer expect = new ByteArrayBuffer();
            new XMLOutputter().output(element.get().getElement(), expect);
            StreamSource source = new StreamSource(expect.newInputStream());
            StreamResult result = new StreamResult(buff);
            transformer.transform(source, result);
            element.set(new Element(parser.build(buff.newInputStream()).getRootElement()));
        } catch (TransformerException | IOException | JDOMException e) {
            e.printStackTrace();
        }
    }

    private void settingParameters(Goods goods, Transformer transformer) {
        transformer.setParameter(CATEGORY_NAME, goods.getCategory());
        transformer.setParameter(SUB_CATEGORY_NAME, goods.getSubCategory());
        transformer.setParameter(UNIT_NAME, goods.getUnit());
        transformer.setParameter(UNIT_PRODUCER, goods.getProvider());
        transformer.setParameter(UNIT_MODEL, goods.getModel());
        transformer.setParameter(UNIT_DATE, goods.getDateOfIssue());
        transformer.setParameter(UNIT_COLOR, goods.getColor());
        transformer.setParameter(UNIT_STOCK, Boolean.toString(goods.getStock()));
        transformer.setParameter(UNIT_PRICE, goods.getPrice().toString());

    }

    public void save(Element rootElement) {
        element.set(rootElement);
    }

    public void backUp(String goods_xml) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(goods_xml);
            new XMLOutputter().output(element.get().getElement(), fileOutputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void backUp() {
        backUp(currentPath);
    }

    public Element getElement() {
        return element.get();
    }
}
