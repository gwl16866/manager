package com.hy.manager.mapper.product;

import com.hy.manager.entity.product.Product;
import org.apache.ibatis.annotations.Param;
import org.springframework.util.StringUtils;

public class ProductProvider {

    public String selectProductList(@Param("product") Product product){
        StringBuffer sb = new StringBuffer("select p.*,c.className from product p,classes c where p.classes = c.id  ");
        if(!StringUtils.isEmpty(product.getProductName())){
            sb.append(" and CONCAT(productName,productNumber) LIKE '%"+product.getProductName()+"%'");
        }else if(!StringUtils.isEmpty(product.getClasses())){
            sb.append(" and c.id = "+product.getClasses()+"");
        }
        System.out.println(sb.toString());
        return sb.toString();
    }






}
