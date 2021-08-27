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

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.optaplanner.core.api.domain.solution.PlanningEntityCollectionProperty;
import org.optaplanner.core.api.domain.solution.PlanningScore;
import org.optaplanner.core.api.domain.solution.PlanningSolution;
import org.optaplanner.core.api.domain.solution.ProblemFactCollectionProperty;
import org.optaplanner.core.api.domain.valuerange.ValueRangeProvider;
import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore;
import org.optaplanner.core.api.solver.SolverStatus;

@Entity
@PlanningSolution
@Table(name = "SCHEDULE")
public class Schedule {

	@Id
	@GeneratedValue
	private Long id;

	@Column(nullable = true, unique = true)
	private String name;

	@Transient
	@PlanningScore
	private HardSoftScore hardSoftScore;

	@Transient
	private SolverStatus solverStatus;

	@OneToMany
	@ProblemFactCollectionProperty
	@ValueRangeProvider(id = "benchRange")
	private List<Bench> benchs;

	@OneToMany
	@ProblemFactCollectionProperty
	@ValueRangeProvider(id = "timelineRange")
	private List<Timeline> timelines;

	@OneToMany
	@PlanningEntityCollectionProperty
	private List<Tutorial> tutorials;

	public Schedule() {
		super();
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public HardSoftScore getHardSoftScore() {
		return hardSoftScore;
	}

	public SolverStatus getSolverStatus() {
		return solverStatus;
	}

	public List<Bench> getBenchs() {
		return benchs;
	}

	public List<Timeline> getTimelines() {
		return timelines;
	}

	public List<Tutorial> getTutorials() {
		return tutorials;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setHardSoftScore(HardSoftScore hardSoftScore) {
		this.hardSoftScore = hardSoftScore;
	}

	public void setSolverStatus(SolverStatus solverStatus) {
		this.solverStatus = solverStatus;
	}

	public void setBenchs(List<Bench> benchs) {
		this.benchs = benchs;
	}

	public void setTimelines(List<Timeline> timelines) {
		this.timelines = timelines;
	}

	public void setTutorials(List<Tutorial> tutorials) {
		this.tutorials = tutorials;
	}
}
