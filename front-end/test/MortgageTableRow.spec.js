import React from 'react';
import renderer from 'react-test-renderer';

import MortgageTableRow from "../src/components/mortgage/MortgageTableRow";

describe('MortgageTableRow', () => {
  it('renders correctly with items', () => {
    const itemList = ['test', 'test2']
    const tree = renderer.create(<MortgageTableRow list={itemList}/>).toJSON();

    expect(tree).toMatchSnapshot();
  })
})
