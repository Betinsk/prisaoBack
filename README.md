# Prisão Federal - Sistema de Gestão Prisional

## 📝 Descrição
O **Prisão Federal** é um sistema de gestão prisional inspirado em séries como *The Orange Is the New Black* e *Breaking Bad*.  
Permite gerenciar **detentos, funcionários, unidades prisionais, atividades e eventos internos**, com dashboard analítico e autenticação segura.

O backend é desenvolvido em **Java Spring Boot** usando **JPA/Hibernate** com **PostgreSQL**, e o frontend em **React**.

---

## 💻 Tecnologias
- **Backend:** Java 17+, Spring Boot, JPA, Hibernate, PostgreSQL  
- **Frontend:** React, React Query
- **Autenticação:** Spring Security JWT  
- **Túnel de Desenvolvimento:** Cloudflare Tunnel  
- **Banco local (dev):** H2 em modo compatível PostgreSQL  

---

## 🚀 Estrutura do Projeto

### Backend (Spring Boot)

src/main/java/com/prisaofederal/
├─ controller/ # Endpoints REST
├─ entity/ # Entidades JPA
├─ repository/ # Repositórios JPA
├─ service/ # Lógica de negócio
└─ config/ # Configurações (Security, DB, JWT)
# Frontend (React)
src/
├─ components/ # Componentes React
├─ hooks/ # Hooks customizados (ex: useDetentos)
├─ pages/ # Telas do sistema
├─ services/ # Chamadas à API (fetch/axios)
└─ utils/ # Funções auxiliares

🔑 Funcionalidades Principais

Gerenciamento de detentos (cadastro, movimentação, histórico)
Gerenciamento de funcionários e permissões
Controle de unidades prisionais e celas
Registro de atividades internas (trabalho, estudos, eventos)
Dashboard com estatísticas e gráficos
Autenticação com Spring Security + JWT

📚 Referências

Spring Boot Docs
Hibernate / JPA Docs
React Docs
Cloudflare Tunnel Docs
