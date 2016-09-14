﻿CREATE TRIGGER ARKADAS_EKLE
ON FRIEND 
AFTER INSERT
AS
    
BEGIN
DECLARE 
@friend_email_id CHAR(8),
@created_at DATE,
@email_id CHAR(8),

  SELECT @friend_email_id =email_id, @email_id=friend_email_id, @created_at=created_at
FROM INSERTED

  
 INSERT INTO FRIEND(friend_email_id,created_at,email_id) VALUES(@friend_email_id,@created_at,@email_id )
 END;
 RETURN;



