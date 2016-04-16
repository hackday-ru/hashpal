import './states/search/search.template.html';
import './states/post/post.template.html';
import './states/home/home.template.html';

import homeController from './states/home/home.controller';

export default function mainRouter($stateProvider, $urlRouterProvider) {
    $urlRouterProvider.otherwise('/');
    $stateProvider
        .state('home', {
            url: '/',
            templateUrl: './states/home/home.template.html',
            controller: ($rootScope, vkDataService) => new homeController($rootScope, vkDataService),
            controllerAs: 'ctx'
        })
        .state('home.search', {
            url: '/search',
            templateUrl: './states/search/search.template.html'
        })
        .state('home.post', {
            url: '/post',
            templateUrl: './states/post/post.template.html'
        });
}