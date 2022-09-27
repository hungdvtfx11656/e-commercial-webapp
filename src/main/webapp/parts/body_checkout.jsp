<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="check_out">
    <div class="row justify-content-center g-0">
        <div class="col-11 col-md-10">
            <div class="row justify-content-center mx-3">
                <div class="col-12 col-lg-9 px-3">
                    <h2 class="mb-3">Items in cart</h2>
                    <table class="table">
                        <thead class="table-light">
                        <tr>
                            <th scope="col">Name</th>
                            <th scope="col">Price</th>
                            <th scope="col">Quantity</th>
                            <th scope="col">Amount</th>
                            <th scope="col">Remove</th>
                        </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${sessionScope.cart.items}" var="product">
                                <tr>
                                    <th scope="row">${product.name}</th>
                                    <td><fmt:formatNumber value = "${product.price * 1000000}" groupingUsed = "true" maxFractionDigits="0"/> VND</td>
                                    <td>${product.number}</td>
                                    <td><fmt:formatNumber value = "${product.price * 1000000 * product.number}" groupingUsed = "true" maxFractionDigits="0"/> VND</td>
                                    <td><a href="AddToCart?action=remove&product_id=${product.id}" class="text-danger">X</a></td>
                                </tr>
                            </c:forEach>
                        </tbody>
                        <tfoot class="table-light text-danger">
                            <th scope="row"></th>
                            <td></td>
                            <td></td>
                            <td>
                                <fmt:formatNumber value = "${sessionScope.cart.amount * 1000000}" groupingUsed = "true" maxFractionDigits="0"/> VND
                            </td>
                            <td></td>
                        </tfoot>
                    </table>
                    </table>
                </div>
                <div class="col-12 col-lg-3 px-3 mb-5">
                    <h2 class="mb-3">Customer info</h2>
                    <form action="CheckOut" method="post">
                        <div class="mb-3">
                            <label for="email" class="form-label">Email</label>
                            <input type="email" name="email" id="email" class="form-control" placeholder="" required>
                        </div>
                        <div class="mb-3">
                            <label for="address" class="form-label">Address</label>
                            <input type="text" name="address" id="address" class="form-control" placeholder="" required>
                        </div>
                        <div class="mb-3">
                            <label for="discount" class="form-label">Discount</label>
                            <input type="text" name="discount" id="discount" class="form-control" placeholder="" maxlength="8">
                        </div>
                        <div class="d-flex justify-content-center">
                            <button type="submit" class="btn btn-primary rounded-pill w-100" <c:if test="${sessionScope.cart.amount == null || sessionScope.cart.amount == 0}">disabled</c:if>>Check out</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>