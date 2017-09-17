import java.util.ArrayList;
import java.util.List;

    public class Company {

    private String name;
    private Adress adress;
    private List<Department> departments = new ArrayList<>();

    public Company (String name) {
        this.name = name;
        System.out.println("This is class Company");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Adress getAdress() {
        return adress;
    }

    public void setAdress(Adress adress) {
        this.adress = adress;
    }

    public List<Department> getDepartments() {
        return departments;
    }

    public void addDepartment(Department newDepartment) {
        departments.add(newDepartment);
        newDepartment.setCompany(this);
    }
}