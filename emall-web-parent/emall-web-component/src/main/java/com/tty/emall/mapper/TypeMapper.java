package com.tty.emall.mapper;

import com.tty.emall.entity.Type;
import com.tty.emall.entity.TypeExample;
import com.tty.emall.vo.TypeVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TypeMapper {
    long countByExample(TypeExample example);

    int deleteByExample(TypeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Type record);

    int insertSelective(Type record);

    List<Type> selectByExample(TypeExample example);

    /**
     * 查询所有分类商品
     * @return
     */
    List<TypeVo> selectByTypeAndGoods();

    /**
     * 根据分类id，查询所有商品
     * @param id
     * @return
     */
    TypeVo selectByTypeAndGoodsById(@Param("id") Integer id);

    Type selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Type record, @Param("example") TypeExample example);

    int updateByExample(@Param("record") Type record, @Param("example") TypeExample example);

    int updateByPrimaryKeySelective(Type record);

    int updateByPrimaryKey(Type record);
}