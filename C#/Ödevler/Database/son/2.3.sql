/*memleketi hatay olan bir kullan�c�n�n cal�st�g� sirket bilgileri , sirket ismine g�re alfabetik olarak azalan s�rada listeler */
(select w.company_name,w.startDate,w.pozition
from WORKPLACE as w	
where w.workplace_id in (select l.Location_id
						from LOCATION as l ,ADRESS_home as a
						where l.City ='Hatay' and a.home=l.Location_id
						
					))
order by 	w.company_name DESC

