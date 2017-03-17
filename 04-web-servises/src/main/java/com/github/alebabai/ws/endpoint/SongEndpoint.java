package com.github.alebabai.ws.endpoint;

import com.github.alebabai.ws.domain.Song;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

@Path("songs")
@Produces(MediaType.APPLICATION_JSON)
public class SongEndpoint {
    private static final List<Song> songs = new ArrayList<>();

    @GET
    public List<Song> getSongs() {
        return songs;
    }
}
