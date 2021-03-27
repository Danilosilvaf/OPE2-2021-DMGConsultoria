-- --------------------------------------------------------
-- Servidor:                     127.0.0.1
-- Versão do servidor:           10.5.8-MariaDB - mariadb.org binary distribution
-- OS do Servidor:               Win64
-- HeidiSQL Versão:              11.0.0.5919
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Copiando estrutura do banco de dados para ijeans
CREATE DATABASE IF NOT EXISTS `ijeans` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `ijeans`;

-- Copiando estrutura para tabela ijeans.fornecedor
CREATE TABLE IF NOT EXISTS `fornecedor` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(200) NOT NULL,
  `email` varchar(200) NOT NULL,
  `telefone` varchar(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

-- Copiando dados para a tabela ijeans.fornecedor: ~1 rows (aproximadamente)
/*!40000 ALTER TABLE `fornecedor` DISABLE KEYS */;
INSERT INTO `fornecedor` (`id`, `nome`, `email`, `telefone`) VALUES
	(1, 'Marcão', 'itysaboy@hotmail.com', '44445555');
/*!40000 ALTER TABLE `fornecedor` ENABLE KEYS */;

-- Copiando estrutura para tabela ijeans.fornecimento
CREATE TABLE IF NOT EXISTS `fornecimento` (
  `id_fornecedor` int(11) NOT NULL,
  `id_produto` int(11) NOT NULL,
  KEY `id_fornecedor` (`id_fornecedor`),
  KEY `id_produto` (`id_produto`),
  CONSTRAINT `fornecimento_ibfk_1` FOREIGN KEY (`id_fornecedor`) REFERENCES `fornecedor` (`id`),
  CONSTRAINT `fornecimento_ibfk_2` FOREIGN KEY (`id_produto`) REFERENCES `produto` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Copiando dados para a tabela ijeans.fornecimento: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `fornecimento` DISABLE KEYS */;
/*!40000 ALTER TABLE `fornecimento` ENABLE KEYS */;

-- Copiando estrutura para tabela ijeans.funcionario
CREATE TABLE IF NOT EXISTS `funcionario` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `login` varchar(20) NOT NULL,
  `senha` varchar(200) NOT NULL,
  `nome` varchar(200) NOT NULL,
  `email` varchar(200) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `login` (`login`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

-- Copiando dados para a tabela ijeans.funcionario: ~3 rows (aproximadamente)
/*!40000 ALTER TABLE `funcionario` DISABLE KEYS */;
INSERT INTO `funcionario` (`id`, `login`, `senha`, `nome`, `email`) VALUES
	(1, 'a', 'a', 'queridao', ''),
	(5, 'b', 'b', 'queridau', 'qrd@hotmail.com'),
	(7, 'c', 'c', 'queridaum', 'qrd1@hotmail.com');
/*!40000 ALTER TABLE `funcionario` ENABLE KEYS */;

-- Copiando estrutura para tabela ijeans.marca
CREATE TABLE IF NOT EXISTS `marca` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(200) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- Copiando dados para a tabela ijeans.marca: ~2 rows (aproximadamente)
/*!40000 ALTER TABLE `marca` DISABLE KEYS */;
INSERT INTO `marca` (`id`, `nome`) VALUES
	(1, 'Nike'),
	(2, 'Adidas');
/*!40000 ALTER TABLE `marca` ENABLE KEYS */;

-- Copiando estrutura para tabela ijeans.produto
CREATE TABLE IF NOT EXISTS `produto` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(200) NOT NULL,
  `preco_atual` float NOT NULL,
  `quantidade_estoque` int(11) NOT NULL,
  `id_marca` int(11) NOT NULL,
  `id_tipo` int(11) NOT NULL,
  `id_tamanho` char(3) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `nome` (`nome`),
  KEY `id_marca` (`id_marca`),
  KEY `id_tipo` (`id_tipo`),
  KEY `id_tamanho` (`id_tamanho`),
  CONSTRAINT `produto_ibfk_1` FOREIGN KEY (`id_marca`) REFERENCES `marca` (`id`),
  CONSTRAINT `produto_ibfk_2` FOREIGN KEY (`id_tipo`) REFERENCES `tipoproduto` (`id`),
  CONSTRAINT `produto_ibfk_3` FOREIGN KEY (`id_tamanho`) REFERENCES `tamanho` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

-- Copiando dados para a tabela ijeans.produto: ~2 rows (aproximadamente)
/*!40000 ALTER TABLE `produto` DISABLE KEYS */;
INSERT INTO `produto` (`id`, `nome`, `preco_atual`, `quantidade_estoque`, `id_marca`, `id_tipo`, `id_tamanho`) VALUES
	(2, 'novo', 30, 25, 1, 1, 'GG'),
	(3, 'novo4', 30, 25, 1, 1, 'GG');
/*!40000 ALTER TABLE `produto` ENABLE KEYS */;

-- Copiando estrutura para tabela ijeans.tamanho
CREATE TABLE IF NOT EXISTS `tamanho` (
  `id` char(3) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Copiando dados para a tabela ijeans.tamanho: ~7 rows (aproximadamente)
/*!40000 ALTER TABLE `tamanho` DISABLE KEYS */;
INSERT INTO `tamanho` (`id`) VALUES
	('G'),
	('GG'),
	('M'),
	('P'),
	('PP'),
	('XG'),
	('XL');
/*!40000 ALTER TABLE `tamanho` ENABLE KEYS */;

-- Copiando estrutura para tabela ijeans.tipoproduto
CREATE TABLE IF NOT EXISTS `tipoproduto` (
  `id` int(11) NOT NULL,
  `nome` varchar(30) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Copiando dados para a tabela ijeans.tipoproduto: ~5 rows (aproximadamente)
/*!40000 ALTER TABLE `tipoproduto` DISABLE KEYS */;
INSERT INTO `tipoproduto` (`id`, `nome`) VALUES
	(1, 'Camiseta'),
	(2, 'Calça'),
	(3, 'Blusa'),
	(4, 'Tênis'),
	(5, 'Camisa');
/*!40000 ALTER TABLE `tipoproduto` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
