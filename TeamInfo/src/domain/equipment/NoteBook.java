package domain.equipment;

/**
 * @author kinoz
 * @date 2022/4/22 - 20:52
 * @apiNote �ʼǱ���
 */
public class NoteBook implements Equipment{
    private String model;//�ͺ�
    private double price;//�۸�

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
