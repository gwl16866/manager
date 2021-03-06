package com.hy.manager.mapper.order.Dao;

public class OrderDao {
    public String selectOrders(String orderOrProduct,String nameOrPhone,String time) {
        StringBuffer sql = new StringBuffer("select o.*,c.*,p.* from orders o,product p,customer c where o.userId=c.id and o.productId=p.pid and o.status !=10 and 1=1 ");
        //订单编号/商品编号
        if (null != orderOrProduct && orderOrProduct !="") {
            sql.append(" and o.orderNumber like '%" + orderOrProduct + "%' or o.productId like '%"+orderOrProduct+"%'");
        }
        //客户名称/客户手机号
        if (null != nameOrPhone && nameOrPhone !="") {
            sql.append(" and o.cname like '%" + nameOrPhone + "%' or o.cphone like '%"+nameOrPhone+"%'");
        }
        //提交时间
        if (null != time && time !="") {
            sql.append(" and substr(o.submitDate,1,10) = '"+time+"'");
        }

        return sql.toString();
    }
}
