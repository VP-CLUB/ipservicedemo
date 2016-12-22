package cn.vpclub.ipaddress.storage.annotation;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Caching;

import java.lang.annotation.*;

/**
 * Created by admin on 2016/10/14.
 */
@Caching(
        evict = {
                @CacheEvict(value = "appConfig", allEntries = true),
                @CacheEvict(value = "appInfo", allEntries = true)
        }
)
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface AppInfoEvictCache {
}
