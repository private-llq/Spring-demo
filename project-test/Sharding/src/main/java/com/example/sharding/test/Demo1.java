package com.example.sharding.test;

import com.zaxxer.hikari.HikariDataSource;
import org.apache.shardingsphere.api.config.sharding.ShardingRuleConfiguration;
import org.apache.shardingsphere.api.config.sharding.TableRuleConfiguration;
import org.apache.shardingsphere.api.config.sharding.strategy.InlineShardingStrategyConfiguration;
import org.apache.shardingsphere.shardingjdbc.api.ShardingDataSourceFactory;
import org.apache.shardingsphere.underlying.common.config.properties.ConfigurationPropertyKey;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class Demo1 {
    public static void main(String[] args) throws SQLException {
        /**
* 1、配置真实数据源
*/
        Map<String, DataSource> dataSourceMap = new HashMap<>();
        dataSourceMap.put("ds0", dataSource1());

        /**
* 2.配置表的规则
*/
        TableRuleConfiguration orderTableRuleConfig = new TableRuleConfiguration("t_order", "ds0.t_order_$->{0..1}");
        // 指定表的分片策略（分片字段+分片算法）
        orderTableRuleConfig.setTableShardingStrategyConfig(new InlineShardingStrategyConfiguration("order_id", "t_order_$->{order_id % 2}"));

        /**
* 3、分片规则
*/
        ShardingRuleConfiguration shardingRuleConfig = new ShardingRuleConfiguration();
        //将表的分片规则加入到分片规则列表
        shardingRuleConfig.getTableRuleConfigs().add(orderTableRuleConfig);

        /**
* 4、配置一些属性
*/
        Properties props = new Properties();
        //输出sql
        props.put(ConfigurationPropertyKey.SQL_SHOW.getKey(), true);

        /**
* 5、创建数据源
*/
        DataSource dataSource = ShardingDataSourceFactory.
            createDataSource(dataSourceMap, shardingRuleConfig, props);

        /**
* 6、获取连接，执行sql
*/
        Connection connection = dataSource.getConnection();
        connection.setAutoCommit(false);

        /**
* 测试向t_order表插入8条数据，8条数据会分散到2个表
*/
        PreparedStatement ps = connection.prepareStatement("insert into t_order (order_id,user_id,price) values (?,?,?)");
        for (long i = 1; i <= 8; i++) {
            int j = 1;
            ps.setLong(j++, i);
            ps.setLong(j++, i);
            ps.setLong(j, 100 * i);
            System.out.println(ps.executeUpdate());
        }

        connection.commit();
        ps.close();
        connection.close();
    }


    private static DataSource dataSource1() {
        HikariDataSource dataSource1 = new HikariDataSource();
        dataSource1.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource1.setJdbcUrl("jdbc:mysql://localhost:3306/sj_ds0?characterEncoding=UTF-8");
        dataSource1.setUsername("root");
        dataSource1.setPassword("root123");
        return dataSource1;
    }

}
