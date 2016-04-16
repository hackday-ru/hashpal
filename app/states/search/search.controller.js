export default class searchController {
    constructor(utilsService, $scope, $rootScope, vkDataService, hashtagParser, postsParser) {
        this.getPosts = () => {
            debugger;
            vkDataService.retrievePostsByGeo(this.count, (data) => {
                for (let item of data.items) {
                    if (postsParser.hasText(item) && hashtagParser.hasTags(item.text)) {
                        this.posts.push(item);
                    }
                }
                if (this.posts.length === 0) {
                    this.count += 100;
                    this.getPosts();
                }
                else {
                    debugger;
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
            this.getPosts();
        }
        else console.log('fuck off');
    }
}