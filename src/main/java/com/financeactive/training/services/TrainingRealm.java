package com.financeactive.training.services;

import com.financeactive.training.entities.User;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.authz.permission.AllPermission;
import org.apache.shiro.cache.MemoryConstrainedCacheManager;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 * Created with IntelliJ IDEA.
 * User: jvedikunnel
 * Date: 26/10/12
 * Time: 11:33
 */
public class TrainingRealm extends AuthorizingRealm {

    Session session;

    public TrainingRealm(@Inject Session session) {
        this.session = session;
        super.setCacheManager(new MemoryConstrainedCacheManager());
        super.setName("UPRealm");
        super.setAuthenticationTokenClass(UsernamePasswordToken.class);
        super.setCredentialsMatcher(new CredentialsMatcher() {
            @Override
            public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
                UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;
                String login = usernamePasswordToken.getUsername();
                String password = new String(usernamePasswordToken.getPassword());
                return login.equals(password);
            }
        });
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.addObjectPermission(new AllPermission());
        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;
        String login = usernamePasswordToken.getUsername();
        User user = (User) session.createCriteria(User.class).add(Restrictions.eq("email", login)).uniqueResult();
        if (user == null) {
            throw new UnknownAccountException("Connais pas le mec: " + usernamePasswordToken.getUsername());
        }
        return new SimpleAuthenticationInfo(usernamePasswordToken.getUsername(), usernamePasswordToken.getPassword(), "UPRealm");
    }
}
