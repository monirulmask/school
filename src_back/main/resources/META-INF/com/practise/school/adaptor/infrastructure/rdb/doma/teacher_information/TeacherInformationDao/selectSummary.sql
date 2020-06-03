select COUNT(teacher_id) as teacher_total_count, AVG(teacher_age) avg_Count_of_age, SUM(teacher_salary) total_count_of_salary,
    SUM(case when teacher_operational_status = 1 then '1' else '0' end) as total_count_of_operational_teacher
from teacher;
