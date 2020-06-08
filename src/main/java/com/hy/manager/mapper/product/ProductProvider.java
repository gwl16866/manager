package com.hy.manager.mapper.product;

import com.hy.manager.entity.product.Product;
import org.apache.ibatis.annotations.Param;
import org.springframework.util.StringUtils;

public class ProductProvider {

    public String selectProductList(@Param("product") Product product){
        StringBuffer sb=null;
         if(!StringUtils.isEmpty(product.getIsShow()) && product.getIsShow() == 0){
            //除非查询是删除状态时让查询出删除的商品
            sb = new StringBuffer(
                    "select p.*,c.className from product p,classes c where p.classes = c.id ");
        }else {
            sb = new StringBuffer(
                    "select p.*,c.className from product p,classes c where p.classes = c.id and isShow =1 ");
        }

        if(!StringUtils.isEmpty(product.getProductName())){
            sb.append(" and CONCAT(productName,productNumber) LIKE '%"+product.getProductName()+"%'");
        }else if(!StringUtils.isEmpty(product.getClasses())){
            sb.append(" and c.id = "+product.getClasses()+"");
        }else if(!StringUtils.isEmpty(product.getStatus())){
            sb.append(" and status = "+product.getStatus()+"");
        }else if(!StringUtils.isEmpty(product.getUpStatus())){
            sb.append(" and upStatus = "+product.getUpStatus()+"");
        }else if(!StringUtils.isEmpty(product.getIsShow())){
            sb.append(" and isShow =2");
        }

        return sb.toString();
    }



    /*
    * 修改upstatus状态
    * */
    public String updateUpStatusProvider(@Param("ids") String [] ids,@Param("type") String type){
       StringBuffer sb = new StringBuffer();
       if(type.equals("shangjia")){
           sb.append("update product set upStatus=1 ");
       }else if(type.equals("xiajia")){
           sb.append("update product set upStatus=2 ");
       }else if(type.equals("delete")){
           sb.append("update product set isShow=2 ");
       }
       sb.append("where pid in (");
       for(int i=0;i<ids.length;i++){
           sb.append(ids[i]);
           if(i<ids.length-1){
               sb.append(",");
           }
       }
       sb.append(")");
        return sb.toString();
    }


    /*
     * 修改status状态
     * */
    public String updateStatusProvider(@Param("ids") String [] ids,@Param("type") String type){
        StringBuffer sb = new StringBuffer();
        if(type.equals("shenhe")){
            sb.append("update product set status=1 ");
        }else if(type.equals("jujue")){
            sb.append("update product set status=0 ");
        }
        sb.append("where pid in (");
        for(int i=0;i<ids.length;i++){
            sb.append(ids[i]);
            if(i<ids.length-1){
                sb.append(",");
            }
        }
        sb.append(")");
        return sb.toString();
    }








}
