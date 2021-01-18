import React from "react";
import { TableBody } from "@material-ui/core";
import MortgageTableRowView from "./MortgageTableRowView";

import PropTypes from 'prop-types';

const MortgageTableRow = ({list}) => {

  return (
      <>
        <TableBody>
          { list.map((row, index) => (<MortgageTableRowView key={index} sentence={row}/>)) }
        </TableBody>
      </>
  );
}

MortgageTableRow.propTypes = {
  list: PropTypes.array.isRequired,
};

export default MortgageTableRow;
