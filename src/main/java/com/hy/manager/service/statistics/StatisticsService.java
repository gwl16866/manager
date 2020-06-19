package com.hy.manager.service.statistics;

import com.hy.manager.entity.system.DeskMonth;
import com.hy.manager.entity.system.DeskPojo;
import com.hy.manager.mapper.statistics.StatisticsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

@Service
public class StatisticsService {
    @Autowired
    private StatisticsMapper statisticsMapper;


    public Integer queryBrowser(){
      return   statisticsMapper.queryBrowser();
    }


    public Integer queryDownOrderCounts(){
        return   statisticsMapper.queryDownOrderCounts();
    }

    public Integer OrderCounts(){
        return   statisticsMapper.OrderCounts();
    }

    public Integer trueOrders(){
        return   statisticsMapper.trueOrders();
    }

    public String sumMoney(){
        return   statisticsMapper.sumMoney();
    }

    public double returnMoney(){
        return statisticsMapper.queryReturnMoney1()+statisticsMapper.queryReturnMoney2();
    }

    public Integer payPeopleCounts(){
        return statisticsMapper.payPeopleCounts();
    }

    public double payMoney(){
        return statisticsMapper.payMoney();
    }

    public String kedanPrice(){
       Double pri = statisticsMapper.payMoney()/statisticsMapper.payPeopleCounts();
        DecimalFormat f = new DecimalFormat("0.00");
        f.setRoundingMode(RoundingMode.HALF_UP);
        return f.format(pri);
    }

    public Integer queryPayOrderCounts(){
        return statisticsMapper.queryPayOrderCounts();
    }

    public ArrayList<String> selectPayMoneyByMonth() {
        DeskMonth dm=new DeskMonth();
        List<DeskPojo> d = statisticsMapper.queryPayMoneyByMonth();

        for(int i=0;i<d.size();i++){
            if(d.get(i).getMonth().equals("01")){
                dm.setOne(d.get(i).getVal());
            }
            if(d.get(i).getMonth().equals("02")){
                dm.setTwo(d.get(i).getVal());
            }
            if(d.get(i).getMonth().equals("03")){
                dm.setThree(d.get(i).getVal());
            }
            if(d.get(i).getMonth().equals("04")){
                dm.setFour(d.get(i).getVal());
            }
            if(d.get(i).getMonth().equals("05")){
                dm.setFive(d.get(i).getVal());
            }
            if(d.get(i).getMonth().equals("06")){
                dm.setSix(d.get(i).getVal());
            }
            if(d.get(i).getMonth().equals("07")){
                dm.setSeven(d.get(i).getVal());
            }
            if(d.get(i).getMonth().equals("08")){
                dm.setEight(d.get(i).getVal());
            }
            if(d.get(i).getMonth().equals("09")){
                dm.setNine(d.get(i).getVal());
            }
            if(d.get(i).getMonth().equals("10")){
                dm.setTen(d.get(i).getVal());
            }
            if(d.get(i).getMonth().equals("11")){
                dm.setEleven(d.get(i).getVal());
            }
            if(d.get(i).getMonth().equals("12")){
                dm.setTwelve(d.get(i).getVal());
            }
        }
        ArrayList<String> arr = new ArrayList<>();
        arr.add(0,dm.getOne());
        arr.add(1,dm.getTwo());
        arr.add(2,dm.getThree());
        arr.add(3,dm.getFour());
        arr.add(4,dm.getFive());
        arr.add(5,dm.getSix());
        arr.add(6,dm.getSeven());
        arr.add(7,dm.getEight());
        arr.add(8,dm.getNine());
        arr.add(9,dm.getTen());
        arr.add(10,dm.getEleven());
        arr.add(11,dm.getTwelve());
        return arr;
    }


