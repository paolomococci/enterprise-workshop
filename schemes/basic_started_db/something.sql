CREATE TABLE public.something (
	id int8 NOT NULL,
	code varchar(16) NULL,
	description varchar(1024) NULL,
	name varchar(255) NULL,
	CONSTRAINT something_pkey PRIMARY KEY (id),
	CONSTRAINT uk_fyx02if07tnlum0vogq03shxo UNIQUE (code),
	CONSTRAINT uk_o5isrkqd0ouogudmo66swbfgp UNIQUE (name)
);
