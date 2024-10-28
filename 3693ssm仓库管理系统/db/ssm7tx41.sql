-- MySQL dump 10.13  Distrib 5.7.31, for Linux (x86_64)
--
-- Host: localhost    Database: ssm7tx41
-- ------------------------------------------------------
-- Server version	5.7.31

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `config`
--

DROP TABLE IF EXISTS `config`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `config` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(100) NOT NULL COMMENT '配置参数名称',
  `value` varchar(100) DEFAULT NULL COMMENT '配置参数值',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='配置文件';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `config`
--

LOCK TABLES `config` WRITE;
/*!40000 ALTER TABLE `config` DISABLE KEYS */;
INSERT INTO `config` VALUES (1,'picture1','http://localhost:8080/ssm7tx41/upload/picture1.jpg'),(2,'picture2','http://localhost:8080/ssm7tx41/upload/picture2.jpg'),(3,'picture3','http://localhost:8080/ssm7tx41/upload/picture3.jpg'),(6,'homepage',NULL);
/*!40000 ALTER TABLE `config` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `gonggaoxinxi`
--

DROP TABLE IF EXISTS `gonggaoxinxi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `gonggaoxinxi` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gonggaobiaoti` varchar(200) NOT NULL COMMENT '公告标题',
  `tupian` varchar(200) DEFAULT NULL COMMENT '图片',
  `neirong` longtext COMMENT '内容',
  `faburiqi` date DEFAULT NULL COMMENT '发布日期',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1617332763593 DEFAULT CHARSET=utf8 COMMENT='公告信息';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gonggaoxinxi`
--

LOCK TABLES `gonggaoxinxi` WRITE;
/*!40000 ALTER TABLE `gonggaoxinxi` DISABLE KEYS */;
INSERT INTO `gonggaoxinxi` VALUES (11,'2021-04-02 03:00:13','公告标题1','http://localhost:8080/ssm7tx41/upload/gonggaoxinxi_tupian1.jpg','内容1','2021-04-02'),(12,'2021-04-02 03:00:13','公告标题2','http://localhost:8080/ssm7tx41/upload/gonggaoxinxi_tupian2.jpg','内容2','2021-04-02'),(13,'2021-04-02 03:00:13','公告标题3','http://localhost:8080/ssm7tx41/upload/gonggaoxinxi_tupian3.jpg','内容3','2021-04-02'),(14,'2021-04-02 03:00:13','公告标题4','http://localhost:8080/ssm7tx41/upload/gonggaoxinxi_tupian4.jpg','内容4','2021-04-02'),(15,'2021-04-02 03:00:13','公告标题5','http://localhost:8080/ssm7tx41/upload/gonggaoxinxi_tupian5.jpg','内容5','2021-04-02'),(16,'2021-04-02 03:00:13','公告标题6','http://localhost:8080/ssm7tx41/upload/gonggaoxinxi_tupian6.jpg','内容6','2021-04-02'),(1617332763592,'2021-04-02 03:06:03','关于商品库存管理规范','http://localhost:8080/ssm7tx41/upload/1617332746965.jpg','<p>商品库存管理规范</p><p>GJTIKYHJTYUIKJYOIKJUYI</p><p><img src=\"http://localhost:8080/ssm7tx41/upload/1617332761943.jpg\"></p>','2021-04-02');
/*!40000 ALTER TABLE `gonggaoxinxi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `gongyingshang`
--

DROP TABLE IF EXISTS `gongyingshang`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `gongyingshang` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gongyingshangbianhao` varchar(200) DEFAULT NULL COMMENT '供应商编号',
  `gongyingshangmingcheng` varchar(200) DEFAULT NULL COMMENT '供应商名称',
  `lianxiren` varchar(200) DEFAULT NULL COMMENT '联系人',
  `lianxidianhua` varchar(200) DEFAULT NULL COMMENT '联系电话',
  `gongyingshangdizhi` varchar(200) DEFAULT NULL COMMENT '供应商地址',
  `beizhu` varchar(200) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`),
  UNIQUE KEY `gongyingshangbianhao` (`gongyingshangbianhao`)
) ENGINE=InnoDB AUTO_INCREMENT=1617332816049 DEFAULT CHARSET=utf8 COMMENT='供应商';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gongyingshang`
--

LOCK TABLES `gongyingshang` WRITE;
/*!40000 ALTER TABLE `gongyingshang` DISABLE KEYS */;
INSERT INTO `gongyingshang` VALUES (31,'2021-04-02 03:00:13','供应商编号1','供应商名称1','联系人1','13823888881','供应商地址1','备注1'),(32,'2021-04-02 03:00:13','供应商编号2','供应商名称2','联系人2','13823888882','供应商地址2','备注2'),(33,'2021-04-02 03:00:13','供应商编号3','供应商名称3','联系人3','13823888883','供应商地址3','备注3'),(34,'2021-04-02 03:00:13','供应商编号4','供应商名称4','联系人4','13823888884','供应商地址4','备注4'),(35,'2021-04-02 03:00:13','供应商编号5','供应商名称5','联系人5','13823888885','供应商地址5','备注5'),(36,'2021-04-02 03:00:13','供应商编号6','供应商名称6','联系人6','13823888886','供应商地址6','备注6'),(1617332816048,'2021-04-02 03:06:55','1617332799503','楼上食品','陈月','12345678978','广州市','');
/*!40000 ALTER TABLE `gongyingshang` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shangpincaigou`
--

DROP TABLE IF EXISTS `shangpincaigou`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `shangpincaigou` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gongyingshangbianhao` varchar(200) DEFAULT NULL COMMENT '供应商编号',
  `gongyingshangmingcheng` varchar(200) DEFAULT NULL COMMENT '供应商名称',
  `caigoubianhao` varchar(200) DEFAULT NULL COMMENT '采购编号',
  `shangpinbianhao` varchar(200) DEFAULT NULL COMMENT '商品编号',
  `shangpinmingcheng` varchar(200) DEFAULT NULL COMMENT '商品名称',
  `pinpai` varchar(200) DEFAULT NULL COMMENT '品牌',
  `guige` varchar(200) DEFAULT NULL COMMENT '规格',
  `shuliang` int(11) DEFAULT NULL COMMENT '数量',
  `caigoujiage` int(11) DEFAULT NULL COMMENT '采购价格',
  `caigoujine` int(11) DEFAULT NULL COMMENT '采购金额',
  `caigouriqi` date DEFAULT NULL COMMENT '采购日期',
  `yuangonggonghao` varchar(200) DEFAULT NULL COMMENT '员工工号',
  `yuangongxingming` varchar(200) DEFAULT NULL COMMENT '员工姓名',
  `sfsh` varchar(200) DEFAULT '否' COMMENT '是否审核',
  `shhf` longtext COMMENT '审核回复',
  PRIMARY KEY (`id`),
  UNIQUE KEY `caigoubianhao` (`caigoubianhao`)
) ENGINE=InnoDB AUTO_INCREMENT=1617332978848 DEFAULT CHARSET=utf8 COMMENT='商品采购';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shangpincaigou`
--

LOCK TABLES `shangpincaigou` WRITE;
/*!40000 ALTER TABLE `shangpincaigou` DISABLE KEYS */;
INSERT INTO `shangpincaigou` VALUES (61,'2021-04-02 03:00:13','供应商编号1','供应商名称1','采购编号1','商品编号1','商品名称1','品牌1','规格1',1,1,1,'2021-04-02','员工工号1','员工姓名1','是',''),(62,'2021-04-02 03:00:13','供应商编号2','供应商名称2','采购编号2','商品编号2','商品名称2','品牌2','规格2',2,2,2,'2021-04-02','员工工号2','员工姓名2','是',''),(63,'2021-04-02 03:00:13','供应商编号3','供应商名称3','采购编号3','商品编号3','商品名称3','品牌3','规格3',3,3,3,'2021-04-02','员工工号3','员工姓名3','是',''),(64,'2021-04-02 03:00:13','供应商编号4','供应商名称4','采购编号4','商品编号4','商品名称4','品牌4','规格4',4,4,4,'2021-04-02','员工工号4','员工姓名4','是',''),(65,'2021-04-02 03:00:13','供应商编号5','供应商名称5','采购编号5','商品编号5','商品名称5','品牌5','规格5',5,5,5,'2021-04-02','员工工号5','员工姓名5','是',''),(66,'2021-04-02 03:00:13','供应商编号6','供应商名称6','采购编号6','商品编号6','商品名称6','品牌6','规格6',6,6,6,'2021-04-02','员工工号6','员工姓名6','是',''),(1617332957477,'2021-04-02 03:09:17','1617332799503','楼上食品','1617332945208','1617332871932','楼上芒果干','楼上','454g',45,25,1250,'2021-04-02','1','陈明','是','ok'),(1617332978847,'2021-04-02 03:09:38','1617332799503','楼上食品','1617332966999','商品编号5','商品名称5','品牌5','规格5',50,50,2500,'2021-04-02','1','陈明','是','ok');
/*!40000 ALTER TABLE `shangpincaigou` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shangpinchuku`
--

DROP TABLE IF EXISTS `shangpinchuku`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `shangpinchuku` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `shangpinmingcheng` varchar(200) DEFAULT NULL COMMENT '商品名称',
  `shangpinbianhao` varchar(200) DEFAULT NULL COMMENT '商品编号',
  `shangpinfenlei` varchar(200) DEFAULT NULL COMMENT '商品分类',
  `pinpai` varchar(200) DEFAULT NULL COMMENT '品牌',
  `guige` varchar(200) DEFAULT NULL COMMENT '规格',
  `shuliang` int(11) DEFAULT NULL COMMENT '数量',
  `shoujia` int(11) DEFAULT NULL COMMENT '售价',
  `zongjine` int(11) DEFAULT NULL COMMENT '总金额',
  `chukuleixing` varchar(200) DEFAULT NULL COMMENT '出库类型',
  `dengjiriqi` date DEFAULT NULL COMMENT '登记日期',
  `yuangonggonghao` varchar(200) DEFAULT NULL COMMENT '员工工号',
  `yuangongxingming` varchar(200) DEFAULT NULL COMMENT '员工姓名',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1617333163354 DEFAULT CHARSET=utf8 COMMENT='商品出库';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shangpinchuku`
--

LOCK TABLES `shangpinchuku` WRITE;
/*!40000 ALTER TABLE `shangpinchuku` DISABLE KEYS */;
INSERT INTO `shangpinchuku` VALUES (81,'2021-04-02 03:00:13','商品名称1','商品编号1','商品分类1','品牌1','规格1',1,1,1,'销售','2021-04-02','员工工号1','员工姓名1'),(82,'2021-04-02 03:00:13','商品名称2','商品编号2','商品分类2','品牌2','规格2',2,2,2,'销售','2021-04-02','员工工号2','员工姓名2'),(83,'2021-04-02 03:00:13','商品名称3','商品编号3','商品分类3','品牌3','规格3',3,3,3,'销售','2021-04-02','员工工号3','员工姓名3'),(84,'2021-04-02 03:00:13','商品名称4','商品编号4','商品分类4','品牌4','规格4',4,4,4,'销售','2021-04-02','员工工号4','员工姓名4'),(85,'2021-04-02 03:00:13','商品名称5','商品编号5','商品分类5','品牌5','规格5',5,5,5,'销售','2021-04-02','员工工号5','员工姓名5'),(86,'2021-04-02 03:00:13','商品名称6','商品编号6','商品分类6','品牌6','规格6',6,6,6,'销售','2021-04-02','员工工号6','员工姓名6'),(1617333118556,'2021-04-02 03:11:58','楼上芒果干','1617332871932','休闲食品','楼上','454g',20,39,780,'销售','2021-04-02','1','陈明'),(1617333163353,'2021-04-02 03:12:42','楼上芒果干','1617332871932','休闲食品','楼上','454g',5,39,195,'退货','2021-04-07','1','陈明');
/*!40000 ALTER TABLE `shangpinchuku` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shangpinfenlei`
--

DROP TABLE IF EXISTS `shangpinfenlei`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `shangpinfenlei` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `shangpinfenlei` varchar(200) NOT NULL COMMENT '商品分类',
  PRIMARY KEY (`id`),
  UNIQUE KEY `shangpinfenlei` (`shangpinfenlei`)
) ENGINE=InnoDB AUTO_INCREMENT=1617332838651 DEFAULT CHARSET=utf8 COMMENT='商品分类';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shangpinfenlei`
--

LOCK TABLES `shangpinfenlei` WRITE;
/*!40000 ALTER TABLE `shangpinfenlei` DISABLE KEYS */;
INSERT INTO `shangpinfenlei` VALUES (41,'2021-04-02 03:00:13','商品分类1'),(42,'2021-04-02 03:00:13','商品分类2'),(43,'2021-04-02 03:00:13','商品分类3'),(44,'2021-04-02 03:00:13','商品分类4'),(45,'2021-04-02 03:00:13','商品分类5'),(46,'2021-04-02 03:00:13','商品分类6'),(1617332825175,'2021-04-02 03:07:04','休闲食品'),(1617332832875,'2021-04-02 03:07:12','体育用品'),(1617332838650,'2021-04-02 03:07:18','日用品');
/*!40000 ALTER TABLE `shangpinfenlei` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shangpinruku`
--

DROP TABLE IF EXISTS `shangpinruku`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `shangpinruku` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `rukudanhao` varchar(200) DEFAULT NULL COMMENT '入库单号',
  `shangpinbianhao` varchar(200) DEFAULT NULL COMMENT '商品编号',
  `shangpinmingcheng` varchar(200) DEFAULT NULL COMMENT '商品名称',
  `shangpinfenlei` varchar(200) DEFAULT NULL COMMENT '商品分类',
  `pinpai` varchar(200) DEFAULT NULL COMMENT '品牌',
  `guige` varchar(200) DEFAULT NULL COMMENT '规格',
  `shuliang` int(11) DEFAULT NULL COMMENT '数量',
  `jinjia` int(11) DEFAULT NULL COMMENT '进价',
  `zongjine` int(11) DEFAULT NULL COMMENT '总金额',
  `beizhu` varchar(200) DEFAULT NULL COMMENT '备注',
  `dengjiriqi` date DEFAULT NULL COMMENT '登记日期',
  `yuangonggonghao` varchar(200) DEFAULT NULL COMMENT '员工工号',
  `yuangongxingming` varchar(200) DEFAULT NULL COMMENT '员工姓名',
  PRIMARY KEY (`id`),
  UNIQUE KEY `rukudanhao` (`rukudanhao`)
) ENGINE=InnoDB AUTO_INCREMENT=1617333078881 DEFAULT CHARSET=utf8 COMMENT='商品入库';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shangpinruku`
--

LOCK TABLES `shangpinruku` WRITE;
/*!40000 ALTER TABLE `shangpinruku` DISABLE KEYS */;
INSERT INTO `shangpinruku` VALUES (71,'2021-04-02 03:00:13','入库单号1','商品编号1','商品名称1','商品分类1','品牌1','规格1',1,1,1,'备注1','2021-04-02','员工工号1','员工姓名1'),(72,'2021-04-02 03:00:13','入库单号2','商品编号2','商品名称2','商品分类2','品牌2','规格2',2,2,2,'备注2','2021-04-02','员工工号2','员工姓名2'),(73,'2021-04-02 03:00:13','入库单号3','商品编号3','商品名称3','商品分类3','品牌3','规格3',3,3,3,'备注3','2021-04-02','员工工号3','员工姓名3'),(74,'2021-04-02 03:00:13','入库单号4','商品编号4','商品名称4','商品分类4','品牌4','规格4',4,4,4,'备注4','2021-04-02','员工工号4','员工姓名4'),(75,'2021-04-02 03:00:13','入库单号5','商品编号5','商品名称5','商品分类5','品牌5','规格5',5,5,5,'备注5','2021-04-02','员工工号5','员工姓名5'),(76,'2021-04-02 03:00:13','入库单号6','商品编号6','商品名称6','商品分类6','品牌6','规格6',6,6,6,'备注6','2021-04-02','员工工号6','员工姓名6'),(1617333063902,'2021-04-02 03:11:03','1617333050861','商品编号5','商品名称5','商品分类5','品牌5','规格5',50,5,250,'采购入库','2021-04-02','1','陈明'),(1617333078880,'2021-04-02 03:11:18','1617333069077','1617332871932','楼上芒果干','休闲食品','楼上','454g',50,25,1250,'采购入库','2021-04-02','1','陈明');
/*!40000 ALTER TABLE `shangpinruku` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shangpintuihuo`
--

DROP TABLE IF EXISTS `shangpintuihuo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `shangpintuihuo` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gongyingshangbianhao` varchar(200) DEFAULT NULL COMMENT '供应商编号',
  `gongyingshangmingcheng` varchar(200) DEFAULT NULL COMMENT '供应商名称',
  `caigoubianhao` varchar(200) DEFAULT NULL COMMENT '采购编号',
  `shangpinbianhao` varchar(200) DEFAULT NULL COMMENT '商品编号',
  `shangpinmingcheng` varchar(200) DEFAULT NULL COMMENT '商品名称',
  `pinpai` varchar(200) DEFAULT NULL COMMENT '品牌',
  `guige` varchar(200) DEFAULT NULL COMMENT '规格',
  `shuliang` int(11) DEFAULT NULL COMMENT '数量',
  `caigoujiage` int(11) DEFAULT NULL COMMENT '采购价格',
  `tuihuojine` int(11) DEFAULT NULL COMMENT '退货金额',
  `tuihuoyuanyin` varchar(200) DEFAULT NULL COMMENT '退货原因',
  `tuihuoriqi` date DEFAULT NULL COMMENT '退货日期',
  `yuangonggonghao` varchar(200) DEFAULT NULL COMMENT '员工工号',
  `yuangongxingming` varchar(200) DEFAULT NULL COMMENT '员工姓名',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1617333148816 DEFAULT CHARSET=utf8 COMMENT='商品退货';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shangpintuihuo`
--

LOCK TABLES `shangpintuihuo` WRITE;
/*!40000 ALTER TABLE `shangpintuihuo` DISABLE KEYS */;
INSERT INTO `shangpintuihuo` VALUES (91,'2021-04-02 03:00:13','供应商编号1','供应商名称1','采购编号1','商品编号1','商品名称1','品牌1','规格1',1,1,1,'退货原因1','2021-04-02','员工工号1','员工姓名1'),(92,'2021-04-02 03:00:13','供应商编号2','供应商名称2','采购编号2','商品编号2','商品名称2','品牌2','规格2',2,2,2,'退货原因2','2021-04-02','员工工号2','员工姓名2'),(93,'2021-04-02 03:00:13','供应商编号3','供应商名称3','采购编号3','商品编号3','商品名称3','品牌3','规格3',3,3,3,'退货原因3','2021-04-02','员工工号3','员工姓名3'),(94,'2021-04-02 03:00:13','供应商编号4','供应商名称4','采购编号4','商品编号4','商品名称4','品牌4','规格4',4,4,4,'退货原因4','2021-04-02','员工工号4','员工姓名4'),(95,'2021-04-02 03:00:13','供应商编号5','供应商名称5','采购编号5','商品编号5','商品名称5','品牌5','规格5',5,5,5,'退货原因5','2021-04-02','员工工号5','员工姓名5'),(96,'2021-04-02 03:00:13','供应商编号6','供应商名称6','采购编号6','商品编号6','商品名称6','品牌6','规格6',6,6,6,'退货原因6','2021-04-02','员工工号6','员工姓名6'),(1617333148815,'2021-04-02 03:12:27','1617332799503','楼上食品','1617332945208','1617332871932','楼上芒果干','楼上','454g',5,25,125,'外包装破损','2021-04-07','1','陈明');
/*!40000 ALTER TABLE `shangpintuihuo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shangpinxinxi`
--

DROP TABLE IF EXISTS `shangpinxinxi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `shangpinxinxi` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `shangpinbianhao` varchar(200) DEFAULT NULL COMMENT '商品编号',
  `shangpinmingcheng` varchar(200) DEFAULT NULL COMMENT '商品名称',
  `shangpinfenlei` varchar(200) DEFAULT NULL COMMENT '商品分类',
  `tupian` varchar(200) DEFAULT NULL COMMENT '图片',
  `shuliang` int(11) DEFAULT NULL COMMENT '数量',
  `pinpai` varchar(200) DEFAULT NULL COMMENT '品牌',
  `guige` varchar(200) DEFAULT NULL COMMENT '规格',
  `jinjia` int(11) DEFAULT NULL COMMENT '进价',
  `shoujia` int(11) DEFAULT NULL COMMENT '售价',
  PRIMARY KEY (`id`),
  UNIQUE KEY `shangpinbianhao` (`shangpinbianhao`)
) ENGINE=InnoDB AUTO_INCREMENT=1617332912943 DEFAULT CHARSET=utf8 COMMENT='商品信息';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shangpinxinxi`
--

LOCK TABLES `shangpinxinxi` WRITE;
/*!40000 ALTER TABLE `shangpinxinxi` DISABLE KEYS */;
INSERT INTO `shangpinxinxi` VALUES (51,'2021-04-02 03:00:13','商品编号1','商品名称1','商品分类1','http://localhost:8080/ssm7tx41/upload/1617332571455.jpg',51,'品牌1','规格1',1,1),(52,'2021-04-02 03:00:13','商品编号2','商品名称2','商品分类2','http://localhost:8080/ssm7tx41/upload/1617332580054.jpg',62,'品牌2','规格2',2,2),(53,'2021-04-02 03:00:13','商品编号3','商品名称3','商品分类3','http://localhost:8080/ssm7tx41/upload/1617332587391.jpg',53,'品牌3','规格3',3,3),(54,'2021-04-02 03:00:13','商品编号4','商品名称4','商品分类4','http://localhost:8080/ssm7tx41/upload/1617332600208.jpg',100,'品牌4','规格4',4,4),(55,'2021-04-02 03:00:13','商品编号5','商品名称5','商品分类5','http://localhost:8080/ssm7tx41/upload/1617332613255.jpg',80,'品牌5','规格5',5,5),(56,'2021-04-02 03:00:13','商品编号6','商品名称6','商品分类6','http://localhost:8080/ssm7tx41/upload/1617332626721.jpg',60,'品牌6','规格6',6,6),(1617332912942,'2021-04-02 03:08:32','1617332871932','楼上芒果干','休闲食品','http://localhost:8080/ssm7tx41/upload/1617332894985.jpg',80,'楼上','454g',25,39);
/*!40000 ALTER TABLE `shangpinxinxi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `token`
--

DROP TABLE IF EXISTS `token`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `token` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `userid` bigint(20) NOT NULL COMMENT '用户id',
  `username` varchar(100) NOT NULL COMMENT '用户名',
  `tablename` varchar(100) DEFAULT NULL COMMENT '表名',
  `role` varchar(100) DEFAULT NULL COMMENT '角色',
  `token` varchar(200) NOT NULL COMMENT '密码',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '新增时间',
  `expiratedtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '过期时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='token表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `token`
--

LOCK TABLES `token` WRITE;
/*!40000 ALTER TABLE `token` DISABLE KEYS */;
INSERT INTO `token` VALUES (1,21,'员工1','yuangong','员工','4l82zczmx99sqqoyombc22jtwar36ytz','2021-04-02 03:01:52','2021-04-02 04:01:53'),(2,1,'abo','users','管理员','wss3io0f3ekjaf4jxug0x5nx9iq2sj66','2021-04-02 03:02:24','2021-04-02 04:13:00'),(3,1617332795370,'1','yuangong','员工','nrcytu47lxmsuqdo1bbe5k5j5owxt1a0','2021-04-02 03:08:39','2021-04-02 04:18:39');
/*!40000 ALTER TABLE `token` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `username` varchar(100) NOT NULL COMMENT '用户名',
  `password` varchar(100) NOT NULL COMMENT '密码',
  `role` varchar(100) DEFAULT '管理员' COMMENT '角色',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '新增时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='用户表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'abo','abo','管理员','2021-04-02 03:00:13');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `yuangong`
--

DROP TABLE IF EXISTS `yuangong`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `yuangong` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `yuangonggonghao` varchar(200) NOT NULL COMMENT '员工工号',
  `mima` varchar(200) NOT NULL COMMENT '密码',
  `yuangongxingming` varchar(200) DEFAULT NULL COMMENT '员工姓名',
  `xingbie` varchar(200) DEFAULT NULL COMMENT '性别',
  `touxiang` varchar(200) DEFAULT NULL COMMENT '头像',
  `shouji` varchar(200) DEFAULT NULL COMMENT '手机',
  `shenfenzheng` varchar(200) DEFAULT NULL COMMENT '身份证',
  PRIMARY KEY (`id`),
  UNIQUE KEY `yuangonggonghao` (`yuangonggonghao`)
) ENGINE=InnoDB AUTO_INCREMENT=1617332795371 DEFAULT CHARSET=utf8 COMMENT='员工';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `yuangong`
--

LOCK TABLES `yuangong` WRITE;
/*!40000 ALTER TABLE `yuangong` DISABLE KEYS */;
INSERT INTO `yuangong` VALUES (21,'2021-04-02 03:00:13','员工1','123456','员工姓名1','男','http://localhost:8080/ssm7tx41/upload/yuangong_touxiang1.jpg','13823888881','440300199101010001'),(22,'2021-04-02 03:00:13','员工2','123456','员工姓名2','男','http://localhost:8080/ssm7tx41/upload/yuangong_touxiang2.jpg','13823888882','440300199202020002'),(23,'2021-04-02 03:00:13','员工3','123456','员工姓名3','男','http://localhost:8080/ssm7tx41/upload/yuangong_touxiang3.jpg','13823888883','440300199303030003'),(24,'2021-04-02 03:00:13','员工4','123456','员工姓名4','男','http://localhost:8080/ssm7tx41/upload/yuangong_touxiang4.jpg','13823888884','440300199404040004'),(25,'2021-04-02 03:00:13','员工5','123456','员工姓名5','男','http://localhost:8080/ssm7tx41/upload/yuangong_touxiang5.jpg','13823888885','440300199505050005'),(26,'2021-04-02 03:00:13','员工6','123456','员工姓名6','男','http://localhost:8080/ssm7tx41/upload/yuangong_touxiang6.jpg','13823888886','440300199606060006'),(1617332795370,'2021-04-02 03:06:35','1','11','陈明','男','http://localhost:8080/ssm7tx41/upload/1617332782588.jpg','12312312312','123456789789456123');
/*!40000 ALTER TABLE `yuangong` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-04-06 16:23:53
