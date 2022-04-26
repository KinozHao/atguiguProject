package domain.equipment;

/**
 * @author kinoz
 * @date 2022/4/22 - 20:52
 * @apiNote 笔记本类
 */
public class NoteBook implements Equipment{
    private String model;//型号
    private double price;//价格

    @Override
    public String getDescription() {
        return  model+ "(" + price + ")";
    }

    public NoteBook(String model, double price) {
        super();
        this.model = model;
        this.price = price;
    }

    public NoteBook(){
        super();
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
