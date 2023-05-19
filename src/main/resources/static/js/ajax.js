// $(document).ready(function () {
//     if(window.location.pathname == "/registration") {
//         $("#usernameID").keyup(function () {
//             $.ajax({
//                 type: 'GET',
//                 url: "checkUsername",
//                 data: {username: $("#usernameID").val()},
//                 success: function (result) {
//                     if (result.trim() === 'false') {
//                         $('#username_error').text(""); // очищаем текст ошибки
//                         document.getElementById("submitbtn").removeAttribute("disabled");
//                     } else {
//                         document.getElementById("submitbtn").setAttribute("disabled", "disabled");
//                         $('#username_error').text("Username already registered");
//                         document.getElementById('username_error').style.color = "red";
//                     }
//                 },
//                 error: function (result) {
//                     console.log(result);
//                 }
//             });
//         });
//     }
// });
$(document).ready(function () {
    if(window.location.pathname == "/registration") {
        $("#usernameID").keyup(function () {
            $.ajax({
                type: 'GET',
                url: "checkUsername",
                data: {username: $("#usernameID").val()},
                beforeSend: function(xhr) {
                    xhr.setRequestHeader('X-CSRF-TOKEN', $("#_csrf").val());
                },
                success: function (result) {
                    if (result.trim() === 'false') {
                        $('#username_error').text(""); // очищаем текст ошибки
                        document.getElementById("submitbtn").removeAttribute("disabled");
                    } else {
                        document.getElementById("submitbtn").setAttribute("disabled", "disabled");
                        $('#username_error').text("Username already registered");
                        document.getElementById('username_error').style.color = "red";
                    }
                },
                error: function (result) {
                    console.log(result);
                }
            });
        });
    }
});
