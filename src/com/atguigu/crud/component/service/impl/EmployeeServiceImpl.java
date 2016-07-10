package com.atguigu.crud.component.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.atguigu.crud.component.dao.BaseDao;
import com.atguigu.crud.component.pojo.Department;
import com.atguigu.crud.component.pojo.Employee;
import com.atguigu.crud.component.service.EmployeeService;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private BaseDao baseDao;

	@Override
	public List<Employee> getEmpList() {
		return baseDao.getEmpList();
	}

	@Override
	public List<Department> getDeptList() {
		return baseDao.getDeptList();
	}

	@Override
	public void saveEmployee(Employee employee) {
		baseDao.saveEmployee(employee);
	}

	@Override
	public Employee getEmployeeById(Integer empId) {
		return baseDao.getEmployeeById(empId);
	}

	@Override
	public void updateEmployee(Employee employee) {
		baseDao.updateEmployee(employee);
	}

	@Override
	public void removeEmployee(Integer empId) {
		baseDao.removeEmployee(empId);
	}

}
