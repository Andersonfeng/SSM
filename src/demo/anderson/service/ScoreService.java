/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo.anderson.service;

import demo.anderson.mapper.ScMapper;
import demo.anderson.po.Sc;
import demo.anderson.po.ScExample;
import demo.anderson.po.ScExample.Criteria;
import demo.anderson.po.ScKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 * @author anderson
 */
@Service
public class ScoreService {

    @Autowired
    private ScMapper scMapper;

    public List<Sc> findScoreBySno(String sno) {
        ScExample scExample = new ScExample();
        Criteria criteria = scExample.createCriteria();
        criteria.andSnoEqualTo(sno);
        return scMapper.selectByExample(scExample);
    }

    public Sc findScoreBySnoCno(String sno, String cno) {
        ScKey scKey = new ScKey();
        scKey.setCno(cno);
        scKey.setSno(sno);
        return scMapper.selectByPrimaryKey(scKey);
    }

    public int deleteScoreBySnoCno(String sno, String cno) {
        ScKey scKey = new ScKey();
        scKey.setCno(cno);
        scKey.setSno(sno);
        return scMapper.deleteByPrimaryKey(scKey);
    }

    public List<Sc> findScAndCourseBySno(String sno) {
        ScKey scKey = new ScKey();
        scKey.setSno(sno);
        return scMapper.selectScAndCourse(scKey);
    }

    public int insertScore(Sc sc) {
        return scMapper.insert(sc);
    }

    public int updateScoreBySnoCno(Sc sc) {
        return scMapper.updateByPrimaryKey(sc);
    }

    public void setScMapper(ScMapper scMapper) {
        this.scMapper = scMapper;
    }

}
