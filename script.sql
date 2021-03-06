USE [master]
GO
/****** Object:  Database [projetSGBD]    Script Date: 18-01-22 11:46:02 ******/
CREATE DATABASE [projetSGBD]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'projetSGBD', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.MSSQLSERVER\MSSQL\DATA\projetSGBD.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'projetSGBD_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.MSSQLSERVER\MSSQL\DATA\projetSGBD_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT
GO
ALTER DATABASE [projetSGBD] SET COMPATIBILITY_LEVEL = 150
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [projetSGBD].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [projetSGBD] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [projetSGBD] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [projetSGBD] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [projetSGBD] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [projetSGBD] SET ARITHABORT OFF 
GO
ALTER DATABASE [projetSGBD] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [projetSGBD] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [projetSGBD] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [projetSGBD] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [projetSGBD] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [projetSGBD] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [projetSGBD] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [projetSGBD] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [projetSGBD] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [projetSGBD] SET  DISABLE_BROKER 
GO
ALTER DATABASE [projetSGBD] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [projetSGBD] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [projetSGBD] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [projetSGBD] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [projetSGBD] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [projetSGBD] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [projetSGBD] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [projetSGBD] SET RECOVERY FULL 
GO
ALTER DATABASE [projetSGBD] SET  MULTI_USER 
GO
ALTER DATABASE [projetSGBD] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [projetSGBD] SET DB_CHAINING OFF 
GO
ALTER DATABASE [projetSGBD] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [projetSGBD] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [projetSGBD] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [projetSGBD] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
EXEC sys.sp_db_vardecimal_storage_format N'projetSGBD', N'ON'
GO
ALTER DATABASE [projetSGBD] SET QUERY_STORE = OFF
GO
USE [projetSGBD]
GO
/****** Object:  Table [dbo].[Association]    Script Date: 18-01-22 11:46:02 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Association](
	[idAssociation] [int] IDENTITY(1,1) NOT NULL,
	[zone] [varchar](50) NOT NULL,
 CONSTRAINT [PK_Association] PRIMARY KEY CLUSTERED 
(
	[idAssociation] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[CentreVaccination]    Script Date: 18-01-22 11:46:02 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[CentreVaccination](
	[idCentreVaccination] [int] IDENTITY(1,1) NOT NULL,
	[Localite] [nvarchar](50) NOT NULL,
	[Adresse] [nvarchar](50) NOT NULL,
	[HeureOuverture] [time](7) NOT NULL,
	[Planning] [nvarchar](50) NOT NULL,
	[idAssociation] [int] NOT NULL,
 CONSTRAINT [PK_CentreVaccination] PRIMARY KEY CLUSTERED 
(
	[idCentreVaccination] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Patient]    Script Date: 18-01-22 11:46:02 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Patient](
	[idPatient] [int] IDENTITY(1,1) NOT NULL,
	[numeroNational] [nvarchar](50) NOT NULL,
	[nomFamille] [nvarchar](50) NOT NULL,
	[Prenom] [nvarchar](50) NOT NULL,
	[dateNaissance] [date] NOT NULL,
	[Pays] [nvarchar](50) NOT NULL,
	[Ville] [nvarchar](50) NOT NULL,
	[Adresse] [nvarchar](50) NOT NULL,
	[idCentreVaccination] [int] NOT NULL,
	[idPlanning] [int] NOT NULL,
	[idAssociation] [int] NOT NULL,
 CONSTRAINT [PK_Patient] PRIMARY KEY CLUSTERED 
(
	[idPatient] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[PatientPlanning]    Script Date: 18-01-22 11:46:02 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PatientPlanning](
	[idPatient] [int] IDENTITY(1,1) NOT NULL,
	[idPlanning] [int] NOT NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Planning]    Script Date: 18-01-22 11:46:02 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Planning](
	[idPlanning] [int] IDENTITY(1,1) NOT NULL,
	[dateRdv] [datetime] NOT NULL,
	[idCentreVaccination] [int] NOT NULL,
 CONSTRAINT [PK_Planning] PRIMARY KEY CLUSTERED 
(
	[idPlanning] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Vaccin]    Script Date: 18-01-22 11:46:02 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Vaccin](
	[idVaccin] [int] IDENTITY(1,1) NOT NULL,
	[nomVaccin] [nvarchar](50) NOT NULL,
	[nbsJoursEntreDoses] [int] NOT NULL,
	[numeroLot] [int] NOT NULL,
	[idCentreVaccination] [int] NOT NULL,
 CONSTRAINT [PK_Vaccin] PRIMARY KEY CLUSTERED 
(
	[idVaccin] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
ALTER TABLE [dbo].[CentreVaccination]  WITH CHECK ADD  CONSTRAINT [FK_CentreVaccination_Association] FOREIGN KEY([idAssociation])
REFERENCES [dbo].[Association] ([idAssociation])
GO
ALTER TABLE [dbo].[CentreVaccination] CHECK CONSTRAINT [FK_CentreVaccination_Association]
GO
ALTER TABLE [dbo].[Patient]  WITH CHECK ADD  CONSTRAINT [FK_Patient_Association] FOREIGN KEY([idAssociation])
REFERENCES [dbo].[Association] ([idAssociation])
GO
ALTER TABLE [dbo].[Patient] CHECK CONSTRAINT [FK_Patient_Association]
GO
ALTER TABLE [dbo].[Patient]  WITH CHECK ADD  CONSTRAINT [FK_Patient_CentreVaccination] FOREIGN KEY([idCentreVaccination])
REFERENCES [dbo].[CentreVaccination] ([idCentreVaccination])
GO
ALTER TABLE [dbo].[Patient] CHECK CONSTRAINT [FK_Patient_CentreVaccination]
GO
ALTER TABLE [dbo].[PatientPlanning]  WITH CHECK ADD  CONSTRAINT [FK_PatientPlanning_Patient] FOREIGN KEY([idPatient])
REFERENCES [dbo].[Patient] ([idPatient])
GO
ALTER TABLE [dbo].[PatientPlanning] CHECK CONSTRAINT [FK_PatientPlanning_Patient]
GO
ALTER TABLE [dbo].[PatientPlanning]  WITH CHECK ADD  CONSTRAINT [FK_PatientPlanning_Planning] FOREIGN KEY([idPlanning])
REFERENCES [dbo].[Planning] ([idPlanning])
GO
ALTER TABLE [dbo].[PatientPlanning] CHECK CONSTRAINT [FK_PatientPlanning_Planning]
GO
ALTER TABLE [dbo].[Planning]  WITH CHECK ADD  CONSTRAINT [FK_Planning_CentreVaccination] FOREIGN KEY([idCentreVaccination])
REFERENCES [dbo].[CentreVaccination] ([idCentreVaccination])
GO
ALTER TABLE [dbo].[Planning] CHECK CONSTRAINT [FK_Planning_CentreVaccination]
GO
ALTER TABLE [dbo].[Vaccin]  WITH CHECK ADD  CONSTRAINT [FK_Vaccin_CentreVaccination] FOREIGN KEY([idCentreVaccination])
REFERENCES [dbo].[CentreVaccination] ([idCentreVaccination])
GO
ALTER TABLE [dbo].[Vaccin] CHECK CONSTRAINT [FK_Vaccin_CentreVaccination]
GO
USE [master]
GO
ALTER DATABASE [projetSGBD] SET  READ_WRITE 
GO
