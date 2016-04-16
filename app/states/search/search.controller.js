export default class searchController {
    constructor($scope, $rootScope, vkDataService) {
        console.log('search');
        if ('geolocation' in navigator) {
            vkDataService.retrievePostsByGeo();
        }
        else console.log('fuck off');
    }
}