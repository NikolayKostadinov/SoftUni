-- 01. Insert
INSERT INTO travel_cards(card_number, job_during_journey, colonist_id,journey_id)
	SELECT 
		IF(birth_date >'1980-01-01', 
			CONCAT(YEAR(birth_date), DAY(birth_date), LEFT(ucn,4)), 
            CONCAT(YEAR(birth_date), MONTH(birth_date), RIGHT(ucn,4))),
        (CASE
			WHEN id % 2 = 0 THEN 'Pilot'
            WHEN id % 3 = 0 THEN 'Cook'
            ELSE 'Engineer'
        END),
        id,
        LEFT(ucn,1)
		FROM colonists
        WHERE id BETWEEN 96 AND 100;

-- 02. Update
UPDATE journeys
SET purpose = 
(CASE
	WHEN id % 2 = 0 THEN 'Medical'
	WHEN id % 3 = 0 THEN 'Technical'
	WHEN id % 5 = 0 THEN 'Educational'
	WHEN id % 7 = 0 THEN 'Military'
    ELSE purpose
END);
    
-- 03. Delete
DELETE FROM colonists as c
	WHERE (SELECT COUNT(id) FROM travel_cards WHERE colonist_id = c.id) = 0;
    
-- 04. Extract all travel cards
SELECT card_number,	job_during_journey
FROM travel_cards
ORDER BY card_number;

-- 05. Extract all colonists
SELECT 
	id, 
    CONCAT_WS(' ', first_name, last_name) AS full_name, 
    ucn
FROM colonists
ORDER BY first_name, last_name, id;

-- 06. Extract all military journeys
SELECT id, journey_start, journey_end
FROM journeys
WHERE purpose = 'Military'
ORDER BY journey_start;

-- 07. Extract all pilots
SELECT 
    c.id,
    CONCAT_WS(' ', c.first_name, c.last_name) AS full_name
FROM
    colonists AS c
        JOIN
    travel_cards AS tc ON tc.colonist_id = c.id
WHERE
    tc.job_during_journey = 'Pilot'
ORDER BY c.id;

-- 08. Count all colonists
SELECT COUNT(c.id)
	FROM colonists as c
		JOIN travel_cards as tc ON tc.colonist_id = c.id
        JOIN journeys as j ON j.id = tc.journey_id
	WHERE j.purpose = 'Technical';
    
-- 09.Extract the fastest spaceship
SELECT 
    s.`name` AS spaceship_name, sp.`name` AS spaceport_name
FROM
    spaceships AS s
        JOIN
    journeys AS j ON j.spaceship_id = s.id
        JOIN
    spaceports AS sp ON sp.id = j.destination_spaceport_id
WHERE
    s.light_speed_rate = (SELECT 
            MAX(light_speed_rate)
        FROM
            spaceships);
            
-- 10. Extract - pilots younger than 30 years
SELECT s.`name`,
	   s.manufacturer 
FROM colonists as c 
    JOIN travel_cards AS tc ON tc.colonist_id = c.id
    JOIN journeys AS j ON j.id = tc.journey_id
    JOIN spaceships AS s ON s.id = j.spaceship_id
 WHERE TIMESTAMPDIFF(YEAR, c.birth_date, '2019-01-01') < 30
		AND tc.job_during_journey = 'Pilot'
-- ORDER BY s.`name`;