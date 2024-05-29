 import java.util.Scanner;
 import java.util.ArrayList;
 abstract class Employee
 {
 	private String name;
 	private int id;
 	public Employee(String name,int id) 	
 	{
 		this.name=name;
 		this.id=id;
 	}
 	public String getName()
 	{
 		return name;
 	}
 	public int getId()
 	{
 		return id;
 	}
 	 	public abstract double salaryCalculatar();
 		public String employeeDetails(){
 		return "Employee[name = "+name+", ID = " +id+", Salary = "+salaryCalculatar()+" ]";
 	}
 }
 class FullTimeEmployee extends Employee
 {
 	private double monthlySalary;
 	public FullTimeEmployee(String name,int id,double monthlySalary)
 	{
 		super(name,id);
 		this.monthlySalary=monthlySalary;
 	}
 	@Override
 	public double salaryCalculatar()
 	{
 		return monthlySalary;
 	}
 }
 class PartTimeEmployee extends Employee
 {
 	private double hoursWorkd;
 	private double hoursRate;
 	public PartTimeEmployee(String name,int id,double hoursWorkd,double hoursRate)
 	{
 		super(name,id);
 		this.hoursWorkd=hoursWorkd;
 		this.hoursRate=hoursRate;
 	}
 	@Override
 	public double salaryCalculatar()
 	{
 		return (hoursRate*hoursWorkd);
 	}
 }
 class PayrollSystem{
 	private ArrayList<Employee> arrayList;
 	public PayrollSystem()
 	{
 		arrayList=new ArrayList<Employee>();
 	}
 	public void addEmployee(Employee employee)
 	{
 		arrayList.add(employee);
 	}
 	public void removeEmployee(int id){
 		Employee employeeToRemove=null;
 		for (Employee employee : arrayList ) 
 		{
 			if (employee.getId()==id) 
 			{
 				employeeToRemove=employee;
 				break;
 			}
 		}
 		if (employeeToRemove!=null) 
 		{
 			arrayList.remove(employeeToRemove);
 		}
 	}
 	public void diplayEmployees()
 	{
 		for (Employee employee : arrayList ) 
 		{
 			System.out.println(employee.employeeDetails());
 		}
 	}
}
class Main 
{	
	public static void menu()
	{
		System.out.println("============ MENU ============");
		System.out.println("1. Add Full Time Employee.");
		System.out.println("2. Add Part Time Employee.");
		System.out.println("3. Remove Employee");
		System.out.println("4. Diplay Details of Employees");
		System.out.println("============ Exit 0 ==========");

	}
	public static void main(String[] args) 
	{
		Scanner scr=new Scanner(System.in);
		PayrollSystem payrollSystem=new PayrollSystem();
		FullTimeEmployee fullTimeEmployee[]=new FullTimeEmployee[5];
		PartTimeEmployee partTimeEmployee[]=new PartTimeEmployee[5];
		int fullTimeEmployee_count=0;
		int partTimeEmployee_count=0;
		int cho=100;
		while (cho!=0) 
		{
			menu();
			cho=scr.nextInt();
			while (cho!=9 && cho!=0) 
			{
				switch (cho) 
				{
					case 1 : scr.nextLine();
							 System.out.print("Enter Employee name :");
							 String name=scr.nextLine();
							 System.out.print("Enter Employee ID :");
							 int id=scr.nextInt();
							 System.out.print("Enter Employee Salary:");
							 int salary=scr.nextInt();
							 fullTimeEmployee[fullTimeEmployee_count]=new FullTimeEmployee(name,id,salary);
							 payrollSystem.addEmployee(fullTimeEmployee[fullTimeEmployee_count]);
							 fullTimeEmployee_count++;
							 System.out.println("Successfully add employee Id :"+id);
						 	 System.out.println("1. Add Full Time Employee.");
						 	 System.out.println("9. Go back to main menu.");
						 	 cho=scr.nextInt();
						 	 break;
					case 2 : scr.nextLine();
							 System.out.print("Enter Employee name :");
							 String name1=scr.nextLine();
							 System.out.print("Enter Employee ID :");
							 int id1=scr.nextInt();
							 System.out.print("Enter Employee Work hours:");
							 int hoursWorkd1=scr.nextInt();
							 System.out.print("Enter Employee Work Rate :");
							 int hoursRate1=scr.nextInt();
							 partTimeEmployee[partTimeEmployee_count]=new PartTimeEmployee(name1,id1,hoursWorkd1,hoursRate1);
							 payrollSystem.addEmployee(partTimeEmployee[partTimeEmployee_count]);
							 fullTimeEmployee_count++;
							 System.out.println("Successfully add employee Id :"+id1);
						 	 System.out.println("1. Add Part Time Employee.");
						 	 System.out.println("9. Go back to main menu.");
						 	 cho=scr.nextInt();
						 	 break;
					case 3 : System.out.print("Enter Employee id : ");
							 int id2 =scr.nextInt();
							 payrollSystem.removeEmployee(id2);
							 System.out.println("Successfully remove employee Id :"+id2);
							 System.out.println("3.Remove Employee");
							 System.out.println("9. Go back to main menu.");
							 cho=scr.nextInt();
							 break;
					case 4 : payrollSystem.diplayEmployees();
							 System.out.println("9. Go back to main menu.");
							 cho=scr.nextInt();
							 break;
					default: System.out.println("Enter a valid Input ");
							 break;
							
					}
				}
			}
			scr.close();
		}
	}
