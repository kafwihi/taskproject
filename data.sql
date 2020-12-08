-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 08, 2020 at 01:33 PM
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
-- Database: `data`
--

-- --------------------------------------------------------

--
-- Table structure for table `applicants`
--

CREATE TABLE `applicants` (
  `username` varchar(255) NOT NULL,
  `firstname` varchar(255) DEFAULT NULL,
  `lastname` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `applicants`
--

INSERT INTO `applicants` (`username`, `firstname`, `lastname`) VALUES
('alfred@gmail.com', 'michael', 'hilda'),
('love', 'family', 'kafwihi'),
('lyrn', 'Praise', 'kafwihi');

-- --------------------------------------------------------

--
-- Table structure for table `interviews`
--

CREATE TABLE `interviews` (
  `interview_id` bigint(20) NOT NULL,
  `applicant_username` varchar(255) DEFAULT NULL,
  `career_jobname` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `interviews`
--

INSERT INTO `interviews` (`interview_id`, `applicant_username`, `career_jobname`) VALUES
(25, 'lyrn', 'designer2'),
(26, 'lyrn', 'designer1');

-- --------------------------------------------------------

--
-- Table structure for table `jobs`
--

CREATE TABLE `jobs` (
  `jobname` varchar(255) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `education_level` varchar(255) DEFAULT NULL,
  `interview_date` datetime NOT NULL,
  `interview_end_time` varchar(255) DEFAULT NULL,
  `interview_start_time` varchar(255) NOT NULL,
  `status` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `years_of_experience` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `jobs`
--

INSERT INTO `jobs` (`jobname`, `description`, `education_level`, `interview_date`, `interview_end_time`, `interview_start_time`, `status`, `type`, `years_of_experience`) VALUES
('designer1', 'desiging systems', 'Bachelar ', '2020-12-14 00:00:00', '10:00', '9:30', 'vacant', 'test2', '4'),
('designer2', 'desiging systems', 'Bachelar ', '2020-12-15 00:00:00', '10:00', '9:30', 'vacant', 'test2', '4'),
('designer3', 'desiging systems', 'Bachelar ', '2020-12-16 00:00:00', '10:00', '9:30', 'vacant', 'test2', '4');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `username` varchar(255) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  `permission` varchar(255) DEFAULT NULL,
  `previlage` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`username`, `password`, `permission`, `previlage`) VALUES
('admin@gmail.com', '$2a$10$tEbW50RrBgSQfXWLxkvhh.myfJVsi6p90dK9GBNmZM33aWbWZcnoq', 'pending', 'user'),
('test@gmail.com', '$2a$10$ewaXjliaZ16F2gtAQeN7ce5tn1rp58USB2bJoTFzWzpBoR0Dyda86', 'pending', 'user');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `applicants`
--
ALTER TABLE `applicants`
  ADD PRIMARY KEY (`username`);

--
-- Indexes for table `interviews`
--
ALTER TABLE `interviews`
  ADD PRIMARY KEY (`interview_id`),
  ADD KEY `FK6fkh1i4c2lmrxjydhc3al1to6` (`applicant_username`),
  ADD KEY `FK32c536dia0qtxcte1q30hvknb` (`career_jobname`);

--
-- Indexes for table `jobs`
--
ALTER TABLE `jobs`
  ADD PRIMARY KEY (`jobname`),
  ADD UNIQUE KEY `UK_omb21ey1q1d9qgg93te32mfhv` (`interview_date`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`username`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `interviews`
--
ALTER TABLE `interviews`
  MODIFY `interview_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=27;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `interviews`
--
ALTER TABLE `interviews`
  ADD CONSTRAINT `FK32c536dia0qtxcte1q30hvknb` FOREIGN KEY (`career_jobname`) REFERENCES `jobs` (`jobname`),
  ADD CONSTRAINT `FK6fkh1i4c2lmrxjydhc3al1to6` FOREIGN KEY (`applicant_username`) REFERENCES `applicants` (`username`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
