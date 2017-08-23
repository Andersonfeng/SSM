/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo.anderson.controller;

import demo.anderson.mapper.StudentMapper;
import demo.anderson.po.Student;
import demo.anderson.service.StudentService;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

/**
 *
 * @author anderson
 */
@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @RequestMapping("/findAllStudent")
    public ModelAndView findAllStudent() {
        ModelAndView modelAndView = new ModelAndView();
        List<Student> students = studentService.findAllStudent();
        modelAndView.setViewName("student");
        modelAndView.addObject("students", students);
        return modelAndView;
    }

    @RequestMapping("/findStudentBySno")
    public ModelAndView findStudentBySno(
            HttpServletRequest request,
            HttpServletResponse response,
            @RequestParam("sno") String sno) throws IOException {
        ModelAndView modelAndView = new ModelAndView("student_edit");
        if (sno != null && !"".equals(sno)) {
            Student student = studentService.findStudentBySno(sno);
            modelAndView.addObject("student", student);
            modelAndView.addObject("submit_button", "update");
            modelAndView.addObject("submit_type", "update");
        } else {
            modelAndView.addObject("submit_button", "add");
            modelAndView.addObject("submit_type", "add");
        }
        return modelAndView;
    }

    @RequestMapping("/updateStudentBySno")
    public void updateStudentBySno(HttpServletRequest request,
            HttpServletResponse response) throws IOException {
        HashMap<String, String> hm = new HashMap();
        HashMap<String, String[]> hm2 = (HashMap) request.getParameterMap();
        for (String key : hm2.keySet()) {
            hm.put(key, hm2.get(key)[0]);
        }
        Student student = new Student();
        student.setSage(Short.parseShort(hm.get("sage")));
        student.setSname(hm.get("sname"));
        student.setSno(hm.get("sno"));
        student.setSsex(hm.get("ssex"));
        int result = studentService.updateStudentBySno(student);
        if (result == 1) {
            response.getWriter().write("success!");
        } else {
            response.getWriter().write("fail!");
        }
    }

    @RequestMapping("/insertStudent")
    public void insertStudent(HttpServletRequest request,
            HttpServletResponse response) throws IOException {
        HashMap<String, String> hm = new HashMap();
        HashMap<String, String[]> hm2 = (HashMap) request.getParameterMap();
        for (String key : hm2.keySet()) {
            hm.put(key, hm2.get(key)[0]);
        }
        Student student = new Student();
        student.setSage(Short.parseShort(hm.get("sage")));
        student.setSname(hm.get("sname"));
        student.setSno(hm.get("sno"));
        student.setSsex(hm.get("ssex"));
        int result = studentService.insertStudent(student);
        if (result == 1) {
            response.getWriter().write("success!");
        } else {
            response.getWriter().write("fail!");
        }
    }

    @RequestMapping("/deleteStudentBySno")
    public void deleteStudentBySno(
            HttpServletRequest request,
            HttpServletResponse response,
            @RequestParam("sno") String sno) throws IOException {
        int result = studentService.deleteStudentBySno(sno);
        if (result == 1) {
            response.getWriter().write("success!");
        } else {
            response.getWriter().write("fail!");
        }
    }

}
