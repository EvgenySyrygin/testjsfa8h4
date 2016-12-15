DROP TABLE IF EXISTS `form1_files`;
DROP TABLE IF EXISTS `employes_list`;
DROP TABLE IF EXISTS `form1`;
DROP TABLE IF EXISTS `own_type`;
DROP TABLE IF EXISTS `legal_form`;
DROP TABLE IF EXISTS `users`;
DROP TABLE IF EXISTS `groups`;

CREATE TABLE `own_type` (
  `ID` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT, 
  `OWN_TYPE` VARCHAR(200) NOT NULL,                      /*Форма собственности*/
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

CREATE TABLE `legal_form` (
  `ID` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT, 
  `LEGAL_FORM` VARCHAR(200) NOT NULL,                 /*Правовая форма*/
  PRIMARY KEY (`ID`) 
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

CREATE TABLE `form1` (
  `ID` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT, 
  `ID_OWN_TYPE` INT(10) UNSIGNED NOT NULL,              /*Форма собственности*/
  `ID_LEGAL_FORM` INT(10) UNSIGNED NOT NULL,            /*Правовая форма*/
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
  `ID_FILES` INT(10) UNSIGNED NOT NULL,                 /*Файлы для прикрепления(при необходимости)*/
  `ID_EMPLOYES_LIST` INT(10) UNSIGNED NOT NULL,         /*Список сотрудников*/
  PRIMARY KEY (`ID`),
	INDEX `FK_form1_own_type` (`ID_OWN_TYPE`),
	INDEX `FK_form1_legal_form` (`ID_LEGAL_FORM`),
	CONSTRAINT `FK_form1_legal_form` FOREIGN KEY (`ID_LEGAL_FORM`) REFERENCES `legal_form` (`ID`),
	CONSTRAINT `FK_form1_own_type` FOREIGN KEY (`ID_OWN_TYPE`) REFERENCES `own_type` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

CREATE TABLE `form1_files` (
  `ID` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT, 
  `ID_FORM1` INT(10) UNSIGNED NOT NULL,                 /*ид формы*/
  `FILE_NAME` VARCHAR(50) NOT NULL,                     /*имя файла*/
  `FILE_DATE` VARCHAR(50) NOT NULL,                     /*дата загрузки*/
  `FILE_DATA` BLOB NOT NULL,                            /*данные*/
  PRIMARY KEY (`ID`),
	INDEX `FK_form1_files_form1` (`ID_FORM1`),
	CONSTRAINT `FK_form1_files_form1` FOREIGN KEY (`ID_FORM1`) REFERENCES `form1` (`ID`) 
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

CREATE TABLE `employes_list` (
  `ID` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT, 
  `ID_FORM1` INT(10) UNSIGNED NOT NULL,                 /*ид формы*/
  `FIO` VARCHAR(200) NOT NULL,                          /*ФИО*/
  `PHONE_HOME` VARCHAR(50) NOT NULL,                    /*Домашний телефон*/
  `PHONE_MOBILE` VARCHAR(50) NOT NULL,                  /*Мобильный телефон*/
  `PHONE_WORK` VARCHAR(50) NOT NULL,                    /*Рабочий телефон*/
  `HOME_ADDRESS` VARCHAR(200) NOT NULL,                 /*Домашний адрес*/
  `MAIL` VARCHAR(50) NOT NULL,                          /*Почта*/
  `BANK_DETAILS` VARCHAR(200) NOT NULL,                 /*Банковские реквизиты*/
  `POSITION` VARCHAR(200) NOT NULL,                     /*Должность*/
  PRIMARY KEY (`ID`),
	INDEX `FK_employes_list_form1` (`ID_FORM1`),
	CONSTRAINT `FK_employes_list_form1` FOREIGN KEY (`ID_FORM1`) REFERENCES `form1` (`ID`) 
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

CREATE TABLE `groups` (
  `ID_ACCESS` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT, 
  `PRIVELEGE` VARCHAR(100) NOT NULL,                     /*уровень доступа*/
  `DESCRIPTION` VARCHAR(200) NOT NULL,                   /*описание*/
  PRIMARY KEY (`ID_ACCESS`) 
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

CREATE TABLE `users` (
  `ID` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT, 
  `LOGIN` VARCHAR(50) NOT NULL,                         /*логин*/
  `PASSWORD` VARCHAR(50) NOT NULL,                      /*пароль*/
  `ID_ACCESS` INT(10) UNSIGNED NOT NULL,                /*уровень доступа*/
  `FIO` VARCHAR(200) NOT NULL,                          /*ФИО*/
  `PHONE_NUMBER` VARCHAR(50),                           /*телефон*/
  `EMAIL` VARCHAR(50),                                  /*Почта*/
  `CREATE_DATE` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP, /*Дата создания*/
  `LOGIN_DATE` TIMESTAMP NULL DEFAULT '0000-00-00 00:00:00',                    /*Дата подключения*/
  PRIMARY KEY (`ID`) ,
	INDEX `FK_users_groups` (`ID_ACCESS`),
	CONSTRAINT `FK_users_groups` FOREIGN KEY (`ID_ACCESS`) REFERENCES `groups` (`ID_ACCESS`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

INSERT INTO `own_type` (`ID`, `OWN_TYPE`) VALUES
	(1, 'Индивидуальная'),
	(2, 'Частная'),
	(3, 'Государственная');

INSERT INTO `legal_form` (`ID`, `LEGAL_FORM`) VALUES
	(1, 'Учредительная'),
	(2, 'Правотворческая'),
	(3, 'Правоприменительная'),
	(4, 'Контрольная');

INSERT INTO `groups` (`ID_ACCESS`, `PRIVELEGE`, `DESCRIPTION`) VALUES
	(1, 'Админ', 'Полный доступ'),
	(2, 'Пользователь', 'Ограниченый доступ');

INSERT INTO `users` (`ID`, `LOGIN`, `PASSWORD`, `ID_ACCESS`, `FIO`, `PHONE_NUMBER`, `EMAIL`, `CREATE_DATE`, `LOGIN_DATE`) VALUES
	(1, 'admin', 'admin', 1, 'System Admin', '777777777', '777@77.kg', '2016-12-15 11:31:51', NULL),
	(2, 'user', 'user', 2, 'System user', '000000', '00000@000.kg', '2016-12-15 12:03:19', NULL);