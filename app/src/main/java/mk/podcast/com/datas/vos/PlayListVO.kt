package mk.podcast.com.datas.vos


import com.google.firebase.database.IgnoreExtraProperties
@IgnoreExtraProperties
data class PlayListVO(
    var id: Int? = 0,
    var added_at_ms: Long? = 0,
    var data: DataVO? = null,
    var notes: String? = "",
    var type: String? = ""
)

data class DataVO(
    var id: String? = "",
    var audio: String? = "",
    var audio_length_sec: Int? = 0,
    var description: String? = "",
    //  var explicit_content: Boolean ?=false,
    var image: String? = "",
    var link: String? = "",
    var listennotes_edit_url: String? = "",
    var listennotes_url: String? = "",
    //   var maybe_audio_invarid: Boolean ?=false,
    var podcast: PodcastVO? = null,
    var pub_date_ms: Long? = 0,
    var thumbnail: String? = "",
    var title: String? = ""
)

