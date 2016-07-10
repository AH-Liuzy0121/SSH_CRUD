<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<center>
		<form action="updateEmp">
			<s:textfield value="empName" label="姓名"/>
			<s:select label="部门" name="department.deptId"
				list="#request.deptList" listKey="deptId" listValue="deptName" />
			<br /> <br />

			<s:submit value="更新" />
		</form>
	</center>
</body>
</html>