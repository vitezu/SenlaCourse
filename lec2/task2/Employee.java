import java.util.ArrayList;
import java.util.List;

public class Employee {
    private Integer idEmployee;
    private String name;
    private String surname;
    private Integer age;
    private String position;
    private List<Education> educations = new ArrayList<>();
    private Adress adress;

    public Employee(Integer idEmployee, String name, String surname, Integer age) {
        this.idEmployee = idEmployee;
        this.name = name;
        this.surname = surname;
        this.age = age;

        System.out.println("This is class Employee");
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Integer getIdEmployee() {
        return idEmployee;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Integer getAge() {
        return age;
    }

    public List<Education> getEducations() {
        return educations;
    }

    public void addEducations(Education education) {
        this.educations.add(education);
    }

    public Adress getAdress() {
        return adress;
    }

    public void setAdress(Adress adress) {
        this.adress = adress;
    }

}
