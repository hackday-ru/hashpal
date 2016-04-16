import './styles/styles.less';
import angular from 'angular';
import './../node_modules/angular-ui-router/release/angular-ui-router.min';
import mainRouter from './mainRouter';
import './components/components';
import './consts/consts.module';
import './services/services.module';

angular.module('app', ['services', 'consts', 'components', 'ui.router'])
    .config(mainRouter);