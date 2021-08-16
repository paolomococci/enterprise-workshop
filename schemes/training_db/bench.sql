CREATE TABLE public.bench (
	id int8 NOT NULL,
	name varchar(255) NULL,
	schedule_id int8 NULL,
	CONSTRAINT bench_pkey PRIMARY KEY (id),
	CONSTRAINT fkfpif08br8uc9wi2y1ubxqmv51 FOREIGN KEY (schedule_id) REFERENCES public.schedule(id)
);
