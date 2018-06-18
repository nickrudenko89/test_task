<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script>
    function showHideDetails(id) {
        var element = document.getElementById(id);
        if (element.style.display === "none") {
            element.style.display = "block";
        } else {
            element.style.display = "none";
        }
    }
</script>
<div>
    <c:if test="${user.userType == 1}">
        <c:forEach items="${allRequests}" var="request">
            <c:if test="${request.isCompleted == -1}">
                <div id="${request.id}" style="display: inline-block">
                    <span><b>User: </b>${request.user.login}</span><br>
                    <span style="margin-left: 10px">Request: ${request.request}; Bid: ${request.bid}; Due date ${request.dueDate};</span>
                    <a class="href_button" style="display: inline-block; width: 20px" href="/changeRequest?id=${request.id}&status=0">×</a>
                    <a class="href_button" style="display: inline-block; width: 20px" href="/changeRequest?id=${request.id}&status=1">✓</a>
                </div>
            </c:if>
        </c:forEach>
    </c:if>
    <c:if test="${user.userType == 2}">
        <c:forEach items="${allRequests}" var="request">
            <div id="${request.id}" style="display: inline-block">
                <span style="margin-left: 10px">Request: ${request.request}; Bid: ${request.bid}; Due date ${request.dueDate};</span>
                <c:if test="${request.isCompleted == -1}">
                    <span> Status: </span><span style="color: blue">considered</span>
                </c:if>
                <c:if test="${request.isCompleted == 0}">
                    <span> Status: </span><span style="color: red">declined</span>
                </c:if>
                <c:if test="${request.isCompleted == 1}">
                    <span> Status: </span><span style="color: green">accepted</span>
                </c:if>
            </div>
        </c:forEach>
    </c:if>
</div>
<br>
<c:if test="${user.userType == 1}">
    <a class="href_button" href="#" onclick="showHideDetails('request_statistics')"><span>Statistics</span></a>
    <div id="request_statistics" style="display: none">
        <span>accepted requests: ${acceptedRequests}</span><br>
        <span>declined requests: ${declinedRequests}</span><br><br>
        <c:forEach items="${allRequests}" var="request">
            <c:if test="${request.isCompleted != -1}">
                <div id="${request.id}" style="display: inline-block">
                    <span><b>User: </b>${request.user.login}</span><br>
                    <span style="margin-left: 10px">Request: ${request.request}; Bid: ${request.bid}; Due date ${request.dueDate};</span>
                    <c:if test="${request.isCompleted == 0}">
                        <span> Status: declined</span>
                    </c:if>
                    <c:if test="${request.isCompleted == 1}">
                        <span> Status: accepted</span>
                    </c:if>
                </div>
            </c:if>
        </c:forEach>
    </div>
</c:if>
<c:if test="${user.userType == 2}">
    <div>
        <a class="href_button" href="#" onclick="showHideDetails('new_request_form')"><span>New request</span></a>
        <div id="new_request_form" style="display: ${displayForm}">
            <form:form method="post" action="/addRequest" commandName="requestForm">
                <table>
                    <tr>
                        <td>Request:</td>
                        <td><form:input path="request" /></td>
                        <td><span class="error"><form:errors path="request" /></span></td>
                    </tr>

                    <tr>
                        <td>Bid:</td>
                        <td><form:input path="bid" /></td>
                        <td><span class="error"><form:errors path="bid" /></span></td>
                    </tr>

                    <tr>
                        <td>Due date:</td>
                        <td><form:input path="dueDate" /></td>
                        <td><span class="error"><form:errors path="dueDate" /></span></td>
                    </tr>

                    <form:hidden path="isCompleted" value="-1" />

                    <tr>
                        <td colspan="3"><input type="submit" value="Submit" /></td>
                    </tr>
                </table>
            </form:form>
        </div>
    </div>
</c:if>
