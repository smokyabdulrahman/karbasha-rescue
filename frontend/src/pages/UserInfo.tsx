import { useKeycloak } from '@react-keycloak/web'

export const UserInfoPage = () => {
  const { keycloak } = useKeycloak()

  return (
    <div>
      <div>Hi {keycloak?.tokenParsed?.preferred_username}!</div>
    </div>
  )
}