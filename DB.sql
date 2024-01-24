DROP DATABASE IF EXISTS `JSP_AM`;
CREATE DATABASE `JSP_AM`;
USE `JSP_AM`;

CREATE TABLE article(
    id INT(10) UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
    regDate DATETIME NOT NULL,
    title CHAR(100) NOT NULL,
    `body` TEXT NOT NULL
);

CREATE TABLE `member`(
    id INT(10) UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
    regDate DATETIME NOT NULL,
    loginId CHAR(100) NOT NULL,
    loginPw CHAR(100) NOT NULL,
    `name` CHAR(100) NOT NULL 
);

ALTER TABLE `member` MODIFY COLUMN loginId CHAR(100) UNIQUE;

INSERT INTO article
SET regDate = NOW(),
title = '제목1',
`body` = '내용1';

INSERT INTO article
SET regDate = NOW(),
title = '제목2',
`body` = '내용2';

INSERT INTO article
SET regDate = NOW(),
title = '제목3',
`body` = '내용3';

INSERT INTO `member`
SET regDate = NOW(),
loginId = 'admin',
loginPw = 'admin',
`name` = '관리자'; 

INSERT INTO `member`
SET regDate = NOW(),
loginId = '아이디1',
loginPw = '비번1',
`name` = '이름__';

INSERT INTO `member`
SET regDate = NOW(),
loginId = '아이디2',
loginPw = '비번2',
`name` = '이름__';


INSERT INTO article 
SET regDate = NOW(),
title = CONCAT('제목__', RAND()),
`body` = CONCAT('제목__', RAND());


SELECT *
FROM article
ORDER BY id DESC;

SELECT *
FROM `member`
ORDER BY id DESC;




