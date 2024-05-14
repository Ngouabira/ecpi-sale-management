<%@ tag language="java" pageEncoding="ISO-8859-1" %>

<script>
    function showDeleteModal(route) {
        $('#btn-confirm-delete').prop('href', route);
        $('#customDeleteModal').modal('show');
    }
</script>

<div class="modal fade" id="customDeleteModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content" id="delete-frm">
            <div class="modal-header">
                <h4 class="modal-title" id="myModalLabel">Delete</h4>
                <button type="button" style="background: none; border: none; font-size: 2.3em; color:red;" class="close" data-dismiss="modal" aria-label="Fermer"><span aria-hidden="true">&times;</span></button>
            </div>
            <div class="modal-body">
                <div class="form-group col-md-12">
                    <h3> Do you really want to delete this item ?</h3>
                </div>
            </div>
            <div class="modal-footer">
                <a href="" class="btn btn-danger" id="btn-confirm-delete">Yes</a>
                <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
            </div>
        </div>
    </div>
</div>