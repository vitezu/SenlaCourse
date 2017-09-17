import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Run {
    public static void main(String[] args) throws ParseException {

        //Create Adress object
        Adress adress = new Adress ("Kosmonavtov", "Grodno", "Belarus", 33-55-77);
        Adress adressCompany = new Adress ("Pushkina", "Grodno", "Belarus", 55-55-77);

        //Create Education object
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Education education1 = new Education ("GrGU", formatter.parse("2012-01-01"), formatter.parse("2016-01-01"), "economic");
        Education education2 = new Education ("BNTU", formatter.parse("2008-01-01"), formatter.parse("2011-01-01"), "engineer");
       
	 //Create Employee object
        Employee employee = new Employee(1, "Ivan", "Ivanov", 25);
        employee.setPosition("Director");
        employee.addEducations(education1);
        employee.addEducations(education2);
        employee.setAdress(adress);
      
	  //Create Department object
        Department department = new Department("Marketing");
        department.addEmployee(employee);
     
	  //Create Company object
        Company company = new Company("Hitachi");
        company.setAdress(adressCompany);
        company.addDepartment(department);
    }
}
