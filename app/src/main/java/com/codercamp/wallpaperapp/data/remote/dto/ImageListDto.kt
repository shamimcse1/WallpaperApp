package com.codercamp.wallpaperapp.data.remote.dto

import com.codercamp.wallpaperapp.domain.model.ImageLists

data class ImageListDto(
    val alt_description: String,
    val blur_hash: String,
    val color: String,
    val created_at: String,
    val current_user_collections: List<Any>,
    val description: String,
    val height: Int,
    val id: String,
    val liked_by_user: Boolean,
    val likes: Int,
    val links: Links,
    val promoted_at: String,
    val sponsorship: Sponsorship,
    val topic_submissions: TopicSubmissions,
    val updated_at: String,
    val urls: Urls,
    val user: User,
    val width: Int
)

fun ImageListDto.toImageList(): ImageLists{
    return ImageLists(
        id = id,
        urls = urls,
        links = links
    )
}