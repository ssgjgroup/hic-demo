/*
 Navicat Premium Data Transfer

 Source Server         : HDW-50
 Source Server Type    : SQL Server
 Source Server Version : 11006020
 Source Host           : 129.10.8.50\bi:1433
 Source Catalog        : CM_DataCenter
 Source Schema         : dbo

 Target Server Type    : SQL Server
 Target Server Version : 11006020
 File Encoding         : 65001

 Date: 10/12/2018 12:22:00
*/


-- ----------------------------
-- Table structure for MBZ_DATA_ERROR
-- ----------------------------
IF EXISTS (SELECT * FROM sys.all_objects WHERE object_id = OBJECT_ID(N'[dbo].[MBZ_DATA_ERROR]') AND type IN ('U'))
	DROP TABLE [dbo].[MBZ_DATA_ERROR]
GO

CREATE TABLE [dbo].[MBZ_DATA_ERROR] (
  [ID] varchar(36) COLLATE Chinese_PRC_BIN  NOT NULL,
  [CLASS_NAME] varchar(128) COLLATE Chinese_PRC_BIN  NULL,
  [METHOD_NAME] varchar(128) COLLATE Chinese_PRC_BIN  NULL,
  [ARGUMENT_STRING] varchar(max) COLLATE Chinese_PRC_BIN  NULL,
  [ERROR_MESSAGE] varchar(max) COLLATE Chinese_PRC_BIN  NULL,
  [ERROR_TIME] datetime DEFAULT (getdate()) NULL
)
GO

ALTER TABLE [dbo].[MBZ_DATA_ERROR] SET (LOCK_ESCALATION = TABLE)
GO


-- ----------------------------
-- Primary Key structure for table MBZ_DATA_ERROR
-- ----------------------------
ALTER TABLE [dbo].[MBZ_DATA_ERROR] ADD CONSTRAINT [PK__MBZ_DATA__3214EC27BDF5CE23] PRIMARY KEY CLUSTERED ([ID])
WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON)  
ON [PRIMARY]
GO

