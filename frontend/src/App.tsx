import React from 'react';
import logo from './logo.svg';
import './App.css';
import { HomePage, UserInfoPage, LoginPage } from './pages';
import { BrowserRouter, Link, Route, Routes } from 'react-router-dom';
import { PrivateRoute } from './routes';

function App() {
  return (
    <div className="App">
      <BrowserRouter>
        <nav
          style={{
            borderBottom: "solid 1px",
            paddingBottom: "1rem",
          }}
        >
          <Link to="/">Home</Link> |{" "}
          <Link to="/secured">User Info</Link>
        </nav>
        <Routes>
          <Route path='/' element={<HomePage />}></Route>
          <Route path='/login' element={<LoginPage />}></Route>
          <Route path='/secured' element={
            // @ts-ignore
            <PrivateRoute>
              <UserInfoPage />
            </PrivateRoute>
          }></Route>
        </Routes>
      </BrowserRouter>
    </div>
  );
}

export default App;
