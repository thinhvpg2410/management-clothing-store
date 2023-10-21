USE [master]
GO
/****** Object:  Database [management-clothing-store]    Script Date: 10/18/2023 4:56:52 PM ******/
CREATE DATABASE [management-clothing-store]
GO
ALTER DATABASE [management-clothing-store] SET COMPATIBILITY_LEVEL = 160
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [management-clothing-store].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO

EXEC sys.sp_db_vardecimal_storage_format N'management-clothing-store', N'ON'
GO
USE [management-clothing-store]
GO
/****** Object:  Table [dbo].[ChiTietHD]    Script Date: 10/18/2023 4:56:52 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ChiTietHD](
    [maHD] [nchar](8) NOT NULL,
    [maSP] [nchar](8) NOT NULL,
    [SoLuong] [nchar](8) NULL,
    CONSTRAINT [PK_ChiTietHD] PRIMARY KEY CLUSTERED
(
    [maHD] ASC,
[maSP] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
    ) ON [PRIMARY]
    GO
/****** Object:  Table [dbo].[HoaDon]    Script Date: 10/18/2023 4:56:52 PM ******/
    SET ANSI_NULLS ON
    GO
    SET QUOTED_IDENTIFIER ON
    GO
CREATE TABLE [dbo].[HoaDon](
    [maHD] [nchar](8) NOT NULL,
    [maNV] [nchar](8) NOT NULL,
    [maKH] [nchar](8) NOT NULL,
    [ngayLapHD] [date] NULL,
    CONSTRAINT [PK_HoaDon] PRIMARY KEY CLUSTERED
(
[maHD] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
    ) ON [PRIMARY]
    GO
/****** Object:  Table [dbo].[KhachHang]    Script Date: 10/18/2023 4:56:52 PM ******/
    SET ANSI_NULLS ON
    GO
    SET QUOTED_IDENTIFIER ON
    GO
CREATE TABLE [dbo].[KhachHang](
    [maKH] [nchar](8) NOT NULL,
    [ten] [nvarchar](64) NULL,
    [email] [nvarchar](64) NULL,
    [sdt] [nchar](12) NULL,
    CONSTRAINT [PK_KhachHang] PRIMARY KEY CLUSTERED
(
[maKH] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
    ) ON [PRIMARY]
    GO
/****** Object:  Table [dbo].[KhuyenMai]    Script Date: 10/18/2023 4:56:52 PM ******/
    SET ANSI_NULLS ON
    GO
    SET QUOTED_IDENTIFIER ON
    GO
CREATE TABLE [dbo].[KhuyenMai](
    [maKM] [nchar](8) NOT NULL,
    [ten] [nvarchar](64) NULL,
    [chietKhau] [float] NULL,
    [ngayBatDau] [date] NULL,
    [ngayKetThuc] [date] NULL,
    [moTa] [nvarchar](255) NULL,
    CONSTRAINT [PK_KhuyenMai] PRIMARY KEY CLUSTERED
(
[maKM] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
    ) ON [PRIMARY]
    GO
/****** Object:  Table [dbo].[NhaCungCap]    Script Date: 10/18/2023 4:56:52 PM ******/
    SET ANSI_NULLS ON
    GO
    SET QUOTED_IDENTIFIER ON
    GO
CREATE TABLE [dbo].[NhaCungCap](
    [maNCC] [nchar](8) NOT NULL,
    [ten] [nvarchar](64) NULL,
    [sdt] [nchar](12) NULL,
    [email] [nvarchar](64) NULL,
    CONSTRAINT [PK_NhaCungCAp] PRIMARY KEY CLUSTERED
(
[maNCC] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
    ) ON [PRIMARY]
    GO
/****** Object:  Table [dbo].[NhanVien]    Script Date: 10/18/2023 4:56:52 PM ******/
    SET ANSI_NULLS ON
    GO
    SET QUOTED_IDENTIFIER ON
    GO
CREATE TABLE [dbo].[NhanVien](
    [maNV] [nchar](8) NOT NULL,
    [ten] [nvarchar](64) NULL,
    [namSinh] [int] NULL,
    [email] [nvarchar](64) NOT NULL,
    [sdt] [nchar](12) NULL,
    [gioiTinh] [nchar](10) NULL,
    CONSTRAINT [PK_NhanVien] PRIMARY KEY CLUSTERED
(
[maNV] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
    ) ON [PRIMARY]
    GO
/****** Object:  Table [dbo].[SanPham]    Script Date: 10/18/2023 4:56:52 PM ******/
    SET ANSI_NULLS ON
    GO
    SET QUOTED_IDENTIFIER ON
    GO
CREATE TABLE [dbo].[SanPham](
    [maSP] [nchar](8) NOT NULL,
    [ten] [nvarchar](64) NULL,
    [donViTinh] [nvarchar](50) NULL,
    [giaNhap] [float] NULL,
    [giaBan] [float] NULL,
    [ngayNhap] [date] NULL,
    [soLuongTon] [int] NULL,
    [trangThai] [nvarchar](50) NULL,
    [mauSac] [nvarchar](50) NULL,
    [kichThuoc] [nchar](10) NULL,
    [thueVAT] [float] NULL,
    [maNCC] [nchar](8) NULL,
    [maKM] [nchar](8) NULL,
    CONSTRAINT [PK_SanPham] PRIMARY KEY CLUSTERED
(
[maSP] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
    ) ON [PRIMARY]
    GO
/****** Object:  Table [dbo].[TaiKhoan]    Script Date: 10/18/2023 4:56:52 PM ******/
    SET ANSI_NULLS ON
    GO
    SET QUOTED_IDENTIFIER ON
    GO
CREATE TABLE [dbo].[TaiKhoan](
    [taiKhoan] [nchar](64) NOT NULL,
    [matKhau] [nchar](64) NULL,
    [loaiTaiKhoan] [nvarchar](64) NULL,
    [ngayTao] [date] NULL,
    [email] [nvarchar](64) NOT NULL,
    [trangThai] [nvarchar](64) NULL,
    CONSTRAINT [PK_TaiKhoan] PRIMARY KEY CLUSTERED
(
[email] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
    ) ON [PRIMARY]
    GO

ALTER TABLE [dbo].[ChiTietHD]  WITH CHECK ADD  CONSTRAINT [FK_ChiTietHD_HoaDon] FOREIGN KEY([maHD])
    REFERENCES [dbo].[HoaDon] ([maHD])
    GO
ALTER TABLE [dbo].[ChiTietHD] CHECK CONSTRAINT [FK_ChiTietHD_HoaDon]
    GO
ALTER TABLE [dbo].[ChiTietHD]  WITH CHECK ADD  CONSTRAINT [FK_ChiTietHD_SanPham] FOREIGN KEY([maSP])
    REFERENCES [dbo].[SanPham] ([maSP])
    GO
ALTER TABLE [dbo].[ChiTietHD] CHECK CONSTRAINT [FK_ChiTietHD_SanPham]
    GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD  CONSTRAINT [FK_HoaDon_KhachHang] FOREIGN KEY([maKH])
    REFERENCES [dbo].[KhachHang] ([maKH])
    GO
ALTER TABLE [dbo].[HoaDon] CHECK CONSTRAINT [FK_HoaDon_KhachHang]
    GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD  CONSTRAINT [FK_HoaDon_NhanVien] FOREIGN KEY([maNV])
    REFERENCES [dbo].[NhanVien] ([maNV])
    GO
ALTER TABLE [dbo].[HoaDon] CHECK CONSTRAINT [FK_HoaDon_NhanVien]
    GO
ALTER TABLE [dbo].[NhanVien]  WITH CHECK ADD  CONSTRAINT [FK_NhanVien_TaiKhoan] FOREIGN KEY([email])
    REFERENCES [dbo].[TaiKhoan] ([email])
    GO
ALTER TABLE [dbo].[NhanVien] CHECK CONSTRAINT [FK_NhanVien_TaiKhoan]
    GO
ALTER TABLE [dbo].[SanPham]  WITH CHECK ADD  CONSTRAINT [FK_SanPham_KhuyenMai] FOREIGN KEY([maKM])
    REFERENCES [dbo].[KhuyenMai] ([maKM])
    GO
ALTER TABLE [dbo].[SanPham] CHECK CONSTRAINT [FK_SanPham_KhuyenMai]
    GO
ALTER TABLE [dbo].[SanPham]  WITH CHECK ADD  CONSTRAINT [FK_SanPham_NhaCungCap] FOREIGN KEY([maNCC])
    REFERENCES [dbo].[NhaCungCap] ([maNCC])
    GO
ALTER TABLE [dbo].[SanPham] CHECK CONSTRAINT [FK_SanPham_NhaCungCap]
    GO
    USE [master]
    GO
ALTER DATABASE [management-clothing-store] SET  READ_WRITE
GO
