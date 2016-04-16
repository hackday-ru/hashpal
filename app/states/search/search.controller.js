export default class searchController {
    constructor($scope, $rootScope, vkDataService) {
        console.log('search');
        this.posts = [];
        if ('geolocation' in navigator) {
            vkDataService.retrievePostsByGeo((data) => {
                this.posts = data;
            }, (error) => {
                //TODO: LOG ERROR
            });
        }
        else console.log('fuck off');
    }
}