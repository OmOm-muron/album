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
    
    <!-- submit -->
    <form class="submit" method="post" action="/album/submit" enctype="multipart/form-data">
      <div class="thumbnail">
        <img id="preview" alt="Please drag and drop image here OR select image file below.">
        <!-- TODO implement javascript code to preview image -->
        <input type="file" name="image" id="image" accept="image/png, image/jpeg, image/jpg">
      </div>
      <textarea name="comment"></textarea>
      <input class="button" type="submit" value="SUBMIT">
    </form>
    
    <!-- footer -->
    <%@ include file="/jsp/footer.jsp"%>
  <script src="/js/submit.js"></script>
  </body>
</html>
