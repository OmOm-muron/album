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
    
    <!-- contact -->
    <div class="contact">
      <div class="telno">
         <p>
         電話番号
         </p>
         <a href="tel:<c:out value="${owner.ownertelno}"/>"><c:out value="${owner.ownertelno}"/></a>
      </div>
      <div class="mail">
        <p>
          メールアドレス
        </p>
        <a href="mailto://<c:out value="${owner.ownermail}"/>"><c:out value="${owner.ownermail}"/></a>
      </div>
      <div class="sns">
        <p>
          各種SNSは下記アイコンからアクセスしてください。
        </p>
        <ul>
          <c:if test="${not empty owner.ownertwitter}">
            <li><a href="<c:out value="${owner.ownertwitter}"/>" target="_blank" rel="noopener norefferer"><img src="/images/twitter.png"></a></li>
          </c:if>
          <c:if test="${not empty owner.ownerinstagram}">
            <li><a href="<c:out value="${owner.ownerinstagram}"/>" target="_blank" rel="noopener norefferer"><img src="/images/instagram.png"></a></li>
          </c:if>
          <c:if test="${not empty owner.ownerfacebook}">
            <li><a href="<c:out value="${owner.ownerfacebook}"/>" target="_blank" rel="noopener norefferer"><img src="/images/facebook.png"></a></li>
          </c:if>
        </ul>
      </div>
    </div>
    
    <!-- footer -->
    <%@ include file="/jsp/footer.jsp"%>
  </body>
</html>
