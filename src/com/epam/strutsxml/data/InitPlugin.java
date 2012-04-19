package com.epam.strutsxml.data;

import org.apache.struts.action.ActionServlet;
import org.apache.struts.action.PlugIn;
import org.apache.struts.config.ModuleConfig;
import resources.ConfigurationManager;

import javax.servlet.ServletException;

/**
 * Created by IntelliJ IDEA.
 * User: Stepanov Dmitriy
 * Date: 4/18/12
 * Time: 11:48 AM
 */
public class InitPlugin implements PlugIn {
    private static JDOMController jdomController = JDOMController.getInstance();

    @Override
    public void destroy() {
        jdomController.backUp(ConfigurationManager.getProperty("GOODS_XML"));
    }

    @Override
    public void init(ActionServlet actionServlet, ModuleConfig moduleConfig) throws ServletException {
        jdomController.parse(ConfigurationManager.getProperty("GOODS_XML"));
    }
}
