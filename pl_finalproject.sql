-- phpMyAdmin SQL Dump
-- version 4.7.9
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 04, 2018 at 05:54 AM
-- Server version: 10.1.31-MariaDB
-- PHP Version: 7.2.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `pl_finalproject`
--

-- --------------------------------------------------------

--
-- Table structure for table `rating`
--

CREATE TABLE `rating` (
  `rating_id` int(11) NOT NULL,
  `rating_code` int(1) NOT NULL,
  `rating_timestamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `rating`
--

INSERT INTO `rating` (`rating_id`, `rating_code`, `rating_timestamp`) VALUES
(1, 1, '2018-06-04 03:18:59'),
(2, 1, '2018-06-04 03:19:04'),
(3, 1, '2018-06-04 03:19:06'),
(4, 2, '2018-06-04 03:19:09'),
(5, 3, '2018-06-04 03:19:11'),
(6, 3, '2018-06-04 03:19:12'),
(7, 2, '2018-06-04 03:19:14'),
(8, 2, '2018-06-04 03:19:14'),
(9, 1, '2018-06-04 03:37:05'),
(10, 3, '2018-06-04 03:37:06'),
(11, 2, '2018-06-04 03:37:06'),
(12, 1, '2018-06-04 03:37:06'),
(13, 2, '2018-06-04 03:37:07'),
(14, 2, '2018-06-04 03:37:07'),
(15, 1, '2018-06-04 03:37:08'),
(16, 1, '2018-06-04 03:37:08'),
(17, 2, '2018-06-04 03:37:08'),
(18, 1, '2018-06-04 03:37:09'),
(19, 2, '2018-06-04 03:51:05'),
(20, 3, '2018-06-04 03:51:06'),
(21, 1, '2018-06-04 03:51:07');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `rating`
--
ALTER TABLE `rating`
  ADD PRIMARY KEY (`rating_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `rating`
--
ALTER TABLE `rating`
  MODIFY `rating_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
