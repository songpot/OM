CREATE TABLE IF NOT EXISTS app_user (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  account_expired bit(1) NOT NULL,
  account_locked bit(1) NOT NULL,
  address varchar(150) COLLATE utf8_bin DEFAULT NULL,
  city varchar(50) COLLATE utf8_bin DEFAULT NULL,
  country varchar(100) COLLATE utf8_bin DEFAULT NULL,
  postal_code varchar(15) COLLATE utf8_bin DEFAULT NULL,
  province varchar(100) COLLATE utf8_bin DEFAULT NULL,
  credentials_expired bit(1) NOT NULL,
  email varchar(255) COLLATE utf8_bin NOT NULL,
  account_enabled bit(1) DEFAULT NULL,
  first_name varchar(50) COLLATE utf8_bin NOT NULL,
  last_name varchar(50) COLLATE utf8_bin NOT NULL,
  password varchar(255) COLLATE utf8_bin NOT NULL,
  password_hint varchar(255) COLLATE utf8_bin DEFAULT NULL,
  phone_number varchar(255) COLLATE utf8_bin DEFAULT NULL,
  username varchar(50) COLLATE utf8_bin NOT NULL,
  version int(11) DEFAULT NULL,
  website varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (id),
  UNIQUE KEY email (email),
  UNIQUE KEY username (username)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=2 ;

CREATE TABLE IF NOT EXISTS role (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  description varchar(64) COLLATE utf8_bin DEFAULT NULL,
  name varchar(20) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=3 ;

CREATE TABLE IF NOT EXISTS user_role (
  user_id bigint(20) NOT NULL,
  role_id bigint(20) NOT NULL,
  PRIMARY KEY (user_id,role_id),
  KEY FK143BF46A3C318157 (role_id),
  KEY FK143BF46AE15C4537 (user_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;



INSERT INTO app_user (id, account_expired, account_locked, address, city, country, postal_code, province, credentials_expired, email, account_enabled, first_name, last_name, password, password_hint, phone_number, username, version, website) VALUES(1, '\0', '\0', '', '', '', '', '', '\0', '', 1, 'Admin', '', 'd033e22ae348aeb5660fc2140aec35850c4da997', 'The same as your username.', '', 'admin', 1, 'http://tot3g.net');

INSERT INTO role (id, description, name) VALUES(1, 'Administrator role (can edit Users)', 'ROLE_ADMIN');
INSERT INTO role (id, description, name) VALUES(2, 'Default role for all Users', 'ROLE_USER');

INSERT INTO user_role (user_id, role_id) VALUES(1, 1);