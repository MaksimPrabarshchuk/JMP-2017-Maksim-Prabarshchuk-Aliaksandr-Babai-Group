package com.github.alebabai.ws.endpoint;

import com.github.alebabai.ws.JerseyApplication;
import com.github.alebabai.ws.domain.Song;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Path("songs")
@Produces(MediaType.APPLICATION_JSON)
public class SongEndpoint {
    private static final List<Song> songs = new ArrayList<>();

    @GET
    public List<Song> getSongs() {
        return songs;
    }

    @GET
    @Path("{id}")
    public Song getSong(@PathParam("id") Long id) {
        return songs.stream().filter(song -> Objects.equals(id, song.getId()))
                .findFirst()
                .orElseThrow(() -> {
                    final Response response = Response.status(Response.Status.NOT_FOUND).entity("Song not found").build();
                    return new NotFoundException(response);
                });
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response saveSong(Song song) {
        return Optional.ofNullable(song)
                .map(it -> {
                    if (songs.contains(song)) {
                        return Response.status(Response.Status.CONFLICT).entity("Song already exists").build();
                    }
                    songs.add(song);
                    return Response.created(JerseyApplication.BASE_URI.resolve("songs/" + song.getId())).build();
                })
                .orElse(Response.status(Response.Status.BAD_REQUEST).entity("Incorrect song data").build());
    }

}
