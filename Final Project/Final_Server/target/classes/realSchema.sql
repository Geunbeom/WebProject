DROP DATABASE IF EXISTS `final`;

CREATE DATABASE IF NOT EXISTS `final`;
USE `final`;

CREATE TABLE `users`(
	id VARCHAR(10) NOT NULL PRIMARY KEY,
	password VARCHAR(10) NOT NULL,
	email VARCHAR(40) NOT NULL,
	name VARCHAR(10) NOT NULL,
	nick_name VARCHAR(10) NOT NULL,
	born_date DATE NOT NULL
);

CREATE TABLE `user_info`(
	id VARCHAR(10) NOT NULL PRIMARY KEY,
	mileage INT NOT NULL,
    exp INT NOT NULL,
    rate int NOT NULL,
    highscore INT,
	CONSTRAINT `info_fk` FOREIGN KEY (`id`) REFERENCES `users` (`id`) ON DELETE CASCADE
);

create table `freeboard`(
	`id` INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    `title` VARCHAR(100) NOT NULL,
    `writer` VARCHAR(100) NOT NULL,
    `content` VARCHAR(1000) NOT NULL,
    `view_cnt` INT NOT NULL,
    `reg_date` DATE NOT NULL
);

create table `freeboardreply`(
    `reply_id` INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    `board_id` INT NOT NULL,
    `writer` VARCHAR(100) NOT NULL,
    `content` VARCHAR(500) NOT NULL, 
    `reg_date` DATE NOT NULL,
    CONSTRAINT `reply_fk` FOREIGN KEY (`board_id`) REFERENCES `freeboard` (`id`) ON DELETE CASCADE
);

create table `routine`(
    `id` INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    `part` VARCHAR(100) NOT NULL,
    `detail` VARCHAR(100) NOT NULL,
    `sets` INT,
    `count` INT
);

create table `routineboard`(
    `id` INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    `routine_id` INT NOT NULL,
    `title` VARCHAR(100) NOT NULL,
    `writer` VARCHAR(100) NOT NULL,
    `content` VARCHAR(1000) NOT NULL,
    `view_cnt` INT NOT NULL,
    `reg_date` DATE NOT NULL,
    `like` INT NOT NULL,
    CONSTRAINT `routine_fk` FOREIGN KEY (`routine_id`) REFERENCES `routine` (`id`) ON DELETE CASCADE
);

create table `routineboardreply`(
    `reply_id` INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    `board_id` INT NOT NULL,
    `writer` VARCHAR(100) NOT NULL,
    `content` VARCHAR(500) NOT NULL, 
    `reg_date` DATE NOT NULL,
    CONSTRAINT `routinereply_fk` FOREIGN KEY (`board_id`) REFERENCES `routineboard` (`id`) ON DELETE CASCADE
);

