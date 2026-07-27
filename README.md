<p align="center" style="margin:0;"><a href="http://fusb.top:8088/#/home"><img src="http://fusb.top/data/voyage/images/logo2.png" alt="DataEase" width="400" /></a>
</p>
<h3 align="center" style="margin-top:10px;">可以定制化开发的开源BI平台</h3>

<div style="display:flex; gap:4px; ">
<a href="LICENSE"><img src="https://img.shields.io/badge/License-GPLv3-blue.svg" alt="License"></a>
<a href="https://github.com/shuangbofu/voyage-bi/stargazers"><img src="https://img.shields.io/github/stars/shuangbofu/voyage-bi" alt="Stars"></a>
<a href="https://github.com/shuangbofu/voyage-bi/issues"><img src="https://img.shields.io/github/issues/shuangbofu/voyage-bi" alt="Issues"></a>
<a href="http://fusb.top:8088/#/home"><img src="https://img.shields.io/badge/Demo-Online-green" alt="Demo"></a>
</div>

## Voyage BI是什么？

**Voyage BI** 是一个开源的可定制化开发的BI工具，通过配置数据源连接，开发数据集，图表开发中拖拉拽方式快速制作看板/报表并分享到外部。提供主题定制、组件定制、自由筛选联动等功能。

## 项目背景与开发初衷

在数据可视化平台/看板报表的开发过程中，我逐渐意识到传统BI方案对于开发者实际开发中存在多个层面的限制。

1. 定制化需求与通用方案之间的矛盾

