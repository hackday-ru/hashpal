export default class postController {
    constructor($scope, $rootScope, vkDataService, toaster, errors, utilsService) {
        this.newPost = {
            text: "simple text",
            tags: "#hackday1"
        };

        this.sendPost = () => {
            //console.log(this.newPost)
            vkDataService.addPost(this.newPost, ()=> {
                //TODO: add message service and replace 'пост отправлен' with message from a service
                utilsService.safeApply();
                toaster.pop({
                    type: 'success',
                    title: 'Ура! ',
                    body: 'Пост отправлен',
                    timeout: 3000
                });

            }, (error)=> {
                if (error) {
                    utilsService.safeApply();
                    toaster.pop({
                        type: 'error',
                        title: 'Ошибка ',
                        body: errors[error],
                        timeout: 3000
                    });
                } else {
                    utilsService.safeApply();
                    toaster.pop({
                        type: 'error',
                        title: 'Ошибка ',
                        body: errors.vkPostErrorGeneral,
                        timeout: 3000
                    });
                }

            });
        };
    }
}