import React from 'react';
import { render, screen, waitFor } from '@testing-library/react';
import App from './App';

global.fetch = jest.fn();

describe('App Component', () => {
  afterEach(() => {
    jest.clearAllMocks();
  });

  it('renders without errors', () => {
    render(<App />);
    const headerElement = screen.getByText(/API results/i);
    expect(headerElement).toBeInTheDocument();
  });

  it('fetches and displays mocked API data', async () => {
    const mockResponse = {
      entries: [
        {
          API: 'Catalog',
          Description: 'Catalog description',
        },
      ],
    };

    fetch.mockResolvedValueOnce({
      ok: true,
      json: async () => mockResponse,
    });

    render(<App />);

    await waitFor(() => {
      expect(screen.getByText('Catalog')).toBeInTheDocument();
      expect(screen.getByText('Catalog description')).toBeInTheDocument();
    });
  });
});