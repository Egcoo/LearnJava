package domain;

/**
 * @ author Egcoo
 * @ date 2022/4/10 - 12:37
 */
public class House {
    //编号 房主 电话 地址 月租 状态（已出租/未出租）
    private int ID;
    private String name;
    private String phone;
    private String address;
    private int rent;
    private String state;

    // 构造器什么的该给就给

    public House(int ID, String name, String phone, String address, int rent, String state) {
        this.ID = ID;
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.rent = rent;
        this.state = state;
    }

    @Override
    public String toString() {
        return
                ID +
                        "\t\t" + name +
                        "\t" + phone +
                        "\t" + address +
                        "\t" + rent +
                        "\t" + state
                ;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getRent() {
        return rent;
    }

    public void setRent(int rent) {
        this.rent = rent;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
