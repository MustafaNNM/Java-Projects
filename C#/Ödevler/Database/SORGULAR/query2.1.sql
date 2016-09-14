/*status tablosunda paylaşımda bulunanların listelenmesi*/
SELECT        Name_first, Name_last
FROM            USERINFO
WHERE        (NOT EXISTS
                             (SELECT        status_id, email_id, created_at, thumb_up, comment, share, is_reply
                               FROM            STATUSS
                               WHERE        (email_id = USERINFO.email_id) AND (share = 'No')))