import React, {useContext, useState} from "react";
import { Formik } from "formik";
import ProspectForm from "./ProspectForm";
import {addProspects} from "../../services/service";
import MortgageContext from "../../context/MortgageContext";
import ProspectFormSchema from "./constraints/ProspectFormSchema";

const ProspectView = () => {

  const { setTableUpdate } = useContext(MortgageContext);
  const [isFailed, setIsFailed] = useState(false);

  return (
    <>
      <h2>Add new prospect</h2>
      <Formik
        initialValues={{fullName: "", totalLoan: 0, interest: 0, years: 0}}
        validationSchema={ProspectFormSchema}
        onSubmit={
          (values, { resetForm }) => {
            const isFailed = addProspects(values);
            if(isFailed) {
              setIsFailed(isFailed);
            } else {
              setTableUpdate(true);
              resetForm({});
            }
          }
        }
        children={(props) => <ProspectForm {...props}/>}
      />
      {isFailed ? <> Cannot save the data, pls check your input is valid or try again later. </> : null}
    </>
  );
};

export default ProspectView;
