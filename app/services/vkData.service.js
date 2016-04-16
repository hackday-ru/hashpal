export default class vkDataService {
    constructor($rootScope, networks) {
        VK.init({
            apiId: networks.vk.appId
        });

        this.retrievePostsByGeo = (successCallback, failureCallback) => {
            let geo = navigator.geolocation.getCurrentPosition((geo) => {
                console.log(geo);
                VK.Api.call('newsfeed.search', {

                    // owner_id: VK.Auth.getSession().mid,
                    // count: 100,
                    // v: 5.50
                }, (r) => {
                    if (r.response) {
                        if (angular.isFunction()) {
                            successCallback();
                        }
                        return;
                    }
                    if (angular.isFunction()) {
                        failureCallback();
                    }
                });
            });
        };

        this.loginVk = (successCallback, failCallback) => {
            VK.Auth.getLoginStatus((response) => {
                if (response.session && response.session.user) {
                    if (angular.isFunction(successCallback)) {
                        successCallback(response.session.user);
                    }
                    //vkDataFactory.parseAuthRequest(response.session);
                    return;
                }
                VK.Auth.login((response) => {
                    if (!response.session) {
                        if (angular.isFunction(failCallback)) {
                            failCallback(response);
                        }
                        return;
                        //broadcast an error
                    }
                    if (response.session) {
                        //vkDataFactory.parseAuthRequest(response.session);
                        return response.session;
                    }
                });
            });
        };
    }
}