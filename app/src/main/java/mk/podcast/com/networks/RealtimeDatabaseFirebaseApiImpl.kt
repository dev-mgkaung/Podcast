package mk.podcast.com.networks

import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import mk.podcast.com.datas.vos.*


object RealtimeDatabaseFirebaseApiImpl : FirebaseApi {

    private val database: DatabaseReference = Firebase.database.reference
    override fun getCategoryList(
        onSuccess: (podcast: List<GenreVO>) -> Unit,
        onFialure: (String) -> Unit
    ) {
        ;
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
        onSuccess: (podcast: RandomPodcastVO) -> Unit,
        onFialure: (String) -> Unit
    ) {
        database.child("random_podcast").addValueEventListener(object : ValueEventListener {
            override fun onCancelled(error: DatabaseError) {
                onFialure(error.message)
            }

            override fun onDataChange(snapshot: DataSnapshot) {
                var randomPodcast = RandomPodcastVO()
                snapshot.children.forEach { dataSnapShot ->
                    dataSnapShot.getValue(RandomPodcastVO::class.java)?.let {
                        randomPodcast = it
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
        onSuccess: (detail: DetailEpisodeVO) -> Unit,
        onFialure: (String) -> Unit
    ) {

        database.child("details").addValueEventListener(object : ValueEventListener {
            override fun onCancelled(error: DatabaseError) {
                onFialure(error.message)
            }

            override fun onDataChange(snapshot: DataSnapshot) {

                var detail = DetailEpisodeVO()
                for (dataSnapShot in snapshot.getChildren()) {
                    if (podcastID == dataSnapShot.key) {
                        detail = dataSnapShot.child("data").getValue(DetailEpisodeVO::class.java)!!
                        break
                    }
                }
                onSuccess(detail)
            }
        })
    }


}