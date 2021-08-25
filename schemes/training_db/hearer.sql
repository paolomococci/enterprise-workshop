CREATE TABLE public.hearer (
	id int8 NOT NULL,
	"name" varchar(255) NULL,
	audience_id int8 NULL,
	tutorial_id int8 NULL,
	CONSTRAINT hearer_pkey PRIMARY KEY (id),
	CONSTRAINT fk3ymgakf1pfk1wpmpfate1gvqg FOREIGN KEY (tutorial_id) REFERENCES public.tutorial(id),
	CONSTRAINT fkparoj6fpxhphvpdlwf5292qjl FOREIGN KEY (audience_id) REFERENCES public.audience(id)
);
