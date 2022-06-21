
-- brand
INSERT INTO public.brand(
	brand_id, brand_name)
	VALUES (1, 'JONTEX');

-- CATEGORIAS
INSERT INTO public.category(
	category_id, description, status)
	VALUES (1, 'MAQUINAS_FAMILIARES', '1');

-- PRODUCTOS
INSERT INTO public.products(
	product_id, name, category_id, barcode, sale_price, amount_stock, status, brand_id, model, locations_id)
	VALUES (1, 'MAQUINA COLLARIN', 1, 'ADF3434', 700000, 100, '1', 1, 22, 1);
INSERT INTO public.products(
	product_id, name, category_id, barcode, sale_price, amount_stock, status, brand_id, model, locations_id)
	VALUES (2, 'MAQUINA 20 PUNTADAS', 1, '445DF3434', 300000, 400, '1', 1, 21, 1);

-- CLIENTES
INSERT INTO users VALUES ('4546221', 'Johannes', 'Kepler', 3104583224, 'Cl 3 # 33 - 33', 'kepler@me.com','www.google.com','Globan123');
INSERT INTO users VALUES ('2552243', 'Galileo', 'Galilei', 3462257293, 'Cl 1 # 11 - 11', 'gali@leo.com','www.google.com','Globan123');
INSERT INTO users VALUES ('983824', 'Nicolas', 'Copernico', 3019392466, 'Cl 2 # 22 - 22', 'nico@cope.com','www.google.com','Globan123');

-- COMPRA
INSERT INTO BUY VALUES (1, '4546221', TO_TIMESTAMP('02/05/2022 17:30:00','DD/MM/YYYY HH24:MI:SS'), 'E', 'NOTHING', 'P','983824');

INSERT INTO buy_products VALUES (1, 1, 10, 3000, '1');

-- SE REINICIAN LAS SECUENCIAS SEGÚN LOS DATOS INICIALES
SELECT setval('public.productos_id_producto_seq', 50, true);
SELECT setval('public.categorias_id_categoria_seq', 8, true);
SELECT setval('public.compras_id_compra_seq', 1, true);