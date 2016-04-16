import './postsList.template.html';

export default class posts {
    constructor() {
        return {
            name: 'postsList',
            restrict: 'E',
            scope: {
                posts: '='
            },
            bindToController: {
                posts: '='
            },
            templateUrl: './components/posts/postsList.template.html',
            link: ($scope) => {
                // console.log($scope);
            },
            controller: postsController,
            controllerAs: "ctx"
        }
    }
}

class postsController {
    constructor(postsParser, hashtagParser) {
        // this.confirmPosts = [];
        // for (let item of this.posts) {
        //     if (postsParser.hasText(item) && hashtagParser.hasTags(item.text)) {
        //         this.confirmPosts.push(item);
        //     }
        // }
        this.confirmPosts = this.posts;
        console.log(this.confirmPosts);
        console.log(this.posts);
    }
}