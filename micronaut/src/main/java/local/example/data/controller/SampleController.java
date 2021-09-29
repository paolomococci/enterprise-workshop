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

package local.example.data.controller;

import io.micronaut.http.HttpHeaders;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.*;
import io.micronaut.scheduling.TaskExecutors;
import io.micronaut.scheduling.annotation.ExecuteOn;

import local.example.data.model.Sample;
import local.example.data.repository.SampleRepository;
import local.example.data.helper.SampleSave;
import local.example.data.helper.SampleUpdate;
import local.example.data.util.SortingAndOrderArguments;

import javax.persistence.PersistenceException;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@ExecuteOn(TaskExecutors.IO)
@Controller("/samples")
public class SampleController {

    protected final SampleRepository sampleRepository;

    public SampleController(SampleRepository sampleRepository) {
        this.sampleRepository = sampleRepository;
    }

    @Post
    public HttpResponse<Sample> create(@Body @Valid SampleSave sampleSave) {
        Sample sample = this.sampleRepository.save(sampleSave.getCode());
        return HttpResponse.created(sample).headers(
                headers -> headers.location(this.location(sample.getId()))
        );
    }

    @Post(value = "/try")
    public HttpResponse<Sample> tryCreate(@Body @Valid SampleSave sampleSave) {
        try {
            Sample sample = this.sampleRepository.save(sampleSave.getCode());
            return HttpResponse.created(sample).headers(
                    headers -> headers.location(this.location(sample.getId()))
            );
        } catch (PersistenceException persistenceException) {
            return HttpResponse.noContent();
        }
    }

    @Get(value = "/{id}")
    public Sample read(Long id) {
        return this.sampleRepository.findById(id).orElse(null);
    }

    @Get(value = "/list{?sortingAndOrderArguments*}")
    public List<Sample> readAll(@Valid SortingAndOrderArguments sortingAndOrderArguments) {
        return this.sampleRepository.findAll(sortingAndOrderArguments);
    }

    @Put
    public HttpResponse update(@Body @Valid SampleUpdate sampleUpdate) {
        int numberOfSamplesUpdated = this.sampleRepository
                .update(sampleUpdate.getId(), sampleUpdate.getCode());
        return HttpResponse
                .noContent()
                .header(HttpHeaders.LOCATION, location(sampleUpdate.getId()).getPath());
    }

    @Delete(value = "/{id}")
    public HttpResponse delete(Long id) {
        this.sampleRepository.deleteById(id);
        return HttpResponse.noContent();
    }

    protected URI location(Long id) {
        return URI.create("/samples/" + id);
    }

    protected URI location(Sample sample) {
        return this.location(sample.getId());
    }
}
