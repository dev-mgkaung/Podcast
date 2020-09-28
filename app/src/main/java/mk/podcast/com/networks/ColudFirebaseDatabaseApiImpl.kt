package mk.podcast.com.networks

import android.util.Log
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.google.gson.Gson
import mk.podcast.com.datas.vos.EpisodeVO
import mk.podcast.com.datas.vos.GenreVO
import mk.podcast.com.datas.vos.PodcastVO

object ColudFirebaseDatabaseApiImpl : FirebaseApi {

    val db = Firebase.firestore
    override fun getCategoryList(
        onSuccess: (podcast: List<GenreVO>) -> Unit,
        onFailure: (String) -> Unit
    ) {
        db.collection("genres")
            .addSnapshotListener { value, error ->
                error?.let {
                    onFailure(it.message ?: "Please check connection")
                } ?: run {
                    val categoryList: MutableList<GenreVO> = arrayListOf()

                    val result = value?.documents ?: arrayListOf()

                    for (document in result) {
                        val data = document.data
                        val category = GenreVO()
                        category.name = data?.get("name") as String
                        category.parent_id = (data["parent_id"] as Long).toInt()
                        category.id = (data["id"] as Long).toInt()
                        categoryList.add(category)
                    }
                    onSuccess(categoryList)
                }
            }

    }

    override fun getAllEpisodes(
        onSuccess: (playlist: List<EpisodeVO>) -> Unit,
        onFailure: (String) -> Unit
    ) {
        db.collection("latest_episodes")
            .addSnapshotListener { value, error ->
                error?.let {
                    onFailure(it.message ?: "Please check connection")
                } ?: run {
                    val episodeList: MutableList<EpisodeVO> = arrayListOf()

                    val result = value?.documents ?: arrayListOf()

                    for (document in result) {
                        val hashmap = document.data
                        hashmap?.put("id", document.id)
                        val Data = Gson().toJson(hashmap)
                        val docsData = Gson().fromJson<EpisodeVO>(Data, EpisodeVO::class.java)
                        episodeList.add(docsData)
                    }

                    onSuccess(episodeList)
                }
            }
    }

}
