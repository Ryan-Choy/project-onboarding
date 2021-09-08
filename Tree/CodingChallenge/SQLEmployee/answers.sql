--a) Write an SQL query to fetch worker names with salaries >= 50000 and <= 100000
select first_name, last_name
from "project-onboarding".employee_list
where salary >= 50000 and salary <= 100000;


--b) Write an SQL query to fetch the no. of workers for each department in the descending order. 
select department,count(department) as "Number of Workers"
from "project-onboarding".employee_list
group by department
order by count(department) desc;

--c) Write an SQL query to fetch intersecting records of two tables. 
select *
from "project-onboarding".employee_list e join "project-onboarding".title t
on e.worker_id = t.worker_ref_id;


--d) Write an SQL query to determine the 5th highest salary without using TOP or limit method.
select *
from(
	select *, dense_rank() over (order by e.salary desc) as salary_rank
	from "project-onboarding".employee_list e
) as t
where t.salary_rank = 5;
