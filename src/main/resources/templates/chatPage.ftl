<#--<html lang="en">-->
<#--<head>-->
<#--    <meta charset="UTF-8">-->
<#--    <title>Chat</title>-->
<#--    <link rel="stylesheet" type="text/css" href="/css/chat.css">-->
<#--    <link rel="stylesheet"  href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-alpha1/dist/css/bootstrap.min.css">-->
<#--    <link rel="stylesheet"  href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">-->
<#--    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>-->
<#--    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>-->
<#--<body>-->
<#--<div class="container height-100 d-flex justify-content-center align-items-center"> <div class="card p-3"> <h5>Write your message</h5> <textarea id="textarea" class="form-control" onkeydown="specialText(this, event)"> </textarea> <div class="mt-3 d-flex justify-content-between align-items-center"> <span id="count"></span> <button class="btn btn-sm btn-danger">Submit</button> </div> </div>-->
<#--</div>-->
<#--<script src = "/js/chat.js"></script>-->
<#--</body>-->
<#--</html>-->


<!DOCTYPE html>
<html>
<head>
    <title>WebSocket Chat</title>
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <script>
        $(document).ready(function() {
            var socket = new WebSocket("ws://localhost:8080/chat");

            socket.onmessage = function(event) {
                var message = event.data;
                $("#chatMessages").append("<p>" + message + "</p>");
            }

            $("#chatForm").submit(function(event) {
                event.preventDefault();
                var message = $("#messageInput").val();
                socket.send(message);
                $("#messageInput").val("");
            });
        });
    </script>
</head>
<body>
<h1>WebSocket Chat</h1>
<div id="chatMessages"></div>
<form id="chatForm">
    <input type="text" id="messageInput" required/>
    <input type="submit" value="Send"/>
</form>
</body>
</html>
