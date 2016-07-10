package com.atguigu.crud.component.service;

import java.util.List;

import com.atguigu.crud.component.pojo.Department;
import com.atguigu.crud.component.pojo.Employee;

public interface EmployeeService {

	public List<Employee> getEmpList();

	public List<Department> getDeptList();

	public void saveEmployee(Employee employee);

	public Employee getEmployeeById(Integer empId);

	public void updateEmployee(Employee employee);

	public void removeEmployee(Integer empId);
}
