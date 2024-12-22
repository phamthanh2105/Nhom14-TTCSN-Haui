USE master
GO

-- Drop the database if it already exists
IF EXISTS ( SELECT name
                FROM sys.databases
                WHERE name = N'QuanLyChungCu' )
    DROP DATABASE QuanLyChungCu
GO

CREATE DATABASE QuanLyChungCu
GO

USE QuanLyChungCu
/*





*/
---------- Tables ----------

-- Account Table --
CREATE TABLE TAIKHOAN
    (
      TenTaiKhoan VARCHAR(25) CONSTRAINT pk_TAIKHOAN PRIMARY KEY ,
      MatKhau VARCHAR(16) NOT NULL ,
      VaiTro BIT NOT NULL
                 DEFAULT 0
    )
GO

-- Area Apartment Table
CREATE TABLE KHUCANHO
    (
      MaKhu CHAR(2) CONSTRAINT pk_KHUCANHO PRIMARY KEY ,
      TenKhu NVARCHAR(50) NOT NULL ,
      SoTang INT NOT NULL
                 DEFAULT 1 ,
      SoCanTT INT NOT NULL
                  DEFAULT 1 ,
      DiaChi NVARCHAR(100) NOT NULL,
	)

-- Resident Table --
CREATE TABLE CUDAN
    (
      MaCuDan CHAR(6) CONSTRAINT pk_CUDAN PRIMARY KEY ,
      TenCuDan NVARCHAR(50) NOT NULL ,
      NgaySinh DATE NOT NULL
                    DEFAULT GETDATE() ,
      GioiTinh BIT NOT NULL
                   DEFAULT 0 ,
      SoDT CHAR(10) NOT NULL ,
      SoCMT CHAR(12) NOT NULL ,
      QueQuan NVARCHAR(100) NOT NULL
    )
GO

-- Apartment Table --
CREATE TABLE CANHO
    (
      MaCanHo CHAR(6) CONSTRAINT pk_CANHO PRIMARY KEY ,
      DienTich FLOAT NOT NULL
                     DEFAULT 50 ,
      Gia BIGINT NOT NULL ,
      TrangThai BIT NOT NULL
                    DEFAULT 0 ,
      SoPhong INT NOT NULL
                  DEFAULT 5 ,
      MaCuDan CHAR(6)
        CONSTRAINT fk1_CANHO FOREIGN KEY REFERENCES dbo.CUDAN ( MaCuDan ) ,
      MaKhu CHAR(2)
        NOT NULL
        DEFAULT 'AA'
        CONSTRAINT fk2_CANHO
        FOREIGN KEY REFERENCES dbo.KHUCANHO ( MaKhu ) ON DELETE CASCADE
        ON UPDATE CASCADE --  (AA -> ZZ)
    )
GO

-- Contract Table --
CREATE TABLE HOPDONG
    (
      MaHopDong CHAR(12) NOT NULL
                         CONSTRAINT pk_HOPDONG PRIMARY KEY , -- HD0000000001
      NgayGiaoDich DATE NOT NULL
                        DEFAULT GETDATE() ,
      DiaChiKH NVARCHAR(100) NOT NULL ,
      MaCuDan CHAR(6)
        NOT NULL
        CONSTRAINT fk1_HOPDONG FOREIGN KEY REFERENCES dbo.CUDAN ( MaCuDan ) ,
      MaCanHo CHAR(6)
        NOT NULL
        CONSTRAINT fk2_HOPDONG
        FOREIGN KEY REFERENCES dbo.CANHO ( MaCanHo ) ON DELETE CASCADE
        ON UPDATE CASCADE,
    )
GO

