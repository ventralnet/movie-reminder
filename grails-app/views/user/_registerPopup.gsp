<script>
$(document).ready(function() {
  $('#registrationSubmitButton').click(function(e){
    // We don't want this to act as a link so cancel the link action
    e.preventDefault();

    // Find form and submit it
    $('#registrationForm').submit();
  });
});
</script>

<!-- register modal --> 
<div id="registerModal" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
        <h3 id="myModalLabel">Register, its free!</h3>
    </div>
    
    <div id="registerFormContainer">
        <g:render template="/user/registerForm"></g:render>
    </div>

    <div class="modal-footer">
        <button class="btn" data-dismiss="modal" aria-hidden="true">Cancel</button>
        <button id="registrationSubmitButton" class="btn btn-primary">Register</button>
    </div>
</div>

