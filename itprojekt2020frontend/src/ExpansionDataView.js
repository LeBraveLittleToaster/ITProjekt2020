import React, { useState, useEffect, Component } from 'react';
import { makeStyles, withStyles } from '@material-ui/core/styles';
import ExpansionPanel from '@material-ui/core/ExpansionPanel';
import ExpansionPanelSummary from '@material-ui/core/ExpansionPanelSummary';
import ExpansionPanelDetails from '@material-ui/core/ExpansionPanelDetails';
import Typography from '@material-ui/core/Typography';
import ExpandMoreIcon from '@material-ui/icons/ExpandMore';
import ProjectDataView from './ProjektDataView';
import Grid from '@material-ui/core/Grid';
import axios from 'axios';
import ExpansionInsertView from './ExpansionInsertView.js';

const useStyles = makeStyles((theme) => ({
  root: {
    width: '100%',
  },
  heading: {
    fontSize: theme.typography.pxToRem(20),
    fontWeight: theme.typography.fontWeightBold,
  },
  sub_heading: {
    fontSize: theme.typography.pxToRem(20),
    fontWeight: theme.typography.fontWeightBold,
  }
}));

class ExpansionDataView extends Component {


  constructor(props) {
    super(props)
    this.state = {
      data: []
    }
    this._build();
  }
  _build = () => {
    const response = axios.get("http://localhost:8080/Gradle___itprojekt___server_1_0_SNAPSHOT_war/patient/projekts/data",
      { headers: { 'token': this.props.store.AppStore.token, 'projektID': this.props.value.projektID } });
    response.then((response) => {
      console.log(response)
      if (response.status === 200 && response.data.isSuccess === true) {
        console.log(response.data)
        this.setState({data:response.data.projektData})
      }
    })
  };

  render() {
    const { classes } = this.props;

    return (
      <div className={classes.root}>
        <ExpansionPanel /*TransitionProps={{ unmountOnExit: true }}*/ onClick={() => console.log("Opening")}>
          <ExpansionPanelSummary
            expandIcon={<ExpandMoreIcon />}
            aria-controls="panel1a-content"
            id="panel1a-header"
          >
            <Typography className={classes.heading} gutterBottom>{this.props.value.projektname}</Typography>
          </ExpansionPanelSummary>
          <ExpansionPanelDetails>
            <Grid container spacing={2}>
              <Grid item xs={12} className={classes.listitem}>
                <ExpansionInsertView />
              </Grid>
              <Grid item xs={12}><Typography variant="h6" gutterBottom>Projekt Daten</Typography></Grid>
              <ProjectDataView/>
            </Grid>
          </ExpansionPanelDetails>
        </ExpansionPanel>
      </div>
    );
  }
}

export default withStyles(useStyles)(ExpansionDataView);