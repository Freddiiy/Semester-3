CREATE DATABASE
IF NOT EXISTS `test`;

DROP TABLE IF EXISTS `Text`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Text`
(
    `id` int NOT NULL AUTO_INCREMENT,
    `text` varchar
(100) NOT NULL,
    PRIMARY KEY
(`id`)
) ENGINE=InnoDB;