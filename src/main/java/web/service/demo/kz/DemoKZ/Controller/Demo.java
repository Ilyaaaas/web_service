package web.service.demo.kz.DemoKZ.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import web.service.demo.kz.DemoKZ.Model.UserModel;

import java.sql.*;
import java.util.ArrayList;

@RestController
@RequestMapping("/demo")
public class Demo
{

    private static final String URL  = "jdbc:mysql://78.40.108.24:3306/web_service_db";
    //поменять адрес при переносе на сервер!!!
    //private static final String URL  = "jdbc:mysql://localhost:3306/web_service_db";
    private static final String USER_NAME  = "root";
    private static final String PASSWORD  = "Astana2018";

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public ResponseEntity<String> hello()
    {
        return new ResponseEntity<String>("Hello Nek", HttpStatus.CREATED);
    }

    @RequestMapping(value = "/hello/name", method = RequestMethod.GET)
    public ResponseEntity<String> helloName(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model)
    {
        return new ResponseEntity<String>("Hello "+name, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/nek/array" , method = RequestMethod.GET)
    public ResponseEntity<ArrayList<UserModel>> array()
    {
        System.out.println("get request is running");
        Connection connection;
        ArrayList<UserModel> userModelArrayList = new ArrayList<UserModel>();
        try {
            connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
            Statement statement =  connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select customer_id, first_name, last_name from TEST");
            int column_id = 1;
            while(resultSet.next())
            {
                String id = resultSet.getString(1);
                String first_name = resultSet.getString(2);
                String last_name = resultSet.getString(3);

                userModelArrayList.add(new UserModel(id, first_name, last_name));
                column_id++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("sql is done");
        return new ResponseEntity<ArrayList<UserModel>>(userModelArrayList, HttpStatus.CREATED);
    }
}


