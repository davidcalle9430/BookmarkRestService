ALTER TABLE cardexi 
CHANGE COLUMN consec consec 
int(10) NOT NULL AUTO_INCREMENT;

ALTER TABLE cardex
CHANGE COLUMN consec consec 
int(10) NOT NULL AUTO_INCREMENT;

ALTER TABLE clientes 
MODIFY 
CODIGO INTEGER;

SELECT g.nombre, a.referencia, a.precio, a.codigo
FROM articulo a JOIN genero g on LEFT(LPAD(a.codigo,6,'0'),3) = LPAD(g.codigo,3,'0');

select a.codigo, g.nombre, a.referencia, a.precio*cardex.cantidad as valor
from articulo a, cardex, genero g
where a.codigo = cardex.codigo
	and LEFT(LPAD(a.codigo,6,'0'),3) = LPAD(g.codigo,3,'0')
	and ndoc = ?0
	and str_to_date(?1, "%Y-%m-%d")
order by cardex.consec;


select e.codigo, c.razsoc, e.articulo, e.referencia, e.precio
from ((articulo a JOIN especia e ON a.codigo = e.articulo) JOIN clientes c ON  e.codigo = c.codigo)
order by e.codigo, e.articulo


select a.codigo, g.nombre, a.referencia, a.precio*cardex.cantidad as valor
from articulo a, cardex, genero g
where a.codigo = cardex.codigo
	and LEFT(LPAD(a.codigo,6,'0'),3) = LPAD(g.codigo,3,'0')
	and ndoc = 438
	and str_to_date('2002-01-03', '%Y-%m-%d')
order by cardex.consec;

ALTER TABLE importaciones 
CHANGE COLUMN consec consec 
int(10) NOT NULL AUTO_INCREMENT;