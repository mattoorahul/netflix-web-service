CREATE TABLE `netflix` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `show_id` varchar(500) DEFAULT NULL,
  `type` varchar(500) DEFAULT NULL,
  `country` varchar(500) DEFAULT NULL,
  `date_added` varchar(500) DEFAULT NULL,
  `listed_in` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;


INSERT INTO `employee_db`.`netflix`
(
`show_id`,
`type`,
`country`,
`date_added`,
`listed_in`)
VALUES
(
's1',
'TV Show',
'Brazil',
'14-Aug-20',
'International TV Shows, TV Dramas, TV Sci-Fi & Fantasy');

