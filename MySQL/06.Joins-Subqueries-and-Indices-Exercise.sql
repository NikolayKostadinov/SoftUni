-- 01. Employee Address
SELECT
	e.employee_id,
	e.job_title,
	e.address_id,
	a.address_text
FROM employees AS e LEFT JOIN addresses AS a
	USING(address_id)
ORDER BY address_id ASC
LIMIT 5;

-- 02. Addresses with Towns
SELECT
	e.first_name,
	e.last_name,
	t.`name` as town,
	a.address_text
FROM employees AS e JOIN addresses as a
	USING(address_id) JOIN towns as t
    USING(town_id)
ORDER BY first_name, last_name
LIMIT 5;

-- 03. Sales Employee
SELECT
	e.employee_id,
	e.first_name,
	e.last_name,
	d.`name` as department_name 
FROM employees AS e JOIN departments as d
	USING (department_id)
WHERE d.`name` = 'Sales'
ORDER BY employee_id DESC;

-- 04. Employee Departments
SELECT 
	e.employee_id,
	e.first_name,
	e.salary,
	d.`name` AS department_name
FROM employees as e JOIN departments as d
	on e.department_id = d.department_id
WHERE e.salary > 15000
ORDER BY e.department_id DESC, e.employee_id ASC
LIMIT 5;

-- 05. Employees Without Project
SELECT 
	e.employee_id,
	e.first_name
FROM employees AS e LEFT JOIN employees_projects as ep
	USING(employee_id)
WHERE (SELECT COUNT(*) FROM employees_projects WHERE employee_id = e.employee_id) = 0
ORDER BY employee_id DESC
LIMIT 3;

-- 06. Employees Hired After
SELECT
	e.first_name,
	e.last_name,
	e.hire_date,
	d.`name` AS dept_name
FROM employees AS e JOIN departments AS d 
	USING(department_ID)
    WHERE e.hire_date > '1999/01/01' 
		AND d.`name` IN ("Sales", "Finance")
        ORDER BY e.hire_date ASC;
	
-- 07. Employees with Project
SELECT 
    e.employee_id, e.first_name, p.`name` AS project_name
FROM
    employees AS e
        JOIN employees_projects AS ep USING (employee_id)
        JOIN projects AS p USING (project_id)
WHERE
    DATE(p.start_date) > '2002-08-13'
        AND p.end_date IS NULL
ORDER BY e.first_name , p.`name`
LIMIT 5;
         
-- 08. Employee 24
SELECT 
	e.employee_id,
	e.first_name,
	IF(YEAR(p.start_date) >= 2005, NULL, p.`name`) AS project_name
FROM
    employees AS e
        JOIN employees_projects AS ep USING (employee_id)
        JOIN projects AS p USING (project_id)
WHERE ep.employee_id = 24
ORDER BY project_name;

-- 09. Employee Manager
SELECT 
	e.employee_id,
	e.first_name,
	e.manager_id,
	m.first_name as manager_name
FROM employees as e JOIN employees as m
	ON e.manager_id = m.employee_id
WHERE e.manager_id IN (3, 7)
ORDER BY e.first_name;

-- 10. Employee Summary
SELECT 
    e.employee_id,
    CONCAT_WS(' ', e.first_name, e.last_name) AS employee_name,
    CONCAT_WS(' ', m.first_name, m.last_name) AS manager_name,
    d.`name` AS department_name
FROM
    employees AS e
        JOIN
    employees AS m ON e.manager_id = m.employee_id
        JOIN
    departments AS d ON e.department_id = d.department_id
ORDER BY e.employee_id
LIMIT 5;

-- 11. Min Average Salary
SELECT AVG(salary) AS min_average_salary
FROM employees
GROUP BY department_id
ORDER BY min_average_salary
LIMIT 1;

-- 12. Highest Peaks in Bulgaria
SELECT 
    mc.country_code, m.mountain_range, p.peak_name, p.elevation
FROM
    peaks AS p
        JOIN
			mountains AS m ON p.mountain_id = m.id
		JOIN
			mountains_countries AS mc ON m.id = mc.mountain_id
		JOIN 
			countries AS c ON mc.country_code = c.country_code
WHERE c.country_name = "Bulgaria" AND p.elevation > 2835
ORDER BY p.elevation DESC;

-- 13. Count Mountain Ranges
SELECT 
    mc.country_code, COUNT(m.mountain_range) as mountain_range
FROM
   mountains AS m
        JOIN
    mountains_countries AS mc ON m.id = mc.mountain_id
    	JOIN 
			countries AS c ON mc.country_code = c.country_code
WHERE c.country_name IN ('United States', 'Russia','Bulgaria')
GROUP BY mc.country_code
ORDER BY mountain_range DESC;

-- 14. Countries with Rivers
SELECT c.country_name, r.river_name
	FROM countries AS c
		JOIN continents AS co USING(continent_code)
        LEFT JOIN countries_rivers cr USING(country_code)
        JOIN rivers as r ON cr.river_id = river_id
        WHERE co.continent_name = 'Africa'
ORDER BY c.country_name
LIMIT 5;
