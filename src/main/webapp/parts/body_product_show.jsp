<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div>
    <div class="row justify-content-center px-3 g-0">
        <div class="col-11 col-md-10">
            <div class="border-bottom border-2 mx-3 mb-4 text-black-50">
                <h2>${requestScope.product.name}</h2>
            </div>
            <div class="row justify-content-center mb-5 g-0">
                <div class="col-12 col-md-5 px-3 mb-4">
                    <img src="${requestScope.product.src}" class="w-100">
                </div>
                <div class="col-12 col-md-7 px-3">
                    <div class="mb-3 text-danger">
                        <h2><fmt:formatNumber value = "${product.price * 1000000}" groupingUsed = "true" maxFractionDigits="0"/> VND</h2>
                    </div>
                    <div class="mb-5">
                        <p class="mb-3">${requestScope.product.description}</p>
                    </div>
                    <div class="mb-3">
                        <a href="AddToCart?action=add&product_id=${requestScope.product.id}" class="btn btn-primary rounded-pill w-50">
                            Add to cart
                        </a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>