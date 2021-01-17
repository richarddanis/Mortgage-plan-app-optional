import React, {useState} from 'react';
import MortgageView from "./components/mortgage/MortgageView";
import { Container, Card, CardContent } from '@material-ui/core';
import ProspectView from "./components/prospect/ProspectView";
import MortgageContext from "./context/MortgageContext";

function App() {
  const [shouldUpdate, setTableUpdate] = useState(false);

  return (
    <>
      <MortgageContext.Provider value={{ shouldUpdate, setTableUpdate }}>
        <Container fixed>
          <Card>
            <CardContent>
              <ProspectView/>
            </CardContent>
          </Card>
          <Card>
            <CardContent>
              <MortgageView/>
            </CardContent>
          </Card>
        </Container>
      </MortgageContext.Provider>
    </>
  );
}

export default App;
