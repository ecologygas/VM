public class Slot extends Product{
    private int button_state;
    private int stock;
    private Product product;

    public void button_on(){
        this.button_state = 1;
    }
    
    public void button_off(){
        this.button_state = 0;
    }
    
    public void button_sold(){
        this.button_state = 2;
    }
    
    public int getStock(){
        return this.stock;
    }

    public int getPrice(){
        return this.product.price;
    }

    public String getName(){
        return this.product.name;
    }

    public int getButton_state(){
        return this.button_state;
    }

    public void setStock(int stock){
        this.stock = stock;
    }

    public void setPrice(int price){
        this.price = price;
    }

    public void setName(String name){
        this.name = name;
    }
}
