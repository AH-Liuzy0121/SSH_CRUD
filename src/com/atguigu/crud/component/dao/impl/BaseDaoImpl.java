package com.atguigu.crud.component.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.metadata.ClassMetadata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.atguigu.crud.component.dao.BaseDao;
import com.atguigu.crud.component.pojo.Department;
import com.atguigu.crud.component.pojo.Employee;

@Repository
@SuppressWarnings("unchecked")
public class BaseDaoImpl implements BaseDao {

	@Autowired
	private SessionFactory sessionFactory;

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public List<Employee> getEmpList() {
		return getSession().createQuery(
				"form Employee e left join fetch e.department").list();
		// return getSession().createQuery("form Employee").list();
	}

	@Override
	public List<Department> getDeptList() {
		return getSession().createQuery("form Department").setCacheable(true)
				.list();
	}

	@Override
	public void saveEmployee(Employee employee) {
		getSession().save(employee);
	}

	@Override
	public Employee getEmployeeById(Integer empId) {
		return (Employee) getSession().get(Employee.class, empId);
	}

	@Override
	public void updateEmployee(Employee employee) {

		getSession().update(employee);
	}

	@Override
	public void removeEmployee(Integer empId) {
		ClassMetadata classMetadata = sessionFactory
				.getClassMetadata(Employee.class);
		String identifierPropertyName = classMetadata
				.getIdentifierPropertyName();
		String hql = "delete from Employee e where e." + identifierPropertyName
				+ "=?";
		Employee employee = new Employee();
		employee.setEmpId(empId);
		getSession().createQuery(hql).setInteger(0, empId).executeUpdate();
	}

}
