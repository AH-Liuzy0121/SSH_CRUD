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
		<table border="1">
			<s:if test="#request.empList == null \\ #request.empList.empty">
				<h1>没有员工信息</h1>
			</s:if>
			<s:else>
				<tr>
					<th>ID</th>
					<th>姓名</th>
					<th>所属部门</th>
					<th>更新</th>
					<th>删除</th>
				</tr>
				<s:iterator value="#request.empList">
					<tr>
						<td><s:property value="empId"/></td>
						<td><s:property value="empName"/></td>
						<td><s:property value="department.deptName"/></td>
						<td><s:a action="editUI?empId=%{empId}">更新</s:a></td>
						<td><s:a action="removeEmp?empId=%{empId}">删除</s:a></td>
						<td></td>
					</tr>
				</s:iterator>
			</s:else>
		</table>
	</center>
	
	<a href="addUI.action">添加员工信息</a>
</body>
</html>