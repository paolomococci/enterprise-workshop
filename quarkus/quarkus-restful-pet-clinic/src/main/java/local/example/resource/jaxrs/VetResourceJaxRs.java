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

import local.example.model.Vet;
import local.example.resource.VetResource;

import org.jboss.resteasy.annotations.jaxrs.PathParam;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path(value = "/rest-vet")
public class VetResourceJaxRs {

    @Inject
    VetResource vetResource;

    @GET
    @Path(value = "/vets")
    @Produces(MediaType.APPLICATION_JSON)
    public Response readAll() {
        // TODO
        return Response
                .status(Response.Status.OK)
                .build();
    }

    @POST
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(Vet vet) {
        return null;
    }

    @GET
    @Path(value = "/rest-vet/vets/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response read(@PathParam("id") String id) {
        Vet vet = vetResource.get(Long.valueOf(id));
        return vet != null
                ? Response.status(Response.Status.OK).entity(vet).build()
                : Response.status(Response.Status.NOT_FOUND).build();
    }

    @PUT
    @Transactional
    @Path(value = "{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response update(@PathParam("id") String id, Vet vet) {
        return null;
    }

    @DELETE
    @Transactional
    @Path(value = "{id}")
    public Response delete(@PathParam("id") String id) {
        return null;
    }
}
