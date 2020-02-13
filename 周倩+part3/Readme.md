# 使用SpringBoot集成MyBatis-Plus，实现数据表操作（CRUD）

1. 在pom.xml文件注入mybatis-plus依赖，以及mybatis-plus-generator用于构造器
2. 在test文件中编写代码进行配置自动生成controller、dao、entity、mapper、service。在本地中找到所在目录复制到项目中(官网有另一种方式)
3. 编写config文件用于注入分页插件
4. 在test文件中进行服务测试，包括：
* 基于service实现插入
* 基于service实现删除(根据entity)
* 基于service实现删除（根据id）
* 基于service进行更新(根据entity)
* 基于service进行查询（有条件）
* 基于service查询整张表
* 实现数据分页查询(切记注入分页插件)
