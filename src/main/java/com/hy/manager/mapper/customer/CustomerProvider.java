package com.hy.manager.mapper.customer;

import com.hy.manager.entity.customer.Customer;

public class CustomerProvider {

    public String selectCustomer(Customer customer) {
        StringBuffer sql = new StringBuffer("select * from customer where 1=1 ");
        if (customer.getAccount() != null && customer.getAccount() != "") {
            sql.append(" and account = '"+customer.getAccount()+"' ");
        }
        if (customer.getName()!= null && customer.getName() != "") {
            sql.append(" and name = '"+customer.getName()+"' ");
        }
        if (customer.getOrderCounts() != null && customer.getOrderCounts() != 0) {
            sql.append(" and  orderCounts= '"+customer.getOrderCounts()+"' ");
        }
        return sql.toString();
    }

}
