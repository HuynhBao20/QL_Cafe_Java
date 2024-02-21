﻿
CREATE DATABASE QL_CAFE
GO
USE QL_CAFE
GO
--Phân quyền


--Tạo bảng
CREATE TABLE BAN
(
	MABAN	CHAR(5),
	TENBAN	NVARCHAR(10),
	SONGUOI	INT,
	MAKV	CHAR(5),
	TRANGTHAI NVARCHAR(20),
	CONSTRAINT PK_BAN_MABAN	PRIMARY KEY (MABAN)
)

CREATE TABLE CHITIET_PHIEU
(
	MAPHIEU	CHAR(5),
	MAMON	CHAR(5),
	GIAMGIA	INT,
	SOLUONG	INT,
	CONSTRAINT PK_CHITIET_PHIEU PRIMARY KEY (MAPHIEU, MAMON)
);
CREATE TABLE KHUVUC
(
	MAKV	CHAR(5),
	TENKV	NVARCHAR(20),
	CONSTRAINT PK_KHUVUC PRIMARY KEY (MAKV)
);
CREATE TABLE LOAIMON
(
	MALOAI	CHAR(5),
	TENLOAI NVARCHAR(30),
	CONSTRAINT PK_LOAIMON PRIMARY KEY (MALOAI)
)

CREATE TABLE PHIEU
(
	MAPHIEU	CHAR(5),
	MANV	CHAR(5),
	NGAYLAP	Date,
	MABAN	CHAR(5),
	TINHTIEN	FLOAT,
	CONSTRAINT PK_PHIEU PRIMARY KEY (MAPHIEU)
)

CREATE TABLE THUCDON
(
	MAMON	CHAR(5),
	TENMON	NVARCHAR(30),
	MALOAI	CHAR(5),
	DONGIA	int,
	DVT NVARCHAR(10),
	CONSTRAINT PK_THUCDON PRIMARY KEY (MAMON)
)

CREATE TABLE NHANVIEN
(
	MANV	CHAR(5),
	HOTEN	NVARCHAR(30),
	DIACHI	NVARCHAR(40),
	SDT		CHAR(10),
	NGAYVL	DATE,
	PHAI	NVARCHAR(5),
	NGAYSINH	DATE,
	CONSTRAINT PK_NHANVIEN	PRIMARY KEY (MANV)
)

CREATE TABLE KHO
(
	MAKHO	CHAR(5),
	TENHANG	NVARCHAR(200),
	SLTON	INT,
	PRIMARY KEY (MAKHO),
)
CREATE TABLE NHAPKHO
(
	MAPHIEUNHAP	CHAR(5),
	MANV	CHAR(5),
	TENHANG	NVARCHAR(200),
	SOLUONG	INT,
	NGAYNHAP	DATE,
	MAKHO	CHAR(5),
	FOREIGN KEY (MAKHO) REFERENCES KHO(MAKHO),
	PRIMARY KEY(MAPHIEUNHAP, MANV),
	FOREIGN KEY (MANV) REFERENCES NHANVIEN(MANV)
)
CREATE TABLE CHAMCONG
(
	MANV	CHAR(5),
	NGAY	DATE,
	SOGIO	INT,
	CONSTRAINT PK_CHAMCONG	PRIMARY KEY	(MANV, NGAY, SOGIO)
)

CREATE TABLE Login_log
(
	Acc char(20),
	NgayDN char(20)
)
--Khóa chính, khóa ngoại, ràng buộc
ALTER TABLE BAN
ADD CONSTRAINT FK_BAN_MAKV FOREIGN KEY (MAKV) REFERENCES KHUVUC(MAKV),
CONSTRAINT CHK_BAN_SONGUOI	CHECK (SONGUOI > 0)
GO
ALTER TABLE CHITIET_PHIEU
ADD 
CONSTRAINT FK_CHITIET_PHIEU_MAPHIEU	FOREIGN KEY (MAPHIEU) REFERENCES PHIEU(MAPHIEU),
CONSTRAINT FK_CHITIET_PHIEU_MAMON	FOREIGN KEY (MAMON) REFERENCES THUCDON(MAMON)
GO
ALTER TABLE PHIEU
ADD CONSTRAINT FK_PHIEU_MANV	FOREIGN KEY (MANV) REFERENCES NHANVIEN(MANV),
CONSTRAINT FK_PHIEU_MABAN	FOREIGN KEY (MABAN) REFERENCES BAN(MABAN)
GO
ALTER TABLE THUCDON
ADD CONSTRAINT FK_THUCDON_MALOAI FOREIGN KEY (MALOAI) REFERENCES LOAIMON(MALOAI),
CONSTRAINT CHK_THUCDON_DONGIA	CHECK (DONGIA > 0)

