/*M!999999\- enable the sandbox mode */ 
-- MariaDB dump 10.19-12.0.2-MariaDB, for Linux (x86_64)
--
-- Host: localhost    Database: CondominioAPIJava
-- ------------------------------------------------------
-- Server version	12.0.2-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*M!100616 SET @OLD_NOTE_VERBOSITY=@@NOTE_VERBOSITY, NOTE_VERBOSITY=0 */;

--
-- Current Database: `CondominioAPIJava`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `CondominioAPIJava` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci */;

USE `CondominioAPIJava`;

--
-- Table structure for table `andar`
--

DROP TABLE IF EXISTS `andar`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8mb4 */;
CREATE TABLE `andar` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `andar_quantidade_deresidencias` int(11) DEFAULT NULL,
  `nome` varchar(255) DEFAULT NULL,
  `bloco_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK4ddn50a1o5nrl71pkypxo1gr0` (`bloco_id`),
  CONSTRAINT `FK4ddn50a1o5nrl71pkypxo1gr0` FOREIGN KEY (`bloco_id`) REFERENCES `bloco` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `area`
--

DROP TABLE IF EXISTS `area`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8mb4 */;
CREATE TABLE `area` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `descricao` varchar(255) DEFAULT NULL,
  `nome` varchar(255) DEFAULT NULL,
  `status` bit(1) DEFAULT NULL,
  `condominio_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKrhtgpo133cxgkcvtio191lokn` (`condominio_id`),
  CONSTRAINT `FKrhtgpo133cxgkcvtio191lokn` FOREIGN KEY (`condominio_id`) REFERENCES `condominio` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `bloco`
--

DROP TABLE IF EXISTS `bloco`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8mb4 */;
CREATE TABLE `bloco` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) DEFAULT NULL,
  `quantidade_deresidencias` int(11) DEFAULT NULL,
  `condominio_id` bigint(20) DEFAULT NULL,
  `endereco_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UKkbun2hlidyj82wmxsw949gxni` (`endereco_id`),
  KEY `FKiaa4fng9gn6s3cpiec3kw7gj7` (`condominio_id`),
  CONSTRAINT `FKiaa4fng9gn6s3cpiec3kw7gj7` FOREIGN KEY (`condominio_id`) REFERENCES `condominio` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `condominio`
--

