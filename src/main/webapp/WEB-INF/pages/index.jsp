<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset=utf-8"/>
    <script type="text/javascript" src="/resources/js/timer.js"></script>
    <link href="<c:url value="/resources/css/styles.css"/>" type="text/css" rel="stylesheet">
    <title>Index page</title>
</head>
<body onload="startTimer()">
<div id="index_wrapper">
    <div class="left_menu">
        <table width="100%">
            <tr>
                <td>
                    <p><span>Welcome, ${userName}</span></p>
                </td>
            </tr>
            <tr>
                <td><span class="user_session"> Session expires: <span id="timer">00:10:01</span></span></td>
            </tr>
            <tr>
                <td>
                    <a class="href_button" style="margin-top: 10px" href="/requests">Show requests</a>
                </td>
            </tr>
            <tr>
                <td>
                    <a class="href_button" href="/logout">Exit</a>
                </td>
            </tr>

        </table>

    </div>
    <div class="index_content" id="main_content">
        <c:if test="${path==null}">
            <c:set var="path" value="/resources/imported_html/blank.html"/>
        </c:if>
        <jsp:include page="${path}"/>
    </div>
</div>
</body>
</html>