GO
ALTER TABLE NHANVIEN
ADD CONSTRAINT CHK_NHANVIEN_NGAYVL	CHECK (NGAYVL <= GETDATE()),
CONSTRAINT CHK_NHANVIEN_PHAI	CHECK (PHAI = N'Nam' or PHAI = N'Nữ')
GO

ALTER TABLE CHAMCONG
ADD CONSTRAINT FK_CHAMCONG_MANV FOREIGN KEY (MANV) REFERENCES NHANVIEN(MANV)

--INSERT Data
INSERT [dbo].[KHUVUC] ([MAKV], [TENKV]) VALUES (N'KV001', N'Tầng trệt')
INSERT [dbo].[KHUVUC] ([MAKV], [TENKV]) VALUES (N'KV002', N'Tầng 2')
INSERT [dbo].[KHUVUC] ([MAKV], [TENKV]) VALUES (N'KV003', N'Sân vườn')
INSERT [dbo].[KHUVUC] ([MAKV], [TENKV]) VALUES (N'KV004', N'Tầng 2, máy lạnh')
INSERT [dbo].[KHUVUC] ([MAKV], [TENKV]) VALUES (N'KV005', N'VIP')
GO
INSERT [dbo].[BAN] ([MABAN], [TENBAN], [SONGUOI], [MAKV], [TRANGTHAI]) VALUES (N'B0001', N'Bàn 1', 4, N'KV001', N'Đã đặt')
INSERT [dbo].[BAN] ([MABAN], [TENBAN], [SONGUOI], [MAKV], [TRANGTHAI]) VALUES (N'B0002', N'Bàn 2', 4, N'KV002', N'Đã đặt')
INSERT [dbo].[BAN] ([MABAN], [TENBAN], [SONGUOI], [MAKV], [TRANGTHAI]) VALUES (N'B0003', N'Bàn 3', 6, N'KV002', N'Đã đặt')
INSERT [dbo].[BAN] ([MABAN], [TENBAN], [SONGUOI], [MAKV], [TRANGTHAI]) VALUES (N'B0004', N'Bàn 4', 2, N'KV005', N'Đã đặt')
INSERT [dbo].[BAN] ([MABAN], [TENBAN], [SONGUOI], [MAKV], [TRANGTHAI]) VALUES (N'B0005', N'Bàn 5', 4, N'KV005', N'Đã đặt')
INSERT [dbo].[BAN] ([MABAN], [TENBAN], [SONGUOI], [MAKV], [TRANGTHAI]) VALUES (N'B0006', N'Bàn 6', 5, N'KV001', N'Trống')
INSERT [dbo].[BAN] ([MABAN], [TENBAN], [SONGUOI], [MAKV], [TRANGTHAI]) VALUES (N'B0007', N'Bàn 7', 4, N'KV002', N'Đã đặt')
INSERT [dbo].[BAN] ([MABAN], [TENBAN], [SONGUOI], [MAKV], [TRANGTHAI]) VALUES (N'B0008', N'Bàn 8', 4, N'KV005', N'Trống')
INSERT [dbo].[BAN] ([MABAN], [TENBAN], [SONGUOI], [MAKV], [TRANGTHAI]) VALUES (N'B0009', N'Bàn 9', 5, N'KV001', N'Trống')
INSERT [dbo].[BAN] ([MABAN], [TENBAN], [SONGUOI], [MAKV], [TRANGTHAI]) VALUES (N'B0010', N'Bàn 10', 4, N'KV002', N'Trống')
INSERT [dbo].[BAN] ([MABAN], [TENBAN], [SONGUOI], [MAKV], [TRANGTHAI]) VALUES (N'B0011', N'Bàn 11', 3, N'KV002', N'Trống')

