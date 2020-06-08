package com.hy.manager.service.product;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hy.manager.entity.product.ClassesBo;
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
    public Integer updateUpStatusById(Product product);
    public Integer updateStatusById(Product product);
    public Integer deleteProductById(Integer id);
    public Integer updateUpStatusProvider(String[] ids,String type);
    public Integer updateStatusProvider(String[] ids,String type);
    public Product queryProductById(Integer pid);



}
