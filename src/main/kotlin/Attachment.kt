sealed class Attachment(
    val type: String
)

data class Video(
    val id: Int = 1,
    val ownerId: Int = 1,
    val title: String,
    val duration: Int
)

data class VideoAttachment(
    val video: Video
) : Attachment("video")

data class Audio(
    val id: Int = 1,
    val ownerId: Int = 1,
    val duration: Int = 1,
    val title: String,
    val artist: String
)

data class AudioAttachment(
    val audio: Audio
) : Attachment("audio")

data class Photo(
    val id: Int = 1,
    val ownerId: Int = 1,
    val date: Int = 1,
    val text: String
)

data class PhotoAttachment(
    val photo: Photo
) : Attachment("photo")

data class File(
    val id: Int = 1,
    val ownerId: Int = 1,
    val title: String,
    val size: Int = 2
)

data class FileAttachment(
    val file: File
) : Attachment("file")

data class Memes(
    val id: Int,
    val ownerId: Int
)

data class MemesAttachment(val memes: Memes) :
    Attachment("memes")