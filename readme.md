## Questões

### 1. Qual é a diferença entre autenticação e autorização? Exemplifique com o projeto.

Autenticação em um sistema é o ato de um usuário inserir suas credenciais, algo que só ele saiba, de modo que comprove que ele é realmente quem diz ser. Autorização é quando esse usuário tem acesso ou não a determinadas páginas em um sistema. Um exemplo disso é a diferenciação do acesso entre um usuário comum e um administrador, em que esse último possui autorização para acessar mais coisas que o primeiro.

### 2. Para que servem `SecurityFilterChain`, `UserDetailsService` e `PasswordEncoder`?

- SecurityFilterChain é o modo como o Spring Security define a política de autorização dos endpoints; 
- UserDetailsService retorna um objeto UserDetails, que contém as informações do usuário. Juntas, elas fornecem uma maneira de obter e validar o usuário;
- PasswordEncoder é a função de criptografar a senha do usuário, fornecendo maior segurança.

### 3. Qual é a diferença entre os códigos HTTP 401 e 403?

401 ocorre quando o usuário não está autenticado ou informou credenciais inválidas. 403 ocorre quando o usuário está autenticado (logado), mas não tem permissão de acesso.

### 4. Como as regras de acesso foram configuradas?

Em cima das rotas e das funções, foi utilizado um decorator que diz qual nível de acesso o usuário precisa ter para acessar aquela rota.

### 5. O que é CSRF e como foi tratado no projeto?

É uma medida de proteção contra ataques cibernéticos em que cada requisição HTTP possui um código único. Para esse exemplo, essa medida foi desabilitada, pois não irá trafegar na internet.

## Usuários para teste

| Papel | Login | Senha |
|---|---|---|
| ADMIN | `Ademir` | `adm1234` |
| USER | `Ursula` | `usr1234` |

