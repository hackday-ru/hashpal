import vkDataService from './vkData.service';
import utilsService from './utils.service';
import hashTagParserService from './hashtagParser.service';

angular.module('services', [])
    .service('vkDataService', ($rootScope, networks) => new vkDataService($rootScope, networks))
    .service('utilsService', ($rootScope) => new utilsService($rootScope))
    .service('hashtagParser', () => new hashTagParserService());