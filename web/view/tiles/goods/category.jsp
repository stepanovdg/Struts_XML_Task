<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@ include file="/view/taglibs.jsp" %>
<table id="goodsTable">
    <tr>
        <TH>Category</TH>
        <TH>Subcategory</TH>
        <TH>Product Name</TH>
        <TH>Provider</TH>
        <TH>Model</TH>
        <TH>Date of Issue</TH>
        <TH>Color</TH>
        <TH>Price</TH>
        <TH>NotInStock</TH>
    </tr>
    <nested:root name="goodsForm">
        <nested:nest property="rootElement">
            <nested:iterate id="goods" property="children" indexId="index">
                <nested:iterate property="attributes">
                    <nested:define id="categoryName" property="value"/>
                </nested:iterate>
                <tr>
                    <td>
                        <a href="goodsAction.do?method=view&categoryName=${categoryName}">
                                ${categoryName}
                        </a>
                    </td>
                    <td>
                    </td>
                    <bean:define id="subCategory" name="goodsForm" property="categoryName">
                    </bean:define>
                    <c:choose>
                        <c:when test='${subCategory==categoryName}'>
                            <jsp:include page="./subCategory.jsp"/>
                        </c:when>
                    </c:choose>
                </tr>
            </nested:iterate>
        </nested:nest>
    </nested:root>
</table>
