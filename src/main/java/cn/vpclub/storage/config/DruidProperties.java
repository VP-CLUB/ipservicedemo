package cn.vpclub.storage.config;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by  vpclub on 16-10-9.
 * PackageName cn.vpclub.common.config
 * ModifyDate  16-10-9
 * Description (constants prop 配置类)
 * ProjectName cmos-finance
 */
@Component
@ConfigurationProperties(prefix = "druid")
public class DruidProperties {

    private String allow;
    private String deny;
    private String loginUsername;
    private String loginPassword;

    public String getAllow() {
        return allow;
    }

    public void setAllow(String allow) {
        this.allow = allow;
    }

    public String getDeny() {
        return deny;
    }

    public void setDeny(String deny) {
        this.deny = deny;
    }

    public String getLoginUsername() {
        return loginUsername;
    }

    public void setLoginUsername(String loginUsername) {
        this.loginUsername = loginUsername;
    }

    public String getLoginPassword() {
        return loginPassword;
    }

    public void setLoginPassword(String loginPassword) {
        this.loginPassword = loginPassword;
    }
}

