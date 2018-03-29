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

import java.util.ArrayList;

@RestController
@RequestMapping("/demo")
public class Demo
{
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
        ArrayList<UserModel> userModelArrayList = new ArrayList<UserModel>();
        userModelArrayList.add(new UserModel("Neka", "Nek"));
        userModelArrayList.add(new UserModel("Test", "TestValue"));
        userModelArrayList.add(new UserModel("Test2", "TestValue23"));
        return new ResponseEntity<ArrayList<UserModel>>(userModelArrayList, HttpStatus.CREATED);
    }
}

