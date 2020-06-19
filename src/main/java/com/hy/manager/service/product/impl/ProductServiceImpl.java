package com.hy.manager.service.product.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hy.manager.entity.product.*;
import com.hy.manager.mapper.product.ProductMapper;
import com.hy.manager.service.product.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

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

    public static final int START = 100;   //定义范围开始数字

    public static final int END = 999; //定义范围结束数字

    @Override
    public List<Product> selectProductList(Product product) {
        return productMapper.selectProductList(product);
    }

    @Override
    public List<ClassesBo> selectClasses() {
        return productMapper.selectClasses();
    }

    @Override
    public List<ClassesBo> queryGoodClasses() {
        return productMapper.queryGoodClasses();
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

    @Override
    public Integer addClasses(ClassesBo classesBo) {
        return productMapper.addClasses(classesBo);
    }

    @Override
    public Integer addModelOrColor(ClassModel classModel) {
        return productMapper.addModelOrColor(classModel);
    }

    @Override
    public Integer delModelOrColor(ClassModel classModel) {
        return productMapper.delModelOrColor(classModel);
    }

    @Override
    public List<ClassModel> queryClassModel(ClassModel classModel) {
        return productMapper.queryClassModel(classModel);
    }


    public String returnDateStr (){
       Date date=new Date();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("YYYYMMDDHHmmss");
        String s= simpleDateFormat.format(date);
        Random random=new Random();
        //产生随机数
        int number = random.nextInt(END - START + 1) + START;
        return s+number;
    }


    @Override
    public Integer addProduct(Contain contain) {
        List<AddProduct> productList = contain.getAddList();
        Product product = contain.getProduct();
        Integer num=0;
        for(int i=0;i<productList.size();i++){
            product.setProductNumber(returnDateStr());
            //添加商品
            num = productMapper.addProduct(product,productList.get(i));
            //添加订单 增加库存
            productMapper.addOrders(productList.get(i).getCounts());
            Integer maxOrderId = productMapper.maxOrderId();
            Integer pid = productMapper.maxPid();
            //添加库存记录
            productMapper.addCounts(pid,maxOrderId,productList.get(i).getCounts(),2,1);
        }





        return num;
    }

    @Override
    public Integer queryPNum(String num) {
        return productMapper.queryPNum(num);
    }
}