GO
INSERT [dbo].[NHANVIEN] ([MANV], [HOTEN], [DIACHI], [SDT], [NGAYVL], [PHAI], [NGAYSINH]) VALUES (N'NV001', N'Huỳnh Thế Bảo', N'Long An', N'09878976  ', CAST(N'2022-08-10' AS Date), N'Nam', CAST(N'2002-10-20' AS Date))
INSERT [dbo].[NHANVIEN] ([MANV], [HOTEN], [DIACHI], [SDT], [NGAYVL], [PHAI], [NGAYSINH]) VALUES (N'NV002', N'Cao Quốc Phú', N'Tây Ninh', N'09879097  ', CAST(N'2023-01-20' AS Date), N'Nam', CAST(N'2002-08-20' AS Date))
INSERT [dbo].[NHANVIEN] ([MANV], [HOTEN], [DIACHI], [SDT], [NGAYVL], [PHAI], [NGAYSINH]) VALUES (N'NV003', N'Trần Quỳnh Như', N'TP. HCM', N'09878764  ', CAST(N'2020-09-18' AS Date), N'Nữ', CAST(N'2002-09-09' AS Date))
INSERT [dbo].[NHANVIEN] ([MANV], [HOTEN], [DIACHI], [SDT], [NGAYVL], [PHAI], [NGAYSINH]) VALUES (N'NV004', N'Hồ Mỹ Như', N'TP. HCM', N'09898793  ', CAST(N'2020-09-23' AS Date), N'Nữ', CAST(N'2002-09-23' AS Date))
INSERT [dbo].[NHANVIEN] ([MANV], [HOTEN], [DIACHI], [SDT], [NGAYVL], [PHAI], [NGAYSINH]) VALUES (N'NV005', N'Ngô Hoài Nhật Duy', N'Tây Ninh', N'09876787  ', CAST(N'2022-09-20' AS Date), N'Nam', CAST(N'2002-10-20' AS Date))
INSERT [dbo].[NHANVIEN] ([MANV], [HOTEN], [DIACHI], [SDT], [NGAYVL], [PHAI], [NGAYSINH]) VALUES (N'NV007', N'Cao thị Trang', N'Tây Ninh', N'09876787  ', CAST(N'2022-09-14' AS Date), N'Nam', CAST(N'2002-10-14' AS Date))
INSERT [dbo].[NHANVIEN] ([MANV], [HOTEN], [DIACHI], [SDT], [NGAYVL], [PHAI], [NGAYSINH]) VALUES (N'NV008', N'Cao thị Trang Anh', N'Tây Ninh', N'09876787  ', CAST(N'2022-09-12' AS Date), N'Nữ', CAST(N'2002-10-12' AS Date))
INSERT [dbo].[NHANVIEN] ([MANV], [HOTEN], [DIACHI], [SDT], [NGAYVL], [PHAI], [NGAYSINH]) VALUES (N'NV009', N'Hóa đơn', N'Tây Ninh', N'09876787  ', CAST(N'2022-09-06' AS Date), N'Nam', CAST(N'2002-10-06' AS Date))
INSERT [dbo].[NHANVIEN] ([MANV], [HOTEN], [DIACHI], [SDT], [NGAYVL], [PHAI], [NGAYSINH]) VALUES (N'NV010', N'Phạm Tiến Phúc', N'Long An', N'09878976  ', CAST(N'2022-08-08' AS Date), N'Nam', CAST(N'2002-10-18' AS Date))
INSERT [dbo].[NHANVIEN] ([MANV], [HOTEN], [DIACHI], [SDT], [NGAYVL], [PHAI], [NGAYSINH]) VALUES (N'NV011', N'Phạm Tiến', N'Long An', N'09878976  ', CAST(N'2022-08-06' AS Date), N'Nam', CAST(N'2002-10-16' AS Date))
INSERT [dbo].[NHANVIEN] ([MANV], [HOTEN], [DIACHI], [SDT], [NGAYVL], [PHAI], [NGAYSINH]) VALUES (N'NV012', N'Phạm Tiến hUN', N'Long An', N'09878976  ', CAST(N'2022-08-04' AS Date), N'Nam', CAST(N'2002-10-14' AS Date))
INSERT [dbo].[NHANVIEN] ([MANV], [HOTEN], [DIACHI], [SDT], [NGAYVL], [PHAI], [NGAYSINH]) VALUES (N'NV013', N'Phạm Tiến Phats', N'Long An', N'09878976  ', CAST(N'2022-08-02' AS Date), N'Nam', CAST(N'2002-10-12' AS Date))
GO
INSERT [dbo].[CHAMCONG] ([MANV], [NGAY], [SOGIO]) VALUES (N'NV001', CAST(N'2022-10-30' AS Date), 3)
INSERT [dbo].[CHAMCONG] ([MANV], [NGAY], [SOGIO]) VALUES (N'NV001', CAST(N'2023-05-30' AS Date), 5)
INSERT [dbo].[CHAMCONG] ([MANV], [NGAY], [SOGIO]) VALUES (N'NV002', CAST(N'2023-03-29' AS Date), 3)
INSERT [dbo].[CHAMCONG] ([MANV], [NGAY], [SOGIO]) VALUES (N'NV010', CAST(N'2023-05-30' AS Date), 2)
INSERT [dbo].[CHAMCONG] ([MANV], [NGAY], [SOGIO]) VALUES (N'NV010', CAST(N'2023-05-30' AS Date), 3)
GO
INSERT [dbo].[LOAIMON] ([MALOAI], [TENLOAI]) VALUES (N'L0001', N'Nước giải khác')
INSERT [dbo].[LOAIMON] ([MALOAI], [TENLOAI]) VALUES (N'L0002', N'Đồ ăn')
INSERT [dbo].[LOAIMON] ([MALOAI], [TENLOAI]) VALUES (N'L0003', N'Cafe')
GO
INSERT [dbo].[THUCDON] ([MAMON], [TENMON], [MALOAI], [DONGIA], [DVT]) VALUES (N'M0001', N'Cafe đen đá', N'L0003', 15000, N'VND')
INSERT [dbo].[THUCDON] ([MAMON], [TENMON], [MALOAI], [DONGIA], [DVT]) VALUES (N'M0002', N'Cafe Muối', N'L0003', 25000, N'VND')
INSERT [dbo].[THUCDON] ([MAMON], [TENMON], [MALOAI], [DONGIA], [DVT]) VALUES (N'M0003', N'Coca cola', N'L0001', 15000, N'VND')
INSERT [dbo].[THUCDON] ([MAMON], [TENMON], [MALOAI], [DONGIA], [DVT]) VALUES (N'M0004', N'Cafe sữa đá', N'L0003', 25000, N'VND')
INSERT [dbo].[THUCDON] ([MAMON], [TENMON], [MALOAI], [DONGIA], [DVT]) VALUES (N'M0005', N'7 Up', N'L0001', 15000, N'VND')
GO
INSERT [dbo].[CHITIET_PHIEU] ([MAPHIEU], [MAMON], [GIAMGIA], [SOLUONG]) VALUES (N'P0001', N'M0001', 10000, 3)
INSERT [dbo].[CHITIET_PHIEU] ([MAPHIEU], [MAMON], [GIAMGIA], [SOLUONG]) VALUES (N'P0001', N'M0002', 0, 1)
INSERT [dbo].[CHITIET_PHIEU] ([MAPHIEU], [MAMON], [GIAMGIA], [SOLUONG]) VALUES (N'P0002', N'M0001', 0, 5)
INSERT [dbo].[CHITIET_PHIEU] ([MAPHIEU], [MAMON], [GIAMGIA], [SOLUONG]) VALUES (N'P0002', N'M0003', 15000, 4)
INSERT [dbo].[CHITIET_PHIEU] ([MAPHIEU], [MAMON], [GIAMGIA], [SOLUONG]) VALUES (N'P0003', N'M0001', 0, 4)
INSERT [dbo].[CHITIET_PHIEU] ([MAPHIEU], [MAMON], [GIAMGIA], [SOLUONG]) VALUES (N'P0003', N'M0003', NULL, 4)
INSERT [dbo].[CHITIET_PHIEU] ([MAPHIEU], [MAMON], [GIAMGIA], [SOLUONG]) VALUES (N'P0008', N'M0003', 0, 3)
GO


