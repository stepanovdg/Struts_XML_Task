package com.epam.strutsxml.util.wrapper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Stepanov Dmitriy
 * Date: 4/9/12
 * Time: 8:30 AM
 */
public class Element {
    private org.jdom2.Element element;

    public Element(org.jdom2.Element rootElement) {
        this.element = rootElement;
    }

    public String getText() {
        return element.getText();
    }

    public final void setText(String text) {
        this.element.setText(text);                         //change to void
    }

    public org.jdom2.Element getElement() {
        return element;
    }

    @Override
    public boolean equals(Object ob) {
        return element.equals(ob);
    }

    @Override
    public int hashCode() {
        return element.hashCode();
    }

    public List<Attribute> getAttributes() {
        List<org.jdom2.Attribute> atrList = element.getAttributes();
        List<Attribute> atrReturn = new ArrayList<>(atrList.size());
        for (org.jdom2.Attribute atr : atrList) {
            atrReturn.add(new Attribute(atr));
        }
        return atrReturn;
    }


    @Override
    public String toString() {
        return element.toString();
    }

    @Override
    public Element clone() {
        return new Element(element.clone());
    }


    public List<Element> getChildren() {
        List<org.jdom2.Element> atrList = element.getChildren();
        List<Element> atrReturn = new ArrayList<>(atrList.size());
        for (org.jdom2.Element atr : atrList) {
            atrReturn.add(new Element(atr));
        }
        return atrReturn;
    }
}
