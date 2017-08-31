<%-- 
    Document   : tools
    Created on : 2017-7-11, 13:53:47
    Author     : anderson
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="../jquery/jquery-1.9.1.min.js" type="text/javascript"></script>
        <link href="../bootstrap-3.3.7/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <script src="../bootstrap-3.3.7/js/bootstrap.min.js" type="text/javascript"></script>
    </head>
    <body>
        <div class="modal fade" id="globeModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title" id="myModalLabel"></h4>
                    </div>
                    <div class="modal-body" id="modal_body">
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal" id="globeModalClose">Close</button>
                        <button type="button" class="btn btn-primary" onclick="doSubmit()">Save changes</button>
                    </div>
                </div>
            </div>
        </div>

        <div class="modal fade" id="messageModal" style=" display: none;">
            <div class="modal-dialog" >
                <div class="modal-content">
                    <div class="modal-header">
                        <h4 class="modal-title">Message</h4>
                    </div>
                    <div class="modal-body" id="message_modal_body">
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal" id="messageModalClose" >Close</button>
                    </div>
                </div>
            </div>
        </div>
    </body>
    <script>
        function showMessage(message, success_function) {
            $("#message_modal_body").text(message);
            $("#messageModalClose").attr("onclick", success_function);
            $("#messageModal").css({"display": "block"});
            $("#messageModal").attr("class", "in modal");
        }
        function hideMessage() {
            $("#messageModal").css({"display": "none"});
            $("#messageModal").attr("class", "");
        }

        function doSubmit() {
            $("#modal_body form").submit();
        }
        function closeGlobeModal() {
            $("#globeModalClose").click();
        }
    </script>
</html>
