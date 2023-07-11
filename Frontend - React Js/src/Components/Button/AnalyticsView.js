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
  Typography,
} from "@mui/material";
import axios from "axios";
import { createTheme, ThemeProvider } from "@mui/material/styles";
import DialogChart from "../Chart/Dialog";
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
          borderRadius: "0px",
          "&.Mui-disabled": {
            color: "white",
            opacity: 0.7,
            border: "none",
          },
          "&:hover": {
            backgroundColor: "#14AFF1",
            border: "2px solid #7FCEF1",
          },
        },
      },
    },
    MuiFilledInput: {
      styleOverrides: {
        root: {
          margin: 6,
        },
        input: {
          backgroundColor: "white",
          borderRadius: "5px",
          "&:after": {
            borderBottom: "2px solid white",
            backgroundColor: "white",
            color: "white",
          },
        },
      },
    },
  },
});

export default function AnalyticsView() {
  const [open, setOpen] = useState(false);
  const [chartOpen, setChartOpen] = useState(false);
  const [newData, setNewData] = useState({
    distributionChannel: "",
    customerNumber: "",
    
  });
  const [chart, setChart] = useState({
    distributionChannel: "",
    customerNumber: "",
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
      distributionChannel: "",
      customerNumber: "",
    });
  };

  const handleAnalytics = async (e) => {
    e.preventDefault();
    const {
      distributionChannel,
      customerNumber,
    } = newData;
    await axios
      .post(
        "http://localhost:8080/JDBC/analytics",
        queryString.stringify({
          distributionChannel: "",
          customerNumber: "",
        })
      )
      .then((res) => {
        setOpen(false);        
        setChart({
          businessCode:res.data.business.map(item=>item.BusinessCode),
          customerNumber:res.data.business.map(item=>item.NumberOfCust),
          totalAmount:res.data.business.map(item=>item.TotalAmount),
          invoice:res.data.count.map(item=>item.Invoice),
          count:res.data.count.map(item=>item.Count)
        })
        setNewData({
          ...newData,
          distributionChannel: "",
    customerNumber: "",
        });
        setChartOpen(true);
      })
      .catch((err) => {
        setOpen(false);
      });
  };

  return (
    <ThemeProvider theme={theme}>
      <Button variant="outlined" onClick={handleClickOpen} fullWidth>
        ANALYTICS REVIEW
      </Button>
      <Dialog open={open} onClose={() => setOpen(false)} maxWidth="sm">
        <DialogTitle style={{ backgroundColor: "#2A3E4C", color: "white" }}>
          Analytics View
        </DialogTitle>
        <DialogContent style={{ paddingTop: 20, backgroundColor: "#2A3E4C" }}>
          <DialogContentText component={"div"}>
            <Grid
              container
              direction="row"
              justifyContent="center"
              alignItems="flex-start"
              spacing={{ xs: 2, md: 3 }}
              columns={{ xs: 4, sm: 8, md: 12 }}
            >
              
              <Grid item xs={12} md={6}>
                <Typography style={{ color: "white" }}>
                  Invoice Currency
                </Typography>
                <TextField
                  label="DISTRIBUTION CHANNEL"
                  variant="filled"
                  fullWidth
                  name="distributionChannel"
                  value={newData.invoice_currency}
                  onChange={handleChange}
                />
              </Grid>
              
              <Grid item xs={12} md={6}>
                <Typography style={{ color: "white" }}>
                  Invoice Currency
                </Typography>
                <TextField
                  label="CUSTOMER NUMBER"
                  variant="filled"
                  fullWidth
                  name="customerNumber"
                  value={newData.invoice_currency}
                  onChange={handleChange}
                />
              </Grid>
            </Grid>
          </DialogContentText>
        </DialogContent>
        <DialogActions style={{ backgroundColor: "#2A3E4C" }}>
          <Button
            onClick={handleAnalytics}
            fullWidth
            variant="outline"
            style={{
              border: "1px solid white",
              borderRadius: 5,
              marginRight: 10,
            }}
          >
            VIEW
          </Button>
          <Button
            onClick={handleClose}
            autoFocus
            fullWidth
            variant="outline"
            style={{ border: "1px solid white", borderRadius: 5 }}
          >
            CANCEL
          </Button>
        </DialogActions>
      </Dialog>
      <DialogChart open={chartOpen} setOpen={setChartOpen} chart={chart} />
    </ThemeProvider>
  );
}
