package net.prasanna.spring.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import net.prasanna.spring.entity.Student;
import net.prasanna.spring.services.StudentService;



@Controller
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService) {
        super();
        this.studentService = studentService;
    }

    @GetMapping("/qiscet")
    public String listStudents(Model model) {
        model.addAttribute("students", studentService.getAllStudents());
        return "students";
    }

    @GetMapping("/qiscet/new")
    public String createStudent(Model model) {
        Student student = new Student();
        model.addAttribute("student", student);
        return "AddStudent";
    }

    @PostMapping("/qiscet")
    public String saveStudent(@ModelAttribute("student") Student student, BindingResult result) {
        if (result.hasErrors()) {
            return "AddStudent";
        }
        studentService.saveStudent(student);
        return "redirect:/qiscet";
    }

    @GetMapping("/qiscet/edit/{id}")
    public String editStudent(@PathVariable Long id, Model model) {
        model.addAttribute("student", studentService.getStudentById(id));
        return "EditStudent";
    }

    @PostMapping("/qiscet/{id}")
    public String upStudent(@PathVariable Long id, @ModelAttribute("student") Student student, BindingResult result) {
        if (result.hasErrors()) {
            return "EditStudent";
        }
        student.setId(id);
        studentService.updateStudent(student);
        return "redirect:/qiscet";
    }
}