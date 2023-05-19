<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Create User</title>
    <link rel="stylesheet" type="text/css" href="/css/adminCreateUser.css">
</head>
<body>
<h1>Create User</h1>
<form action="/admin/create" method="post">
    <label for="username">Username:</label>
    <input type="text" id="username" name="username">
    <label for="firstName">First Name:</label>
    <input type="text" id="firstName" name="firstName">
    <label for="password">Password:</label>
    <input type="text" id="password" name="password">
    <label for="secondName">Last Name:</label>
    <input type="text" id="secondName" name="secondName">
    <label for="email">Email:</label>
    <input type="email" id="email" name="email">
    <label for="phoneNumber">Phone Number:</label>
    <input type="text" id="phoneNumber" name="phoneNumber">
    <button type="submit">Save</button>
</form>
</body>
</html>
