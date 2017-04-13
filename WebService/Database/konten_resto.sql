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
-- Table structure for table `konten_wisata`
--

CREATE TABLE IF NOT EXISTS `konten_resto` (
  `ID_Resto` int(11) NOT NULL AUTO_INCREMENT,
  `Username` varchar(255) NOT NULL,
  `Nama_Resto` varchar(255) NOT NULL,
  `Detail_Resto` longtext NOT NULL,
  `Alamat` longtext NOT NULL,
  `Kota` longtext NOT NULL,
  `Gambar` longtext NOT NULL,
  `Jumlah_Likes` int(11) NOT NULL DEFAULT '0',
  `Created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`ID_Resto`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=20 ;

--
-- Dumping data for table `konten_wisata`
--

INSERT INTO `konten_resto` (`ID_Resto`, `Username`, `Nama_Resto`, `Detail_Resto`, `Alamat`, `Kota`, `Gambar`, `Jumlah_Likes`, `Created_at`) VALUES
(1, 'dias', 'RM Bunda Saliro', 'Rumah makan padang yang menyediakan makanan khas padang yang lezat', 'Jalan Kedamaian no 100, Sleman', 'Yogyakarta', 'http://restopedia.890m.com/restopedia-doc/gambar1.jpg', 1, '2017-03-21 10:35:16'),
(2, 'dias', 'Mie Afui', 'Tempat makan yang menjual mie ayam yang enak namun kotor', 'Jalan Tambakbayan no 77, Sleman', 'Yogyakarta', 'http://restopedia.890m.com/restopedia-doc/gambar2.jpg', 0, '2017-03-22 00:09:37');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
