/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     13/12/2017 8:08:47                           */
/*==============================================================*/


drop table if exists ACTIVIDAD;

drop table if exists ALARMA;

drop table if exists COSECHA;

drop table if exists ESTACION;

drop table if exists ESTADISTICA;

drop table if exists HISTORIAL_ESTACION;

drop table if exists MES;

drop table if exists REGION;

drop table if exists TERRENO;

drop table if exists TIPO_ACTIVIDAD;

drop table if exists TIPO_TERRENO;

drop table if exists TIPO_USUARIO;

drop table if exists USUARIO;

/*==============================================================*/
/* Table: ACTIVIDAD                                             */
/*==============================================================*/
create table ACTIVIDAD
(
   COD_ACTIVIDAD        int not null auto_increment,
   COD_TIPO_ACTIVIDAD   varchar(10) not null,
   COD_COSECHA          int,
   NOTA                 varchar(512),
   FECHA_ULTIMA_EJECUCION date not null,
   ESTADO               varchar(3) not null,
   primary key (COD_ACTIVIDAD, COD_TIPO_ACTIVIDAD)
);

/*==============================================================*/
/* Table: ALARMA                                                */
/*==============================================================*/
create table ALARMA
(
   COD_ALARMA           int not null auto_increment,
   COD_ACTIVIDAD        int,
   COD_TIPO_ACTIVIDAD   varchar(10),
   DESCRIPCION          varchar(512),
   primary key (COD_ALARMA)
);

/*==============================================================*/
/* Table: COSECHA                                               */
/*==============================================================*/
create table COSECHA
(
   COD_COSECHA          int not null auto_increment,
   COD_TERRENO          int not null,
   COD_TIPO_TERRENO     varchar(10) not null,
   FECHA_PLANTACION     date not null,
   primary key (COD_COSECHA)
);

/*==============================================================*/
/* Table: ESTACION                                              */
/*==============================================================*/
create table ESTACION
(
   COD_ESTACION         varchar(10) not null,
   COD_MES              int not null,
   NOMBRE               varchar(100) not null,
   DESCRIPCION          varchar(512),
   primary key (COD_ESTACION, COD_MES)
);

/*==============================================================*/
/* Table: ESTADISTICA                                           */
/*==============================================================*/
create table ESTADISTICA
(
   COD_ESTADISTICA      int not null auto_increment,
   COD_COSECHA          int,
   FECHA_ULTIMA_COSECHA date not null,
   NUMERO_ARBOLES       numeric(5,0) not null,
   TOTAL_KILOS          numeric(8,2) not null,
   primary key (COD_ESTADISTICA)
);

/*==============================================================*/
/* Table: HISTORIAL_ESTACION                                    */
/*==============================================================*/
create table HISTORIAL_ESTACION
(
   COD_HISTORIAL_ESTACION int not null auto_increment,
   COD_ESTACION         varchar(10),
   COD_MES              int,
   ANIO                 date not null,
   FECHA_INICIO         date not null,
   FECHA_FINALIZACION   date not null,
   NOTA                 varchar(512),
   primary key (COD_HISTORIAL_ESTACION)
);

/*==============================================================*/
/* Table: MES                                                   */
/*==============================================================*/
create table MES
(
   COD_MES              int not null auto_increment,
   NOMBRE               varchar(100) not null,
   primary key (COD_MES)
);

/*==============================================================*/
/* Table: REGION                                                */
/*==============================================================*/
create table REGION
(
   COD_REGION           varchar(10) not null,
   COD_ESTACION         varchar(10),
   COD_MES              int,
   NOMBRE               varchar(100) not null,
   primary key (COD_REGION)
);

/*==============================================================*/
/* Table: TERRENO                                               */
/*==============================================================*/
create table TERRENO
(
   COD_TERRENO          int not null auto_increment,
   COD_TIPO_TERRENO     varchar(10) not null,
   COD_REGION           varchar(10) not null,
   DESCRIPCION          varchar(512),
   ANCHO                numeric(8,2) not null,
   LARGO                numeric(8,2) not null,
   primary key (COD_TERRENO, COD_TIPO_TERRENO)
);

