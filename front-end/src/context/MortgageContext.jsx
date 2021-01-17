import { createContext } from "react";

const MortgageContext = createContext({
  shouldUpdate: false,
  setTableUpdate: () => {}
});

export default MortgageContext;
