<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Popup Close</title>
</head>
<body>
<script type="text/javascript">
    <c:if test="${message != null}">
    alert("${message}");
    </c:if>

    parent.closePopup();
</script>
</body>
</html>
