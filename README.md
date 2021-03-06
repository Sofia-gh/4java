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
- 03.31：前台主页面设置，完成**租柜管理**、**员工签到**、**会员进场**
- 04.01：**潜客登记**、**会员充值**、**训练记录**
- 04.02：**团课预约**、**私教预约**、**教练查询**
- 04.03：**运动报表**、**排课管理**、**学员管理**
- 04.04：**日程管理**、**统计分析**、**员工管理**
- 04.05：**会员管理**、**会员卡管理**、**教练管理**
- 04.06：**课程管理**、**财务管理**、**业绩管理**
- 04.07：**修改记录**、**维护记录**
- 04.08：项目测试 
- 04.09：交项目   
## 03.30
### 完成任务
数据库设计
### 出现问题
- 多重角色登录且不同角色有自己的表，不能使用shiro
- 需要将所有产品放在一个表中
## 03.31
### 完成任务
租柜管理、员工签到、会员进场
### 出现问题
- 由日期+毫秒组成的编号要改为bigint，要先转为字符串拼接，再转为long
- 金额要随购买的类型自己计算多少
- 状态在页面展示对应其具体内容，不能只是简单的数字
- 组柜记录表中添加了一行柜子编号
- 在mysql5.5中只能有一个timestamp设为默认值为current_timestamp，其他的可以不设置默认值，或者默认值为具体某个时间
## 04.01
### 完成任务
潜客登记、会员充值、训练记录
### 出现问题
- 充值项在之后实现直接以下拉列表的方式选择
- 登录在主管端写完再写
## 04.02
### 完成任务
团课管理、团课预约、教练管理
### 出现问题
- 会员预约团课成功之后的展示页面（即我的团课）应该去显示团课的具体信息（多表关联）
- 重新调整需求完成计划：团课管理--》团课预约；教练管理--》教练排课--》私教预约
- 考虑使用shiro写登录，将不同角色的账户密码放在一个表里，再安排角色和权限
- 关于七牛云上传问题，可以等部署到Linux系统上时再试一下
- 前端想要输入带有时分秒的时间并且转化为数据库timestamp，使用datetime类型的input
- 关于使用thymeleaf实现单选更具条件默认选中
  th:attr ="checked=${coach.status==1?true:false}"
## 04.03
### 完成任务
排课管理、教练查询、私教预订
### 出现问题
- 课程编号设为开始时间年月日时分秒
- 对循环出来的按钮添加点击事件，展开或收起内容（弄了好久，记住他）
	$(show).hide();
	$(b).click(function () {
   		 var $value = $(this);
   		 if ($value.text()=='查看更多') {
       			 $value.text('收起');
        			$value.prev().show();
   	 	}else{
        			$value.text('查看更多');
       		 	$value.prev().hide();
   		 }
	});
- 实现了三层表关联
- 明天完成：会员管理--》会员卡管理--》学员管理
# 04.04
### 完成任务
会员管理、会员卡管理、学员管理
### 出现问题
- 使用mybatis注解方式两表关联
- Thymeleaf中select标签的使用
  ```html
  <select  class="form-control" name="cardNumber">
      <option th:each="card:${cards}" th:value="${card.number}" th:text="${card.type}" th:selected="${member.cardNumber eq card.number}"></option>
  </select>
  ```
# 04.07
### 完成任务
员工管理、维护管理
### 出现问题
明天完成各种统计表分析需求
# 04.08
### 完成任务
日程管理、业绩管理、用户登录+角色管理
# 04.09
### 完成任务
运动报表、统计分析、财务管理、修改记录