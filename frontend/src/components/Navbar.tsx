import { Menu } from "antd";
import { MenuProps } from "rc-menu";
import { useMemo } from "react";
import { Navigate, useNavigate } from "react-router-dom";

// works when >=4.20.0, recommended ✅
// const items = [
//   { label: <span>Login</span>, key: 'login' },
//   { label: <span>User Profile</span>, key: 'user-profile' },
// ];

export const Navbar = () => {
  const navigate = useNavigate();
  const items = useMemo(() => {
    return [
      { label: 'Login', key: 'login', onClick: () => navigate('/login')},
      { label: 'User Profile', key: 'user-profile', onClick: () => navigate('/secured')},
    ]
  }, []); 

  // @ts-ignore
  return <Menu mode="horizontal" items={items} />
};