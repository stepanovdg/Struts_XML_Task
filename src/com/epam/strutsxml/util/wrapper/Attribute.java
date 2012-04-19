package com.epam.strutsxml.util.wrapper;

/**
 * Created by IntelliJ IDEA.
 * User: Stepanov Dmitriy
 * Date: 4/11/12
 * Time: 6:10 AM
 */
public class Attribute {
    private org.jdom2.Attribute attribute;

    public Attribute(org.jdom2.Attribute attribute) {
        this.attribute = attribute;
    }


    public String getValue() {
        return attribute.getValue();
    }

    public void setValue(String value) {
        this.attribute.setValue(value);
    }

    @Override
    public String toString() {
        return attribute.toString();
    }

    @Override
    public Attribute clone() {
        return new Attribute(attribute.clone());
    }


}
