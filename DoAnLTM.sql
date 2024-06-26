USE [QuanLyDiemSV2]
GO
/****** Object:  Table [dbo].[BangDiem]    Script Date: 1/8/2024 1:35:03 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[BangDiem](
	[MaSV] [nvarchar](50) NULL,
	[TenSV] [nvarchar](50) NULL,
	[dltm] [int] NULL,
	[MonHoc] [nvarchar](50) NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[NguoiDung]    Script Date: 1/8/2024 1:35:03 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NguoiDung](
	[MaND] [nvarchar](50) NULL,
	[TenNd] [nvarchar](50) NULL,
	[MatKhau] [nvarchar](50) NULL,
	[PhanQuyen] [int] NULL,
	[Email] [nvarchar](50) NULL,
	[SDT] [char](10) NULL,
	[LopHoc] [nvarchar](50) NULL
) ON [PRIMARY]
GO
INSERT [dbo].[BangDiem] ([MaSV], [TenSV], [dltm], [MonHoc]) VALUES (N'2080601131', N'Hoang Em', 6, N'Ngu Van ')
INSERT [dbo].[BangDiem] ([MaSV], [TenSV], [dltm], [MonHoc]) VALUES (N'2080600933', N'Hoang Anh An', 10, N'Ly')
INSERT [dbo].[BangDiem] ([MaSV], [TenSV], [dltm], [MonHoc]) VALUES (N'2080601218', N'Van Hoang Tien', 8, N'Hoa')
INSERT [dbo].[BangDiem] ([MaSV], [TenSV], [dltm], [MonHoc]) VALUES (N'2080600939', N'Thai Binh', 8, N'Van')
INSERT [dbo].[BangDiem] ([MaSV], [TenSV], [dltm], [MonHoc]) VALUES (N'2080600991', N'Tan Tai', 10, N'Cong Nghe')
INSERT [dbo].[BangDiem] ([MaSV], [TenSV], [dltm], [MonHoc]) VALUES (N'2080601163', N'The Tai', 9, N'Tin Hoc')
INSERT [dbo].[BangDiem] ([MaSV], [TenSV], [dltm], [MonHoc]) VALUES (N'2080601133', N'Ngoc Tram Em', 10, N'Toan')
INSERT [dbo].[BangDiem] ([MaSV], [TenSV], [dltm], [MonHoc]) VALUES (N'2080601185', N'Ngoc Minh', 6, N'Toan')
INSERT [dbo].[BangDiem] ([MaSV], [TenSV], [dltm], [MonHoc]) VALUES (N'2080600112', N'Hoang Anh', 7, N'Toan')
INSERT [dbo].[BangDiem] ([MaSV], [TenSV], [dltm], [MonHoc]) VALUES (N'2080601133', N'Ngoc Tram Em', 10, N'Hoa Hoc')
GO
INSERT [dbo].[NguoiDung] ([MaND], [TenNd], [MatKhau], [PhanQuyen], [Email], [SDT], [LopHoc]) VALUES (N'2080600937', N'Vu Hoàng Anh', N'12345678', 1, N'trolltinao1@gmail.com', N'0844779298', N'20DTHE6')
INSERT [dbo].[NguoiDung] ([MaND], [TenNd], [MatKhau], [PhanQuyen], [Email], [SDT], [LopHoc]) VALUES (N'2080601218', N'Van An', N'123456789', 0, NULL, NULL, NULL)
GO
