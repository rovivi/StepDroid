package com.kyagamy.step.room.repos

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.kyagamy.step.room.entities.Song
import com.kyagamy.step.room.entities.SongDao

class SongRepository(private val songDao: SongDao) {

    // Room executes all queries on a separate thread.
    // Observed LiveData will notify the observer when the data has changed.
    val allSong: LiveData<List<Song>> = songDao.getAll()
    fun  categorySong (nameCategory: String):LiveData<List<Song>> {
        return  songDao.getCategory(nameCategory)
    }


    fun  idSong (id:Int):LiveData<List<Song>> {
        return  songDao.loadAllByIds(id)
    }

    fun  deleteAll (){
        songDao.deleteAll()
    }

    suspend fun insert(song: Song) {
         songDao.insert(song)
    }
}