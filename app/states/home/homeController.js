export default class homeController {
    constructor($rootScope, vkDataService) {
        this.loginVk = () => {
            vkDataService.loginVk();
        };
    }
}