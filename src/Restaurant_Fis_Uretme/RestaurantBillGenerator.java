package Restaurant_Fis_Uretme;

import java.util.Scanner;

public class RestaurantBillGenerator {

    public static void main(String[] args) {

        getSelectionMenu();


    }


    public static void getSelectionMenu(){
        Scanner scan=new Scanner(System.in);
        DishService dishService=new DishService();
OrderService orderService=new OrderService();


        int select=-1;
        do {
            System.out.println("-------------------------------------------------");
            System.out.println("***** Lezzet Restaurant Sipariş Uyggulaması *****");
            System.out.println("1-Menü");
            System.out.println("2-Sipariş Gir");
            System.out.println("3-Siparişi İptal Et");
            System.out.println("4-Hesap Oluştur");
            System.out.println("0-ÇIKIŞ");
            System.out.println("Seçiminiz:  ");
            select=scan.nextInt();
            System.out.println("-------------------------------------------------");
            switch (select){

                case 1://menü()
                    dishService.showMenu();
                    break;
                case 2://sipariş oluştur()
                    orderService.createOrder(dishService);
                    break;
                case 3://sipariş iptal()
                    orderService.deleteOrder();
                    dishService.showMenu();
                    break;
                case 4://hesap oluştur()
                    orderService.printBill();
                    break;
                case 0:
                    System.out.println("İyi günler dileriz");
                    break;
                default:
                    System.out.println("Hatalı Giriş yaptınız.Tekrar deneyiniz");
                break;

            }




        }while(select!=0);


    }
}
