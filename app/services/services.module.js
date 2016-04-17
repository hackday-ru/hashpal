import vkDataService from './vkData.service';
import utilsService from './utils.service';
import hashTagParserService from './hashtagParser.service';
import postsParserServer from './postsParser.service';
import fbDataService from './fbData.service';

angular.module('services', [])
    .service('vkDataService', ($rootScope, networks) => new vkDataService($rootScope, networks))
    .service('utilsService', ($rootScope) => new utilsService($rootScope))
    .service('hashtagParser', () => new hashTagParserService())
    .service('postsParser', () => new postsParserServer())
    .service('fbDataService', () => new fbDataService());