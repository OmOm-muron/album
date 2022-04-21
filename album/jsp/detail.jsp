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
    
    <!-- delete -->
    <c:if test="${sessionScope.login}" >
      <div class="manage">
        <dialog id="dialog">
          <b class="dialog-message">
            Are you sure to delete this post?
          </b>
          <div class="dialog-buttons">
            <button id="submit-button">Yes</button>
            <button id="cancel-button">No</button>
          </div>
          <input type="hidden" name="imageid" value="<c:out value="${album.imageid}"/>">
        </dialog>
        <button type="button" id="delete-confirm">
          DELETE
        </button>
      </div>
    </c:if>
    
    <!-- detail -->
    <div class="detail">
      <div class="thumbnail">
        <img src="<c:out value="${album.imagepath}"/>">
      </div>
      <div class="comment">
        <pre><c:out value="${fn:trim(album.comment)}"/></pre>
      </div>
    </div>
    
    <!-- footer -->
    <%@ include file="/jsp/footer.jsp"%>
  <script src="/js/delete.js"></script>
  </body>
</html>
