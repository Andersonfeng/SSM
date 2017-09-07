/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo.anderson.service;

import demo.anderson.mapper.CourseMapper;
import demo.anderson.mapper.ScMapper;
import demo.anderson.po.Course;
import demo.anderson.po.CourseExample;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 * @author anderson
 */
@Service
public class CourseService {

    private CourseMapper courseMapper;

    public List<Course> findAllCourse() {
        return courseMapper.selectByExample(new CourseExample());
    }

    public int addCourse(Course course) {
        return courseMapper.insert(course);
    }

    public void setCourseMapper(CourseMapper courseMapper) {
        this.courseMapper = courseMapper;
    }

}
