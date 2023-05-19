<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Confirm Delete User</title>
    <link rel="stylesheet" type="text/css" href="/css/adminDeleteUser.css">
</head>
<body>
<h1>Confirm Delete User</h1>
<p>Are you sure you want to delete this user?</p>
<form action="/admin/${user.id}/delete" method="post">
    <input type="hidden" name="_method" value="DELETE">
    <button type="submit">Delete</button>
    <a href="/admin">Cancel</a>
</form>
</body>
</html>
