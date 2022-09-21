package edu.hanoi.controller;

import edu.hanoi.model.Group;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/group")
public class GroupController {
    private final static Logger LOGGER = Logger.getLogger(GroupController.class);
    @RequestMapping(value = "add-form",method = RequestMethod.GET)
    public ModelAndView addForm(){
        return new ModelAndView("group.form","command",new Group());
    }
    @RequestMapping(value = "add",method = RequestMethod.POST)
    public ModelAndView addGroup(@Validated @ModelAttribute("command") Group group, BindingResult result){
        ModelAndView mv = new ModelAndView();
        if(result.hasErrors()){
            mv.addObject("errors",result);
        }
        LOGGER.info("-- Add new group -> "+group);
        return mv;
    }
}

