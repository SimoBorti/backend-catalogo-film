# 🎬 Movie Info Backend (Java & Spring Boot)

Modulo backend sviluppato in **Java** con il framework **Spring Boot** per la gestione e consultazione di informazioni relative al mondo del cinema (schede film, dettagli sul cast, recensioni degli utenti e altro).

> ℹ️ **Nota sul Repository:** Questo repository raccoglie esclusivamente la logica di business e l'architettura backend da me sviluppata. Trattandosi della sola componente applicativa estratta dall'ecosistema complessivo, non include file di ambiente o l'interfaccia frontend, ed è pensata come dimostrazione delle scelte architetturali e di codice.

---

## 🏛️ Architettura & Pattern
Il progetto adotta il pattern **MVC (Model-View-Controller)** strutturato su una classica architettura a livelli (*Layered Architecture*):
* **Controller:** Gestione delle endpoint e dell'instradamento delle richieste.
* **Service:** Logica di business e regole applicative.
* **Repository / DAO:** Astrazione dell'accesso ai dati e query.

---

## 🛠️ Stack Tecnologico
* **Linguaggio:** Java
* **Framework:** Spring Boot (Spring MVC, Spring Data JPA)
* **Database:** PostgreSQL
* **Persistenza:** JPA / Hibernate

---

## 🎯 Componenti Implementate
All'interno di questo modulo mi sono occupato di:
* Modellazione delle entità di dominio e delle relative relazioni su **PostgreSQL** (es. relazioni tra Film, Attori/Cast e Recensioni).
* Implementazione dei servizi per la ricerca, il recupero e la manipolazione delle informazioni cinematografiche.
* Strutturazione dell'architettura layered per garantire manutenibilità e separazione delle responsabilità.
