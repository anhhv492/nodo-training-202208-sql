package com.example.controller;

import com.example.dao.StudentDAO;
import com.example.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.sql.SQLException;
import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentDAO studentDAO;
    @RequestMapping(value = "add",method = RequestMethod.GET)
    public ModelAndView add(){
        return new ModelAndView("student-form","command",new Student());
    }
//    @RequestMapping(value = "save",method = RequestMethod.POST)
//    public ModelAndView save(@RequestParam(value = "name",required = false)String name,
//                             @RequestParam(value = "age",required = false) int age){
//        ModelAndView mv = new ModelAndView();
//        mv.setViewName("student-view");
//        mv.addObject("name",name);
//        mv.addObject("age",age);
//        return mv;
//    }
    @RequestMapping(value = "save",method = RequestMethod.POST)
    public ModelAndView save(@Validated @ModelAttribute("command") Student student, BindingResult result){
        ModelAndView mv =new ModelAndView();
        if(!result.hasErrors()){
            mv.addObject("student",student);
            if(student.getId()>0){
                studentDAO.update(student);
            }else{
                studentDAO.insert(student);
            }
            System.out.println("ok !!");
            mv = new ModelAndView("redirect:/student/list");
        }else{
            mv = new ModelAndView("student-form","command",student);
            mv.addObject("errors",result);
            System.out.println("erros !!");
        }
        return mv;
    }
    @RequestMapping(value = "list")
    public ModelAndView listStudent(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("student-list");
        mv.addObject("students",studentDAO.listStudent());
        return mv;
    }
    @RequestMapping("delete/{id}")
    public String delete(@PathVariable("id") Integer id) throws SQLException {
        studentDAO.delete(id);
        return "redirect:/student/list";
    }
    @RequestMapping("edit/{id}")
    public ModelAndView edit(@PathVariable("id") Integer id){
        try {
            Student student = studentDAO.findById(id);
            return new ModelAndView("/student/student-form","command",student);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    @RequestMapping(value = "json/{id}",method = RequestMethod.GET)
    public Student viewJson(@RequestBody Integer id){
        return studentDAO.findById(id);
    }
}
