# 用户表
CREATE TABLE `k_user` (
  `id` varchar(23) NOT NULL,
  `username` varchar(23) NOT NULL,
  `password` varchar(23) NOT NULL,
  `nickname` varchar(23) NOT NULL,
  `email` varchar(23) NOT NULL,
  `createtime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP,
  `pseudo` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否为假的，默认为false，用于假删除。',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8


# 第三方用户表
CREATE TABLE `third_party_user` ()

# 用户关注表
CREATE TABLE `k_user2fans` (
  `id` int(11) NOT NULL,
  `targetid` int(11) NOT NULL COMMENT '目标ID，即被关注的人',
  `fansid` int(11) NOT NULL COMMENT '粉丝ID，即关注目标的人',
  `createtime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP,
  `pseudo` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否为假的，默认为false，用于假删除。',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8


# 文章表
CREATE TABLE `k_article` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(20) NOT NULL COMMENT '标题',
  `content` longtext NOT NULL COMMENT '主内容',
  `summary` text NOT NULL COMMENT '简介',
  `userid` int(11) NOT NULL COMMENT '发布人Id',
  `createtime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `pseudo` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否为假的，默认为false，用于假删除。',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8

#评论表
CREATE TABLE `k_comment` (
  `id` int(11) NOT NULL,
  `content` char(200) NOT NULL COMMENT '评论内容',
  `userid` int(11) NOT NULL COMMENT '用户id',
  `articleid` int(11) NOT NULL COMMENT '文章id',
  `parentid` int(11) NOT NULL COMMENT '父评论的ID',
  `parentuserid` int(11) NOT NULL,
  `pseudo` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否为假的，默认为false，用于假删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8


