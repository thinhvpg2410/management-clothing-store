-- MySQL dump 10.13  Distrib 8.0.27, for macos11 (x86_64)
--
-- Host: 127.0.0.1    Database: management_clothing_store
-- ------------------------------------------------------
-- Server version	8.0.27

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `ChiTietHD`
--

DROP TABLE IF EXISTS `ChiTietHD`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ChiTietHD` (
  `maHD` char(8) NOT NULL,
  `maSP` char(8) NOT NULL,
  `SoLuong` char(8) DEFAULT NULL,
  PRIMARY KEY (`maHD`,`maSP`),
  KEY `maSP` (`maSP`),
  CONSTRAINT `chitiethd_ibfk_1` FOREIGN KEY (`maHD`) REFERENCES `HoaDon` (`maHD`),
  CONSTRAINT `chitiethd_ibfk_2` FOREIGN KEY (`maSP`) REFERENCES `SanPham` (`maSP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ChiTietHD`
--

/*!40000 ALTER TABLE `ChiTietHD` DISABLE KEYS */;
/*!40000 ALTER TABLE `ChiTietHD` ENABLE KEYS */;

--
-- Table structure for table `HoaDon`
--

DROP TABLE IF EXISTS `HoaDon`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `HoaDon` (
  `maHD` char(8) NOT NULL,
  `maNV` char(8) NOT NULL,
  `maKH` char(8) NOT NULL,
  `ngayLapHD` date DEFAULT NULL,
  PRIMARY KEY (`maHD`),
  KEY `maKH` (`maKH`),
  KEY `maNV` (`maNV`),
  CONSTRAINT `hoadon_ibfk_1` FOREIGN KEY (`maKH`) REFERENCES `KhachHang` (`maKH`),
  CONSTRAINT `hoadon_ibfk_2` FOREIGN KEY (`maNV`) REFERENCES `NhanVien` (`maNV`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `HoaDon`
--

/*!40000 ALTER TABLE `HoaDon` DISABLE KEYS */;
/*!40000 ALTER TABLE `HoaDon` ENABLE KEYS */;

--
-- Table structure for table `KhachHang`
--

DROP TABLE IF EXISTS `KhachHang`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `KhachHang` (
  `maKH` char(8) NOT NULL,
  `ten` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `email` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `sdt` char(12) DEFAULT NULL,
  PRIMARY KEY (`maKH`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `KhachHang`
--

/*!40000 ALTER TABLE `KhachHang` DISABLE KEYS */;
/*!40000 ALTER TABLE `KhachHang` ENABLE KEYS */;

--
-- Table structure for table `KhuyenMai`
--

DROP TABLE IF EXISTS `KhuyenMai`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `KhuyenMai` (
  `maKM` char(8) NOT NULL,
  `ten` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `chietKhau` float DEFAULT NULL,
  `ngayBatDau` date DEFAULT NULL,
  `ngayKetThuc` date DEFAULT NULL,
  `moTa` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`maKM`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `KhuyenMai`
--

/*!40000 ALTER TABLE `KhuyenMai` DISABLE KEYS */;
/*!40000 ALTER TABLE `KhuyenMai` ENABLE KEYS */;

--
-- Table structure for table `NhaCungCap`
--

DROP TABLE IF EXISTS `NhaCungCap`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `NhaCungCap` (
  `maNCC` char(8) NOT NULL,
  `ten` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `sdt` char(12) DEFAULT NULL,
  `email` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`maNCC`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `NhaCungCap`
--

/*!40000 ALTER TABLE `NhaCungCap` DISABLE KEYS */;
INSERT INTO `NhaCungCap` VALUES ('NCC0001','Công ty TNHH Thời trang ABC','0123456789','abc@gmail.com');
/*!40000 ALTER TABLE `NhaCungCap` ENABLE KEYS */;

--
-- Table structure for table `NhanVien`
--

DROP TABLE IF EXISTS `NhanVien`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `NhanVien` (
  `maNV` char(8) NOT NULL,
  `ten` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `namSinh` int DEFAULT NULL,
  `email` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `sdt` char(12) DEFAULT NULL,
  `gioiTinh` char(10) DEFAULT NULL,
  PRIMARY KEY (`maNV`),
  KEY `email` (`email`),
  CONSTRAINT `nhanvien_ibfk_1` FOREIGN KEY (`email`) REFERENCES `TaiKhoan` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `NhanVien`
--

/*!40000 ALTER TABLE `NhanVien` DISABLE KEYS */;
/*!40000 ALTER TABLE `NhanVien` ENABLE KEYS */;

--
-- Table structure for table `SanPham`
--

DROP TABLE IF EXISTS `SanPham`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `SanPham` (
  `maSP` char(8) NOT NULL,
  `ten` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `donViTinh` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `giaNhap` float DEFAULT NULL,
  `giaBan` float DEFAULT NULL,
  `ngayNhap` date DEFAULT NULL,
  `soLuongTon` int DEFAULT NULL,
  `trangThai` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `mauSac` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `kichThuoc` char(10) DEFAULT NULL,
  `thueVAT` float DEFAULT NULL,
  `maNCC` char(8) DEFAULT NULL,
  `maKM` char(8) DEFAULT NULL,
  `thuongHieu` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`maSP`),
  KEY `maKM` (`maKM`),
  KEY `maNCC` (`maNCC`),
  CONSTRAINT `sanpham_ibfk_1` FOREIGN KEY (`maKM`) REFERENCES `KhuyenMai` (`maKM`),
  CONSTRAINT `sanpham_ibfk_2` FOREIGN KEY (`maNCC`) REFERENCES `NhaCungCap` (`maNCC`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `SanPham`
--

/*!40000 ALTER TABLE `SanPham` DISABLE KEYS */;
INSERT INTO `SanPham` VALUES ('SP00001','QUẦN TÂY - NÂU','Cái',100000,120000,'2021-01-01',10,'Còn hàng','Nâu','M',0.1,'NCC0001',NULL,'ABC'),('SP00002','VÁY TRƠN','Cái',120000,150000,'2021-02-01',15,'Còn hàng','Đen','S',0.1,'NCC0001',NULL,'ABC'),('SP00003','CHÂN VÁY XẾP LY','Cái',150000,180000,'2021-03-01',20,'Còn hàng','Trắng','L',0.1,'NCC0001',NULL,'ABC'),('SP00004','CHÂN VÁY CÔNG SỞ','Cái',130000,160000,'2021-04-01',18,'Còn hàng','Xanh','XL',0.1,'NCC0001',NULL,'ABC'),('SP00005','SƠ MI HOA','Cái',110000,140000,'2021-05-01',12,'Còn hàng','Đỏ','S',0.1,'NCC0001',NULL,'ABC'),('SP00006','VEST NỮ','Bộ',200000,250000,'2021-06-01',25,'Còn hàng','Đen','M',0.1,'NCC0001',NULL,'ABC'),('SP00007','ĐẦM NỮ','Cái',180000,220000,'2021-07-01',22,'Còn hàng','Hồng','L',0.1,'NCC0001',NULL,'ABC'),('SP00008','SƠ MI NỮ','Cái',160000,200000,'2021-08-01',28,'Còn hàng','Trắng','XL',0.1,'NCC0001',NULL,'ABC');
/*!40000 ALTER TABLE `SanPham` ENABLE KEYS */;

--
-- Table structure for table `TaiKhoan`
--

DROP TABLE IF EXISTS `TaiKhoan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `TaiKhoan` (
  `taiKhoan` char(64) NOT NULL,
  `matKhau` char(64) DEFAULT NULL,
  `loaiTaiKhoan` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `ngayTao` date DEFAULT NULL,
  `email` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `trangThai` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `TaiKhoan`
--

/*!40000 ALTER TABLE `TaiKhoan` DISABLE KEYS */;
/*!40000 ALTER TABLE `TaiKhoan` ENABLE KEYS */;

--
-- Dumping routines for database 'management_clothing_store'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-11-20 14:02:28
