import React from 'react';

function SearchBar({ searchText, setSearchText, filterData }) {
  return (
    <div className="row">
      <div className="col-md-6">
        <div className="input-group mb-3">
          <input
            type="text"
            className="form-control"
            placeholder="Search..."
            value={searchText}
            onChange={(e) => setSearchText(e.target.value)}
          />
          <div className="input-group-append">
            <button
              className="btn btn-primary"
              type="button"
              onClick={filterData}
            >
              Search
            </button>
            <button
              className="btn btn-secondary"
              type="button"
              onClick={() => setSearchText('')}
            >
              Reset
            </button>
          </div>
        </div>
      </div>
    </div>
  );
}

export default SearchBar;
