 CREATE TABLE category (
     id IDENTITY,
     name VARCHAR(50),
     description VARCHAR(255),
     image_url VARCHAR(50),
     is_active BOOLEAN,
     CONSTRAINT pk_category_id PRIMARY KEY (id)
 );
 
INSERT INTO category (name, description, image_url, is_active) VALUES('Laptop','this is a description for laptop','CAT_01.img',true);
INSERT INTO category (name, description, image_url, is_active) VALUES('Mobile','this is a description for Mobile','CAT_02.img',true);
INSERT INTO category (name, description, image_url, is_active) VALUES('Television','this is a description for Television','CAT_03.img',true);

CREATE TABLE user_detail (
	id IDENTITY,
	first_name VARCHAR(50),
	last_name VARCHAR(50),
	role VARCHAR(50),
	enabled BOOLEAN,
	password VARCHAR(50),
	email VARCHAR(100),
	contact_number VARCHAR(15),
	CONSTRAINT pk_user_id PRIMARY KEY(id)
);


INSERT INTO user_detail
(first_name, last_name, role, enabled, password, email, contact_number)
VALUES('shareef', 'shaik', 'ADMIN', true, 'admin', 'shaikshareef@gnail.com', '987923686');
INSERT INTO user_detail
(first_name, last_name, role, enabled, password, email, contact_number)
VALUES('abdul wahid', 'shaik', 'SUPPLIER', true, 'admin', 'shaikabdul@gnail.com', '273635346');
INSERT INTO user_detail
(first_name, last_name, role, enabled, password, email, contact_number)
VALUES('feroz', 'syed', 'SUPPLIER', true, 'admin', 'shaikshareef@gnail.com', '987923686');



CREATE TABLE product (
	id IDENTITY,
	code VARCHAR(20),
	name VARCHAR(50),
	brand VARCHAR(50),
	description VARCHAR(225),
	unit_price DECIMAL(10,2),
	quantity INT,
	is_active BOOLEAN,
	category_id INT,
	supplier_id INT,
	purchases INT DEFAULT 0,
	views INT DEFAULT 0,
	CONSTRAINT pk_product_id PRIMARY KEY (id),
	CONSTRAINT fk_product_category_id FOREIGN KEY (category_id) REFERENCES category(id),
	CONSTRAINT fk_product_supplier_id FOREIGN KEY (supplier_id) REFERENCES user_detail(id),
);


INSERT INTO product 
(code, name, brand, description, unit_price, quantity, is_active, category_id, supplier_id)
VALUES 
('PRDPQRTEWNGEY', 'Google Pixel', 'google', 'this is one of the best mobile phone available in market', 57000.53, 5 ,true, 3, 2);

INSERT INTO product 
(code, name, brand, description, unit_price, quantity, is_active, category_id, supplier_id)
VALUES 
('GWJWYGQTPKLMX', 'Macbook pro', 'apple', 'this is one of the best mobile phone available in market', 67000.43, 2, true, 1, 2);

INSERT INTO product 
(code, name, brand, description, unit_price, quantity, is_active, category_id, supplier_id)
VALUES 
('PRHDTEPMCGSS', 'Dell latitude', 'dell', 'this is one of the best mobile phone available in market', 34000.87, 3, true, 1, 3);




