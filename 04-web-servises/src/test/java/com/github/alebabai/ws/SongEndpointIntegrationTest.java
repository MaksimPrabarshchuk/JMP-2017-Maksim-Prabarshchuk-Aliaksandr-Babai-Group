package com.github.alebabai.ws;

import com.github.alebabai.ws.domain.Quote;
import com.github.alebabai.ws.domain.Song;
import com.github.alebabai.ws.domain.Text;
import com.github.alebabai.ws.domain.Verse;
import com.github.alebabai.ws.endpoint.SongEndpoint;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Collections;
import java.util.List;

import static com.github.alebabai.ws.JerseyApplication.createConfig;


@RunWith(JUnit4.class)
public class SongEndpointIntegrationTest extends JerseyTest {

    private static final String PHRASE = "Всё идёт по плану";
    private static final long SONG_ID = 1L;
    private static final Song SONG = new Song(SONG_ID, new Text(Collections.singletonList(new Verse(Collections.singletonList(new Quote(PHRASE))))));

    @After
    public void after() {
        SongEndpoint.SAP_HANA_DB.clear();
    }

    @Override
    protected Application configure() {
        return createConfig();
    }

    @Test
    public void getSongsTest() {
        SongEndpoint.SAP_HANA_DB.put(SONG_ID, SONG);
        final Response response = target("/songs").request().get();
        final List<Song> songs = response.readEntity(new GenericType<List<Song>>() {
        });
        Assert.assertEquals(response.getMediaType(), MediaType.APPLICATION_JSON_TYPE);
        Assert.assertEquals(response.getStatus(), 200);
        Assert.assertEquals(Collections.singletonList(SONG), songs);
    }

    @Test
    public void getSongByIdPositiveTest() {
        SongEndpoint.SAP_HANA_DB.put(SONG_ID, SONG);
        final Response response = target(String.format("/songs/%d", SONG_ID)).request().get();
        final Song song = response.readEntity(Song.class);
        Assert.assertEquals(response.getMediaType(), MediaType.APPLICATION_JSON_TYPE);
        Assert.assertEquals(response.getStatus(), 200);
        Assert.assertEquals(SONG, song);
    }

    @Test
    public void getSongByIdNegativeTest() {
        final Response response = target(String.format("/songs/%d", SONG_ID)).request().get();
        Assert.assertEquals(response.getStatus(), 404);
    }

    @Test
    public void saveNewSongPositiveTest() {
        final Response response = target("/songs").request().post(Entity.entity(SONG, MediaType.APPLICATION_JSON_TYPE));
        final Song song = response.readEntity(Song.class);
        Assert.assertEquals(SONG, song);
        Assert.assertEquals(response.getMediaType(), MediaType.APPLICATION_JSON_TYPE);
        Assert.assertEquals(response.getStatus(), 201);
    }

    @Test
    public void saveExistingSongPositiveTest() {
        SongEndpoint.SAP_HANA_DB.put(SONG_ID, SONG);
        final Response response = target("/songs").request().post(Entity.entity(SONG, MediaType.APPLICATION_JSON_TYPE));
        final Song song = response.readEntity(Song.class);
        Assert.assertEquals(SONG, song);
        Assert.assertEquals(response.getMediaType(), MediaType.APPLICATION_JSON_TYPE);
        Assert.assertEquals(response.getStatus(), 200);
    }

    @Test
    public void saveNewSongNegativeTest() {
        final Response response = target("/songs").request().post(Entity.entity("{}", MediaType.APPLICATION_JSON_TYPE));
        Assert.assertEquals(response.getStatus(), 400);
    }

    @Test
    public void updateExistingSongPositiveTest() {
        SongEndpoint.SAP_HANA_DB.put(SONG_ID, SONG);
        final Response response = target(String.format("/songs/%d", SONG_ID)).request().put(Entity.entity(SONG, MediaType.APPLICATION_JSON_TYPE));
        final Song song = response.readEntity(Song.class);
        Assert.assertEquals(SONG, song);
        Assert.assertEquals(response.getMediaType(), MediaType.APPLICATION_JSON_TYPE);
        Assert.assertEquals(response.getStatus(), 200);
    }

    @Test
    public void updateNewSongPositiveTest() {
        final Response response = target(String.format("/songs/%d", SONG_ID)).request().put(Entity.entity(SONG, MediaType.APPLICATION_JSON_TYPE));
        final Song song = response.readEntity(Song.class);
        Assert.assertEquals(SONG, song);
        Assert.assertEquals(response.getMediaType(), MediaType.APPLICATION_JSON_TYPE);
        Assert.assertEquals(response.getStatus(), 201);
    }

    @Test
    public void updateSongNegativeTest() {
        final Response response = target("/songs").request().post(Entity.entity("{}", MediaType.APPLICATION_JSON_TYPE));
        Assert.assertEquals(response.getStatus(), 400);
    }


    @Test
    public void deleteSongPositiveTest() {
        SongEndpoint.SAP_HANA_DB.put(SONG_ID, SONG);
        final Response response = target(String.format("/songs/%d", SONG_ID)).request().delete();
        Assert.assertEquals(response.getStatus(), 200);
    }

    @Test
    public void deleteSongNegativeTest() {
        final Response response = target(String.format("/songs/%d", SONG_ID)).request().delete();
        Assert.assertEquals(response.getStatus(), 400);
    }
}
