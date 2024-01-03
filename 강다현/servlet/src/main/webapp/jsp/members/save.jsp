<%@ page import="hello.servlet.domain.member.MemberRepository" %>
<%@ page import="hello.servlet.domain.member.Member" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    //request, response는 그냥 사용 가능 어땠는 jsp도 나중에 가면 servlet으로 변하기 때문이다.
    MemberRepository memberRepository = MemberRepository.getInstance();

    System.out.println("Member.SaveServlet.service");
    String username = request.getParameter("username");
    int age = Integer.parseInt(request.getParameter("age"));

    Member member = new Member(username, age);
    memberRepository.save(member);

%>

<html>
<head>
    <title>Title</title>
</head>
<body>

성공
<ul>
    <li>id = <%=((Member)request.getAttribute("mamber")).getId()%> </li>
    <li> username =<%=((Member)request.getAttribute("mamber")).getUsername()%></li>
    <li> age =<%=((Member)request.getAttribute("mamber")).getAge()%></li>
</ul>
<a href = "/index.html">메인</a>
</body>
</html>