delete from SCHOOL
where userid=(select userid
			from USERPROF�LE
			where last_name='Tetik')
			
select *
from SCHOOL