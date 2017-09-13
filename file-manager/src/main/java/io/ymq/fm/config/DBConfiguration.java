package io.ymq.fm.config;

/**
 * 描述: 
 * author: yanpenglei
 * Date: 2017/9/8 15:17
 */


import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.sql.SQLException;

/**
 * 描述: 核心配置，配置数据源 事物 sqlsession
 * author: yanpenglei
 * Date: 2017/9/8 18:21
 */
@Configuration
@EnableTransactionManagement
public class DBConfiguration extends AbstractDruidDBConfig {

    @Value("${spring.datasource.url}")
    private String url;

    @Value("${spring.datasource.username}")
    private String username;

    @Value("${spring.datasource.password}")
    private String password;

    // 注册dataSource
    @Bean(name = "datasource", initMethod = "init", destroyMethod = "close")
    public DruidDataSource dataSource() {
        return super.createDataSource(url, username, password);
    }

    @Bean(name = "sqlSessionFactorFileManager")
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        return super.sqlSessionFactory(dataSource());
    }

    @Bean
    public PlatformTransactionManager transactionManager() throws SQLException {
        return new DataSourceTransactionManager(dataSource());
    }
}
