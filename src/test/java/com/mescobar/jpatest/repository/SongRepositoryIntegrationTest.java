package com.mescobar.jpatest.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import com.mescobar.jpatest.entity.Song;

//@RunWith(SpringRunner.class)
@SpringBootTest
@Sql(scripts = { "/test-song-data.sql" })
public class SongRepositoryIntegrationTest {

	 @Autowired 
	 private SongRepository songRepository;

	    @Transactional
	    @Test
	    public void givenSong_WhenFindLikeByName_ThenShouldReturnOne() {
	        List<Song> songs = songRepository.findByNameLike("Despacito");
	        assertEquals(1, songs.size());
	    }

	    @Transactional
	    @Test
	    public void givenSong_WhenFindByNameNotLike_thenShouldReturn3Songs() {
	        List<Song> songs = songRepository.findByNameNotLike("Despacito");
	        assertEquals(5, songs.size());
	    }

	    @Transactional
	    @Test
	    public void givenSong_WhenFindByNameStartingWith_thenShouldReturn2Songs() {
	        List<Song> songs = songRepository.findByNameStartingWith("Co");
	        assertEquals(2, songs.size());
	    }

	    @Transactional
	    @Test
	    public void givenSong_WhenFindByNameEndingWith_thenShouldReturn2Songs() {
	        List<Song> songs = songRepository.findByNameEndingWith("Life");
	        assertEquals(2, songs.size());
	    }

	    @Transactional
	    @Test
	    public void givenSong_WhenFindBySingerContaining_thenShouldReturn2Songs() {
	        List<Song> songs = songRepository.findBySingerContaining("Luis");
	        assertEquals(2, songs.size());
	    }
}
