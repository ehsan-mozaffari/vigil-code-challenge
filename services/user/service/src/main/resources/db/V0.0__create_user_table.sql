-- @@@@@@@@@@@ USER TABLE @@@@@@@@@@@
CREATE TABLE "user" (
	id serial PRIMARY KEY,
	name varchar NOT NULL,
	email varchar UNIQUE NOT NULL,
	is_online boolean NOT NULL,
	followed_user_ids integer[] NOT NULL
);