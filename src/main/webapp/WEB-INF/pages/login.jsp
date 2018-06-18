<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="<c:url value="/resources/css/styles.css"/>" type="text/css" rel="stylesheet">
    <title>Index page</title>
</head>
<body>
<div id="login_wrapper">
    <div id="login_body">
        <div id="login_body_top">
            <label id="error_label">${errorMsg}</label>
        </div>
        <div id="login_body_foot">
            <form method="POST" action="/login" style="margin-top: 10px;">
                <input tabindex="1" class="input" id="user_input" type="text" name="login" value placeholder="Login">
                <br>
                <input tabindex="2" class="input" id="password_input" type="password" name="password" value
                       placeholder="Password">
                <br>
                <table width="415">
                    <tr>
                        <td>
                            <input tabindex="3" class="button" type="submit" value="Log In">
                        </td>
                    </tr>
                </table>
            </form>
        </div>
    </div>
</div>
</body>
</html>
