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

package local.example.controller;

import io.quarkus.panache.common.Page;

import local.example.model.Book;
import local.example.resource.BookResource;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path(value = "/books")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class BookController {

    @Inject
    BookResource bookResource;

    @GET
    public Response readAll(
            @QueryParam("page") @DefaultValue("0") int page,
            @QueryParam("size") @DefaultValue("50") int size
    ) {
        List<Book> books = bookResource.list(Page.of(page, size), null);
        return Response
                .ok(books)
                .build();
    }

    @GET
    @Path(value = "/{id}")
    public Response read(@PathParam("id") String id) {
        Book book = bookResource.get(Long.valueOf(id));
        return book != null
                ? Response.status(Response.Status.OK).entity(book).build()
                : Response.status(Response.Status.NOT_FOUND).build();
    }

    @POST
    @Transactional
    public Response create(Book bookToCreate) {
        try {
            Book book = bookResource.add(bookToCreate);
            return Response
                    .status(Response.Status.CREATED)
                    .entity(book).build();
        } catch (Exception exception) {
            exception.getMessage();
            return null;
        }
    }

    @DELETE
    @Transactional
    @Path(value = "/{id}")
    public Response delete(@PathParam("id") String id) {
        return !bookResource.delete(Long.valueOf(id))
                ? Response.status(Response.Status.NOT_FOUND).build()
                : Response.status(Response.Status.NO_CONTENT).build();
    }
}
