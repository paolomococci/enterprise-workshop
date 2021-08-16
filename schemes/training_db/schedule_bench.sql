CREATE TABLE public.schedule_bench (
	schedule_id int8 NOT NULL,
	benchs_id int8 NOT NULL,
	CONSTRAINT uk_s7ilv9x7vgfuemjjp9onfcoqw UNIQUE (benchs_id),
	CONSTRAINT fk17i6qxxxhmby23v87jwnn5qow FOREIGN KEY (benchs_id) REFERENCES public.bench(id),
	CONSTRAINT fkto374sl8n46pcy3v49mc9c538 FOREIGN KEY (schedule_id) REFERENCES public.schedule(id)
);
