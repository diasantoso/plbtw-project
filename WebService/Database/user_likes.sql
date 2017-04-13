-- phpMyAdmin SQL Dump
-- version 4.0.10.14
-- http://www.phpmyadmin.net
--
-- Host: localhost:3306
-- Generation Time: Jun 06, 2016 at 02:54 AM
-- Server version: 5.5.49-cll
-- PHP Version: 5.4.31

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `hnwtvcco_database`
--

-- --------------------------------------------------------

--
-- Table structure for table `user_votes`
--

CREATE TABLE IF NOT EXISTS `user_likes` (
  `ID_Like` int(11) NOT NULL AUTO_INCREMENT,
  `Username` varchar(255) NOT NULL,
  `ID_Resto` int(11) NOT NULL,
  `Flag` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID_Like`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=10 ;

--
-- Dumping data for table `user_votes`
--

INSERT INTO `user_likes` (`ID_Like`, `Username`, `ID_Resto`, `Flag`) VALUES
(1, 'dias', 1, 2),
(2, 'dias', 2, 0),
(3, 'hery', 1, 2),
(4, 'hery', 2, 0),
(5, 'bagong', 1, 0),
(6, 'bagong', 2, 0),
(7, 'eric', 1, 0),
(8, 'eric', 2, 0);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
