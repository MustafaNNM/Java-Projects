CREATE TRIGGER ARKADAS_EKLE
ON FRIEND 
AFTER INSERT
AS
    
BEGIN
DECLARE 
@friend_id INT,
@created_at nvarchar(MAX),
@email_id INT,

SELECT @friend_id=email_id, @email_id=friend_id, @created_at=created_at
FROM INSERTED

  
 INSERT INTO FRIEND(friend_id,created_at,email_id) VALUES(@friend_id,@created_at,@email_id )
 END;
 RETURN;



