data class Comments(
    var text: String = " ",
    val id: Int = 0,
    val postId: Int = 0,
    val userId: Int = 0
)

data class Post(
    val id: Int = 0,
    val authorId: Int = 0,
    val authorName: String = "Incognita",
    val date: Int = 0,
    val canDelete: Boolean = true,
    val canEdit: Boolean = true,
    val likes: Int = 0,
    val content: String?,
    var comments: Comments?,
    val attachments: Array<Attachment> = emptyArray()
)