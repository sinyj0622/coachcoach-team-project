<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../../header.jsp"/>

<h1>공지사항</h1>
<form action='list' method='get' enctype='multipart/form-data'>
보낸날짜: 2020-04-22 <br>
보낸회원목록: 홍길동, 유관순<br>
날짜: 2020-04-02 ~ 2020-04-03<br>
제목: [엄진영코치] 이틀 휴가입니다.<br>
내용: 4월 2일,3일 휴가입니다. 휴가 갔다와서 차례대로 채팅하겠습니다.
감사합니다.<br>
<p><a href='delete'>삭제</a> 
<a href='updateForm'>수정</a></p>
<p><button>확인</button>
</form>


<jsp:include page="../../footer.jsp"/>
    