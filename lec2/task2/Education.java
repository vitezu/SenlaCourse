import java.util.Date;

public class Education {
    private String name;
    private Date dateBegin;
    private Date dateExpire;
    private String profession;

    public Education(String name, Date dateBegin, Date dateExpire, String profession) {
        this.name = name;
        this.dateBegin = dateBegin;
        this.dateExpire = dateExpire;
        this.profession = profession;
        System.out.println("This is class Education");
    }

    public String getName() {
        return name;
    }

    public Date getDateBegin() {
        return dateBegin;
    }

    public Date getDateExpire() {
        return dateExpire;
    }

    public String getProfession() {
        return profession;
    }
}
