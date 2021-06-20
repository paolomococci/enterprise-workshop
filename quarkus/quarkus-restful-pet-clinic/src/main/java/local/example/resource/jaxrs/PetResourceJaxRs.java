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

import local.example.model.Pet;
import local.example.resource.PetResource;

import org.jboss.resteasy.annotations.jaxrs.PathParam;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path(value = "/rest-pet")
public class PetResourceJaxRs {

    @Inject
    PetResource petResource;

    @GET
    @Path(value = "/pets")
    @Produces(MediaType.APPLICATION_JSON)
    public Response readAll() {
        // TODO
        return Response
                .status(Response.Status.OK)
                .build();
    }

    @GET
    @Path(value = "/rest-pet/pets/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response read(@PathParam("id") String id) {
        Pet pet = petResource.get(Long.valueOf(id));
        return pet != null
                ? Response.status(Response.Status.OK).entity(pet).build()
                : Response.status(Response.Status.NOT_FOUND).build();
    }
}
