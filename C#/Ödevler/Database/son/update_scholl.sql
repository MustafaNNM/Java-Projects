update SCHOOL
set graduation_year='2009-2-2'
where SCHOOL.userid=(select userid
					from USERPROF�LE
					where first_name='G�khan')
					
					
select *
from SCHOOL