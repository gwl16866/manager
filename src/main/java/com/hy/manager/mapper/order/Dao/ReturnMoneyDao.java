package com.hy.manager.mapper.order.Dao;

public class ReturnMoneyDao {
    public String selectReturnMoney(String serverNumber,Integer applyStatus,String time) {
        StringBuffer sql = new StringBuffer("select ry.*,rn.reason,c.*,o.*,p.* from returnmoney ry,returnreason rn, customer c,orders o,product p where ry.returnReason=rn.id  and ry.userId=c.id and o.id=ry.orderId and ry.pid=p.pid and 1=1 ");
        //退款单号
        if (null != serverNumber && serverNumber !="") {
            sql.append(" and ry.serverNumber like '%" + serverNumber + "%'");
        }
        //退款状态
        if (applyStatus !=null) {
            sql.append(" and ry.applyStatus =" + applyStatus );
        }
        //退款时间
        if (null != time && time !="") {
            sql.append(" and substr(ry.applyTime,1,10) = '"+time+"'");
        }
        return sql.toString();
    }
}
