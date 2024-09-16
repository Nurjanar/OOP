object WallService {
    private var posts = emptyArray<Post>()
    private var lastId: Int = 0
    private var comments = emptyArray<Comments>()

    fun add(post: Post): Post {
        posts += post.copy(
            id = ++lastId,
            comments = post.comments?.copy(id = lastId)
        )
        return posts.last()
    }

    fun update(newPost: Post): Boolean {
        for ((index, post) in posts.withIndex()) {
            if (posts[index].id == newPost.id) {
                posts[index] = newPost.copy(
                    comments = posts[index].comments
                )
                return true
            }
        }
        return false
    }

    fun getComments(postId: Int): List<Comments> {
        return comments.filter { it.postId == postId }
    }

    fun showPosts() {
        for (post in posts) {
            println(post)
        }
    }

    fun clear() {
        posts = emptyArray()
        lastId = 0
    }

    @Throws(PostNotFoundException::class)
    fun createComment(postId: Int, comment: Comments): Comments? {
        if (postId == 0 || posts.size < postId) {
            throw PostNotFoundException()
        }
        val newComment = Comments(
            id = comments.size + 1,
            postId = postId,
            text = comment.text
        )
        for ((index, post) in posts.withIndex()) {
            if (posts[index].id == postId) {
                comments += newComment
                val result = getComments(postId = post.id)
                posts[index].comments?.text = result.toString()
            }
        }
        return comments.last()
    }
}