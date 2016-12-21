# CommentSystem

## Introduction
* 这是frontend分支上二级cms的java后端实现。前端采用angularjs+bootstrap实现，后端使用maven构建，springboot搭建整个spring环境，持久层采用灵活的mybatis，数据库使用mysql。

## Database design
* 三张表<br/>
![](https://raw.githubusercontent.com/timelessmemory/WikiLibrary/master/cms/tables.png)
<br/>
### saying说说表<br/>
![](https://raw.githubusercontent.com/timelessmemory/WikiLibrary/master/cms/saying.png)
* 本系统模拟评论说说，所以设置了一张说说表。其中特别增加了一个likes字段，用户可以对说说"点赞"标记为喜欢。

### firstLevelComment一级评论表<br/>
![](https://raw.githubusercontent.com/timelessmemory/WikiLibrary/master/cms/flc.png)
<br/>

### secondLevelComment二级评论表<br/>
![](https://raw.githubusercontent.com/timelessmemory/WikiLibrary/master/cms/slc.png)

## Show result
![](https://raw.githubusercontent.com/timelessmemory/WikiLibrary/master/cms/1.png)
![](https://raw.githubusercontent.com/timelessmemory/WikiLibrary/master/cms/2.png)
![](https://raw.githubusercontent.com/timelessmemory/WikiLibrary/master/cms/3.png)
![](https://raw.githubusercontent.com/timelessmemory/WikiLibrary/master/cms/4.png)
