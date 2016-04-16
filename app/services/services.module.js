import vkDataService from './vkData.service';

angular.module('services', [])
    .service('vkDataService', ($rootScope) => new vkDataService($rootScope));
