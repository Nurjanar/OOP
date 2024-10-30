import java.time.LocalDateTime

data class Comments(
    var text: String = " ",
    var commentId: Int = 0,
    val id: Int = 0,
    var deleted: Boolean = false
)

data class Note(
    var title: String = " ",
    var text: String = " ",
    val noteId: Int = 0,
    val userId: Int = 0,
    var comments: Comments?,
    val createdAt: LocalDateTime = LocalDateTime.now()
)

data class Post(
    val postId: Int = 0,
    val authorId: Int = 0,
    val authorName: String = "Incognita",
    val createdAt: LocalDateTime = LocalDateTime.now(),
    val canDelete: Boolean = true,
    val canEdit: Boolean = true,
    val likes: Int = 0,
    val content: String?,
    var comments: Comments?,
    val attachments: Array<Attachment> = emptyArray()
)