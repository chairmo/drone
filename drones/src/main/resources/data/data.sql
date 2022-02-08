insert into `drone` (`serial`, `model`, `battery`, `state`) values ('DR-011', 'Lightweight',56, 'IDLE'),
	('DR-021', 'Cruiserweight', 26, 'LOADING'), ('DR-031', 'Heavyweight',16, 'DELIVERING'), 
	('DR-041', 'Lightweight', 76, 'RETURNING'), ('DR-051', 'Cruiserweight', 38, 'LOADING'),
	 ('DR-061', 'Heavyweight',51, 'LOADED'), ('DR-071', 'Cruiserweight', 22, 'DELIVERED'),
	('DR-081', 'Lightweight', 23, 'IDLE'), ('DR-091', 'Widdleweight', 30, 'LOADING'),
	 ('DR-101', 'Widdleweight',100, 'LOADED');
	
	
insert into `medication` (`name`, `weight`, `code`, `image_url`, `drone_id`) values
	 ('Panadol', 89, 'PA_4563', 'https://image1', 1), ('Aspirin', 67, 'AS563', 'https://image2', 1),
	 ('Ibuprofen', 100, 'IB_063', 'https://image3', 1), ('Amoxilllin', 70, 'AMX_345', 'https://image4', 2),
	 ('Codeine',90, 'COD_4563', 'https://image5', 2), ('Diazepam', 20, 'DIA_4563', 'https://image6', 4),
	 ('Abilify', 89, 'AB063', 'https://image7', 4), ('Cymbalta', 68, 'CY1563', 'https://image6', 4),
	 ('Ativan', 300, 'AT_463', 'https://image8', 5), ('ACE Inhibitors', 132, 'ACEEIMBI', 'https://image10', 6),
	 ('Atenolol', 68, 'ATE101', 'https://image9', 6), ('Clonazeparam', 78, '324563', 'https://image11', 9),
	  ('Carvedilol', 124,'CARVASOS', 'https://image9', 9), ('Citolopram', 56, '324563', 'https://image11', 6);


