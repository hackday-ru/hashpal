export default class hackTagParser {
    constructor() {
        this.hasTags = (text) => {
            return text.match(/(^|\s)(#[a-z\d-]+)/ig);
        };

        this.cropTags = (text) => {
            let tags = text.match(/(^|\s)(#[a-z\d-]+)/ig);
            for (let tag of tags) {
                text = text.slice(text.indexOf(tag), tag.length);
            }
            return {
                postText: text,
                postTags: tags
            };
        }
    }
}