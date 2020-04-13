import React, { Component } from 'react';
import './App.css';
import {withRouter,  Redirect } from 'react-router-dom';
import PatientView from './PatientView.js';

class Dataview extends Component {

  constructor(props) {
    super(props)
  }

  getDataview(roleID){
    switch(roleID){
      case 10: 
        return <PatientView store={this.props.store}/>;
      case 20: 
        return <div>Assistent View</div>; 
        case 30:
          return <div>Doctor View</div>;
      default: 
        return <a>Error</a>
    }
  }

  render() {
    console.log(this.props.store.AppStore.token)
    return (
      <div>
        {this.props.store.AppStore.token !== undefined ? (
          <div>{this.getDataview(this.props.store.AppStore.roleID)}</div>
        ) : (
            <Redirect to="/login" />
          )}
      </div>
    );
  }
}

export default withRouter(Dataview);
