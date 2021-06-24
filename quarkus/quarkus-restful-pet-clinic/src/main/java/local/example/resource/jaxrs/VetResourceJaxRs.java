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

import local.example.model.Vet;
import local.example.resource.VetResource;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

@Path(value = "/rest-vet")
@Consumes("application/json")
@Produces("application/hal+json")
public class VetResourceJaxRs {

    @Inject
    VetResource vetResource;

    @GET
    @Path(value = "/vets")
    public Response readAll(
            @QueryParam("page") @DefaultValue("0") int page,
            @QueryParam("size") @DefaultValue("50") int size
    ) {
        List<Vet> vets = vetResource.list(Page.of(page, size), null);
        return Response.ok(vets).build();
    }

    @POST
    @Transactional
    public Response create(Vet vetToCreate) {
        try {
            Vet vet = vetResource.add(vetToCreate);
            return Response
                    .status(Response.Status.CREATED)
                    .entity(vet).build();
        } catch (Exception exception) {
            exception.getMessage();
            return null;
        }
    }

    @GET
    @Path(value = "/{id}")
    public Response read(@PathParam("id") String id) {
        Vet vet = vetResource.get(Long.valueOf(id));
        return vet != null
                ? Response.status(Response.Status.OK).entity(vet).build()
                : Response.status(Response.Status.NOT_FOUND).build();
    }

    @PUT
    @Transactional
    @Path(value = "{id}")
    public Response update(@PathParam("id") String id, Vet vetToUpdate) {
        try {
            if (vetResource.get(Long.valueOf(id)) == null) {
                Vet vet = vetResource.add(vetToUpdate);
                return Response
                        .status(Response.Status.CREATED)
                        .entity(vet).build();
            } else {
                Vet vet = vetResource.update(Long.valueOf(id), vetToUpdate);
                return Response
                        .status(Response.Status.RESET_CONTENT)
                        .entity(vet).build();
            }
        } catch (Exception exception) {
            exception.getMessage();
            return null;
        }
    }

    @DELETE
    @Transactional
    @Path(value = "{id}")
    public Response delete(@PathParam("id") String id) {
        return !vetResource.delete(Long.valueOf(id))
                ? Response.status(Response.Status.NO_CONTENT).build()
                : Response.status(Response.Status.NOT_FOUND).build();
    }
}
