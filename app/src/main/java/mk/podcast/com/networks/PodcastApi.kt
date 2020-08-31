package mk.podcast.com.networks

import io.reactivex.Observable
import mk.padc.themovie.utils.*
import mk.podcast.com.datas.vos.DetailEpisodeVO
import mk.podcast.com.datas.vos.RandomPodcastVO
import mk.podcast.com.networks.responses.GetBestPodcastResponse
import mk.podcast.com.networks.responses.GetGenericsResponse
import mk.podcast.com.networks.responses.GetPlayListResponse
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path
import retrofit2.http.Query

interface PodcastApi {

    /* Fetch a list of podcast genres */
    @GET(GET_GENRE)
    fun fetchPodcastGenresList(
        @Header(API_KEY_PARAM) apiKey: String,
        @Query(TOP_LEVEL_ONLY_PARAM) top_level_only: Int,
    ): Observable<GetGenericsResponse>


    /* Fetch a list of best podcasts by genre */
   @GET(GET_BEST_PODCAST)
   fun fetchBestPodcastGenresList(
       @Header(API_KEY_PARAM) apiKey: String,
       @Query(GENRE_ID_PARAM) genre_id: Int,
       @Query(PAGE_PARAM) page: Int,
       @Query(REGION_PARAM) region: String,
       @Query(SAFE_MODE_PARAM) safe_mode: Int
   ): Observable<GetBestPodcastResponse>

    /* Fetch detailed meta data for an episode by id*/
    @GET(GET_DETAIL)
    fun fetchDetailEpisodeByID(
        @Header(API_KEY_PARAM) apiKey: String,
        @Path(ID_PARAM) id: String,
        ): Observable<DetailEpisodeVO>

    /* Fetch a random podcast episode */
    @GET(GET_JUST_LISTEN)
    fun fetchRandomPodcastEpisode(
        @Header(API_KEY_PARAM) apiKey: String,
    ): Observable<RandomPodcastVO>

    /* Fetch a playlist's info and items (i.e., episodes or podcasts).  id= SgTozE1ZAe3*/
    @GET(GET_PLAYLIST_INFO_AND_ITEM)
    fun fetchPlayList(
        @Header(API_KEY_PARAM) apiKey: String,
        @Path(ID_PARAM) id:String
    ): Observable<GetPlayListResponse>


}