/*==============================================================*/
/* Table: TIPO_ACTIVIDAD                                        */
/*==============================================================*/
create table TIPO_ACTIVIDAD
(
   COD_TIPO_ACTIVIDAD   varchar(10) not null,
   NOMBRE               varchar(100) not null,
   DESCRIPCION          varchar(512),
   primary key (COD_TIPO_ACTIVIDAD)
);

/*==============================================================*/
/* Table: TIPO_TERRENO                                          */
/*==============================================================*/
create table TIPO_TERRENO
(
   COD_TIPO_TERRENO     varchar(10) not null,
   NOMBRE               varchar(100) not null,
   DESCRIPCION          varchar(512) not null,
   primary key (COD_TIPO_TERRENO)
);

/*==============================================================*/
/* Table: TIPO_USUARIO                                          */
/*==============================================================*/
create table TIPO_USUARIO
(
   COD_TIPO_USUARIO     int not null auto_increment,
   TIPO                 varchar(3) not null,
   DESCRIPCION          varchar(512) not null,
   primary key (COD_TIPO_USUARIO)
);

/*==============================================================*/
/* Table: USUARIO                                               */
/*==============================================================*/
create table USUARIO
(
   COD_USUARIO          int not null auto_increment,
   COD_TIPO_USUARIO     int,
   NOMBRE               varchar(100) not null,
   APELLIDO             varchar(100) not null,
   PASSWORD             varchar(512) not null,
   TELEFONO             varchar(14) not null,
   EMAIL                varchar(256) not null,
   primary key (COD_USUARIO)
);

alter table ACTIVIDAD add constraint FK_REFERENCE_13 foreign key (COD_COSECHA)
      references COSECHA (COD_COSECHA) on delete restrict on update restrict;

alter table ACTIVIDAD add constraint FK_REFERENCE_4 foreign key (COD_TIPO_ACTIVIDAD)
      references TIPO_ACTIVIDAD (COD_TIPO_ACTIVIDAD) on delete restrict on update restrict;

alter table ALARMA add constraint FK_REFERENCE_15 foreign key (COD_ACTIVIDAD, COD_TIPO_ACTIVIDAD)
      references ACTIVIDAD (COD_ACTIVIDAD, COD_TIPO_ACTIVIDAD) on delete restrict on update restrict;

alter table COSECHA add constraint FK_REFERENCE_14 foreign key (COD_TERRENO, COD_TIPO_TERRENO)
      references TERRENO (COD_TERRENO, COD_TIPO_TERRENO) on delete restrict on update restrict;

alter table ESTACION add constraint FK_REFERENCE_9 foreign key (COD_MES)
      references MES (COD_MES) on delete restrict on update restrict;

alter table ESTADISTICA add constraint FK_REFERENCE_3 foreign key (COD_COSECHA)
      references COSECHA (COD_COSECHA) on delete restrict on update restrict;

alter table HISTORIAL_ESTACION add constraint FK_REFERENCE_10 foreign key (COD_ESTACION, COD_MES)
      references ESTACION (COD_ESTACION, COD_MES) on delete restrict on update restrict;

alter table REGION add constraint FK_REFERENCE_12 foreign key (COD_ESTACION, COD_MES)
      references ESTACION (COD_ESTACION, COD_MES) on delete restrict on update restrict;

alter table TERRENO add constraint FK_REFERENCE_5 foreign key (COD_TIPO_TERRENO)
      references TIPO_TERRENO (COD_TIPO_TERRENO) on delete restrict on update restrict;

alter table TERRENO add constraint FK_REFERENCE_7 foreign key (COD_REGION)
      references REGION (COD_REGION) on delete restrict on update restrict;

alter table USUARIO add constraint FK_REFERENCE_11 foreign key (COD_TIPO_USUARIO)
      references TIPO_USUARIO (COD_TIPO_USUARIO) on delete restrict on update restrict;

