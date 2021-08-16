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

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.optaplanner.core.api.domain.entity.PlanningEntity;
import org.optaplanner.core.api.domain.lookup.PlanningId;
import org.optaplanner.core.api.domain.variable.PlanningVariable;

@Entity
@PlanningEntity
@Table(name = "TUTORIAL")
public class Tutorial {

	@Id
	@PlanningId
	@GeneratedValue
	private Long id;

	private String title;

	@OneToMany
	private List<Hearer> hearers;

	@OneToMany
	private List<Tutor> tutors;

	@ManyToOne
	@PlanningVariable(valueRangeProviderRefs = "benchRange")
	private Bench bench;

	@ManyToOne
	private Schedule schedule;

	@ManyToOne
	@PlanningVariable(valueRangeProviderRefs = "timelineRange")
	private Timeline timeline;

	public Tutorial() {
		super();
	}

	public Long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<Tutor> getTutors() {
		return tutors;
	}

	public void setTutors(List<Tutor> tutors) {
		this.tutors = tutors;
	}

	public List<Hearer> getHearers() {
		return hearers;
	}

	public void setHearers(List<Hearer> hearers) {
		this.hearers = hearers;
	}

	public Bench getBench() {
		return bench;
	}

	public void setBench(Bench bench) {
		this.bench = bench;
	}

	public Schedule getSchedule() {
		return schedule;
	}

	public void setSchedule(Schedule schedule) {
		this.schedule = schedule;
	}

	public Timeline getTimeline() {
		return timeline;
	}

	public void setTimeline(Timeline timeline) {
		this.timeline = timeline;
	}
}
