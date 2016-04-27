<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<div>
    <h2>Sign in to Spitter</h2>

    <p>
        If you've been using Spitter from your phone,
        then that's amazing...we don't support IM yet.
    </p>

    <form method="post" class="signin" action="<c:url value='/j_spring_security_check'/>">

        <fieldset>
            <table cellspacing="0">
                <tr>
                    <th><label for="username_or_email">Username or Email</label></th>
                    <td><input id="username_or_email"
                               name="username"
                               type="text"/>  <!--<co id="co_usernameField"/>-->
                    </td>
                </tr>
                <tr>
                    <th><label for="password">Password</label></th>
                    <td><input id="password"
                               name="password"
                               type="password"/> <!--<co id="co_passwordField"/>-->
                        <small><a href="/account/resend_password">Forgot?</a></small>
                    </td>
                </tr>
                <tr>
                    <th></th>
                    <td><input id="remember_me"
                               name="_spring_security_remember_me"
                               type="checkbox"/> <!--<co id="co_rememberMe"/>-->
                        <label for="remember_me"
                               class="inline">Remember me</label></td>
                </tr>
                <tr>
                    <th></th>
                    <td><input name="commit" type="submit" value="Sign In"/></td>
                </tr>
            </table>
        </fieldset>
        <input type="hidden" name="${_csrf.parameterName}"
               value="${_csrf.token}"/>
    </form>

    <script type="text/javascript">
        document.getElementById('username_or_email').focus();
    </script>
</div>