import java.util.ArrayList;
import java.util.List;

  public class Department {

    private String name;
    private List<Employee> employes = new ArrayList<>();
    private Company company;

    public Department (String name) {
        this.name = name;
        System.out.println("This is class Department");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Employee> getEmployes() {
        return employes;
    }

    public void addEmployee(Employee employee) {
        this.employes.add(employee);
    }

    public void deleteEmployee (Employee employee) {
        employee = null;
    }
    public void setCompany(Company company) {
        this.company = company;
    }
}
