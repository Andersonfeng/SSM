/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo.anderson.service;

import demo.anderson.mapper.StudentMapper;
import demo.anderson.po.Student;
import demo.anderson.po.StudentExample;
import demo.anderson.util.SpringContextUtil;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

/**
 * @author anderson
 */
@Service
public class StudentService {

    @Autowired
    private StudentMapper studentMapper;

    public Student findStudentBySno(String sno) {
        return studentMapper.selectByPrimaryKey(sno);
    }

    public List<Student> findAllStudent() {
        return studentMapper.selectByExample(new StudentExample());
    }

    public int updateStudentBySno(Student student) {
        return studentMapper.updateByPrimaryKey(student);
    }

    public int insertStudent(Student student) {
        return studentMapper.insert(student);
    }

    public int deleteStudentBySno(String sno) {
        return studentMapper.deleteByPrimaryKey(sno);
    }

    public void setStudentMapper(StudentMapper studentMapper) {
        this.studentMapper = studentMapper;
    }

}
