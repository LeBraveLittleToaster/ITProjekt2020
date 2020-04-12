import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import * as serviceWorker from './serviceWorker';
import {Store} from './Rootstore.js';
import { Route, BrowserRouter as Router } from 'react-router-dom'
import DataView from './Dataview.js';
import Loginpage from './Loginpage';

const routing = (
  <React.StrictMode>
    <Router>
      <Route path="/login" component={(props) => <Loginpage {...props} store={Store} />} />
      <Route path="/app" component={(props) => <DataView {...props} store={Store} />} />
    </Router>
  </React.StrictMode>
)

ReactDOM.render(routing, document.getElementById('root'));
// If you want your app to work offline and load faster, you can change
// unregister() to register() below. Note this comes with some pitfalls.
// Learn more about service workers: https://bit.ly/CRA-PWA
serviceWorker.unregister();
