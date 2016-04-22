<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<script>
    function showCreditCardField() {
        var ccNumberStyle = document.paymentForm.creditCardNumber.style;
        ccNumberStyle.visibility = 'visible';
    }

    function hideCreditCardField() {
        var ccNumberStyle = document.paymentForm.creditCardNumber.style;
        ccNumberStyle.visibility = 'hidden';
    }
</script>

<h2>Take Payment</h2>
<form:form commandName="paymentDetails" name="paymentForm">
    <input type="hidden" name="_flowExecutionKey"
           value="${flowExecutionKey}"/>

    <!--  只有支付方式选择 CREDIT_CARD 的时候,才会显示卡号输入框,否则不可见 -->
    <form:radiobutton path="paymentType"
                      value="CASH" label="Cash (taken at delivery)"
                      onclick="hideCreditCardField()"/><br/>
    <form:radiobutton path="paymentType"
                      value="CHECK" label="Check (taken at delivery)"
                      onclick="hideCreditCardField()"/><br/>
    <form:radiobutton path="paymentType"
                      value="CREDIT_CARD" label="Credit Card:"
                      onclick="showCreditCardField()"/>


    <form:input path="creditCardNumber"
                cssStyle="visibility:hidden;"/>

    <br/><br/>
    <input type="submit" class="button"
           name="_eventId_paymentSubmitted" value="Submit"/>
    <input type="submit" class="button"
           name="_eventId_cancel" value="Cancel"/>
</form:form>
</div>
