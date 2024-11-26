-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le : ven. 22 nov. 2024 à 20:29
-- Version du serveur : 8.2.0
-- Version de PHP : 8.2.13

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `restaurants`
--

-- --------------------------------------------------------

--
-- Structure de la table `caissier`
--

DROP TABLE IF EXISTS `caissier`;
CREATE TABLE IF NOT EXISTS `caissier` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nom` varchar(255) NOT NULL,
  `mdp` varchar(255) NOT NULL,
  `gerant_id` int NOT NULL,
  `question` varchar(255) NOT NULL,
  `reponse` varchar(255) NOT NULL,
  `date_creation` date NOT NULL,
  `adresse` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `caissier`
--

INSERT INTO `caissier` (`id`, `nom`, `mdp`, `gerant_id`, `question`, `reponse`, `date_creation`, `adresse`) VALUES
(1, 'Blaz\'s', '1234', 8, 'Quel est votre nourriture favorite?', 'ndole', '2024-10-29', ''),
(2, 'PAV', '1478', 1, 'Quel est votre couleur favorite?', 'bleu', '2024-10-29', ''),
(3, 'charle', '963852', 1, 'Quel est votre couleur favorite?', 'marron', '2024-10-29', 'ynd'),
(4, 'grey', '852963', 1, 'Quel est votre couleur favorite?', 'noir', '2024-10-29', 'DOUALA'),
(5, 'loic', 'poa', 1, 'Quel est votre couleur favorite?', 'noir', '2024-10-30', 'DOGPASSY '),
(6, 'yanzo', '12345', 1, 'Quel est votre couleur favorite?', 'bleu', '2024-10-30', 'lopg'),
(7, 'tobi', '456', 1, 'Quel est votre couleur favorite?', 'vert', '2024-10-30', 'lobbessou');

-- --------------------------------------------------------

--
-- Structure de la table `gerant`
--

DROP TABLE IF EXISTS `gerant`;
CREATE TABLE IF NOT EXISTS `gerant` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nom` varchar(255) NOT NULL,
  `mdp` varchar(255) NOT NULL,
  `cle` varchar(255) NOT NULL,
  `question` varchar(255) NOT NULL,
  `reponse` varchar(255) NOT NULL,
  `date` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `gerant`
--

INSERT INTO `gerant` (`id`, `nom`, `mdp`, `cle`, `question`, `reponse`, `date`) VALUES
(1, 'wil', '123456', '123', 'Quel est votre couleur favorite?', 'bleu', NULL);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
