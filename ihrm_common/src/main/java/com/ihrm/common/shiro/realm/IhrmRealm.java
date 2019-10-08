package com.ihrm.common.shiro.realm;

import com.ihrm.domain.system.response.ProfileResult;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import java.util.Set;

//公共的realm：获取安全信息，构造权限信息
public class IhrmRealm extends AuthorizingRealm {

    public void setName(String name) {
        super.setName("ihrmRealm");
    }

    //授权方法
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //1.获取安全数据
        ProfileResult resut = (ProfileResult) principalCollection.getPrimaryPrincipal();
        //2.获取权限信息
        Set<String> apisPerms = (Set<String>) resut.getRoles().get("apis");
        //3.构造权限数据，返回值
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.setStringPermissions(apisPerms);
        return info;
    }

    //认证方法
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        return null;
    }
}
