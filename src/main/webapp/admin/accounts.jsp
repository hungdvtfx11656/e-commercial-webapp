<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <c:import url="../parts/head_meta.jsp"></c:import>
    <title>Accounts</title>
    <c:import url="../parts/head_link.jsp"></c:import>
</head>
<body>
    <c:import url="../parts/header_search.jsp"></c:import>
    <c:import url="../parts/header_menu.jsp"></c:import>

    <div class="admin_page mb-5">
        <div class="row justify-content-center g-0">
            <div class="col-10">
                <div class="row justify-content-center mx-3">
                    <div class="col-3 px-3">
                        <h2 class="mb-3">Database</h2>
                        <ul class="list-unstyled">
                            <li><a href="#">Accounts</a></li>
                        </ul>
                    </div>
                    <div class="col-9 px-3">
                        <h2 class="mb-3">Table show</h2>
                        <table class="table">
                            <thead class="table-light">
                            <tr>
                                <th scope="col">Email</th>
                                <th scope="col">Name</th>
                                <th scope="col">Address</th>
                                <th scope="col">Phone</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${requestScope.account_list}" var="a">
                                <tr>
                                    <th scope="row">${a.usr}</th>
                                    <td>${a.name}</td>
                                    <td>${a.address}</td>
                                    <td>${a.phone}</td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <c:import url="../parts/footer_info.jsp"></c:import>
    <c:import url="../parts/footer_script.jsp"></c:import>
</body>
</html>