企业对看板的需求往往具有高度的个性化和业务相关性，但现有BI产品(腾讯BI、有数、海致BDP、DataEase、davinci）大多依赖固定图表类型与有限的参数体系。尽管提供了可配置能力，仍难以支持不同业务场景下对数据逻辑、交互行为和视觉样式的多样化诉求。这种“千人千面”的真实需求，最终只能被迫适配“千人一面”的通用方案，灵活性严重不足。

2. 技术架构的迭代困境

开源层面，传统BI组件在架构层面也存在明显短板。视图层与业务逻辑的深度耦合、样式系统缺乏扩展性，使得定制开发常常需要对原有组件进行大范围改动，甚至接近重构，导致二次开发的成本随复杂度呈指数级增长。这种架构模式不利于敏捷迭代，也难以在快速响应业务变化的前提下保持代码质量和可维护性。

3. 数据准备层的体验断层

现有的数据集模块大多设计为可视化建模界面，试图兼顾技术用户与业务用户的使用场景。但实际效果并不理想：对熟悉SQL的开发者来说，可视化操作效率不如直接编写查询；而对非技术用户而言，底层的数据抽象和逻辑设置仍然存在门槛，无法真正实现“所见即所得”。这种模糊定位的“中间态”设计，往往陷入两头不讨好的局面。

4. 我的开发思路与动机

基于以上问题，我在项目中尝试从两个方向进行改进：

- 前端层面：在通用图表组件的基础上，构建出一套「可定制的通用组件体系」，既保持组件的结构统一与可复用性，也支持对样式、交互逻辑的灵活扩展，以适配不同场景的看板需求。
- 后端与数据逻辑层面：设计支持「自由变量、外部筛选器与图表间联动」的机制，允许开发者在通用数据接口的基础上动态控制图表行为和数据逻辑。这种方式可以在保持接口通用性的前提下，实现复杂的业务定制与看板联动策略。

虽然目前在自定义组件与交互设计上仍有优化空间，还有许多可以改进的地方。但这正是我计划开源该项目的初衷之一：希望通过实践沉淀一套灵活、可扩展、适合真实业务需求的数据可视化解决方案，**欢迎有类似思考的开发者共同交流**。

### 对比常用BI

<table style="font-size: 10px; border-collapse: collapse; width: 100%; font-family: Arial; margin: 20px 0; text-align:center;">
  <tr style="background-color: #f5f5f5;">
    <th style="padding: 4px; border: 1px solid #ddd; min-width: 120px;">功能维度</th>
    <th style="padding: 4px; border: 1px solid #ddd;">Voyage BI</th>
    <th style="padding: 4px; border: 1px solid #ddd; min-width: 180px;">DataEase社区版</th>
  </tr>

  <tr>
    <td style="padding: 4px; border: 1px solid #ddd;">全局支持浅色&深色模式</td>
    <td style="padding: 4px; border: 1px solid #ddd; color: #4CAF50;">支持（图表支持浅色&深色）</td>
    <td style="padding: 4px; border: 1px solid #ddd; color: #FFA000;">支持（仅图表浅色&深色）</td>
  </tr>

  <tr>
    <td style="padding: 4px; border: 1px solid #ddd;">组件定制化开发</td>
    <td style="padding: 4px; border: 1px solid #ddd; color: #4CAF50;">支持图表组件的配置化定制开发</td>
    <td style="padding: 4px; border: 1px solid #ddd; color: #FFA000;">组件类型固定，配置项有限，无法深度定制</td>
  </tr>

  <tr>
    <td style="padding: 4px; border: 1px solid #ddd;">主题支持</td>
    <td style="padding: 4px; border: 1px solid #ddd; color: #4CAF50;">支持自由主题开发</td>
    <td style="padding: 4px; border: 1px solid #ddd; color: #4CAF50;">提供模板市场</td>
  </tr>

  <tr>
    <td style="padding: 4px; border: 1px solid #ddd;">数据集开发</td>
    <td style="padding: 4px; border: 1px solid #ddd; color: #4CAF50;">支持动态代码块和变量参数自由开发</td>
    <td style="padding: 4px; border: 1px solid #ddd; color: #FF4444;">复杂嵌套SQL会报错</td>
  </tr>

  <tr>
    <td style="padding: 4px; border: 1px solid #ddd;">联动机制</td>
    <td style="padding: 4px; border: 1px solid #ddd; color: #4CAF50;">支持事件与数据集变量联动</td>
    <td style="padding: 4px; border: 1px solid #ddd; color: #FF4444;">仅支持数据联动，无法自由控制</td>
  </tr>

  <tr>
    <td style="padding: 4px; border: 1px solid #ddd;">筛选能力</td>
    <td style="padding: 4px; border: 1px solid #ddd; color: #4CAF50;">支持灵活筛选</td>
    <td style="padding: 4px; border: 1px solid #ddd; color: #FF4444;">只有全局筛选，且只能关联数据集字段，不够自由</td>
  </tr>

  <tr>
    <td style="padding: 4px; border: 1px solid #ddd;">数据源环境支持</td>
    <td style="padding: 4px; border: 1px solid #ddd; color: #4CAF50;">多环境切换</td>
    <td style="padding: 4px; border: 1px solid #ddd; color: #FFA000;">仅支持单环境</td>
  </tr>
</table>

---

## 功能架构

![Voyage BI 功能架构](http://fusb.top/data/voyage/images/arch.jpg)

---

## 👓 界面预览

### gif
![Voyage BI 界面演示](http://fusb.top/data/voyage/images/show.gif)

### mobile page

![Voyage BI 界面演示](http://fusb.top/data/voyage/images/mobile.png)

### design page

![Voyage BI 界面演示](http://fusb.top/data/voyage/images/design.png)
---

<!-- ## ✨ 功能特性 -->

## 🛠️ 技术栈

### 前端

- React + TypeScript + Umi.js
- Tailwind CSS + Ant Design
- ECharts（图表库）

### 后端

- Spring Boot + Java
- MyBatis-Plus（ORM）
- JSQLParser（SQL 解析）
- Sa-Token（权限认证）

### 数据库 & 缓存

- MySQL
- Redis

## 🚀 快速开始

### 在线体验

直接访问 [在线演示](http://fusb.top:8088/#/home) 立即使用。
> - 账号：guest
> - 密码：123456

### 本地运行

#### 克隆代码

```bash
# 克隆仓库
git clone https://github.com/shuangbofu/voyage-bi.git
```

#### 前端运行

```bash
cd voyage-bi/web-ui

# 安装依赖
yarn install

# 启动开发服务器
yarn dev

# 构建生产版本
yarn build
```

#### 后端运行

```bash
cd voyage-bi

sh build.sh

java -jar ./web-server/target/voyage-bi.jar

```

## 📂 项目结构

```
├── LICENSE                     # 项目许可证文件
├── README.md                   # 项目说明文档
├── build.sh                    # 自动化构建脚本
├── data-core                   # 数据核心模块
│   ├── base                    # 基础数据抽象层
│   │   └── src/main/java/top/fusb/bi/data/base
│   │       ├── client          # 数据客户端抽象接口
│   │       ├── domin           # 数据领域模型定义
│   │       ├── exception       # 自定义异常体系
│   │       ├── parser          # SQL动态解析模块
│   │       └── utils           # 通用工具包
│   ├── jdbc                    # JDBC连接模块
│   │   └── src/main/java/top/fusb/bi/data/jdbc
│   │       ├── client          # JDBC客户端实现
│   │       ├── domain          # 数据源配置实体
│   │       └── utils           # 连接池工具
├── sql                         # SQL脚本目录
│   ├── example.sql            # 示例查询脚本
│   └── structure.sql          # 数据库表结构脚本
├── voyage-base                 # base模块
│   └── src/main/java/top/fusb/voyagebi/base
│       ├── utils             # 工具类
│       └── VO                # 通用视图
├── web-client                  # 客户端SDK
│   └── src/main/java/top/fusb/voyagebi/client
│       ├── domain             # API传输对象
│       └── utils              # 签名验签工具
├── web-resource-node                # 资源节点模块
│   └── src/main/java/top/fusb/voyagebi/web/resource/node
│       ├── aspect             # 资源节点切面
│       ├── controller         # 控制器层
│       ├── domain             # 业务模型
│       │   ├── annotation     # 注解定义
│       ├── persist            # 持久层
│       │   └── mapper         # MyBatis映射
│       ├── service            # 服务层
│       │   ├── aspect         # AOP切面
│       ├── utils              # 工具类
│       └── websocket          # WebSocket服务
├── web-server                  # 后端服务主模块
│   └── src/main/java/top/fusb/voyagebi
│       ├── config             # 系统配置中心
│       ├── controller         # 控制器层
│       ├── domain             # 业务模型
│       │   ├── enums          # 枚举定义
│       │   ├── request        # 请求对象
│       │   └── VO             # 视图对象
│       ├── open               # 开放API
│       ├── persist            # 持久层
│       │   ├── entity         # 数据库实体
│       │   └── mapper         # MyBatis映射
│       ├── service            # 服务层
│       │   ├── aspect         # AOP切面
│       │   ├── access         # 分享校验
│       │   ├── cache          # 缓存处理
│       │   ├── facade         # DsClientFacade
│       │   ├── impl           # 服务实现
│       │   └── manager        # 服务管理
│       ├── utils              # 工具类
│       └── websocket          # WebSocket服务
└── web-ui                      # 前端模块（完整结构）
    ├── src
    │   ├── components         # 组件库
    │   │   ├── ChartInteractionEventBus  # 图表事件总线
    │   │   ├── CodeCompare     # 代码对比组件
    │   │   ├── Dashboard       # 仪表板组件群
    │   │   │   ├── Chart        # 图表子系统
    │   │   │   │   ├── ChartCfgForm  # 配置表单
    │   │   │   │   ├── ChartGrid    # 图表网格
    │   │   │   │   ├── ChartTypeSelector  # 图表类型选择
    │   │   │   │   └── ChartView    # 图表渲染核心
    │   │   │   ├── ChartGroup   # 图表组管理
    │   │   │   ├── FilterConfigurator  # 筛选器配置
    │   │   │   └── Filters      # 筛选器组件
    │   │   ├── Kanban          # 看板组件
    │   │   ├── MobileDesigner  # 移动端设计器
    │   │   ├── SearchButton    # 增强搜索按钮
    │   │   ├── base            # 基础组件库
    │   │   │   ├── BaseModal    # 基础弹窗
    │   │   │   ├── CommonGridLayout  # 通用栅格
    │   │   │   ├── DataTable     # 数据表
    │   │   │   ├── DropdownButton  # 下拉按钮
    │   │   │   ├── Editor       # 代码编辑器
    │   │   │   ├── ErrorBoundary  # 错误边界
    │   │   │   ├── FileTree     # 文件树
    │   │   │   ├── FormModal    # 表单弹窗
    │   │   │   ├── Guide        # 新手引导
    │   │   │   ├── ItemList     # 条目列表
    │   │   │   ├── MyIcon       # 图标组件
    │   │   │   ├── SchemaForm   # 动态表单
    │   │   │   └── Transfer     # 穿梭框组件
    │   │   └── setting         # 系统设置组件
    │   │       ├── DataModeSwitch  # 数据模式切换
    │   │       └── ThemeSelector  # 主题选择器
    │   ├── pages              # 页面入口
    │   │   ├── Chart          # 图表设计页
    │   │   │   └── Designer    # 图表设计器核心
    │   │   ├── Dashboard       # 仪表板模块
    │   │   │   ├── DashboardDesigner  # 设计器
    │   │   │   ├── Preview      # 预览模式
    │   │   │   └── ShareListDrawer  # 分享管理
    │   │   ├── DataSheet       # 数据集模块
    │   │   │   └── SheetView    # 数据集视图
    │   │   ├── DataSource      # 数据源管理
    │   │   ├── Develop         # 开发模块
    │   │   ├── Home            # 主页模块
    │   │   ├── Preview         # 通用预览
    │   │   ├── System          # 系统管理
    │   │   │   ├── App         # 应用管理
    │   │   │   ├── ComponentManage  # 组件管理
    │   │   │   ├── SystemConfig  # 系统配置
    │   │   │   └── ThemeManage  # 主题管理
    │   │   ├── Test            # 测试页面
    │   │   └── User            # 用户管理
    └── 配置文件               # 工程配置
        ├── tailwind.config.js  # Tailwind配置
        ├── tsconfig.json       # TypeScript配置
        └── yarn.lock           # 依赖锁文件
```

## ❓ 遗留问题

1.组件开发预览优化
2.组件显示规则配置
3.其他bug及优化项

## 🌟 后续计划

1. 数据集开发时显示数据库表列表及元数据
2. 增加其他联动事件
3. 增加其他数据源类型
4. 修改sql生成方式
5. 移动端筛选使用移动端组件
6. 各维度权限锁
   7……

## 📜 许可证

[![License: GPL v3](https://img.shields.io/badge/License-GPLv3-blue.svg)](LICENSE)  
本项目采用 [GNU GPLv3 许可证](https://www.gnu.org/licenses/gpl-3.0) 开源，详见 [LICENSE](LICENSE)。  
Copyright © 2026 [shuangbofu](https://github.com/shuangbofu)
