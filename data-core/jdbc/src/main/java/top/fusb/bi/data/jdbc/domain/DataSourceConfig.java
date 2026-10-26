package top.fusb.bi.data.jdbc.domain;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import lombok.extern.slf4j.Slf4j;
import top.fusb.bi.data.base.exception.DbException;

import javax.sql.DataSource;

@Slf4j
public class DataSourceConfig {

    public static DataSource createDataSource(RdsParam rdsParam) {
        try {
            HikariConfig config = new HikariConfig();
            config.setJdbcUrl(rdsParam.getUrl());
            config.setUsername(rdsParam.getUsername());
            config.setPassword(rdsParam.getPassword());

            // 动态数据源按需扩容，避免每个数据源长期占用大量空闲连接。
            // JVM 系统属性允许部署时调整，无需重新修改源码。
            config.setMaximumPoolSize(Integer.getInteger("bi.jdbc.pool.maximumPoolSize", 20));
            config.setMinimumIdle(Integer.getInteger("bi.jdbc.pool.minimumIdle", 1));
            config.setIdleTimeout(Long.getLong("bi.jdbc.pool.idleTimeout", 60000L));
            config.setConnectionTimeout(30000); // 30秒
            config.setMaxLifetime(1800000);  // 30分钟

            // 设置连接测试查询
            config.setConnectionTestQuery("SELECT 1");

            // 其他参数
            config.addDataSourceProperty("cachePrepStmts", "true");
            config.addDataSourceProperty("prepStmtCacheSize", "250");
            config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
            config.addDataSourceProperty("useConfigs", "maxPerformance");
            rdsParam.getParams().forEach(config::addDataSourceProperty);

            return new HikariDataSource(config);
        } catch (Exception e) {
            throw new DbException("连接失败, " + e.getMessage());
        }
    }
}
