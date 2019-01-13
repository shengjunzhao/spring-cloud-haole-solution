package com.haole.haolecloud.cache.ehcache;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * Created by shengjunzhao on 2019/1/12.
 */
@Configuration
public class EhcacheConfig {

    private final String ehcachexml = "/ehcache.xml";

    @Bean(value = "cacheManager")
    public EhCacheManager3FactoryBean ehcacheManage() {
        EhCacheManager3FactoryBean factoryBean = new EhCacheManager3FactoryBean();
        factoryBean.setCacheManagerUri(ehcachexml);
        return factoryBean;
    }


}
