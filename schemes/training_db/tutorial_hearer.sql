CREATE TABLE public.tutorial_hearer (
	tutorial_id int8 NOT NULL,
	hearers_id int8 NOT NULL,
	CONSTRAINT uk_b0dojbo2p8twpimlxbrfucy0y UNIQUE (hearers_id),
	CONSTRAINT fk52xcbsitcn86f2exqr3weta4h FOREIGN KEY (tutorial_id) REFERENCES public.tutorial(id),
	CONSTRAINT fkmh0q7oeacmgdqfhhku6jkpv5k FOREIGN KEY (hearers_id) REFERENCES public.hearer(id)
);
