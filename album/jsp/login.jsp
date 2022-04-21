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
    
    <!-- error message -->
    <div class="error">
      <c:out value="${message}"/>
    </div>
    
    <!-- login -->
    <div class="login">
      <form method="post" action="/album/manager">
        <div class="texts">
          <p>User ID</p>
          <input type="text" name="ownerid" autocomplete="off" value="<c:out value="${ownerid}"/>">
          <p>Password</p>
          <input type="password" name="password">
        </div>
        <div class="buttons">
          <input id="submit" type="submit" value="LOGIN">
          <input id="reset" type="reset" value="RESET">
        </div>
      </form>
    </div>
    
    <!-- footer -->
    <%@ include file="/jsp/footer.jsp"%>
  </body>
</html>
