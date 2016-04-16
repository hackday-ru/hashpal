export default class vkDataService {
    constructor($rootScope, networks) {
        VK.init({
            apiId: networks.vk.appId
        });
        this.loginVk = (name, pass) => {
            VK.Auth.getLoginStatus((response) => {
                if (response.session && response.session.user) {
                    vkDataFactory.parseAuthRequest(response.session);
                    return;
                }
                VK.Auth.login((response) => {
                    if (!response.session) {
                        return;
                        //broadcast an error
                    }
                    if (response.session) {
                        vkDataFactory.parseAuthRequest(response.session);
                    }
                });
            });
        };
    }
}