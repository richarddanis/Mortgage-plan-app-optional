import React from "react";
import {TableCell, TableRow} from "@material-ui/core";

import PropTypes from 'prop-types';

const MortgageTableRowView = ({ sentence }) => {
  return (
    <>
      <TableRow>
        <TableCell align="center">
          { sentence }
        </TableCell>
      </TableRow>
    </>
  );
}

MortgageTableRowView.propTypes = {
  sentence: PropTypes.string.isRequired,
};

export default MortgageTableRowView;
