CREATE TABLE `users` (
	`id` bigint(20) NOT NULL,
	`username` varchar(255) NOT NULL DEFAULT '',
	`password` varchar(255) DEFAULT NULL COMMENT 'it is used if account create by username/password',
	`name` varchar(255) DEFAULT NULL COMMENT 'firstname and lastname',
	`token` varchar(255) DEFAULT NULL COMMENT 'auth token',
	`created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
	PRIMARY KEY (`id`),
	INDEX `findByUserName` (`username`, `password`) comment ''
) COMMENT='';
