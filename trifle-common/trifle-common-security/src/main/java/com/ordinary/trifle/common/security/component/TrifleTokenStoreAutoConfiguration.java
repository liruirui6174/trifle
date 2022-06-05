package com.ordinary.trifle.common.security.component;

import com.ordinary.trifle.common.core.constant.CacheConstants;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.security.oauth2.provider.token.TokenStore;

/**
 * @author lengleng
 * @date 2021/10/16
 */
public class TrifleTokenStoreAutoConfiguration {

	@Bean
	public TokenStore tokenStore(RedisConnectionFactory redisConnectionFactory) {
		TrifleRedisTokenStore tokenStore = new TrifleRedisTokenStore(redisConnectionFactory);
		tokenStore.setPrefix(CacheConstants.PROJECT_OAUTH_ACCESS);
		return tokenStore;
	}

}
