package Restaurant_Fis_Uretme;

public class Order {
    public static int count=999;
    public int orderCode;
    public int numberOfDish;
    public double orderPrice;
    public Dish dish;

    public Order(Dish dish,int numberOfDish){
        count++;
        this.orderCode=count;
        this.dish=dish;
        this.numberOfDish=numberOfDish;
    }

    public void setPrice(){
        this.orderPrice=this.dish.getPrice()*this.numberOfDish;

    }

}
