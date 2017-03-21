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
-- Table structure for table `user_api`
--

CREATE TABLE IF NOT EXISTS `user` (
  `ID_User` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `api_key` varchar(255) NOT NULL,
  `total_request` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID_User`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=22 ;

--
-- Dumping data for table `user_api`
--

INSERT INTO `user` (`ID_User`, `username`, `password`, `api_key`, `total_request`) VALUES
(21, 'dias', 'dias', 'ExYctdZGA7HQWaXozurM14', 1),
(22, 'hery', 'hery', 'tLRJEVQGkZNpmB7sxq3218', 3),
(23, 'eric', 'eric', '7cBXDawjrOECIlpMmz8n19', 2),
(24, 'bagong', 'bagong', 'Heqi0PObv4Gp65RBz9Uo20', 0);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
