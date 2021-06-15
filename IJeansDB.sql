-- --------------------------------------------------------
-- Host:                         ijeans.cqmkj6jwvg6h.sa-east-1.rds.amazonaws.com
-- Server version:               10.4.13-MariaDB-log - Source distribution
-- Server OS:                    Linux
-- HeidiSQL Version:             11.0.0.5919
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Dumping database structure for ijeans
CREATE DATABASE IF NOT EXISTS `ijeans` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `ijeans`;

-- Dumping structure for table ijeans.fornecedor
CREATE TABLE IF NOT EXISTS `fornecedor` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(200) NOT NULL,
  `email` varchar(200) NOT NULL,
  `telefone` varchar(11) NOT NULL,
  `STATUS` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=latin1;

-- Dumping data for table ijeans.fornecedor: ~2 rows (approximately)
/*!40000 ALTER TABLE `fornecedor` DISABLE KEYS */;
INSERT INTO `fornecedor` (`id`, `nome`, `email`, `telefone`, `STATUS`) VALUES
	(22, 'queridao2', 'queridao@queridao.com', '1199999999', 1),
	(23, 'Trabiques', 'vejasasfotosdafesta@adas.com', '11999999999', 1),
	(24, 'fornecedor', '2', '1122223333', 1);
/*!40000 ALTER TABLE `fornecedor` ENABLE KEYS */;

-- Dumping structure for table ijeans.funcionario
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
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=latin1;

-- Dumping data for table ijeans.funcionario: ~4 rows (approximately)
/*!40000 ALTER TABLE `funcionario` DISABLE KEYS */;
INSERT INTO `funcionario` (`id`, `login`, `senha`, `nome`, `email`, `nivel_func`) VALUES
	(24, 'admin', 'admin', 'admin', 'admin@admin.com', 1),
	(33, 'queridao', 'queridao', 'queridao', 'queridao21@queridao.com', 0),
	(38, 'queridao134232', 'queridao134232', 'queridao', 'queridao134232@dasda.com', 0),
	(39, 'lady.gaga', 'pokerface', 'ladygaga', 'lady@gaga.com', 0),
	(41, 'Nome', 'Senha123', 'Meu Nome', 'meuemail@email.com.br', 0),
	(42, 'Usuario123', '12345678', 'Funcionario 123', 'email@email.com.br', 0);
/*!40000 ALTER TABLE `funcionario` ENABLE KEYS */;

-- Dumping structure for table ijeans.lote
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
) ENGINE=InnoDB AUTO_INCREMENT=57 DEFAULT CHARSET=latin1;

-- Dumping data for table ijeans.lote: ~1 rows (approximately)
/*!40000 ALTER TABLE `lote` DISABLE KEYS */;
INSERT INTO `lote` (`id`, `quantidade`, `preco_compra`, `id_produto`, `id_fornecedor`) VALUES
	(48, -10, -20, 67, 23),
	(49, 2, 100, 67, 22),
	(50, 5, 200, 67, 22),
	(51, -20, 200, 68, 23),
	(52, 120, 20, 67, 22),
	(53, 40, 20, 68, 22),
	(54, 102, 140, 68, 22),
	(55, 1020, -300, 69, 23),
	(56, -40, -30, 72, 22);
/*!40000 ALTER TABLE `lote` ENABLE KEYS */;

-- Dumping structure for table ijeans.marca
CREATE TABLE IF NOT EXISTS `marca` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(200) NOT NULL,
  `STATUS` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

-- Dumping data for table ijeans.marca: ~4 rows (approximately)
/*!40000 ALTER TABLE `marca` DISABLE KEYS */;
INSERT INTO `marca` (`id`, `nome`, `STATUS`) VALUES
	(5, 'puma', 1),
	(6, 'Nike', 1),
	(7, 'Adasd', 0),
	(8, 'org.tabajara', 1),
	(9, 'Editado', 0),
	(10, 'all star', 1);
/*!40000 ALTER TABLE `marca` ENABLE KEYS */;

-- Dumping structure for table ijeans.movimentacao
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
) ENGINE=InnoDB AUTO_INCREMENT=60 DEFAULT CHARSET=latin1;

-- Dumping data for table ijeans.movimentacao: ~1 rows (approximately)
/*!40000 ALTER TABLE `movimentacao` DISABLE KEYS */;
INSERT INTO `movimentacao` (`id`, `quantidade`, `valor_unitario`, `tipo_transacao`, `id_lote`, `DATA`) VALUES
	(51, -10, -20, 1, 48, '2021-06-15'),
	(52, 2, 100, 1, 49, '2021-06-15'),
	(53, 5, 200, 1, 50, '2021-06-15'),
	(54, -20, 200, 1, 51, '2021-06-15'),
	(55, 120, 20, 1, 52, '2021-06-15'),
	(56, 40, 20, 1, 53, '2021-06-15'),
	(57, 102, 140, 1, 54, '2021-06-15'),
	(58, 1020, -300, 1, 55, '2021-06-15'),
	(59, -40, -30, 1, 56, '2021-06-15');
/*!40000 ALTER TABLE `movimentacao` ENABLE KEYS */;

-- Dumping structure for table ijeans.produto
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
) ENGINE=InnoDB AUTO_INCREMENT=73 DEFAULT CHARSET=latin1;

-- Dumping data for table ijeans.produto: ~1 rows (approximately)
/*!40000 ALTER TABLE `produto` DISABLE KEYS */;
INSERT INTO `produto` (`id`, `nome`, `preco_atual`, `quantidade_estoque`, `id_marca`, `id_tipo`, `id_tamanho`, `STATUS`) VALUES
	(67, 'Produto teste', -40, 117, 6, 2, '36', 1),
	(68, 'camiseta', -100, 122, 5, 1, 'PP', 1),
	(69, 'Nome', -500, 1020, 6, 2, '36', 1),
	(72, 'Teste', -30, -40, 5, 1, 'G', 1);
/*!40000 ALTER TABLE `produto` ENABLE KEYS */;

-- Dumping structure for table ijeans.tamanho
CREATE TABLE IF NOT EXISTS `tamanho` (
  `id` char(3) NOT NULL,
  `id_tipo` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table ijeans.tamanho: ~17 rows (approximately)
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

-- Dumping structure for table ijeans.tipoproduto
CREATE TABLE IF NOT EXISTS `tipoproduto` (
  `id` int(11) NOT NULL,
  `nome` varchar(30) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table ijeans.tipoproduto: ~2 rows (approximately)
/*!40000 ALTER TABLE `tipoproduto` DISABLE KEYS */;
INSERT INTO `tipoproduto` (`id`, `nome`) VALUES
	(1, 'Camiseta'),
	(2, 'Tenis');
/*!40000 ALTER TABLE `tipoproduto` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
