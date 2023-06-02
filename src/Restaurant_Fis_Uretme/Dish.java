package Restaurant_Fis_Uretme;

public class Dish {

    private int code;
    private String name;
    private double price;



    public Dish(int code, String name, double price) {
        this.code = code;
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getCode() {
        return code;
    }

    public double getPrice() {
        return price;
    }


    @Override
    public String toString() {
        return
                "code= " + code +
                "name= " + name + '\'' +
                "price= " + price ;

    }
}
