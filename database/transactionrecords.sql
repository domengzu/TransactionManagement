-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 19, 2025 at 01:04 PM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `transactionrecords`
--

-- --------------------------------------------------------

--
-- Table structure for table `transactions`
--

CREATE TABLE `transactions` (
  `id` int(11) NOT NULL,
  `date` datetime NOT NULL DEFAULT current_timestamp(),
  `receiptType` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `address` varchar(255) NOT NULL,
  `productName` varchar(255) NOT NULL,
  `unit` int(255) NOT NULL,
  `pricePerUnit` int(255) NOT NULL,
  `totalPrice` int(255) NOT NULL,
  `recordedBy` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `transactions`
--

INSERT INTO `transactions` (`id`, `date`, `receiptType`, `name`, `address`, `productName`, `unit`, `pricePerUnit`, `totalPrice`, `recordedBy`) VALUES
(1, '2025-04-16 12:59:12', 'Charge', 'Sabin Hotel', 'Wangag', 'Beef', 5, 500, 2500, 'fullname'),
(2, '2025-04-16 12:59:12', 'Sales Receipt', 'edit', 'edit', 'edit', 0, 3434, 3434, 'fullname'),
(3, '2025-04-16 12:59:12', 'Collection Receipt', 'Sabin Resort', 'Cogon', 'Pork', 5, 350, 10000, 'fullname'),
(4, '2025-04-16 12:59:12', 'Charge Receipt', 'Agalon', 'Albuera, mars', 'Chicken', 5, 250, 444, 'fullname'),
(5, '2025-04-16 12:59:12', 'Charge Receipt', 'wangag', 'wangag', 'Chicken', 45, 32, 980, 'fullname'),
(6, '2025-04-16 12:59:12', 'Charge Receipt', 'wow', 'wow', 'wow', 3434, 3434, 3434, 'fullname'),
(7, '2025-04-16 12:59:12', 'Sales Receipt', 'walahh', 'walahh', 'walahh', 54, 54, 54, 'fullname'),
(8, '2025-04-16 12:59:12', 'Charge Receipt', 'baybayon ni Agalon', 'Domenick Alferez', 'Chicken', 5, 45, 4500, 'fullname'),
(9, '2025-04-16 12:59:12', 'Charge Receipt', 'gfgfgf', 'gfgfgf', 'gfgfgf', 4545, 545, 35, 'fullname'),
(10, '2025-04-16 13:00:12', 'Charge Receipt', 'timestamp test', 'wangag', 'time ', 5, 300, 44, 'fullname'),
(11, '2025-04-16 23:45:45', 'Sales Receipt', 'auto load', 'wangag rako boss', 'secret', 5, 345, 53, 'fullname'),
(12, '2025-04-16 23:47:02', 'Charge Receipt', 'auto load data', 'auto load data', 'auto load data', 54, 6554, 3434, 'fullname'),
(13, '2025-04-17 00:00:17', 'Collection Receipt', 'search this', 'put spinner okay ?', 'put spinner okay ?', 5, 56, 45, 'fullname'),
(14, '2025-04-17 00:02:43', 'Charge Receipt', 'input spinner wow wow', 'input spinner', 'input spinner', 4, 3, 343, 'fullname'),
(15, '2025-04-17 00:08:33', 'Charge Receipt', 'input spinner 3', 'input spinner 3', 'input spinner 3', 6, 6, 4545, 'fullname'),
(16, '2025-04-17 10:11:58', 'Charge Receipt', 'input sipnner 4 edited', 'input sipnner 4', 'input sipnner 4', 4, 53, 4545, 'fullname'),
(17, '2025-04-17 10:18:42', 'Collection Receipt', 'input spinner 5 edited', 'input spinner 5 edited', 'input spinner 5 edited', 55, 4545, 9, 'fullname'),
(18, '2025-04-17 10:19:59', 'Charge Receipt', 'input spinner 6', 'input spinner 6', 'input spinner 6', 4545, 4545, 5656, 'fullname'),
(19, '2025-04-17 10:23:42', 'Sales Receipt', 'input spinner edited', 'input spinner 7 edited', 'input spinner 7 edited', 444, 44, 4545, 'fullname'),
(20, '2025-04-17 22:11:12', 'Charge Receipt', 'wow wwo edit', 'bantigue', 'Beef', 5, 500, 2500, 'fullname'),
(21, '2025-04-18 12:01:58', 'Collection Receipt', 'seryos haha wasds', 'first record in address aksdos', 'first record in 18', 7, 7, 45454, 'fullname'),
(22, '2025-04-18 12:02:18', 'Charge Receipt', 'edited haha', 'editedna po', 'editedna po', 7, 5, 45454, 'fullname'),
(23, '2025-04-18 12:06:11', 'Sales Receipt', 'no records haha', 'no records', 'no records', 6, 6, 3554, 'fullname'),
(24, '2025-04-18 12:15:40', 'Collection Receipt', 'input spinner 567 no ref', 'input spinner 567 edited', 'input spinner 5', 55, 4545, 15, 'fullname'),
(25, '2025-04-18 12:15:51', 'Collection Receipt', 'input spinner 5 edit na kana', 'input spinner 5 edited', 'input spinner 5 edited', 55, 4545, 30, 'fullname'),
(26, '2025-04-18 22:38:34', 'Charge Receipt', 'test add updated', 'test add', 'test add', 7, 343, 3434, 'fullname'),
(27, '2025-04-18 22:41:39', 'Charge Receipt', 'save  edit', 'save  wow', 'save', 4433, 545, 443, 'fullname'),
(28, '2025-04-19 15:00:23', 'Charge Receipt', 'karon ', 'karon  april 19 haha', 'ambot', 3343, 334, 433, 'fullname');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `transactions`
--
ALTER TABLE `transactions`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `transactions`
--
ALTER TABLE `transactions`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=29;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
