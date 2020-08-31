package mk.padc.themovie.utils

import mk.podcast.com.BuildConfig

const val BASE_URL = BuildConfig.BASE_URL_FIELD
const val DATABASE_NAME="Podcast.DB"

//End points
const val GET_GENRE = "genres"
const val GET_BEST_PODCAST= "best_podcasts"
const val GET_DETAIL ="episodes/{id}"
const val GET_JUST_LISTEN = "just_listen"
const val GET_PLAYLIST_INFO_AND_ITEM= "playlists/{id}?type=episode_list&last_timestamp_ms=0&sort=recent_added_first"


//API Param Keys
const val API_KEY_PARAM = "X-ListenAPI-Key"
const val TOP_LEVEL_ONLY_PARAM = "top_level_only"
const val  GENRE_ID_PARAM = "genre_id"
const val PAGE_PARAM ="page"
const val REGION_PARAM = "region"
const val SAFE_MODE_PARAM ="safe_mode"
const val ID_PARAM="id"
const val SORT_PARAM= "sort"

//Api Params Values
const val PARAM_API_ACCESS_TOKEN = BuildConfig.BaseApiKey
const val page=0
const val region="us"
const val safe_mode=0
const val sort= "recent_first"
const val playlistId="SgTozE1ZAe3"


//Error Messages
const val EM_NO_INTERNET_CONNECTION = "No Internet Connection"
const val EM_NO_NEWS_AVAILABLE = "There are no data available"

//Empty Image
const val EMPTY_IMAGE_URL = "https://www.how2shout.com/wp-content/uploads/2018/09/Internet-Access-Error.jpg"