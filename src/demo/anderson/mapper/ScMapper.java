package demo.anderson.mapper;

import demo.anderson.po.Sc;
import demo.anderson.po.ScExample;
import demo.anderson.po.ScKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;

@MapperScan
public interface ScMapper {

    long countByExample(ScExample example);

    int deleteByExample(ScExample example);

    int deleteByPrimaryKey(ScKey key);

    int insert(Sc record);

    int insertSelective(Sc record);

    List<Sc> selectByExample(ScExample example);

    Sc selectByPrimaryKey(ScKey key);

    int updateByExampleSelective(@Param("record") Sc record, @Param("example") ScExample example);

    int updateByExample(@Param("record") Sc record, @Param("example") ScExample example);

    int updateByPrimaryKeySelective(Sc record);

    int updateByPrimaryKey(Sc record);

    List<Sc> selectScAndCourse(ScKey key);
}
