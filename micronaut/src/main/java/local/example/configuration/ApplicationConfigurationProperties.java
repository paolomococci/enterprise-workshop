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

package local.example.configuration;

import io.micronaut.context.annotation.ConfigurationProperties;
import io.micronaut.core.annotation.NonNull;
import local.example.configuration.ApplicationConfiguration;

@ConfigurationProperties("application")
public class ApplicationConfigurationProperties
        implements ApplicationConfiguration {

    protected final Integer DEFAULT_MAX = 10;

    @NonNull
    private Integer max = DEFAULT_MAX;

    @NonNull
    @Override
    public Integer getMax() {
        return max;
    }

    public void setMax(@NonNull Integer max) {
        if (this.max != null)
            this.max = max;
    }
}
