import sidePanel from './sidePanel/sidePanel.directive';
import postItem from './posts/postItem/postItem.directive';
import posts from './posts/posts.directive';

angular.module('components', [])
    .directive('sidePanel', (vkDataService, utilsService) =>
        new sidePanel(vkDataService, utilsService))
    .directive('posts', () => new posts())
    .directive('postItem', () => new postItem())
    .directive('sidePanel', (vkDataService, utilsService, toaster) =>
        new sidePanel(vkDataService, utilsService, toaster));
