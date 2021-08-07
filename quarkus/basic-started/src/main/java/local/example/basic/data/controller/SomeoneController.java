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

package local.example.basic.data.controller;

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
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.jboss.logging.Logger;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import local.example.basic.data.model.Someone;
import local.example.basic.data.repository.SomeoneRepository;

@Path("somes")
@ApplicationScoped
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class SomeoneController {

	@Inject
	SomeoneRepository someoneRepository;

	@Provider
	public static class ErrorMapper 
			implements ExceptionMapper<Exception> {

		@Inject
		ObjectMapper objectMapper;

		private static final Logger LOGGER = Logger.getLogger(SomeoneController.class.getName());

		@GET
		public Response readAll() {
			// TODO
			return null;
		}

		@GET
		@Path("{id}")
		public Response read(@PathParam Long id) {
			// TODO
			return null;
		}

		@POST
		@Transactional
		public Response create(Someone someone) {
			// TODO
			return null;	
		}

		@PUT
		@Path("{id}")
		@Transactional
		public Response update(@PathParam Long id, Someone someoneUpdated) {
			// TODO
			return null;
		}

		@PATCH
		@Path("{id}")
		@Transactional
		public Response partialUpdate(@PathParam Long id, Someone someoneUpdated) {
			// TODO
			return null;
		}

		@PATCH
		@Path("/update/email/{email}")
		@Transactional
		public Response partialUpdateByEmail(@PathParam("email") String email, Someone someoneUpdated) {
			// TODO
			return null;
		}

		@DELETE
		@Path("{id}")
		@Transactional
		public Response delete(@PathParam Long id) {
			// TODO
			return null;
		}

		@DELETE
		@Path("/delete/email/{email}")
		@Transactional
		public Response deleteByEmail(@PathParam("email") String email) {
			// TODO
			return null;
		}

		@GET
		@Path("/email/{email}")
		public Response searchByEmail(@PathParam("email") String email) {
			// TODO
			return null;
		}

		@GET
		@Path("/phone/{phone}")
		public Response searchByPhone(@PathParam("phone") String phone) {
			// TODO
			return null;
		}

		@GET
		@Path("/count")
		public Response count() {
			// TODO
			return null;
		}

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
