package com.hy.manager.mapper.customer;

import com.hy.manager.entity.customer.Customer;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
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
    @Update("update customer set account=#{account},name=#{name},level=#{level},money=#{money},orderCounts=#{orderCounts},status=#{status} where id=#{id}")
    public void upd(Customer customer);
    @Delete("delete from customer where id=#{value}")
    public void del(String id);
}
