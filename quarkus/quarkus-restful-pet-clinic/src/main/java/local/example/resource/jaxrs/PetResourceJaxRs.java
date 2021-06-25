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

package local.example.resource.jaxrs;

import io.quarkus.panache.common.Page;

import local.example.model.Pet;
import local.example.resource.PetResource;

//import org.jboss.resteasy.annotations.jaxrs.PathParam;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

@Path(value = "/rest-pet")
@Consumes("application/json")
@Produces("application/hal+json")
public class PetResourceJaxRs {

    @Inject
    PetResource petResource;

    @GET
    @Path(value = "/pets")
    public Response readAll(
            @QueryParam("page") @DefaultValue("0") int page,
            @QueryParam("size") @DefaultValue("50") int size
    ) {
        List<Pet> pets = petResource.list(Page.of(page, size), null);
        return Response.ok(pets).build();
    }

    @POST
    @Transactional
    public Response create(Pet petToCreate) {
        try {
            Pet pet = petResource.add(petToCreate);
            return Response
                    .status(Response.Status.CREATED)
                    .entity(pet).build();
        } catch (Exception exception) {
            exception.getMessage();
            return null;
        }
    }

    @GET
    @Path(value = "/{id}")
    public Response read(@PathParam("id") String id) {
        Pet pet = petResource.get(Long.valueOf(id));
        return pet != null
                ? Response.status(Response.Status.OK).entity(pet).build()
                : Response.status(Response.Status.NOT_FOUND).build();
    }

    @PUT
    @Transactional
    @Path(value = "/{id}")
    public Response update(@PathParam("id") String id, Pet petToUpdate) {
        try {
            if (petResource.get(Long.valueOf(id)) == null) {
                Pet pet = petResource.add(petToUpdate);
                return Response
                        .status(Response.Status.CREATED)
                        .entity(pet).build();
            } else {
                Pet pet = petResource.update(Long.valueOf(id), petToUpdate);
                return Response
                        .status(Response.Status.RESET_CONTENT)
                        .entity(pet).build();
            }
        } catch (Exception exception) {
            exception.getMessage();
            return null;
        }
    }

    @DELETE
    @Transactional
    @Path(value = "/{id}")
    public Response delete(@PathParam("id") String id) {
        return !petResource.delete(Long.valueOf(id))
                ? Response.status(Response.Status.NOT_FOUND).build()
                : Response.status(Response.Status.NO_CONTENT).build();
    }
}
