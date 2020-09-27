package mk.podcast.com.networks

import android.content.ContentValues.TAG
import android.util.Log
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
                val randomPodcast = RandomPodcastVO()
                for (dataSnapShot in snapshot.getChildren())  //--> At this point, ds is an iterator of dataSnapshot; it will iterate the dataSnapshot's children. In this case, the first child's type is String, thus the first iteration of ds will have a type of String.
                {
                    randomPodcast.id = dataSnapShot.child("id").getValue(String::class.java)
                    randomPodcast.audio = dataSnapShot.child("audio").getValue(String::class.java)
                    randomPodcast.image =
                        dataSnapShot.child("thumbnail").getValue(String::class.java)
                    randomPodcast.title = dataSnapShot.child("title").getValue(String::class.java)
                    randomPodcast.description =
                        dataSnapShot.child("description").getValue(String::class.java)
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

                for (dataSnapShot in snapshot.getChildren()) {
                    println("data=" + dataSnapShot.value)

                    val entity = PlayListVO()
                    entity.id = dataSnapShot.child("id").getValue(Long::class.java)?.toInt()
                    entity.added_at_ms =
                        dataSnapShot.child("added_at_ms").getValue(Long::class.java)

                    entity.data = dataSnapShot.child("data").getValue(DataVO::class.java)

                    playlists.add(entity)
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