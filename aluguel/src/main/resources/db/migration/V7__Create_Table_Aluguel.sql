DROP TABLE IF EXISTS `aluguel`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `aluguel` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `data_pagamento` date NOT NULL,
  `observacoes` varchar(255) DEFAULT NULL,
  `valor_pago` decimal(19,2) NOT NULL,
  `id_casa` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKg73kjjkvaw82r3klpvp0v8ks8` (`id_casa`),
  CONSTRAINT `FKg73kjjkvaw82r3klpvp0v8ks8` FOREIGN KEY (`id_casa`) REFERENCES `casa` (`id`)
)