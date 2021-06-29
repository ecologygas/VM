import java.util.*;

public class Kounyu {
    public Kounyu() {
        Scanner sc = new Scanner(System.in);
        int buy;
        if (Kanri.num_10 < 5 || Kanri.num_50 < 5 || Kanri.num_100 < 5 || Kanri.num_500 < 5) {
            System.out.println("釣銭が不足しています");
        } else {
            for (int i = 0; i < Kanri.slot.length; i++) {
                System.out.print(i + "." + Kanri.slot[i].name + " " + Kanri.slot[i].price + "円 ");
                if (Kanri.slot[i].getButton_state() == 0) {
                    System.out.println("");
                } else if (Kanri.slot[i].getButton_state() == 1) {
                    System.out.println("購入可");
                } else if (Kanri.slot[i].getButton_state() == 2) {
                    System.out.println("売切");
                }
            }
            System.out.println("------------------");
            System.out.println("投入金額:" + Kanri.remaining);
            System.out.println("どの商品を購入しますか?(0/1/2/3/4)\n番号:");
            buy = sc.nextInt();

            if (buy >= 0 && buy <= 4) {
                if (Kanri.slot[buy].getButton_state() == 1) {
                    Haisyutsu.tumble_out(buy);
                    Kanri.remaining -= Kanri.slot[buy].price;
                    Henkyaku.repay();
                    Kanri.sales += Kanri.slot[buy].price;
                    Kanri.state = 0;
                }else if (Kanri.slot[buy].getButton_state() == 0 || Kanri.slot[buy].getButton_state() == 2){
                    System.out.println("購入可能な商品の番号を入力してください。");
                }
            } else {
                System.out.println("購入可能な商品の番号を入力してください。");
            }
        }
    }
}
