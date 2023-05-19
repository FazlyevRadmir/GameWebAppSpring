<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Edit User</title>
    <link rel="stylesheet" type="text/css" href="/css/adminEditUser.css">
</head>
<body>
<h1>Edit User</h1>
<form action="/admin/${user.id}/edit" method="post">
    <input type="hidden" name="_method" value="PUT">
    <label for="username">Username:</label>
    <input type="text" id="username" name="username" value="${user.username}">
    <label for="firstName">First Name:</label>
    <input type="text" id="firstName" name="firstName" value="${user.firstName}">
    <label for="secondName">Last Name:</label>
    <input type="text" id="secondName" name="secondName" value="${user.secondName}">
    <label for="email">Email:</label>
    <input type="email" id="email" name="email" value="${user.email}">
    <label for="phoneNumber">Phone Number:</label>
    <input type="text" id="phoneNumber" name="phoneNumber" value="${user.phoneNumber}">
    <button type="submit">Save</button>
</form>
</body>
</html>
