package com.hy.manager.controller.product;


import com.github.pagehelper.PageHelper;
import com.hy.manager.Date.ResultData;
import com.hy.manager.entity.product.ClassModel;
import com.hy.manager.entity.product.ClassesBo;
import com.hy.manager.entity.product.Product;
import com.hy.manager.service.product.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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

    /**
     * 查询商品列表
     * @param currentPage
     * @param pageSize
     * @param product
     * @return
     */
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

    /**
     * 查询所有类别表table分页
     * @return
     */
    @RequestMapping("/queryClassesTable")
    public ResultData queryClassesTable(@RequestParam("currentPage") int currentPage,
                                        @RequestParam("pageSize") int pageSize,
                                        Integer classId){
        ResultData resultData = new ResultData();
        resultData.setDataSize(productService.queryClassesTable(classId).size());
        PageHelper.startPage(currentPage,pageSize);
        List<ClassesBo> classsesList = productService.queryClassesTable(classId);
        resultData.setData(classsesList);
        return resultData;
    }



    /**
     * 根据id查一条商品
     * @param pid
     * @return
     */
    @RequestMapping("/queryProductById")
    public List<Product> queryProductById(Integer pid){
        List<Product> list =new ArrayList<>();
        list.add(productService.queryProductById(pid));
        return list;

    }


    /**
     * 查询所有类别
     * @return
     */
    @RequestMapping("/queryClasses")
    public List<ClassesBo> selectClasses(){
       return productService.selectClasses();
    }

    /**
     *修改上架状态
     */
    @RequestMapping("/updateUpStatusById")
    public ResultData updateUpStatusById(Product product){
        ResultData resultData = new ResultData();
        Integer v = productService.updateUpStatusById(product);
        if(v >0){
            resultData.setCode(200);
        }else {
            resultData.setCode(400);
        }
        return resultData;
    }



    /**
     *修改审核状态
     */
    @RequestMapping("/updateStatusById")
    public ResultData updateStatusById(Product product,Integer showStatus){
        ResultData resultData = new ResultData();
        Integer isShowVal=0;
        //恢复当前商品的isshow状态
        if(null != showStatus && showStatus == 1 ){
           isShowVal = productService.updateIsShow(product.getPid());
        }
        Integer v = productService.updateStatusById(product);
        //当拒绝时 也下架
        if(product.getStatus() == 0){
            //下架
            Product xiajiaProduct = new Product();
            xiajiaProduct.setPid(product.getPid());
            xiajiaProduct.setUpStatus(2);
            Integer xiajiaVal = productService.updateUpStatusById(xiajiaProduct);

        }
        if(v >0 && isShowVal >0){
            resultData.setCode(200);
        }else {
            resultData.setCode(400);
        }
        return resultData;
    }



    /**
     *物理删除
     */
    @RequestMapping("/deleteProductById")
    public ResultData deleteProductById(Integer id){
        ResultData resultData = new ResultData();
        Integer v = productService.deleteProductById(id);
        //修改审核状态为拒绝
        Product jujueProduct = new Product();
        jujueProduct.setPid(id);
        jujueProduct.setStatus(0);
        Integer shenheVal = productService.updateStatusById(jujueProduct);
        //下架
        Product xiajiaProduct = new Product();
        xiajiaProduct.setPid(id);
        xiajiaProduct.setUpStatus(2);
        Integer xiajiaVal = productService.updateUpStatusById(xiajiaProduct);

        if(v >0 && shenheVal >0 && xiajiaVal >0){
            resultData.setCode(200);
        }else {
            resultData.setCode(400);
        }
        return resultData;
    }


    /**
     *批量修改上架状态
     */
    @RequestMapping(value = "/controlSome")
    public ResultData controlSome(String [] ids,String type){
        ResultData resultData = new ResultData();
        Integer v=0;
        if("shangjia".equals(type)){
            //先去查询 这些需要上架的商品是否已审核
            Integer[] list = productService.queryStatus(ids);
            if(list.length>0){
                v = productService.updateUpStatusProvider(list,type);
            }else{
                v=-1;
            }
        }else{
            //下架 删除
            v = productService.updateUpStatusProvider(ids,type);
        }
        if(v >0){
            resultData.setCode(200);
        }else if(v==-1){
            resultData.setCode(300);
        }else {
            resultData.setCode(400);
        }

        return resultData;
    }


    /**
     *批量修改审核状态
     */
    @RequestMapping(value = "/controlSomeStatus")
    public ResultData controlSomeStatus(String [] ids,String type){
        ResultData resultData = new ResultData();
        Integer v = productService.updateStatusProvider(ids,type);
        Integer xiajiaVal = productService.updateUpStatusProvider(ids,"xiajia");

        if(v >0 && xiajiaVal >0){
            resultData.setCode(200);
        }else {
            resultData.setCode(400);
        }
        return resultData;
    }

    /**
     *修改商品类别是否可用
     */
    @RequestMapping("/updateClassStatus")
    public ResultData updateClassStatus(ClassesBo classesBo){
        ResultData resultData = new ResultData();
        Integer v = productService.updateClassStatus(classesBo);
        if(v >0){
            resultData.setCode(200);
        }else {
            resultData.setCode(400);
        }
        return resultData;
    }

    /**
     *添加类别
     */
    @RequestMapping("/addClasses")
    public ResultData addClasses(ClassesBo classesBo){
        ResultData resultData = new ResultData();
        Integer v = productService.addClasses(classesBo);
        if(v >0){
            resultData.setCode(200);
        }else {
            resultData.setCode(400);
        }
        return resultData;
    }



    /**
     *  查询规格 或颜色
     */
    @RequestMapping("/queryClassModel")
    public ResultData queryClassModel( @RequestParam("currentPage") int currentPage,
                                        @RequestParam("pageSize") int pageSize,
                                        ClassModel classModel){
        ResultData resultData = new ResultData();
        List<ClassModel> list = productService.queryClassModel(classModel);
        PageHelper.startPage(currentPage,pageSize);
        resultData.setData(productService.queryClassModel(classModel));
        resultData.setDataSize(list.size());
        return resultData;
    }


    /**
     *添加规格或颜色
     */
    @RequestMapping("/addModelOrColor")
    public ResultData addModelOrColor(ClassModel classModel){
        ResultData resultData = new ResultData();
        Integer v = productService.addModelOrColor(classModel);
        if(v >0){
            resultData.setCode(200);
        }else {
            resultData.setCode(400);
        }
        return resultData;
    }

    /**
     *删除规格或颜色
     */
    @RequestMapping("/delModelOrColor")
    public ResultData delModelOrColor(ClassModel classModel){
        ResultData resultData = new ResultData();
        Integer v = productService.delModelOrColor(classModel);
        if(v >0){
            resultData.setCode(200);
        }else {
            resultData.setCode(400);
        }
        return resultData;
    }
















}
