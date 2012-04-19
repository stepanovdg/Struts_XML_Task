<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%@ include file="/view/taglibs.jsp" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/ie.css"/>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.7.1.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/xsl.js"></script>
</head>
<body>
<div id="page">
    <div id="header">
        <tiles:insert attribute="header"/>
    </div>
    <div id="mider">
        <tiles:insert attribute="body" ignore="true"/>
    </div>
    <div id="footer">
        <tiles:insert attribute="footer"/>
    </div>
</div>
</body>
</html>
