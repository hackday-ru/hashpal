export default class searchController {
    constructor(utilsService, $scope, $rootScope, vkDataService, hashtagParser, postsParser, $timeout) {
        this.getPosts = (tag) => {
            vkDataService.retrievePostsByGeo(this.count, tag, (data) => {
                for (let item of data.items) {
                    // console.log(item.text);
                    if (postsParser.hasText(item)) {
                        this.posts.push(item);
                    }
                }
                if (this.posts.length === 0) {
                    this.count += 100;
                    $timeout(this.getPosts, 400);
                }
                else {
                    utilsService.safeApply();
                }
            }, (error) => {
                //TODO: LOG ERROR
            });
        };
        console.log('search');
        this.posts = [];
        this.count = 0;
        if ('geolocation' in navigator) {
            this.getPosts("#skyporn");
        }
    }
}