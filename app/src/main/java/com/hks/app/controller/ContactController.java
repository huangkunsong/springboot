package com.hks.app.controller;

import com.hks.app.dao.ITestDao;
import com.hks.app.entity.Contact;
import com.hks.app.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/")
public class ContactController {

    @Autowired
    ITestDao iTestDao;

	@RequestMapping(method=RequestMethod.GET)
	public String home(Map<String,Object> model) {
        List<Contact> contacts = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Contact contact = new Contact();
            contact.setEmailAddress("Address" + i);
            contact.setFirstName("asdasdasd" + "i");
        }
        model.put("contacts", contacts);
        return "home";
	}

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public List<User> home(User user){
        return iTestDao.findAllUser(user);
    }
}