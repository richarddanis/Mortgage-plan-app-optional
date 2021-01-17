import React from "react";
import { useField } from "formik";
import {TextField} from "@material-ui/core";

const InputField = ({...props}) => {
  const [field, meta] = useField(props);

  return(
    <>
      <
        TextField type="text" {...field} {...props}
                  error={meta.touched && meta.error != null}
                  helperText={meta.error}
      />
    </>
  );
};

export default InputField;
