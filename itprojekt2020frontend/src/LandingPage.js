import React, { Component } from 'react';
import CircularProgress from '@material-ui/core/CircularProgress';
import './App.css';
import { withRouter, Redirect } from 'react-router-dom';
import { withStyles } from '@material-ui/core/styles';
import {observer} from 'mobx-react';

const useStyles = (theme) => ({
  alignItemsAndJustifyContent: {
    margin: 100,
    display: 'flex',
    alignItems: 'center',
    justifyContent: 'center',
  }
});
const LandingPage = observer(class LandingPage extends Component{

    constructor(props){
        super(props)
        setTimeout(() => {
            console.log(this.props.store.AppStore.isHydrated);
        }, 5000)
    }

  render() {
    const { classes } = this.props;
    console.log(this.props.store.AppStore.isHydrated);
    return (
      <div>
          {this.props.store.AppStore.isHydrated ? (
              <div><Redirect to="/login"/></div>
          ):(
              <div>
                  <CircularProgress />
              </div>
          )}
      </div>
    );
  }
});

export default withStyles(useStyles)(withRouter(LandingPage));
