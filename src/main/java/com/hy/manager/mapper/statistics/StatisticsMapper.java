package com.hy.manager.mapper.statistics;

import com.hy.manager.entity.system.DeskPojo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

@Mapper
public interface StatisticsMapper {



    @Select("SELECT SUM(browser) FROM product")
    public Integer queryBrowser();


    @Select("SELECT COUNT(DISTINCT userid) FROM orders")
    public Integer queryDownOrderCounts();


    @Select("SELECT COUNT(*) FROM orders WHERE cphone IS NOT NULL")
    public Integer OrderCounts();

    @Select("SELECT COUNT(*) FROM orders o WHERE o.status != 3")
    public Integer trueOrders();


    @Select("SELECT SUM(summoney) FROM orders")
    public String sumMoney();

    @Select("SELECT SUM(returnmoney) FROM returnmoney WHERE applystatus=2")
    public double queryReturnMoney1();

    @Select("SELECT SUM(returnmoney) FROM returnthings WHERE applystatus=2")
    public double queryReturnMoney2();

    //付款人数
    @Select("SELECT COUNT(DISTINCT userid) FROM orders o WHERE o.status != 3")
    public Integer payPeopleCounts();


    //付款金额
    @Select("SELECT SUM(summoney) FROM orders o WHERE o.status != 3")
    public double payMoney();


    //付款订单
    @Select("SELECT COUNT(*) FROM orders o WHERE o.status != 3")
    public Integer queryPayOrderCounts();



    //付款
    @Select("SELECT SUM(sumMoney)val,DATE_FORMAT(submitDate,'%m')  MONTH FROM orders o WHERE o.status !=3  GROUP BY DATE_FORMAT(submitDate,'%Y%m') ORDER BY DATE_FORMAT(submitDate,'%Y%m')")
    public List<DeskPojo> queryPayMoneyByMonth();


    //退款1
    @Select("SELECT SUM(returnMoney)val,DATE_FORMAT(dispose,'%m')  MONTH FROM returnmoney o WHERE o.applyStatus =2  GROUP BY DATE_FORMAT(dispose,'%Y%m') ORDER BY DATE_FORMAT(dispose,'%Y%m')")
    public List<DeskPojo> queryReturnMoneyByMonth();


    //退款2
    @Select("SELECT SUM(returnMoney)val,DATE_FORMAT(dispose,'%m')  MONTH FROM returnthings o WHERE o.applyStatus =2  GROUP BY DATE_FORMAT(dispose,'%Y%m') ORDER BY DATE_FORMAT(dispose,'%Y%m')")
    public List<DeskPojo> queryReturnMoneyByMonth2();


    @SelectProvider(type = StatisticsProvider.class,method = "queryPayCountsMany")
    public Integer queryPayCountsMany(String type,String star,String end,Integer num1,Integer num2);











}
