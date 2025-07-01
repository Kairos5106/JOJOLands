package DSTeam3.source.PearlJam.base;

public class Customer {
    private String nameCustomer;
    private String age;
    private String gender;
    private String order;
    private int orderNumber;
    private String nameRestaurant; // restaurant specific identifier
    private int arrivalTime;

    // Constructor methods
    public Customer() {
        nameCustomer = null;
        age = null;
        gender = null;
        order = null;
        orderNumber = 0;
        nameRestaurant = null;
        arrivalTime = 0;
    }

    public Customer(String nameCustomer, String age, String gender) {
        this.nameCustomer = nameCustomer;
        this.age = age;
        this.gender = gender;
    }

    public Customer(String nameCustomer, String age, String gender, String order, int arrivalTime) {
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

    public String getAge() {
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

    public int getArrivalTime() {
        return arrivalTime;
    }

    // Mutator methods
    public void setnameCustomer(String nameCustomer) {
        this.nameCustomer = nameCustomer;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public void setOrderNumber(int number) {
        this.orderNumber = number;
    }

    public void setNameRestaurant(String nameRestaurant) {
        this.nameRestaurant = nameRestaurant;
    }

    public void setArrivalTime(int arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public String toString(){
        return String.format("%-30s" +
                            "%5s" +
                            "%10s" + 
                            "%40s" +
                            "%5s" +
                            "%3s", getNameCustomer(), getAge(), getGender(), getOrder(), getArrivalTime(), getOrderNumber());
    }
}
