CREATE TABLE public.bench_tutorial (
	bench_id int8 NOT NULL,
	tutorials_id int8 NOT NULL,
	CONSTRAINT uk_gunrh3ucs8e3xhyu138nrvgbj UNIQUE (tutorials_id),
	CONSTRAINT fk9ap3em5o4a4hv75r454aakc75 FOREIGN KEY (bench_id) REFERENCES public.bench(id),
	CONSTRAINT fke5aqqm57xfgbtfrtbrae44ss FOREIGN KEY (tutorials_id) REFERENCES public.tutorial(id)
);
