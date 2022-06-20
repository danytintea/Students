package com.example.controller;

import com.example.dto.MajorDto;
import com.example.dto.StudentDto;
import com.example.entity.Student;
import com.example.service.MajorService;
import com.example.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class FormController {


    @Autowired
    StudentService studentService;

    @Autowired
    MajorService majorService;



    @GetMapping(value = "")
    public String showDefault(Model model) {return "home";}

    @GetMapping(value = "/home")
    public String showHome(Model model) {
        return "home";
    }


    @GetMapping(value = "/formStudent")
    public String showFormStudent(Model model) {
        Student student = Student.builder().build();
        List<MajorDto> majorDtoList = majorService.getMajor();
        model.addAttribute("majorList", majorDtoList);
        model.addAttribute("student",student);
        return "formStudent";
    }

    @PostMapping(value = "/addStudent")
    public String addStudent(@ModelAttribute("student") StudentDto studentDto,BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "error";
        }

//        System.out.println(student);
        studentDto.setMajor(majorService.getMajor().get(studentDto.getMajor().getId()-1));
//        System.out.println(student);
        studentService.saveStudentToDataBase(studentDto);

        return "redirect:/overviewStudent";
    }

    @GetMapping(value = "/overviewStudent")
    public String showOverviewStudent(Model model) {
        List<StudentDto> studentDtoList = studentService.getStudents();
        List<MajorDto> majorDtoList = majorService.getMajor();
        model.addAttribute("studentList", studentDtoList);
        model.addAttribute("majorList", majorDtoList);
        return "overviewStudent";
    }

    @GetMapping(value = "/formMajor")
    public String showFormMajor(Model model) {
        return "formMajor";
    }

    @PostMapping(value = "/addMajor")
    public String addMajor(@ModelAttribute("major") MajorDto major, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "error";
        }

        model.addAttribute("major", major);
        majorService.saveMajorToDataBase(major);

        return "redirect:/overviewMajor";
    }

    @GetMapping(value = "/overviewMajor")
    public String showOverviewMajor(Model model) {
        List<MajorDto> majors = majorService.getMajor();
        model.addAttribute("majors",majors);
        return "overviewMajor";
    }

    @GetMapping(value = "/404")
    public String show404(Model model) {
        return "404";
    }

    @GetMapping(value = "/contact")
    public String showcontact(Model model) {

        //Message message = Message.builder().build();
        //model.addAttribute("message", message);
        //System.out.println(message);

        return "contact";
    }

    @GetMapping(value = "/deleteStudent/{id}")
    public String deleteStudent(@PathVariable("id") int id, Model model){

        studentService.deleteStudentById(id);
        return "redirect:/overviewStudent";
    }

    @GetMapping(value = "/deleteMajor/{id}")
    public String deleteMajor(@PathVariable("id") int id, Model model){

        majorService.deleteMajorById(id);
        return "redirect:/overviewMajor";
    }
}
