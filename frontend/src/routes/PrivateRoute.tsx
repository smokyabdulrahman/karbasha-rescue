import { useKeycloak } from "@react-keycloak/web";
import React from "react";
import { Navigate } from "react-router-dom";

export const PrivateRoute = ({ children }: { children: React.ReactNode }) => {
    const { keycloak, initialized } = useKeycloak();
    if (!initialized) {
        return;
    }

    if (initialized && !keycloak?.authenticated) {
        return <Navigate to="/login" />;
    }

    return children;
}