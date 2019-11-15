CREATE TABLE IF NOT EXISTS roles (
    role_id BIGSERIAL PRIMARY KEY,
    role_name VARCHAR(50) NOT NULL
)

CREATE TABLE IF NOT EXISTS users (
    user_id UUID PRIMARY KEY,
    username VARCHAR(100) NOT NULL UNIQUE,
    password VARCHAR(200) NOT NULL,
    role_id BIGINT NOT NULL REFERENCES roles(role_id) ON UPDATE CASCADE ON DELETE CASCADE,,
    first_name VARCHAR(100),
    last_name VARCHAR(100),
    email VARCHAR(200) NOT NULL UNIQUE,
    is_active BOOLEAN DEFAULT TRUE
)

CREATE TABLE IF NOT EXISTS shops (
    shop_id UUID PRIMARY KEY,
    shop_name VARCHAR(200) NOT NULL,
    owned_by UUID REFERENCES users(user_id) ON UPDATE CASCADE ON DELETE CASCADE,
    is_active BOOLEAN DEFAULT TRUE,
    is_approved BOOlEAN DEFAULT FALSE,
    created_on TIMESTAMP,
    updated_on TIMESTAMP
)

CREATE TABLE IF NOT EXISTS categories (
    category_id BIGSERIAL PRIMARY KEY,
    category_name VARCHAR(100),
    parent_id BIGINT
)

CREATE TABLE IF NOT EXISTS users_roles (
    role_id BIGINT REFERENCES roles(role_id) ON UPDATE CASCADE ON DELETE CASCADE,
    user_id UUID REFERENCES users(user_id) ON UPDATE CASCADE ON DELETE CASCADE,
    PRIMARY KEY (role_id, user_id)
)


CREATE TABLE IF NOT EXISTS products (
    product_id UUID PRIMARY KEY,
    product_name VARCHAR(200) NOT NULL,
    product_description VARCHAR(500),
    shop_id UUID REFERENCES shops(shop_id) ON UPDATE CASCADE ON DELETE CASCADE,
    created_by UUID REFERENCES users(user_id) ON UPDATE CASCADE ON DELETE CASCADE,
    is_active BOOLEAN DEFAULT FALSE,
    is_approved BOOLEAN DEFAULT FALSE,
    created_on TIMESTAMP,
    updated_on TIMESTAMP,
    category_id BIGINT REFERENCES categories(category_id) ON UPDATE CASCADE ON DELETE CASCADE
)



CREATE TABLE IF NOT EXISTS reviews (
    review_id BIGSERIAL PRIMARY KEY,
    point SMALLINT,
    product_id UUID REFERENCES products(product_id) ON UPDATE CASCADE ON DELETE CASCADE,
    created_on TIMESTAMP,
    reviewed_by UUID REFERENCES users(user_id) ON UPDATE CASCADE ON DELETE CASCADE
)