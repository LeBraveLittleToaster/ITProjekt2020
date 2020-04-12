import React, { PureComponent, Component } from 'react';
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

    console.log(this.props.store)
    this.state = {
      username: undefined,
      password: undefined
    }
  }

  handleLogin = async () => {
    console.log("login");
    try{
    const response = await axios.get("http://localhost:8080/Gradle___itprojekt___server_1_0_SNAPSHOT_war/login");
    console.log(response.data)
    }catch(e){
      console.log(e)
    }
    this.props.store.AppStore.setUserTokenAndLoginname("token", "loginname");
    this.props.store.AppStore.setUser("921f07d6-342f-41c3-80d2-e833164c9efe",
    "2020-04-12T14:56:49.580+02:00", 10, "root");
    this.props.store.AppStore.setPatient("Schiessle", "Pascal", "hellostr.","123", "12345","Nirvana");
    console.log(this.context.history)
    this.props.history.push('/app'); 
    
  }

  handlePwChange = (e) => {
    this.setState({ password: e.target.value })
  }

  handleLoginnameChange = (e) => {
    this.setState({ loginname: e.target.value })
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
                        <TextField id="input-with-icon-grid" onChange={this.handleLoginnameChange} label="Loginname" />
                      </Grid>
                    </Grid>
                    <Grid item className={classes.padding}>
                      <Grid item>
                        <LockTwoToneIcon />
                      </Grid>
                      <Grid item>
                        <TextField id="input-with-icon-grid" type={'password'} onChange={this.handlePwChange} label="Passwort" />
                      </Grid>
                    </Grid>
                  </Grid>
                  <Grid item xs={12} >
                    <Button variant="contained" color="primary" onClick={this.handleLogin} className={classes.loginbtn} endIcon={<DoubleArrowIcon />}>Login</Button>
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
