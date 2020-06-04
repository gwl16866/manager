package com.hy.manager.entity.customer;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author gwl
 * @since 2020-06-04
 */
@Data
public class Customer implements Serializable {

    private static final long serialVersionUID = 1L;

    private String account;

    private String name;

    private String level;

    private BigDecimal money;

    private Integer orderCounts;

    private String registDate;

    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "Asia/Shanghai")
    @DateTimeFormat(pattern = "yyyy-MM-dd")//前端到后端
    private Date birthday;

    private String phoneNo;

    private String address;

    private Integer status;


}
