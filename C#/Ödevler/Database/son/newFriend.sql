CREATE TRIGGER newFriend
ON FRIEND_RELATIONS 
AFTER INSERT 
AS
    
BEGIN
DECLARE 
@user_id1 int,
@user_id2 int

  SELECT @user_id1 =userid2, @user_id2=userid1
FROM INSERTED

  
 INSERT INTO FRIEND_RELATIONS(userid1,userid2) VALUES(@user_id1,@user_id2 )
 END;
 RETURN;
