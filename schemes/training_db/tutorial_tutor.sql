CREATE TABLE public.tutorial_tutor (
	tutorial_id int8 NOT NULL,
	tutors_id int8 NOT NULL,
	CONSTRAINT uk_qcvscui9giv536pfb5u3wqfq5 UNIQUE (tutors_id),
	CONSTRAINT fk8d15ugowiy64ylbigyt27hp4e FOREIGN KEY (tutors_id) REFERENCES public.tutor(id),
	CONSTRAINT fkf2d4qvvyrc5wgovmb63emgaev FOREIGN KEY (tutorial_id) REFERENCES public.tutorial(id)
);
