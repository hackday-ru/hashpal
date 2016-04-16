import sidePanel from './sidePanel/sidePanel.directive';
angular.module('components', [])
    .directive('sidePanel', (vkDataService, utilsService) => new sidePanel(vkDataService, utilsService));