CREATE TABLE public.timeline_tutorial (
	timeline_id int8 NOT NULL,
	tutorials_id int8 NOT NULL,
	CONSTRAINT uk_7cwyqmdquwkmiovd2u4dq66jd UNIQUE (tutorials_id),
	CONSTRAINT fk4m53jttl5c79usklciaytywog FOREIGN KEY (tutorials_id) REFERENCES public.tutorial(id),
	CONSTRAINT fkjec4231ut2s8ekxemahuhtyek FOREIGN KEY (timeline_id) REFERENCES public.timeline(id)
);
