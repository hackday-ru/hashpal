export default class homeController {
    constructor($rootScope, vkDataService) {
        console.log('mainCtrl');
        this.user = {
            firstName: 'USER_FIRST_NAME',
            lastName: 'USER_LAST_NAME',
            photoSrc: 'photoSrc'
        };

        this.loginVk = () => {
            console.log("clicked vk");
            vkDataService.loginVk((user) => {
                this.user = user;
            }, (response) => {
                console.warn(response);
                //
            });
        };

        // if (VK.Auth.getSession()) {
        //     //https://vk.com/dev/wall.get
        //    VK.Api.call('wall.get', {owner_id: VK.Auth.getSession().mid, count: 100, v: 5.50}, function (r) {
        //        if (r.response) {
        //            console.log(r);
        //            $scope.count = r.response.count;
        //            $scope.posts = r.response.items;
        //            $scope.$apply();
        //        }
        //    });
        // }
    }
}
