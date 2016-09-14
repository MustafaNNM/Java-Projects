
INSERT INTO USERPROFÝLE ([userid], [first_name], [middle_name], [last_name], [password_], [e_mail], [picture], [activities], [about_me], [birthday], [interests], [phone], [political_wievs], [religion], [webAddFriendLink], [webProfileLink]) VALUES (1, 'Gökhan', '', 'Yalýnbaþ', '812017', 'gokhan@hotmail.com', '1.jpg', 'Playing football', 'I''m an engineer', '1990-12-12', 'Cars', '812302645', 'BJK', NULL, 'https://www.facebook.com/profile.php?id=1653945583', 'https://www.facebook.com/profile.php?id=1653945583')
INSERT INTO USERPROFÝLE ([userid], [first_name], [middle_name], [last_name], [password_], [e_mail], [picture], [activities], [about_me], [birthday], [interests], [phone], [political_wievs], [religion], [webAddFriendLink], [webProfileLink]) VALUES (2, 'Anýl', NULL, 'Tetik', '1234', 'anýl@hotmail.com', '2.jpg', 'playing basketball', '!'' a fenomen','2000-2-3', 'Films', '120236548', 'GS', 'None', 'https://www.facebook.com/profile.php?id=1653945583&ref=tn_tinyman', 'https://www.facebook.com/profile.php?id=1653945583&ref=tn_tinyman')
INSERT INTO USERPROFÝLE ([userid], [first_name], [middle_name], [last_name], [password_], [e_mail], [picture], [activities], [about_me], [birthday], [interests], [phone], [political_wievs], [religion], [webAddFriendLink], [webProfileLink]) VALUES (3, 'Ugur', NULL, 'Taskan', '1234', 'ugur@hotmail.com', '3.jpg', 'Playing guitar', 'I''m an engineer', '1990-12-3', 'Everything', '812365485', 'GS', 'Ateist', 'https://www.facebook.com/profile.php?id=1653945583&ref=tn_tinyman', 'https://www.facebook.com/profile.php?id=1653945583&ref=tn_tinyman')
INSERT INTO USERPROFÝLE ([userid], [first_name], [middle_name], [last_name], [password_], [e_mail], [picture], [activities], [about_me], [birthday], [interests], [phone], [political_wievs], [religion], [webAddFriendLink], [webProfileLink]) VALUES (4, 'Ertunç', 'hakan', 'Akþit', '1234', 'ertunç@hotmail.com', '4.jpg', 'Watching movie', 'I'' m an angry man', '1989-12-5', 'Films', '845210215', 'FB', 'None', 'https://www.facebook.com/profile.php?id=1653945583&ref=tn_tinyman', 'https://www.facebook.com/profile.php?id=1653945583&ref=tn_tinyman')


INSERT INTO LOCATION ([Location_id], [City], [Country], [States], [Street], [postcode]) VALUES (1, 'Hatay', 'Turkey', 'Akdeniz', 'Samandað', '31800')
INSERT INTO LOCATION ([Location_id], [City], [Country], [States], [Street], [postcode]) VALUES (2, 'Amasya', 'Turkey', 'Ege', 'Bornova', '35100')
INSERT INTO LOCATION ([Location_id], [City], [Country], [States], [Street], [postcode]) VALUES (3, 'Paris', 'France', NULL, 'Evian', '125552')
INSERT INTO LOCATION ([Location_id], [City], [Country], [States], [Street], [postcode]) VALUES (4, 'Ýstanbul', 'Turkey', 'Marmara', 'Taksim', '34100')
INSERT INTO LOCATION ([Location_id], [City], [Country], [States], [Street], [postcode]) VALUES (5, 'Ankara', 'Turkey', 'Anadolu', 'Kýzýlay', '06100')
INSERT INTO LOCATION ([Location_id], [City], [Country], [States], [Street], [postcode]) VALUES (6, 'Ankara', 'Turkey', 'Anadolu', 'Kýzýlay', '06100')


