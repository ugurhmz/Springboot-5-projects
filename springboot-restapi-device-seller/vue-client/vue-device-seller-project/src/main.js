import { createApp } from 'vue'
import App from './App.vue'
import store from "./store";
import router from "./router"

// CSS
import  "./style.css";

// Bootstrap
import "bootstrap";
import "bootstrap/dist/css/bootstrap.min.css";

//jQuery
global.jQuery = require('jquery');
const $ = global.jQuery;
window.$ = $;


// fontawesome
import { FontAwesomeIcon } from '@fortawesome/vue-fontawesome';
import { library } from '@fortawesome/fontawesome-svg-core';
import {
    faDesktop,
    faHome, faLaptop, faMobileAlt, faTabletAlt,
    faUserCircle,
} from '@fortawesome/free-solid-svg-icons';

library.add(faHome,
    faUserCircle, // => in form => user-circle
    faDesktop, // => desktop
    faLaptop, // laptop
    faMobileAlt, //mobile-alt
    faTabletAlt //tablet-alt
);



const app = createApp(App);
app.use(router);
app.use(store);
app.component("font-awesome-icon", FontAwesomeIcon)
app.mount("#app");