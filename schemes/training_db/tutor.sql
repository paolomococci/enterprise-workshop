CREATE TABLE public.tutor (
	id int8 NOT NULL,
	"name" varchar(255) NULL,
	tutorial_id int8 NULL,
	CONSTRAINT tutor_pkey PRIMARY KEY (id),
	CONSTRAINT fklllsfntx73bgssu178w2we1wx FOREIGN KEY (tutorial_id) REFERENCES public.tutorial(id)
);
