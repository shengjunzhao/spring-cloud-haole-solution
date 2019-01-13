package com.haole.haolecloud.cache.ehcache;

import org.ehcache.event.CacheEvent;
import org.ehcache.event.CacheEventListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by shengjunzhao on 2019/1/13.
 */
public class EventLogger implements CacheEventListener<Object, Object> {

    private static final Logger log = LoggerFactory.getLogger(EventLogger.class);

    @Override
    public void onEvent(CacheEvent<?, ?> event) {
        log.info("Event: " + event.getType() + " Key: " + event.getKey() + " old value: " + event.getOldValue()
                + " new value: " + event.getNewValue());
    }
}
