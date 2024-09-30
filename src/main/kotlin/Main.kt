fun main() {

    WallService.add(
        Post(
            1, content = "Hello everyone!",
            comments = Comments(),
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
    WallService.createComment(
        1, comment = Comments("Hello my friend!")
    )

    WallService.add(
        Post(
            2, content = "Who goes with me to the cinema tonight?",
            comments = Comments()
        )
    )
    WallService.createComment(
        2, comment = Comments("I will")
    )
    WallService.showPosts()
    val post =
        Post(
            2, content = "Interstellar at 20:30",
            comments = Comments(),
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
    WallService.showPosts()


    NoteService.addNote(
        Note(
            "Угадайте у кого сегодня др?",
            "У лягушки-квакушки!", comments = Comments()
        )
    )

    NoteService.createComment(1, "Надо же!")
    NoteService.read()
    NoteService.editNote(
        1, "Те,кто угадал--->",
        "Приходите праздновать!"
    )

    NoteService.createComment(1, "Урааа!")
    NoteService.read()
    NoteService.editComment(1, 1, "С ума сойти!")
    println(NoteService.getComments(1))
    NoteService.deleteComment(1, 1)
    println(NoteService.getComments(1))
    NoteService.restoreComment(1, 1)
    NoteService.deleteNote(1)
    NoteService.read()
}