package com.epam.strutsxml.presentation.Action;

import com.epam.strutsxml.data.JDOMController;
import com.epam.strutsxml.data.Validator;
import com.epam.strutsxml.model.Goods;
import com.epam.strutsxml.presentation.Form.GoodsForm;
import com.epam.strutsxml.util.wrapper.Element;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.LookupDispatchAction;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: Stepanov Dmitriy
 * Date: 4/9/12
 * Time: 7:50 AM
 */
public class GoodsAction extends LookupDispatchAction {
    private static final Map<String, String> map = new HashMap<String, String>();
    private static JDOMController jdomController = JDOMController.getInstance();

    static {
        GoodsAction.map.put("jsp.edit.button.cancel", "cancel");
        GoodsAction.map.put("jsp.list.link.view", "view");
        GoodsAction.map.put("jsp.edit.button.save", "edit");
        GoodsAction.map.put("jsp.edit.button.add", "save");
    }

    @Override
    protected Map getKeyMethodMap() {
        return Collections.unmodifiableMap(map);
    }

    public ActionForward cancel(ActionMapping mapping,
                                ActionForm form,
                                HttpServletRequest request,
                                HttpServletResponse response)
            throws IOException, ServletException {
        return mapping.findForward("cancelPage");
    }

    public ActionForward save(ActionMapping mapping,
                              ActionForm form,
                              HttpServletRequest request,
                              HttpServletResponse response)
            throws IOException, ServletException {
        GoodsForm goodsForm = (GoodsForm) form;
        Goods emptyGoods = new Goods("", "", "", "", "", "", "", null, false);
        Goods goods = goodsForm.getGoods();
        if (goodsForm.getJsCheck()) {
            if (isTokenValid(request, true)) {
                jdomController.save(goods);
            }
            goodsForm.setGoods(emptyGoods);
        } else {
            String val = Validator.validate(goods);
            if (val.isEmpty()) {
                if (isTokenValid(request, true)) {
                    jdomController.save(goods);
                }
                goodsForm.setGoods(emptyGoods);
            } else {
                goodsForm.setValidateMessage(val);
                resetToken(request);
                return view(mapping, form, request, response);
            }
        }
        goodsForm.setSubCategoryName(goods.getSubCategory());
        goodsForm.setCategoryName(goods.getCategory());
        return view(mapping, form, request, response);
    }

    public ActionForward edit(ActionMapping mapping,
                              ActionForm form,
                              HttpServletRequest request,
                              HttpServletResponse response)
            throws IOException, ServletException {
        GoodsForm goodsForm = (GoodsForm) form;
        Goods goods = goodsForm.getGoods();
        Element element = goodsForm.getRootElement();
        jdomController.save(goodsForm.getRootElement());
        goodsForm.setSubCategoryName(goods.getSubCategory());
        goodsForm.setCategoryName(goods.getCategory());
        return view(mapping, form, request, response);
    }

    public ActionForward view(ActionMapping mapping,
                              ActionForm form,
                              HttpServletRequest request,
                              HttpServletResponse response)
            throws IOException, ServletException {
        GoodsForm goodsForm = (GoodsForm) form;
        getData(goodsForm);
        if (goodsForm.getShowAdd()) {
            saveToken(request);
        }
        if (goodsForm.getCategoryName().isEmpty()) {
            return mapping.findForward("categoryPage");
        } else {
            if (goodsForm.getSubCategoryName().isEmpty()) {
                return mapping.findForward("subCategoryPage");
            } else {
                return mapping.findForward("unitPage");
            }
        }


    }

    public void getData(GoodsForm form) throws IOException, ServletException {
        form.setRootElement(jdomController.getElement());
    }


    @Override
    protected ActionForward unspecified(ActionMapping mapping,
                                        ActionForm form,
                                        HttpServletRequest request,
                                        HttpServletResponse response) throws Exception {
        return view(mapping, form, request, response);
    }
}
