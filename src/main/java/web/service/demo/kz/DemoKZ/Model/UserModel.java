package web.service.demo.kz.DemoKZ.Model;

public class UserModel {
    private String Name;
    private String NickName;

    public UserModel(String Name, String NickName){
        this.Name = Name;
        this.NickName = NickName;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getNickName() {
        return NickName;
    }

    public void setNickName(String nickName) {
        NickName = nickName;
    }
}