CREATE TABLE `likeBoard` (
	`id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	`user_id` VARCHAR(10) NOT NULL,
    `board_id` INT NOT NULL,
    CONSTRAINT `like_fk1` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE CASCADE,
    CONSTRAINT `like_fk2` FOREIGN KEY (`board_id`) REFERENCES `routineboard` (`id`) ON DELETE CASCADE
);

CREATE TABLE `myRoutine` (
	`user_id` VARCHAR(10) NOT NULL,
    `routine_id` INT NOT NULL,
    `reg_date` DATE NOT NULL,
    `attend` INT NOT NULL,
    CONSTRAINT `attend_fk1` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE CASCADE,
    CONSTRAINT `attend_fk2` FOREIGN KEY (`routine_id`) REFERENCES `routine` (`id`) ON DELETE CASCADE
);

# 임시 user 등록
INSERT INTO `users`
VALUES('admin', '1234', 'ssafy@ssafy.com', '관리자', '관리자', '2000-01-01');
INSERT INTO `users`
VALUES('ssafy', '1234', 'ssafy@ssafy.com', '김싸피', 'KimS', '1997-01-01');
INSERT INTO `users`
VALUES('ssafy2', '1234', 'ssafy2@ssafy.com', '서싸피', 'SeoS', '1997-06-17');
INSERT INTO `users`
VALUES('ssafy3', '1234', 'ssafy2@ssafy.com', '이싸피', 'LeeS', '2000-11-23');
INSERT INTO `users`
VALUES('ssafy4', '1234', 'ssafy2@ssafy.com', '박싸피', 'ParkS', '1998-03-27');
INSERT INTO `users`
VALUES('ssafy5', '1234', 'ssafy2@ssafy.com', '최싸피', 'ChoiS', '1999-08-24');

# 임시 user-info 등록
INSERT INTO `user_info`
VALUES('ssafy', 100000, 11900, 3, 74);
INSERT INTO `user_info`
VALUES('ssafy2', 27800, 9500, 3, 21);
INSERT INTO `user_info`
VALUES('ssafy3', 9300, 6200, 2, 12);
INSERT INTO `user_info`
VALUES('ssafy4', 1500, 1200, 1, 5);
INSERT INTO `user_info`
VALUES('ssafy5', 0, 100, 0, 0);


INSERT INTO `freeboard` (`id`, `title`, `writer`, `content`, `view_cnt`, `reg_date`)
VALUES(0, "첫 글", "KimS", "첫 글 등록ㅋㅋ", 177, '2024-05-10');
INSERT INTO `freeboard` (`id`, `title`, `writer`, `content`, `view_cnt`, `reg_date`)
VALUES(0, "안녕하세요", "SeoS", "도움 많이 되고 있어요!", 53, '2024-05-15');
INSERT INTO `freeboard` (`id`, `title`, `writer`, `content`, `view_cnt`, `reg_date`)
VALUES(0, "헬린이 키우기 어렵네", "LeeS", "이제 곧 플레임 ㅠㅠ", 42, '2024-05-16');
INSERT INTO `freeboard` (`id`, `title`, `writer`, `content`, `view_cnt`, `reg_date`)
VALUES(0, "곧 다이아다", "KimS", "먼저 다이아 갑니다~", 243, '2024-05-23');
INSERT INTO `freeboard` (`id`, `title`, `writer`, `content`, `view_cnt`, `reg_date`)
VALUES(0, "뉴비 입니다.", "ChoiS", "오늘 가입했어요 잘 부탁드립니다!", 3, '2024-05-24');


INSERT INTO `freeboardreply` (`reply_id`, `board_id`, `writer`, `content`, `reg_date`)
VALUES(0, 1, "SeoS", "1빠", '2024-05-10');
INSERT INTO `freeboardreply` (`reply_id`, `board_id`, `writer`, `content`, `reg_date`)
VALUES(0, 1, "LeeS", "2빠", '2024-05-10');
INSERT INTO `freeboardreply` (`reply_id`, `board_id`, `writer`, `content`, `reg_date`)
VALUES(0, 2, "KimS", "안녕하세요~", '2024-05-15');
INSERT INTO `freeboardreply` (`reply_id`, `board_id`, `writer`, `content`, `reg_date`)
VALUES(0, 3, "KimS", "화이팅 ㅋㅋ", '2024-05-16');
INSERT INTO `freeboardreply` (`reply_id`, `board_id`, `writer`, `content`, `reg_date`)
VALUES(0, 4, "SeoS", "오 축하합니다~", '2024-05-23');
INSERT INTO `freeboardreply` (`reply_id`, `board_id`, `writer`, `content`, `reg_date`)
VALUES(0, 4, "ParkS", "부럽..", '2024-05-23');

INSERT INTO `routine`
VALUES(0, "어깨", "벤치프레스", 4, 10);
INSERT INTO `routine`
VALUES(0, "팔", "레그프레스", 4, 15);
INSERT INTO `routine`
VALUES(0, "전완근", "레그프레스", 4, 15);
INSERT INTO `routine`
VALUES(0, "가슴", "레그프레스", 4, 15);
INSERT INTO `routine`
VALUES(0, "등", "레그프레스", 4, 15);
INSERT INTO `routine`
VALUES(0, "복근", "레그프레스", 4, 15);
INSERT INTO `routine`
VALUES(0, "하체", "레그프레스", 4, 15);


INSERT INTO `routineboard` (`id`, `routine_id`, `title`, `writer`, `content`, `view_cnt`, `reg_date`, `like`)
VALUES(0, 1, "어깨 운동 참조", "관리자", "GPT 프롬프트를 이용해 받아온 자료입니다. 초보 분들 참고하세요.", 53, '2024-05-10', 0);
INSERT INTO `routineboard` (`id`, `routine_id`, `title`, `writer`, `content`, `view_cnt`, `reg_date`, `like`)
VALUES(0, 2, "팔 운동 참조", "관리자", "GPT 프롬프트를 이용해 받아온 자료입니다. 초보 분들 참고하세요.", 67, '2024-05-10', 0);
INSERT INTO `routineboard` (`id`, `routine_id`, `title`, `writer`, `content`, `view_cnt`, `reg_date`, `like`)
VALUES(0, 3, "전완근 운동 참조", "관리자", "GPT 프롬프트를 이용해 받아온 자료입니다. 초보 분들 참고하세요.", 53, '2024-05-10', 0);
INSERT INTO `routineboard` (`id`, `routine_id`, `title`, `writer`, `content`, `view_cnt`, `reg_date`, `like`)
VALUES(0, 4, "가슴 운동 참조", "관리자", "GPT 프롬프트를 이용해 받아온 자료입니다. 초보 분들 참고하세요.", 42, '2024-05-10', 0);
INSERT INTO `routineboard` (`id`, `routine_id`, `title`, `writer`, `content`, `view_cnt`, `reg_date`, `like`)
VALUES(0, 5, "등 운동 참조", "관리자", "GPT 프롬프트를 이용해 받아온 자료입니다. 초보 분들 참고하세요.", 85, '2024-05-10', 0);
INSERT INTO `routineboard` (`id`, `routine_id`, `title`, `writer`, `content`, `view_cnt`, `reg_date`, `like`)
VALUES(0, 6, "복근 운동 참조", "관리자", "GPT 프롬프트를 이용해 받아온 자료입니다. 초보 분들 참고하세요.", 32, '2024-05-10', 0);
INSERT INTO `routineboard` (`id`, `routine_id`, `title`, `writer`, `content`, `view_cnt`, `reg_date`, `like`)
VALUES(0, 7, "하체 운동 참조", "관리자", "GPT 프롬프트를 이용해 받아온 자료입니다. 초보 분들 참고하세요.", 16, '2024-05-10', 0);


INSERT INTO `routineboardreply` (`reply_id`, `board_id`, `writer`, `content`, `reg_date`)
VALUES(0, 1, "KimS", "감사합니다", '2024-05-10');
INSERT INTO `routineboardreply` (`reply_id`, `board_id`, `writer`, `content`, `reg_date`)
VALUES(0, 1, "SeoS", "감사합니다", '2024-05-11');
INSERT INTO `routineboardreply` (`reply_id`, `board_id`, `writer`, `content`, `reg_date`)
VALUES(0, 2, "KimS", "감사합니다", '2024-05-10');
INSERT INTO `routineboardreply` (`reply_id`, `board_id`, `writer`, `content`, `reg_date`)
VALUES(0, 2, "SeoS", "감사합니다", '2024-05-11');
INSERT INTO `routineboardreply` (`reply_id`, `board_id`, `writer`, `content`, `reg_date`)
VALUES(0, 4, "KimS", "감사합니다", '2024-05-10');
INSERT INTO `routineboardreply` (`reply_id`, `board_id`, `writer`, `content`, `reg_date`)
VALUES(0, 4, "SeoS", "감사합니다", '2024-05-11');
INSERT INTO `routineboardreply` (`reply_id`, `board_id`, `writer`, `content`, `reg_date`)
VALUES(0, 5, "KimS", "감사합니다", '2024-05-10');
INSERT INTO `routineboardreply` (`reply_id`, `board_id`, `writer`, `content`, `reg_date`)
VALUES(0, 5, "SeoS", "감사합니다", '2024-05-11');
INSERT INTO `routineboardreply` (`reply_id`, `board_id`, `writer`, `content`, `reg_date`)
VALUES(0, 7, "KimS", "감사합니다", '2024-05-10');
INSERT INTO `routineboardreply` (`reply_id`, `board_id`, `writer`, `content`, `reg_date`)
VALUES(0, 7, "SeoS", "감사합니다", '2024-05-11');


INSERT INTO `myRoutine`
VALUES ('ssafy', 1, '2024-05-13', 0);
INSERT INTO `myRoutine`
VALUES ('ssafy', 2, '2024-05-14', 0);
INSERT INTO `myRoutine`
VALUES ('ssafy', 3, '2024-05-15', 0);
INSERT INTO `myRoutine`
VALUES ('ssafy', 4, '2024-05-16', 0);
INSERT INTO `myRoutine`
VALUES ('ssafy', 5, '2024-05-17', 0);
INSERT INTO `myRoutine`
VALUES ('ssafy', 6, '2024-05-18', 0);
INSERT INTO `myRoutine`
VALUES ('ssafy', 7, '2024-05-19', 0);
INSERT INTO `myRoutine`
VALUES ('ssafy', 6, '2024-05-20', 0);
INSERT INTO `myRoutine`
VALUES ('ssafy', 3, '2024-05-21', 0);
INSERT INTO `myRoutine`
VALUES ('ssafy', 1, '2024-05-22', 0);
INSERT INTO `myRoutine`
VALUES ('ssafy', 2, '2024-05-23', 0);

INSERT INTO `myRoutine`
VALUES ('ssafy', 1, '2024-05-13', 1);
INSERT INTO `myRoutine`
VALUES ('ssafy', 2, '2024-05-14', 1);
INSERT INTO `myRoutine`
VALUES ('ssafy', 3, '2024-05-15', 1);
INSERT INTO `myRoutine`
VALUES ('ssafy', 4, '2024-05-16', 1);
INSERT INTO `myRoutine`
VALUES ('ssafy', 5, '2024-05-17', 1);
INSERT INTO `myRoutine`
VALUES ('ssafy', 6, '2024-05-18', 1);
INSERT INTO `myRoutine`
VALUES ('ssafy', 7, '2024-05-19', 1);

INSERT INTO `myRoutine`
VALUES ('ssafy2', 3, '2024-05-15', 0);
INSERT INTO `myRoutine`
VALUES ('ssafy2', 4, '2024-05-16', 0);
INSERT INTO `myRoutine`
VALUES ('ssafy2', 5, '2024-05-17', 0);
INSERT INTO `myRoutine`
VALUES ('ssafy2', 6, '2024-05-18', 0);
INSERT INTO `myRoutine`
VALUES ('ssafy2', 6, '2024-05-20', 0);
INSERT INTO `myRoutine`
VALUES ('ssafy2', 3, '2024-05-21', 0);
INSERT INTO `myRoutine`
VALUES ('ssafy2', 2, '2024-05-23', 0);

INSERT INTO `myRoutine`
VALUES ('ssafy2', 1, '2024-05-13', 1);
INSERT INTO `myRoutine`
VALUES ('ssafy2', 2, '2024-05-14', 1);
INSERT INTO `myRoutine`
VALUES ('ssafy2', 3, '2024-05-15', 1);
INSERT INTO `myRoutine`
VALUES ('ssafy2', 4, '2024-05-16', 1);
INSERT INTO `myRoutine`
VALUES ('ssafy2', 5, '2024-05-17', 1);
INSERT INTO `myRoutine`
VALUES ('ssafy2', 6, '2024-05-18', 1);
INSERT INTO `myRoutine`
VALUES ('ssafy2', 7, '2024-05-19', 1);


INSERT INTO `myRoutine`
VALUES ('ssafy3', 6, '2024-05-20', 0);
INSERT INTO `myRoutine`
VALUES ('ssafy3', 2, '2024-05-23', 0);

INSERT INTO `myRoutine`
VALUES ('ssafy3', 1, '2024-05-20', 1);
INSERT INTO `myRoutine`
VALUES ('ssafy3', 2, '2024-05-20', 1);
INSERT INTO `myRoutine`
VALUES ('ssafy3', 3, '2024-05-20', 1);

INSERT INTO `myRoutine`
VALUES ('ssafy4', 2, '2024-05-22', 0);
INSERT INTO `myRoutine`
VALUES ('ssafy4', 2, '2024-05-22', 1);


INSERT INTO `myRoutine`
VALUES ('ssafy5', 1, '2024-05-23', 0);
INSERT INTO `myRoutine`
VALUES ('ssafy5', 1, '2024-05-23', 1);

