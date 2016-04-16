export default class vkDataService {
    constructor($rootScope, networks) {
        VK.init({
            apiId: networks.vk.appId
        });

        this.retrievePostsByGeo = (shift, successCallback, failureCallback) => {
            navigator.geolocation.getCurrentPosition((geo) => {
                console.log(geo);
                VK.Api.call('newsfeed.search', {
                    // start_from: shift,
                    // latitude: geo.coords.latitude,
                    // longetude: geo.coords.longitude,
                    count: 100,
                    v: '5.50',
                    start_time: geo.timestamp - 30000
                }, (r) => {
                    if (r.response) {
                        if (angular.isFunction(successCallback)) {
                            successCallback(r.response);
                        }
                        return;
                    }
                    if (angular.isFunction(failureCallback)) {
                        failureCallback(r.response);
                    }
                });
            }, (error) => {
                console.log('error', error);
                failureCallback(error);
            }, {
                timeout: Infinity,
                enableHighAccuracy: true,
                maximumAge: 0
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
                        //TODO: broadcast an error
                    }
                    if (response.session) {
                        successCallback(response.session.user);
                        return response.session;
                    }
                });
            });
        };
    }
}