-------- TaiKhoan ----------
INSERT [dbo].[TAIKHOAN] ([TenTaiKhoan], [MatKhau], [VaiTro]) VALUES (N'Admin', N'123456', 1)
INSERT [dbo].[TAIKHOAN] ([TenTaiKhoan], [MatKhau], [VaiTro]) VALUES (N'NV001', N'abc123', 0)
INSERT [dbo].[TAIKHOAN] ([TenTaiKhoan], [MatKhau], [VaiTro]) VALUES (N'NV002', N'kiutui254', 0)
GO



  USE QuanLyChungCu
  GO
  CREATE PROC [dbo].[searchApartmentWithCriterias]
    @trangthai BIT ,
    @tugia BIGINT ,
    @dengia BIGINT ,
    @tudt FLOAT ,
    @dendt FLOAT
  AS
    BEGIN
  -----
        IF ( @dendt = 0 AND @dengia = 0 ) 
            SELECT c.MaCanHo, c.DienTich, c.Gia, c.TrangThai, c.SoPhong,
                    c.MaCuDan, k.TenKhu
                FROM [QuanLyChungCu].[dbo].[CANHO] c
                    JOIN [QuanLyChungCu].[dbo].KHUCANHO k
                    ON k.MaKhu = c.MaKhu
                WHERE TrangThai = @trangthai AND Gia > @tugia AND DienTich > @tudt
        ELSE 
            IF ( @dendt = 0 AND ( ( @tugia = 0 AND @dengia = 150000 ) OR ( @tugia = 150000 AND @dengia = 300000 ) ) )
                SELECT c.MaCanHo, c.DienTich, c.Gia, c.TrangThai, c.SoPhong,
                        c.MaCuDan, k.TenKhu
                    FROM [QuanLyChungCu].[dbo].[CANHO] c
                        JOIN [QuanLyChungCu].[dbo].KHUCANHO k
                        ON k.MaKhu = c.MaKhu
                    WHERE TrangThai = @trangthai AND Gia BETWEEN @tugia AND @dengia AND DienTich > @tudt
            ELSE 
                IF ( @dengia = 0 AND ( ( @tudt = 40 AND @dendt = 60 ) OR ( @tudt = 60 AND @dendt = 80 ) ) )
                    SELECT c.MaCanHo, c.DienTich, c.Gia, c.TrangThai,
                            c.SoPhong, c.MaCuDan, k.TenKhu
                        FROM [QuanLyChungCu].[dbo].[CANHO] c
                            JOIN [QuanLyChungCu].[dbo].KHUCANHO k
                            ON k.MaKhu = c.MaKhu
                        WHERE TrangThai = @trangthai AND Gia > @tugia AND DienTich BETWEEN @tudt AND @dendt
                ELSE
                    SELECT c.MaCanHo, c.DienTich, c.Gia, c.TrangThai,
                            c.SoPhong, c.MaCuDan, k.TenKhu
                        FROM [QuanLyChungCu].[dbo].[CANHO] c
                            JOIN [QuanLyChungCu].[dbo].KHUCANHO k
                            ON k.MaKhu = c.MaKhu
                        WHERE TrangThai = @trangthai AND Gia BETWEEN @tugia AND @dengia AND DienTich BETWEEN @tudt AND @dendt
  -----
    END

GO
SELECT * FROM  dbo.CANHO
EXEC dbo.searchApartmentWithCriterias 0,300000,0,60,80 -- 
GO 
CREATE PROC [dbo].[searchApartments]
    @tugia BIGINT ,
    @dengia BIGINT ,
    @tudt FLOAT ,
    @dendt FLOAT,
	@sophong INT
  AS
    BEGIN
  -----
        IF ( @dendt = 0 AND @dengia = 0 )
            SELECT c.MaCanHo, c.DienTich, c.Gia, c.SoPhong, k.TenKhu
                FROM [QuanLyChungCu].[dbo].[CANHO] c
                    JOIN [QuanLyChungCu].[dbo].KHUCANHO k
                    ON k.MaKhu = c.MaKhu
                WHERE TrangThai = 0 AND Gia > @tugia AND DienTich > @tudt AND SoPhong=@sophong
        ELSE
            IF ( @dendt = 0 AND ( ( @tugia = 0 AND @dengia = 150000 ) OR ( @tugia = 150000 AND @dengia = 300000 ) ) )
                SELECT c.MaCanHo, c.DienTich, c.Gia, c.SoPhong, k.TenKhu
                    FROM [QuanLyChungCu].[dbo].[CANHO] c
                        JOIN [QuanLyChungCu].[dbo].KHUCANHO k
                        ON k.MaKhu = c.MaKhu
                    WHERE Gia BETWEEN @tugia AND @dengia AND DienTich > @tudt AND SoPhong=@sophong
            ELSE 
                IF ( @dengia = 0 AND ( ( @tudt = 40 AND @dendt = 60 ) OR ( @tudt = 60 AND @dendt = 80 ) ) )
                    SELECT c.MaCanHo, c.DienTich, c.Gia, c.SoPhong, k.TenKhu
                        FROM [QuanLyChungCu].[dbo].[CANHO] c
                            JOIN [QuanLyChungCu].[dbo].KHUCANHO k
                            ON k.MaKhu = c.MaKhu
                        WHERE Gia > @tugia AND DienTich BETWEEN @tudt AND @dendt AND SoPhong=@sophong
                ELSE
                    SELECT c.MaCanHo, c.DienTich, c.Gia, c.SoPhong, k.TenKhu
                        FROM [QuanLyChungCu].[dbo].[CANHO] c
                            JOIN [QuanLyChungCu].[dbo].KHUCANHO k
                            ON k.MaKhu = c.MaKhu
                        WHERE  Gia BETWEEN @tugia AND @dengia AND DienTich BETWEEN @tudt AND @dendt AND SoPhong=@sophong
  -----
    END
GO
EXEC [dbo].[searchApartments] 150000,300000,40,60,4
GO
---------- Funtions ----------

---------- Triggers ----------

---------- Write Select, Insert, Update, Delete Alter below!  -----------
