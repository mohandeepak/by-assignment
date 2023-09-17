import React from 'react';
import { AgGridReact } from 'ag-grid-react';

function ApiGrid({ rowData, onGridReady, columnDefs, defaultColDef }) {
  return (
    <div className="ag-theme-alpine" style={{ height: 400, width: '100%' }}>
      <AgGridReact
        onGridReady={onGridReady}
        rowData={rowData}
        columnDefs={columnDefs}
        pagination={true}
        paginationPageSize={10}
        suppressCellSelection={false}
        defaultColDef={defaultColDef}
      ></AgGridReact>
    </div>
  );
}
export default ApiGrid;