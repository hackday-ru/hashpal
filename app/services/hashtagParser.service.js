export default class hackTagParser {
    constructor() {
        this.hasTags = (text) => {
            return text.match('\#(x?[\da-f]+;|(\w+))');
        };

        this.cropTags = (text) => {
            debugger;
            text.match('\#(x?[\da-f]+;|(\w+))');
        }
    }
}