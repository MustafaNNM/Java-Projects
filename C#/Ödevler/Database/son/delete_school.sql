delete from SCHOOL
where userid=(select userid
			from USERPROFİLE
			where last_name='Tetik')
			
select *
from SCHOOL