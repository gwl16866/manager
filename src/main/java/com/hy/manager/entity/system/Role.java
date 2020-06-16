package com.hy.manager.entity.system;


import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author gwl
 * @since 2020-06-04
 */
@Data
public class Role implements Serializable {


    private Integer rid;

    private Integer status;

    private String roleName;


}
