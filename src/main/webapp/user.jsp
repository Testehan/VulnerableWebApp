<%@ page language="java" contentType="text/html; charset=UTF-8" 
import="io.openliberty.guides.ui.*"%>
<!DOCTYPE html>
<head>
    <title>User</title>
</head>
<body>

    <%
       // Chapter 1 issue 2 fix
        // back button logins the user back in the app...which is bad..this is a possible solution
       // response.setHeader("Cache-Control","no-cache, no-store, must-revalidate");
       // response.setHeader("Pragma", "no-cache"); // Http 1.0
       // response.setHeader("Expires","0"); // proxies

    %>

    <h2>User page</h2>
    <br />
    <br />
   Welcome back ${userBean.username} !
    <br />
    <br />

   <FORM METHOD="POST" ACTION="ibm_security_logout" NAME="logout">
        <input type="submit" name="logout" value="Log Out" />
        <input type="HIDDEN" name="logoutExitPage" value="/home" />
   </FORM>

</body>
</html>
