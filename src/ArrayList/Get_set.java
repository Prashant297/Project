package ArrayList;

public class Get_set {

    private int P_id;
    private String P_name;
    private int P_price;
    private int P_size;

    public int getid(){
        return P_id;
    }
    public int setid(int NewId){
        this.P_id=NewId;
        return NewId;
    }
    public String getname(){
        return P_name;
    }
    public String setname(String NewName){
        this.P_name=NewName;
        return NewName;
    }
    public int getprice(){
        return P_price;
    }
    public int setprice(int NewPrice){
        this.P_price=NewPrice;
        return NewPrice;
    }
    public int getsize(){
        return P_size;
    }
    public Object setsize(int NewSize){
        this.P_size=NewSize;
        return NewSize;
    }
}
