package com.hy.manager.controller.product;


import com.github.pagehelper.PageHelper;
import com.hy.manager.Date.ResultData;
import com.hy.manager.entity.product.ClassesBo;
import com.hy.manager.entity.product.Product;
import com.hy.manager.service.product.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author gwl
 * @since 2020-06-04
 */
@RestController
@RequestMapping("product")
public class ProductController {
    @Autowired
    private IProductService productService;

    @RequestMapping("/queryProduct")
    public ResultData selectProductList(@RequestParam("currentPage") int currentPage,
                                        @RequestParam("pageSize") int pageSize,
                                        Product product){
        ResultData resultData = new ResultData();
        resultData.setDataSize(productService.selectProductList(product).size());

        PageHelper.startPage(currentPage,pageSize);
        List<Product> productList = productService.selectProductList(product);
        resultData.setData(productList);

        return resultData;
    }


    @RequestMapping("queryClasses")
    public List<ClassesBo> selectClasses(){
       return productService.selectClasses();
    }















}
