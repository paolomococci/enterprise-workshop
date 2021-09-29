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

package local.example.data.repository;

import local.example.data.util.SortingAndOrderArguments;
import local.example.data.model.Sample;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

public interface SampleRepository {

    Optional<Sample> findById(@NotNull Long id);

    List<Sample> findAll(@NotNull SortingAndOrderArguments sortingAndOrderArguments);

    Sample save(@NotBlank String code);

    Sample saveWithException(@NotBlank String code);

    int update(@NotNull Long id, @NotBlank String code);

    void deleteById(@NotNull Long id);
}
