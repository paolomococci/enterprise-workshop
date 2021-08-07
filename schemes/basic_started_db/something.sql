CREATE TABLE public.something (
	id int8 NOT NULL,
	code varchar(16) NOT NULL,
	description text NULL,
	"name" varchar(255) NOT NULL,
	someone_id int8 NULL,
	CONSTRAINT something_pkey PRIMARY KEY (id),
	CONSTRAINT uk2114k13novxv2bfgs8gkb41lo UNIQUE (code, name),
	CONSTRAINT uk_fyx02if07tnlum0vogq03shxo UNIQUE (code),
	CONSTRAINT uk_o5isrkqd0ouogudmo66swbfgp UNIQUE (name),
	CONSTRAINT fkp94t22ugr8j79lr86m0mdwuh1 FOREIGN KEY (someone_id) REFERENCES public.someone(id)
);
