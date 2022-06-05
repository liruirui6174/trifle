package com.ordinary.trifle.gateway.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ordinary.trifle.gateway.filter.PasswordDecoderFilter;
import com.ordinary.trifle.gateway.filter.TrifleRequestGlobalFilter;
import com.ordinary.trifle.gateway.filter.SwaggerBasicGatewayFilter;
import com.ordinary.trifle.gateway.filter.ValidateCodeGatewayFilter;
import com.ordinary.trifle.gateway.handler.GlobalExceptionHandler;
import com.ordinary.trifle.gateway.handler.ImageCodeHandler;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * 网关配置
 *
 * @author L.cm
 */
@Configuration(proxyBeanMethods = false)
@EnableConfigurationProperties(GatewayConfigProperties.class)
public class GatewayConfiguration {

	@Bean
	public PasswordDecoderFilter passwordDecoderFilter(GatewayConfigProperties configProperties) {
		return new PasswordDecoderFilter(configProperties);
	}

	@Bean
	public TrifleRequestGlobalFilter trifleRequestGlobalFilter() {
		return new TrifleRequestGlobalFilter();
	}

	@Bean
	@ConditionalOnProperty(name = "swagger.basic.enabled")
	public SwaggerBasicGatewayFilter swaggerBasicGatewayFilter(
			SpringDocConfiguration.SwaggerDocProperties swaggerProperties) {
		return new SwaggerBasicGatewayFilter(swaggerProperties);
	}

	@Bean
	public ValidateCodeGatewayFilter validateCodeGatewayFilter(GatewayConfigProperties configProperties,
			ObjectMapper objectMapper, RedisTemplate redisTemplate) {
		return new ValidateCodeGatewayFilter(configProperties, objectMapper, redisTemplate);
	}

	@Bean
	public GlobalExceptionHandler globalExceptionHandler(ObjectMapper objectMapper) {
		return new GlobalExceptionHandler(objectMapper);
	}

	@Bean
	public ImageCodeHandler imageCodeHandler(RedisTemplate redisTemplate) {
		return new ImageCodeHandler(redisTemplate);
	}

}
