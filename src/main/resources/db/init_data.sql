INSERT INTO roles(role_name)
       VALUES ('ROLE_USER'),
	          ('ROLE_SHOP_ADMIN'),
			  ('ROLE_SHOP_MODERATOR'),
			  ('ROLE_SITE_MODERATOR'),
			  ('ROLE_SITE_ADMIN')

--ALTER TABLE users ADD COLUMN role_id BIGINT;
--ALTER TABLE users
--   ADD CONSTRAINT users_roles_id_fk
--   FOREIGN KEY (role_id)
--   REFERENCES roles(role_id);

INSERT INTO users (user_id, role_id, username, password, email, first_name, is_active)
       VALUES (uuid_generate_v4(), 2, 'shop_admin', md5('admin@123'), 'admin@shopping.testvn.com', 'Admin', true),
	          (uuid_generate_v4(), 3, 'shop_moderator', md5('admin@123'), 'moderator_u1@shopping.testvn.com', 'Moderator', true)