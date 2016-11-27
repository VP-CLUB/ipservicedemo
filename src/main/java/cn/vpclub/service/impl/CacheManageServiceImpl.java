package cn.vpclub.service.impl;

import cn.vpclub.api.CacheManageService;
import cn.vpclub.common.utils.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service(value = "cacheManageServiceImpl")
@Transactional
public class CacheManageServiceImpl implements CacheManageService {

    private static Logger logger = LoggerFactory.getLogger(CacheManageServiceImpl.class);

    @Override
    @Cacheable(value = "demoCache", key = "#key")
    public Object getCache(Object data, String key) {
        logger.info("getCache method key: " + key);
        if (null == key || "".equals(key)) {
            return null;
        }
        logger.info("getCache method data: " + data);
        return data;
    }

    @Override
    @CachePut(value = "demoCache", key = "#key")
    public Object putCache(Object data, String key) {
        logger.info("putCache method key: " + key);
        if (StringUtil.isEmpty(data)) {
            return null;
        }
        logger.info("putCache method data: " + data);
        return data;
    }

    /**
     * Clean Cache Data
     *
     * @param key
     * @return
     */
    @Override
    @CacheEvict(value = "demoCache", key = "#key")
    public int cleanCache(String key) {
        logger.info("cleanCache method key: " + key);
        if (StringUtil.isEmpty(key)) {
            return 0;
        }
        return 1;
    }
}
