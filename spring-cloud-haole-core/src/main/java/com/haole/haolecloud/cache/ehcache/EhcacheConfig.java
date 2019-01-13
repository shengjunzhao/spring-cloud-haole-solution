package com.haole.haolecloud.cache.ehcache;

import org.ehcache.CacheManager;
import org.ehcache.config.builders.CacheManagerBuilder;
import org.ehcache.xml.XmlConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * Created by shengjunzhao on 2019/1/12.
 */
@Configuration
public class EhcacheConfig {

    private final String ehcachexml = "/ehcache.xml";

    @Bean(value = "cacheManager")
    public EhCacheManager3FactoryBean ehcacheManage() throws Exception {
        EhCacheManager3FactoryBean factoryBean = new EhCacheManager3FactoryBean();
        factoryBean.setCacheManagerUri(ehcachexml);
        return factoryBean;
    }


}
