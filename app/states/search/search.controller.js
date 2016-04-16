export default class searchController {
    constructor($scope, $rootScope, vkDataService) {
        console.log('search');
        if ('geolocation' in navigator) {
            vkDataService.retrievePostsByGeo((data) => {
                
            }, (error) => {

            });
        }
        else console.log('fuck off');
    }
}