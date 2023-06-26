package com.scw.module.auth.interceptor;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.scw.module.multitent.MultitenantDataSource;
import com.scw.module.multitent.MultitenantService;
import com.scw.module.multitent.TenantProperties;

@Component
public class MultitenantConfiguration {

	@Autowired
	private DataSourceProperties properties;

	@Autowired
	MultitenantService multitenantService;

	private TenantProperties[] TenantDatas = null;

	@Bean
	public DataSource dataSource() {
		Map<Object, Object> resolvedDataSources = new HashMap<>();
		TenantDatas = multitenantService.titenantDatas();
		for (TenantProperties tenant : TenantDatas) {			
			try {
				DataSourceBuilder<?> dataSourceBuilder = DataSourceBuilder.create();
				String tenantId = tenant.getTenantId();
				dataSourceBuilder.driverClassName(properties.getDriverClassName())
						.driverClassName(tenant.getDriverName()).url(tenant.getUrl()).username(tenant.getUsername())
						.password(tenant.getPassword());
				resolvedDataSources.put(tenantId, dataSourceBuilder.build());
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		}
		MultitenantDataSource dataSource = new MultitenantDataSource();
		dataSource.setDefaultTargetDataSource(defaultDataSource());
		dataSource.setTargetDataSources(resolvedDataSources);

		dataSource.afterPropertiesSet();

		return dataSource;
	}

	private DataSource defaultDataSource() {
		DataSourceBuilder<?> dataSourceBuilder = DataSourceBuilder.create()
				.driverClassName(properties.getDriverClassName()).url(properties.getUrl())
				.username(properties.getUsername()).password(properties.getPassword());

		if (properties.getType() != null) {
			dataSourceBuilder.type(properties.getType());
		}

		return dataSourceBuilder.build();
	}
}
