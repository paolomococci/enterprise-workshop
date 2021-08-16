CREATE TABLE public.schedule_timeline (
	schedule_id int8 NOT NULL,
	timelines_id int8 NOT NULL,
	CONSTRAINT uk_j46gn9vcelkkwy7cge0gxx5s UNIQUE (timelines_id),
	CONSTRAINT fke0reekaukmn68f6w8orqfhs9x FOREIGN KEY (schedule_id) REFERENCES public.schedule(id),
	CONSTRAINT fkow69oiy2uepoe5upm6m2suavw FOREIGN KEY (timelines_id) REFERENCES public.timeline(id)
);
