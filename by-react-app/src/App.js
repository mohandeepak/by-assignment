import React, { useState, useEffect } from 'react';
import 'ag-grid-community/styles/ag-grid.css';
import 'ag-grid-community/styles/ag-theme-alpine.css';
import 'bootstrap/dist/css/bootstrap.min.css';
import SearchBar from './SearchBar';
import ApiGrid from './ApiGrid';

function App() {
  const [rowData, setRowData] = useState([]);
  const [gridApi, setGridApi] = useState(null);
  const [error, setError] = useState(null);
  const [searchText, setSearchText] = useState('');

  const columnDefs = [
    { headerName: 'Name', field: 'API', sortable: true, filter: true },
    { headerName: 'Description', field: 'Description', sortable: true, filter: true, width: 300, tooltipField: 'Description' },
    { headerName: 'Auth', field: 'Auth', sortable: true, filter: true, width: 100 },
    { headerName: 'HTTPS', field: 'HTTPS', sortable: true, filter: true, width: 100 },
    { headerName: 'Cors', field: 'Cors', sortable: true, filter: true, width: 100 },
    {
      headerName: 'Link',
      field: 'Link',
      sortable: false,
      filter: false,
      tooltipField: 'Link',
      width: 400
    },
    { headerName: 'Category', field: 'Category', sortable: true, filter: true, width: 250 },
  ];

  useEffect(() => {
    const apiUrl = 'http://localhost:8080/api/entries';
    try {
      fetch(apiUrl)
        .then((response) => {
          if (!response.ok) {
            throw new Error('Server error');
          }
          return response.json();
        })
        .then((result) => {
          setRowData(result.entries);
        })
        .catch((error) => {
          setError(error);
        });
    } catch (error) {
      setError(error);
    }
  }, []);

  const onGridReady = (params) => {
    setGridApi(params.api);
  };

  const defaultColDef = {
    resizable: true,
    enableRangeSelection: true,
  };

  const filterData = () => {
    if (gridApi) {
      gridApi.setQuickFilter(searchText);
    }
  };

  if (error) {
    return (
      <div className="App">
        <h1 style={{ textAlign: 'center', margin: '20px' }}>API results</h1>
        <p>Error: {error.message}</p>
      </div>
    );
  }

  return (
    <div className="App">
      <h1 style={{ textAlign: 'center', margin: '20px' }}>API results</h1>
      <SearchBar searchText={searchText} setSearchText={setSearchText} filterData={filterData} />
      <ApiGrid rowData={rowData} onGridReady={onGridReady} columnDefs={columnDefs} defaultColDef={defaultColDef} />
    </div>
  );
}

export default App;