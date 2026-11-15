# Schemat bazy danych

Plik generują reguły projektu (panel Maven → Lifecycle → verify). Nie edytujcie go ręcznie.

Tabele: 6 · kolumny: 39 · relacje: 4 × @ManyToOne, 1 × @OneToMany, 1 × @OneToOne, 0 × @ManyToMany

| Tabela | Encja | Kolumny | Klucze obce |
|---|---|---|---|
| amenity | Amenity | 5 | — |
| booking | Booking | 9 | client_id, room_id |
| booking_amenity | BookingAmenity | 5 | amenity_id, booking_id |
| client | Client | 9 | user_account_id |
| conference_room | ConferenceRoom | 6 | — |
| user_account | UserAccount | 5 | — |

```mermaid
erDiagram
    amenity {
        Long id PK
        Boolean available
        String description
        String name
        BigDecimal unit_price
    }
    booking {
        Long id PK
        Integer attendees
        Long client_id FK
        LocalDateTime created_at
        LocalDateTime end_time
        Long room_id FK
        LocalDateTime start_time
        BookingStatus status
        String title
    }
    booking_amenity {
        Long id PK
        Long amenity_id FK
        Long booking_id FK
        String note
        Integer quantity
    }
    client {
        Long id PK
        String city
        String company_name
        String contact_person
        String email
        String phone
        String postal_code
        String street
        Long user_account_id FK
    }
    conference_room {
        Long id PK
        Integer capacity
        Integer floor_number
        Boolean has_projector
        BigDecimal hourly_rate
        String name
    }
    user_account {
        Long id PK
        LocalDateTime created_at
        String display_name
        String email
        AccountRole role
    }
    amenity ||--o{ booking_amenity : "amenity_id"
    booking ||--o{ booking_amenity : "booking_id"
    client ||--o{ booking : "client_id"
    conference_room ||--o{ booking : "room_id"
    user_account |o--o| client : "user_account_id"
```
