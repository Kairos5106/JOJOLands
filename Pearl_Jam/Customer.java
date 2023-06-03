package Pearl_Jam;

public class Customer {
    private String nameCustomer;
    private int age;
    private String gender;
    private String order;
    private String nameRestaurant;

    // constructor method
    public Customer() {
        nameCustomer = null;
        age = 0;
        gender = null;
        order = null;
        nameRestaurant = null;
    }

    public Customer(String nameCustomer, int age, String gender, String order) {
        this.nameCustomer = nameCustomer;
        this.age = age;
        this.gender = gender;
        this.order = order;
        this.nameRestaurant = nameRestaurant;
    }

    // accessor methods
    public String getNameCustomer() {
        return nameCustomer;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String getOrder() {
        return order;
    }

    public String getNameRestaurant() {
        return nameRestaurant;
    }

    // mutator methods
    public void setnameCustomer(String nameCustomer) {
        this.nameCustomer = nameCustomer;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public void setNameRestaurant(String nameRestaurant) {
        this.nameRestaurant = nameRestaurant;
    }
}