DROP TABLE IF EXISTS `condominio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8mb4 */;
CREATE TABLE `condominio` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cnpj` varchar(255) DEFAULT NULL,
  `nome` varchar(255) DEFAULT NULL,
  `telefone` varchar(255) DEFAULT NULL,
  `tipo` enum('Horizontal','Vertical') DEFAULT NULL,
  `endereco_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UKbxmh0ac34jtchc0tt946yrpy4` (`endereco_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `flyway_schema_history`
--

DROP TABLE IF EXISTS `flyway_schema_history`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8mb4 */;
CREATE TABLE `flyway_schema_history` (
  `installed_rank` int(11) NOT NULL,
  `version` varchar(50) DEFAULT NULL,
  `description` varchar(200) NOT NULL,
  `type` varchar(20) NOT NULL,
  `script` varchar(1000) NOT NULL,
  `checksum` int(11) DEFAULT NULL,
  `installed_by` varchar(100) NOT NULL,
  `installed_on` timestamp NOT NULL DEFAULT current_timestamp(),
  `execution_time` int(11) NOT NULL,
  `success` tinyint(1) NOT NULL,
  PRIMARY KEY (`installed_rank`),
  KEY `flyway_schema_history_s_idx` (`success`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `funcionario`
--

DROP TABLE IF EXISTS `funcionario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8mb4 */;
CREATE TABLE `funcionario` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cargo` varchar(255) DEFAULT NULL,
  `cpf` varchar(255) DEFAULT NULL,
  `data_admissao` datetime(6) DEFAULT NULL,
  `data_demissao` datetime(6) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `nome` varchar(255) DEFAULT NULL,
  `status` bit(1) DEFAULT NULL,
  `telefone` varchar(255) DEFAULT NULL,
  `usuario_sistema` bit(1) DEFAULT NULL,
  `condominio_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKga398uvsmcba66decg8yer58l` (`condominio_id`),
  CONSTRAINT `FKga398uvsmcba66decg8yer58l` FOREIGN KEY (`condominio_id`) REFERENCES `condominio` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `morador`
--

DROP TABLE IF EXISTS `morador`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8mb4 */;
CREATE TABLE `morador` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cpf` varchar(255) DEFAULT NULL,
  `data_nascimento` date DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `nome` varchar(255) DEFAULT NULL,
  `status` bit(1) DEFAULT NULL,
  `telefone` varchar(255) DEFAULT NULL,
  `condominio_id` bigint(20) DEFAULT NULL,
  `endereco_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UKg1yvg44feg3xwgvqvmp5gqpkj` (`endereco_id`),
  KEY `FKiid091g67lg33lvi2ypbkrelb` (`condominio_id`),
  CONSTRAINT `FKiid091g67lg33lvi2ypbkrelb` FOREIGN KEY (`condominio_id`) REFERENCES `condominio` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `permisions`
--

DROP TABLE IF EXISTS `permisions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8mb4 */;
CREATE TABLE `permisions` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `regras`
--

DROP TABLE IF EXISTS `regras`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8mb4 */;
CREATE TABLE `regras` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `descricao` varchar(255) DEFAULT NULL,
  `tipo_penalidade` enum('HORIZONTAL_BARULHO','HORIZONTAL_CONSTRUCAO','HORIZONTAL_LIXO','VERTICAL_ANIMAIS','VERTICAL_BARULHO','VERTICAL_ESTACIONAMENTO') DEFAULT NULL,
  `titulo` varchar(255) DEFAULT NULL,
  `valor_penalidade` decimal(38,2) DEFAULT NULL,
  `condominio_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKjq39nhes3g1t3vnyh5yx2610j` (`condominio_id`),
  CONSTRAINT `FKjq39nhes3g1t3vnyh5yx2610j` FOREIGN KEY (`condominio_id`) REFERENCES `condominio` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `reserva`
--

DROP TABLE IF EXISTS `reserva`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8mb4 */;
CREATE TABLE `reserva` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `data_reserva` datetime(6) DEFAULT NULL,
  `horario_fim` datetime(6) DEFAULT NULL,
  `horario_inicio` datetime(6) DEFAULT NULL,
  `nome` varchar(255) DEFAULT NULL,
  `observacoes` varchar(255) DEFAULT NULL,
  `status` bit(1) DEFAULT NULL,
  `area_id` bigint(20) DEFAULT NULL,
  `morador_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UKgnwwynleyhww9xd9k65591hkl` (`area_id`),
  UNIQUE KEY `UKjfl3pli7sslxrutmuaqrkcvhd` (`morador_id`),
  CONSTRAINT `FKf9lfww720vmmkc01hdp8ot45s` FOREIGN KEY (`area_id`) REFERENCES `area` (`id`),
  CONSTRAINT `FKnhes5nph8m7wkwpom3m0xyy81` FOREIGN KEY (`morador_id`) REFERENCES `morador` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `residencia`
--

DROP TABLE IF EXISTS `residencia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8mb4 */;
CREATE TABLE `residencia` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `andar_id` bigint(20) DEFAULT NULL,
  `bloco_id` bigint(20) DEFAULT NULL,
  `morador_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKanrpri9tlqewts0d7xix9j97e` (`andar_id`),
  KEY `FKkvamllmf64nflb6v4rg1crwf1` (`bloco_id`),
  KEY `FKatiyxyafrfgpmc6rpv39vxvew` (`morador_id`),
  CONSTRAINT `FKanrpri9tlqewts0d7xix9j97e` FOREIGN KEY (`andar_id`) REFERENCES `andar` (`id`),
  CONSTRAINT `FKatiyxyafrfgpmc6rpv39vxvew` FOREIGN KEY (`morador_id`) REFERENCES `morador` (`id`),
  CONSTRAINT `FKkvamllmf64nflb6v4rg1crwf1` FOREIGN KEY (`bloco_id`) REFERENCES `bloco` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `reuniao`
--

DROP TABLE IF EXISTS `reuniao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8mb4 */;
CREATE TABLE `reuniao` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `data_hora` datetime(6) DEFAULT NULL,
  `descricao` varchar(255) DEFAULT NULL,
  `local` varchar(255) DEFAULT NULL,
  `status` bit(1) DEFAULT NULL,
  `tipo_reuniao` tinyint(4) DEFAULT NULL,
  `titulo` varchar(255) DEFAULT NULL,
  `condominio_id` bigint(20) DEFAULT NULL,
  `sindico_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UKha4eecnhkulakgyyv9xw7dus1` (`sindico_id`),
  KEY `FK70dew91lnqmgxqgxrjrsbsmaa` (`condominio_id`),
  CONSTRAINT `FK70dew91lnqmgxqgxrjrsbsmaa` FOREIGN KEY (`condominio_id`) REFERENCES `condominio` (`id`),
  CONSTRAINT `FKmr36d2ouuuansgvf25ftbtgtn` FOREIGN KEY (`sindico_id`) REFERENCES `sindico` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `sindico`
--

DROP TABLE IF EXISTS `sindico`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8mb4 */;
CREATE TABLE `sindico` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cpf` varchar(255) DEFAULT NULL,
  `data_fim_mandato` datetime(6) DEFAULT NULL,
  `data_inicio_mandato` datetime(6) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `nome` varchar(255) DEFAULT NULL,
  `status` bit(1) DEFAULT NULL,
  `telefone` varchar(255) DEFAULT NULL,
  `usuario_sistema` bit(1) DEFAULT NULL,
  `condominio_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKc15t2ic2oh9qi684mxnmea1rq` (`condominio_id`),
  CONSTRAINT `FKc15t2ic2oh9qi684mxnmea1rq` FOREIGN KEY (`condominio_id`) REFERENCES `condominio` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(100) NOT NULL,
  `password` varchar(255) NOT NULL,
  `email` varchar(150) NOT NULL,
  `password_hash` varchar(255) DEFAULT NULL,
  `is_active` tinyint(1) DEFAULT 1,
  `created_at` datetime DEFAULT CURRENT_TIMESTAMP,
  `last_access` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_users_username` (`username`),
  UNIQUE KEY `UK_users_email` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;


--
-- Table structure for table `user_permisions`
--

DROP TABLE IF EXISTS `user_permisions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_permisions` (
  `user_id` bigint(20) NOT NULL,
  `permisions_id` bigint(20) NOT NULL,
  KEY `FK5uh4hfwbs18jhxslnjjwgw0mf` (`permisions_id`),
  CONSTRAINT `FK5uh4hfwbs18jhxslnjjwgw0mf` FOREIGN KEY (`permisions_id`) REFERENCES `permisions` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `visita`
--

DROP TABLE IF EXISTS `visita`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8mb4 */;
CREATE TABLE `visita` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `data_hora_entrada` datetime(6) DEFAULT NULL,
  `data_hora_saida` datetime(6) DEFAULT NULL,
  `extra` varchar(255) DEFAULT NULL,
  `funcionario_id` bigint(20) DEFAULT NULL,
  `morador_id` bigint(20) DEFAULT NULL,
  `residencia_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK12g25h48yr7rbou8mmhxkk5k2` (`funcionario_id`),
  UNIQUE KEY `UKi6wtd5h4ro7dk1m3qky1ye06b` (`residencia_id`),
  KEY `FKiwfw12w826l5hys7oar5al02d` (`morador_id`),
  CONSTRAINT `FK2fcgc6nrwe9s8816j9m1w416p` FOREIGN KEY (`funcionario_id`) REFERENCES `funcionario` (`id`),
  CONSTRAINT `FK5wdnpwwsls93h88jjs657kme7` FOREIGN KEY (`residencia_id`) REFERENCES `residencia` (`id`),
  CONSTRAINT `FKiwfw12w826l5hys7oar5al02d` FOREIGN KEY (`morador_id`) REFERENCES `morador` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `visitante`
--

DROP TABLE IF EXISTS `visitante`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8mb4 */;
CREATE TABLE `visitante` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `autorizado` bit(1) DEFAULT NULL,
  `cor_do_veiculo` varchar(255) DEFAULT NULL,
  `data_entrada` datetime(6) DEFAULT NULL,
  `data_saida` datetime(6) DEFAULT NULL,
  `documento` varchar(255) DEFAULT NULL,
  `modelo_do_veiculo` varchar(255) DEFAULT NULL,
  `nome` varchar(255) DEFAULT NULL,
  `placa_do_veiculo` varchar(255) DEFAULT NULL,
  `telefone` varchar(255) DEFAULT NULL,
  `condominio_id` bigint(20) DEFAULT NULL,
  `visita_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK2gt7r0hyslg13v3mx1ig4tj1f` (`condominio_id`),
  KEY `FKghf7emt9mkrw2u43di7b9uhk2` (`visita_id`),
  CONSTRAINT `FK2gt7r0hyslg13v3mx1ig4tj1f` FOREIGN KEY (`condominio_id`) REFERENCES `condominio` (`id`),
  CONSTRAINT `FKghf7emt9mkrw2u43di7b9uhk2` FOREIGN KEY (`visita_id`) REFERENCES `visita` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*M!100616 SET NOTE_VERBOSITY=@OLD_NOTE_VERBOSITY */;

-- Dump completed on 2025-10-11 22:58:02
