CREATE TABLE USERINFO(

	email_id	 INT	 NOT NULL,
	passwrd		 nvarchar(MAX)    NOT NULL,
	Name_first   nvarchar(MAX)    NOT NULL, 
	Name_last    nvarchar(MAX)    NOT NULL,
	sex          nvarchar(MAX)    NOT NULL,
	birthday     nvarchar(MAX)    NOT NULL, 
	email	     nvarchar(MAX)	  NOT NULL,
	created_at   nvarchar(MAX)    NOT NULL,  
	PRIMARY KEY(email_id));

CREATE TABLE PROFILEINFO(
	profile_id      INT   NOT NULL,
	email_id         INT  NOT NULL,         
	about_me        VARCHAR(160)      ,
	relationship    nvarchar(MAX)       ,
	subscriptions   nvarchar(MAX),
	notes           nvarchar(MAX),
	created_at     nvarchar(MAX)   NOT NULL,
	PRIMARY KEY(profile_id),
	FOREIGN KEY(email_id) REFERENCES USERINFO(email_id));



CREATE TABLE KNOWLEDGE(
	know_id  INT NOT NULL,
	profile_id  INT NOT NULL,
	city   nvarchar(MAX),
	country nvarchar(MAX),
	education      nvarchar(MAX)      ,
	hobbies        nvarchar(MAX)      ,
	fav_movies     nvarchar(MAX)      ,
	fav_artist     nvarchar(MAX)      ,
	created_at      nvarchar(MAX)    NOT NULL,
	PRIMARY KEY(know_id),
	FOREIGN KEY(profile_id) REFERENCES PROFILEINFO(profile_id));


CREATE TABLE NOTIFICATIONINFO(
	notification_id INT       NOT NULL,
	typed            nvarchar(MAX)               ,
	created_at      nvarchar(MAX)   NOT NULL,
	PRIMARY KEY(notification_id));


CREATE TABLE LANGUAGEINFO(
     email_id	INT NOT NULL              ,
	language_id INT      NOT NULL,
	lang        nvarchar(MAX) NOT NULL,
	PRIMARY KEY(language_id),
	FOREIGN KEY(email_id) REFERENCES USERINFO(email_id));


CREATE TABLE MESSAGEINFO(
	message_id  INT      NOT NULL,
	email_id	INT NOT NULL            ,
	messagess   nvarchar(MAX)  ,
	created_at  nvarchar(MAX)    NOT NULL,
	is_read     nvarchar(MAX)       NOT NULL,
	is_spam     nvarchar(MAX)       NOT NULL,
	PRIMARY KEY(message_id),
	FOREIGN KEY(email_id) REFERENCES USERINFO(email_id));


CREATE TABLE CHAT(
	chat_id    INT     NOT NULL,
    too        nvarchar(MAX)     NOT NULL,
	chat        nvarchar(MAX) ,
	email_id	INT    NOT NULL         ,
	created_at nvarchar(MAX)    NOT NULL           ,
	PRIMARY KEY(chat_id),
	FOREIGN KEY(email_id) REFERENCES USERINFO(email_id));


CREATE TABLE STATUSS(
	status_id      INT      NOT NULL,
	email_id	INT    NOT NULL,
	created_at     nvarchar(MAX)    NOT NULL,
	thumb_up       nvarchar(MAX)          ,
	comment nvarchar(MAX),
	share nvarchar(MAX)   ,
	is_reply       nvarchar(MAX)        ,
	PRIMARY KEY(status_id),
	FOREIGN KEY(email_id)REFERENCES USERINFO(email_id));



CREATE TABLE COMMENT(
	comment_id	INT      NOT NULL,
	messagess	nvarchar(MAX)         ,
	status_id    INT     NOT NULL        ,
	friend_id   INT      NOT NULL        ,
	created_at  nvarchar(MAX)    NOT NULL            ,
	PRIMARY KEY(comment_id),
	FOREIGN KEY(status_id) REFERENCES USERINFO(email_id),
	FOREIGN KEY(friend_id) REFERENCES USERINFO(email_id));



	CREATE TABLE FRIEND(

	friend_id		INT  NOT NULL,
	email_id	INT   NOT NULL,
	friend_list_id  INT NOT NULL,
	created_at nvarchar(MAX)    NOT NULL
	PRIMARY KEY(friend_id),
	FOREIGN KEY(email_id) REFERENCES USERINFO(email_id),
	FOREIGN KEY(friend_list_id) REFERENCES USERINFO(email_id));



CREATE TABLE FRIEND_LIST(

	friend_list_id INT   NOT NULL,
	name           nvarchar(MAX)        ,
	friend_id      INT    NOT NULL,
	email_id        INT   NOT NULL,
	PRIMARY KEY(friend_list_id),
	FOREIGN KEY(friend_id) REFERENCES FRIEND(friend_id),
	FOREIGN KEY(email_id) REFERENCES USERINFO(email_id));