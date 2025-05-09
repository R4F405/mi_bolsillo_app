# Flujos de Usuario de Mi Bolsillo App

## Flujo: Registrar Nueva Transacción (Ingreso o Gasto)

1.  **Punto de Partida:** Usuario en Pantalla Principal/Dashboard o Lista de Transacciones, pulsa botón "+".
2.  **Transición:** Sistema navega a Pantalla "Nueva Transacción".
3.  **En Pantalla "Nueva Transacción":**
    * Usuario **selecciona el Tipo** ("Ingreso" o "Gasto" - con "Gasto" posiblemente preseleccionado mediante un Segmented Control).
    * Usuario introduce Monto.
    * Usuario selecciona/confirma Fecha (usando selector de fecha).
    * Usuario pulsa un campo/botón "Categoría" que lleva a la Pantalla "Selección de Categoría". Selecciona una categoría y vuelve.
    * Usuario introduce Concepto.
    * Botón "Confirmar Transacción" (o texto dinámico "Confirmar Gasto" / "Confirmar Ingreso").
4.  **Acción del Usuario:** Pulsa "Confirmar Transacción".
5.  **Procesamiento:** Validación de datos. Si hay errores, muestra mensaje en la misma pantalla. Si es correcto, guarda la transacción.
6.  **Feedback y Siguiente Paso:** Muestra mensaje de confirmación breve (Toast/Snackbar). Permanece en la pantalla "Nueva Transacción" con campos de entrada limpios (Monto, Concepto). El Tipo y la Categoría podrían mantenerse preseleccionados de la última entrada para agilizar registros consecutivos.

---

## Flujo: Pantalla Principal / Dashboard

1. **Acceso a la Pantalla:** Al abrir la aplicación, la Pantalla Principal / Dashboard se carga automáticamente.
2. **Información y Controles Visibles por Defecto (para el periodo actual):**
* A. Selector de Periodo:
    * Ubicado en la parte superior de la pantalla.
    * Consiste en flechas de navegación (< Mes Anterior y Mes Siguiente >) y el nombre del mes y año actualmente seleccionado visible entre ellas (ej. "Mayo 2025").
* B. Resumen del Balance (para el periodo seleccionado):
    * Sección más destacada visualmente, situada debajo del selector de periodo.
    * Muestra claramente: Ingresos Totales del periodo. Gastos Totales del periodo. Balance Neto (Ingresos - Gastos).
* C. Gráfico de Desglose de Gastos (para el periodo seleccionado):
    * Ubicado debajo del Resumen del Balance.
    * Tipo: Gráfico circular (Pie Chart).
    * Acompañado de una leyenda que detalla el monto o porcentaje gastado por cada categoría principal.
    * El gráfico no es interactivo (no se puede pulsar en sus porciones para acciones adicionales).
* D. Lista de Transacciones Recientes (para el periodo seleccionado):
    * Situada debajo del Gráfico de Desglose de Gastos.
    * Muestra un resumen de las últimas 3-5 transacciones.
    * Cada ítem de la lista muestra: Categoría y Monto de la transacción.
    * Incluye un botón o enlace claramente visible (ej. "Ver historial completo") para navegar a una pantalla con la lista completa de todas las transacciones.
* E. Botón de Añadir Nueva Transacción:
    * Un Botón de Acción Flotante (FAB) con un icono "+" está presente (generalmente en la esquina inferior derecha), permitiendo al usuario iniciar el registro de una nueva transacción.
3. **Interacciones del Usuario en esta Pantalla:**
* Cambiar el Periodo:
    * Al pulsar las flechas del selector de periodo, la información mostrada en el Resumen del Balance, el Gráfico de Desglose de Gastos y la Lista de Transacciones Recientes se actualiza dinámicamente para reflejar los datos del nuevo periodo seleccionado.
* Ver Historial Completo de Transacciones:
    * Al pulsar el botón/enlace "Ver historial completo", el usuario es redirigido a una pantalla dedicada que muestra todas sus transacciones, con opciones de filtrado y búsqueda.
* Ver Detalles de una Transacción Reciente:
    * Al pulsar sobre un ítem específico en la Lista de Transacciones Recientes, el usuario navega a una pantalla de "Detalle de Transacción", donde puede ver toda la información de esa transacción y, opcionalmente, editarla.
