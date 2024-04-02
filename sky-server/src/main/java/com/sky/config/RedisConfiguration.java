package com.sky.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Component;

/**
 * @Configuration用于标记一个类作为配置类，这类通常包含一组@Bean注解的方法，用于声明和初始化Spring容器中的bean
 * 定义在该类内部的方法会通过@Bean注解产生相应的bean对象，并注册到Spring应用上下文中。
 *
 * 配置类替代XML配置文件，使配置更加灵活。配置类之间可以通过相互引用（即一个@Bean方法调用另一个@Bean方法）来构建复杂的bean依赖关系
 */
@Configuration
@Component
@Slf4j
public class RedisConfiguration {

    @Autowired
    private RedisConnectionFactory redisConnectionFactory;

    @Bean
    public RedisTemplate redisTemplate(RedisConnectionFactory redisConnectionFactory){
        log.info("开始创建redis模板对象...");
        RedisTemplate redisTemplate = new RedisTemplate();
        //设置redis的连接工厂对象。 Spring Data Redis会自己创建RedisConnectionFactory放入到Spring容器
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        //设置redis key的序列化器。字符串式的序列化器
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        return redisTemplate;
    }
}
