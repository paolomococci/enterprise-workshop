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

package local.example.basic.data.resource;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PATCH;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.jboss.logging.Logger;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import io.quarkus.panache.common.Sort;
import local.example.basic.data.model.Something;
import local.example.basic.error.RestApplicationException;

@Path("things")
@ApplicationScoped
@Produces("application/json")
@Consumes("application/json")
public class SomethingResource {

	private static final Logger LOGGER = Logger.getLogger(SomethingResource.class.getName());

	@GET
	public List<Something> readAll() {
		return Something.listAll(Sort.by("code"));
	}

	@GET
	@Path("{id}")
	public Response read(@PathParam Long id) {
		try {
			Something something = Something.findById(id);
			if (something == null)
				throw new RestApplicationException("thing with id: " + id + " not found", 404);
			return Response.ok(something).status(200).build();
		} catch (RestApplicationException restApplicationException) {
			// Not Found
			return Response.ok(null).status(restApplicationException.getResponse().getStatus()).build();
		}
	}

	@POST
	@Transactional
	public Response create(Something something) {
		try {
			if (something.id != null)
				throw new WebApplicationException("entity already registered in the system", 422);
			something.persist();
			return Response.ok(something).status(201).build();
		} catch (WebApplicationException webApplicationException) {
			// Unprocessable Entity
			return Response.ok(null).status(webApplicationException.getResponse().getStatus()).build();
		}		
	}

	@PUT
	@Path("{id}")
	@Transactional
	public Response update(@PathParam Long id, Something somethingUpdated) {
		try {
			if (
					somethingUpdated.getCode() == null || 
					somethingUpdated.getName() == null || 
					somethingUpdated.getDescription() == null	
				)
				throw new WebApplicationException("one or more fields of the entity have not been set", 422);
			Something somethingAlreadyRegistered = Something.findById(id);
			if (somethingAlreadyRegistered == null)
				throw new WebApplicationException("thing with id: " + id + " not found", 404);
			somethingAlreadyRegistered.setCode(somethingUpdated.getCode());
			somethingAlreadyRegistered.setName(somethingUpdated.getName());
			somethingAlreadyRegistered.setDescription(somethingUpdated.getDescription());
			return Response.ok(somethingAlreadyRegistered).status(200).build();
		} catch (WebApplicationException webApplicationException) {
			// Not Found or Unprocessable Entity
			return Response.ok(null).status(webApplicationException.getResponse().getStatus()).build();
		}
	}

	@PATCH
	@Path("{id}")
	@Transactional
	public Response partialUpdate(@PathParam Long id, Something somethingUpdated) {
		try {
			Something somethingAlreadyRegistered = Something.findById(id);
			if (somethingAlreadyRegistered == null)
				throw new WebApplicationException("thing with id: " + id + " not found", 404);
			if (somethingUpdated.getCode() != null)
				somethingAlreadyRegistered.setCode(somethingUpdated.getCode());
			if (somethingUpdated.getName() != null)
				somethingAlreadyRegistered.setName(somethingUpdated.getName());
			if (somethingUpdated.getDescription() != null)
				somethingAlreadyRegistered.setDescription(somethingUpdated.getDescription());
			return Response.ok(somethingAlreadyRegistered).status(200).build();
		} catch (WebApplicationException webApplicationException) {
			// Not Found
			return Response.ok(null).status(webApplicationException.getResponse().getStatus()).build();
		}
	}

	@DELETE
	@Path("{id}")
	@Transactional
	public Response delete(@PathParam Long id) {
		try {
			Something something = Something.findById(id);
			if (something == null)
				throw new WebApplicationException("thing with id: " + id + " not found", 404);
			something.delete();
			return Response.status(204).build();
		} catch (WebApplicationException webApplicationException) {
			// Not Found
			return Response.ok(null).status(webApplicationException.getResponse().getStatus()).build();
		}
	}

	@Provider
	public static class ErrorMapper 
			implements ExceptionMapper<Exception> {

		@Inject
		ObjectMapper objectMapper;

		@Override
		public Response toResponse(Exception exception) {
			LOGGER.error("failed to handle request", exception);
			int code = 500;
			if (exception instanceof WebApplicationException)
				code = ((WebApplicationException) exception).getResponse().getStatus();
			ObjectNode objectNode = objectMapper.createObjectNode();
			objectNode.put("exceptionType", exception.getClass().getName());
			objectNode.put("code", code);
			if (exception.getMessage() != null)
				objectNode.put("error", exception.getMessage());
			return Response.status(code).entity(objectNode).build();
		}		
	}
}
