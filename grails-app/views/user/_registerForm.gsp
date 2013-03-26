<script>
$(document).ready(function() {
  $('#registrationSubmitButton').click(function(e){
    e.preventDefault();
    // Find form and submit it
    $('#registrationForm').submit();
  });

});
</script>

<div id="formContents" class="modal-body">
    <g:formRemote id="registrationForm"  update="registerFormContainer" name="registerForm" url="[controller:'user',action:'register']" class="form-horizontal">
        <legend>We will just need a couple pieces of info!</legend>
        <g:set var="errorClass" value=""/>
        <g:if test="${urc?.hasErrors() && urc?.errors['email']}">
            <g:set var="errorClass" value="error"/>
        </g:if>
        <div class="control-group ${errorClass}"> 
            <label class="control-label">Email</label>
            <div class="controls">
                <input name="email" value="${urc?.email}" type="email" required placeholder="me@me.com"/>
                <span class="help-inline"><g:hasErrors bean="${urc}"><g:message error="${urc.errors['email']}"/></g:hasErrors></span>
            </div>
        </div>
        <g:set var="errorClass" value=""/>
        <g:if test="${urc?.hasErrors() && urc?.errors['firstName']}">
            <g:set var="errorClass" value="error"/>
        </g:if>
        <div class="control-group ${errorClass}"> 
            <label class="control-label">First Name</label>
            <div class="controls">
                <input name="firstName" value="${urc?.firstName}" type="text" placeholder="First name..."/>
                <span class="help-inline"><g:hasErrors bean="${urc}"><g:message error="${urc.errors['firstName']}"/></g:hasErrors></span>
            </div>
        </div>
        <g:set var="errorClass" value=""/>
        <g:if test="${urc?.hasErrors() && urc?.errors['lastName']}">
            <g:set var="errorClass" value="error"/>
        </g:if>
        <div class="control-group ${errorClass}"> 
            <label class="control-label">Last Name</label>
            <div class="controls">
                <input name="lastName" value="${urc?.lastName}" type="text" placeholder="Last name..."/>
                <span class="help-inline"><g:hasErrors bean="${urc}"><g:message error="${urc.errors['lastName']}"/></g:hasErrors></span>
            </div>
        </div>
        <g:set var="errorClass" value=""/>
        <g:if test="${urc?.hasErrors() && urc?.errors['password']}">
            <g:set var="errorClass" value="error"/>
        </g:if>
        <div class="control-group ${errorClass}"> 
            <label class="control-label">Password</label>
            <div class="controls">
                <input name="password" value="${urc?.password}" type="password" placeholder="password..."/>
                <span class="help-inline"><g:hasErrors bean="${urc}"><g:message error="${urc.errors['password']}"/></g:hasErrors></span>
            </div>
        </div>
        <g:set var="errorClass" value=""/>
        <g:if test="${urc?.hasErrors() && urc?.errors['passwordConfirm']}">
            <g:set var="errorClass" value="error"/>
        </g:if>
        <div class="control-group ${errorClass}"> 
            <label class="control-label">Password Verification</label>
            <div class="controls">
                <input name="passwordConfirm" value="" type="password" placeholder="password verification..."/>
                <span class="help-inline"><g:hasErrors bean="${urc}"><g:message error="${urc.errors['passwordConfirm']}"/></g:hasErrors></span>
            </div>
        </div>
    </g:formRemote>
</div>

