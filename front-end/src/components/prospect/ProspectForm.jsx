import React from "react";
import {Button, Grid} from "@material-ui/core";
import InputField from "./fields/InputField";

import PropTypes from 'prop-types';

const ProspectForm = ({ handleSubmit }) => {
  return(
    <>
      <form onSubmit={handleSubmit}>
        <Grid item xs={12}>
          <InputField name="fullName"
                      label="Full Name"
                      type="text"/>
          <InputField name="totalLoan"
                      label="Total Loan"
                      type="number"/>
        </Grid>
        <Grid item xs={12}>
          <InputField name="interest"
                      label="Interest"
                      type="number"/>
          <InputField name="years"
                      label="Years"
                      type="number"/>
        </Grid>
        <Button type="submit" value="submit">
          Submit
        </Button>
      </form>
    </>
  )
}

ProspectForm.propTypes = {
  handleSubmit: PropTypes.func.isRequired,
};

export default ProspectForm;
