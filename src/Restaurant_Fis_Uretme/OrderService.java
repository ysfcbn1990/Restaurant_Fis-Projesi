package Restaurant_Fis_Uretme;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OrderService {
Scanner inp=new Scanner(System.in);
List<Order> orderList=new ArrayList<>();

public void createOrder(DishService dishService){
    int dishcode;
    do{
        System.out.println("Lütfen ürün kodu giriniz:\nÇIKIŞ için 0 giriniz.");
        dishcode=inp.nextInt();
        if(dishService.findByDishCode(dishcode)!=null){
            Dish dish=dishService.findByDishCode(dishcode);
            System.out.println("Adet giriniz");
            int number=inp.nextInt();
            Order order;
            if(findbyOrderByDish(dish)!=null){
                order=findbyOrderByDish(dish);
                order.numberOfDish+=number;
                order.setPrice();
            }else{
                order=new Order(dish,number);
                order.setPrice();
                this.orderList.add(order);
            }
        }
        listOrders();


    }while(dishcode!=0);
}

    private void listOrders() {
        this.orderList.forEach(order-> System.out.printf("Sipariş kodu:%-5s  LezzetKodu:%-4s  Lezzet adı:%-15s  Adet:%-2s\n",
                order.orderCode,order.dish.getCode(),order.dish.getName(),order.numberOfDish));
    }

    private Order findbyOrderByDish(Dish dish){
    for(Order order:this.orderList){
        if(order.dish.equals(dish)){
            return order;
        }
    }
    return null;
}
public void deleteOrder(){
    System.out.println("İptal etmek istediğiniz siparişin kodunu giriniz");
    int code=inp.nextInt();
    boolean isValid=true;
    for(Order order:this.orderList){
        if(order.orderCode==code){
            System.out.println("iptal etmek istediğiniz miktarı giriniz");
            int num=inp.nextInt();
            if(order.numberOfDish>num){
                order.numberOfDish-=num;
                order.setPrice();
                System.out.println("siparişiniz iptal edildi"+order.dish.getName());
            }else if(order.numberOfDish==num){
                this.orderList.remove(order);
                System.out.println("Sipparişiniz iptal edildi"+order.dish.getName());
            }else{
                System.out.println("Hatalı giriş");
            }
            isValid=true;
            break;
        }else{
            isValid=false;

        }
    }
    if(!isValid){
        System.out.println("Sipariş kodu geçersiz!!");
    }
}
public void printBill(){
    double total=0;
    System.out.println("                  Lezzet Fişiniz                ");
    for(Order order:this.orderList){
        System.out.printf("Sipariş kodu:%-6s      Lezzet kodu:%-5s     Lezzet adı:%-15s   Adet:%-2s  Tutar:%-6s Lira\n",
                order.orderCode,order.dish.getCode(),order.dish.getName(),order.numberOfDish,order.orderPrice);
        total+=order.orderPrice;
    }
    System.out.println("Toplam Tutar :"+total);
    System.out.println("Afiyet olsun...");
    this.orderList.clear();

}



}
