 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<jsp:include page="../header.jsp"/>

<div style='border:1px solid gray; padding:10px; margin:5px'>
<form action='applyForm' method='post'>
<h3>프로그램</h3>
번호: ${programList.no}<br>
프로그램명: ${programList.name}<br>
프로그램: ${programList.introduce}<br>
수강금액: ${programList.fee}<br>
</div>
<div style='border:1px solid gray; padding:10px; margin:5px'>
<h5>${programList.coach.name} 코치님</h5>
<img src='${pageContext.servletContext.contextPath}/upload/coach/${programList.coach.photo}' height='200'><br>
수업가능지역: ${programList.coach.area}<br>
경력: ${programList.coach.career}<br>
자격증: ${programList.coach.certification}<br>
소개: ${programList.coach.introduce}<br>
유형: ${programList.coach.workType}<br>
<button>신청하기</button>
<input name='no' type='hidden' value='${programList.no}'><br>
</form>
</div>



<div style='border:1px solid gray; padding:10px; margin:5px'>

<p>코치 만족도</p>
<p id="star_grade">
        <a href="#">★</a>
        <a href="#">★</a>
        <a href="#">★</a>
        <a href="#">★</a>
        <a href="#">★</a>
</p>        

  <h3>수강후기</h3>
  <c:forEach items="${memberProgram}" var="memberProgram">
    <c:if test="${memberProgram.review ne null}">
      ${memberProgram.review}
      ${memberProgram.reviewDate}
      </c:if>
  </c:forEach>

</div>



<script>
        $('#star_grade a').click(function(){
            $(this).parent().children("a").removeClass("on");  
            $(this).addClass("on").prevAll("a").addClass("on"); 
            return false;
        });
</script>


<jsp:include page="../footer.jsp"/>
