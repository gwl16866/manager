package com.hy.manager.mapper.product;

import com.hy.manager.entity.product.*;
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
     * @return 查询所有可用类别
     */
    @Select("SELECT * FROM classes where status=1")
    public List<ClassesBo> queryGoodClasses();





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


    /**
     * 添加类别
     * @param classesBo
     * @return
     */
    @Insert("insert into classes(className,status) values(#{className},#{status})")
    public Integer addClasses(ClassesBo classesBo);

    /**
     * 根据类别查询 规格或颜色
     * @param classModel
     * @return
     */
    @Select("select * from model where fid=#{fid} and type =#{type}")
    public List<ClassModel> queryClassModel(ClassModel classModel);


    /**
     * 根据类别添加 规格或颜色
     * @param classModel
     * @return
     */
    @Insert("insert into model(fid,twoModel,type) values(#{fid},#{twoModel},#{type})")
    public Integer addModelOrColor(ClassModel classModel);


    /**
     * 根据类别删除 规格或颜色
     * @param classModel
     * @return
     */
    @Insert("delete from model where id=#{id}")
    public Integer delModelOrColor(ClassModel classModel);


    /**
     * 添加商品
     * @param product
     * @param productForm
     * @return
     */
    @Insert("insert into product" +
            "(productName,price,productNumber,sellVolume,status,upStatus,image,productModel,productColor,marketDate,productMaterials,productUser,classes,isShow,counts,alarmCount)values" +
            "(#{product.productName},#{productForm.price},#{product.productNumber},0,2,2,#{product.image},#{productForm.model},#{productForm.color},#{product.marketDate},#{product.productMaterials},#{product.productUser},#{product.classes},1,#{productForm.counts},#{productForm.alarm})")
    public Integer addProduct(@Param("product") Product product,@Param("productForm") AddProduct productForm);


    /**
     * 查询商品货号
     * @param num
     * @return
     */
    @Select("select count(*) from product where productNumber = #{num}")
    public Integer queryPNum(String num);

    /**
     * 添加一条订单
     * @param counts
     * @return
     */
    @Insert("insert into orders(counts) values(#{counts})")
    public Integer addOrders(Integer counts);


    /**
     *查询最大orderid
     */
    @Select("select max(id) from orders")
    public Integer maxOrderId();

    /**
     *查询最大商品id
     */
    @Select("select max(pid) from product")
    public Integer maxPid();


    /**
     * 添加库存记录
     * @param productId
     * @param orderId
     * @param productCount
     * @param userId
     * @return
     */
    @Insert("insert into quantity(productId,orderId,count,userId,controlClass,status) values(#{productId},#{orderId},#{productCount},#{userId},2,2)")
    public Integer addCounts(Integer productId,Integer orderId,Integer productCount,Integer userId);

}
