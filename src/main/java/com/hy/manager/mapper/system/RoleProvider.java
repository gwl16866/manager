package com.hy.manager.mapper.system;

import org.apache.ibatis.annotations.Param;

public class RoleProvider {


    /**
     *查询role列表
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


    /**
     * 给用户添加角色
     * @param uid
     * @param haveRoles
     * @return
     */
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


    /**
     * 添加权限
     * @param havePerms
     * @param rid
     * @return
     */
    public String addRolePerms(@Param("haveRoles") String [] havePerms,@Param("rid") Integer rid){
        StringBuffer sb = new StringBuffer();
        sb.append("insert into rolepermission (rid,pid) values ");
        for(int i=0;i<havePerms.length;i++){
            sb.append("(");
            sb.append(rid+","+havePerms[i]);
            sb.append(")");
            if(i<havePerms.length-1){
                sb.append(",");
            }
        }
        return sb.toString();
    }




}
