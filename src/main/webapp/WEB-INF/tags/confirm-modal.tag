<%@ tag language="java" pageEncoding="ISO-8859-1" %>
<%@ attribute name="title" required="true" rtexprvalue="true" %>
<%@ attribute name="message" required="true" rtexprvalue="true" %>
<%@ attribute name="route" required="true" rtexprvalue="true" %>


<div class="modal fade" id="customDeleteModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content" id="delete-frm">
            <div class="modal-header">
                <h4 class="modal-title" id="myModalLabel">${title}</h4>
                <button type="button" style="background: none; border: none; font-size: 2.3em; color:red;" class="close" data-dismiss="modal" aria-label="Fermer"><span aria-hidden="true">&times;</span></button>
            </div>
            <div class="modal-body">
                <div class="form-group col-md-12">
                    <h3> ${message}</h3>
                </div>
            </div>
            <div class="modal-footer">
                <a href="${pageContext.request.contextPath}/${route}?id=" class="btn btn-danger" data-dismiss="modal">Yes</a>
                <button class="btn btn-success" type="submit" >Cancel</button>
            </div>
        </div>
    </div>
</div>