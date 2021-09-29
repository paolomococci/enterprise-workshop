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

import io.micronaut.transaction.annotation.ReadOnly;
import local.example.configuration.ApplicationConfiguration;
import local.example.data.util.SortingAndOrderArguments;
import local.example.data.model.Sample;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class SampleRepositoryImpl
        implements SampleRepository {

    private final EntityManager entityManager;
    private final ApplicationConfiguration applicationConfiguration;
    private final static List<String> VALID_PROPERTY_NAMES = Arrays.asList("id", "code");

    public SampleRepositoryImpl(
            EntityManager entityManager,
            ApplicationConfiguration applicationConfiguration
    ) {
        this.entityManager = entityManager;
        this.applicationConfiguration = applicationConfiguration;
    }

    @Override
    @ReadOnly
    public Optional<Sample> findById(@NotNull Long id) {
        return Optional.ofNullable(entityManager.find(Sample.class, id));
    }

    @Override
    @ReadOnly
    public List<Sample> findAll(@NotNull SortingAndOrderArguments sortingAndOrderArguments) {
        String queryString = "select s from sample as s";
        if (sortingAndOrderArguments.getOrder().isPresent() &&
                sortingAndOrderArguments.getSort().isPresent() &&
                VALID_PROPERTY_NAMES.contains(sortingAndOrderArguments.getSort().get())) {
            queryString += " order by s." +
                    sortingAndOrderArguments.getSort().get() +
                    " " +
                    sortingAndOrderArguments.getOrder().get().toLowerCase();
        }
        TypedQuery<Sample> sampleTypedQuery = this.entityManager.createQuery(queryString, Sample.class);
        sampleTypedQuery
                .setMaxResults(sortingAndOrderArguments.getMax()
                        .orElseGet(applicationConfiguration::getMax));
        sortingAndOrderArguments.getOffset().ifPresent(sampleTypedQuery::setFirstResult);
        return sampleTypedQuery.getResultList();
    }

    @Override
    @Transactional
    public Sample save(@NotBlank String code) {
        Sample sample = new Sample(code);
        this.entityManager.persist(sample);
        return sample;
    }

    @Override
    @Transactional
    public Sample saveWithException(@NotBlank String code) {
        this.save(code);
        throw new PersistenceException();
    }

    @Override
    @Transactional
    public int update(@NotNull Long id, @NotBlank String code) {
        return this.entityManager
                .createQuery("update sample s set code = :code where id = :id")
                .setParameter("code", code)
                .setParameter("id", id)
                .executeUpdate();
    }

    @Override
    @Transactional
    public void deleteById(@NotNull Long id) {
        findById(id).ifPresent(this.entityManager::remove);
    }
}
