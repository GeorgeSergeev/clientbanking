DROP TABLE IF EXISTS `roles`;
CREATE TABLE IF NOT EXISTS `roles` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(128) DEFAULT NULL,  
  PRIMARY KEY (`id`),
  UNIQUE KEY `role_name` (`role_name`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;


INSERT INTO `roles` (`role_name`) VALUES
('ROLE_CLIENT'),('ROLE_EMPLOEE'),('ROLE_ADMIN');

-- --------------------------------------------------------

DROP TABLE IF EXISTS `users`;
CREATE TABLE IF NOT EXISTS `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(200) NOT NULL,
  `login` varchar(200) NOT NULL,
  `password` varchar(64) NOT NULL,
  `status` int(11) NOT NULL DEFAULT 0,
  `role_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `role_id` (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

ALTER TABLE `users`
  ADD CONSTRAINT `fk_users_roles` FOREIGN KEY (`role_id`) REFERENCES `roles` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION;
  
INSERT INTO `users`(`name`,`login`,`password`,`status`,`role_id`) VALUES
('user1','user1','797cb93f8b1159e6dc68b2b7fddd6c55',0,1),
('user2','user2','797cb93f8b1159e6dc68b2b7fddd6c55',0,2),
('admin','admin','797cb93f8b1159e6dc68b2b7fddd6c55',0,3)
