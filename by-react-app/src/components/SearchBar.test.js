import React from 'react';
import { render, screen, fireEvent } from '@testing-library/react';
import SearchBar from './SearchBar';

describe('SearchBar Component', () => {
  it('should render the search input and buttons', () => {
    const { getByPlaceholderText, getByText } = render(
      <SearchBar searchText="" setSearchText={() => {}} filterData={() => {}} />
    );

    const searchInput = getByPlaceholderText('Search...');
    const searchButton = getByText('Search');
    const resetButton = getByText('Reset');

    expect(searchInput).toBeInTheDocument();
    expect(searchButton).toBeInTheDocument();
    expect(resetButton).toBeInTheDocument();
  });

  it('should reset the input field when clicking the Reset button', () => {
    const setSearchText = jest.fn();
    const { getByText } = render(
      <SearchBar searchText="test" setSearchText={setSearchText} filterData={() => {}} />
    );
    const resetButton = getByText('Reset');

    fireEvent.click(resetButton);

    expect(setSearchText).toHaveBeenCalledWith('');
  });
});