## Introducción: Pedido del colegio

El equipo directivo del colegio manifestó la necesidad de mejorar y unificar la gestión de las notificaciones enviadas a responsables y docentes. Actualmente, existen distintos canales y criterios dispares según el tipo de comunicación (administrativas, disciplinarias, educativas o generales). Además, algunos responsables manifestaron su interés en recibir solo cierto tipo de comunicaciones, lo que requiere un mecanismo de suscripción flexible.

Esta necesidad se formalizó en los documentos "**pedidos-del-colegio.md**" y "**Gestion-de-la-Comunicacion-Colegios.md**", donde se establecen los distintos tipos de notificaciones y las reglas para determinar a quién deben enviarse.

---

## Historias de usuario implementadas

### Historia 1: Como responsable quiero recibir solo las notificaciones administrativas que yo solicite
**Criterios:**
- Cada responsable puede decidir si desea o no recibir comunicaciones administrativas.
- El sistema debe filtrar destinatarios según esa preferencia.
- La suscripción puede cambiarse en cualquier momento mediante métodos específicos del dominio (sin setters).

### Historia 2: Como colegio quiero asegurarme que las notificaciones disciplinarias se envíen a todos los responsables del estudiante
**Criterios:**
- Independientemente del rol (madre, padre, tutor), todos los responsables asignados a un estudiante deben ser notificados ante eventos disciplinarios.
- No se consideran preferencias de suscripción en este tipo de comunicación.

### Historia 3: Como docente quiero que los responsables de mi curso reciban comunicaciones educativas
**Criterios:**
- Todos los responsables de los alumnos del curso deben ser notificados.
- El docente responsable también debe estar incluido como destinatario.

### Historia 4: Como colegio quiero enviar comunicados generales a todos los responsables y docentes
**Criterios:**
- Incluye a todos los responsables registrados del sistema.
- También a todos los docentes activos.

---

## Modelo adoptado (arquitectura y dominio)

### Enfoque DDD + Hexagonal

Se modeló el sistema usando arquitectura hexagonal con fuerte orientación DDD:

- **Agregado principal:** `StudentRecord`, que representa la relación del estudiante con sus responsables.
- **Entidad relevante:** `ResponsibleAdult`, que encapsula nombre, email, preferencias de suscripción y otros datos de contacto.
- **Interface de dominio:** `NotificationRecipient`, implementada por `ResponsibleAdult`, `GuardianAssignment` y `Teacher`.
- **Políticas de negocio:** `NotificationPolicy` y sus implementaciones:
  - `AdministrativeNotificationPolicy`
  - `DisciplinaryNotificationPolicy`
  - `EducationalNotificationPolicy`
  - `GeneralNotificationPolicy`
- **Contexto compartido:** `NotificationContext`, usado para encapsular información necesaria por las políticas.

### Principios aplicados:
- Ningún setter público.
- Los cambios de estado (como suscripción) se hacen mediante métodos expresivos: `enableAdministrativeNotifications()`.
- Tests unitarios completos para cada política.
- Fábrica `NotificationContextFactory` para facilitar la construcción del contexto en tests y casos de uso.

Este enfoque garantiza un dominio limpio, desacoplado, y preparado para crecer según evolucione el negocio.

