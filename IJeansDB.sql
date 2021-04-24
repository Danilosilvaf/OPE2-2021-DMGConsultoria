-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               10.5.9-MariaDB - mariadb.org binary distribution
-- Server OS:                    Win64
-- HeidiSQL Version:             11.0.0.5919
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Dumping database structure for IJeans
CREATE DATABASE IF NOT EXISTS `ijeans` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `IJeans`;

-- Dumping structure for table IJeans.fornecedor
CREATE TABLE IF NOT EXISTS `fornecedor` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(200) NOT NULL,
  `email` varchar(200) NOT NULL,
  `telefone` varchar(11) NOT NULL,
  `STATUS` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=latin1;

-- Dumping data for table IJeans.fornecedor: ~5 rows (approximately)
/*!40000 ALTER TABLE `fornecedor` DISABLE KEYS */;
INSERT INTO `fornecedor` (`id`, `nome`, `email`, `telefone`, `STATUS`) VALUES
	(9, 'Queridão', 'Queridao@queridao.com', '1199999999', 1),
	(10, '', '', '', 0),
	(11, '', 'asdas@asdas.com', '11963460773', 0),
	(12, 'Marcos', 'marcos@alunoimpacta.com.br', '1143909734', 1),
	(13, 'asdas', 'asdasdas@a.com', '11123451234', 1),
	(14, 'SADA', 'asas2@SDas.com', '1232131232', 0);
/*!40000 ALTER TABLE `fornecedor` ENABLE KEYS */;

