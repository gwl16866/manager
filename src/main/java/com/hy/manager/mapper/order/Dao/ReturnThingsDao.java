package com.hy.manager.mapper.order.Dao;

import com.hy.manager.entity.order.Seckill;
import org.apache.ibatis.annotations.Param;

import java.text.SimpleDateFormat;
import java.util.Locale;

public class ReturnThingsDao {
    //退货列表
   public String selectReturnThings(String serverNumber,String nameOrPhone,String time,Integer applyStatus) {
        StringBuffer sql = new StringBuffer("select rs.*,rn.reason,c.*,o.*,p.*,a.* from returnthings rs,returnreason rn, customer c,orders o,product p,address a  where rs.returnReason=rn.id and rs.userId=c.id and o.id=rs.orderId and p.pid=rs.pid and rs.aid=a.id and 1=1 ");
       //退款单号
       if (null != serverNumber && serverNumber !="") {
           sql.append(" and rs.serverNumber like '%" + serverNumber + "%'");
       }
       //客户名称/客户手机号
       if (null != nameOrPhone && nameOrPhone !="") {
           sql.append(" and concat(a.phoneNo,c.name) like '%" + nameOrPhone + "%'");
       }
       //退货时间
       if (null != time && time !="") {
           sql.append(" and substr(rs.applyTime,1,10) >= '"+time+"'");
       }
       if(null !=applyStatus ){
           sql.append(" and rs.applyStatus = "+applyStatus);
       }
        return sql.toString();
    }


    //批量
    public String batch(@Param("batchList")String[] batchList, @Param("type") String type){
        StringBuffer sb = new StringBuffer();
        if(type.equals("agree")){
            sb.append("update returnthings set applyStatus=2,dispose=now()");
        }else if(type.equals("refuse")){
            sb.append("update returnthings set applyStatus=3,dispose=now() ");
        }
        sb.append("where id in (");
        for(int i=0;i<batchList.length;i++){
            sb.append(batchList[i]);
            if(i<batchList.length-1){
                sb.append(",");
            }
        }
        sb.append(")");
        return sb.toString();
    }


    //秒杀
    public String selectSeckill(Seckill seckill) {
        StringBuffer sql = new StringBuffer("select s.* from seckill s where  s.status !=3 and 1=1 ");
        //标题
        if (null != seckill.getTitle() && seckill.getTitle() !="") {
            sql.append(" and s.title like '%" + seckill.getTitle() + "%'");
        }
        //开始时间
        if (null != seckill.getStarTime() ) {
            SimpleDateFormat s=new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
            sql.append(" and s.starTime >= '"+s.format(seckill.getStarTime())+"'");
        }
        //结束
        if (null != seckill.getEndTime() ) {
            SimpleDateFormat s=new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
            sql.append(" and s.endTime <= '"+s.format(seckill.getEndTime())+"'");
        }
        //状态
        if(null !=seckill.getStatus() ){
            sql.append(" and s.status = "+seckill.getStatus());
        }
        return sql.toString();
    }
}
