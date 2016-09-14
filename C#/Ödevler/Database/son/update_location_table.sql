update LOCATION

set City='Amasya'
where Location_id=(select ADRESS_Current.current_
					from  ADRESS_Current
					where ADRESS_Current.userid=1)
								
select *
from LOCATION