package org.tech.repository;
import org.tech.pojo.*;
import java.util.*;

public class EmployeeRepository {
	List list = new ArrayList();
	public int isAddEmployee(EmployeeDetails employee) {
		boolean b = false;
		for(Object obj:list) {
			EmployeeDetails e = (EmployeeDetails)obj;
			if(e.getId()==employee.getId()) {
				b=true;
				break;
			}
		}
		if(b) {
			return -1;
		}else {
			boolean x = list.add(employee);
			if(x) {
				return 1;
			}else {
				return 0;
			}
		}
	}
	public List getAllEmployees() {
		return list;
	}
	public EmployeeDetails getEmployee(String name , int id) {
		EmployeeDetails e1=null;
		for(Object obj:list) {
			EmployeeDetails e = (EmployeeDetails)obj;
			if(e.getId()==id || e.getName().equals(name) ) {
				e1 = e;
				break;
			}
		}
		return e1;
	}
	public List getEmployeeBySalary(int salary) {
		List li = new ArrayList();
		for(Object obj:list) {
			EmployeeDetails e = (EmployeeDetails)obj;
			if(e.getSalary()==salary) {
				li.add(e);
			}
		}
		return li;
	}
	public boolean isDelete(int id) {
		for(Object obj:list) {
			EmployeeDetails e = (EmployeeDetails)obj;
			if(e.getId()==id) {
				list.remove(e);
				return true;
			}
		}
		return false;
	}
	public EmployeeDetails updateEmployee(EmployeeDetails employee,int id) {
		EmployeeDetails e1 = null;
		int i=0;
		for(Object obj:list) {
			EmployeeDetails e = (EmployeeDetails)obj;
			if(e.getId()==id) {
				list.set(i, employee);	
				e1=e;
			}
			i++;
		}
		return e1;
	}
	public List getEmployeeByDesignation(String Designation) {
		List li = new ArrayList();
		for(Object obj:list) {
			EmployeeDetails e = (EmployeeDetails)obj;
			if(e.getDesignation().equals(Designation)) {
				li.add(e);
			}
		}
		return li;
	}
	
	public float getAverageEmployeeSalary() {
		float i=0;
		float sum=0;
		for(Object obj:list) {
			EmployeeDetails e = (EmployeeDetails)obj;
			sum = sum + (float)e.getSalary();
			i++;
		}
		float avg = sum/i;
		return avg;
	}
	public EmployeeDetails getEmployeeWhoseSalaryIsMax() {
		int max = Integer.MIN_VALUE;
		EmployeeDetails e1 = null;
		for(Object obj:list) {
			EmployeeDetails e = (EmployeeDetails)obj;
			
			if(e.getSalary()>max) {
				max = e.getSalary();
			}
		}
		for(Object obj:list) {
			EmployeeDetails e = (EmployeeDetails)obj;
			
			if(e.getSalary()==max) {
				e1 = e;
				break;
			}
		}	
		return e1;
	}
	public EmployeeDetails getEmployeeWhoseSalaryIsSecondMax() {
		int max = Integer.MIN_VALUE;
		int secmax =Integer.MIN_VALUE;
		EmployeeDetails e1 = null;
		for(Object obj:list) {
			EmployeeDetails e = (EmployeeDetails)obj;
			
			if(e.getSalary()>max) {
				secmax = max;
				max = e.getSalary();
				
			}
			else if(e.getSalary()>secmax && e.getSalary()<max ){
				secmax=e.getSalary();
			}
		}
		for(Object obj:list) {
			EmployeeDetails e = (EmployeeDetails)obj;
			
			if(e.getSalary()==secmax) {
				e1 = e;
				break;
			}
		}	
		return e1;
	}

}
