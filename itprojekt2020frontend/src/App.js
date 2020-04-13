import React, { Component } from 'react';
import {withRouter} from 'react-router-dom';
import './App.css';
import Dataview from './Dataview.js';
import Loginpage from './Loginpage.js';

class App extends Component {

  constructor(props){
    super(props)
  }
  render(){
    return (
      <div>
        {this.props.store.AppStore.token === undefined ? (
          <Loginpage store = {this.props.store}/>
        ):(
          <Dataview store = {this.props.store}/>
        )}
      </div>
    );
  }
}

export default withRouter(App);
