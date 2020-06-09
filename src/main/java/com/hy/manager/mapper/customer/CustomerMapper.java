package com.hy.manager.mapper.customer;

import com.hy.manager.entity.customer.Address;
import com.hy.manager.entity.customer.Customer;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hy.manager.entity.customer.CustomerOrderProduct;
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

  @Select("select c.id,c.account,c.name,c.sex,c.birthday,a.aname,c.registDate from customer c,address a where c.id=a.fid and c.id=#{value}")
    public List<CustomerOrderProduct> userselect(String id);

  @Select("select c.name,a.phoneNo,a.aname,c.coding from customer c,address a where c.id=a.fid and c.id=#{value}")
    public List<CustomerOrderProduct> addselect(String id);

    @Select("select c.*,o.*,a.* from customer c,orders o,address a where c.id=o.userId and c.id=a.fid and c.id=#{value}")
    public List<CustomerOrderProduct> orderselect(String id);

    @Update("update customer set account=#{account},name=#{name},level=#{level},money=#{money},orderCounts=#{orderCounts},status=#{status} where id=#{id}")
    public void upd(Customer customer);

    @Update("update customer set account=#{account},name=#{name},sex=#{sex},birthday=#{birthday},registDate=#{registDate} where id=#{id}")
    public void custupd(Customer customer);
//
    @Update("update address set aname=#{aname} where id=#{id}")
    public void addupd(Address address);

    @Select("select c.*,o.*,p.*,a.* from customer c,orders o,product p,address a where c.id=o.userId and o.productId=p.pid and c.id=a.fid and c.id=#{value}")
    public CustomerOrderProduct ordersselect(String id);


    @Delete("delete from customer where id=#{value}")
    public void del(String id);
}
