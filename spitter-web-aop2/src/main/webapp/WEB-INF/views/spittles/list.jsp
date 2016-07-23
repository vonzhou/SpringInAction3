
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>

<div>
    <h2>Spittles for ${spitter.username}</h2>

    <table cellspacing="15">
        <c:forEach items="${spittleList}" var="spittle">
            <tr>
                <td>
                    <img src="<s:url value="/resources/images/spitter_avatar.png" />" width="48" height="48">
                </td>
                <td>
                    <a href="<s:url value="spitters/${spittle.spitter.username}"/> ">
                        ${spittle.spitter.username}
                    </a>
                    <c:out value="${spittle.text}"/><br/>
                    <c:out value="${spittle.when}"/>
                </td>
            </tr>
        </c:forEach>
    </table>

</div>