INSERT [dbo].[Login_log] ([Acc], [NgayDN]) VALUES (N'NV002               ', N'29/05/2023 01:10:56 ')
INSERT [dbo].[Login_log] ([Acc], [NgayDN]) VALUES (N'sa                  ', N'29/05/2023 01:44:02 ')
INSERT [dbo].[Login_log] ([Acc], [NgayDN]) VALUES (N'sa                  ', N'29/05/2023 11:09:29 ')
INSERT [dbo].[Login_log] ([Acc], [NgayDN]) VALUES (N'sa                  ', N'29/05/2023 11:12:14 ')
INSERT [dbo].[Login_log] ([Acc], [NgayDN]) VALUES (N'sa                  ', N'29/05/2023 11:18:41 ')
INSERT [dbo].[Login_log] ([Acc], [NgayDN]) VALUES (N'sa                  ', N'29/05/2023 11:34:15 ')
INSERT [dbo].[Login_log] ([Acc], [NgayDN]) VALUES (N'sa                  ', N'29/05/2023 11:34:49 ')
INSERT [dbo].[Login_log] ([Acc], [NgayDN]) VALUES (N'sa                  ', N'29/05/2023 11:38:23 ')
INSERT [dbo].[Login_log] ([Acc], [NgayDN]) VALUES (N'sa                  ', N'29/05/2023 11:40:35 ')
INSERT [dbo].[Login_log] ([Acc], [NgayDN]) VALUES (N'sa                  ', N'29/05/2023 12:35:25 ')
INSERT [dbo].[Login_log] ([Acc], [NgayDN]) VALUES (N'NV010               ', N'29/05/2023 12:36:38 ')
INSERT [dbo].[Login_log] ([Acc], [NgayDN]) VALUES (N'sa                  ', N'29/05/2023 14:51:47 ')
INSERT [dbo].[Login_log] ([Acc], [NgayDN]) VALUES (N'NV001               ', N'29/05/2023 15:30:52 ')
INSERT [dbo].[Login_log] ([Acc], [NgayDN]) VALUES (N'SA                  ', N'29/05/2023 15:31:15 ')
INSERT [dbo].[Login_log] ([Acc], [NgayDN]) VALUES (N'NV011               ', N'29/05/2023 15:31:59 ')
INSERT [dbo].[Login_log] ([Acc], [NgayDN]) VALUES (N'SA                  ', N'29/05/2023 15:32:21 ')
INSERT [dbo].[Login_log] ([Acc], [NgayDN]) VALUES (N'SA                  ', N'29/05/2023 15:32:38 ')
INSERT [dbo].[Login_log] ([Acc], [NgayDN]) VALUES (N'SA                  ', N'29/05/2023 15:33:29 ')
INSERT [dbo].[Login_log] ([Acc], [NgayDN]) VALUES (N'NV001               ', N'29/05/2023 16:04:16 ')
INSERT [dbo].[Login_log] ([Acc], [NgayDN]) VALUES (N'NV001               ', N'29/05/2023 16:27:36 ')
INSERT [dbo].[Login_log] ([Acc], [NgayDN]) VALUES (N'NV001               ', N'29/05/2023 16:28:36 ')
INSERT [dbo].[Login_log] ([Acc], [NgayDN]) VALUES (N'NV001               ', N'29/05/2023 16:29:25 ')
INSERT [dbo].[Login_log] ([Acc], [NgayDN]) VALUES (N'NV002               ', N'29/05/2023 22:20:46 ')
INSERT [dbo].[Login_log] ([Acc], [NgayDN]) VALUES (N'NV001               ', N'30/05/2023 10:09:46 ')
INSERT [dbo].[Login_log] ([Acc], [NgayDN]) VALUES (N'sa                  ', N'30/05/2023 10:20:57 ')
INSERT [dbo].[Login_log] ([Acc], [NgayDN]) VALUES (N'sa                  ', N'30/05/2023 10:42:05 ')
INSERT [dbo].[Login_log] ([Acc], [NgayDN]) VALUES (N'sa                  ', N'30/05/2023 10:43:35 ')
INSERT [dbo].[Login_log] ([Acc], [NgayDN]) VALUES (N'SA                  ', N'30/05/2023 10:47:24 ')
INSERT [dbo].[Login_log] ([Acc], [NgayDN]) VALUES (N'sa                  ', N'30/05/2023 10:57:48 ')
INSERT [dbo].[Login_log] ([Acc], [NgayDN]) VALUES (N'sa                  ', N'30/05/2023 10:59:03 ')
INSERT [dbo].[Login_log] ([Acc], [NgayDN]) VALUES (N'sa                  ', N'30/05/2023 11:26:50 ')
INSERT [dbo].[Login_log] ([Acc], [NgayDN]) VALUES (N'SA                  ', N'30/05/2023 11:28:14 ')
INSERT [dbo].[Login_log] ([Acc], [NgayDN]) VALUES (N'SA                  ', N'30/05/2023 11:31:41 ')
INSERT [dbo].[Login_log] ([Acc], [NgayDN]) VALUES (N'SA                  ', N'30/05/2023 11:37:01 ')
INSERT [dbo].[Login_log] ([Acc], [NgayDN]) VALUES (N'SA                  ', N'30/05/2023 11:38:53 ')
INSERT [dbo].[Login_log] ([Acc], [NgayDN]) VALUES (N'NV002               ', N'30/05/2023 11:41:04 ')
INSERT [dbo].[Login_log] ([Acc], [NgayDN]) VALUES (N'SA                  ', N'30/05/2023 11:41:42 ')
INSERT [dbo].[Login_log] ([Acc], [NgayDN]) VALUES (N'sa                  ', N'30/05/2023 14:03:07 ')
INSERT [dbo].[Login_log] ([Acc], [NgayDN]) VALUES (N'NV002               ', N'30/05/2023 14:04:45 ')
INSERT [dbo].[Login_log] ([Acc], [NgayDN]) VALUES (N'SA                  ', N'30/05/2023 14:06:05 ')
INSERT [dbo].[Login_log] ([Acc], [NgayDN]) VALUES (N'NV013               ', N'30/05/2023 14:07:07 ')
INSERT [dbo].[Login_log] ([Acc], [NgayDN]) VALUES (N'SA                  ', N'30/05/2023 14:07:23 ')
INSERT [dbo].[Login_log] ([Acc], [NgayDN]) VALUES (N'NV001               ', N'29/05/2023 16:23:40 ')
INSERT [dbo].[Login_log] ([Acc], [NgayDN]) VALUES (N'SA                  ', N'30/05/2023 11:29:42 ')
INSERT [dbo].[Login_log] ([Acc], [NgayDN]) VALUES (N'SA                  ', N'30/05/2023 11:38:14 ')
INSERT [dbo].[Login_log] ([Acc], [NgayDN]) VALUES (N'NV012               ', N'30/05/2023 11:43:54 ')
INSERT [dbo].[Login_log] ([Acc], [NgayDN]) VALUES (N'NV002               ', N'29/05/2023 01:05:04 ')
INSERT [dbo].[Login_log] ([Acc], [NgayDN]) VALUES (N'NV002               ', N'29/05/2023 01:06:56 ')
INSERT [dbo].[Login_log] ([Acc], [NgayDN]) VALUES (N'SA                  ', N'30/05/2023 11:42:32 ')
INSERT [dbo].[Login_log] ([Acc], [NgayDN]) VALUES (N'NV012               ', N'30/05/2023 11:43:19 ')
INSERT [dbo].[Login_log] ([Acc], [NgayDN]) VALUES (N'SA                  ', N'30/05/2023 11:44:18 ')

