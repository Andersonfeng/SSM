/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo.anderson.mapper;

import demo.anderson.po.Student;
import demo.anderson.po.StudentExample;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author anderson
 */
public class StudentMapperTest {

    private StudentMapper studentMapper;

    public StudentMapperTest() {
    }

    @Before
    public void setUp() {
        ApplicationContext context = new ClassPathXmlApplicationContext("config/spring/applicationContext.xml");
        studentMapper = context.getBean(StudentMapper.class);
    }

    /**
     * Test of countByExample method, of class StudentMapper.
     */

    /**
     * Test of selectByExample method, of class StudentMapper.
     */
    @Test
    public void testSelectByExample() {
        StudentExample studentExample = new StudentExample();
//        studentExample.createCriteria().andSnoEqualTo("s001");
        List<Student> student = studentMapper.selectByExample(studentExample);
        System.out.println(student);
    }
    @Test
    public void testCountByExample() {
    }

    /**
     * Test of deleteByExample method, of class StudentMapper.
     */
    @Test
    public void testDeleteByExample() {
    }

    /**
     * Test of deleteByPrimaryKey method, of class StudentMapper.
     */
    @Test
    public void testDeleteByPrimaryKey() {
    }

    /**
     * Test of insert method, of class StudentMapper.
     */
    @Test
    public void testInsert() {
    }

    /**
     * Test of insertSelective method, of class StudentMapper.
     */
    @Test
    public void testInsertSelective() {
    }

    /**
     * Test of selectByPrimaryKey method, of class StudentMapper.
     */
    @Test
    public void testSelectByPrimaryKey() {
        Student student = studentMapper.selectByPrimaryKey("s001");
        System.out.println(student);
    }

    /**
     * Test of updateByExampleSelective method, of class StudentMapper.
     */
    @Test
    public void testUpdateByExampleSelective() {
    }

    /**
     * Test of updateByExample method, of class StudentMapper.
     */
    @Test
    public void testUpdateByExample() {
    }

    /**
     * Test of updateByPrimaryKeySelective method, of class StudentMapper.
     */
    @Test
    public void testUpdateByPrimaryKeySelective() {
    }

    /**
     * Test of updateByPrimaryKey method, of class StudentMapper.
     */
    @Test
    public void testUpdateByPrimaryKey() {
    }

    public class StudentMapperImpl implements StudentMapper {

        public long countByExample(StudentExample example) {
            return 0L;
        }

        public int deleteByExample(StudentExample example) {
            return 0;
        }

        public int deleteByPrimaryKey(String sno) {
            return 0;
        }

        public int insert(Student record) {
            return 0;
        }

        public int insertSelective(Student record) {
            return 0;
        }

        public List<Student> selectByExample(StudentExample example) {
            return null;
        }

        public Student selectByPrimaryKey(String sno) {
            return null;
        }

        public int updateByExampleSelective(Student record, StudentExample example) {
            return 0;
        }

        public int updateByExample(Student record, StudentExample example) {
            return 0;
        }

        public int updateByPrimaryKeySelective(Student record) {
            return 0;
        }

        public int updateByPrimaryKey(Student record) {
            return 0;
        }
    }


}
