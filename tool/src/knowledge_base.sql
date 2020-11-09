-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 08, 2020 at 07:31 PM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.4.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `knowledge_base`
--

-- --------------------------------------------------------

--
-- Table structure for table `sla_table`
--

CREATE TABLE `sla_table` (
  `sla_id` int(255) UNSIGNED NOT NULL,
  `sla_service` varchar(100) NOT NULL,
  `sla_name` varchar(255) NOT NULL,
  `sla_type` varchar(255) DEFAULT NULL,
  `sla_plan` varchar(255) DEFAULT NULL,
  `availability_zone` tinyint(1) DEFAULT NULL,
  `MUP` float DEFAULT NULL COMMENT 'Monthly Uptime Percentage',
  `RTO` int(100) DEFAULT NULL COMMENT 'Recovery Time Objective(Max time)',
  `RTO_monthly` float DEFAULT NULL,
  `RPO` int(100) DEFAULT NULL COMMENT 'Recovery Point Objective(Max time)',
  `RPO_monthly` float DEFAULT NULL,
  `MAP` float DEFAULT NULL COMMENT 'Monthly Availability Percentage',
  `MTP` float DEFAULT NULL COMMENT 'Monthly Throughput Percentage',
  `CAP` float DEFAULT NULL COMMENT 'Consistency Attainment Percentage ',
  `LAP` float DEFAULT NULL COMMENT 'Latency Attainment Percentage'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `sla_table`
--

INSERT INTO `sla_table` (`sla_id`, `sla_service`, `sla_name`, `sla_type`, `sla_plan`, `availability_zone`, `MUP`, `RTO`, `RTO_monthly`, `RPO`, `RPO_monthly`, `MAP`, `MTP`, `CAP`, `LAP`) VALUES
(1, 'Database', 'Azure SQL Database', 'Vcore', 'General Purpose', NULL, 99.99, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(3, 'Database', 'Azure SQL Database', 'Vcore', 'Business Critical', NULL, 99.99, 30, 100, 5, 100, NULL, NULL, NULL, NULL),
(4, 'Database', 'Azure SQL Database', 'Vcore', 'HyperScale', NULL, 99.95, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `sla_table`
--
ALTER TABLE `sla_table`
  ADD PRIMARY KEY (`sla_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `sla_table`
--
ALTER TABLE `sla_table`
  MODIFY `sla_id` int(255) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
