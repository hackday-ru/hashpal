import './sidePanel.template.html';

export default class sidePanel {
    constructor() {
        return {
            name: 'sidePanel',
            restrict: 'E',
            scope: {
                user: '=',
                sidePanelOpened: '='
            },
            bindToController: {
                user: '=',
                sidePanelOpened: '='
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
    constructor(vkDataService, fbDataService, utilsService, toaster, errors, $state) {

        this.state = $state;
        this.navigate = () => {
            if ($state.current.name === 'home.post') {
                $state.go('home.search');
            }
            else {
                $state.go('home.post');
            }
        };

        this.loginVk = () => {
            this.blockVkLogin = true;
            console.log("clicked vk");
            vkDataService.loginVk((user) => {
                this.user.username = user.first_name + ' ' + user.last_name;
                this.blockVkLogin = false;
                this.vkLogged = true;
                utilsService.safeApply();
            }, (response) => {
                console.warn(response);
                this.blockVkLogin = false;
                utilsService.safeApply();
            });
        };

        this.toggleSidePanel = () => {
            this.sidePanelOpened = !this.sidePanelOpened;
        };
        
        this.toggleLoginPane = () => {
            this.loginPaneOpened = !this.loginPaneOpened;
        };

        this.loginFB = () => {
            this.blockFBLogin = true;
            fbDataService.fbLogin((response) => {
                fbDataService.getUserName(response.authResponse.userID, (username) => {
                    this.user.username = username;
                });
                fbDataService.getUserPic(response.authResponse.userID, (url) => {
                    this.user.picSrc = url;
                });
                this.fbLogged = true;
                this.blockFBLogin = false;
            });
        }
    }
}
