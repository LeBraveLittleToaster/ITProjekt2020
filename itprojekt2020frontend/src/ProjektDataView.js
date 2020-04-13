import React from 'react';
import { makeStyles } from '@material-ui/core/styles';
import Typography from '@material-ui/core/Typography';

const useStyles = makeStyles((theme) => ({
  root: {
    width: '100%',
  },
  heading: {
    fontSize: theme.typography.pxToRem(15),
    fontWeight: theme.typography.fontWeightRegular,
  }
}));

export default function ProjektDataView(props) {
  const classes = useStyles();
  return (
    <div className={classes.root}>
      {JSON.stringify(props.data)}
    </div>
  );
}