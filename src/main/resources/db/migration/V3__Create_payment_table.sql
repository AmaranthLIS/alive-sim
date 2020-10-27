CREATE TABLE `card_payments`
(
    `id`         bigint(20)                                               NOT NULL,
    `user_id`    bigint(20) UNSIGNED                                      NOT NULL                             DEFAULT 0,
    `card_id`    bigint(20) UNSIGNED                                      NOT NULL                             DEFAULT 0,
    `amount`     decimal(16, 2)                                           NOT NULL                             DEFAULT 0.00,
    `status`     enum ('PENDING','PROGRESS','SUCCESS','FAIL','CANCEL','') NOT NULL                             DEFAULT 'PENDING',
    `created_at` datetime                                                 NOT NULL ON UPDATE CURRENT_TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    `desc`       varchar(512)                                                                                  DEFAULT NULL  COMMENT 'description of transaction, it could be a reason of status',
    PRIMARY KEY (`id`),
    INDEX `findByUserCard` (`user_id`, `card_id`, `created_at`) comment ''
) COMMENT ='';
