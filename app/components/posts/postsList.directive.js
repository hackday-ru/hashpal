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
        this.confirmPosts = this.posts;
    }
}