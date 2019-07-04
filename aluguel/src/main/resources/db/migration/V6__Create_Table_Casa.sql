DROP TABLE IF EXISTS `casa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `casa` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `data_vencimento` date NOT NULL,
  `tipo_casa` varchar(80) NOT NULL,
  `valor_aluguel` decimal(19,2) NOT NULL,
  `valor_iptu` decimal(19,2) NOT NULL,
  `id_endereco` bigint(20) DEFAULT NULL,
  `id_inquilino` bigint(20) DEFAULT NULL,
  `id_proprietario` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKbqe3si1t0gds0elgr0mx8d7eg` (`id_endereco`),
  KEY `FKr1e5lo2lg7wi2u6namvuhl8bu` (`id_inquilino`),
  KEY `FK5u6ibe643ueqtws648cutw20r` (`id_proprietario`),
  CONSTRAINT `FK5u6ibe643ueqtws648cutw20r` FOREIGN KEY (`id_proprietario`) REFERENCES `proprietario` (`id`),
  CONSTRAINT `FKbqe3si1t0gds0elgr0mx8d7eg` FOREIGN KEY (`id_endereco`) REFERENCES `endereco` (`id`),
  CONSTRAINT `FKr1e5lo2lg7wi2u6namvuhl8bu` FOREIGN KEY (`id_inquilino`) REFERENCES `inquilino` (`id`)
)