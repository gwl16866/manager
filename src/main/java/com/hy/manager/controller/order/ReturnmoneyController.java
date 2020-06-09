package com.hy.manager.controller.order;

import com.github.pagehelper.PageHelper;
import com.hy.manager.Date.ResultData;
import com.hy.manager.entity.order.Returnmoney;
import com.hy.manager.entity.order.Returnreason;
import com.hy.manager.service.order.IReturnmoneyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author gwl
 * @since 2020-06-04
 */
@RestController
@RequestMapping("/re/returnmoney")
public class ReturnmoneyController {

    @Autowired
    private IReturnmoneyService iReturnmoneyService;

    //退款列表
    @ResponseBody
    @RequestMapping("/selectReturnMoney")
    public ResultData selectReturnMoney(@RequestParam("currentPage") int currentPage,
                                        @RequestParam("pageSize") int pageSize, String serverNumber, String nameOrPhone, String time,Integer applyStatus) {
        ResultData resultData = new ResultData();
        List<Returnmoney> returnmoneyListSize = iReturnmoneyService.selectReturnMoney(serverNumber, nameOrPhone, time,applyStatus);
        PageHelper.startPage(currentPage, pageSize);
        List<Returnmoney> returnmoneyList = iReturnmoneyService.selectReturnMoney(serverNumber, nameOrPhone, time,applyStatus);
        resultData.setDataSize(returnmoneyListSize.size());
        resultData.setData(returnmoneyList);
        return resultData;
    }

    //退款原因列表
    @ResponseBody
    @RequestMapping("/selectReturnReason")
    public ResultData selectReturnReason(@RequestParam("currentPage") int currentPage,
                                         @RequestParam("pageSize") int pageSize) {
        ResultData resultData=new ResultData();
        List<Returnreason> returnreasonListSize=iReturnmoneyService.selectReturnReason();
        PageHelper.startPage(currentPage, pageSize);
        List<Returnreason> returnreasonList=iReturnmoneyService.selectReturnReason();
        resultData.setDataSize(returnreasonListSize.size());
        resultData.setData(returnreasonList);
        return resultData;
    }

    //退款原因是否启用
    @ResponseBody
    @RequestMapping("/OpenOrNotStatus")
    public Integer OpenOrNotStatus(Integer id, Integer reasonStatus) {
        try {
            iReturnmoneyService.OpenOrNotStatus(id, reasonStatus);
        } catch (Exception e) {
            return 0;
        }
        return 1;
    }

    //删除退款原因
    @ResponseBody
    @RequestMapping("/deleteReason")
    public Integer deleteReason(Integer id) {
        try {
            iReturnmoneyService.deleteReason(id);
        } catch (Exception e) {
            return 0;
        }
        return 1;
    }

    //修改退货原因
    @ResponseBody
    @RequestMapping("/updateReason")
    public Integer updateReason(Integer id, String reason) {
        try {
            iReturnmoneyService.updateReason(id, reason);
        } catch (Exception e) {
            return 0;
        }
        return 1;
    }

    //新增退货原因
    @ResponseBody
    @RequestMapping("/addReason")
    public Integer addReason(String reason) {
        try {
            iReturnmoneyService.addReason( reason);
        } catch (Exception e) {
            return 0;
        }
        return 1;
    }

    //同意或者拒绝退款
    @ResponseBody
    @RequestMapping("/agreeReturn")
    public Integer agreeReturn(Integer id,Integer applyStatus){
        try {
            iReturnmoneyService.agreeReturn(id,applyStatus);
        }catch (Exception e){
            return 0;
        }
        return 1;
    }


    //批量同意或者拒绝退款
    @ResponseBody
    @RequestMapping("/batch")
    public Integer batch(String[] batchList,String type){
        try {
            iReturnmoneyService.batch(batchList,type);
        }catch (Exception e){
            return 0;
        }
        return 1;
    }


}
