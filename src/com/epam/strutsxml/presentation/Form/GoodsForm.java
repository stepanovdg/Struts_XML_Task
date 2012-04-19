package com.epam.strutsxml.presentation.Form;

import com.epam.strutsxml.model.Goods;
import com.epam.strutsxml.util.wrapper.Element;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by IntelliJ IDEA.
 * User: Stepanov Dmitriy
 * Date: 4/9/12
 * Time: 7:56 AM
 */
public class GoodsForm extends ActionForm {


    private Element rootElement;
    private String categoryName;
    private String subCategoryName;
    private String validateMessage = "";
    private Boolean showAdd;
    private Boolean jsCheck;
    private Goods goods = new Goods();

    public String getValidateMessage() {
        return validateMessage;
    }

    public void setValidateMessage(String validateMessage) {
        this.validateMessage = validateMessage;
    }

    public Element getRootElement() {
        return this.rootElement;
    }

    public void setRootElement(Element rootElement) {
        this.rootElement = rootElement;
    }

    public Boolean getShowAdd() {
        if (showAdd != null) {
            return showAdd;
        } else {
            return false;
        }
    }

    public void setShowAdd(Boolean showAdd) {
        this.showAdd = showAdd;
    }


    public Boolean getJsCheck() {
        return jsCheck;
    }

    public void setJsCheck(Boolean jsCheck) {
        this.jsCheck = jsCheck;
    }


    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }


    public String getSubCategoryName() {
        if (subCategoryName != null) {
            return subCategoryName;
        } else {
            return "";
        }
    }

    public void setSubCategoryName(String subCategoryName) {
        this.subCategoryName = subCategoryName;
    }

    public String getCategoryName() {
        if (categoryName != null) {
            return categoryName;
        } else {
            return "";
        }
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    @Override
    public void reset(ActionMapping mapping, HttpServletRequest request) {
        super.reset(mapping, request);
        setCategoryName(null);
        setSubCategoryName(null);
        setShowAdd(null);
    }
}
