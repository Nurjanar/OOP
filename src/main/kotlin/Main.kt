fun main() {

    WallService.add(
        Post(
            1, content = "Hello everyone!",
            comments = Comments("Hello my friend!"),
            attachments = arrayOf(
                AudioAttachment(
                    Audio(
                        artist = "Adele",
                        title = "Hello"
                    )
                ),
                PhotoAttachment(
                    Photo(
                        text = "sunset photo"
                    )
                )
            )
        )
    )

    WallService.add(
        Post(
            2, content = "Who wants to go to the cinema tonight?",
            comments = Comments("I'll go")
        )
    )
    val post =
        Post(
            2, content = "Interstellar at 20:30",
            comments = Comments("let`s go"),
            attachments = arrayOf(
                VideoAttachment(
                    Video(
                        title = "I'm ready",
                        duration = 1
                    )
                ),
                FileAttachment(
                    File(
                        title = "cinema tickets"
                    )
                )
            )
        )
    WallService.update(post)
    WallService.showPosts()
    for (attachment in post.attachments) {
        val result = when (attachment) {
            is AudioAttachment -> "audio"
            is PhotoAttachment -> "photo"
            is VideoAttachment -> "video"
            is FileAttachment -> "file"
            is MemesAttachment -> "memes"
        }
        println(result)
    }

    val attachment: Attachment = AudioAttachment(
        audio = Audio(title = "test", artist = "1")
    )
    println(attachment.type)
}