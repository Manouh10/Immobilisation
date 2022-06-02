-- phpMyAdmin SQL Dump
-- version 4.5.4.1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Jun 02, 2022 at 08:18 AM
-- Server version: 5.7.11
-- PHP Version: 5.6.18

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `immo`
--

-- --------------------------------------------------------

--
-- Table structure for table `article`
--

CREATE TABLE `article` (
  `id` int(11) NOT NULL,
  `nom_artcile` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `article`
--

INSERT INTO `article` (`id`, `nom_artcile`) VALUES
(1, 'Informatique'),
(2, 'Bureau'),
(3, 'Transport');

-- --------------------------------------------------------

--
-- Table structure for table `employe`
--

CREATE TABLE `employe` (
  `id` int(11) NOT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `prenom` varchar(255) DEFAULT NULL,
  `article` int(11) DEFAULT NULL,
  `date_achat` varchar(255) DEFAULT NULL,
  `date_service` varchar(255) DEFAULT NULL,
  `duree_ammortissement` int(11) DEFAULT NULL,
  `prix_aquisation` int(11) DEFAULT NULL,
  `responsable` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `employe`
--

INSERT INTO `employe` (`id`, `nom`, `prenom`, `article`, `date_achat`, `date_service`, `duree_ammortissement`, `prix_aquisation`, `responsable`) VALUES
(1, 'test', NULL, 1, '2022-05-31', NULL, 5, 13, 3),
(2, 'sdvvdv', NULL, 1, '2022-05-31', NULL, 22, 2, 3),
(3, 'test', NULL, 1, '2022-05-31', NULL, 2, 2, 3),
(4, 'test', NULL, 1, '2022-05-31', NULL, 2, 2, 3),
(5, 'test', NULL, 1, '2022-05-31', NULL, 2, 2, 3),
(6, 'test', NULL, 1, '2022-05-31', NULL, 2, 2, 3),
(7, 'test', NULL, 1, '2022-05-31', NULL, 2, 2, 3),
(8, 'test', NULL, 1, '2022-05-31', NULL, 2, 2, 2),
(9, 'test', NULL, 1, '2022-05-31', NULL, 2, 2, 2);

-- --------------------------------------------------------

--
-- Table structure for table `immobilisation`
--

CREATE TABLE `immobilisation` (
  `id` int(11) NOT NULL,
  `nom` varchar(30) DEFAULT NULL,
  `article` int(11) DEFAULT NULL,
  `prix_aquisation` decimal(10,0) DEFAULT NULL,
  `date_achat` date DEFAULT NULL,
  `date_service` date DEFAULT NULL,
  `responsable` int(11) DEFAULT NULL,
  `duree_ammortissement` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `immobilisation`
--

INSERT INTO `immobilisation` (`id`, `nom`, `article`, `prix_aquisation`, `date_achat`, `date_service`, `responsable`, `duree_ammortissement`) VALUES
(1, 'test', 1, '2', '2022-05-31', '2022-06-01', 3, 2),
(2, 'Ordinateur', 1, '2000000', '2022-06-01', NULL, 3, 5),
(3, 'Table', 2, '1000000', '2022-06-01', NULL, 2, 3),
(4, 'Hoseah manou', 2, '2', '2022-06-01', NULL, 2, 2),
(5, 'Moto', 3, '10000000', '2022-06-01', NULL, 1, 10);

-- --------------------------------------------------------

--
-- Table structure for table `responsable`
--

CREATE TABLE `responsable` (
  `id` int(11) NOT NULL,
  `nom_responsable` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `responsable`
--

INSERT INTO `responsable` (`id`, `nom_responsable`) VALUES
(1, 'Tony Larren'),
(2, 'Jaheem Harris'),
(3, 'Mamy Lahatra Hajaina');

-- --------------------------------------------------------

--
-- Stand-in structure for view `viewimmo`
--
CREATE TABLE `viewimmo` (
`id` int(11)
,`nom` varchar(30)
,`prix_aquisation` decimal(10,0)
,`date_achat` date
,`date_service` date
,`duree_ammortissement` int(11)
,`nom_artcile` varchar(30)
,`nom_responsable` varchar(30)
);

-- --------------------------------------------------------

--
-- Structure for view `viewimmo`
--
DROP TABLE IF EXISTS `viewimmo`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `viewimmo`  AS  (select `i`.`id` AS `id`,`i`.`nom` AS `nom`,`i`.`prix_aquisation` AS `prix_aquisation`,`i`.`date_achat` AS `date_achat`,`i`.`date_service` AS `date_service`,`i`.`duree_ammortissement` AS `duree_ammortissement`,`a`.`nom_artcile` AS `nom_artcile`,`r`.`nom_responsable` AS `nom_responsable` from ((`immobilisation` `i` join `article` `a` on((`a`.`id` = `i`.`article`))) join `responsable` `r` on((`r`.`id` = `i`.`responsable`)))) ;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `article`
--
ALTER TABLE `article`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `employe`
--
ALTER TABLE `employe`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `immobilisation`
--
ALTER TABLE `immobilisation`
  ADD PRIMARY KEY (`id`),
  ADD KEY `article` (`article`),
  ADD KEY `responsable` (`responsable`);

--
-- Indexes for table `responsable`
--
ALTER TABLE `responsable`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `article`
--
ALTER TABLE `article`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `employe`
--
ALTER TABLE `employe`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
--
-- AUTO_INCREMENT for table `immobilisation`
--
ALTER TABLE `immobilisation`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT for table `responsable`
--
ALTER TABLE `responsable`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `immobilisation`
--
ALTER TABLE `immobilisation`
  ADD CONSTRAINT `immobilisation_ibfk_1` FOREIGN KEY (`article`) REFERENCES `article` (`id`),
  ADD CONSTRAINT `immobilisation_ibfk_2` FOREIGN KEY (`responsable`) REFERENCES `responsable` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