-- Dumping structure for table IJeans.fornecimento
CREATE TABLE IF NOT EXISTS `fornecimento` (
  `id_fornecedor` int(11) NOT NULL,
  `id_produto` int(11) NOT NULL,
  KEY `id_fornecedor` (`id_fornecedor`),
  KEY `id_produto` (`id_produto`),
  CONSTRAINT `fornecimento_ibfk_1` FOREIGN KEY (`id_fornecedor`) REFERENCES `fornecedor` (`id`),
  CONSTRAINT `fornecimento_ibfk_2` FOREIGN KEY (`id_produto`) REFERENCES `produto` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table IJeans.fornecimento: ~0 rows (approximately)
/*!40000 ALTER TABLE `fornecimento` DISABLE KEYS */;
/*!40000 ALTER TABLE `fornecimento` ENABLE KEYS */;

-- Dumping structure for table IJeans.funcionario
CREATE TABLE IF NOT EXISTS `funcionario` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `login` varchar(20) NOT NULL,
  `senha` varchar(200) NOT NULL,
  `nome` varchar(200) NOT NULL,
  `email` varchar(200) NOT NULL,
  `nivel_func` int(1) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `login` (`login`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=latin1;

-- Dumping data for table IJeans.funcionario: ~0 rows (approximately)
/*!40000 ALTER TABLE `funcionario` DISABLE KEYS */;
INSERT INTO `funcionario` (`id`, `login`, `senha`, `nome`, `email`, `nivel_func`) VALUES
	(20, 'queridao', 'queridao', 'queridao', 'queridao@queridao.com', 0);
/*!40000 ALTER TABLE `funcionario` ENABLE KEYS */;

-- Dumping structure for table IJeans.marca
CREATE TABLE IF NOT EXISTS `marca` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(200) NOT NULL,
  `STATUS` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- Dumping data for table IJeans.marca: ~2 rows (approximately)
/*!40000 ALTER TABLE `marca` DISABLE KEYS */;
INSERT INTO `marca` (`id`, `nome`, `STATUS`) VALUES
	(1, 'Nike', 1),
	(2, 'Adidas', 1);
/*!40000 ALTER TABLE `marca` ENABLE KEYS */;

-- Dumping structure for table IJeans.produto
CREATE TABLE IF NOT EXISTS `produto` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(200) NOT NULL,
  `preco_atual` float NOT NULL,
  `quantidade_estoque` int(11) NOT NULL,
  `id_marca` int(11) NOT NULL,
  `id_tipo` int(11) NOT NULL,
  `id_tamanho` char(3) NOT NULL,
  `STATUS` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `nome` (`nome`),
  KEY `id_marca` (`id_marca`),
  KEY `id_tipo` (`id_tipo`),
  KEY `id_tamanho` (`id_tamanho`),
  CONSTRAINT `produto_ibfk_1` FOREIGN KEY (`id_marca`) REFERENCES `marca` (`id`),
  CONSTRAINT `produto_ibfk_2` FOREIGN KEY (`id_tipo`) REFERENCES `tipoproduto` (`id`),
  CONSTRAINT `produto_ibfk_3` FOREIGN KEY (`id_tamanho`) REFERENCES `tamanho` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=latin1;

-- Dumping data for table IJeans.produto: ~22 rows (approximately)
/*!40000 ALTER TABLE `produto` DISABLE KEYS */;
INSERT INTO `produto` (`id`, `nome`, `preco_atual`, `quantidade_estoque`, `id_marca`, `id_tipo`, `id_tamanho`, `STATUS`) VALUES
	(2, 'novo', 30, 25, 1, 1, 'GG', 0),
	(3, 'novo4', 30, 25, 1, 1, 'GG', 0),
	(4, 'novo1', 30, 25, 1, 1, 'GG', 0),
	(5, 'novo23456', 27, 25, 1, 1, 'GG', 0),
	(6, 'Air Jordan 2345', 2333, 25, 1, 1, 'GG', 0),
	(7, 'Air Jordan 7', 30, 25, 1, 1, 'GG', 1),
	(8, 'Air Jordan 6', 30, 25, 1, 1, 'GG', 1),
	(9, 'Air Jordan 5', 30, 25, 1, 1, 'GG', 1),
	(10, 'Air Jordan 4', 30, 25, 1, 1, 'GG', 1),
	(11, 'Air Jordan 3', 30, 25, 1, 1, 'GG', 1),
	(12, 'Air Jordan 2', 30, 25, 1, 1, 'GG', 1),
	(13, 'Air Jordan1', 30, 25, 1, 1, 'GG', 1),
	(14, 'Air Jordan 444', 30, 25, 1, 1, 'GG', 1),
	(15, 'CAMISETA HENLEY', 129.9, 3, 1, 1, 'GG', 1),
	(16, 'a', 12, 1, 1, 1, 'GG', 1),
	(17, '', 0, 0, 1, 1, 'GG', 1),
	(18, 'asdasdasdas', 111, 2, 1, 1, 'G', 1),
	(19, 'aaaaasd', 1, 1, 1, 1, 'G', 1),
	(20, 'adasadas', 123, 1, 1, 1, 'G', 1),
	(21, 'Air Jordan', 18.99, 3, 1, 1, 'G', 1),
	(22, 'aaaassdasdad', 111, 1, 1, 1, 'G', 1),
	(23, 'aasdasdasdasdas', 232.93, 122, 1, 1, 'G', 1);
/*!40000 ALTER TABLE `produto` ENABLE KEYS */;

-- Dumping structure for table IJeans.tamanho
CREATE TABLE IF NOT EXISTS `tamanho` (
  `id` char(3) NOT NULL,
  `id_tipo` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_tipo` (`id_tipo`),
  CONSTRAINT `tamanho_ibfk_1` FOREIGN KEY (`id_tipo`) REFERENCES `tipoproduto` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table IJeans.tamanho: ~19 rows (approximately)
/*!40000 ALTER TABLE `tamanho` DISABLE KEYS */;
INSERT INTO `tamanho` (`id`, `id_tipo`) VALUES
	('32', 2),
	('33', 2),
	('34', 2),
	('35', 2),
	('36', 2),
	('37', 2),
	('38', 2),
	('39', 2),
	('40', 2),
	('41', 2),
	('42', 2),
	('43', 2),
	('44', 2),
	('45', 2),
	('G', 1),
	('GG', 1),
	('M', 1),
	('P', 1),
	('PP', 1);
/*!40000 ALTER TABLE `tamanho` ENABLE KEYS */;

-- Dumping structure for table IJeans.tipoproduto
CREATE TABLE IF NOT EXISTS `tipoproduto` (
  `id` int(11) NOT NULL,
  `nome` varchar(30) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table IJeans.tipoproduto: ~2 rows (approximately)
/*!40000 ALTER TABLE `tipoproduto` DISABLE KEYS */;
INSERT INTO `tipoproduto` (`id`, `nome`) VALUES
	(1, 'Camiseta'),
	(2, 'Tenis');
/*!40000 ALTER TABLE `tipoproduto` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
