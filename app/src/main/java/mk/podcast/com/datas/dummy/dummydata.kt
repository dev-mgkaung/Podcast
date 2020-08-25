package mk.podcast.com.datas.dummy

import mk.podcast.com.datas.vos.PodcastVO

fun getDummyPodcastList() : List<PodcastVO> {
    var one = PodcastVO()
    one.image="https://images.assetsdelivery.com/compings_v2/gmast3r/gmast3r1511/gmast3r151100776.jpg"
    one.title  = "Art Design"
    one. description  = "Hello World Hello WorldHello WorldHello WorldHello WorldHello WorldHello WorldHello WorldHello WorldHello World"
    one. hour  = "1 hour left"

    var two = PodcastVO()
    two.image="https://thumbs.dreamstime.com/b/man-hipster-avatar-cartoon-guy-black-hair-red-glasses-flat-icon-blue-background-user-person-character-vector-151711777.jpg"
    two.title  = "Developer"
    two. description  = "DeveloperDeveloperDeveloperDeveloperDeveloperDeveloperDeveloperDeveloperDeveloperDeveloper"
    two. hour  = "2 hour left"

    var three = PodcastVO()
    three.image="https://us.123rf.com/450wm/gmast3r/gmast3r1603/gmast3r160300768/54398279-business-man-profile-icon-male-avatar-hipster-style-fashion-cartoon-guy-beard-portrait-casual-busine.jpg?ver=6"
    three.title  = "Review"
    three. description  = "BackendBackendBackendBackendBackendBackendBackendBackendBackendBackend"
    three. hour  = "3hour left"

    var four = PodcastVO()
    four.image="https://previews.123rf.com/images/photoplotnikov/photoplotnikov1604/photoplotnikov160400049/57872290-hipster-man-character-with-beard-hairstyle-and-glasses-in-flat-style-stylish-young-guy-on-background.jpg"
    four.title  = "Frondend"
    four. description  = "Frondend Frondend FrondendFrondendFrondendFrondendFrondendFrondendFrondendFrondendFrondendFrondend"
    four. hour  = "25 minutes"

    return arrayListOf(one,two,three,four,one,two,three,four)

}

