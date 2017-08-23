/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo.anderson.mapper;

import demo.anderson.po.Sc;
import demo.anderson.po.ScExample;
import demo.anderson.po.ScKey;
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
public class ScMapperTest {
    
    private ScMapper scMapper;
    
    public ScMapperTest() {
    }
    
    @Before
    public void setUp() {
        ApplicationContext context = new ClassPathXmlApplicationContext("config/spring/applicationContext.xml");
        scMapper = context.getBean(ScMapper.class);
    }

    /**
     * Test of countByExample method, of class ScMapper.
     */
    @Test
    public void testCountByExample() {
        
    }

    /**
     * Test of deleteByExample method, of class ScMapper.
     */
    @Test
    public void testDeleteByExample() {
    }

    /**
     * Test of deleteByPrimaryKey method, of class ScMapper.
     */
    @Test
    public void testDeleteByPrimaryKey() {
    }

    /**
     * Test of insert method, of class ScMapper.
     */
    @Test
    public void testInsert() {
    }

    /**
     * Test of insertSelective method, of class ScMapper.
     */
    @Test
    public void testInsertSelective() {
    }

    /**
     * Test of selectByExample method, of class ScMapper.
     */
    @Test
    public void testSelectByExample() {
        
    }

    /**
     * Test of selectByPrimaryKey method, of class ScMapper.
     */
    @Test
    public void testSelectByPrimaryKey() {
        ScKey scKey = new ScKey();
        scKey.setSno("s001");
        scKey.setCno("c001");
        System.out.println(scMapper.selectByPrimaryKey(scKey));
    }

    /**
     * Test of updateByExampleSelective method, of class ScMapper.
     */
    @Test
    public void testUpdateByExampleSelective() {
    }

    /**
     * Test of updateByExample method, of class ScMapper.
     */
    @Test
    public void testUpdateByExample() {
    }

    /**
     * Test of updateByPrimaryKeySelective method, of class ScMapper.
     */
    @Test
    public void testUpdateByPrimaryKeySelective() {
    }

    /**
     * Test of updateByPrimaryKey method, of class ScMapper.
     */
    @Test
    public void testUpdateByPrimaryKey() {
    }

    /**
     * Test of selectScAndCourse method, of class ScMapper.
     */
    @Test
    public void testSelectScAndCourse() {
        ScKey scKey = new ScKey();
        scKey.setSno("s001");
        scKey.setCno("c001");
        List<Sc> sc = scMapper.selectScAndCourse(scKey);
        System.out.println(sc.get(0).getCourse().getCname());
    }
    
}
