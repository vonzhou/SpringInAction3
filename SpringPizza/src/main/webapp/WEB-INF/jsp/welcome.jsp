<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<h2>Welcome to Spizza!!!</h2>

<form:form>
    <input type="text" name="phoneNumber"/><br/>

    <input type="submit" name="_eventId_phoneEntered" value="Lookup Customer"/> <!--触发phoneEntered事件-->
</form:form>
