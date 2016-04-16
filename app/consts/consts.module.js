import networks from './networks';
import errors from './errors';

angular.module('consts', [])
    .constant('networks', networks)
    .constant('errors', errors);