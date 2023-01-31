<%@ page language="java" contentType="text/html; charset=UTF-8" 
import="io.openliberty.guides.ui.*"%>
<!DOCTYPE html>
<html>
<head>
    <title>Administrator</title>
</head>
<body>
    <h2>Administrator page</h2>
        <FORM METHOD="POST" ACTION="ibm_security_logout" NAME="logout">
          <input type="submit" name="logout" value="Log Out" />
          <input type="HIDDEN" name="logoutExitPage" value="/chapter1" />
        </FORM>
        Username: ${userBean.username} 
        Roles: ${userBean.roles}
</body>
</html>
