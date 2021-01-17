import React from "react";
import { TableBody } from "@material-ui/core";
import MortgageTableRowView from "./MortgageTableRowView";

const MortgageTableRow = ({list}) => {

  return (
      <>
        <TableBody>
          { list.map((row, index) => (<MortgageTableRowView key={index} sentence={row}/>)) }
        </TableBody>
      </>
  );
}

export default MortgageTableRow;
