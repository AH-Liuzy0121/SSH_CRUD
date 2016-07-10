package com.atguigu.crud.component.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.atguigu.crud.component.pojo.Department;
import com.atguigu.crud.component.pojo.Employee;
import com.atguigu.crud.component.service.EmployeeService;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

@Controller
@Scope("prototype")
public class EmployeeAction implements RequestAware, ModelDriven<Employee>,
		Preparable {

	@Autowired
	private EmployeeService employeeService;
	private Map<String, Object> requestMap;
	private Employee employee;
	private Integer empId;

	// --------------------------------------------------------------------

	// 页面显示
	public String showEmpList() {
		List<Employee> empList = employeeService.getEmpList();
		requestMap.put("empList", empList);

		return "success";
	}

	//添加
	public String addUI() {
		List<Department> deptList = employeeService.getDeptList();
		requestMap.put("deptList", deptList);
		return "success";
	}

	//添加前准备
	public void prepareSaveEmp() {
		this.employee = new Employee();
	}

	public String saveEmp() {
		employeeService.saveEmployee(employee);
		return "success";
	}

	public void prepareEditEmp() {
		this.employee = employeeService.getEmployeeById(empId);
	}

	public String editEmp() {
		List<Department> deptList = employeeService.getDeptList();
		requestMap.put("deptList", deptList);
		return "success";
	}

	public void prepareUpdateEmp() {
		this.employee = new Employee();
	}

	public String updateEmp() {
		employeeService.updateEmployee(employee);
		return "success";
	}
	
	public String removeEmp(){
		employeeService.removeEmployee(empId);
		return "success";
	}

	// -----------------------------------------------------------------------

	@Override
	public void prepare() throws Exception {
		System.out.println("prepare........");
	}

	@Override
	public Employee getModel() {
		return this.employee;
	}

	@Override
	public void setRequest(Map<String, Object> request) {
		this.requestMap = request;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

}
