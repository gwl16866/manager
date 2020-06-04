package com.hy.manager.entity.product;

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
public class Specificationparameter implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer classes;

    private Integer specification;

    private Integer color;


}
