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
                //console.log($scope);
            },
            controller: sidePanelController,
            controllerAs: "sidePanelCtrl"
        }
    }
}

class sidePanelController {
    constructor(vkDataService, utilsService, toaster) {
        this.loginVk = () => {
            toaster.pop({
                type: 'error',
                title: 'aaaaaaaaaaaaaa ',
                body: 'Мы все умрём!!!!!!!!!!!',
                timeout: 3000
            });
            this.blockVkLogin = true;
            console.log("clicked vk");
            vkDataService.loginVk((user) => {
                this.user.firstName = user.first_name;
                this.user.lastName = user.last_name;
                this.blockVkLogin = false;
                utilsService.safeApply();
            }, (response) => {
                console.warn(response);
                this.blockVkLogin = false;
                utilsService.safeApply();
            });
        };
    }
}
