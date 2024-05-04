import React from 'react';
import { createBrowserRouter, Routes, RouterProvider } from 'react-router-dom';
import route from './config/route';
import Layout from './components/Layout';
import Home from './pages/Home';
import User from './pages/User';
import Group from './pages/Group';

const router = createBrowserRouter([
  {
    path: route.home,
    element: (
      <Layout>
        <Home/>
      </Layout>
    )
  },{
    path: route.user,
    element: (
      <Layout>
        <User/>
      </Layout>
    )
  },{
    path: route.group,
    element: (
      <Layout>
        <Group/>
      </Layout>
    )
  }
]);
function App() {
  return (
    <RouterProvider router={router}>
      <Routes/>
    </RouterProvider>
  );
}

export default App;
