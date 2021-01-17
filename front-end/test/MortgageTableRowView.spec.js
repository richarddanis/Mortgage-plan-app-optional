import React from 'react';
import renderer from 'react-test-renderer';

import MortgageTableRowView from "../src/components/mortgage/MortgageTableRowView";

describe('MortgageTableRowView', () => {
  it('should render', () => {
    const tree = renderer.create(<MortgageTableRowView sentence={'test sentence'}/>).toJSON();

    expect(tree).toMatchSnapshot();
  })
})
