package org.jlhh.mes.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * Created by wangyong on 2017/10/16.
 * 多数据源配置类定义
 * 创建一个Spring配置类，定义两个DataSource用来读取application.properties中的不同配置。
 * 如下例子中，主数据源配置为spring.datasource.primary开头的配置，
 * 第二数据源配置为spring.datasource.secondary开头的配置。
 */
@Configuration
public class DataSourceConfig {
    @Bean(name = "primaryDataSource")
    @Qualifier("primaryDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.primary")
    public DataSource primaryDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "secondaryDataSource")
    @Qualifier("secondaryDataSource")
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource.secondary")
    public DataSource secondaryDataSource() {
        return DataSourceBuilder.create().build();
    }

    /**
     * 多数据源配置类定义
     * 对JdbcTemplate的支持比较简单，只需要为其注入对应的datasource即可，
     * 如下例子，在创建JdbcTemplate的时候分别注入
     * 名为primaryDataSource和secondaryDataSource的数据源来区分
     * 不同的JdbcTemplate。
     */
    @Bean(name = "primaryJdbcTemplate")
    @Primary
    public JdbcTemplate primaryJdbcTemplate(
            @Qualifier("primaryDataSource") javax.sql.DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    @Bean(name = "secondaryJdbcTemplate")
    public JdbcTemplate secondaryJdbcTemplate(
            @Qualifier("secondaryDataSource") javax.sql.DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
}