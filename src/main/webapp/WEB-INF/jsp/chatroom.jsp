<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" %>

<div style="max-height: 400px; overflow-y: scroll;">
    <table>
        <c:forEach items="${sessionScope.messages}" var="message">
            <tr>
                <td><c:out value="${message.payload}" /></td>
                <td><c:out value="${message.author}" /></td>
                <td><c:out value="${message.date}" /></td>
            </tr>
        </c:forEach>
    </table>
</div>

<table>
    <td>
        <form action="/chatroom" method="post">
            <p> <input type="text" name="new message" > </p>
            <p> <input type="submit" name="send" value="отправить сообщение"> </p>
        </form>
    </td>
    <td>
        <form action="/chatroom" method="get">
            <p>твой токен секретна <c:out value="${sessionScope.account.token}" /></p>
            <p> <input type="submit" name="update" value="обновить сообщения от работяг"></p>
        </form>
    </td>
</table>
<a href="/"><p>на главную</p></a>



