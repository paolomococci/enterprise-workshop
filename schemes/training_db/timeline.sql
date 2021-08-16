CREATE TABLE public.timeline (
	id int8 NOT NULL,
	dayofweek int4 NULL,
	"start" time NULL,
	stop time NULL,
	schedule_id int8 NULL,
	CONSTRAINT timeline_pkey PRIMARY KEY (id),
	CONSTRAINT fk2fm2be9niwjmet2cmxpvm77su FOREIGN KEY (schedule_id) REFERENCES public.schedule(id)
);
