import './states/search/search.template.html';
import './states/post/post.template.html';
import './states/home/home.template.html';

export default function mainRouter($stateProvider, $urlRouterProvider) {
    $urlRouterProvider.otherwise('/');
    $stateProvider
        .state('layout', {
            url: '/',
            template: '<div ui-view>layout</div>',
            controller: () => {
                console.log('layout');
            }
        })
        .state('home', {
            url: '',
            abstract: true,
            template: '<div ui-view></div>',
            controller: () => {
                console.log('home');
            }
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