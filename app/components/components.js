import sidePanel from './sidePanel/sidePanel.directive';
angular.module('components', [])
    .directive('sidePanel', (vkDataService, utilsService, toaster) => new sidePanel(vkDataService, utilsService, toaster));