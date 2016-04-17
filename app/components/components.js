import sidePanel from './sidePanel/sidePanel.directive';
import postItem from './posts/postItem/postItem.directive';
import posts from './posts/postsList.directive.js';
import navDir from './navDir/navDir.directive.js';

angular.module('components', [])
    .directive('sidePanel', (vkDataService, fbDataService, utilsService, toaster, errors, $state) =>
        new sidePanel(vkDataService, fbDataService, utilsService, toaster, errors, $state))
    .directive('postsList', (postsParser, hashtagParser) =>
        new posts(postsParser, hashtagParser))
    .directive('postItem', ($rootScope, hashtagParser) => new postItem($rootScope, hashtagParser))
    .directive('navDir', ($rootScope, $state, utilsService) => new navDir($rootScope, $state, utilsService));

