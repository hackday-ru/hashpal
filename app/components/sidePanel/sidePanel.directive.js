import './sidePanel.template.html';

export default class sidePanel {
    constructor() {
        return {
            name: 'sidePanel',
            restrict: 'E',
            scope: {
                user: '='
            },
            bindToController: {
                user: '='
            },
            templateUrl: './components/sidePanel/sidePanel.template.html',
            link: ($scope) => {
                console.log($scope);
            },
            controller: sidePanelController,
            controllerAs: "sidePanelCtrl"
        }
    }
}

class sidePanelController {
    constructor(vkDataService, utilsService) {
        var extUser = this.user;
        this.loginVk = () => {
            console.log("clicked vk");
            vkDataService.loginVk((user) => {
                extUser.firstName = user.first_name;
                extUser.lastName = user.last_name;
                console.log(extUser);
                utilsService.safeApply();
                //$rootScope.$apply();
            }, (response) => {
                console.warn(response);
            });
        };
    }
}
