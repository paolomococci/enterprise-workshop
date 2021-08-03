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

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
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
	public Something read(@PathParam Long id) {
		Something something = Something.findById(id);
		if (something == null)
			throw new WebApplicationException("Thing with id: " + id + " not found", 404);
		return something;
	}

	@Provider
	public static class ErrorMapper implements ExceptionMapper<Exception> {

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