INSERT [dbo].[PHIEU] ([MAPHIEU], [MANV], [NGAYLAP], [MABAN], [TINHTIEN]) VALUES (N'P0001', N'NV001', CAST(N'2023-03-23' AS Date), N'B0003', 25000)
INSERT [dbo].[PHIEU] ([MAPHIEU], [MANV], [NGAYLAP], [MABAN], [TINHTIEN]) VALUES (N'P0002', N'NV002', CAST(N'2023-05-18' AS Date), N'B0003', 75000)
INSERT [dbo].[PHIEU] ([MAPHIEU], [MANV], [NGAYLAP], [MABAN], [TINHTIEN]) VALUES (N'P0003', N'NV001', CAST(N'2023-05-26' AS Date), N'B0001', NULL)
INSERT [dbo].[PHIEU] ([MAPHIEU], [MANV], [NGAYLAP], [MABAN], [TINHTIEN]) VALUES (N'P0004', N'NV001', CAST(N'2023-05-26' AS Date), N'B0002', NULL)
INSERT [dbo].[PHIEU] ([MAPHIEU], [MANV], [NGAYLAP], [MABAN], [TINHTIEN]) VALUES (N'P0005', N'NV001', CAST(N'2023-05-26' AS Date), N'B0001', NULL)
INSERT [dbo].[PHIEU] ([MAPHIEU], [MANV], [NGAYLAP], [MABAN], [TINHTIEN]) VALUES (N'P0006', N'NV001', CAST(N'2023-05-26' AS Date), N'B0004', NULL)
INSERT [dbo].[PHIEU] ([MAPHIEU], [MANV], [NGAYLAP], [MABAN], [TINHTIEN]) VALUES (N'P0007', N'NV001', CAST(N'2023-05-26' AS Date), N'B0002', NULL)
INSERT [dbo].[PHIEU] ([MAPHIEU], [MANV], [NGAYLAP], [MABAN], [TINHTIEN]) VALUES (N'P0008', N'NV001', CAST(N'2023-05-26' AS Date), N'B0002', NULL)
INSERT [dbo].[PHIEU] ([MAPHIEU], [MANV], [NGAYLAP], [MABAN], [TINHTIEN]) VALUES (N'P0009', N'NV001', CAST(N'2023-05-26' AS Date), N'B0002', NULL)
INSERT [dbo].[PHIEU] ([MAPHIEU], [MANV], [NGAYLAP], [MABAN], [TINHTIEN]) VALUES (N'P0010', N'NV001', CAST(N'2023-05-26' AS Date), N'B0001', NULL)
INSERT [dbo].[PHIEU] ([MAPHIEU], [MANV], [NGAYLAP], [MABAN], [TINHTIEN]) VALUES (N'P0011', N'NV001', CAST(N'2023-05-26' AS Date), N'B0002', NULL)
GO