    public ArrayList<Double> selectReturnMoneyByMonth() {
        DeskMonth dm=new DeskMonth();
        DeskMonth dm1=new DeskMonth();
        List<DeskPojo> d = statisticsMapper.queryReturnMoneyByMonth();
        List<DeskPojo> d1 = statisticsMapper.queryReturnMoneyByMonth2();

        for(int i=0;i<d.size();i++){
            if(d.get(i).getMonth().equals("01")){
                dm.setOne(d.get(i).getVal());
            }
            if(d.get(i).getMonth().equals("02")){
                dm.setTwo(d.get(i).getVal());
            }
            if(d.get(i).getMonth().equals("03")){
                dm.setThree(d.get(i).getVal());
            }
            if(d.get(i).getMonth().equals("04")){
                dm.setFour(d.get(i).getVal());
            }
            if(d.get(i).getMonth().equals("05")){
                dm.setFive(d.get(i).getVal());
            }
            if(d.get(i).getMonth().equals("06")){
                dm.setSix(d.get(i).getVal());
            }
            if(d.get(i).getMonth().equals("07")){
                dm.setSeven(d.get(i).getVal());
            }
            if(d.get(i).getMonth().equals("08")){
                dm.setEight(d.get(i).getVal());
            }
            if(d.get(i).getMonth().equals("09")){
                dm.setNine(d.get(i).getVal());
            }
            if(d.get(i).getMonth().equals("10")){
                dm.setTen(d.get(i).getVal());
            }
            if(d.get(i).getMonth().equals("11")){
                dm.setEleven(d.get(i).getVal());
            }
            if(d.get(i).getMonth().equals("12")){
                dm.setTwelve(d.get(i).getVal());
            }
        }

        for(int i=0;i<d1.size();i++){
            if(d1.get(i).getMonth().equals("01")){
                dm1.setOne(d1.get(i).getVal());
            }
            if(d1.get(i).getMonth().equals("02")){
                dm1.setTwo(d1.get(i).getVal());
            }
            if(d1.get(i).getMonth().equals("03")){
                dm1.setThree(d1.get(i).getVal());
            }
            if(d1.get(i).getMonth().equals("04")){
                dm1.setFour(d1.get(i).getVal());
            }
            if(d1.get(i).getMonth().equals("05")){
                dm1.setFive(d1.get(i).getVal());
            }
            if(d1.get(i).getMonth().equals("06")){
                dm1.setSix(d1.get(i).getVal());
            }
            if(d1.get(i).getMonth().equals("07")){
                dm1.setSeven(d1.get(i).getVal());
            }
            if(d1.get(i).getMonth().equals("08")){
                dm1.setEight(d1.get(i).getVal());
            }
            if(d1.get(i).getMonth().equals("09")){
                dm1.setNine(d1.get(i).getVal());
            }
            if(d1.get(i).getMonth().equals("10")){
                dm1.setTen(d1.get(i).getVal());
            }
            if(d1.get(i).getMonth().equals("11")){
                dm1.setEleven(d1.get(i).getVal());
            }
            if(d1.get(i).getMonth().equals("12")){
                dm1.setTwelve(d1.get(i).getVal());
            }
        }

        ArrayList<Double> arr = new ArrayList<>();
        arr.add(0,Double.valueOf(dm.getOne())+Double.valueOf(dm1.getOne()));
        arr.add(1,Double.valueOf(dm.getTwo())+Double.valueOf(dm1.getTwo()));
        arr.add(2,Double.valueOf(dm.getThree())+Double.valueOf(dm1.getThree()));
        arr.add(3,Double.valueOf(dm.getFour())+Double.valueOf(dm1.getFour()));
        arr.add(4,Double.valueOf(dm.getFive())+Double.valueOf(dm1.getFive()));
        arr.add(5,Double.valueOf(dm.getSix())+Double.valueOf(dm1.getSix()));
        arr.add(6,Double.valueOf(dm.getSeven())+Double.valueOf(dm1.getSeven()));
        arr.add(7,Double.valueOf(dm.getEight())+Double.valueOf(dm1.getEight()));
        arr.add(8,Double.valueOf(dm.getNine())+Double.valueOf(dm1.getNine()));
        arr.add(9,Double.valueOf(dm.getTen())+Double.valueOf(dm1.getTen()));
        arr.add(10,Double.valueOf(dm.getEleven())+Double.valueOf(dm1.getEleven()));
        arr.add(11,Double.valueOf(dm.getTwelve())+Double.valueOf(dm1.getTwelve()));
        return arr;
    }


    public List<Integer> queryPayCountsMany(String type,String star,String end){
        List<Integer> list=new ArrayList<>();
        list.add(statisticsMapper.queryPayCountsMany(type,star,end,0,50));
        list.add(statisticsMapper.queryPayCountsMany(type,star,end,51,100));
        list.add(statisticsMapper.queryPayCountsMany(type,star,end,101,200));
        list.add(statisticsMapper.queryPayCountsMany(type,star,end,201,500));
        list.add(statisticsMapper.queryPayCountsMany(type,star,end,501,1000));
        list.add(statisticsMapper.queryPayCountsMany(type,star,end,1001,5000));
        list.add(statisticsMapper.queryPayCountsMany(type,star,end,5000,10000));
        return list;
    };













}

