package Week4.Lecture;

class Customer {
    private String name;
    private String address;

    public Customer (String name, String address){
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return this.name;
    }
    public String getAddress() {
        return this.address;
    }
    public void setAddress(String address){
        this.address = address;
    }
}
class Order extends Customer {
    //private Customer customer;
    private String product;
    private String amount;

    public Order (String product, String amount, String name, String address) {
        super(name, address);
        this.product = product;
        this.amount = amount;
        //this.customer = customer;
    }

    public String getProduct() {
        return this.product;
    }
    public String getAmount() {
        return this.amount;
    }
    public String mailingAddress() {
        return this.getName() + "\n" + this.getAddress();
    }
}

