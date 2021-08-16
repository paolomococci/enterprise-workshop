CREATE TABLE public.schedule_tutorial (
	schedule_id int8 NOT NULL,
	tutorials_id int8 NOT NULL,
	CONSTRAINT uk_8joba7ng8syqxg91wpmwkprie UNIQUE (tutorials_id),
	CONSTRAINT fkouoif7vqcl6lrf294fnhg98g8 FOREIGN KEY (tutorials_id) REFERENCES public.tutorial(id),
	CONSTRAINT fktbruody0y9y7o0pra2j7rtptk FOREIGN KEY (schedule_id) REFERENCES public.schedule(id)
);
