/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo.anderson.mapper;

import demo.anderson.po.Teacher;
import demo.anderson.po.TeacherExample;
import java.util.List;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author anderson
 */
public class TeacherMapperTest {

    private TeacherMapper teacherMapper;

    public TeacherMapperTest() {
    }

    @Before
    public void setUp() {
        ApplicationContext context = new ClassPathXmlApplicationContext("config/spring/applicationContext.xml");
        teacherMapper = context.getBean(TeacherMapper.class);
    }

    /**
     * Test of countByExample method, of class TeacherMapper.
     */
    @Test
    public void testCountByExample() {
        TeacherExample teacherExample = new TeacherExample();
        TeacherExample.Criteria criteria = teacherExample.createCriteria();
        criteria.andTnameEqualTo("t001");
        List<Teacher>list = teacherMapper.selectByExample(teacherExample);
        System.out.println(list);
    }

    /**
     * Test of deleteByExample method, of class TeacherMapper.
     */
    @Test
    public void testSelectByPrimaryKey() {
        Teacher teacher = teacherMapper.selectByPrimaryKey("t001");
        System.out.println(teacher);
    }

    /**
     * Test of updateByExampleSelective method, of class TeacherMapper.
     */
    @Test
    public void testUpdateByExampleSelective() {
    }

    /**
     * Test of updateByExample method, of class TeacherMapper.
     */
    @Test
    public void testUpdateByExample() {
    }

    /**
     * Test of updateByPrimaryKeySelective method, of class TeacherMapper.
     */
    @Test
    public void testUpdateByPrimaryKeySelective() {
    }

    /**
     * Test of updateByPrimaryKey method, of class TeacherMapper.
     */
    @Test
    public void testUpdateByPrimaryKey() {
    }

}
