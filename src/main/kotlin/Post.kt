data class Comments(
    val text: String = " "
)

data class Post(
    val id: Long = 0,
    val authorId: Long = 0,
    val authorName: String = "Incognita",
    val date: Int = 0,
    val content: String?,
    val canDelete: Boolean = true,
    val canEdit: Boolean = true,
    val likes: Int = 0,
    val comments: Comments?,
    var attachments: Array<Attachment> = emptyArray()
)