--TRUY VẤN CSDL

--Truy vấn tính tiền mỗi phiếu
SELECT p.MAPHIEU, TINHTIEN = (SOLUONG * t.DONGIA - GIAMGIA)
FROM CHITIET_PHIEU ct, PHIEU p, THUCDON t
WHERE ct.MAPHIEU = p.MAPHIEU and ct.MAMON = t.MAMON
--Truy vấn đếm nhân viên từng ca
SELECT concat('Ca: ', CA), COUNT(*) as N'Số lượng nhân viên'
FROM NHANVIEN
GROUP BY CA
--Đếm công nhân viên
go
CREATE PROC sp_TinhCong
as
BEGIN
SELECT nv.MANV, HOTEN, SUM(CC.SOCA) as N'Số ca làm'
FROM NHANVIEN nv, CHAMCONG cc
WHERE NV.MANV = CC.MANV
GROUP BY nv.MANV, HOTEN
END
--proc tìm nhân viên
GO
--Proc 
GO
CREATE VIEW THANHTIEN
AS
SELECT ct.MAPHIEU, t.MAMON, p.MANV, ct.SOLUONG, t.DONGIA, ct.GIAMGIA, p.TINHTIEN
FROM PHIEU p, CHITIET_PHIEU ct, THUCDON t
WHERE p.MAPHIEU = ct.MAPHIEU AND ct.MAMON = t.MAMON
DROP VIEW THANHTIEN

