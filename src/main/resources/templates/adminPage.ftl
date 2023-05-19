<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>User List</title>
    <link rel="stylesheet" type="text/css" href="/css/adminPage.css">
</head>
<body>
<h1>User List</h1>
<table>
    <thead>
    <tr>
        <th>Username</th>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Email</th>
        <th>Phone Number</th>
        <th>Actions</th>
    </tr>
    </thead>
    <tbody>
    <#list users as user>
        <tr>
            <td>${user.username}</td>
            <td>${user.firstName}</td>
            <td>${user.secondName}</td>
            <td>${user.email}</td>
            <td>${user.phoneNumber}</td>
            <td>
                <a href="/admin/${user.id}/edit">Edit</a>
                <a href="/admin/${user.id}/delete">Delete</a>
            </td>
        </tr>
    </#list>
    </tbody>
</table>
<a href="/admin/create">Add New User</a>
</body>
</html>
