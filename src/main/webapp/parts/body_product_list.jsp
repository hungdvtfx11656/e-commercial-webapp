<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="product_list">
    <div class="row justify-content-center g-0">
        <div class="col-11 col-md-10 px-3">

<%--            Product list--%>
            <div class="row g-0">
            <c:choose>
                <c:when test="${requestScope.products.isEmpty()}">
                    <div class="mx-3">
                        <h3>No product was found</h3>
                    </div>
                </c:when>
                <c:otherwise>
                    <c:forEach items="${requestScope.products}" var="product">
                        <div class="col-12 col-md-6 col-lg-3">
                            <a href="ProductGet?product_id=${product.id}">
                                <div class="border border-secondary rounded p-3 mx-3 mb-5">
                                    <div>
                                        <img src="${product.src}" class="w-100 mb-3">
                                    </div>
                                    <div>
                                        <p class="text-black-50">${fn:toUpperCase(product.type)}</p>
                                        <p class="text-primary">${product.name}</p>
                                        <p class="text-danger"><fmt:formatNumber value = "${product.price * 1000000}" groupingUsed = "true" maxFractionDigits="0"/> VND</p>
                                    </div>
                                </div>
                            </a>
                        </div>
                    </c:forEach>
                </c:otherwise>
            </c:choose>
            </div>

            <div class="mb-5">
                <nav aria-label="">
                    <ul class="pagination justify-content-center">
                        <li class="page-item <c:if test="${requestScope.current_page eq 1}">disabled</c:if>">
                            <a class="page-link" href="${request.getContextPath()}?page=${requestScope.current_page - 1}&search=${requestScope.search}">Previous</a>
                        </li>

                        <c:forEach begin="1" end="${requestScope.no_pages}" var="i">
                            <li class="page-item <c:if test="${requestScope.current_page eq i}">disabled</c:if>">
                                <a class="page-link" href="${request.getContextPath()}?page=${i}&search=${requestScope.search}">${i}</a>
                            </li>
                        </c:forEach>

                        <li class="page-item <c:if test="${requestScope.current_page eq requestScope.no_pages}">disabled</c:if>">
                            <a class="page-link" href="${request.getContextPath()}?page=${requestScope.current_page + 1}&search=${requestScope.search}">Next</a>
                        </li>
                    </ul>
                </nav>
            </div>

        </div>
    </div>
</div>