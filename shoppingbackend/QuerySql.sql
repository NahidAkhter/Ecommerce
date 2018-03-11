CREATE TABLE category (
	id NUMBER(10) NOT NULL,
	 name VARCHAR(50) NOT NULL,
	 description VARCHAR(255),
	 image_url VARCHAR(50),
	 is_active VARCHAR(1),
	 
	 CONSTRAINT pk_category_id PRIMARY KEY (id)
);