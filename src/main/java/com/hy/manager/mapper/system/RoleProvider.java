package com.hy.manager.mapper.system;

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



}
