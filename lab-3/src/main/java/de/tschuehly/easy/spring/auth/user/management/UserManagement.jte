@import static de.tschuehly.easy.spring.auth.user.management.UserManagement.*
@import de.tschuehly.easy.spring.auth.user.management.UserManagement.UserManagementContext
@param UserManagementContext userManagementContext
<html lang="en">

<head>
    <title>Easy Spring Auth</title>
    <link rel="stylesheet" href="/css/sakura.css" type="text/css">
    <script src="/htmx_1.9.11.js"></script>
    <script src="/htmx_debug.js"></script>
    <script src="http://localhost:35729"></script>
</head>
<body hx-ext="debug">
<nav>
    <h1>
        Easy Spring Auth
    </h1>
</nav>
<main>
    ${userManagementContext.viewContext()}
</main>
</body>
<div id="${MODAL_CONTAINER_ID}" hx-on:$unsafe{CLOSE_MODAL_EVENT}="this.innerHTML = null">

</div>

</html>