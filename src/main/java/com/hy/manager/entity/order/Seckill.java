package com.hy.manager.entity.order;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class Seckill {
    private Integer seckillId;
    private String title;
    private Integer status;
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "Asia/Shanghai")
    @DateTimeFormat(pattern = "yyyy-MM-dd")//前端到后端
    private Date starTime;
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "Asia/Shanghai")
    @DateTimeFormat(pattern = "yyyy-MM-dd")//前端到后端
    private Date endTime;
    private Integer putOrNot;
    private String seckillStarTime;
    private String seckillEndTime;
    private Integer counts;

    private String[] productCounts;
}
