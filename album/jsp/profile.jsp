<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html>
  <!-- head -->
  <%@ include file="/html/head.html"%>

  <body>
    <!-- header -->
    <%@ include file="/html/header.html"%>
    
    <!-- profile -->
    <div class="profile">
      <div class="introduce">
        <h3>
          <c:out value="${owner.ownername}"/>
        </h3>
        <pre><c:out value="${owner.ownerprofile}"/></pre>
      </div>
      <div class="face">
        <img src="<c:out value="${owner.ownerimagepath}"/>">
      </div>
    </div>
    
    <!-- footer -->
    <%@ include file="/jsp/footer.jsp"%>
  </body>
</html>
