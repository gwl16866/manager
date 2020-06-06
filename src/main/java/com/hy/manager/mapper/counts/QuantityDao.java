package com.hy.manager.mapper.counts;

public class QuantityDao {
    //库存列表
    public String selectQuantity(String productOrNumber, Integer status,String time) {
        StringBuffer sql = new StringBuffer("select qy.*,pt.*,o.*,u.* from quantity qy,product pt,orders o,user u where qy.productId=pt.pid and qy.orderId=o.id and qy.userId=u.uid and 1=1 ");
        //商品名称/货号
        if (null != productOrNumber && productOrNumber !="") {
            sql.append(" and pt.productName like '%" + productOrNumber + "%' or pt.productNumber like '%"+productOrNumber+"%'");
        }
        //状态
        if (null != status) {
            sql.append(" and qy.status =" + status );
        }
        //操作时间时间
        if (null != time && time !="") {
            sql.append(" and substr(qy.quantityTime,1,10) = '"+time+"'");
        }
        return sql.toString();
    }
}
