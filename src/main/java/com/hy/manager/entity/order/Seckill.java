package com.hy.manager.entity.order;

import lombok.Data;

import java.util.Date;

@Data
public class Seckill {
    private Integer seckillId;
    private String title;
    private Integer status;
    private Date starTime;
    private Date endTime;
    private Integer putOrNot;
    private String seckillStarTime;
    private String seckillEndTime;
    private Integer counts;
}