GO
CREATE PROC sp_ThanhTien @MAPHIEU CHAR(10), @MAMON CHAR(10)
AS
BEGIN
	UPDATE THANHTIEN 
	SET TINHTIEN = ((SOLUONG * DONGIA) - GIAMGIA) 
	WHERE MAPHIEU = @MAPHIEU AND MAMON = @MAMON
END
GO
EXEC sp_ThanhTien 'P0003', 'M0002'


SELECT MAPHIEU, SUM(TINHTIEN)
FROM THANHTIEN
GROUP BY MAPHIEU

SELECT CT.MAMON, TENMON, DONGIA, SOLUONG 
FROM CHITIET_PHIEU ct, THUCDON t 
WHERE ct.MAMON = t.MAMON

SELECT MAPHIEU, COUNT(*) FROM THANHTIEN
GROUP BY MAPHIEU
GO

CREATE VIEW GOPMON
AS
SELECT b.MABAN, ct.MAMON, d.TENMON, p.MANV FROM BAN b, CHITIET_PHIEU ct, PHIEU p, THUCDON d
WHERE b.MABAN = p.MABAN and ct.MAPHIEU = p.MAPHIEU and d.MAMON = ct.MAMON

CREATE VIEW BANKV
AS
SELECT b.MABAN, b.TENBAN, SONGUOI, TENKV  FROM BAN b, KHUVUC k
WHERE b.MAKV = k.MAKV 
GO
CREATE VIEW MENU
AS
SELECT t.MALOAI, t.TENMON, t.DONGIA, t.DVT FROM LOAIMON l, THUCDON t
WHERE l.MALOAI = t.MALOAI --AND t.MALOAI = N'L0001'

