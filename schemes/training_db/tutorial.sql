CREATE TABLE public.tutorial (
	id int8 NOT NULL,
	title varchar(255) NULL,
	bench_id int8 NULL,
	schedule_id int8 NULL,
	timeline_id int8 NULL,
	CONSTRAINT tutorial_pkey PRIMARY KEY (id),
	CONSTRAINT fklqlqhve4yx435oy8pvj2fb6lo FOREIGN KEY (schedule_id) REFERENCES public.schedule(id),
	CONSTRAINT fkngngpnkiggj4d1lpch7yxh7v5 FOREIGN KEY (timeline_id) REFERENCES public.timeline(id),
	CONSTRAINT fkrfa3whb9baia2oa7u63leellq FOREIGN KEY (bench_id) REFERENCES public.bench(id)
);
