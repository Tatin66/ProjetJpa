-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le : mar. 18 juil. 2023 à 08:09
-- Version du serveur :  5.7.31
-- Version de PHP : 7.4.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `popjpa`
--
CREATE DATABASE IF NOT EXISTS `popjpa` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `popjpa`;

-- --------------------------------------------------------

--
-- Structure de la table `commande`
--

DROP TABLE IF EXISTS `commande`;
CREATE TABLE IF NOT EXISTS `commande` (
  `id_commande` int(11) NOT NULL AUTO_INCREMENT,
  `session_id` varchar(32) DEFAULT NULL,
  `telephone` varchar(12) DEFAULT NULL,
  `nom` varchar(50) DEFAULT NULL,
  `date` date DEFAULT NULL,
  PRIMARY KEY (`id_commande`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `commande`
--

INSERT INTO `commande` (`id_commande`, `session_id`, `telephone`, `nom`, `date`) VALUES
(1, 'aaa', '+33656544332', 'Tota', '2023-07-18');

-- --------------------------------------------------------

--
-- Structure de la table `commande_produit`
--

DROP TABLE IF EXISTS `commande_produit`;
CREATE TABLE IF NOT EXISTS `commande_produit` (
  `id_commande` int(11) NOT NULL,
  `id_produit` int(11) NOT NULL,
  `quantite_produit` int(11) DEFAULT NULL,
  KEY `fk_commande_produit` (`id_commande`),
  KEY `fk_produit_commande` (`id_produit`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `commande_produit`
--

INSERT INTO `commande_produit` (`id_commande`, `id_produit`, `quantite_produit`) VALUES
(1, 1, NULL),
(1, 2, NULL),
(1, 2, 1),
(1, 2, 1);

-- --------------------------------------------------------

--
-- Structure de la table `produit`
--

DROP TABLE IF EXISTS `produit`;
CREATE TABLE IF NOT EXISTS `produit` (
  `id_produit` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `url_image` varchar(255) DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  `prix` float DEFAULT NULL,
  PRIMARY KEY (`id_produit`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `produit`
--

INSERT INTO `produit` (`id_produit`, `name`, `url_image`, `quantity`, `prix`) VALUES
(1, 'pop trop style', 'je suis une image', 1000, 10.05),
(2, 'pop trop style le retour', 'image 2', 1000, 10.05);

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `commande_produit`
--
ALTER TABLE `commande_produit`
  ADD CONSTRAINT `fk_commande_produit` FOREIGN KEY (`id_commande`) REFERENCES `commande` (`id_commande`),
  ADD CONSTRAINT `fk_produit_commande` FOREIGN KEY (`id_produit`) REFERENCES `produit` (`id_produit`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
