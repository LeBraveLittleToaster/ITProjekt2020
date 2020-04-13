import React, {useState} from 'react';
import { makeStyles } from '@material-ui/core/styles';
import ExpansionPanel from '@material-ui/core/ExpansionPanel';
import ExpansionPanelSummary from '@material-ui/core/ExpansionPanelSummary';
import ExpansionPanelDetails from '@material-ui/core/ExpansionPanelDetails';
import Typography from '@material-ui/core/Typography';
import ExpandMoreIcon from '@material-ui/icons/ExpandMore';
import Grid from '@material-ui/core/Grid';
import TextField from '@material-ui/core/TextField';
import Button from '@material-ui/core/Button';

const useStyles = makeStyles((theme) => ({
  root: {
    width: '100%',
  },
  heading: {
    fontSize: theme.typography.pxToRem(20),
    fontWeight: theme.typography.fontWeightBold,
    width: "100%"
  },
  sub_heading: {
    fontSize: theme.typography.pxToRem(14),
    fontWeight: theme.typography.fontWeightRegular,
  },
  details_sub_heading: {
    fontSize: theme.typography.pxToRem(13),
    fontWeight: theme.typography.fontWeightRegular,
  },
}));



export default function ExpansionInsertView(props) {
  const classes = useStyles();
  const [sysrr, setSysrr] = useState("");
  const [sysdia, setSysdia] = useState("");
  const [pulse, setPulse] = useState("");
  const [weightkg, setweightkg] = useState("");
  const [commentar, setCommentar] = useState("");
  const [unvalid ,setUnvalid] = useState(true);
  
  const _validate = () => {
    setUnvalid(sysrr == '' || sysdia == '' || pulse == '' || weightkg == '' || commentar == '')
    console.log("Commentar: " + commentar)
  }

  return (
    <div className={classes.root}>
      <ExpansionPanel variant="outlined">
        <ExpansionPanelSummary
          expandIcon={<ExpandMoreIcon />}
          aria-controls="panel1a-content"
          id="panel1a-header"
        >
          <Typography className={classes.sub_heading} gutterBottom>Neuer Eintrag</Typography>  
        </ExpansionPanelSummary>
        <ExpansionPanelDetails>
            <Grid container spacing={3} alignItems="center">
                  <Grid item xs={4}><TextField id="outlined-basic" label="Sysrr" onChange={(e) => {setSysrr(e.target.value); _validate();}} type="number" variant="outlined" /></Grid>
                  <Grid item xs={4}><TextField id="outlined-basic" label="Sysdia" onChange={(e) => {setSysdia(e.target.value); _validate();}} type="number" variant="outlined" /></Grid>
                  <Grid item xs={12}><TextField id="outlined-basic" label="Puls" onChange={(e) => {setPulse(e.target.value); _validate();}} type="number" variant="outlined" /></Grid>
                  <Grid item xs={12}><TextField id="outlined-basic" label="Gewicht in kg" onChange={(e) => {setweightkg(e.target.value); _validate();}} type="number" variant="outlined" /></Grid>
                  <Grid item xs={12}><TextField id="outlined-basic" label="Commentar" onChange={(e) => {setCommentar(e.target.value); _validate();}} variant="outlined" /></Grid>
                  <Grid item xs={12}><Button variant="outlined" disabled={unvalid} color="primary" onClick={() => console.log(sysrr)} >Senden</Button></Grid>
          </Grid>
        </ExpansionPanelDetails>
      </ExpansionPanel>
    </div>
  );
}