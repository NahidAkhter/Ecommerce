 CREATE TABLE category (
     id NUMBER GENERATED AS IDENTITY,
     name VARCHAR(50),
     description VARCHAR(255),
     image_url VARCHAR(50),
     is_active char(1) check (is_active in ( 'Y', 'N' )),
     CONSTRAINT pk_category_id PRIMARY KEY (id)
 );