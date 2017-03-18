package com.github.alebabai.ws.endpoint;

import com.github.alebabai.ws.domain.Song;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.*;

import static com.github.alebabai.ws.JerseyApplication.BASE_URI;

@Path("songs")
@Produces(MediaType.APPLICATION_JSON)
public class SongEndpoint {
    private static final Map<Long, Song> SAP_HANA_DB = new LinkedHashMap<>();

    @GET
    public Collection<Song> getSongs() {
        return SAP_HANA_DB.values();
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
        if(Objects.nonNull(song) && Objects.nonNull(song.getId())) {
            SAP_HANA_DB.put(song.getId(), song);
            return Optional.of(song.getId())
                    .filter(SAP_HANA_DB::containsKey)
                    .map(id -> Response.ok().type(MediaType.APPLICATION_JSON_TYPE).entity(song).build())
                    .orElse(Response
                            .created(BASE_URI.resolve(String.format("/songs/%d", song.getId())))
                            .type(MediaType.APPLICATION_JSON_TYPE)
                            .entity(song)
                            .build());

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
    public Response deleteSong(@PathParam("id") Long id){
        return Optional.of(id)
                .filter(SAP_HANA_DB::containsKey)
                .map(it ->{
                    SAP_HANA_DB.remove(id);
                    return Response.ok().build();
                })
                .orElse(Response.status(Response.Status.BAD_REQUEST).build());

    }

}
