DROP TABLE IF EXISTS `form1`;
CREATE TABLE `form1` (
  `ID` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT, 
  `ID_OWN_TYPE` INT(10) NOT NULL,                       /*Форма собственности*/
  `ID_LEGAL_FORM` INT(20) NOT NULL,                     /*Правовая форма*/
  `ORG_NAME` VARCHAR(100) NOT NULL,                     /*Название организации*/
  `FIO_HEAD` VARCHAR(100) NOT NULL,                     /*ФИО руководителя*/
  `FAX` VARCHAR(25) NOT NULL,                           /*Факс*/
  `PHONE` VARCHAR(25) NOT NULL,                         /*Телефон*/
  `WEB_PAGE` VARCHAR(100) NOT NULL,                     /*Веб-страница*/
  `LICENSE_NUMBER` VARCHAR(20) NOT NULL,                /*Номер лизенции (уникальный)*/
  `LICENSE_DATE` DATE(20) NOT NULL,                     /*Дата получения лицензии*/
  `CERTIFICATE_NUMBER` VARCHAR(20) NOT NULL,            /*Номер свидетельства*/
  `CERTIFICATE_DATE` DATE(20) NOT NULL,                 /*Дата получения свидетельства*/
  `ADDRESS` VARCHAR(250) NOT NULL,                      /*Адрес*/
  `ID_FILES` INT(10) NOT NULL,                          /*Файлы для прикрепления(при необходимости)*/
  `ID_EMPLOYES_LIST` INT(10) NOT NULL,                  /*Список сотрудников*/
  PRIMARY KEY (`ID`) USING BTREE,
  UNIQUE KEY `UNI_CERTIFICATE_NUMBER` (`CERTIFICATE_NUMBER`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `own_type`;
CREATE TABLE `own_type` (
  `ID` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT, 
  `OWN_TYPE` VARCHAR(100) NOT NULL,                      /*Форма собственности*/
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `legal_form`;
CREATE TABLE `legal_form` (
  `ID` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT, 
  `LEGAL_FORM` VARCHAR(100) NOT NULL,                 /*Правовая форма*/
  PRIMARY KEY (`ID`) USING BTREE  
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `form1_files`;
CREATE TABLE `form1_files` (
  `ID` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT, 
  `ID_FORM1` INT(10) NOT NULL,                          /*ид формы*/
  `FILE_NAME` VARCHAR(20) NOT NULL,                     /*имя файла*/
  `FILE_DATE` VARCHAR(20) NOT NULL,                     /*дата загрузки*/
  `FILE_DATA` VARCHAR(20) NOT NULL,                     /*данные*/
  PRIMARY KEY (`ID`) USING BTREE  
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `employes_list`;
CREATE TABLE `employes_list` (
  `ID` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT, 
  `ID_FORM1` VARCHAR(10) NOT NULL,                      /*ид формы*/
  `FIO` VARCHAR(20) NOT NULL,                           /*ФИО*/
  `PHONE_HOME` VARCHAR(20) NOT NULL,                    /*Домашний телефон*/
  `PHONE_MOBILE` VARCHAR(20) NOT NULL,                  /*Мобильный телефон*/
  `PHONE_WORK` VARCHAR(20) NOT NULL,                    /*Рабочий телефон*/
  `HOME_ADDRESS` VARCHAR(20) NOT NULL,                  /*Домашний адрес*/
  `MAIL` VARCHAR(20) NOT NULL,                          /*Почта*/
  `BANK_DETAILS` VARCHAR(20) NOT NULL,                  /*Банковские реквизиты*/
  `POSITION` VARCHAR(20) NOT NULL,                      /*Должность*/
  PRIMARY KEY (`ID`) USING BTREE  
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `ID` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT, 
  `LOGIN` VARCHAR(10) NOT NULL,                         /*логин*/
  `ID_ACCESS` VARCHAR(10) NOT NULL,                     /*уровень доступа*/
  `FIO` VARCHAR(20) NOT NULL,                           /*ФИО*/
  `PHONE_NUMBER` VARCHAR(20),                  /*телефон*/
  `EMAIL` VARCHAR(20),                         /*Почта*/
  `CREATE_DATE` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP, /*Дата создания*/
  `LOGIN_DATE` TIMESTAMP,                    /*Дата подключения*/
  PRIMARY KEY (`ID`) USING BTREE  
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `access`;
CREATE TABLE `access` (
  `ID` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT, 
  `PRIVELEGE` VARCHAR(10) NOT NULL,                     /*уровень доступа*/
  `DESCRIPTION` VARCHAR(10) NOT NULL,                   /*описание*/
  PRIMARY KEY (`ID`) USING BTREE  
) ENGINE=InnoDB DEFAULT CHARSET=utf8;




