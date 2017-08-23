/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo.anderson.controller;

import demo.anderson.po.Sc;
import demo.anderson.service.CourseService;
import demo.anderson.service.ScoreService;
import demo.anderson.service.StudentService;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author anderson
 */
@Controller
@RequestMapping("/sc")
public class ScoreController {

    @Autowired
    private ScoreService scoreService;
    @Autowired
    private StudentService studentService;
    @Autowired
    private CourseService courseService;

    @RequestMapping("/findScoreBySno")
    public ModelAndView findScoreBySno(
            HttpServletRequest request,
            HttpServletResponse response,
            @RequestParam("sno") String sno) throws IOException {
        ModelAndView modelAndView = new ModelAndView("sc");
//        List<Sc> scores = scoreService.findScoreBySno(sno);
        List<Sc> scores = scoreService.findScAndCourseBySno(sno);
        JSONArray jSONArray = new JSONArray(scores);
        response.getWriter().write(jSONArray.toString());
        request.setAttribute("scores", scores);
        return modelAndView;
    }

    @RequestMapping("/findScoreBySnoCno")
    public ModelAndView findScoreBySnoCno(
            HttpServletRequest request,
            HttpServletResponse response,
            @RequestParam("sno") String sno,
            @RequestParam("cno") String cno,
            @RequestParam("mode") String mode) {
        ModelAndView modelAndView = new ModelAndView("sc_edit");
        if ("edit".equals(mode)) {
            modelAndView.addObject("sc", scoreService.findScoreBySnoCno(sno, cno));
            modelAndView.addObject("submit_type", "update");
        } else if ("add".equals(mode)) {
            modelAndView.addObject("students", studentService.findAllStudent());
            modelAndView.addObject("courses", courseService.findAllCourse());
            modelAndView.addObject("submit_type", "add");
        }
        modelAndView.addObject("mode", mode);
        return modelAndView;
    }

    @RequestMapping("/editScoreBySnoCno")
    public void editScoreBySnoCno(
            HttpServletRequest request,
            HttpServletResponse response) throws IOException {
        HashMap<String, String[]> hm2 = (HashMap) request.getParameterMap();
        HashMap<String, String> hm = new HashMap();
        for (String key : hm2.keySet()) {
            hm.put(key, hm2.get(key)[0]);
        }
        Sc sc = new Sc();
        sc.setCno(hm.get("cno"));
        sc.setSno(hm.get("sno"));
        sc.setScore(new BigDecimal(hm.get("score")));
        int result = scoreService.updateScoreBySnoCno(sc);
        if (result == 1) {
            response.getWriter().write("success!");
        } else {
            response.getWriter().write("error!");
        }
    }

    @RequestMapping("/addScore")
    public void addScore(HttpServletRequest request,
            HttpServletResponse response) throws IOException {
        HashMap<String, String[]> hm2 = (HashMap) request.getParameterMap();
        HashMap<String, String> hm = new HashMap();
        for (String key : hm2.keySet()) {
            hm.put(key, hm2.get(key)[0]);
        }
        Sc sc = new Sc();
        sc.setCno(hm.get("cno"));
        sc.setSno(hm.get("sno"));
        sc.setScore(new BigDecimal(hm.get("score")));
        int result = scoreService.insertScore(sc);
        if (result == 1) {
            response.getWriter().write("success!");
        } else {
            response.getWriter().write("error!");
        }
    }

    @RequestMapping("/deleteScoreBySnoCno")
    public void deleteScoreBySnoCno(
            HttpServletRequest request,
            HttpServletResponse response) throws IOException {
        HashMap<String, String[]> hm2 = (HashMap) request.getParameterMap();
        HashMap<String, String> hm = new HashMap();
        for (String key : hm2.keySet()) {
            hm.put(key, hm2.get(key)[0]);
        }
//        Sc sc = new Sc();
//        sc.setCno(hm.get("cno"));
//        sc.setSno(hm.get("sno"));
//        sc.setScore(new BigDecimal(hm.get("score")));
        int result = scoreService.deleteScoreBySnoCno(hm.get("sno"),hm.get("cno"));
        if (result == 1) {
            response.getWriter().write("success!");
        } else {
            response.getWriter().write("error!");
        }
    }

}
