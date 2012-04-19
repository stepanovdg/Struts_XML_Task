<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@ include file="/view/taglibs.jsp" %>

<bean:define id="category" name="goodsForm" property="categoryName"/>
<nested:iterate property="children" indexId="index">
    <nested:iterate property="attributes">
        <nested:define id="subCategoryName" property="value"/>
    </nested:iterate>
    <tr>
        <td/>
        <td>
            <a href="goodsAction.do?method=view&categoryName=${category}&subCategoryName=${subCategoryName}">
                    ${subCategoryName}
            </a>
        </td>
        <td>
        </td>
        <td>
            <bean:define id="unit" name="goodsForm" property="subCategoryName"/>
            <c:choose>
                <c:when test='${unit==subCategoryName}'>
                    <jsp:include page="unit.jsp"/>
                </c:when>
            </c:choose>
        </td>
    </tr>
</nested:iterate>



