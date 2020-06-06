package com.hy.manager.controller.order;

import com.hy.manager.entity.order.Returnmoney;
import com.hy.manager.entity.order.Returnreason;
import com.hy.manager.service.order.IReturnmoneyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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
@RequestMapping("/re/returnmoney")
public class ReturnmoneyController {

    @Autowired
    private IReturnmoneyService iReturnmoneyService;

    //退款列表
    @ResponseBody
    @RequestMapping("/selectReturnMoney")
    public List<Returnmoney> selectReturnMoney(String serverNumber,Integer applyStatus,String time){

        return iReturnmoneyService.selectReturnMoney(serverNumber,applyStatus,time);
    }

    //退款原因列表
    @ResponseBody
    @RequestMapping("/selectReturnReason")
    public List<Returnreason> selectReturnReason(){
        return iReturnmoneyService.selectReturnReason();
    }

    //退款原因是否启用
    @ResponseBody
    @RequestMapping("/OpenOrNotStatus")
    public Integer OpenOrNotStatus(Integer id,Integer reasonStatus){
        try {
            iReturnmoneyService.OpenOrNotStatus(id,reasonStatus);
        } catch (Exception e) {
            return 0;
        }
            return 1;
    }

    //删除退款原因
    @ResponseBody
    @RequestMapping("/deleteReason")
    public Integer deleteReason(Integer id){
        try {
            iReturnmoneyService.deleteReason(id);
        } catch (Exception e) {
            return 0;
        }
        return 1;
    }
}
