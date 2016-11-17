package cn.vpclub.api.model.request;

/**
 * Created by vp on 2016/6/20.
 */
public class AppInfoParam extends PageBaseSearchParamAdapter{
    /**
     * appName
     */
    private String appName;

    public AppInfoParam() {
        super();
    }

    public AppInfoParam(Integer pageSize, Integer pageNo) {
        super(pageSize, pageNo);
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }
}
