package com.vkpriesniakov.imaginesoft.utils



sealed class SortOrder(sortType: String)

class SortLatest(val sortType: String = "latest") : SortOrder(sortType)
class SortOldest(val sortType: String = "oldest") : SortOrder(sortType)
class SortPopular(val sortType: String = "popular") : SortOrder(sortType)

fun getTypeByPosition(position: Int) = when (position) {
    1 -> SortPopular().sortType
    2 -> SortOldest().sortType
    else -> SortLatest().sortType
}