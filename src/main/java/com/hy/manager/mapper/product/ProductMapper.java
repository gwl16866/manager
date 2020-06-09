package com.hy.manager.mapper.product;

import com.hy.manager.entity.product.ClassesBo;
import com.hy.manager.entity.product.Product;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.*;

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


    @Select("select p.*,c.className from product p,classes c where p.classes = c.id and p.pid=#{pid}")
    public Product queryProductById(Integer pid);



    /**
     * @return 查询所有类别分页
     */
    @SelectProvider(type = ProductProvider.class,method = "queryClassesTable")
    public List<ClassesBo> queryClassesTable(Integer classId);


    /**
     * @return 查询所有类别
     */
    @Select("SELECT * FROM classes")
    public List<ClassesBo> selectClasses();

    /**
     *
     * @return 修改上架状态
     */
    @Update("update product set upStatus=#{upStatus} where pid=#{pid} ")
    public Integer updateUpStatusById(Product product);

    /**
     *
     * @return 修改商品类别状态
     */
    @Update("update classes set status=#{status} where id=#{id} ")
    public Integer updateClassStatus(ClassesBo classesBo);


    /**
     *
     * @return 修改审核状态
     */
    @Update("update product set status=#{status} where pid=#{pid} ")
    public Integer updateStatusById(Product product);


    /**
     *
     * @return isshow恢复
     */
    @Update("update product set isShow=1 where pid=#{id}")
    public Integer updateIsShow(Integer id);


    /**
     *
     * @return 删除
     */
    @Update("update product set isShow=2 where pid=#{id}")
    public Integer deleteProductById(Integer id);


    /**
     * @return 批量修改上下架状态
     */
    @UpdateProvider(type = ProductProvider.class,method = "updateUpStatusProvider")
    public Integer updateUpStatusProvider(@Param("ids") Object[] ids,@Param("type") String type);


    /**
     * @return 批量修改审核状态
     */
    @UpdateProvider(type = ProductProvider.class,method = "updateStatusProvider")
    public Integer updateStatusProvider(@Param("ids") String[] ids,@Param("type") String type);


    /**
     * @return 查询审核状态
     */
    @SelectProvider(type = ProductProvider.class,method = "queryStatus")
    public Integer[] queryStatus(@Param("ids") String[] ids);




}
