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

package local.example.solver;

import org.optaplanner.core.api.score.stream.Constraint;
import org.optaplanner.core.api.score.stream.ConstraintFactory;
import org.optaplanner.core.api.score.stream.ConstraintProvider;

public class ScheduleSolver 
		implements ConstraintProvider {

	Constraint tutorHardConstraint(ConstraintFactory constraintFactory ) {
		// TODO
		return constraintFactory
				.fromUniquePair(null)
				.penalize(null, null);
	}

	Constraint hearerHardConstraint(ConstraintFactory constraintFactory ) {
		// TODO
		return constraintFactory
				.fromUniquePair(null)
				.penalize(null, null);
	}

	Constraint benchHardConstraint(ConstraintFactory constraintFactory ) {
		// TODO
		return constraintFactory
				.fromUniquePair(null)
				.penalize(null, null);
	}

	Constraint tutorialsSoftConstraint(ConstraintFactory constraintFactory ) {
		// TODO
		return constraintFactory
				.fromUniquePair(null)
				.penalize(null, null);
	}

	Constraint tutorBenchSoftConstraint(ConstraintFactory constraintFactory ) {
		// TODO
		return constraintFactory
				.fromUniquePair(null)
				.penalize(null, null);
	}

	Constraint tutorScheduleSoftConstraint(ConstraintFactory constraintFactory ) {
		// TODO
		return constraintFactory
				.fromUniquePair(null)
				.penalize(null, null);
	}

	@Override
	public Constraint[] defineConstraints(ConstraintFactory constraintFactory) {
		return new Constraint[] {};
	}
}
