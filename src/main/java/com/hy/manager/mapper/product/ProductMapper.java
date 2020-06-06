package com.hy.manager.mapper.product;

import com.hy.manager.entity.product.ClassesBo;
import com.hy.manager.entity.product.Product;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author gwl
 * @since 2020-06-04
 */
@Mapper
public interface ProductMapper extends BaseMapper<Product> {


    /**
     * @return 查询product列表
     */
    @SelectProvider(type = ProductProvider.class,method = "selectProductList")
    public List<Product> selectProductList(@Param("product") Product product);

    /**
     * @return 查询所有类别
     */
    @Select("SELECT * FROM classes")
    public List<ClassesBo> selectClasses();


}
