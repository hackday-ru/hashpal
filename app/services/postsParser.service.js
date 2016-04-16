export default class postsParserService {
    constructor() {
        this.hasText = (post) => {
            return post.text && post.text.length > 0;
        };
    }
}