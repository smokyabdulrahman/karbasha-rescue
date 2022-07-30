import { useKeycloak } from "@react-keycloak/web"

export const LoginPage = () => {
    const { keycloak, initialized } = useKeycloak();

    return (
        <div>
            <h1>Unfortunatly! you aren't signed in, please sign in to go to the protected pages.</h1>
            <button onClick={() => keycloak.login()}>Login!</button>
        </div>
    )
}