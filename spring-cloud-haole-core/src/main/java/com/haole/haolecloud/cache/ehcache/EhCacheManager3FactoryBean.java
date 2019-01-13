package com.haole.haolecloud.cache.ehcache;

import org.ehcache.CacheManager;
import org.ehcache.config.builders.CacheManagerBuilder;
import org.ehcache.xml.XmlConfiguration;
import org.springframework.beans.factory.BeanClassLoaderAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.lang.Nullable;


/**
 * Created by shengjunzhao on 2019/1/13.
 */
public class EhCacheManager3FactoryBean implements FactoryBean<CacheManager>, BeanClassLoaderAware, InitializingBean, DisposableBean {

    private String cacheManagerUri;
    @Nullable
    private ClassLoader beanClassLoader;
    @Nullable
    private CacheManager cacheManager;

    public void setCacheManagerUri(String cacheManagerUri) {
        this.cacheManagerUri = cacheManagerUri;
    }

    @Override
    public void setBeanClassLoader(ClassLoader classLoader) {
        this.beanClassLoader = classLoader;
    }

    @Override
    public void destroy() throws Exception {
        if (null != cacheManager) {
            cacheManager.close();
        }
    }

    @Override
    public CacheManager getObject() throws Exception {
        return this.cacheManager;
    }

    @Override
    public Class<?> getObjectType() {
        return (this.cacheManager != null ? this.cacheManager.getClass() : CacheManager.class);
    }

    @Override
    public boolean isSingleton() {
        return true;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
//        if (null == beanClassLoader) {
//            cacheManager = CacheManagerBuilder.newCacheManager(new XmlConfiguration(getClass().getResource(cacheManagerUri)));
//            cacheManager.init();
//        } else {
//            cacheManager = CacheManagerBuilder.newCacheManager(new XmlConfiguration(beanClassLoader.getResource(cacheManagerUri)));
//            cacheManager.init();
//        }
        cacheManager = CacheManagerBuilder.newCacheManager(new XmlConfiguration(getClass().getResource(cacheManagerUri)));
        cacheManager.init();
    }
}
