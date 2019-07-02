DROP TABLE IF EXISTS `fiador`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `fiador` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `documento` int(11) DEFAULT NULL,
  `name` varchar(255) NOT NULL,
  `renda` decimal(19,2) NOT NULL,
  `rg` int(11) DEFAULT NULL,
  `tipo_documento` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_k699u6hr1d3f8s2bfbhi70uhr` (`documento`)
)