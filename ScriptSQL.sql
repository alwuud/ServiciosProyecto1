create table ROL(
	id_rol SERIAL PRIMARY KEY,
	nombre VARCHAR(20) NOT NULL,
	description VARCHAR(120)
);
	

create table USUARIO(
	id_usuario SERIAL PRIMARY KEY,
	nombre VARCHAR(25) NOT NULL,
	loginUser VARCHAR(15) NOT NULL UNIQUE,
	pass  VARCHAR(150) NOT NULL,
	email VARCHAR(150) NOT NULL UNIQUE,
	activo boolean NOT NULL DEFAULT  TRUE,
	experiencia int NOT NULL DEFAULT 0 CHECK(experiencia>-1)
	id_rol int NOT NULL REFERENCES ROL(id_rol)


);

create table AVATAR(
	id_avatar SERIAL PRIMARY KEY,
	nombre VARCHAR(25) NOT NULL,
	imageURL VARCHAR(256),

	id_usuario int NOT NULL REFERENCES USUARIO(id_usuario) on delete cascade

	
	

);

create table ITEM(
	id_item SERIAL PRIMARY KEY,
	nombre VARCHAR(120) NOT NULL,
	descripcion VARCHAR(256) NOT NULL,
	efectividad int NOT NULL CHECK( efectividad > -1 AND efectividad <101),
	rareza int NOT NULL CHECK( rareza> -1 AND rareza <100),
	gana int NOT NULL  CHECK( gana>-1),
	pierde int NOT NULL,
	unUso boolean NOT NULL
	
	
); 

create table ITEM_USUARIO(
	id SERIAL PRIMARY KEY,

	id_usuario int NOT NULL REFERENCES USUARIO(id_usuario) on delete cascade,
	id_avatar int REFERENCES AVATAR(id_avatar),
	id_item int NOT NULL REFERENCES ITEM(id_item)
);

create table CARRERA(
	codigo INT PRIMARY KEY,
	nombre VARCHAR(120) NOT NULL
	
);

create table CURSO(
	codigo INT PRIMARY KEY,
	nombre VARCHAR(120) NOT NULL,
	activo boolean NOT NULL DEFAULT TRUE,	
	descripcion VARCHAR(120),

	codigo_carrera int NOT NULL REFERENCES CARRERA(codigo) on delete cascade
	
);

create table DIFICULTAD(
	id_dificultad SERIAL PRIMARY KEY,
	nombre VARCHAR(25) NOT NULL,
	experiencia int NOT NULL CHECK(experiencia>0)	
	
);

create table PREGUNTA(
	id_pregunta SERIAL PRIMARY KEY,
	texto VARCHAR(256) NOT NULL,
	tiempo INTERVAL NOT NULL,
	activa boolean NOT NULL DEFAULT FALSE,
	revisada boolean NOT NULL DEFAULT FALSE,
	denunciada boolean NOT NULL DEFAULT FALSE,
	jugada int NOT NULL CHECK(jugada>-1)  DEFAULT 0,
	correcta int NOT NULL CHECK(correcta>-1)  DEFAULT 0,

	id_curso int NOT NULL REFERENCES CURSO(codigo) on delete cascade,
	id_dificultad int NOT NULL REFERENCES DIFICULTAD(id_dificultad)
	
	
);

create table RESPUESTA(
	id_res SERIAL PRIMARY KEY,
	res VARCHAR(120) NOT NULL,
	correcta boolean  NOT NULL,


	id_pregunta int NOT NULL REFERENCES PREGUNTA(id_pregunta)
	

);