INSERT INTO GROUPS ([creator], [description_], [group_id], [group_type], [group_pic], [name], [update_time], [location_id]) VALUES (1, 'Not paylasýmý', 1, 'Egitim ', '9.jpg', 'Bilgisayar09', '2011-12-12', 1)
INSERT INTO GROUPS ([creator], [description_], [group_id], [group_type], [group_pic], [name], [update_time], [location_id]) VALUES (2, 'spor', 2, 'Spor', 'b.jpg', 'BJK haber', '2011-1-2', 3)
INSERT INTO GROUPS ([creator], [description_], [group_id], [group_type], [group_pic], [name], [update_time], [location_id]) VALUES (3, 'Eglenceli paylasýmlar :)', 3, 'Eglence', 'l.jpg', 'Vur patlasýn cal oynasýn', '2001-1-9', 3)
INSERT INTO GROUPS ([creator], [description_], [group_id], [group_type], [group_pic], [name], [update_time], [location_id]) VALUES (1, 'Bu grup sadece ögrenciler içindir', 4, 'Bilgi', '1.jpg', 'Bilmedikleriniz', '2004-9-12', 4)
INSERT INTO GROUPS ([creator], [description_], [group_id], [group_type], [group_pic], [name], [update_time], [location_id]) VALUES (4, 'Kar amacý gütmeyen grup', 5, 'izdivac', 'lk.jpg', 'EGE izdivaç','2008-12-10', 3)
INSERT INTO GROUPS ([creator], [description_], [group_id], [group_type], [group_pic], [name], [update_time], [location_id]) VALUES (4, 'Kar amacý gütmeyen grup', 6, 'izdivac', 'lk.jpg', 'EGE izdivaç', '2001-5-12', 3)


INSERT INTO GROUP_MEMBERS  ([group_id], [userid], [memberType]) VALUES (1, 2, 'üye')
INSERT INTO GROUP_MEMBERS  ([group_id], [userid], [memberType]) VALUES (1, 3, 'üye')
INSERT INTO GROUP_MEMBERS  ([group_id], [userid], [memberType]) VALUES (2, 3, 'üye')
INSERT INTO GROUP_MEMBERS  ([group_id], [userid], [memberType]) VALUES (3, 1, 'üye')
INSERT INTO GROUP_MEMBERS  ([group_id], [userid], [memberType]) VALUES (4, 2, 'üye')










INSERT INTO RELATIONSHIPSTATUS ([userid], [statu]) VALUES (1, 'Evli')
INSERT INTO RELATIONSHIPSTATUS ([userid], [statu]) VALUES (2, 'Ýliþkisi var')
INSERT INTO RELATIONSHIPSTATUS ([userid], [statu]) VALUES (3, 'iliþkisi yok')


INSERT INTO SCHOOL ([userid], [schoolid], [name], [graduation_year]) VALUES (1, 1, 'Yüksel Acun Anadolu Lisesi', '2005-11-11')
INSERT INTO SCHOOL ([userid], [schoolid], [name], [graduation_year]) VALUES (3, 2, 'Namýk kemal lisesi', '2009-10-11')
INSERT INTO SCHOOL ([userid], [schoolid], [name], [graduation_year]) VALUES (4, 3, 'Ýzmir Fen Lisesi', '2010-1-11')
INSERT INTO SCHOOL ([userid], [schoolid], [name], [graduation_year]) VALUES (4, 4, 'ATAKENT LÝSESÝ', '2007-4-7')


INSERT INTO EVENT_ ([event_id], [location_id], [creator], [description_], [end_time], [event_type], [picture], [name], [start_time], [update_time]) VALUES (1, 2, 1, 'Dogum günü', '1999-2-3', 'Eglence', '5.jpg', 'party', '1899-8-3', '2001-12-3')
INSERT INTO EVENT_ ([event_id], [location_id], [creator], [description_], [end_time], [event_type], [picture], [name], [start_time], [update_time]) VALUES (2, 3, 3, NULL, '1990-2-5', 'Egitim', '6.jpg', 'Mamtematik dersi', '2009-11-3', '2009-7-6')
INSERT INTO EVENT_ ([event_id], [location_id], [creator], [description_], [end_time], [event_type], [picture], [name], [start_time], [update_time]) VALUES (3, 4, 2, 'Topluca yürüyüþ', '2008-2-3', 'Sosyal', '3.jpg', 'yürüyüþ', '2011-9-14', '2004-3-3')


INSERT INTO ADRESS_home ([userid], [home]) VALUES (1, 1)
INSERT INTO ADRESS_home ([userid], [home]) VALUES (2, 2)
INSERT INTO ADRESS_home ([userid], [home]) VALUES (3, 4)
INSERT INTO ADRESS_home ([userid], [home]) VALUES (4, 3)


