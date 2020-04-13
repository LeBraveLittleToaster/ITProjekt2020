import React, { Component } from 'react';
import { makeStyles, withStyles } from '@material-ui/core/styles';
import { withRouter, Redirect } from 'react-router-dom';
import CreateIcon from '@material-ui/icons/Create';
import ListIcon from '@material-ui/icons/List';
import Grid from '@material-ui/core/Grid';
import ExpansionDataView from './ExpansionDataView.js'
import { Typography } from '@material-ui/core';
import { Button } from '@material-ui/core';
import {observer} from 'mobx-react';

const mystyle = (theme) => ({
    alignItemsAndJustifyContent: {
        margin: 100,
        display: 'flex',
        alignItems: 'center',
        justifyContent: 'center'
    },
    padding: {
        padding: theme.spacing(3)
    },
    bg: {
        backgroundColor: "red"
    },
    rootsize: {
        width: 100
    },
    heading: {
        fontSize: theme.typography.pxToRem(15),
        fontWeight: theme.typography.fontWeightRegular,
    },
});

class PatientView extends Component {
    constructor(props) {
        super(props)
        this.state = {
            isInListView: true,
            isLoading: true,
            data: [
                { sysdia: 123, sysrr: 321, bmi: 56.7 },
                {
                    sysdia: 123,
                    sysrr: 323,
                    bmi: 52.234
                }, {
                    sysdia: 120,
                    sysrr: 322,
                    bmi: 253.467
                }
            ]
        }
    }

    loadHistory = () => {

    }
    _handleLogout = () => {
        console.log("Logging out")
        this.props.store.AppStore.setUserTokenAndLoginname(undefined, undefined);
        setTimeout(() => console.log("TOKEN" + this.props.store.AppStore.token), 2000);
        this.props.history.push("/login")
    }

    render() {
        const { classes } = this.props;
        return (
            <div className={classes.alignItemsAndJustifyContent}>
                {this.props.store.AppStore.token !== undefined ?
                <Grid container spacing={3} alignItems="flex-start">
                    <Grid item xs={3}>
                        <Typography variant="h4" gutterBottom>
                            User
                        </Typography>
                        <Typography variant="body1" gutterBottom>
                            {this.props.store.AppStore.firstname} {this.props.store.AppStore.lastname}
                        </Typography>
                        <Button variant="outlined" color="primary" onClick={this._handleLogout} className={classes.loginbtn}>logout</Button>
                    </Grid>
                    <Grid item xs={9}>
                        <Grid container spacing={3} alignItems="flex-end">
                            {this.state.data.map(function (d, idx) {
                                return (<Grid item xs={12} className={classes.listitem}><ExpansionDataView key={idx} value={d} /></Grid>)
                            })}
                        </Grid>
                    </Grid>
                </Grid>
                :
                <Redirect to="/login"/>}
            </div>
        );
    }
}

export default withStyles(mystyle)(observer(withRouter(PatientView)));