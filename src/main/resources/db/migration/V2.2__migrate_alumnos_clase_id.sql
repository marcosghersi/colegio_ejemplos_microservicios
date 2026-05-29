-- Asignar a cada alumno el ID de clase correspondiente
-- según el nombre almacenado en ALUMNOS.CLASE
UPDATE ESCUELADB.ALUMNOS A
SET CLASE_ID = (
    SELECT C.ID
    FROM ESCUELADB.CLASE C
    WHERE C.NOMBRE = TRIM(UPPER(A.CLASE))
    LIMIT 1
)
WHERE A.CLASE IS NOT NULL AND TRIM(A.CLASE) <> '';

-- Crear la clave foránea cuando la columna ya esté poblada
ALTER TABLE ESCUELADB.ALUMNOS
    ADD CONSTRAINT FK_ALUMNOS_CLASE
        FOREIGN KEY (CLASE_ID)
            REFERENCES ESCUELADB.CLASE(ID);

-- Eliminar la columna antigua una vez migrados los datos
ALTER TABLE ESCUELADB.ALUMNOS
    DROP COLUMN CLASE;
