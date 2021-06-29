public class Haisyutsu {
    public static void tumble_out(int i){
        Kanri.slot[i].setStock(Kanri.slot[i].getStock()-1);
        System.out.println(Kanri.slot[i].name+"を排出しました");
    }
}
