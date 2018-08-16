package yiming.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import yiming.model.User;
import yiming.model.mapper.UserMapper;
import yiming.service.ValidatorService;
import yiming.validate.Group;

import java.util.ArrayList;
import java.util.List;

@RestController
public class Controller {

    @Autowired
    UserMapper userMapper;
    @Autowired
    ValidatorService validatorService;

    @RequestMapping(value = "/valite1",method = RequestMethod.GET)
    public String valite1(){
        User user=new User();
       /* user.setUserId("1");
        user.setUserName("123");*/
        List<String> list=new ArrayList<String>();
        list.add("1");
        user.setLists(list);
        validatorService.validate(user,Group.notNUll1.class,Group.notNull2.class);

        userMapper.insert(user);
        return "ok";
    }

    @RequestMapping(value = "/valite2",method = RequestMethod.GET)
    public String valite2(){
        User user=new User();
        validatorService.validate(user,Group.notNull2.class);

        userMapper.insert(user);
        return "ok";
    }

    @RequestMapping(value = "/valite3",method = RequestMethod.GET)
    public String valite3(){
        User user=new User();
        user.setUserName("123");
        user.setPassword("qwe");
        validatorService.validate(user);
        userMapper.insert(user);
        return "ok";
    }

    @RequestMapping(value = "select",method = RequestMethod.GET)
    public String select(){
        User user=userMapper.findByUserName("w");
        return user==null?"":user.toString();
    }


}
