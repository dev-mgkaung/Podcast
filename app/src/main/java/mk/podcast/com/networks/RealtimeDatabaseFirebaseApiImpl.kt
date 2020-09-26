package mk.podcast.com.networks

import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import mk.podcast.com.datas.vos.DetailEpisodeVO
import mk.podcast.com.datas.vos.GenreVO
import mk.podcast.com.datas.vos.PlayListVO
import mk.podcast.com.datas.vos.RandomPodcastVO
import mk.podcast.com.networks.responses.GetPlayListResponse


object RealtimeDatabaseFirebaseApiImpl : FirebaseApi {

    private val database: DatabaseReference = Firebase.database.reference
    override fun getCategoryList(
        onSuccess: (podcast: List<GenreVO>) -> Unit,
        onFialure: (String) -> Unit
    ) {
        database.child("categories").addValueEventListener(object : ValueEventListener {
            override fun onCancelled(error: DatabaseError) {
                onFialure(error.message)
            }

            override fun onDataChange(snapshot: DataSnapshot) {
                val categoryList = arrayListOf<GenreVO>()
                snapshot.children.forEach { dataSnapShot ->
                    dataSnapShot.getValue(GenreVO::class.java)?.let {
                        categoryList.add(it)
                    }
                }
                onSuccess(categoryList)
            }
        })
    }

    override fun getRandomPodcast(
        onSuccess: (podcast: List<RandomPodcastVO>) -> Unit,
        onFialure: (String) -> Unit
    ) {
        database.child("random_podcast").addValueEventListener(object : ValueEventListener {
            override fun onCancelled(error: DatabaseError) {
                onFialure(error.message)
            }

            override fun onDataChange(snapshot: DataSnapshot) {
                val randomPodcast = arrayListOf<RandomPodcastVO>()
                snapshot.children.forEach { dataSnapShot ->
                    dataSnapShot.getValue(RandomPodcastVO::class.java)?.let {
                        randomPodcast.add(it)
                    }
                }
                onSuccess(randomPodcast)
            }
        })
    }

    override fun getPodcatPlayLists(
        onSuccess: (playlist: List<PlayListVO>) -> Unit,
        onFialure: (String) -> Unit
    ) {
        database.child("playlists").addValueEventListener(object : ValueEventListener {
            override fun onCancelled(error: DatabaseError) {
                onFialure(error.message)
            }

            override fun onDataChange(snapshot: DataSnapshot) {
                val playlists = arrayListOf<PlayListVO>()
                snapshot.children.forEach { dataSnapShot ->
                    dataSnapShot.getValue(PlayListVO::class.java)?.let {
                        playlists.add(it)
                    }
                }
                onSuccess(playlists)
            }
        })
    }

    override fun getPodcastDetailById(
        podcastID: String,
        onSuccess: (playlist: List<DetailEpisodeVO>) -> Unit,
        onFialure: (String) -> Unit
    ) {
        TODO("Not yet implemented")
    }


}