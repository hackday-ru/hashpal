import sidePanel from './sidePanel/sidePanel.directive';
import postItem from './posts/postItem/postItem.directive';
import posts from './posts/posts.directive';

angular.module('components', [])
    .directive('sidePanel', (vkDataService, utilsService, toaster, errors) =>
        new sidePanel(vkDataService, utilsService, toaster, errors))
    .directive('posts', () => new posts())
    .directive('postItem', () => new postItem());