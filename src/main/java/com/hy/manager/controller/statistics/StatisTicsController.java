package com.hy.manager.controller.statistics;

import com.hy.manager.entity.statistics.TableOne;
import com.hy.manager.entity.statistics.TableTwo;
import com.hy.manager.entity.system.FourObject;
import com.hy.manager.entity.system.TwoObject;
import com.hy.manager.service.statistics.StatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("sta")
public class StatisTicsController {
    @Autowired
    private StatisticsService statisticsService;


    /**
     * 查询table统计
     * @return
     */
    @RequestMapping("/statisticsTable")
    public List<TableOne> statisticsTable(){
        TableOne one = new TableOne();
        one.setBrowser(statisticsService.queryBrowser());
        one.setDownOrderCounts(statisticsService.queryDownOrderCounts());
        one.setOrderCounts(statisticsService.OrderCounts());
        one.setTrueOrderCounts(statisticsService.trueOrders());
        one.setSumMoney(statisticsService.sumMoney());
        List<TableOne> list = new ArrayList<>();
        list.add(one);
        return list;
    }


    /**
     * 查询table统计
     * @return
     */
    @RequestMapping("/statisticsTable2")
    public List<TableTwo> statisticsTable2(){
        TableTwo two = new TableTwo();
        two.setReturnMoney(statisticsService.returnMoney());
        two.setPayPeopleCounts(statisticsService.payPeopleCounts());
        two.setKedanMoney(statisticsService.kedanPrice());
        two.setPayMoney(statisticsService.payMoney());
        two.setPayOrderCounts(statisticsService.queryPayOrderCounts());
        List<TableTwo> list = new ArrayList<>();
        list.add(two);
        return list;
    }


    /**
     * 查询折线交易
     * @return
     */
    @RequestMapping("/statisticsPayReturn")
    public TwoObject statisticsPayReturn(){
        TwoObject twoObject= new TwoObject();
        twoObject.setPay(statisticsService.selectPayMoneyByMonth());
        twoObject.setReturns(statisticsService.selectReturnMoneyByMonth());
        return twoObject;
    }


    /**
     * 查询柱状统计图
     * @return
     */
    @RequestMapping("/queryPayMoneyMany")
    public List<Integer> queryPayMoneyMany(String type,String [] date){
        String star="";
        String end="";
        if(null != date && date.length>0){
            star = date[0].substring(0,10);
            end  = date[1].substring(0,10);
        }

        return statisticsService.queryPayCountsMany(type,star,end);
    }










}
