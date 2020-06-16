package com.hy.manager.entity.order;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

@Data
public class SeckillTwo {
    private Integer seckillId;
    private String title;

    @DateTimeFormat(pattern = "yyyy-MM-dd")//前端到后端
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "Asia/Shanghai")
    private String starTime;

    @DateTimeFormat(pattern = "yyyy-MM-dd")//前端到后端
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "Asia/Shanghai")
    private String endTime;
    private String seckillStarTime;
    private String seckillEndTime;

    private Integer status;

    private Integer putOrNot;

    private Integer counts;

    private String productCounts;
}
