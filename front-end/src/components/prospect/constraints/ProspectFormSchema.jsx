import * as Yup from "yup";

const ProspectFormSchema = Yup.object().shape({
  fullName: Yup.string().min(1, "Too Short!").required("Required field."),
  totalLoan: Yup.number().positive("Must be more than zero.").required("Required field."),
  interest: Yup.number().positive("Must be more than zero.").required("Required field."),
  years: Yup.number().positive("Must be more than zero.").required("Required field."),
})

export default ProspectFormSchema;
