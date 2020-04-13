import React, { Component } from 'react';
import axios from 'axios';
import './App.css';
import { withRouter, Redirect } from 'react-router-dom';
import { withStyles } from '@material-ui/core/styles';
import TextField from '@material-ui/core/TextField';
import Grid from '@material-ui/core/Grid';
import Paper from '@material-ui/core/Paper';
import AccountCircle from '@material-ui/icons/AccountCircle';
import LockTwoToneIcon from '@material-ui/icons/LockTwoTone';
import DoubleArrowIcon from '@material-ui/icons/DoubleArrow';
import { Button } from '@material-ui/core';
const useStyles = (theme) => ({
  alignItemsAndJustifyContent: {
    margin: 100,
    display: 'flex',
    alignItems: 'center',
    justifyContent: 'center',
  },
  paper: {
    padding: theme.spacing(1),
    textAlign: 'center',
    elevation: 8,
    color: theme.palette.text.secondary,
  },
  padding: {
    padding: theme.spacing(3)
  },
  loginbtn: {
    margin: theme.spacing(3)

  }
});

class Loginpage extends Component {

  constructor(props) {
    super(props)
    this.state = {
      loginname: "root1",
      password: "root",
      isRequesting : false,
      isRequestFailed : false
    }
  }

  handleLogin = async () => {
    this.setState({isRequesting : true});
    const response = await axios.get("http://localhost:8080/Gradle___itprojekt___server_1_0_SNAPSHOT_war/login",
      { headers: { 'username': this.state.loginname, 'password': this.state.password } });
      console.log("Requested user: " + response.status)
      console.log(response.data)
    if (response.status === 200 && response.data.isSuccess === true) {
      console.log("GO!")
      this.props.store.AppStore.setUserTokenAndLoginname(response.data.token, response.data.user.loginname);
      this.props.store.AppStore.setUser(response.data.user.userID,
        response.data.user.crDate, response.data.user.roleID, response.data.user.loginname);
      this.props.store.AppStore.setPatient(response.data.patient.lastname, response.data.patient.firstname, response.data.patient.street,
        response.data.patient.plz, response.data.patient.postcode, response.data.patient.cityname);
      this.props.history.push('/app');
    } else {
      this.setState({isRequesting : false});
      this.setState({isRequestFailed : true});

    }
  }

  _handleUsernameChange = (e) => {
    this.setState({loginname : e.target.value, isRequestFailed : false})
  }
  _handlePasswordChange = (e) => {
    this.setState({password : e.target.value,isRequestFailed : false});
  }

  render() {
    const { classes } = this.props;
    return (
      <div>
        {this.props.store.AppStore.token != undefined ? (
          <Redirect to="app" />
        ) : (
            <div className={classes.alignItemsAndJustifyContent}>
              <Paper>
                <Grid container spacing={3} alignItems="flex-end">
                  <Grid item xs={12}>
                    <Grid item className={classes.padding}>
                      <Grid item>
                        <AccountCircle />
                      </Grid>
                      <Grid item>
                        <TextField id="input-with-icon-grid" onChange={this._handleUsernameChange} label="Loginname" defaultValue={this.state.loginname} ></TextField>
                      </Grid>
                    </Grid>
                    <Grid item className={classes.padding}>
                      <Grid item>
                        <LockTwoToneIcon />
                      </Grid>
                      <Grid item>
                        <TextField id="input-with-icon-grid" type={'password'} onChange={this._handlePasswordChange} label="Passwort" defaultValue={this.state.password} />
                      </Grid>
                    </Grid>
                  </Grid>
                  <Grid item xs={12} >
                    <Button variant="contained" color={this.state.isRequestFailed ? "secondary" : "primary"} disabled={this.state.isRequesting} onClick={this.handleLogin} className={classes.loginbtn} endIcon={<DoubleArrowIcon />}>Login</Button>
                  </Grid>
                </Grid>
              </Paper>
            </div>
          )}
      </div>
    );
  }
}

export default withStyles(useStyles)(withRouter(Loginpage));
