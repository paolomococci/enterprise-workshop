CREATE TABLE public.audience_hearer (
	audience_id int8 NOT NULL,
	listeners_id int8 NOT NULL,
	CONSTRAINT uk_d388fqocld4sgki7rpf0ssn46 UNIQUE (listeners_id),
	CONSTRAINT fk3juplm9m8grr88um054ml6q6k FOREIGN KEY (listeners_id) REFERENCES public.hearer(id),
	CONSTRAINT fkkaspe2mr2mqiolkt43jwimdne FOREIGN KEY (audience_id) REFERENCES public.audience(id)
);
