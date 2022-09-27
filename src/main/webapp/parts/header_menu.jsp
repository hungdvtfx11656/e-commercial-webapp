<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="header_menu mb-5">
    <div class="row justify-content-center align-items-center g-0">
        <div class="col-11 col-md-10 px-3">
            <div class="d-flex justify-content-between mx-3">
                <ul class="list-unstyled d-flex">
                    <li><a href="index.jsp">Home</a></li>
                </ul>
                <ul class="list-unstyled d-flex">
                    <c:choose>
                        <c:when test="${sessionScope.account.check == 0}">
                            <li class="text-warning">Welcome <strong>${sessionScope.account.usr}</strong></li>
                            <c:if test="${sessionScope.account.role == 0}">
                                <li><a href="AccountList">Admin</a></li>
                            </c:if>
                            <li><a href="Logout">Logout</a></li>
                        </c:when>
                        <c:otherwise>
                            <li><a href="login.jsp">Login</a></li>
                            <li><a href="registry.jsp">Registry</a></li>
                        </c:otherwise>
                    </c:choose>
                </ul>
            </div>
        </div>
    </div>
</div>