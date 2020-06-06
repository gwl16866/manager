package com.hy.manager.mapper.order.Dao;

public class ReturnThingsDao {
   public String selectReturnThings(String serverNumber,String nameOrPhone,String time) {
        StringBuffer sql = new StringBuffer("select rs.*,rn.reason,c.*,o.* from returnthings rs,returnreason rn, customer c,orders o where rs.returnReason=rn.id and rs.userId=c.id and o.id=rs.orderId and 1=1 ");
       //退款单号
       if (null != serverNumber && serverNumber !="") {
           sql.append(" and rs.serverNumber like '%" + serverNumber + "%'");
       }
       //客户名称/客户手机号
       if (null != nameOrPhone && nameOrPhone !="") {
           sql.append(" and c.name like '%" + nameOrPhone + "%' or c.phoneNo like '%"+nameOrPhone+"%'");
       }
       //退货时间
       if (null != time && time !="") {
           sql.append(" and substr(rs.applyTime,1,10) = '"+time+"'");
       }
        return sql.toString();
    }
}
