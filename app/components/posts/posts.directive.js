import './posts.template.html';

export default class posts {
    constructor() {
        return {
            name: 'postItem',
            restrict: 'E',
            scope: {
                posts: '='
            },
            bindToController: {
                posts: '='
            },
            templateUrl: './components/posts/posts.template.html',
            link: ($scope) => {
                // console.log($scope);
            },
            controller: postsController,
            controllerAs: "ctx"
        }
    }
}

class postsController {
    constructor() {
        console.log(this.posts);
    }
}