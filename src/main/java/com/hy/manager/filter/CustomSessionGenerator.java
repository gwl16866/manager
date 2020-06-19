package com.hy.manager.filter;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.eis.SessionIdGenerator;

import java.io.Serializable;
import java.util.UUID;

/**
 * 自定义 sessionID 生成
 *
 * @author licheng
 * @date 2020/6/16 15:35
 */
public class CustomSessionGenerator implements SessionIdGenerator {


    @Override
    public Serializable generateId(Session session) {
        return "GWL" + UUID.randomUUID().toString().replace("-", "");
    }
}
