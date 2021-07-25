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

package local.example.user.data.helper;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public abstract class RepositoryHelper<T, ID> {

    protected abstract JpaRepository<T, ID> getRepository ();

    public long count() {
        return getRepository().count();
    }

    public T create(T entity) {
        return getRepository().save(entity);
    }

    public List<T> readAll() {
        return getRepository().findAll();
    }

    public Optional<T> get(ID id) {
        return getRepository().findById(id);
    }

    public T update(T entity) {
        return getRepository().save(entity);
    }

    public Page<T> readAllPageable(Pageable pageable) {
        return getRepository().findAll(pageable);
    }

    public void delete(ID id) {
        getRepository().deleteById(id);
    }
}
