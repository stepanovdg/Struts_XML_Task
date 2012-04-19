<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@ include file="/view/taglibs.jsp" %>
<bean:define id="showAdd" name="goodsForm" property="showAdd"/>
<bean:define id="categoryName" name="goodsForm" property="categoryName"/>
<bean:define id="subCategoryName" name="goodsForm" property="subCategoryName"/>
<bean:define id="validateMessage" name="goodsForm" property="validateMessage"/>
<html:form styleId="saveFormNested" method="POST" action="/goodsAction.do?method=Save">
    <input type="hidden" id="alertName" value="<bean:message key='jsp.unit.alert.name'/>"/>
    <input type="hidden" id="alertProducer" value="<bean:message key='jsp.unit.alert.producer'/>"/>
    <input type="hidden" id="alertDate" value="<bean:message key='jsp.unit.alert.date'/>"/>
    <input type="hidden" id="alertColor" value="<bean:message key='jsp.unit.alert.color'/>"/>
    <input type="hidden" id="alertModel" value="<bean:message key='jsp.unit.alert.model'/>"/>
    <input type="hidden" id="alertPrice" value="<bean:message key='jsp.unit.alert.price'/>"/>
    <input type="hidden" id="validateMessage" value="${validateMessage}"/>
    <nested:iterate id="unit" property="children" indexId="index">
        <tr id="tr${index}">
            <td/>
            <td/>
            <td>
                <nested:text styleId="unitNm${index}" styleClass="unitPrSt" property="attributes[0].value"/>
            </td>
            <td>
                <nested:text styleId="unitPv${index}" styleClass="unitPrSt" property="attributes[1].value"/>
            </td>
            <td>
                <nested:text styleId="unitMd${index}" styleClass="unitPrSt" property="attributes[2].value"/>
            </td>
            <td>
                <nested:text styleId="unitDt${index}" styleClass="unitPrSt" property="children[0].text"/>
            </td>
            <td>
                <nested:text styleId="unitCl${index}" styleClass="unitPrSt" property="children[1].text"/>
            </td>
            <td>
                <nested:text styleId="unitPr${index}" styleClass="unitPrSt" property="children[2].text"/>
            </td>
            <td>
                <nested:checkbox styleId="${index}" styleClass="unitPrSt" property="children[2].text"/>
            </td>
        </tr>
    </nested:iterate>
    <span id="WithoutJsForm">
        <html:hidden styleId="categoryName"
                     value='${categoryName}'
                     name="goodsForm"
                     property="goods.category"/>

        <html:hidden styleId="subCategoryName"
                     value='${subCategoryName}'
                     name="goodsForm" property="goods.subCategory"/>

        <td>
            <html:submit styleId="saveButton" property="method">
                <bean:message key="jsp.edit.button.save"/>
            </html:submit>
        </td>
        <td>
            <a href="goodsAction.do?method=view&categoryName=${categoryName}&subCategoryName=${subCategoryName}">
                Cancel
            </a>
        </td>

        <td>
            <a href="goodsAction.do?method=view&showAdd=true&categoryName=${categoryName}&subCategoryName=${subCategoryName}">
                Add New Unit
            </a>
        </td>
        <td/>
        <td/>
        <td/>
        <td/>
        <td/>
        <td/>
        </tr>
    </span>
</html:form>
<c:choose>
    <c:when test="${showAdd==true}">

        <html:form styleId="add" method="POST" action="/goodsAction.do?method=Add">
            <html:hidden styleId="categoryName"
                         value='${categoryName}'
                         name="goodsForm" property="goods.category"/>

            <html:hidden styleId="subCategoryName"
                         value='${subCategoryName}'
                         name="goodsForm" property="goods.subCategory"/>
            <html:hidden styleId="jsCheck"
                         value='false'
                         name="goodsForm" property="jsCheck"/>

            <tr>
                <td>
                    <html:submit styleId="addButton" property="method">
                        <bean:message key="jsp.edit.button.add"/>
                    </html:submit>
                    <a id="addHref" href="">
                        Add
                    </a>
                </td>
                <td>
                    <a href="goodsAction.do?method=view&categoryName=${categoryName}&subCategoryName=${subCategoryName}">
                        Cancel
                    </a>
                </td>
                <td>
                    <html:text styleId="editName" name="goodsForm" property="goods.unit"/>
                </td>
                <td><html:text styleId="editProducer" name="goodsForm" property="goods.provider"/>
                </td>
                <td><html:text styleId="editModel" name="goodsForm" property="goods.model"/>
                </td>
                <td><html:text styleId="editDate" name="goodsForm" property="goods.dateOfIssue"/>
                </td>
                <td>
                    <html:text styleId="editColor" name="goodsForm" property="goods.color"/>
                </td>

                <td>
                    <div id="unitPrice" style="width:5px">
                        <html:text styleId="editPrice" name="goodsForm" property="goods.price"/>
                    </div>
                </td>
                <td>
                    <html:checkbox styleId="unitStockBox" name="goodsForm" property="goods.stock"/>
                </td>
            </tr>
        </html:form>

    </c:when>
    <c:otherwise>
        <html:form styleId="saveForm" method="POST" action="/goodsAction.do?method=Save">
            <html:hidden styleId="categoryName"
                         value='${categoryName}'
                         name="goodsForm"
                         property="goods.category"/>

            <html:hidden styleId="subCategoryName"
                         value='${subCategoryName}'
                         name="goodsForm" property="goods.subCategory"/>

            <td>
                <a id="saveHref" href="">
                    Save
                </a>
            </td>
            <td>
                <a href="goodsAction.do?method=view&categoryName=${categoryName}&subCategoryName=${subCategoryName}">
                    Cancel
                </a>
            </td>

            <td>
                <a href="goodsAction.do?method=view&showAdd=true&categoryName=${categoryName}&subCategoryName=${subCategoryName}">
                    Add New Unit
                </a>
            </td>
            <td/>
            <td/>
            <td/>
            <td/>
            <td/>
            <td/>
        </html:form>
    </c:otherwise>
</c:choose>
