# CommentSystem

##Introduction
这是frontend分支上二级cms的java后端实现。前端采用angularjs+bootstrap实现，后端使用maven构建，springboot搭建整个spring环境，持久层采用灵活的mybatis，数据库使用mysql。

##Database design
三张表<br/>
![](https://raw.githubusercontent.com/timelessmemory/WikiLibrary/master/cms/tables.png)
###saying说说表<br/>
![](https://raw.githubusercontent.com/timelessmemory/WikiLibrary/master/cms/saying.png)
<br/>
本系统模拟评论说说，所以设置了一张说说表。其中特别增加了一个likes字段，用户可以对说说"点赞"标记为喜欢。

###表<br/>
![](https://raw.githubusercontent.com/timelessmemory/WikiLibrary/master/cms/flc.png)
<br/>
一级
