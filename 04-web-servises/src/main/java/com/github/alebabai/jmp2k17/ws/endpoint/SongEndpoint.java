package com.github.alebabai.jmp2k17.ws.endpoint;

import com.github.alebabai.jmp2k17.ws.domain.Song;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.*;
import java.util.stream.Collectors;

import static com.github.alebabai.jmp2k17.ws.JerseyApplication.BASE_URI;

@Path("songs")
@Produces(MediaType.APPLICATION_JSON)
public class SongEndpoint {
    public static final Map<Long, Song> SAP_HANA_DB = new LinkedHashMap<>();

    @GET
    @Consumes(MediaType.TEXT_PLAIN)
    public Collection<Song> getSortedSongs(@QueryParam("sort") @DefaultValue("") String sort) {
        Collection<Song> result;
        switch (sort.toLowerCase()) {
            case "asc":
                result = SAP_HANA_DB.values()
                        .stream()
                        .sorted(Comparator.comparing(Song::getId))
                        .collect(Collectors.toList());
                break;
            case "desc":
                result = SAP_HANA_DB.values()
                        .stream()
                        .sorted((song1, song2) -> song2.getId().compareTo(song1.getId()))
                        .collect(Collectors.toList());
                break;
            default:
                result = SAP_HANA_DB.values();
                break;
        }
        return result;
    }

    @GET
    @Path("{id}")
    public Song getSong(@PathParam("id") Long id) {
        return Optional.ofNullable(SAP_HANA_DB.get(id))
                .orElseThrow(() -> new NotFoundException(Response
                        .status(Response.Status.NOT_FOUND)
                        .type(MediaType.APPLICATION_JSON_TYPE)
                        .entity("Song not found")
                        .build()));
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response saveSong(Song song) {
        if (Objects.nonNull(song) && Objects.nonNull(song.getId())) {
            final Response response = Optional.of(song.getId())
                    .filter(SAP_HANA_DB::containsKey)
                    .map(id -> Response.ok().type(MediaType.APPLICATION_JSON_TYPE).entity(song).build())
                    .orElse(Response
                            .created(BASE_URI.resolve(String.format("/songs/%d", song.getId())))
                            .type(MediaType.APPLICATION_JSON_TYPE)
                            .entity(song)
                            .build());
            SAP_HANA_DB.put(song.getId(), song);
            return response;

        }
        return Response.status(Response.Status.BAD_REQUEST).type(MediaType.APPLICATION_JSON_TYPE).build();
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateSong(@PathParam("id") Long id, Song song) {
        return Optional.ofNullable(song)
                .map(safeSong -> Optional.of(id)
                        .filter(SAP_HANA_DB::containsKey)
                        .map(safeId -> Response.ok().type(MediaType.APPLICATION_JSON_TYPE).entity(song).build())
                        .orElse(Response.created(BASE_URI.resolve(String.format("/songs/%d", id))).type(MediaType.APPLICATION_JSON_TYPE).entity(song).build()))
                .orElse(Response.status(Response.Status.BAD_REQUEST).build());
    }

    @DELETE
    @Path("{id}")
    public Response deleteSong(@PathParam("id") Long id) {
        return Optional.of(id)
                .filter(SAP_HANA_DB::containsKey)
                .map(it -> {
                    SAP_HANA_DB.remove(id);
                    return Response.ok().build();
                })
                .orElse(Response.status(Response.Status.BAD_REQUEST).build());

    }

}
