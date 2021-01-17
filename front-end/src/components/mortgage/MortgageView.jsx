import React, {useContext, useEffect, useState} from "react";
import MortgageTableRow from "./MortgageTableRow";
import {LinearProgress, Table, TableContainer} from "@material-ui/core";
import MortgageContext from "../../context/MortgageContext";
import {getMortgages} from "../../services/service";

const MortgageView = () => {
  const { shouldUpdate, setTableUpdate } = useContext(MortgageContext);

  const [isLoading, setLoad] = useState(true);
  const [isFailed, setFailed] = useState(false);
  const [list, setList] = useState([]);

  useEffect(() => {
    getMortgages()
      .then(items => {
        const sentences = items.slice().map((item) => {
          return `${item.customerName} wants to borrow ${item.borrow.toFixed(2)}  € for a period of ${item.period} years and pay ${item.paymentPerMonth.toFixed(2)} € each month`
        })
        setList(sentences)
      })
      .then(() => setLoad(false))
      .catch(() => setFailed(true))
    setTableUpdate(false);
  }, [shouldUpdate])

  return (
    <>
      <h2>Report Section</h2>
      {isFailed ? <>Error, cannot load the table.</> :
          isLoading ? <LinearProgress/> :
            <TableContainer>
              <Table>
                <MortgageTableRow list={list}/>
              </Table>
            </TableContainer>
        }
    </>
  );
};

export default MortgageView;
