package com.hy.manager.mapper.customer;

import com.hy.manager.entity.customer.Customer;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hy.manager.entity.customer.customerOrderProduct;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author gwl
 * @since 2020-06-04
 */
@Mapper
public interface CustomerMapper extends BaseMapper<Customer> {

    @SelectProvider(type = CustomerProvider.class, method = "selectCustomer")
    public List<Customer> listselect(Customer customer);

  @Select("select id,account,name,sex,birthday,address,registDate from customer where id=#{value}")
    public List<Customer> userselect(String id);

  @Select("select name,phoneNo,address,coding from customer where id=#{value}")
    public List<Customer> addselect(String id);

    @Select("select c.*,o.* from customer c,orders o where c.id=o.userId and c.id=#{value}")
    public List<customerOrderProduct> orderselect(String id);

    @Update("update customer set account=#{account},name=#{name},level=#{level},money=#{money},orderCounts=#{orderCounts},status=#{status} where id=#{id}")
    public void upd(Customer customer);

    @Update("update customer set account=#{account},name=#{name},sex=#{sex},birthday=#{birthday},address=#{address},registDate=#{registDate} where id=#{id}")
    public void custupd(Customer customer);

    @Update("update customer set name=#{name},phoneNo=#{phoneNo},address=#{address},coding=#{coding} where id=#{id}")
    public void addupd(Customer customer);

    @Select("SELECT c.*,o.*,p.* FROM customer c,orders o,product p WHERE c.id=o.userId AND o.productId=p.pid AND c.id=#{value}")
    public List<customerOrderProduct> ordersselect(String id);


    @Delete("delete from customer where id=#{value}")
    public void del(String id);
}
