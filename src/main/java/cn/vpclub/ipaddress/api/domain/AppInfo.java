package cn.vpclub.ipaddress.api.domain;

import java.util.List;

/**
 * 应用系统信息
 * <p>
 * Created by HJ on 2016/3/29.
 */
public class AppInfo extends BaseAppInfo {

    /**
     * 应用系统接口配置信息数组
     */
    private List<AppConfig> configList;

    public List<AppConfig> getConfigList() {
        return configList;
    }

    public void setConfigList(List<AppConfig> configList) {
        this.configList = configList;
    }
}
