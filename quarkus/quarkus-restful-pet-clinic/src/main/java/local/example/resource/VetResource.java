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

package local.example.resource;

import io.quarkus.hibernate.orm.rest.data.panache.PanacheRepositoryResource;
import local.example.model.Vet;
import local.example.repository.VetRepository;

import javax.ws.rs.Path;

@Path(value = "/vets")
public interface VetResource
        extends PanacheRepositoryResource<VetRepository, Vet, Long> {
}
