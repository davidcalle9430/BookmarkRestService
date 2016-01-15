ALTER TABLE cardexi 
CHANGE COLUMN consec consec 
int(10) NOT NULL AUTO_INCREMENT;

ALTER TABLE clientes 
MODIFY 
CODIGO INTEGER;

SELECT g.nombre, a.referencia, a.precio, a.codigo
FROM articulo a JOIN genero g on LEFT(LPAD(a.codigo,6,'0'),3) = LPAD(g.codigo,3,'0');
