package com.hy.manager.mapper.statistics;

public class StatisticsProvider {






    public String queryPayCountsMany(String type,String star,String end,Integer num1,Integer num2){
        StringBuffer sb = new StringBuffer();
        sb.append("SELECT COUNT(*) FROM orders WHERE summoney BETWEEN "+num1+" AND "+num2+" ");
        if("today".equals(type)){
            sb.append(" AND TO_DAYS(submitdate) = TO_DAYS(NOW())");
        }else if(!star.equals("") || !end.equals("")){
            sb.append(" AND submitdate >= '"+star+"' AND submitdate <= '"+end+"'");
        }
        return sb.toString();
    }

}
