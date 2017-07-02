-- phpMyAdmin SQL Dump
-- version 3.5.2
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Jul 01, 2017 at 10:16 AM
-- Server version: 5.5.25a
-- PHP Version: 5.4.4

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `app_blogvolley`
--

-- --------------------------------------------------------

--
-- Table structure for table `hape`
--

CREATE TABLE IF NOT EXISTS `hape` (
  `idhp` int(11) NOT NULL,
  `merk` varchar(20) NOT NULL,
  `tipe` varchar(20) NOT NULL,
  `keterangan` text NOT NULL,
  `gambar` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `hape`
--

INSERT INTO `hape` (`idhp`, `merk`, `tipe`, `keterangan`, `gambar`) VALUES
(43534, 'oppo', 'opopopopopop', 'dia adalah orang yang selalu menemanimu ', 'surat lamaran BANK BRI 2.PNG'),
(123, 'Samsung', 'samsung', 'samsung', 'gumiho.png'),
(55555, 'NOKIA', 'nokia', 'nokia', 'berry.png'),
(12345, 'VIVO', 'VIV O23', 'VIVOVIVO', 'vivo.jpg'),
(55556, 'Esia', 'Esia2341dfH', 'Esia adalah sebuah merk hp yang telah di keluarkan oleh lahzad pada tanggal 23 juni 1997 ', 'vietnam (47).jpg');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
