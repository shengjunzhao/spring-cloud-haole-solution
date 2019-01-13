package com.haole.haolecloud.cache.ehcache;

import org.ehcache.CacheManager;
import org.ehcache.config.builders.CacheManagerBuilder;
import org.ehcache.xml.XmlConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * Created by shengjunzhao on 2019/1/12.
 */
@Configuration
public class EhcacheConfig {

    private final String ehcachexml = "/ehcache.xml";

    @Bean("cacheManager")
    public CacheManager ehcacheManage() {
        CacheManager cacheManager = CacheManagerBuilder.newCacheManager(new XmlConfiguration(getClass().getResource(ehcachexml)));
        cacheManager.init();
        return cacheManager;
    }
}
