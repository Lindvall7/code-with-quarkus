package org.linden;

import jakarta.inject.Inject;
import jakarta.validation.constraints.Min;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriInfo;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.linden.Flashcard;
import org.linden.FlashcardService;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import static jakarta.ws.rs.core.MediaType.APPLICATION_JSON;
import static jakarta.ws.rs.core.MediaType.TEXT_PLAIN;

@Path("/api/flashcards")
@Produces(APPLICATION_JSON)
@Consumes(APPLICATION_JSON)
public class FlashcardResource {

    @Inject
    FlashcardService flashcardService;

    @Inject
    UriInfo uriInfo;

    // microprofile OpenAPI documentation annotation
    @Operation(summary = "Returns all flashcards")
    @APIResponse(responseCode = "204", description = "No flashcards found")
    @APIResponse(responseCode = "200", description = "Flashcards found",
            content = @Content(mediaType = APPLICATION_JSON,
            schema = @Schema(implementation = Flashcard.class, type = SchemaType.ARRAY)))

    @GET
    public Response getFlashcards() {
        List<Flashcard> flashcards = flashcardService.findAll(); // get all flashcards
        if (flashcards.isEmpty()) {
            return Response.noContent().build();
        } else {
            return Response.ok(flashcards).build();
        }
    }

    @Operation(summary = "Returns a flashcard by specifying its id")

    @GET
    @Path("/{id}")
    public Response getFlashcard(@PathParam("id") @Min(1) Long id) {
        Flashcard flashcard = flashcardService.find(id);
        if (flashcard == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        } else {
            return Response.ok(flashcard).build();
        }
    }

    @Operation(summary = "Returns the total number of added flashcards")

    @GET
    @Path("/count")
    @Produces(TEXT_PLAIN)
    public Response countFlashcards() {
        Long nbOfFlashcards = flashcardService.countAll();

        if (nbOfFlashcards == 0) {
            return Response.noContent().build();
        } else {
            return Response.ok(nbOfFlashcards).build();
        }
    }

    @Operation(summary = "Creates a new flashcard")

    @POST
    public Response createFlashcard(Flashcard flashcard) throws URISyntaxException {
        flashcard = flashcardService.create(flashcard);
        URI createdURI = uriInfo.getAbsolutePathBuilder().path(flashcard.getId().toString()).build();
        return Response.created(createdURI).entity(flashcard).build();
    }

    @Operation(summary = "Removes a flashcard")

    @DELETE
    @Path("/{id}")
    public Response deleteFlashcard(@PathParam("id") @Min(1) Long id) {
        flashcardService.delete(id);
        return Response.noContent().build();
    }

    // POST create flashcard exercise

    // GET get flashcard exercise

    // DELETE remove flashcard exercise

}
