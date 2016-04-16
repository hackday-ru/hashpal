import vkDataService from './vkData.service';

angular.module('services', [])
    .service('vkDataService', ($rootScope, networks) => new vkDataService($rootScope, networks));