export default class hackTagParser {
    constructor() {
        this.hasTags = (text) => {
            return text.match(/(^|\s)(#[a-z\d-]+)/ig);
        };

        this.cropTags = (text) => {
            let tags = text.match(/(^|\s)(#[a-z\d-]+)/ig);
            if (tags && tags.length > 0) {
                for (let tag of tags) {
                    text = text.slice(text.indexOf(tag), tag.length + 1);
                }
            }
            return {
                postText: text,
                postTags: tags
            };
        }
    }
}