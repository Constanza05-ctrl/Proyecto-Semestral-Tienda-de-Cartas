# Proyecto-Semestral-Tienda-de-Cartas

# Proyecto Semestral: NextCard
## Integrantes: Felipe Acuña, Constanza Carrasco, Cristóbal Hermosilla

### Estado del Sistema (Hito 1)
| Microservicio | Puerto | DB Name | Funcionalidad |
| :--- | :--- | :--- | :--- |
| Usuario | Instancia_2:8080 | _db | CRUD de Usuario |
| Catalogo | Instancia_1:8080 | CatalogoDB | CRUD de Producto |
| Tienda | Instancia_1:8081 | TiendaDB | CRUD de Tienda |

### Despliegue Técnico
- **Instancias** 3 instancias de AWS EC2 t3.large (Ubuntu 24.04)
- **Comando de inicio:** `docker compose up -d`
