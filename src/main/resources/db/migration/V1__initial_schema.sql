CREATE  TABLE  to_do_item
(
     uid       INT AUTO_INCREMENT NOT NULL,
     name      VARCHAR(255)       NULL,
     finished  BIT(1)             NOT NULL ,
     to_do_listuid  INT           NOT NULL ,
     CONSTRAINT pk_todoitem PRIMARY KEY (uid)
);

CREATE  TABLE  to_do_list
(
    uid INT AUTO_INCREMENT  NOT NULL,
    name varchar(255)       NULL,
    CONSTRAINT  pk_todolist PRIMARY KEY (uid)
);

ALTER  TABLE  to_do_item
     ADD  CONSTRAINT  FK_TODOITEM_ON_TODOLISTUID FOREIGN KEY (to_do_listuid) REFERENCES  to_do_list (uid);