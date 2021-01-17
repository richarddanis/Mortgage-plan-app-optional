import React from "react";
import {TableCell, TableRow} from "@material-ui/core";

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

export default MortgageTableRowView;
