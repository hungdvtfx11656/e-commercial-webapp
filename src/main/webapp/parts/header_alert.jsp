<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<c:if test="${requestScope.alert_warning != null}">
    <div class="alert alert-warning alert-dismissible fade show mb-0" role="alert">
        <strong>Warning! </strong>${requestScope.alert_warning}
        <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
    </div>
</c:if>
<c:if test="${requestScope.alert_success != null}">
    <div class="alert alert-success alert-dismissible fade show mb-0" role="alert">
        <strong>Success! </strong>${requestScope.alert_success}
        <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
    </div>
</c:if>