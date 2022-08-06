import { HomePage, UserInfoPage, LoginPage } from './pages';
import { BrowserRouter, Link, Outlet, Route, Routes } from 'react-router-dom';
import { PrivateRoute } from './routes';
import { Navbar } from './components';
import { Layout, Switch } from 'antd';
import './App.css';


const { Header, Content, Footer } = Layout;
function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path='/' element={
          <Layout className="layout">
            <Header>
              <Navbar />
            </Header>
            <Content style={{ padding: '0 50px' }}>
              <Outlet></Outlet>
            </Content>
            <Footer style={{ textAlign: 'center' }}>Ant Design ©2018 Created by Ant UED</Footer>
          </Layout>
        }>
          <Route path='/' element={<HomePage />}></Route>
          <Route path='/login' element={<LoginPage />}></Route>
          <Route path='/secured' element={
            // @ts-ignore
            <PrivateRoute>
              <UserInfoPage />
            </PrivateRoute>
          }></Route>
        </Route>
      </Routes>
    </BrowserRouter>
    // <div className="App">
    // <BrowserRouter>
    // <Header />
    //   <nav
    //     style={{
    //       borderBottom: "solid 1px",
    //       paddingBottom: "1rem",
    //     }}
    //   >
    //     <Link to="/">Home</Link> |{" "}
    //     <Link to="/secured">User Info</Link>
    //   </nav>
    //   <Routes>
    //     <Route path='/' element={<HomePage />}></Route>
    //     <Route path='/login' element={<LoginPage />}></Route>
    //     <Route path='/secured' element={
    //       // @ts-ignore
    //       <PrivateRoute>
    //         <UserInfoPage />
    //       </PrivateRoute>
    //     }></Route>
    //   </Routes>
    // </BrowserRouter>
    // </div>
  );
}

export default App;
