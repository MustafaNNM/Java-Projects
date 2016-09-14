CREATE TRIGGER Grups
ON GROUPS
AFTER INSERT
AS

BEGIN
DECLARE 
@grupid int,
@user_id int,
@member_Type varchar(50)

SELECT @grupid =group_id, @user_id=creator, @member_Type='Admin'
FROM INSERTED


INSERT INTO GROUP_MEMBERS(group_id,userid,memberType) VALUES(@grupid,@user_id,@member_Type )
END;
RETURN;