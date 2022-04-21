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
    
    <!-- message -->
    <div class="message">
      <p>
        <c:out value="${message}"/>
      </p>
    </div>
    
    <!-- album -->
    <!-- 非同期通信によって無限スクロールで取得する -->
    <div class="album">
      <c:forEach items="${albumList}" var="album">
        <a href="/album/detail?imageid=<c:out value="${album.imageid}"/>"><img src="<c:out value="${album.imagepath}"/>"></a>
      </c:forEach>
    </div>
    <input id="offset" type="hidden" value="15">
    
    <!-- footer -->
    <%@ include file="/jsp/footer.jsp"%>
  <script src="/js/album.js"></script>
  </body>
</html>
