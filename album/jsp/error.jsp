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
    
    <!-- error -->
    <div class="error">
      <p>Error has occurred.</p>
      <p>Please contact administrator.</p>
    </div>
    
    <!-- footer -->
    <%@ include file="/jsp/footer.jsp"%>
  </body>
</html>
