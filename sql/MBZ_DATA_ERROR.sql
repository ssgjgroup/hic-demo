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

 Date: 08/12/2018 16:14:40
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
  [ERROR_MESSAGE] varchar(max) COLLATE Chinese_PRC_BIN  NULL,
  [ERROR_TIME] datetime DEFAULT (getdate()) NULL
)
GO

ALTER TABLE [dbo].[MBZ_DATA_ERROR] SET (LOCK_ESCALATION = TABLE)
GO

