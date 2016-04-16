import sidePanel from './sidePanel/sidePanel.directive';
angular.module('components', [])
    .directive('sidePanel', () => new sidePanel());