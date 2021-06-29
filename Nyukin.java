import java.util.Scanner;

public class Nyukin {
    private int num;
    private int coin;

    public Nyukin() {
        System.out.print("どの紙幣・硬貨を入れますか？(1000/500/100/50/10)\n種類:");
        Scanner sc = new Scanner(System.in);
        int coin = 0, num = 0;
        coin = sc.nextInt();
        if (coin == 10 || coin == 50 || coin == 100 || coin == 500 || coin == 1000) {
            this.coin = coin;

            while (true) {
                System.out.print("何枚入れますか？\n枚数:");
                num = sc.nextInt();
                if (num >= 1 && num <= 200) {
                    if (Kanri.remaining >= 2000) {
                        System.out.println("投入可能な金額の上限は1990円です。返却します");
                        break;
                    }
                    System.out.println("投入金額は" + (coin * num) + "円です");
                    if (coin == 10) {
                        Kanri.num_10++;
                    } else if (coin == 50) {
                        Kanri.num_50++;
                    } else if (coin == 100) {
                        Kanri.num_100++;
                    } else if (coin == 500) {
                        Kanri.num_500++;
                    } else if (coin == 1000) {
                        Kanri.num_1000++;
                    }
                    Kanri.remaining += coin * num;
                    break;
                } else {
                    System.out.println("不正な入力です");
                }
            }
        } else {
            System.out.println("投入できない硬貨・紙幣です");
        }
    }

}
