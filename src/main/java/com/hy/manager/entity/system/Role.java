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

    private static final long serialVersionUID = 1L;


    private Integer rid;

    private String role;


}
