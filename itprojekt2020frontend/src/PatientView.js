import React, { Component } from 'react';
import { makeStyles, withStyles } from '@material-ui/core/styles';
import CreateIcon from '@material-ui/icons/Create';
import ListIcon from '@material-ui/icons/List';
import Grid from '@material-ui/core/Grid';
import Paper from '@material-ui/core/Paper';
import ExpansionDataView from './ExpansionDataView.js'

const useStyles = makeStyles((theme) => ({
    alignItemsAndJustifyContent: {
        margin: 100,
        display: 'flex',
        alignItems: 'center',
        justifyContent: 'center',
        maxWidth : 100
      },
    padding: {
        padding: theme.spacing(3)
      },
    listitem : {
        padding: theme.spacing(3),
        maxWidth : 500
    }
}));



class PatientView extends Component {
    constructor(props) {
        super(props)
        this.state = {
            isInListView: true,
            isLoading: true,
            data: [
                {sysdia: 123,sysrr: 321,bmi: 56.7},
                {
                    sysdia: 123,
                    sysrr: 323,
                    bmi: 52.234
                },{
                    sysdia: 120,
                    sysrr: 322,
                    bmi: 253.467
                }
            ]
        }
    }

    loadHistory = () => {

    }

    render() {
        const { classes } = this.props;
        return (
            <div>
            <div className={classes.alignItemsAndJustifyContent}>
                {this.state.isInListView ? (
                    <Grid container spacing={3} alignItems="flex-end">
                            {this.state.data.map(function(d, idx){
                                return (<Grid item xs={12} className={classes.listitem}><ExpansionDataView key={idx} value={d} /></Grid>)
                            })}
                    </Grid>
                ) : (
                        <div />
                    )}
            </div>
            </div>
        );
    }
}

export default withStyles(useStyles)(PatientView);