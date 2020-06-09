package com.hy.manager.service.product.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hy.manager.entity.product.ClassesBo;
import com.hy.manager.entity.product.Product;
import com.hy.manager.mapper.product.ProductMapper;
import com.hy.manager.service.product.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author gwl
 * @since 2020-06-04
 */
@Service
@Transactional
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements IProductService {
    @Autowired
    private ProductMapper productMapper;


    @Override
    public List<Product> selectProductList(Product product) {
        return productMapper.selectProductList(product);
    }

    @Override
    public List<ClassesBo> selectClasses() {
        return productMapper.selectClasses();
    }

    @Override
    public List<ClassesBo> queryClassesTable(Integer classId) {
        return productMapper.queryClassesTable(classId);
    }

    @Override
    public Integer updateUpStatusById(Product product) {
        return productMapper.updateUpStatusById(product);
    }

    @Override
    public Integer updateClassStatus(ClassesBo classesBo) {
        return productMapper.updateClassStatus(classesBo);
    }

    @Override
    public Integer updateStatusById(Product product) {
        return productMapper.updateStatusById(product);
    }

    @Override
    public Integer updateIsShow(Integer pid) {
        return productMapper.updateIsShow(pid);
    }

    @Override
    public Integer deleteProductById(Integer id) {
        return productMapper.deleteProductById(id);
    }

    @Override
    public Integer updateUpStatusProvider(Object[] ids, String type) {
        return productMapper.updateUpStatusProvider(ids,type);
    }

    @Override
    public Integer updateStatusProvider(String[] ids, String type) {
        return productMapper.updateStatusProvider(ids,type);
    }

    @Override
    public Product queryProductById(Integer pid) {
        return productMapper.queryProductById(pid);
    }

    @Override
    public Integer[] queryStatus(String[] ids) {
        return productMapper.queryStatus(ids);
    }
}
