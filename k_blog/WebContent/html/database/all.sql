# �û���
CREATE TABLE `k_user` (
  `id` varchar(23) NOT NULL,
  `username` varchar(23) NOT NULL,
  `password` varchar(23) NOT NULL,
  `nickname` varchar(23) NOT NULL,
  `email` varchar(23) NOT NULL,
  `createtime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP,
  `pseudo` tinyint(1) NOT NULL DEFAULT '0' COMMENT '�Ƿ�Ϊ�ٵģ�Ĭ��Ϊfalse�����ڼ�ɾ����',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8


# �������û���
CREATE TABLE `third_party_user` ()

# �û���ע��
CREATE TABLE `k_user2fans` (
  `id` int(11) NOT NULL,
  `targetid` int(11) NOT NULL COMMENT 'Ŀ��ID��������ע����',
  `fansid` int(11) NOT NULL COMMENT '��˿ID������עĿ�����',
  `createtime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP,
  `pseudo` tinyint(1) NOT NULL DEFAULT '0' COMMENT '�Ƿ�Ϊ�ٵģ�Ĭ��Ϊfalse�����ڼ�ɾ����',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8


# ���±�
CREATE TABLE `k_article` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(20) NOT NULL COMMENT '����',
  `content` longtext NOT NULL COMMENT '������',
  `summary` text NOT NULL COMMENT '���',
  `userid` int(11) NOT NULL COMMENT '������Id',
  `createtime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP COMMENT '����ʱ��',
  `pseudo` tinyint(1) NOT NULL DEFAULT '0' COMMENT '�Ƿ�Ϊ�ٵģ�Ĭ��Ϊfalse�����ڼ�ɾ����',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8

#���۱�
CREATE TABLE `k_comment` (
  `id` int(11) NOT NULL,
  `content` char(200) NOT NULL COMMENT '��������',
  `userid` int(11) NOT NULL COMMENT '�û�id',
  `articleid` int(11) NOT NULL COMMENT '����id',
  `parentid` int(11) NOT NULL COMMENT '�����۵�ID',
  `parentuserid` int(11) NOT NULL,
  `pseudo` tinyint(1) NOT NULL DEFAULT '0' COMMENT '�Ƿ�Ϊ�ٵģ�Ĭ��Ϊfalse�����ڼ�ɾ��',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8


