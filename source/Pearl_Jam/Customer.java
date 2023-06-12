package source.Pearl_Jam;
import java.util.Date;

public class Customer {
    private String nameCustomer;
    private int age;
    private String gender;
    private String order;
    private int orderNumber;
    private String nameRestaurant; // restaurant specific identifier
    private Date arrivalTime;

    // Constructor methods
    public Customer() {
        nameCustomer = null;
        age = 0;
        gender = null;
        order = null;
        orderNumber = 0;
        nameRestaurant = null;
        arrivalTime = null;
    }

    public Customer(String nameCustomer, int age, String gender, String order, Date arrivalTime) {
        this.nameCustomer = nameCustomer;
        this.age = age;
        this.gender = gender;
        this.order = order;
        this.arrivalTime = arrivalTime;
    }

    // Accessor methods
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

    public int getOrderNumber() {
        return orderNumber;
    }

    public String getNameRestaurant() {
        return nameRestaurant;
    }

    public Date getArrivalTime() {
        return arrivalTime;
    }

    // Mutator methods
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

    public void setOrderNumber() {
        this.orderNumber++;
    }

    public void setNameRestaurant(String nameRestaurant) {
        this.nameRestaurant = nameRestaurant;
    }

    public void setArrivalTime(Date arrivalTime) {
        this.arrivalTime = arrivalTime;
    }
}
