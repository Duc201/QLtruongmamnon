USE [master]
GO
/****** Object:  Database [He_Thong_Truong_Mam_Non]    Script Date: 29-Sep-23 1:36:48 PM ******/
CREATE DATABASE [He_Thong_Truong_Mam_Non]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'He_Thong_Truong_Mam_Non', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL16.SQLEXPRESS\MSSQL\DATA\He_Thong_Truong_Mam_Non.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'He_Thong_Truong_Mam_Non_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL16.SQLEXPRESS\MSSQL\DATA\He_Thong_Truong_Mam_Non_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT, LEDGER = OFF
GO
ALTER DATABASE [He_Thong_Truong_Mam_Non] SET COMPATIBILITY_LEVEL = 160
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [He_Thong_Truong_Mam_Non].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [He_Thong_Truong_Mam_Non] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [He_Thong_Truong_Mam_Non] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [He_Thong_Truong_Mam_Non] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [He_Thong_Truong_Mam_Non] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [He_Thong_Truong_Mam_Non] SET ARITHABORT OFF 
GO
ALTER DATABASE [He_Thong_Truong_Mam_Non] SET AUTO_CLOSE ON 
GO
ALTER DATABASE [He_Thong_Truong_Mam_Non] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [He_Thong_Truong_Mam_Non] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [He_Thong_Truong_Mam_Non] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [He_Thong_Truong_Mam_Non] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [He_Thong_Truong_Mam_Non] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [He_Thong_Truong_Mam_Non] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [He_Thong_Truong_Mam_Non] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [He_Thong_Truong_Mam_Non] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [He_Thong_Truong_Mam_Non] SET  ENABLE_BROKER 
GO
ALTER DATABASE [He_Thong_Truong_Mam_Non] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [He_Thong_Truong_Mam_Non] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [He_Thong_Truong_Mam_Non] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [He_Thong_Truong_Mam_Non] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [He_Thong_Truong_Mam_Non] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [He_Thong_Truong_Mam_Non] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [He_Thong_Truong_Mam_Non] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [He_Thong_Truong_Mam_Non] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [He_Thong_Truong_Mam_Non] SET  MULTI_USER 
GO
ALTER DATABASE [He_Thong_Truong_Mam_Non] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [He_Thong_Truong_Mam_Non] SET DB_CHAINING OFF 
GO
ALTER DATABASE [He_Thong_Truong_Mam_Non] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [He_Thong_Truong_Mam_Non] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [He_Thong_Truong_Mam_Non] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [He_Thong_Truong_Mam_Non] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
ALTER DATABASE [He_Thong_Truong_Mam_Non] SET QUERY_STORE = ON
GO
ALTER DATABASE [He_Thong_Truong_Mam_Non] SET QUERY_STORE (OPERATION_MODE = READ_WRITE, CLEANUP_POLICY = (STALE_QUERY_THRESHOLD_DAYS = 30), DATA_FLUSH_INTERVAL_SECONDS = 900, INTERVAL_LENGTH_MINUTES = 60, MAX_STORAGE_SIZE_MB = 1000, QUERY_CAPTURE_MODE = AUTO, SIZE_BASED_CLEANUP_MODE = AUTO, MAX_PLANS_PER_QUERY = 200, WAIT_STATS_CAPTURE_MODE = ON)
GO
USE [He_Thong_Truong_Mam_Non]
GO
/****** Object:  Table [dbo].[Chitietgiaovien]    Script Date: 29-Sep-23 1:36:49 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Chitietgiaovien](
	[maGV] [varchar](10) NOT NULL,
	[maLop] [varchar](10) NOT NULL,
 CONSTRAINT [PK_Chitietgiaovien] PRIMARY KEY CLUSTERED 
(
	[maGV] ASC,
	[maLop] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Chitiethocphi]    Script Date: 29-Sep-23 1:36:49 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Chitiethocphi](
	[maHocPhi1] [int] IDENTITY(1,1) NOT NULL,
	[maHS] [varchar](10) NOT NULL,
	[maLop] [varchar](10) NOT NULL,
	[maHP] [int] NOT NULL,
	[soBua] [int] NULL,
	[tong] [money] NULL,
 CONSTRAINT [PK_Chitiethocphi] PRIMARY KEY CLUSTERED 
(
	[maHocPhi1] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY],
 CONSTRAINT [hocphiduynhat] UNIQUE NONCLUSTERED 
(
	[maHS] ASC,
	[maLop] ASC,
	[maHP] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Chitiethocsinh]    Script Date: 29-Sep-23 1:36:49 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Chitiethocsinh](
	[maHS] [varchar](10) NOT NULL,
	[maLop] [varchar](10) NOT NULL,
	[danhGia] [nvarchar](255) NULL,
 CONSTRAINT [PK_Chitiethocsinh] PRIMARY KEY CLUSTERED 
(
	[maHS] ASC,
	[maLop] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Diemdanh]    Script Date: 29-Sep-23 1:36:49 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Diemdanh](
	[maDD] [int] IDENTITY(1,1) NOT NULL,
	[trangThai] [bit] NOT NULL,
	[ngayHoc] [date] NOT NULL,
	[maHS] [varchar](10) NOT NULL,
	[maLop] [varchar](10) NOT NULL,
 CONSTRAINT [PK__Diemdanh__7A3EF4032CC89DEA] PRIMARY KEY CLUSTERED 
(
	[maDD] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Giaovien]    Script Date: 29-Sep-23 1:36:49 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Giaovien](
	[maGV] [varchar](10) NOT NULL,
	[namCT] [int] NOT NULL,
	[hinhAnh] [nvarchar](50) NULL,
	[maND] [varchar](10) NOT NULL,
 CONSTRAINT [PK__Giaovien__7A3E2D75012C6063] PRIMARY KEY CLUSTERED 
(
	[maGV] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[HocPhi]    Script Date: 29-Sep-23 1:36:49 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HocPhi](
	[maHP] [int] IDENTITY(1,1) NOT NULL,
	[tenHP] [nvarchar](50) NOT NULL,
	[ngayBatDau] [date] NULL,
	[ngayKetThuc] [date] NULL,
	[hocPhi1Bua] [money] NULL,
	[maNienKhoa] [varchar](10) NULL,
 CONSTRAINT [PK_HocPhi] PRIMARY KEY CLUSTERED 
(
	[maHP] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Hocsinh]    Script Date: 29-Sep-23 1:36:49 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Hocsinh](
	[maHS] [varchar](10) NOT NULL,
	[hoTen] [nvarchar](50) NOT NULL,
	[ngaySinh] [date] NOT NULL,
	[gioiTinh] [bit] NOT NULL,
	[danToc] [nvarchar](30) NOT NULL,
	[hinhAnh] [nvarchar](50) NULL,
	[maND] [varchar](10) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[maHS] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Lophoc]    Script Date: 29-Sep-23 1:36:49 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Lophoc](
	[maLop] [varchar](10) NOT NULL,
	[tenLop] [nvarchar](50) NOT NULL,
	[siSo] [int] NOT NULL,
	[hocPhi] [float] NULL,
	[maNienKhoa] [varchar](10) NOT NULL,
 CONSTRAINT [PK__Lophoc__261ECAE393BED6B6] PRIMARY KEY CLUSTERED 
(
	[maLop] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Nguoidung]    Script Date: 29-Sep-23 1:36:49 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Nguoidung](
	[maND] [varchar](10) NOT NULL,
	[tenDN] [varchar](30) NOT NULL,
	[matKhau] [varchar](20) NOT NULL,
	[vaiTro] [varchar](20) NOT NULL,
	[hoTen] [nvarchar](50) NOT NULL,
	[namSinh] [int] NOT NULL,
	[gioiTinh] [bit] NOT NULL,
	[cccd] [varchar](13) NOT NULL,
	[danToc] [nvarchar](20) NOT NULL,
	[diaChi] [nvarchar](200) NOT NULL,
	[soDT] [varchar](10) NOT NULL,
	[email] [varchar](150) NULL,
PRIMARY KEY CLUSTERED 
(
	[maND] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Nienkhoa]    Script Date: 29-Sep-23 1:36:49 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Nienkhoa](
	[maNienKhoa] [varchar](10) NOT NULL,
	[namHoc] [varchar](9) NOT NULL,
	[ngayBD] [date] NOT NULL,
	[ngayKT] [date] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[maNienKhoa] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Thucdon]    Script Date: 29-Sep-23 1:36:49 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Thucdon](
	[maThucDon] [varchar](10) NOT NULL,
	[buaSang] [nvarchar](255) NOT NULL,
	[buaTrua] [nvarchar](255) NOT NULL,
	[ngayHoc] [date] NOT NULL,
	[maNienKhoa] [varchar](10) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[maThucDon] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
ALTER TABLE [dbo].[Chitietgiaovien]  WITH CHECK ADD  CONSTRAINT [FK__Chitietgi__maLop__47DBAE45] FOREIGN KEY([maLop])
REFERENCES [dbo].[Lophoc] ([maLop])
GO
ALTER TABLE [dbo].[Chitietgiaovien] CHECK CONSTRAINT [FK__Chitietgi__maLop__47DBAE45]
GO
ALTER TABLE [dbo].[Chitietgiaovien]  WITH CHECK ADD  CONSTRAINT [FK__Chitietgia__maGV__46E78A0C] FOREIGN KEY([maGV])
REFERENCES [dbo].[Giaovien] ([maGV])
GO
ALTER TABLE [dbo].[Chitietgiaovien] CHECK CONSTRAINT [FK__Chitietgia__maGV__46E78A0C]
GO
ALTER TABLE [dbo].[Chitiethocphi]  WITH CHECK ADD  CONSTRAINT [FK_Chitiethocphi_Chitiethocsinh1] FOREIGN KEY([maHS], [maLop])
REFERENCES [dbo].[Chitiethocsinh] ([maHS], [maLop])
GO
ALTER TABLE [dbo].[Chitiethocphi] CHECK CONSTRAINT [FK_Chitiethocphi_Chitiethocsinh1]
GO
ALTER TABLE [dbo].[Chitiethocphi]  WITH CHECK ADD  CONSTRAINT [FK_Chitiethocphi_HocPhi] FOREIGN KEY([maHP])
REFERENCES [dbo].[HocPhi] ([maHP])
GO
ALTER TABLE [dbo].[Chitiethocphi] CHECK CONSTRAINT [FK_Chitiethocphi_HocPhi]
GO
ALTER TABLE [dbo].[Chitiethocsinh]  WITH CHECK ADD  CONSTRAINT [FK__Chitietho__maLop__44FF419A] FOREIGN KEY([maLop])
REFERENCES [dbo].[Lophoc] ([maLop])
GO
ALTER TABLE [dbo].[Chitiethocsinh] CHECK CONSTRAINT [FK__Chitietho__maLop__44FF419A]
GO
ALTER TABLE [dbo].[Chitiethocsinh]  WITH CHECK ADD  CONSTRAINT [FK__Chitiethoc__maHS__440B1D61] FOREIGN KEY([maHS])
REFERENCES [dbo].[Hocsinh] ([maHS])
GO
ALTER TABLE [dbo].[Chitiethocsinh] CHECK CONSTRAINT [FK__Chitiethoc__maHS__440B1D61]
GO
ALTER TABLE [dbo].[Diemdanh]  WITH CHECK ADD  CONSTRAINT [FK_Diemdanh_Chitiethocsinh] FOREIGN KEY([maHS], [maLop])
REFERENCES [dbo].[Chitiethocsinh] ([maHS], [maLop])
GO
ALTER TABLE [dbo].[Diemdanh] CHECK CONSTRAINT [FK_Diemdanh_Chitiethocsinh]
GO
ALTER TABLE [dbo].[Giaovien]  WITH CHECK ADD  CONSTRAINT [FK__Giaovien__maND__3E52440B] FOREIGN KEY([maND])
REFERENCES [dbo].[Nguoidung] ([maND])
GO
ALTER TABLE [dbo].[Giaovien] CHECK CONSTRAINT [FK__Giaovien__maND__3E52440B]
GO
ALTER TABLE [dbo].[HocPhi]  WITH CHECK ADD  CONSTRAINT [FK_HocPhi_Nienkhoa] FOREIGN KEY([maNienKhoa])
REFERENCES [dbo].[Nienkhoa] ([maNienKhoa])
GO
ALTER TABLE [dbo].[HocPhi] CHECK CONSTRAINT [FK_HocPhi_Nienkhoa]
GO
ALTER TABLE [dbo].[Hocsinh]  WITH CHECK ADD FOREIGN KEY([maND])
REFERENCES [dbo].[Nguoidung] ([maND])
GO
ALTER TABLE [dbo].[Lophoc]  WITH CHECK ADD  CONSTRAINT [FK__Lophoc__maNienKh__3B75D760] FOREIGN KEY([maNienKhoa])
REFERENCES [dbo].[Nienkhoa] ([maNienKhoa])
GO
ALTER TABLE [dbo].[Lophoc] CHECK CONSTRAINT [FK__Lophoc__maNienKh__3B75D760]
GO
ALTER TABLE [dbo].[Thucdon]  WITH CHECK ADD FOREIGN KEY([maNienKhoa])
REFERENCES [dbo].[Nienkhoa] ([maNienKhoa])
GO
USE [master]
GO
ALTER DATABASE [He_Thong_Truong_Mam_Non] SET  READ_WRITE 
GO
