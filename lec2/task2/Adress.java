public class Adress {
    private String street;
    private String city;
    private String country;
    private Integer phone;

    public Adress (String street, String city, String country, Integer phone) {
      this.street = street;
      this.city = city;
      this.country = country;
      this.phone = phone;
        System.out.println("This is class Adress");
    }

  public String getStreet() {
    return street;
}
  public String getCity (){
        return city;
}
    public String getCountry() {
        return country;
    }
    public Integer getPhone() {
        return phone;
    }
}