update SCHOOL
set graduation_year='2009-2-2'
where SCHOOL.userid=(select userid
					from USERPROFÝLE
					where first_name='Gökhan')
					
					
select *
from SCHOOL