package com.hy.manager.mapper.system;

import org.apache.ibatis.annotations.Param;

public class RoleProvider {


    /**
     *
     * @param name
     * @return
     */
    public String queryRoles(String name){
        StringBuffer sb = new StringBuffer();
        sb.append("select * from role where 1=1  ");
        if(null != name && !"".equals(name)){
            sb.append(" and role like '%"+name+"%'");
        }
        return sb.toString();
    }


    public String addUserRoles(@Param("uid") Integer uid, @Param("haveRoles") String []haveRoles){
        StringBuffer sb = new StringBuffer();
        sb.append("insert into userrole (uid,rid) values ");
        for(int i=0;i<haveRoles.length;i++){
            sb.append("(");
            sb.append(uid+","+haveRoles[i]);
            sb.append(")");
            if(i<haveRoles.length-1){
                sb.append(",");
            }
        }
        return sb.toString();
    }







}
