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
        database.child("genres").addValueEventListener(object : ValueEventListener {
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

    override fun getAllEpisodes(
        onSuccess: (playlist: List<EpisodeVO>) -> Unit,
        onFialure: (String) -> Unit
    ) {
        database.child("latest_episodes").addValueEventListener(object : ValueEventListener {
            override fun onCancelled(error: DatabaseError) {
                onFialure(error.message)
            }

            override fun onDataChange(snapshot: DataSnapshot) {

                val playlists = arrayListOf<EpisodeVO>()

                snapshot.children.forEach { dataSnapShot ->
                    dataSnapShot.getValue(EpisodeVO::class.java)?.let {
                        playlists.add(it)
                    }
                }
                onSuccess(playlists)
            }
        })
    }

}