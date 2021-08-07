CREATE TABLE public.someone (
	id int8 NOT NULL,
	email varchar(255) NOT NULL,
	"name" varchar(64) NOT NULL,
	phone varchar(64) NOT NULL,
	surname varchar(64) NOT NULL,
	CONSTRAINT someone_pkey PRIMARY KEY (id),
	CONSTRAINT uk_8d661ibgubljxalyx0sf0bbg UNIQUE (phone),
	CONSTRAINT uk_icn2eejc9d8eu6p820u4yc0no UNIQUE (email)
);
