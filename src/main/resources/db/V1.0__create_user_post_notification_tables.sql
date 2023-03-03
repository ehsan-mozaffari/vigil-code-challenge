-- @@@@@@@@@@@ USER TABLE @@@@@@@@@@@
CREATE TABLE "user" (
	id serial PRIMARY KEY,
	name varchar NOT NULL,
	email varchar UNIQUE NOT NULL,
	is_online boolean NOT NULL,
	followed_user_ids integer[] NOT NULL
);

-- @@@@@@@@@@@ POST TABLE @@@@@@@@@@@
CREATE TABLE post (
	id serial PRIMARY KEY,
	author_id integer NOT NULL,
	content varchar NOT NULL,
	image varchar ,
	publish_date timestamp without time zone NOT NULL
);

-- @@@@@@@@@@@ NOTIFICATION TABLE @@@@@@@@@@@
CREATE TABLE notification (
	id serial PRIMARY KEY,
	user_id integer NOT NULL,
	post_id integer NOT NULL,
	is_read boolean NOT NULL
);
