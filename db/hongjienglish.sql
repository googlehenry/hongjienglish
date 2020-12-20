-- --------------------------------------------------------
-- 主机:                           127.0.0.1
-- 服务器版本:                        10.5.8-MariaDB - mariadb.org binary distribution
-- 服务器操作系统:                      Win64
-- HeidiSQL 版本:                  11.0.0.5919
-- --------------------------------------------------------

-- 导出 hongjienglish 的数据库结构
CREATE DATABASE IF NOT EXISTS `hongjienglish` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `hongjienglish`;

-- 导出  表 hongjienglish.learn_item 结构
CREATE TABLE IF NOT EXISTS `learn_item` (
  `id` varchar(50) DEFAULT NULL,
  `category` varchar(50) DEFAULT NULL,
  `name` varchar(200) DEFAULT NULL,
  `locale` varchar(50) DEFAULT NULL,
  `description` varchar(200) DEFAULT NULL,
  `image` mediumtext DEFAULT NULL,
  `audio` mediumtext DEFAULT NULL,
  `video` mediumtext DEFAULT NULL,
  `grade` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
