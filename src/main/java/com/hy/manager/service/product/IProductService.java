package com.hy.manager.service.product;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hy.manager.entity.product.ClassModel;
import com.hy.manager.entity.product.ClassesBo;
import com.hy.manager.entity.product.Contain;
import com.hy.manager.entity.product.Product;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author gwl
 * @since 2020-06-04
 */
public interface IProductService extends IService<Product> {


    public List<Product> selectProductList(Product product);
    public List<ClassesBo> selectClasses();
    public List<ClassesBo> queryGoodClasses();
    public List<ClassesBo> queryClassesTable(Integer classId);
    public Integer updateUpStatusById(Product product);
    public Integer updateClassStatus(ClassesBo classesBo);
    public Integer updateStatusById(Product product);
    public Integer updateIsShow(Integer pid);
    public Integer deleteProductById(Integer id);
    public Integer updateUpStatusProvider(Object[] ids,String type);
    public Integer updateStatusProvider(String[] ids,String type);
    public Product queryProductById(Integer pid);
    public Integer[] queryStatus(String[] ids);
    public Integer addClasses(ClassesBo classesBo);
    public Integer addModelOrColor(ClassModel classModel);
    public Integer delModelOrColor(ClassModel classModel);
    public List<ClassModel> queryClassModel(ClassModel classModel);
    public Integer addProduct(Contain contain);
    public Integer queryPNum(String num);



}
