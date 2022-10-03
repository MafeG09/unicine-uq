insert into administrador values (1, "admin1@email.com", "contra1");
insert into administrador values (2, "admin2@email.com", "contra2");
insert into administrador values (3, "admin3@email.com", "contra3");

insert into administrador_teatro values (1, "adminTeatro1@email.com", "365426");
insert into administrador_teatro values (2, "adminTeatro2@email.com", "89795");
insert into administrador_teatro values (3, "adminTeatro3@email.com", "etgre87");

insert into ciudad values (1, "Armenia");
insert into ciudad values (2, "Pereira");
insert into ciudad values (3, "Manizales");
insert into ciudad values (4, "Cali");

insert into cliente values (1, "pepe@email.com", "contraPepe",  1, "pepe", "ruta foto");
insert into cliente values (2, "juan@email.com", "contrajuan",  1, "juan", "ruta foto");
insert into cliente values (3, "luis@email.com", "contraluis",  0, "luis", "ruta foto");
insert into cliente values (4, "maria@email.com", "contramaria", 1, "maria", "ruta foto");
insert into cliente values (5, "luisa@email.com", "contraluisa", 1, "luisa", "ruta foto");

insert into cliente_telefonos values (1, "36985");
insert into cliente_telefonos values (2, "89674");
insert into cliente_telefonos values (3, "32145");
insert into cliente_telefonos values (4, "32147");
insert into cliente_telefonos values (5, "9875");

insert into distribucion_sillas values (1,5," XXX ",10,50);
insert into distribucion_sillas values (2,5,"",10,50);
insert into distribucion_sillas values (3,5,"",10,50);

insert into teatro values (1, "Carrera 33 #2-3", "78956", 1,1);
insert into teatro values (2, "Unicentro ", "32596", 1,1);
insert into teatro values (3, "Parque Arboleda", "87452", 3,2);
insert into teatro values (4, "Manizales", "78965", 2,3);

insert into tipo_sala values (1,"3D");
insert into tipo_sala values (2,"2D");

insert into sala values (1, "sala1", 1, 1,1);
insert into sala values (2, "sala2", 2, 2,1);
insert into sala values (3, "sala3", 3, 3,2);

insert into horario values (1, 1, "2022:12:03", "2022-12-20","3:20");
insert into horario values (2, 20, "2022:12:03","2022-12-20","5:10");
insert into horario values (3, 13, "2022:12:03","2022-12-20","9:25");

insert into pelicula values (1, 0, "miedito movie", "pelicula de miedito", "ruta foto", "ruta trailer");
insert into pelicula values (2, 0, "pinocho", "pelicula mas miedosa que miedito movie", "ruta foto", "ruta trailer");
insert into pelicula values (3, 0, "la dama y el vagabundo", "amorch", "ruta foto", "ruta trailer");

insert into pelicula_genero values (1, "terror");
insert into pelicula_genero values (1, "romance");
insert into pelicula_genero values (2, "fantansia");
insert into pelicula_genero values (3, "romance");

insert into pelicula_reparto values (1, "jennifer laurence");
insert into pelicula_reparto values (2, "leonardo ");
insert into pelicula_reparto values (3, "bambi");

insert into funcion values (1,1200.0,1,1,1);
insert into funcion values (2,1400.0,2,3,2);
insert into funcion values (3,1600.0,3,2,3);

insert into cupon values (1, "primera compra","cupon por primera compra",5,"2022-12-31");
insert into cupon values (2, "registro", "cupon por registro",15, "2022-12-31" );
insert into cupon values (3, "cumpleaños","cupon por cumpleaños",50,  "2022-12-31");

insert into cupon_cliente values (1,0,1,1);
insert into cupon_cliente values (2,0,2,2);
insert into cupon_cliente values (3,1,3,3);

insert into compra values (1,"2020-12-03", "NEQUI", 30000.0, 1,1,1);
insert into compra values (2,"2021-09-23", "VISA", 50000.0, 2,2,2);
insert into compra values (3,"2022-01-30", "MASTERCARD", 23000.0, 3,3,3);

insert into confiteria values (1, "crispeta",10000.0, "ruta foto" );
insert into confiteria values (2, "combo",20000.0, "ruta foto" );
insert into confiteria values (3, "nachos",7000.0, "ruta foto" );

insert into compra_confiteria values (1,21000,1,1,1);
insert into compra_confiteria values (2,32000,1,2,2);
insert into compra_confiteria values (3,5000,5,3,3);
