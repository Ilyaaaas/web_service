package web.service.demo.kz.DemoKZ.Model;

public class UserModel {
    private String customer_id;
    private String first_name;
    private String last_name;

    public UserModel(String customer_id_par, String first_name_par, String last_name_par){
        this.customer_id = customer_id_par;
        this.first_name = first_name_par;
        this.last_name = last_name_par;
    }

    public String getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(String first_name) {
        first_name = first_name;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        last_name = last_name;
    }
}
