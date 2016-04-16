import './postItem.template.html';

export default class postItem {
    constructor() {
        return {
            name: 'postItem',
            restrict: 'E',
            scope: {
                post: '='
            },
            bindToController: {
                postItem: '='
            },
            templateUrl: './components/posts/postItem/postItem.template.html',
            link: ($scope) => {
                //console.log($scope);
            },
            controller: postItemController,
            controllerAs: "ctx"
        }
    }
}

class postItemController {
    constructor(hashtagParser) {
        this.imgSrc = null;
        if (this.postItem.attachments[0].type = 'photo' &&
                Object.keys(this.postItem.attachments[0]).indexOf('photo') > -1) {
            this.imgSrc = this.postItem.attachments[0].photo.photo_604;
        }
        let text = '',
            tags = [];
        [text, tags] = hashtagParser.cropTags(this.postItem.text);
        console.log(this.postItem);
    }
}