import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int menu;
        new Kanri();
        while(true){
            Kanri.reflesh_button();
            System.out.println("------------------------\nメニュー表示");
            for(int i=0; i<Kanri.slot.length; i++){
                System.out.print("・"+Kanri.slot[i].name+" "+Kanri.slot[i].price+" ");
                if (Kanri.slot[i].getButton_state() == 0) {
                    System.out.println("");
                } else if (Kanri.slot[i].getButton_state() == 1) {
                    System.out.println("購入可");
                } else if (Kanri.slot[i].getButton_state() == 2) {
                    System.out.println("売切");
                }
            }
            System.out.println("------------------------");
            System.out.println("0.入金 1.購入 2.返金 3.管理者モード 4.終了\n番号を入力してください");
            menu = sc.nextInt();
            if(menu == 0){
                new Nyukin();
            }else if(menu == 1){
                new Kounyu();
            }else if(menu == 2){
                Henkyaku.repay();
            }else if(menu == 3){
                Kanri.kanri_Mode();
            }else if(menu == 4){
                break;
            }
        }
        sc.close();
    }    
}