INSERT INTO ADRESS_Current ([userid], [current_]) VALUES (1, 2)
INSERT INTO ADRESS_Current  ([userid], [current_]) VALUES (2, 2)
INSERT INTO ADRESS_Current  ([userid], [current_]) VALUES (3, 1)
INSERT INTO ADRESS_Current  ([userid], [current_]) VALUES (4, 4)



INSERT INTO GENDER ([userid], [lokingFor], [profileGender]) VALUES (1, 'Male', 'Female')
INSERT INTO GENDER ([userid], [lokingFor], [profileGender]) VALUES (3, '', 'Male')
INSERT INTO GENDER ([userid], [lokingFor], [profileGender]) VALUES (4, '', NULL)
INSERT INTO GENDER ([userid], [lokingFor], [profileGender]) VALUES (2, 'Female', 'Male')


INSERT INTO FRIEND_RELATIONS ([userid1], [userid2]) VALUES (1, 2)
INSERT INTO FRIEND_RELATIONS ([userid1], [userid2]) VALUES (2, 3)
INSERT INTO FRIEND_RELATIONS ([userid1], [userid2]) VALUES (2, 4)



INSERT INTO FAVOURÝTES ([userid], [books], [movies], [music], [quotes], [TvShows], [Team], [actriss]) VALUES (1, 'Melekler ve Seytanlar', 'INCEPTION', 'pop', 'lalalala...', 'Ya sundadýr ya bunda', 'FB', 'Hülya Avsar')
INSERT INTO FAVOURÝTES ([userid], [books], [movies], [music], [quotes], [TvShows], [Team], [actriss]) VALUES (2, 'Angela''nýn Külleri', 'Angela', 'Rock', 'Neolursan ol adam ol', 'How I meet your mother', 'HJK', 'Angelina Jolie')
INSERT INTO FAVOURÝTES ([userid], [books], [movies], [music], [quotes], [TvShows], [Team], [actriss]) VALUES (3, 'Melekler veSeytanlar', 'Batman', 'Metal', NULL, 'BÝgbang Theory', 'BJK', 'Jesica Alba')
INSERT INTO FAVOURÝTES ([userid], [books], [movies], [music], [quotes], [TvShows], [Team], [actriss]) VALUES (4, NULL, NULL, NULL, NULL, NULL, 'GS', NULL)

INSERT INTO WORKPLACE ([userid], [workplace_id], [company_name], [Descriptions], [startDate], [endDate], [pozition]) VALUES (1, 1, 'Microsoft', 'Software company', '12.12.2008', '2.5.2009', 'Müdür')
INSERT INTO WORKPLACE ([userid], [workplace_id], [company_name], [Descriptions], [startDate], [endDate], [pozition]) VALUES (2, 1, 'Vodafone', 'Telekominukasyon', '12.12.2008',  '2.5.2009', 'Developer')
INSERT INTO WORKPLACE ([userid], [workplace_id], [company_name], [Descriptions], [startDate], [endDate], [pozition]) VALUES (3, 4, 'Avea', 'Telekominukasyon', '12.12.2008', '2.5.2009', 'Developer')
INSERT INTO WORKPLACE ([userid], [workplace_id], [company_name], [Descriptions], [startDate], [endDate], [pozition]) VALUES (4, 3, 'Turkcell', 'Telekominukasyon', '12.12.2008',  '2.5.2009', 'Asistan')


INSERT INTO VÝDEO ([video_id], [owner_id], [caption]) VALUES (1, 1, 'Bjk macý')
INSERT INTO VÝDEO ([video_id], [owner_id], [caption]) VALUES (2, 1, 'Fener macý')
INSERT INTO VÝDEO ([video_id], [owner_id], [caption]) VALUES (3, 2, 'Kopmak garanti :D')
INSERT INTO VÝDEO ([video_id], [owner_id], [caption]) VALUES (4, 3, 'kesinlikle izle')
INSERT INTO VÝDEO ([video_id], [owner_id], [caption]) VALUES (5, 4, 'youtube.com/ly142')
INSERT INTO VÝDEO ([video_id], [owner_id], [caption]) VALUES (6, 4, 'güzel manzaralar')


