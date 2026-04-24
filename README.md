# 预制菜订购平台（Spring Boot 后端）

这是一个基于 Spring Boot 2.x 的预制菜在线订购平台后端项目，提供完整的 RESTful API 接口。

## 项目简介

本项目是一个 B2C 预制菜电商平台，支持用户端下单、商家端管理、订单追踪、购物车、收藏、聊天等功能。

## 技术栈

- **框架**：Spring Boot 2.2.2.RELEASE
- **ORM**：MyBatis-Plus 2.3 + MybatisPlus Spring Boot Starter 1.0.5
- **数据库**：MySQL 5.7+
- **权限认证**：Apache Shiro 1.3.2
- **工具库**：Hutool 4.0.12、FastJSON 1.2.8、Commons Lang3
- **支付**：支付宝 SDK
- **AI 能力**：百度人工智能 SDK 4.4.1
- **文件处理**：Apache POI（Excel 导出/导入）
- **Java 版本**：JDK 1.8

## 项目结构

```
src/main/java/com/
├── annotation/       # 自定义注解（如登录用户、忽略认证等）
├── config/           # 配置文件（拦截器、MyBatis-Plus、支付宝配置等）
├── controller/       # 控制器层（REST API）
├── dao/              # MyBatis 映射接口
├── entity/           # 实体类
│   ├── model/        # 业务模型类
│   ├── view/         # 视图对象
│   └── vo/           # 值对象
├── service/          # 业务逻辑层
└── utils/            # 工具类
```

## 核心功能模块

| 模块 | 功能说明 |
|------|---------|
| 用户 (Yonghu) | 用户注册、登录、个人信息管理 |
| 商家 (Shangjia) | 商家入驻、商品管理、订单处理 |
| 预制菜信息 (Xizhuangxinxi) | 菜品展示、详情、上下架 |
| 分类管理 (Xizhuangfenlei) | 菜品分类 |
| 定制需求 (Xizhuangdingzhi) | 个性化定制服务 |
| 订单 (Orders) | 下单、支付、退款、状态追踪 |
| 购物车 (Cart) | 商品暂存、批量结算 |
| 收藏 (Storeup) | 收藏菜品、取消收藏 |
| 地址管理 (Address) | 收货地址增删改查、设置默认 |
| 新闻资讯 (News) | 系统公告、新闻列表 |
| 聊天 (Chat) | 用户与商家在线沟通 |
| 评价 (Discussxizhuangxinxi) | 菜品评价、评分 |
| 回复 (Huifuxinxi) | 商家回复评价 |
| 友情链接 (Friendlink) | 外部链接管理 |
| 在线沟通 (Zaixiangoutong) | 客服在线咨询 |
| 配置管理 (Config) | 系统配置参数 |

## 数据库设计

项目提供了完整的 `db/springboot01u2zqkf.sql` 脚本，包含 20+ 张表的建表语句和基础数据。

**主要数据表**：
- `address` - 收货地址
- `cart` - 购物车
- `chat` - 聊天记录
- `orders` - 订单
- `xizhuangxinxi` - 预制菜信息
- `xizhuangfenlei` - 分类
- `shangjia` - 商家
- `yonghu` - 用户
- `storeup` - 收藏
- `news` / `newstype` - 新闻及分类
- `discussxizhuangxinxi` - 评价
- `huifuxinxi` - 评价回复
- `token` - 用户登录 token
- `config` - 系统配置

## 快速开始

### 环境要求

- JDK 1.8+
- Maven 3.x
- MySQL 5.7+
- Node.js（如需前端，通常另建前端项目）

### 1. 导入数据库

```bash
mysql -u root -p < db/springboot01u2zqkf.sql
```

### 2. 修改数据库配置

编辑 `src/main/resources/application.yml`（或 `application.properties`），更新数据库连接信息：

```yaml
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/springboot01u2zqkf?useUnicode=true&characterEncoding=utf8&useSSL=false&serverTimezone=Asia/Shanghai
    username: your_username
    password: your_password
    driver-class-name: com.mysql.jdbc.Driver
```

### 3. 构建项目

```bash
mvn clean package
```

### 4. 运行项目

```bash
mvn spring-boot:run
```
或运行生成的 JAR 包：
```bash
java -jar target/springboot01u2zqkf-0.0.1-SNAPSHOT.jar
```

### 5. 访问接口

启动成功后，后端 API 默认监听：
- **地址**：`http://localhost:8080`
- **接口前缀**：`/api/`（具体查看 Controller 中的 `@RequestMapping` 注解）

## API 示例

```bash
# 用户登录
POST /api/users/login

# 获取菜品列表
GET /api/xizhuangxinxi/page

# 提交订单
POST /api/orders/save

# 查询购物车
GET /api/cart/list
```

更多接口请查看 `com.controller` 包下的各个 Controller 文件。

## 配置说明

- **MyBatis-Plus**：已配置全局分页、逻辑删除等（`MybatisPlusConfig.java`）
- **拦截器**：登录验证、权限控制（`InterceptorConfig.java`）
- **Shiro**：基于注解的权限管理（`APPLoginUser.java`、`LoginUser.java`）
- **支付宝配置**：`AlipayConfig.java` 中配置商户信息

## 注意事项

1. 本项目仅包含**后端代码**，需配合前端（Vue/React/小程序等）使用
2. 默认端口为 `8080`，可在配置文件中修改 `server.port`
3. 生产环境需关闭调试模式，配置 HTTPS、数据库连接池等
4. 百度 AI SDK 和支付宝 SDK 需申请对应密钥并配置参数

## 许可证

MIT License

## 作者

项目由 contributor 开发和维护。
