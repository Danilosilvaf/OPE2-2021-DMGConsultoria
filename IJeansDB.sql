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
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=latin1;

-- Dumping data for table IJeans.fornecedor: ~3 rows (approximately)
/*!40000 ALTER TABLE `fornecedor` DISABLE KEYS */;
INSERT INTO `fornecedor` (`id`, `nome`, `email`, `telefone`, `STATUS`) VALUES
	(19, 'queridao', 'queridao@queridao', '11999999999', 1),
	(20, 'Gui', 'gui@alunoimpacta.com', '1188888888', 1),
	(21, 'Edna', 'edna@henrique.com', '11777777777', 1);
/*!40000 ALTER TABLE `fornecedor` ENABLE KEYS */;

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
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=latin1;

-- Dumping data for table IJeans.funcionario: ~2 rows (approximately)
/*!40000 ALTER TABLE `funcionario` DISABLE KEYS */;
INSERT INTO `funcionario` (`id`, `login`, `senha`, `nome`, `email`, `nivel_func`) VALUES
	(24, 'admin', 'admin123', 'admin', 'admin@admin.com', 0),
	(25, 'queridao', 'queridao', 'queridao', 'queridao@queridao.com', 0);
/*!40000 ALTER TABLE `funcionario` ENABLE KEYS */;

-- Dumping structure for table IJeans.lote
CREATE TABLE IF NOT EXISTS `lote` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `quantidade` int(11) NOT NULL,
  `preco_compra` float NOT NULL,
  `id_produto` int(11) NOT NULL,
  `id_fornecedor` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_produto` (`id_produto`),
  KEY `id_fornecedor` (`id_fornecedor`),
  CONSTRAINT `lote_iprodutobfk_1` FOREIGN KEY (`id_produto`) REFERENCES `produto` (`id`),
  CONSTRAINT `lote_iprodutobfk_2` FOREIGN KEY (`id_fornecedor`) REFERENCES `fornecedor` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=latin1;

-- Dumping data for table IJeans.lote: ~3 rows (approximately)
/*!40000 ALTER TABLE `lote` DISABLE KEYS */;
INSERT INTO `lote` (`id`, `quantidade`, `preco_compra`, `id_produto`, `id_fornecedor`) VALUES
	(25, 0, 1000, 44, 19),
	(26, 12, 1000, 45, 21),
	(27, 12, 100, 46, 21),
	(28, 11, 1000, 44, 20),
	(29, 50, 1000, 44, 19),
	(30, 5, 200, 47, 21);
/*!40000 ALTER TABLE `lote` ENABLE KEYS */;

-- Dumping structure for table IJeans.marca
CREATE TABLE IF NOT EXISTS `marca` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(200) NOT NULL,
  `STATUS` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

-- Dumping data for table IJeans.marca: ~2 rows (approximately)
/*!40000 ALTER TABLE `marca` DISABLE KEYS */;
INSERT INTO `marca` (`id`, `nome`, `STATUS`) VALUES
	(1, 'Nike', 1),
	(2, 'Adidas', 1);
/*!40000 ALTER TABLE `marca` ENABLE KEYS */;

-- Dumping structure for table IJeans.movimentacao
CREATE TABLE IF NOT EXISTS `movimentacao` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `quantidade` int(11) NOT NULL,
  `valor_unitario` float NOT NULL,
  `tipo_transacao` tinyint(1) NOT NULL,
  `id_lote` int(11) NOT NULL,
  `DATA` varchar(100) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_lote` (`id_lote`),
  CONSTRAINT `movimentacao_ibfk_1` FOREIGN KEY (`id_lote`) REFERENCES `lote` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

-- Dumping data for table IJeans.movimentacao: ~6 rows (approximately)
/*!40000 ALTER TABLE `movimentacao` DISABLE KEYS */;
INSERT INTO `movimentacao` (`id`, `quantidade`, `valor_unitario`, `tipo_transacao`, `id_lote`, `DATA`) VALUES
	(8, 12, 1000, 1, 25, '2021-05-31'),
	(9, 12, 1000, 1, 26, '2021-05-31'),
	(10, 12, 100, 1, 27, '2021-05-31'),
	(11, 4, 1400, 0, 25, '2021-05-31'),
	(12, 9, 1400, 0, 25, '2021-05-31'),
	(13, 8, 1400, 0, 25, '2021-05-31'),
	(14, 11, 1000, 1, 28, '2021-05-31'),
	(15, 50, 1000, 1, 29, '2021-05-31'),
	(16, 5, 200, 1, 30, '2021-05-31');
/*!40000 ALTER TABLE `movimentacao` ENABLE KEYS */;

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
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=latin1;

-- Dumping data for table IJeans.produto: ~3 rows (approximately)
/*!40000 ALTER TABLE `produto` DISABLE KEYS */;
INSERT INTO `produto` (`id`, `nome`, `preco_atual`, `quantidade_estoque`, `id_marca`, `id_tipo`, `id_tamanho`, `STATUS`) VALUES
	(44, 'Air Jordan 1', 1100, 65, 1, 2, '42', 1),
	(45, 'Ari Jordan 1', 1100, 12, 2, 2, '43', 1),
	(46, 'Camiseta a', 150, 12, 2, 1, 'XL', 1),
	(47, 'Camiseta Adidas X7', 300, 5, 2, 1, 'P', 0);
/*!40000 ALTER TABLE `produto` ENABLE KEYS */;

-- Dumping structure for table IJeans.tamanho
CREATE TABLE IF NOT EXISTS `tamanho` (
  `id` char(3) NOT NULL,
  `id_tipo` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table IJeans.tamanho: ~17 rows (approximately)
/*!40000 ALTER TABLE `tamanho` DISABLE KEYS */;
INSERT INTO `tamanho` (`id`, `id_tipo`) VALUES
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
	('PP', 1),
	('X', 1),
	('XL', 1);
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
