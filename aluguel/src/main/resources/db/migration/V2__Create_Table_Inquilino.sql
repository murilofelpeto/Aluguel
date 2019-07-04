DROP TABLE IF EXISTS `inquilino`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `inquilino` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cpf` bigint(11) NOT NULL,
  `estado_civil` varchar(255) DEFAULT NULL,
  `nacionalidade` varchar(80) NOT NULL,
  `name` varchar(180) NOT NULL,
  `profissao` varchar(100) NOT NULL,
  `renda` decimal(19,2) NOT NULL,
  `rg` bigint(14) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_og4xy4jvf8p0j58dv67ku1n27` (`cpf`)
)