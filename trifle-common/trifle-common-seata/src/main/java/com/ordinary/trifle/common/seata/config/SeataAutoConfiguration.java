package com.ordinary.trifle.common.seata.config;

import com.ordinary.trifle.common.core.factory.YamlPropertySourceFactory;
import io.seata.spring.annotation.datasource.EnableAutoDataSourceProxy;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * Seata 配置类
 *
 * @author lengleng
 * @date 2022/3/29
 */
@PropertySource(value = "classpath:seata-config.yml", factory = YamlPropertySourceFactory.class)
@EnableAutoDataSourceProxy
@Configuration(proxyBeanMethods = false)
public class SeataAutoConfiguration {

}
