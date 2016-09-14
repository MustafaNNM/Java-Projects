
CREATE TABLE USERPROFÝLE(
 userid				INT	NOT NULL,
 first_name			VARCHAR(15)			NOT NULL,
 middle_name		VARCHAR(15)			,
 last_name			VARCHAR(15)			NOT NULL,
 password_			VARCHAR(20)			NOT NULL,
 e_mail				VARCHAR(50)			NOT NULL,
 picture			VARCHAR(255),
 activities			VARCHAR(255),
 about_me			VARCHAR(255),
 birthday			date,
 interests				varchar(255),
 phone					varchar(40),
 political_wievs		varchar(255),
 religion				varchar(255),
 webAddFriendLink		varchar(255),
 webProfileLink			varchar(255),
 
 UNIQUE(e_mail),
 constraint userpff
 PRIMARY KEY(userid)

);

CREATE TABLE LOCATION(
Location_id			int				NOT NULL,
City				VARCHAR(55),
Country				VARCHAR(55),
States				VARCHAR(55),
Street				VARCHAR(55),
postcode			VARCHAR(20),
constraint lockey
PRIMARY KEY(Location_id)

);
CREATE TABLE ADRESS_home(
userid		int		not null	,
home		int,
constraint ads
primary key(userid),
constraint adsfk
foreign key(home)references LOCATION(Location_id) 
	on delete set null   on update cascade,
foreign key(userid)references USERPROFÝLE(userid) 

);
CREATE TABLE ADRESS_Current(
userid		int		not null	,
current_	int,
constraint ads1
primary key(userid),
constraint adresfk
foreign key(current_)references LOCATION(Location_id)
	on delete set null	on update cascade,
foreign key(userid)references USERPROFÝLE(userid)

);
CREATE TABLE WORKPLACE(
userid				int			not null default 0,
workplace_id		int			not null default 0,
company_name		varchar(45),
Descriptions		varchar(45),
startDate			date,
endDate				date,
pozition			varchar(45),
constraint workkey
PRIMARY KEY(workplace_id,userid),
constraint workforeign1
foreign key(userid) references USERPROFÝLE(userid) 
	on delete set default		on update cascade,
constraint workforeign2
foreign key(workplace_id) references LOCATION(Location_id)
	on delete set default		on update cascade
);

CREATE TABLE GENDER(

userid		int		not null default 0,
lokingFor   VARCHAR(15)	 default 0,
profileGender	VARCHAR(15),
constraint genderpk
PRIMARY KEY(userid),
constraint genderfk
foreign key(userid)references USERPROFÝLE(userid)
	on delete set default		on update cascade
);
CREATE TABLE LOOKINGFOR(

userid			int		not null default 0,
For_			VARCHAR(15),
constraint lokingforpk
PRIMARY KEY(userid),
constraint lokingforfk
foreign key(userid) references USERPROFÝLE(userid)
	on delete set default		on update cascade
);
CREATE TABLE RELATIONSHIPSTATUS(
userid		int		not null default 0,
statu		VARCHAR(25),
with_id		int		default 0,
constraint relationpk
PRIMARY KEY(userid),
constraint relationfk
foreign key(userid) references USERPROFÝLE(userid)
	on delete set default   on update cascade
);

CREATE TABLE SCHOOL(
userid			int			not null default 0,
schoolid		int			not null default 0,
name			varchar(255)		not null,
graduation_year		date,
primary key(userid,schoolid),
constraint schollfk
foreign key(userid) references USERPROFÝLE(userid)
	on delete set default		on update cascade
);
CREATE TABLE MESSAGE_(

message_id			int			not null default 0,
userid				int			not null default 0,
to_user				int			not null default 0 ,
created_at			timestamp		not null,
is_read				bit	not null,
is_reply			bit	not null,
message_			varchar(550),
primary key(message_id,userid,to_user),
constraint mesfk
foreign key(userid) references USERPROFÝLE(userid)
	on delete set default			on update cascade,	
foreign key(to_user) references USERPROFÝLE(userid)

);
CREATE TABLE FAVOURÝTES(

userid				int				not null default 0,
books				varchar(255),
movies				varchar(255),
music				varchar(255),
quotes				varchar(255),
TvShows				varchar(255),
Team				varchar(255),
actriss				varchar(255),
primary key(userid),
constraint favfk
foreign key (userid)  references USERPROFÝLE(userid)
	on delete set default		on update cascade
);
CREATE TABLE VÝDEO(
video_id			int			not null default 0,
owner_id			int			not null default 0,
caption				varchar(255),
created_at			timestamp,
primary key(video_id,owner_id),
constraint vidofk
foreign key (owner_id)  references USERPROFÝLE(userid)
	on delete set default		on update cascade
);

CREATE TABLE PHOTO(

photo_id			int			not null default 0,
owner_id			int			not null default 0,
caption				varchar(255),
created_at			timestamp,
primary key(photo_id,owner_id),
constraint photofk
foreign key (owner_id)  references USERPROFÝLE(userid)
	on delete set default		on update cascade
);

CREATE TABLE EVENT_(

event_id			int				not null default 0,
location_id			int				default 0,
creator				int	not null    default 0,
description_		varchar(255),
end_time			date			not null,
event_type			varchar(50)		not null,
picture				varchar(255),
name				varchar(255)	not null,
start_time			date			not null,
update_time			date,
constraint eventpk
primary key(event_id),
constraint eventfk1
foreign key (location_id)  references LOCATION(Location_id)
	on delete set default 		on update cascade,
constraint eventfk11	
foreign key (creator)  references USERPROFÝLE(userid)
on delete set default 		on update cascade
);
CREATE TABLE EVENT_MEMBERS(
userid			int					not null default 0,
event_id		int					not null default 0,
status_			varchar(255)		not null default 0,
primary key(userid,event_id),
constraint eventfkmember
foreign key (event_id)  references EVENT_(event_id)
	on delete set default		on update cascade,
foreign key (userid)  references USERPROFÝLE(userid)
);
CREATE TABLE FRIEND_RELATIONS(
userid1			int			not null default 0,
userid2			int			not null default 0,
primary key(userid1,userid2),
foreign key(userid1) references USERPROFÝLE(userid),
foreign key(userid2) references USERPROFÝLE(userid),
check(userid1<>userid2)
);
CREATE TABLE GROUPS(
creator			int			not null,
description_	varchar(255),
group_id		int					not null default 0,
group_type		varchar(50)			not null,
group_pic		varchar(255),
name			varchar(50)			not null,
update_time		date,
location_id		int			default 0,
constraint groupspk
primary key(group_id),
constraint groupfk
foreign key (location_id)  references LOCATION(Location_id)
on delete set default		on update cascade,
foreign key(creator) references USERPROFÝLE(userid)
);

CREATE TABLE GROUP_MEMBERS(
group_id		int			not null default 0,
userid			int			not null default 0,
memberType		varchar(50)	not null,
primary key(group_id,userid),
foreign key(group_id) references GROUPS(group_id),
foreign key(userid) references USERPROFÝLE(userid)
);
create table Post(
post_id		int     not null,
userid		int		not null,
created_at	timestamp	not null,
post		varchar(1250),
primary key(post_id),
foreign key(userid)references USERPROFÝLE(userid)

);
create table Post_Properties(
post_id		int     not null,
wall_id		int		not null,
primary key(post_id),
foreign key(wall_id)references USERPROFÝLE(userid),
foreign key(post_id)references post(post_id)

);

