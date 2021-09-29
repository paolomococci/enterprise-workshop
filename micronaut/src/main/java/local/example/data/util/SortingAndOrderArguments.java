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

package local.example.data.util;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.core.annotation.Nullable;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import java.util.Optional;

@Introspected
public class SortingAndOrderArguments {

    @Nullable
    @PositiveOrZero
    private Integer offset;

    @Nullable
    @Positive
    private Integer max;

    @Nullable
    @Pattern(regexp = "id|code")
    private String sort;

    @Nullable
    @Pattern(regexp = "asc|ASC|desc|DESC")
    private String order;

    public SortingAndOrderArguments() {
    }

    @Nullable
    public Optional<Integer> getOffset() {
        return Optional.ofNullable(this.offset);
    }

    public void setOffset(@Nullable Integer offset) {
        this.offset = offset;
    }

    @Nullable
    public Optional<Integer> getMax() {
        return Optional.ofNullable(this.max);
    }

    public void setMax(@Nullable Integer max) {
        this.max = max;
    }

    @Nullable
    public Optional<String> getSort() {
        return Optional.ofNullable(this.sort);
    }

    public void setSort(@Nullable String sort) {
        this.sort = sort;
    }

    @Nullable
    public Optional<String> getOrder() {
        return Optional.ofNullable(this.order);
    }

    public void setOrder(@Nullable String order) {
        this.order = order;
    }
}
