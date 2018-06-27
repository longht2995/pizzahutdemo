-- phpMyAdmin SQL Dump
-- version 4.8.0.1
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th6 26, 2018 lúc 08:44 AM
-- Phiên bản máy phục vụ: 10.1.32-MariaDB
-- Phiên bản PHP: 5.6.36

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `pizzahut`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `category`
--

CREATE TABLE `category` (
  `id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Đang đổ dữ liệu cho bảng `category`
--

INSERT INTO `category` (`id`, `name`) VALUES
(1, 'Veggie'),
(2, 'Meat'),
(3, 'Crust Flavor');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `material`
--

CREATE TABLE `material` (
  `id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `category_id` int(11) DEFAULT NULL,
  `size_id` int(11) DEFAULT NULL,
  `image_id` int(11) DEFAULT NULL,
  `background` varchar(255) DEFAULT NULL,
  `icon` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Đang đổ dữ liệu cho bảng `material`
--

INSERT INTO `material` (`id`, `name`, `price`, `category_id`, `size_id`, `image_id`, `background`, `icon`) VALUES
(1, 'Green Pepper Strips', 3.5, 1, 1, NULL, 'images/itm006663bg.png', 'images/itm006663.png'),
(2, 'Sliced Black Olives', 3.5, 1, 1, NULL, 'images/itm006610bg.png', 'images/itm006610.png'),
(3, 'Smoky Beef Bacon', 3.5, 2, 1, NULL, 'images/itm006651bg.png', 'images/itm006651.png'),
(4, 'Ground Beef', 3.5, 2, 1, NULL, 'images/itm006646bg.png', 'images/itm006646.png'),
(5, 'Fresh Cut Onions', 3.5, 1, 1, NULL, 'images/itm006625bg.png', 'images/itm006625.png'),
(6, 'White Button Mushrooms', 3.5, 1, 1, NULL, 'images/itm006608.png', 'images/itm006614.png'),
(7, 'Garlic Parmesan', 2.5, 3, 1, NULL, 'images/itm005954bg.png', 'images/itm005954.png');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `pizza`
--

CREATE TABLE `pizza` (
  `id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `size_id` int(11) DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Đang đổ dữ liệu cho bảng `pizza`
--

INSERT INTO `pizza` (`id`, `name`, `size_id`, `image`) VALUES
(1, 'Hot Stuff', 1, 'images/itm000170.png'),
(2, 'Create Your Own', 1, 'images/itm000165.png');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `pizza_material`
--

CREATE TABLE `pizza_material` (
  `pizza_id` int(11) NOT NULL,
  `listMaterial_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Đang đổ dữ liệu cho bảng `pizza_material`
--

INSERT INTO `pizza_material` (`pizza_id`, `listMaterial_id`) VALUES
(1, 1),
(1, 4),
(1, 5);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `size`
--

CREATE TABLE `size` (
  `id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Đang đổ dữ liệu cho bảng `size`
--

INSERT INTO `size` (`id`, `name`) VALUES
(1, 'S'),
(2, 'M'),
(3, 'L');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `category`
--
ALTER TABLE `category`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `material`
--
ALTER TABLE `material`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK11D36527B0F69533` (`category_id`),
  ADD KEY `FK11D365271B6A16D3` (`size_id`),
  ADD KEY `FK11D36527EB901641` (`image_id`);

--
-- Chỉ mục cho bảng `pizza`
--
ALTER TABLE `pizza`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK65BDC881B6A16D3` (`size_id`);

--
-- Chỉ mục cho bảng `pizza_material`
--
ALTER TABLE `pizza_material`
  ADD UNIQUE KEY `listMaterial_id` (`listMaterial_id`),
  ADD KEY `FKEB7852FE1B33AB21` (`pizza_id`),
  ADD KEY `FKEB7852FEF94B9935` (`listMaterial_id`);

--
-- Chỉ mục cho bảng `size`
--
ALTER TABLE `size`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `category`
--
ALTER TABLE `category`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT cho bảng `material`
--
ALTER TABLE `material`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT cho bảng `pizza`
--
ALTER TABLE `pizza`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT cho bảng `size`
--
ALTER TABLE `size`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `material`
--
ALTER TABLE `material`
  ADD CONSTRAINT `FK11D365271B6A16D3` FOREIGN KEY (`size_id`) REFERENCES `size` (`id`),
  ADD CONSTRAINT `FK11D36527B0F69533` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`),
  ADD CONSTRAINT `FK11D36527EB901641` FOREIGN KEY (`image_id`) REFERENCES `image` (`id`);

--
-- Các ràng buộc cho bảng `pizza`
--
ALTER TABLE `pizza`
  ADD CONSTRAINT `FK65BDC881B6A16D3` FOREIGN KEY (`size_id`) REFERENCES `size` (`id`);

--
-- Các ràng buộc cho bảng `pizza_material`
--
ALTER TABLE `pizza_material`
  ADD CONSTRAINT `FKEB7852FE1B33AB21` FOREIGN KEY (`pizza_id`) REFERENCES `pizza` (`id`),
  ADD CONSTRAINT `FKEB7852FEF94B9935` FOREIGN KEY (`listMaterial_id`) REFERENCES `material` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
