# JDBC 连接池

主库使用 Spring Boot 的 `spring.datasource.hikari` 配置。动态 BI 数据源使用独立的 HikariCP 连接池，通过 JVM 系统属性调整：

| 系统属性 | 默认值 | 含义 |
| --- | --- | --- |
| `bi.jdbc.pool.maximumPoolSize` | 20 | 每个动态数据源的连接上限 |
| `bi.jdbc.pool.minimumIdle` | 1 | 每个动态数据源保留的空闲连接数 |
| `bi.jdbc.pool.idleTimeout` | 60000 | 超过空闲保有量的连接回收时间，毫秒 |

例如 `-Dbi.jdbc.pool.minimumIdle=1 -Dbi.jdbc.pool.maximumPoolSize=20`。参数在进程启动时读取，修改后需要重新发布或重启。`minimumIdle` 应处于 0 到 `maximumPoolSize` 之间，`maximumPoolSize` 至少为 1；有限的 `idleTimeout` 至少为 10000 毫秒。

HikariCP 定期回收连接，因此实际回收可能比配置值延后约 30 秒。连接借用超时仍为 30 秒，连接最大生命周期仍为 30 分钟。动态数据源按首次访问创建连接池；总连接预算需要计入所有被访问的数据源及主库。JDBC URL、账号和 TLS 配置继续由各数据源原配置提供。
