package com.hy.manager.entity.order;

import lombok.Data;
import java.io.Serializable;
//退款原因表
@Data
public class Returnreason  implements Serializable {
    private Integer id;
    private String reason;
    private String reasonTime;
    private Integer reasonStatus;
}
