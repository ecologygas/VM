public class Henkyaku {
    public static void repay() {
        if (Kanri.remaining == 0) {
            System.out.println("お釣りはありません");
        } else {
            if (Kanri.remaining >= 1000 && (Kanri.num_1000 - Kanri.remaining / 1000) >= 0) {
                Kanri.num_1000 -= Kanri.remaining / 1000;
                System.out.print("1000円" + Kanri.remaining / 1000 + "枚 ");
                Kanri.remaining -= 1000 * (Kanri.remaining / 1000);
            }
            if (Kanri.remaining >= 500 && (Kanri.num_500 - Kanri.remaining / 500) >= 0) {
                Kanri.num_500 -= Kanri.remaining / 500;
                System.out.print("500円" + Kanri.remaining / 500 + "枚 ");
                Kanri.remaining -= 500 * (Kanri.remaining / 500);
            }
            if (Kanri.remaining >= 100 && (Kanri.num_100 - Kanri.remaining / 100) >= 0) {
                Kanri.num_100 -= Kanri.remaining / 100;
                System.out.print("100円" + Kanri.remaining / 100 + "枚 ");
                Kanri.remaining -= 100 * (Kanri.remaining / 100);
            }
            if (Kanri.remaining >= 50 && (Kanri.num_50 - Kanri.remaining / 50) >= 0) {
                Kanri.num_50 -= Kanri.remaining / 50;
                System.out.print("50円" + Kanri.remaining / 50 + "枚 ");
                Kanri.remaining -= 50 * (Kanri.remaining / 50);
            }
            if (Kanri.remaining >= 10 && (Kanri.num_1000 - Kanri.remaining / 10) >= 0) {
                Kanri.num_10 -= Kanri.remaining / 10;
                System.out.print("10円" + Kanri.remaining / 10 + "枚 ");
                Kanri.remaining -= 10 * (Kanri.remaining / 10);
            }
            System.out.println("返却しました");
        }
    }
}
