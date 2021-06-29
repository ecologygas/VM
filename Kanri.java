import java.util.*;

public class Kanri {
    public static int state = 0;
    public static int remaining = 0;
    public static int sales = 0;
    public static int num_10 = 100;
    public static int num_50 = 50;
    public static int num_100 = 100;
    public static int num_500 = 20;
    public static int num_1000 = 0;
    public static Slot[] slot = new Slot[5];

    public Kanri() {
        for (int i = 0; i < slot.length; i++) {
            slot[i] = new Slot();
        }
        slot[0].name = "オレンジジュース";
        slot[0].price = 150;
        slot[0].setStock(5);
        slot[0].button_off();

        slot[1].name = "ぶどうジュース";
        slot[1].price = 130;
        slot[1].setStock(5);
        slot[1].button_off();

        slot[2].name = "りんごジュース";
        slot[2].price = 120;
        slot[2].setStock(5);
        slot[2].button_off();

        slot[3].name = "お茶";
        slot[3].price = 110;
        slot[3].setStock(5);
        slot[3].button_off();

        slot[4].name = "水";
        slot[4].price = 100;
        slot[4].setStock(5);
        slot[4].button_off();
    }

    public void push_Button(int i) {

    }

    public static void reflesh_button() {
        for (int i = 0; i < slot.length; i++) {
            if (remaining >= slot[i].price && slot[i].getStock() != 0) {
                slot[i].button_on();
            } else if (remaining < slot[i].price && slot[i].getStock() != 0) {
                slot[i].button_off();
            } else if (slot[i].getStock() == 0) {
                slot[i].button_sold();
            }
        }
    }

    public static void kanri_Mode() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("管理者メニュー画面\n0.釣銭確認 1.釣銭補充 2.在庫確認 3.在庫補充 4.売上金確認 5.管理者モード終了 ");
            int mode = sc.nextInt();
            int coin, num, product;
            if (mode == 0) {
                System.out.println("1000円:" + num_1000 + "枚," + "500円:" + num_500 + "枚," + "100円:" + num_100 + "枚,"
                        + "50円:" + num_50 + "枚," + "10円:" + num_10 + "枚,");
            } else if (mode == 1) {
                while (true) {
                    System.out.println(
                            "1000円:" + num_1000 + "枚," + "500円:" + num_500 + "枚," + "100円:" + num_100 + "枚," + "50円:"
                                    + num_50 + "枚," + "10円:" + num_10 + "枚,\nどの紙幣・硬貨を補充しますか？(1000/500/100/50/10)\n種類:");
                    coin = sc.nextInt();
                    if (coin == 1000 || coin == 500 || coin == 100 || coin == 50 || coin == 10) {
                        while (true) {
                            System.out.println("何枚入れますか？(0～1000)\n枚数");
                            num = sc.nextInt();
                            if (num <= 1000 || num >= 0) {
                                if (coin == 10) {
                                    num_10 += num;
                                } else if (coin == 50) {
                                    num_50 += num;
                                } else if (coin == 100) {
                                    num_100 += num;
                                } else if (coin == 500) {
                                    num_500 += num;
                                } else if (coin == 1000) {
                                    num_1000 += num;
                                }
                                break;
                            } else {
                                System.out.println("不正な入力です");
                            }
                        }
                        break;
                    } else {
                        System.out.println("補充できない紙幣・硬貨です");
                    }
                }
            } else if (mode == 2) {
                System.out.println("在庫数");
                for (int i = 0; i < slot.length; i++) {
                    System.out.println(i + "." + slot[i].name + " " + slot[i].getStock() + "本");
                }
            } else if (mode == 3) {
                System.out.println("在庫数");
                for (int i = 0; i < slot.length; i++) {
                    System.out.println(i + "." + slot[i].name + " " + slot[i].getStock() + "本");
                }
                System.out.println("---------------------");
                System.out.println("どの商品を補充しますか?(0/1/2/3/4)\n番号:");
                product = sc.nextInt();
                if (product >= 0 && product <= 4) {
                    System.out.println("何本入力しますか？(0～100)\n本数:");
                    num = sc.nextInt();
                    if (num >= 0 && num <= 100) {
                        slot[product].setStock(slot[product].getStock() + num);
                        System.out.println("補充を完了しました");
                    } else {
                        System.out.println("不正な入力です");
                    }
                } else {
                    System.out.println("補充可能な商品の番号を入力してください");
                }
            } else if (mode == 4) {
                System.out.println("現在の売上額は" + sales + "円です");
            }
        }
    }
}
