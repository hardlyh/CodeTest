package com.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.baomidou.mybatisplus.extension.plugins.OptimisticLockerInterceptor;

@Configuration
public class VersionConfig {

	@Bean
	public OptimisticLockerInterceptor VersionConfig() {
		return new OptimisticLockerInterceptor();
	}
}
