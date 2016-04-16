export default class homeController {
    constructor($rootScope, vkDataService) {
        console.log('mainCtrl');
        let user = {
            firstName: 'USER_FIRST_NAME',
            lastName: 'USER_LAST_NAME',
            photoSrc: 'photoSrc'
        };
        this.loginVk = () => {
            vkDataService.loginVk();
        };
    }
}
