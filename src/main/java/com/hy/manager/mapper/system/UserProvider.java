package com.hy.manager.mapper.system;

import com.hy.manager.entity.customer.Customer;
import com.hy.manager.entity.system.User;
import org.apache.ibatis.annotations.Select;

public class UserProvider {

    public String selectUser(User user) {
        StringBuffer sql = new StringBuffer("select * from user where status=1 and 1=1 ");
        if (user.getUserName() != null && user.getUserName() != "") {
            sql.append(" and userName = '"+user.getUserName()+"' ");
        }
        if (user.getPhoneNo()!= null && user.getPhoneNo() != "") {
            sql.append(" and phoneNo = '"+user.getPhoneNo()+"' ");
        }

        return sql.toString();
    }
}
