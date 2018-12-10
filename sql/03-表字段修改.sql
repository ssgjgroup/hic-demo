alter table ANMR_ZYBCJL_SQTL alter column  ssyd varchar(max) not null  ;

--24H 出入院记录修改
alter table ANMR_RYJL_RCYJL alter column rzzybmmc  varchar(1000) not null ;
alter table ANMR_RYJL_RCYJL alter column rzzybmdm  varchar(500) not null ;
alter table ANMR_RYJL_RCYJL alter column czzybmmc  varchar(1000) not null ;
alter table ANMR_RYJL_RCYJL alter column czzybmdm  varchar(500) not null ;
alter table ANMR_RYJL_RCYJL alter column czzyzhmc  varchar(1000) not null ;
alter table ANMR_RYJL_RCYJL alter column czzyzhdm  varchar(500) not null ;