package com.hy.manager.entity.statistics;

import lombok.Data;

@Data
public class TableOne {

    private Integer browser;
    private Integer downOrderCounts;
    private Integer orderCounts;
    private Integer trueOrderCounts;
    private String  sumMoney;

}
