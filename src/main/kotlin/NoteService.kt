object NoteService {
    private var notes = mutableListOf<Note>()
    private var lastId: Int = 0
    private var nextId: Int = 0
    private var comments = mutableListOf<Comments>()

    private fun getById(id: Int): Note {
        var result = Note(comments = Comments())
        for ((index, note) in notes.withIndex()) {
            if (notes[index].noteId == id) {
                result = note
            }
        }
        return result
    }

    fun addNote(note: Note): Note {
        notes += note.copy(
            noteId = ++lastId
        )
        return notes.last()
    }

    fun createComment(id: Int, text: String): Comments {
        val note = getById(id = id)
        val comment = Comments(
            id = id,
            text = text,
            commentId = ++nextId
        )
        comments += comment
        val result = getComments(noteId = id)
        note.comments?.text = result.toString()


        return comments.last()
    }

    @Throws(CommentNotFoundException::class)
    fun getComments(noteId: Int): List<Comments> {
        if (notes.isEmpty() || comments.isEmpty()) {
            throw CommentNotFoundException()
        }
        return comments.filter { it.id == noteId && !it.deleted }

    }

    private fun getCommentById(id: Int, commentId: Int): Comments {
        var result = Comments()
        for (comment in comments) {
            if (comment.commentId == commentId &&
                comment.id == id
            ) {
                result = comment
            }
        }
        return result
    }

    fun deleteComment(id: Int, commentId: Int): Boolean {
        val comment = getCommentById(id = id, commentId = commentId)
        if (!comment.deleted) {
            comment.deleted = true
            println("Комментарий удален!")
            return true
        } else {
            throw CommentNotFoundException()
        }
    }

    fun editNote(noteId: Int, newTitle: String, newText: String): Boolean {
        val note = getById(id = noteId)
        note.title = newTitle
        note.text = newText
        return true
    }

    @Throws(CommentNotFoundException::class)
    fun editComment(id: Int, commentId: Int, newText: String): Boolean {
        val comment = getCommentById(id = id, commentId = commentId)
        if (!comment.deleted) {
            comment.text = newText
            return true

        } else {
            throw CommentNotFoundException()
        }

    }

    @Throws(NoteNotFoundException::class)
    fun read() {
        if (notes.isEmpty()) {
            throw NoteNotFoundException()
        }
        for (note in notes) {
            println(note)
        }
    }


    @Throws(CommentNotFoundException::class)
    fun restoreComment(id: Int, commentId: Int): Boolean {
        val comment = getCommentById(id = id, commentId = commentId)
        if (comment.deleted) {
            comment.deleted = false
            return true
        } else {
            throw CommentNotFoundException()
        }
    }

    fun deleteNote(noteId: Int): Boolean {
        val note = getById(id = noteId)
        notes.remove(note)
        val commentsOfDeletedNote = comments.filter { it.id == noteId }
        comments.removeAll(commentsOfDeletedNote)
        println("Заметка удалена!")
        return true
    }

    fun clear() {
        notes.clear()
        lastId = 0
    }
}