INSERT INTO Post ([post_id], [userid], [post]) VALUES (1, 1, 'Dogum günün kutlu olsun')
INSERT INTO Post  ([post_id], [userid], [post]) VALUES (2, 1, 'study study study..')
INSERT INTO Post ([post_id], [userid], [post]) VALUES (3, 2, 'Okul ne zaman baslýyo')
INSERT INTO Post ([post_id], [userid], [post]) VALUES (4, 3, 'Yaz mevsimi gelse de yüzmeye gitsekk.')
INSERT INTO Post  ([post_id], [userid], [post]) VALUES (5, 4, 'yeni yýlýn kutlu olsunn')

INSERT INTO PHOTO ([photo_id], [owner_id], [caption]) VALUES (1, 1, 'Ben')
INSERT INTO PHOTO ([photo_id], [owner_id], [caption]) VALUES (2, 1, 'Sýnav zamaný')
INSERT INTO PHOTO ([photo_id], [owner_id], [caption]) VALUES (3, 2, 'yaz aksamý')
INSERT INTO PHOTO ([photo_id], [owner_id], [caption]) VALUES (4, 3, 'gün batýmý')

INSERT INTO MESSAGE_ ([message_id], [userid], [to_user], [is_read], [is_reply], [message_]) VALUES (1, 2, 3, 1, 0, 'Naber;)')
INSERT INTO MESSAGE_ ([message_id], [userid], [to_user], [is_read], [is_reply], [message_]) VALUES (2, 3, 2, 1, 1, 'nasýlsýn..')
INSERT INTO MESSAGE_ ([message_id], [userid], [to_user], [is_read], [is_reply], [message_]) VALUES (3, 1, 4, 1, 1, 'yarýn ders var mý')
INSERT INTO MESSAGE_ ([message_id], [userid], [to_user], [is_read], [is_reply], [message_]) VALUES (4, 4, 1, 1, 1, 'var . bence kacýrma')
INSERT INTO MESSAGE_ ([message_id], [userid], [to_user], [is_read], [is_reply], [message_]) VALUES (5, 1, 4, 1, 1, 'Neden ki?')
INSERT INTO MESSAGE_ ([message_id], [userid], [to_user], [is_read], [is_reply], [message_]) VALUES (6, 4, 1, 1, 1, 'ödev kontrolu var')
INSERT INTO MESSAGE_ ([message_id], [userid], [to_user], [is_read], [is_reply], [message_]) VALUES (7, 1, 4, 1, 1, 'Ben yapamadým :/')


INSERT INTO LOOKINGFOR ([userid], [For_]) VALUES (1, 'Dating')
INSERT INTO LOOKINGFOR ([userid], [For_]) VALUES (2, 'FriendShip')
INSERT INTO LOOKINGFOR ([userid], [For_]) VALUES (3, 'Randomplay')
INSERT INTO LOOKINGFOR ([userid], [For_]) VALUES (4, NULL)


INSERT INTO Post_Properties ([post_id], [wall_id]) VALUES (1, 1)
INSERT INTO Post_Properties ([post_id], [wall_id]) VALUES (2, 1)
INSERT INTO Post_Properties ([post_id], [wall_id]) VALUES (3, 2)
INSERT INTO Post_Properties ([post_id], [wall_id]) VALUES (4, 3)
INSERT INTO Post_Properties ([post_id], [wall_id]) VALUES (5, 4)


INSERT INTO EVENT_MEMBERS ([userid], [event_id], [status_]) VALUES (1, 1, 'Katýlacak')
INSERT INTO EVENT_MEMBERS ([userid], [event_id], [status_]) VALUES (2, 2, 'Cevap vermedi')
INSERT INTO EVENT_MEMBERS ([userid], [event_id], [status_]) VALUES (2, 3, 'Üye')
INSERT INTO EVENT_MEMBERS ([userid], [event_id], [status_]) VALUES (3, 1, 'Cevap vermedi')
INSERT INTO EVENT_MEMBERS ([userid], [event_id], [status_]) VALUES (3, 2, 'Katýlacak')
INSERT INTO EVENT_MEMBERS ([userid], [event_id], [status_]) VALUES (4, 1, 'Cevap vermedi')
INSERT INTO EVENT_MEMBERS ([userid], [event_id], [status_]) VALUES (4, 2, 'Katýlacak')
INSERT INTO EVENT_MEMBERS ([userid], [event_id], [status_]) VALUES (4, 3, 'Cevap vermedi')

