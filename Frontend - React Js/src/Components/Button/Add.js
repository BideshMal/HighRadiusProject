import React, { useState } from "react";
import {
  Button,
  Dialog,
  DialogActions,
  DialogContent,
  DialogContentText,
  DialogTitle,
  TextField,
  Grid,
  Tooltip,
} from "@mui/material";
import axios from "axios";
import { createTheme, ThemeProvider } from "@mui/material/styles";
const queryString = require("query-string");


const theme = createTheme({
  components: {
    MuiButton: {
      styleOverrides: {
        root: {
          textTransform: "none",
          color: "white",
          boxShadow: "none",
          fontSize: "0.8rem",
          border: "2px solid #1F76A4",
          "&.Mui-disabled": {
            color: "white",
            opacity: 0.7,
            border: "none"
          },
          "&:hover": {
            backgroundColor:"#14AFF1",
            border: "2px solid #7FCEF1",
          }
        }
      }
    },
    MuiFilledInput: {
      styleOverrides: {
        input: {
          backgroundColor: "white",
          borderRadius: "5px",
          "&:after":{
            borderBottom: "2px solid white",
            backgroundColor: "white",
            color:"white"
          }
        }  
      }
    }  
  }
});

export default function Add(props) {
  const {setSnackopen, setStatus, setRefresh, refresh, setSelect} = props;
  const [open, setOpen] = useState(false);
  const [newData, setNewData] = useState({
    customerOrderID: "",
      salesOrg: "",
      distributionChannel: "",
      customerNumber: "",
      companyCode: "",
      orderCurrency: "",
      amountInUSD: "",
      orderCreationDate:"",
  });

  let name, value;

  const handleChange = (e) => {
    name = e.target.name;
    value = e.target.value;
    setNewData({ ...newData, [name]: value });
  };

  const handleClickOpen = () => {
    setOpen(true);
  };

  const handleClose = () => {
    setOpen(false);
    setNewData({
      ...newData,
      customerOrderID: "",
      salesOrg: "",
      distributionChannel: "",
      customerNumber: "",
      companyCode: "",
      orderCurrency: "",
      amountInUSD: "",
      orderCreationDate:"",
    });
  };

  const handleAdd = async (e) => {
    e.preventDefault();
    const {
      customerOrderID, salesOrg,
      distributionChannel, customerNumber, companyCode, orderCurrency, amountInUSD,orderCreationDate
    } = newData;
    await axios
      .post(
        "http://localhost:8080/JDBC/insert",
        queryString.stringify({
          customerOrderID, salesOrg,
          distributionChannel, customerNumber, companyCode, orderCurrency, amountInUSD,orderCreationDate
        })
      )
      .then((res) => {
        setStatus(res.data);
        setOpen(false);
        setSnackopen(true);
        setNewData({
          ...newData,
           customerOrderID: "",
      salesOrg: "",
      distributionChannel: "",
      customerNumber: "",
      companyCode: "",
      orderCurrency: "",
      amountInUSD: "",
      orderCreationDate:"",
        });
        setRefresh(refresh+1);
        setSelect([]);
      })
      .catch((err) => {
        setSnackopen(true);
        setStatus(err);
        setOpen(false);
        setRefresh(refresh+1);
        setSelect([]);
      });
  };

  return (
    <ThemeProvider theme={theme}>
      <Button
        variant="outlined"
        onClick={handleClickOpen}
        fullWidth
      >
        ADD
      </Button>
      <Dialog open={open} onClose={() => setOpen(false)} maxWidth="lg" >
        <DialogTitle style={{backgroundColor:"#2A3E4C", color:"white" }}>Add</DialogTitle>
        <DialogContent style={{ paddingTop: 10, backgroundColor:"#2A3E4C" }}>
          <DialogContentText component={'div'}>
            <Grid
              container
              direction="row"
              alignItems="center"
              spacing={{ xs: 2, md: 3 }}
              columns={{ xs: 4, sm: 8, md: 12 }}
            >
              <Grid item xs={2} sm={4} md={3}>
              <TextField
  label="Customer Order ID"
  variant="filled"
  fullWidth
  name="customerOrderID"
  value={newData.customerOrderID}
  onChange={handleChange}
  InputLabelProps={{ required: true }}
/>
              </Grid>
              <Grid item xs={2} sm={4} md={3}>
                <TextField
                  label="Cust Number"
                  variant="filled"
                  fullWidth
                  name="cust_number"
                  value={newData.cust_number}
                  onChange={handleChange}
                  InputLabelProps={{ required: true }}
                />
              </Grid>
              <Grid item xs={2} sm={4} md={3}>
              <TextField
  label="Sales Org"
  variant="filled"
  fullWidth
  name="salesOrg"
  value={newData.salesOrg}
  onChange={handleChange}
  InputLabelProps={{ required: true }}
/>
              </Grid>
              <Grid item xs={2} sm={4} md={3}>
              <TextField
  label="Distribution Channel"
  variant="filled"
  fullWidth
  name="distributionChannel"
  value={newData.distributionChannel}
  onChange={handleChange}
  InputLabelProps={{ required: true }}
/>
              </Grid>
              <Grid item xs={2} sm={4} md={3}>
              <TextField
  label="Customer Number"
  variant="filled"
  fullWidth
  name="customerNumber"
  value={newData.customerNumber}
  onChange={handleChange}
  InputLabelProps={{ required: true }}
/>
              </Grid>
              <Grid item xs={2} sm={4} md={3}>
              <TextField
  label="Company Code"
  variant="filled"
  fullWidth
  name="companyCode"
  value={newData.companyCode}
  onChange={handleChange}
  InputLabelProps={{ required: true }}
/>
              </Grid>
              <Grid item xs={2} sm={4} md={3}>
              <TextField
  label="Order Currency"
  variant="filled"
  fullWidth
  name="orderCurrency"
  value={newData.orderCurrency}
  onChange={handleChange}
  InputLabelProps={{ required: true }}
/>
              </Grid>
              <Grid item xs={2} sm={4} md={3}>
              <TextField
  label="Amount in USD"
  variant="filled"
  fullWidth
  name="amountInUSD"
  value={newData.amountInUSD}
  onChange={handleChange}
  InputLabelProps={{ required: true }}
/>
              
              </Grid>
            </Grid>
          </DialogContentText>
        </DialogContent>
        <DialogActions style={{backgroundColor:"#2A3E4C"}}>
        <Tooltip title="You have to filled all the Information">
          <span style={{width:"100%" ,marginRight:10}}>
          <Button
            onClick={handleAdd}
            fullWidth
            variant="outline"
            disabled={
              newData.customerOrderID === "" ||
  newData.salesOrg === "" ||
  newData.distributionChannel === "" ||
  newData.customerNumber === "" ||
  newData.companyCode === "" ||
  newData.orderCurrency === "" ||
  newData.amountInUSD === "" ||
  newData.orderCreationDate

                ? true 
                : false
            }
            style={{border:"1px solid white"}}
          >
            ADD
          </Button>
          </span>
          </Tooltip>
          <Button onClick={handleClose} fullWidth variant="outline" style={{border:"1px solid white"}}>
            CANCEL
          </Button>
        </DialogActions>
      </Dialog>
    </ThemeProvider>
  );
}
