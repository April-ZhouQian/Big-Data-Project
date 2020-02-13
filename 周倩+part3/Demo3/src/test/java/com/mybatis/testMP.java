package com.mybatis;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class testMP {
    private static String author="April";
    private static String outputDir="D:\\";
    private static String driver="com.mysql.cj.jdbc.Driver";
    private static String url="jdbc:mysql://127.0.0.1:3306/test?serverTimezone=UTC";
    private static String username="root";
    private static String password="afdxhd0801";
    private static String tablePrefix="t_";
    private static String[] tables={"t_user"};
    private static String parentPackage="com.mybatis";
    private static String dao="dao";
    private static String service="service";
    private static String entity="entity";
    private static String controller="controller";
    private static String mapperxml="mapper";

    @Test
    public void testGenerator(){
        //全局配置
        GlobalConfig config=new GlobalConfig();
        config.setAuthor(author)
                .setOutputDir(outputDir)
                .setFileOverride(true)
                .setIdType(IdType.AUTO)
                .setServiceName("%sService")
                .setBaseResultMap(true)
                .setBaseColumnList(true);

        //数据源配置
        DataSourceConfig dataSourceConfig=new DataSourceConfig();
        dataSourceConfig.setDbType(DbType.MYSQL)
                .setDriverName(driver)
                .setUrl(url)
                .setUsername(username)
                .setPassword(password);

        //策略配置
        StrategyConfig strategyConfig=new StrategyConfig();
        strategyConfig.setCapitalMode(true)
                .setNaming(NamingStrategy.underline_to_camel)
                .setTablePrefix(tablePrefix)
                .setInclude(tables);

        //包配置
        PackageConfig packageConfig=new PackageConfig();
        packageConfig.setParent(parentPackage)
                .setMapper(dao)
                .setController(controller)
                .setEntity(entity)
                .setXml(mapperxml)
                .setService(service);

        //整合配置
        AutoGenerator ag=new AutoGenerator();
        ag.setGlobalConfig(config)
                .setDataSource(dataSourceConfig)
                .setStrategy(strategyConfig)
                .setPackageInfo(packageConfig);

        //执行
        ag.execute();

    }
}