select * from NHANVIEN WHERE MANV LIKE 'NV%' 

BACKUP DATABASE QL_CAFE
TO DISK='D:\sql\QLCAFE_Ful.bak'

SELECT s.nt_username AS 'Tài khoản đăng nhập', login_time AS 'Thời gian đăng nhập'
FROM sys.sysprocesses s WHERE dbid = DB_ID()


SELECT TENMON FROM LOAIMON l, THUCDON t WHERE l.MALOAI = t.MALOAI AND TENLOAI = 'Cafe'
INSERT INTO CHITIET_PHIEU VALUES ('P0003', 'M0001', 0, 4)
SELECT T.MAMON FROM THUCDON t
where TENMON = N'Cafe đen đá'
INSERT INTO CHITIET_PHIEU(MAPHIEU, MAMON, SOLUONG) VALUES ('P0003', 'M0003', 4)
SELECT CONCAT('Tháng: ', MONTH(NGAY), '-', YEAR(NGAY)) AS 'Tháng' FROM CHAMCONG

CREATE ROLE NHANVIEN
GO
CREATE ROLE QUANLY
GO
--Cấp quyền role quản lý
grant SELECT, DELETE, INSERT, UPDATE ON NHANVIEN TO QUANLY
grant SELECT, DELETE, INSERT, UPDATE ON BAN TO QUANLY
grant SELECT, DELETE, INSERT, UPDATE ON CHAMCONG TO QUANLY
grant SELECT, DELETE, INSERT, UPDATE ON CHITIET_PHIEU TO QUANLY
grant SELECT, DELETE, INSERT, UPDATE ON KHUVUC TO QUANLY
grant SELECT, DELETE, INSERT, UPDATE ON LOAIMON TO QUANLY
grant SELECT, DELETE, INSERT, UPDATE ON PHIEU TO QUANLY
grant SELECT, DELETE, INSERT, UPDATE ON THUCDON TO QUANLY

GO
--Cấp quyền cho role nhân viên
grant SELECT, DELETE, INSERT, UPDATE ON BAN TO NHANVIEN
grant SELECT, DELETE, INSERT, UPDATE ON CHITIET_PHIEU TO NHANVIEN
grant SELECT, DELETE, INSERT, UPDATE ON KHUVUC TO NHANVIEN
grant SELECT, DELETE, INSERT, UPDATE ON LOAIMON TO NHANVIEN
grant SELECT, INSERT ON PHIEU TO NHANVIEN
grant SELECT, DELETE, INSERT, UPDATE ON THUCDON TO NHANVIEN
GO