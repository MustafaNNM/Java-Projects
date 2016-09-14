delete from SCHOOL
where userid=(select userid
			from USERPROFÝLE
			where last_name='Tetik')
			
select *
from SCHOOL