DROP TABLE IF EXISTS `inquilino_fiador`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `inquilino_fiador` (
  `id_inquilino` bigint(20) NOT NULL,
  `id_fiador` bigint(20) NOT NULL,
  KEY `FKr35tgihdtstlox6nwivsk8eb3` (`id_fiador`),
  KEY `FK8n9famvd5hydurm0af6a62s14` (`id_inquilino`),
  CONSTRAINT `FK8n9famvd5hydurm0af6a62s14` FOREIGN KEY (`id_inquilino`) REFERENCES `inquilino` (`id`),
  CONSTRAINT `FKr35tgihdtstlox6nwivsk8eb3` FOREIGN KEY (`id_fiador`) REFERENCES `fiador` (`id`)
)