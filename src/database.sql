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
  `LICENSE_DATE` DATE NOT NULL,                         /*Дата получения лицензии*/
  `CERTIFICATE_NUMBER` VARCHAR(20) NOT NULL,            /*Номер свидетельства*/
  `CERTIFICATE_DATE` DATE NOT NULL,                     /*Дата получения свидетельства*/
  `ADDRESS` VARCHAR(250) NOT NULL,                      /*Адрес*/
  `ID_FILES` INT(10) NOT NULL,                          /*Файлы для прикрепления(при необходимости)*/
  `ID_EMPLOYES_LIST` INT(10) NOT NULL,                  /*Список сотрудников*/
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `own_type`;
CREATE TABLE `own_type` (
  `ID` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT, 
  `OWN_TYPE` VARCHAR(200) NOT NULL,                      /*Форма собственности*/
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `legal_form`;
CREATE TABLE `legal_form` (
  `ID` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT, 
  `LEGAL_FORM` VARCHAR(200) NOT NULL,                 /*Правовая форма*/
  PRIMARY KEY (`ID`) 
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `form1_files`;
CREATE TABLE `form1_files` (
  `ID` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT, 
  `ID_FORM1` INT(10) NOT NULL,                          /*ид формы*/
  `FILE_NAME` VARCHAR(50) NOT NULL,                     /*имя файла*/
  `FILE_DATE` VARCHAR(50) NOT NULL,                     /*дата загрузки*/
  `FILE_DATA` VARCHAR(50) NOT NULL,                     /*данные*/
  PRIMARY KEY (`ID`) 
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `employes_list`;
CREATE TABLE `employes_list` (
  `ID` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT, 
  `ID_FORM1` VARCHAR(10) NOT NULL,                      /*ид формы*/
  `FIO` VARCHAR(200) NOT NULL,                           /*ФИО*/
  `PHONE_HOME` VARCHAR(50) NOT NULL,                    /*Домашний телефон*/
  `PHONE_MOBILE` VARCHAR(50) NOT NULL,                  /*Мобильный телефон*/
  `PHONE_WORK` VARCHAR(50) NOT NULL,                    /*Рабочий телефон*/
  `HOME_ADDRESS` VARCHAR(200) NOT NULL,                  /*Домашний адрес*/
  `MAIL` VARCHAR(50) NOT NULL,                          /*Почта*/
  `BANK_DETAILS` VARCHAR(200) NOT NULL,                  /*Банковские реквизиты*/
  `POSITION` VARCHAR(200) NOT NULL,                      /*Должность*/
  PRIMARY KEY (`ID`) 
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `ID` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT, 
  `LOGIN` VARCHAR(50) NOT NULL,                         /*логин*/
  `PASSWORD` VARCHAR(50) NOT NULL,                      /*пароль*/
  `ID_ACCESS` VARCHAR(10) NOT NULL,                     /*уровень доступа*/
  `FIO` VARCHAR(200) NOT NULL,                           /*ФИО*/
  `PHONE_NUMBER` VARCHAR(50),                  /*телефон*/
  `EMAIL` VARCHAR(50),                         /*Почта*/
  `CREATE_DATE` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP, /*Дата создания*/
  `LOGIN_DATE` TIMESTAMP NULL DEFAULT '0000-00-00 00:00:00',                    /*Дата подключения*/
  PRIMARY KEY (`ID`) 
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `groups`;
CREATE TABLE `groups` (
  `ID` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT, 
  `PRIVELEGE` VARCHAR(100) NOT NULL,                     /*уровень доступа*/
  `DESCRIPTION` VARCHAR(200) NOT NULL,                   /*описание*/
  PRIMARY KEY (`ID`) 
) ENGINE=InnoDB DEFAULT CHARSET=utf8;




