CREATE TABLE `cards` (
	`id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT,
	`user_id` bigint(20) UNSIGNED NOT NULL DEFAULT 0,
	`title` varchar(255) NOT NULL DEFAULT '',
	`country` varchar(255) NOT NULL DEFAULT '',
	`operator` varchar(255) NOT NULL DEFAULT '',
	`expire` int(12) UNSIGNED NOT NULL DEFAULT 0,
	`created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
	PRIMARY KEY (`id`),
	INDEX `find_expire` USING BTREE (`user_id`, `expire`) comment ''
) COMMENT='';