* Añadir Nueva Transacción:
    * Al pulsar el Botón de Acción Flotante (+), se inicia el flujo para "Registrar Nueva Transacción", llevando al usuario a la pantalla correspondiente (Pantalla "Nueva Transacción").
4. **Casos Especiales y Estados de la Pantalla:**
* Estado Vacío (Sin Datos):
    * Si no existen transacciones para el periodo seleccionado (o si es la primera vez que el usuario utiliza la app y no ha registrado ninguna transacción).
    * El Resumen del Balance mostrará valores de cero.
    * En el espacio destinado al Gráfico y la Lista de Transacciones Recientes, se mostrará un mensaje amigable indicando la ausencia de datos y, posiblemente, una invitación a registrar la primera transacción (ej. "Aún no tienes movimientos este mes. ¡Haz clic en '+' para añadir uno!").
* Cargando Datos:
    * Durante los momentos en que la aplicación está recuperando y procesando los datos para mostrar (ej. al cambiar de periodo o al iniciar la app), se mostrará un indicador de progreso visual (ej. un círculo giratorio o una barra de carga sutil) para informar al usuario que la operación está en curso.

---

## Flujo: Pantalla "Historial de Transacciones"

1. **Acceso a la Pantalla:** El usuario pulsa el botón/enlace "Ver historial completo" (o similar) desde la Pantalla Principal / Dashboard.
2. **Información y Controles Visibles al Cargar la Pantalla:**
* A. Barra Superior:
    * A la izquierda: Un botón de "Atrás" (icono de flecha <-) para volver a la Pantalla Principal / Dashboard.
    * Centro: El título de la pantalla (ej. "Historial de Movimientos" o "Mis Transacciones").
* B. Controles de Filtro:
    * Ubicados preferentemente debajo de la barra superior, de forma accesible.
    * Filtro por Tipo: Un control de tipo seleccionable para seleccionar entre "Todos", "Ingresos" o "Gastos".
    * Filtro por Categoría: Un control de tipo desplegable para seleccionar una categoría específica (o "Todas las categorías").
* C. Lista Completa de Transacciones:
    * Ocupa la mayor parte de la pantalla y es "scrollable" verticalmente.
    * Las transacciones se ordenan cronológicamente, con la más reciente apareciendo primero.
    * Cada Fila/Ítem de Transacción muestra de forma concisa:
        - Un indicador visual del color de la categoría asociada.
        - El "Concepto" de la transacción (una breve descripción o nombre que el usuario asignó).
        - La Fecha de la transacción.
        - El Monto de la transacción (distinguiendo claramente ingresos de gastos, ej. signo +/-).
    * (La descripción y el nombre explícito de la categoría no se muestran en esta vista de lista, se verán al acceder al detalle/edición).
3. **Interacciones del Usuario en esta Pantalla:**
* Acceder a Detalles y Editar Transacción:
    * El usuario pulsa sobre cualquier parte de una fila de transacción.
    * El sistema navega a la pantalla de "Editar Transacción". Esta pantalla es la misma que se utiliza para "Nueva Transacción", pero se precarga con todos los detalles de la transacción seleccionada (incluyendo nombre de categoría, concepto, monto y fecha) y los campos son editables. El botón de confirmación indicará una acción de guardado de cambios.
* Aplicar Filtros:
    * Al seleccionar una opción en el seleccionable de "Filtro por Tipo" o desplegable "Filtro por Categoría", la lista de transacciones se actualiza instantáneamente para mostrar solo aquellas que cumplen con los criterios de filtro seleccionados.
* Hacer Scroll:
    * El usuario se desplaza verticalmente para navegar a través de toda su lista de transacciones.
4. **Casos Especiales y Estados de la Pantalla:**
* Estado Vacío (Sin Transacciones que Coincidan):
    * Si no hay transacciones registradas que coincidan con los filtros aplicados (o si el historial general está vacío).
    * Se mostrará un mensaje de texto amigable y centrado en el área de la lista (ej. "No hay transacciones para mostrar." o "Ningún movimiento coincide con tu selección.").