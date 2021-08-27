/**
 *
 * Copyright 2021 paolo mococci
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * 	   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed following in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package local.example.data.model;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.optaplanner.core.api.domain.lookup.PlanningId;

@Entity
@Table(name = "TIMELINE")
public class Timeline {

	@Id
	@PlanningId
	@GeneratedValue
	private Long id;

	private String label;

	private DayOfWeek dayOfWeek;

	private LocalTime start;
	private LocalTime stop;

	@ManyToOne
	private Schedule schedule;

	@OneToMany
	private List<Tutorial> tutorials;

	public Timeline() {
		super();
	}

	public Long getId() {
		return id;
	}

	public String getLabel() {
		return label;
	}

	public DayOfWeek getDayOfWeek() {
		return dayOfWeek;
	}

	public LocalTime getStart() {
		return start;
	}

	public LocalTime getStop() {
		return stop;
	}

	public Schedule getSchedule() {
		return schedule;
	}

	public List<Tutorial> getTutorials() {
		return tutorials;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public void setDayOfWeek(DayOfWeek dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
	}

	public void setStart(LocalTime start) {
		this.start = start;
	}

	public void setStop(LocalTime stop) {
		this.stop = stop;
	}

	public void setSchedule(Schedule schedule) {
		this.schedule = schedule;
	}

	public void setTutorials(List<Tutorial> tutorials) {
		this.tutorials = tutorials;
	}
}
