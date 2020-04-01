# gym项目
## 项目需求
###前台端
- 租柜管理
- 前台签到
- 会员进场
- 潜客登记
- 会员充值
### 会员端
- 训练记录
- 团课预约
- 私教预约
- 教练查询
- 运动报表
### 教练端
- 排课管理
- 学员管理
- 日程管理
- 统计分析
### 主管端
- 前台管理
- 会员管理
- 会员卡管理
- 教练管理
- 课程管理
- 财务管理
- 业绩管理
- 修改记录
- 维护记录
## 开发计划：10天完成
- 03.30：完成项目环境搭建，分析项目需求，完成数据库初步设计
- 03.31：前台主页面设置，完成租柜管理、员工签到、会员进场
- 04.01：潜客登记、会员充值、训练记录
- 04.02：团课预约、私教预约、教练查询
- 04.03：运动报表、排课管理、学员管理
- 04.04：日程管理、统计分析、前台管理
- 04.05：会员管理、会员卡管理、教练管理
- 04.06：课程管理、财务管理、业绩管理
- 04.07：修改记录、维护记录
- 04.08：项目测试 
- 04.09：交项目   
## 03.30
### 完成任务
数据库设计
### 出现问题
多重角色登录且不同角色有自己的表，不能使用shiro
需要将所有产品放在一个表中
## 03.31
### 完成任务
租柜管理、员工签到、会员进场
### 出现问题
- 由日期+毫秒组成的编号要改为bigint，要先转为字符串拼接，再转为long
- 金额要随购买的类型自己计算多少
- 状态在页面展示对应其具体内容，不能只是简单的数字
- 组柜记录表中添加了一行柜子编号
- 在mysql5.5中只能有一个timestamp设为默认值为current_timestamp，其他的可以不设置默认值，或者默认值为具体某个时间
