package mk.podcast.com.datas.models.impls

import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import io.reactivex.Observable
import mk.podcast.com.datas.vos.DetailEpisodeVO
import mk.podcast.com.datas.vos.RandomPodcastVO
import mk.podcast.com.networks.PodcastApi
import mk.podcast.com.networks.responses.GetBestPodcastResponse
import mk.podcast.com.networks.responses.GetGenericsResponse
import mk.podcast.com.networks.responses.GetPlayListResponse


object RealtimeDatabaseFirebaseApiImpl : PodcastApi {

    private val database: DatabaseReference = Firebase.database.reference
    override fun fetchPlayList(apiKey: String, id: String): Observable<GetPlayListResponse> {
        TODO("Not yet implemented")
    }

    override fun fetchDetailEpisodeByID(apiKey: String, id: String): Observable<DetailEpisodeVO> {
        TODO("Not yet implemented")
    }

    override fun fetchPodcastGenresList(
        apiKey: String,
        top_level_only: Int
    ): Observable<GetGenericsResponse> {
        TODO("Not yet implemented")
    }

    override fun fetchBestPodcastGenresList(
        apiKey: String,
        genre_id: Int,
        page: Int,
        region: String,
        safe_mode: Int
    ): Observable<GetBestPodcastResponse> {
        TODO("Not yet implemented")
    }

    override fun fetchRandomPodcastEpisode(apiKey: String): Observable<RandomPodcastVO> {
        TODO("Not yet implemented")
    }

//    override fun getGroceries(
//        onSuccess: (groceries: List<GroceryVO>) -> Unit,
//        onFialure: (String) -> Unit
//    ) {
//        database.child("groceries").addValueEventListener(object : ValueEventListener {
//            override fun onCancelled(error: DatabaseError) {
//                onFialure(error.message)
//            }
//
//            override fun onDataChange(snapshot: DataSnapshot) {
//                val groceryList = arrayListOf<GroceryVO>()
//                snapshot.children.forEach { dataSnapShot ->
//                    dataSnapShot.getValue(GroceryVO::class.java)?.let {
//                        groceryList.add(it)
//                    }
//                }
//                onSuccess(groceryList)
//            }
//        })
//    }
//
//    override fun addGrocery(name: String, description: String, amount: Int) {
//        database.child("groceries").child(name).setValue(GroceryVO(name,description,amount))
//    }
//
//    override fun deleteGrocery(name: String) {
//        database.child("groceries").child(name).removeValue()
//    }
}