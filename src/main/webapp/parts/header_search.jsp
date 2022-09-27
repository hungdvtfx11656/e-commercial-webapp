<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<div class="header_search py-3 py-md-5">
    <div class="row justify-content-center align-items-center g-0">
        <div class="col-11 col-md-10 px-3">
            <div class="row justify-content-between align-items-center mx-3 g-0">
                <div class="col-2 text-center d-none d-md-block">
                    <a href="index.jsp" class="text-light">
                        <i class="fa fa-home fa-3x" aria-hidden="true"></i>
                        <div>PRJ321x</div>
                    </a>
                </div>
                <div class="col-8 col-md-8">
                    <form action="ProductSearch">
                        <div class="input-group">
                            <input type="text" name="search" class="form-control text-center w-50 border-0" aria-label="Text input with dropdown button" placeholder="Enter keywords..." value="${requestScope.search}">
                            <button class="btn bg-warning" type="submit">
                                <i class="fa fa-search px-2"></i>
                            </button>
                        </div>
                    </form>
                </div>
                <div class="col-4 col-md-2 text-center">
                    <a href="cart.jsp" class="text-light">
                        <i class="fa fa-shopping-cart fa-3x"></i>
                        <div class="d-none d-md-block">Check out</div>
                    </a>
                </div>
            </div>
        </div>
    </div>
</div>
