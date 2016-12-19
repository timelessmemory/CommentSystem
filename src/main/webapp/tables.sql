create database commentSystem;

use commentSystem;

##说说表或者文章表
create table saying (
        saying_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
        sayingContent VARCHAR(500) NOT NULL,
        author VARCHAR(50) NOT NULL,
        sayingAvatar VARCHAR(50) NOT NULL,
        likes VARCHAR(500) NOT NULL,
        createTime datetime NOT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=utf8;

##一级评论表
create table firstLevelComment (
        flc_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
        sayingId INT NOT NULL,
        commenter VARCHAR(50) NOT NULL,
        commenterAvatar VARCHAR(50) NOT NULL,
        commentContent VARCHAR(500) NOT NULL,
        commentTime datetime NOT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=utf8;

##二级评论表
create table secondLevelComment (
        slc_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
        sayingId INT NOT NULL,
        flcId INT NOT NULL,
        replier VARCHAR(50) NOT NULL,
        toCommenter VARCHAR(50) NOT NULL,
        replyContent VARCHAR(50) NOT NULL,
        replyTime datetime NOT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=utf8;