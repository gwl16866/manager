package com.hy.manager.entity.system;


import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 
 * </p>
 *
 * @author gwl
 * @since 2020-06-04
 */
@Data
public class Permiss implements Serializable {


    private Integer pid;

    private String permissionName;

    private Integer parentId;

    private String url;

    private List<Permiss> rolesList;


}
