package review.gk.exam;

import java.util.ArrayList;

public class BaiDu implements Cloneable{
    private int number;
    private Address addr;

    public Address getAddr() {
        return addr;
    }

    public void setAddr(Address addr) {
        this.addr = addr;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        BaiDu b = null;
        try{
            b = (BaiDu) super.clone();
        }catch (CloneNotSupportedException e){
            e.printStackTrace();
        }
        return b;
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        Address address = new Address();
        address.setAdd("北京");
        BaiDu baiDu = new BaiDu();
        baiDu.setAddr(address);
        BaiDu baidu2 = (BaiDu) baiDu.clone();
        System.out.println("X1"+baiDu.getAddr().getAdd());
        System.out.println("x2"+baidu2.getAddr().getAdd());
        address.setAdd("天津");
        System.out.println("X1"+baiDu.getAddr().getAdd());
        System.out.println("x2"+baidu2.getAddr().getAdd());
        ArrayList<Integer> list  = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println(list.stream().map(d->1).reduce(0,(a,b)->a+b));

    }
}
class Address{
    private String add;

    public String getAdd() {
        return add;
    }

    public void setAdd(String add) {
        this.add = add;
    }
}
