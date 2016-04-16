import './states/search/search.template.html';
import './states/post/post.template.html';
import './states/home/home.template.html';

import searchController from './states/search/search.controller';
import homeController from './states/home/home.controller';
import postController from './states/post/post.controller';

export default function mainRouter($stateProvider, $urlRouterProvider) {
    $urlRouterProvider.otherwise('/');
    $stateProvider
        .state('home', {
            url: '/',
            templateUrl: './states/home/home.template.html',
            controller: ($rootScope, vkDataService, utilsService) =>
                new homeController($rootScope, vkDataService, utilsService),
            controllerAs: 'ctx'
        })
        .state('home.search', {
            url: 'search',
            templateUrl: './states/search/search.template.html',
            controller: ($scope, $rootScope, vkDataService) =>
                new searchController($scope, $rootScope, vkDataService),
            controllerAs: 'ctx'
        })
        .state('home.post', {
            url: 'post',
            templateUrl: './states/post/post.template.html',
            controller: ($scope, $rootScope, vkDataService, toaster, errors, utilsService) =>
                new postController($scope, $rootScope, vkDataService, toaster, errors, utilsService),
            controllerAs: 'ctx'
        });
}