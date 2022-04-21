<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

  <c:if test="${sessionScope.login}">
    <%@ include file="/html/footer-manager.html"%>
  </c:if>
  <c:if test="${!sessionScope.login}">
    <%@ include file="/html/footer.html"%>
  </c:if>
  <input id="contextPath" type="hidden" value="<c:out value="${contextPath}"/>">
