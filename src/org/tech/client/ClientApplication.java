package org.tech.client;
import java.util.*;
import org.tech.pojo.*;
import org.tech.repository.*;

public class ClientApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EmployeeRepository emprepo = new EmployeeRepository();
		do {
			Scanner sc = new Scanner(System.in);
			System.out.println("\n\n");
			System.out.println("1:Add New Employee");
			System.out.println("2:View All Employee");
			System.out.println("3:Search Employee By Name or Id");
			System.out.println("4:find employee list by salary");
			System.out.println("5:delete employee data by id");
			System.out.println("6:update the data at specified id");
			System.out.println("7:average salary of employee");
			System.out.println("8:find max salary employee");
			System.out.println("9:find second max salary employee");
			System.out.println("10:find employee list by designation\n\n");
			System.out.println("enter the choice\n");
			int choice = sc.nextInt();
			switch(choice) {
			       case 1:sc.nextLine();
			              System.out.println("enter name ,designation ,id and salary\n");
			              String name = sc.nextLine();
						  String designation = sc.nextLine();
						  int id = sc.nextInt();
						  int salary = sc.nextInt();

			              EmployeeDetails e = new EmployeeDetails();
			              e.setId(id);
			              e.setName(name);
			              e.setSalary(salary);
			              e.setDesignation(designation);
			              int result = emprepo.isAddEmployee(e);
			              if(result==-1) {
			            	  System.out.println("Employee already exists");
			              }else if(result==1) {
			            	  System.out.println("Employee added successfully-------");
			              }else {
			            	  System.out.println("some problem is there-------");
			              }
			       break; 
			       case 2:List list = emprepo.getAllEmployees();
			              if(list.size()>0) {
			            	  for(Object obj:list) {
				            	  EmployeeDetails e1 = (EmployeeDetails)obj;
				            	  
				            	  System.out.println(e1.getId()+" "+e1.getName()+" "+e1.getSalary()+" "+e1.getDesignation());
				              }
			              }else {
			            	  System.out.println("data not found");
			              }
			       break;  
			       case 3:System.out.println("enter the id and name");
			              int id1=sc.nextInt();
			              String name1=sc.next();
			              EmployeeDetails e1 = emprepo.getEmployee(name1, id1);
			              if(e1!=null) {
			            	  System.out.println(e1.getId()+" "+e1.getName()+" "+e1.getSalary()+" "+e1.getDesignation());
			              }else {
			            	  System.out.println("data not found");
			              }
			       break;
			       case 4:System.out.println("enter the salary");
			              salary = sc.nextInt();
			              List list1 = emprepo.getEmployeeBySalary(salary);
			              if(list1.size()>0) {
			            	  for(Object obj:list1) {
				            	  EmployeeDetails e2 = (EmployeeDetails)obj;
				            	  System.out.println(e2.getId()+" "+e2.getName()+" "+e2.getSalary()+" "+e2.getDesignation());
				              }
			              }else {
			            	  System.out.println("no employee found");
			              }
			              
			       break;
			       case 5:System.out.println("enter the id u want to delete");
		                  id1 = sc.nextInt();
			              boolean b = emprepo.isDelete(id1);
			              if(b) {
			            	  System.out.println("data deleted");
			              }else {
			            	  System.out.println("data not found");
			              }
			       break;
			       case 6:sc.nextLine();
			    	     System.out.println("enter name ,designation ,id and salary\n");
		                 String name2 = sc.nextLine();
					     String designation2 = sc.nextLine();
					     int id2 = sc.nextInt();
					     int salary2 = sc.nextInt();
					     System.out.println("enter the id u want to update");
		                 id1 = sc.nextInt();
		                 EmployeeDetails e2 = new EmployeeDetails();
		                 e2.setId(id2);
		                 e2.setName(name2);
		                 e2.setSalary(salary2);
		                 e2.setDesignation(designation2);
			              
			          EmployeeDetails ed2 = emprepo.updateEmployee(e2, id1);
			          if(ed2!=null) {
			        	  System.out.println("updated successfully----->");
			          }else {
			        	  System.out.println("not found data-->");
			          }
			       break;
			       case 7:float avg = emprepo.getAverageEmployeeSalary();
			    		  System.out.println("average salary is = "+avg);
			       break;
			       case 8:ed2 = emprepo.getEmployeeWhoseSalaryIsMax();
			              if(ed2!=null) {
			            	  System.out.println("max salary employee details");
			            	  System.out.println(ed2.getId()+" "+ed2.getName()+" "+ed2.getSalary()+" "+ed2.getDesignation());
			              }else {
			            	  System.out.println("data not found");
			              }
			       break;
			       case 9:ed2=emprepo.getEmployeeWhoseSalaryIsSecondMax();
			              if(ed2!=null) {
		            	     System.out.println("secondmax salary employee details");
		            	     System.out.println(ed2.getId()+" "+ed2.getName()+" "+ed2.getSalary()+" "+ed2.getDesignation());
		                  }else {
		            	      System.out.println("data not found");
		                  }
			        break;
			       case 10:System.out.println("enter the designation");
			               sc.nextLine();
		                   String designation1 = sc.nextLine();
		                   List list2 = emprepo.getEmployeeByDesignation(designation1);
		                    if(list2.size()>0) {
		                    	
		            	       for(Object obj:list2) {
			            	        e2 = (EmployeeDetails)obj;
			            	        System.out.println(e2.getId()+" "+e2.getName()+" "+e2.getSalary()+" "+e2.getDesignation());
			                   }
		                    }
		                    else {
		            	       System.out.println("no employee found");
		                    }
		            break;
		    }
		}while(true);

	}

}
