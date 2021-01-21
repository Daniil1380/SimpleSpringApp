package com.daniil1380.first.controller;

import com.daniil1380.first.Services.PersonService;
import com.daniil1380.first.entity.PersonEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FirstController {

    @Autowired
    private PersonService personService;


    @RequestMapping(value = "/greeting", method = RequestMethod.GET)
    public String helloWorldController(@RequestParam(name = "id", required = false) String id, Model model) {
        if (id != null){
            PersonEntity personEntity = personService.get(Integer.parseInt(id));
            model.addAttribute("id", personEntity.getId());
            model.addAttribute("content", personEntity.getContent());
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
        personService.save(personEntity);
        return "result";
    }

}
