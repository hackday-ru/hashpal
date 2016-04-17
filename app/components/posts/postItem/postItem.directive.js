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
        if (this.postItem.attachments && this.postItem.attachments[0].type === 'photo' &&
                Object.keys(this.postItem.attachments[0]).indexOf('photo') > -1) {
            this.imgSrc = this.postItem.attachments[0].photo.photo_604;
        }
        let obj = hashtagParser.cropTags(this.postItem.text);
        this.postText = obj.postText;
        this.postTags = obj.postTags;
        this.loises = this.postItem.likes.count;
        this.repastes = this.postItem.comments.count;
        // this.baseUrl = this.
        // console.log(this.postItem);
    }
}