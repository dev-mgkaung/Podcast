package mk.podcast.com.datas.dummy

import mk.podcast.com.datas.vos.CategoryVO

fun getDummyCategoryList() : List<CategoryVO> {
    var one = CategoryVO()
    one.image =
        "https://images.assetsdelivery.com/compings_v2/gmast3r/gmast3r1511/gmast3r151100776.jpg"
    one.title = "Art Design"
    return arrayListOf(one, one, one, one)
}