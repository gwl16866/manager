package com.hy.manager.entity.system;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class RoleData implements Serializable {


    private List<Permiss> allPerms;
    private List<Integer> havePerms;


}
