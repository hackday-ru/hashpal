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
                post: '='
            },
            templateUrl: './components/posts/postItem/postItem.template.html',
            link: ($scope) => {
                //console.log($scope);
            },
            controller: postItemController,
            controllerAs: "postItemCtrl"
        }
    }
}

class postItemController {
    constructor() {
        console.log(this.post);
    }
}