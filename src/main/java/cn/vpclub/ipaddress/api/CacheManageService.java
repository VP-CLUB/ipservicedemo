package cn.vpclub.ipaddress.api;

public interface CacheManageService {
    //缓存取
    Object getCache(Object data, String key);
    //缓存存
    Object putCache(Object data, String key);
    //清除缓存
    int cleanCache(String key);
}
