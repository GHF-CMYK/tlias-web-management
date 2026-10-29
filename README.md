# Tlias 智能学习辅助系统 - 后端

基于 Spring Boot + MyBatis 的 Tlias 智能学习辅助系统后端服务，提供部门、员工、班级、学员管理，以及报表统计与登录鉴权等功能。

## 技术栈

- Java 17
- Spring Boot 4.0.8
- MyBatis + PageHelper 分页插件
- MySQL
- JWT（jjwt）

## 快速开始

1. 创建 MySQL 数据库 `tlias`，导入表结构与初始数据。
2. 修改 `tlias-web-managemnet/src/main/resources/application.yml` 中的数据库连接信息。
3. 运行 `org.example.TliasWebManagemnetApplication`，服务默认运行在 `8080` 端口。

## 目录结构

```
tlias-web-managemnet/
├── src/main/java/org/example
│   ├── controller   # 接口层
│   ├── service      # 业务层
│   ├── mapper       # 持久层
│   ├── pojo         # 实体类
│   ├── interceptor  # 登录校验拦截器
│   ├── filter       # 过滤器
│   └── utils        # 工具类（JWT 等）
└── src/main/resources
    ├── application.yml
    └── org/example/mapper  # MyBatis XML 映射文件
```
