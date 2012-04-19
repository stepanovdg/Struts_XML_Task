<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@ include file="taglibs.jsp" %>
<div id="error">
    <bean:message key="welcome.error"/>
    <html:errors/>
    <a href="/goodsAction.do?method=view"><bean:message key="jsp.list.button.news"/></a>
</div>