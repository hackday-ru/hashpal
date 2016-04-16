export default function mainRouter($stateProvider, $urlRouterProvider) {
    $urlRouterProvider.otherwise('/');
    $stateProvider
        .state('layout', {
            url: '/',
            template: '<div ui-view>TEST</div>'
        });
}