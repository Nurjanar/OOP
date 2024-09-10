object WallService {
    private var posts = emptyArray<Post>()
    private var postId: Long = 0

    fun add(post: Post): Post {
        posts += post.copy(id = ++postId, comments = post.comments?.copy())
        return posts.last()
    }

    fun update(newPost: Post): Boolean {
        for ((index, post) in posts.withIndex()) {
            if (posts[index].id == newPost.id) {
                posts[index] = newPost.copy(comments = post.comments?.copy())
                return true
            }
        }
        return false
    }

    fun clear() {
        posts = emptyArray()
        postId = 0
    }
}