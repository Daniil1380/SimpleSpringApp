package com.daniil1380.first.controller;

import com.daniil1380.first.dao.PersonDao;
import com.daniil1380.first.entity.PersonEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FirstController {

    @RequestMapping(value = "/greeting", method = RequestMethod.GET)
    public String helloWorldController(@RequestParam(name = "id", required = false) String id, Model model) {
        if (id != null){
            PersonDao personDao = new PersonDao();
            PersonEntity personEntity= personDao.findById(Integer.parseInt(id));
            if (personEntity != null) {
                model.addAttribute("id", personEntity.getId());
                model.addAttribute("content", personEntity.getContent());
            }
            else {
                model.addAttribute("id", "Not found");
                model.addAttribute("content", "Not found");
            }
        }
        else {
            model.addAttribute("id", "");
            model.addAttribute("content", "");
        }
        model.addAttribute("personEntity", new PersonEntity());
        return "greeting";
    }



    @RequestMapping(value="/greeting", method=RequestMethod.POST)
    public String greetingSubmit(@ModelAttribute PersonEntity personEntity, Model model) {
        model.addAttribute("personEntity", personEntity);
        PersonDao personDao = new PersonDao();
        personDao.save(personEntity);
        return "result";
    }

}
