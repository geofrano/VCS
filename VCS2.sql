--PostgreSQL Maestro 15.4.0.3
------------------------------------------
--Host     : localhost
--Database : VCS2


SET SESSION AUTHORIZATION 'postgres';
SET search_path = public, pg_catalog;
ALTER TABLE ONLY public."MPP_CARTA_COMPROMISO" DROP CONSTRAINT "FK_MPP_CARTA_COMPROMISO6";
ALTER TABLE ONLY public."MPP_FICHA_ESTUDIANTE" DROP CONSTRAINT "FK_MPP_FICHA_ESTUDIANTE2";
ALTER TABLE ONLY public."MPR_RESPONSABLE_PROYECTO" DROP CONSTRAINT "FK_MPR_RESPONSABLE_PROYECTO2";
ALTER TABLE ONLY public."MPR_RESPONSABLE_PROYECTO" DROP CONSTRAINT "FK_MPR_RESPONSABLE_PROYECTO";
ALTER TABLE ONLY public."MPR_RESPONSABLE_PROYECTO" DROP CONSTRAINT "PK_MPR_RESPONSABLE_PROYECTO";
ALTER TABLE ONLY public."MPR_PROYECTO" DROP CONSTRAINT "FK_MPR_PROYECTO";
ALTER TABLE ONLY public."MPR_PROYECTO" DROP CONSTRAINT "PK_MPR_PROYECTO";
ALTER TABLE ONLY public."MPP_FICHA_ESTUDIANTE" DROP CONSTRAINT "FK_MPP_FICHA_ESTUDIANTE";
ALTER TABLE ONLY public."MPP_CRONOGRAMA_ACT" DROP CONSTRAINT "FK_MPP_CRONOGRAMA_ACT2";
ALTER TABLE ONLY public."MPP_ASIGNAR_ELEMENTO" DROP CONSTRAINT "FK_MPP_ASIGNAR_ELEMENTO";
ALTER TABLE ONLY public."MPP_ASIGNAR_ELEMENTO" DROP CONSTRAINT "PK_MPP_ASIGNAR_ELEMENTO";
ALTER TABLE ONLY public."MPP_CARTA_COMPROMISO" DROP CONSTRAINT "FK_MPP_CARTA_COMPROMISO4";
ALTER TABLE ONLY public."MPP_CARTA_COMPROMISO" DROP CONSTRAINT "FK_MPP_CARTA_COMPROMISO5";
ALTER TABLE ONLY public."MPP_CARTA_COMPROMISO" DROP CONSTRAINT "FK_MPP_CARTA_COMPROMISO3";
ALTER TABLE ONLY public."MPP_CARTA_COMPROMISO" DROP CONSTRAINT "FK_MPP_CARTA_COMPROMISO2";
ALTER TABLE ONLY public."MPP_CARTA_COMPROMISO" DROP CONSTRAINT "FK_MPP_CARTA_COMPROMISO";
ALTER TABLE ONLY public."MPP_CARTA_COMPROMISO" DROP CONSTRAINT "PK_MPP_CARTA_COMPROMISO";
ALTER TABLE ONLY public."MPP_AGREGAR_REPRESENTANTE" DROP CONSTRAINT "FK_UNIDAD_EXTERNA_REP1";
ALTER TABLE ONLY public."MAU_USUARIO" DROP CONSTRAINT "FK_USUARIO_ROL";
ALTER TABLE ONLY public."MAU_MENU_ROL" DROP CONSTRAINT "FK_MENU_ROL_2";
ALTER TABLE ONLY public."MAU_MENU_ROL" DROP CONSTRAINT "FK_MENU_ROL_1";
ALTER TABLE ONLY public."MPP_UNIDAD_EXTERNA" DROP CONSTRAINT "PK_MPP_UNIDAD_EXTERNA";
ALTER TABLE ONLY public."MPP_FICHA_ESTUDIANTE" DROP CONSTRAINT "PK_MPP_FICHA_ESTUDIANTE";
ALTER TABLE ONLY public."MPP_ESTUDIANTES" DROP CONSTRAINT "PK_MPP_ESTUDIANTES";
ALTER TABLE ONLY public."MPP_CRONOGRAMA_ACT" DROP CONSTRAINT "PK_MPP_CRONOGRAMA_ACT";
ALTER TABLE ONLY public."MPP_AGREGAR_REPRESENTANTE" DROP CONSTRAINT "PK_MPP_AGREGAR_REPRESENTANTE";
ALTER TABLE ONLY public."MAU_USUARIO" DROP CONSTRAINT "PK_MAU_USUARIO";
ALTER TABLE ONLY public."MAU_ROL" DROP CONSTRAINT "PK_MAU_ROL";
ALTER TABLE ONLY public."MAU_MENU_ROL" DROP CONSTRAINT "PK_MAU_MENU_ROL";
ALTER TABLE ONLY public."MAU_MENU" DROP CONSTRAINT "PK_MAU_MENU";
ALTER TABLE ONLY public."MPP_PARAMETROS" DROP CONSTRAINT "PK_MPP_PARAMETROS";
DROP FUNCTION public.f_devuelve_actividades (cc_cod text);
DROP VIEW public.view_datos_cc;
DROP TABLE public."MPR_RESPONSABLE_PROYECTO";
DROP SEQUENCE public."MPR_RESPONSABLE_PROYECTO_rp_id_seq";
DROP TABLE public."MPR_PROYECTO";
DROP SEQUENCE public."MPR_PROYECTO_pr_id_seq";
DROP TABLE public."MPP_ASIGNAR_ELEMENTO";
DROP SEQUENCE public."MPP_ASIGNAR_ELEMENTO_ae_id_seq";
DROP TABLE public."MPP_CARTA_COMPROMISO";
DROP TABLE public."MPP_ESTUDIANTES";
DROP TABLE public."MPP_PARAMETROS";
DROP TABLE public."MPP_CRONOGRAMA_ACT";
DROP SEQUENCE public."MPP_CRONOGRAMA_ACT_ca_id_seq";
DROP TABLE public."MPP_FICHA_ESTUDIANTE";
DROP SEQUENCE public."MPP_FICHA_ESTUDIANTE_fe_id_seq";
DROP TABLE public."MPP_UNIDAD_EXTERNA";
DROP SEQUENCE public."MPP_UNIDAD_EXTERNA_ue_id_seq";
DROP TABLE public."MPP_AGREGAR_REPRESENTANTE";
DROP SEQUENCE public."MPP_AGREGAR_REPRESENTANTE_ar_id_seq";
DROP TABLE public."MAU_USUARIO";
DROP SEQUENCE public."MAU_USUARIO_us_id_seq";
DROP TABLE public."MAU_MENU_ROL";
DROP SEQUENCE public."MAU_MENU_ROL_mr_id_seq";
DROP TABLE public."MAU_ROL";
DROP SEQUENCE public."MAU_ROL_ro_id_seq";
DROP TABLE public."MAU_MENU";
DROP SEQUENCE public."MAU_MENU_me_id_seq";
-- Definition for sequence MAU_MENU_me_id_seq (OID = 41104):
CREATE SEQUENCE "MAU_MENU_me_id_seq"
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;
-- Structure for table MAU_MENU (OID = 41106):
CREATE TABLE "MAU_MENU" (
    me_id integer DEFAULT nextval('"MAU_MENU_me_id_seq"'::regclass) NOT NULL,
    me_descripcion char(200) NOT NULL,
    me_nombre char(200) NOT NULL,
    me_menu_padre integer NOT NULL,
    me_pagina char(3000) NOT NULL,
    me_icono char(3000),
    me_es_padre char(1) NOT NULL,
    me_estado char(1) DEFAULT 'A'::bpchar NOT NULL
) WITHOUT OIDS;
-- Definition for sequence MAU_ROL_ro_id_seq (OID = 41120):
CREATE SEQUENCE "MAU_ROL_ro_id_seq"
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;
-- Structure for table MAU_ROL (OID = 41122):
CREATE TABLE "MAU_ROL" (
    ro_id integer DEFAULT nextval('"MAU_ROL_ro_id_seq"'::regclass) NOT NULL,
    ro_descripcion char(2000) NOT NULL,
    ro_estado char(1) DEFAULT 'A'::bpchar NOT NULL
) WITHOUT OIDS;
-- Definition for sequence MAU_MENU_ROL_mr_id_seq (OID = 41191):
CREATE SEQUENCE "MAU_MENU_ROL_mr_id_seq"
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;
-- Structure for table MAU_MENU_ROL (OID = 41193):
CREATE TABLE "MAU_MENU_ROL" (
    mr_id integer DEFAULT nextval('"MAU_MENU_ROL_mr_id_seq"'::regclass) NOT NULL,
    me_id integer NOT NULL,
    ro_id integer NOT NULL
) WITHOUT OIDS;
-- Definition for sequence MAU_USUARIO_us_id_seq (OID = 41197):
CREATE SEQUENCE "MAU_USUARIO_us_id_seq"
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;
-- Structure for table MAU_USUARIO (OID = 41199):
CREATE TABLE "MAU_USUARIO" (
    us_id integer DEFAULT nextval('"MAU_USUARIO_us_id_seq"'::regclass) NOT NULL,
    us_cedula char(30) NOT NULL,
    us_nombre char(500) NOT NULL,
    us_apellido char(500) NOT NULL,
    us_direccion char(200),
    us_cargo char(100) NOT NULL,
    us_fecha_nacimiento date,
    us_celular char(15),
    us_usuario char(20) NOT NULL,
    us_contrasena char(1000) NOT NULL,
    ro_id integer NOT NULL,
    us_estado char(1) DEFAULT 'A'::bpchar NOT NULL
) WITHOUT OIDS;
-- Definition for sequence MPP_AGREGAR_REPRESENTANTE_ar_id_seq (OID = 41207):
CREATE SEQUENCE "MPP_AGREGAR_REPRESENTANTE_ar_id_seq"
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;
-- Structure for table MPP_AGREGAR_REPRESENTANTE (OID = 41209):
CREATE TABLE "MPP_AGREGAR_REPRESENTANTE" (
    ar_id integer DEFAULT nextval('"MPP_AGREGAR_REPRESENTANTE_ar_id_seq"'::regclass) NOT NULL,
    ar_nombre char(500) NOT NULL,
    ar_apellido char(500) NOT NULL,
    ar_cargo char(100) NOT NULL,
    ar_telefono char(20) NOT NULL,
    ue_id integer NOT NULL
) WITHOUT OIDS;
-- Definition for sequence MPP_UNIDAD_EXTERNA_ue_id_seq (OID = 41218):
CREATE SEQUENCE "MPP_UNIDAD_EXTERNA_ue_id_seq"
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;
-- Structure for table MPP_UNIDAD_EXTERNA (OID = 41220):
CREATE TABLE "MPP_UNIDAD_EXTERNA" (
    ue_id integer DEFAULT nextval('"MPP_UNIDAD_EXTERNA_ue_id_seq"'::regclass) NOT NULL,
    ue_nombre char(150) NOT NULL,
    ue_direccion char(400) NOT NULL,
    ue_telefono char(20) NOT NULL,
    ue_actividad_principal text NOT NULL,
    ue_tipo char(2) NOT NULL,
    ue_estado char(1) DEFAULT 'A'::bpchar NOT NULL
) WITHOUT OIDS;
-- Definition for sequence MPP_FICHA_ESTUDIANTE_fe_id_seq (OID = 41240):
CREATE SEQUENCE "MPP_FICHA_ESTUDIANTE_fe_id_seq"
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;
-- Structure for table MPP_FICHA_ESTUDIANTE (OID = 41242):
CREATE TABLE "MPP_FICHA_ESTUDIANTE" (
    fe_id integer DEFAULT nextval('"MPP_FICHA_ESTUDIANTE_fe_id_seq"'::regclass) NOT NULL,
    fe_nombre_proyecto text,
    fe_twitter char(300),
    fe_facebook char(300),
    fe_linked_in char(300),
    cc_id char(30) NOT NULL,
    fe_tipo_documento char(100) DEFAULT 'CEDULA'::bpchar NOT NULL,
    fe_direccion char(600) NOT NULL,
    pr_id integer NOT NULL
) WITHOUT OIDS;
-- Definition for sequence MPP_CRONOGRAMA_ACT_ca_id_seq (OID = 41249):
CREATE SEQUENCE "MPP_CRONOGRAMA_ACT_ca_id_seq"
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;
-- Structure for table MPP_CRONOGRAMA_ACT (OID = 41251):
CREATE TABLE "MPP_CRONOGRAMA_ACT" (
    ca_id integer DEFAULT nextval('"MPP_CRONOGRAMA_ACT_ca_id_seq"'::regclass) NOT NULL,
    ca_semana integer NOT NULL,
    ca_num_hora integer NOT NULL,
    ae_id integer NOT NULL
) WITHOUT OIDS;
-- Structure for table MPP_PARAMETROS (OID = 41255):
CREATE TABLE "MPP_PARAMETROS" (
    pa_id char(100) NOT NULL,
    pa_descripcion char(200) NOT NULL,
    pa_valor char(4000) NOT NULL,
    pa_tipo char(100)
) WITHOUT OIDS;
-- Structure for table MPP_ESTUDIANTES (OID = 41263):
CREATE TABLE "MPP_ESTUDIANTES" (
    es_id integer NOT NULL,
    es_nombre char(500) NOT NULL,
    es_apellido char(500) NOT NULL,
    es_correo char(100) NOT NULL,
    es_celular char(20) NOT NULL,
    es_cedula char(20) NOT NULL,
    es_id_carrera char(100) NOT NULL,
    es_id_ciclo char(100) NOT NULL
) WITHOUT OIDS;
-- Structure for table MPP_CARTA_COMPROMISO (OID = 41346):
CREATE TABLE "MPP_CARTA_COMPROMISO" (
    cc_id char(30) NOT NULL,
    es_id integer NOT NULL,
    cc_tipo_actividad char(100) NOT NULL,
    cc_total_horas integer NOT NULL,
    cc_objetivo_actividad text NOT NULL,
    cc_fecha_inicio date NOT NULL,
    cc_fecha_fin date NOT NULL,
    cc_horario_previsto char(300) NOT NULL,
    cc_id_programa char(100) NOT NULL,
    cc_area_actividad char(300) NOT NULL,
    cc_responsable_area char(600) NOT NULL,
    cc_id_tutor integer NOT NULL,
    cc_id_director_tecnico integer NOT NULL,
    cc_fecha_sistema date DEFAULT ('now'::text)::date NOT NULL,
    cc_lugar_suscripcion char(100) NOT NULL,
    cc_fecha_suscripcion date NOT NULL,
    cc_estado char(1) DEFAULT 'A'::bpchar NOT NULL,
    ue_id integer NOT NULL
) WITHOUT OIDS;
-- Definition for sequence MPP_ASIGNAR_ELEMENTO_ae_id_seq (OID = 41386):
CREATE SEQUENCE "MPP_ASIGNAR_ELEMENTO_ae_id_seq"
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;
-- Structure for table MPP_ASIGNAR_ELEMENTO (OID = 41388):
CREATE TABLE "MPP_ASIGNAR_ELEMENTO" (
    ae_id integer DEFAULT nextval('"MPP_ASIGNAR_ELEMENTO_ae_id_seq"'::regclass) NOT NULL,
    ae_descripcion text NOT NULL,
    ae_tipo char(2) NOT NULL,
    cc_id char(30) NOT NULL,
    ae_orden integer NOT NULL
) WITHOUT OIDS;
-- Definition for sequence MPR_PROYECTO_pr_id_seq (OID = 41417):
CREATE SEQUENCE "MPR_PROYECTO_pr_id_seq"
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;
-- Structure for table MPR_PROYECTO (OID = 41419):
CREATE TABLE "MPR_PROYECTO" (
    pr_id integer DEFAULT nextval('"MPR_PROYECTO_pr_id_seq"'::regclass) NOT NULL,
    pr_nombre text NOT NULL,
    pr_fecha_inicio date NOT NULL,
    pr_fecha_fin date NOT NULL,
    pr_id_programa char(100) NOT NULL
) WITHOUT OIDS;
-- Definition for sequence MPR_RESPONSABLE_PROYECTO_rp_id_seq (OID = 41433):
CREATE SEQUENCE "MPR_RESPONSABLE_PROYECTO_rp_id_seq"
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;
-- Structure for table MPR_RESPONSABLE_PROYECTO (OID = 41435):
CREATE TABLE "MPR_RESPONSABLE_PROYECTO" (
    rp_id integer DEFAULT nextval('"MPR_RESPONSABLE_PROYECTO_rp_id_seq"'::regclass) NOT NULL,
    rp_id_responsable integer NOT NULL,
    rp_id_proyecto integer NOT NULL
) WITHOUT OIDS;
-- Definition for view view_datos_cc (OID = 41477):
CREATE VIEW view_datos_cc AS
    SELECT btrim((cc.cc_id)::text) AS id_cc,
        btrim((tipo_act.pa_valor)::text) AS tipo_actividad,
        to_char((cc.cc_fecha_inicio)::timestamp with time zone, 'dd'::text)
        AS dia_ini,
    to_char((cc.cc_fecha_inicio)::timestamp with time
        zone, 'mm'::text) AS mes_ini,
        to_char((cc.cc_fecha_inicio)::timestamp with time zone,
        'yyyy'::text) AS anio_ini,
    to_char((cc.cc_fecha_fin)::timestamp
        with time zone, 'dd'::text) AS dia_fin,
        to_char((cc.cc_fecha_fin)::timestamp with time zone, 'mm'::text) AS
        mes_fin,
    to_char((cc.cc_fecha_fin)::timestamp with time zone,
        'yyyy'::text) AS anio_fin,
    btrim((es.es_cedula)::text) AS
        ced_est,
    (((es.es_apellido)::text || ' '::text) ||
        (es.es_nombre)::text) AS nombre_estudiante,
        btrim((es.es_celular)::text) AS cel_est,
        btrim((es.es_correo)::text) AS correo_est,
        btrim((carrera.pa_valor)::text) AS carrera_est,
        btrim((ciclo.pa_valor)::text) AS ciclo_est,
        btrim((emp.ue_nombre)::text) AS institucion,
        ((btrim((rep.ar_apellido)::text) || ' '::text) ||
        btrim((rep.ar_nombre)::text)) AS rep_leg,
        btrim((cc.cc_area_actividad)::text) AS cc_area_actividad,
        btrim((cc.cc_responsable_area)::text) AS cc_responsable_area,
        btrim((cc.cc_horario_previsto)::text) AS cc_horario_previsto,
        btrim((rep.ar_cargo)::text) AS cargo_rep_leg,
        btrim((rep.ar_telefono)::text) AS ar_telefono,
        btrim((emp.ue_direccion)::text) AS ue_direccion,
        btrim((programa.pa_valor)::text) AS programa,
    proy.pr_nombre AS
        proyecto,
    ((btrim((tutor.us_nombre)::text) || ' '::text) ||
        btrim((tutor.us_apellido)::text)) AS nombre_tutor,
    (
        SELECT f_devuelve_actividades((cc.cc_id)::text) AS f_devuelve_actividades
        ) AS actividades,
    proy.pr_id AS cod_proy
    FROM "MPP_CARTA_COMPROMISO" cc,
    "MAU_USUARIO" tutor,
        "MPP_ESTUDIANTES" es,
    "MPP_PARAMETROS" programa,
        "MPP_PARAMETROS" tipo_act,
    "MPP_PARAMETROS" ciclo,
        "MPP_PARAMETROS" carrera,
    "MPP_UNIDAD_EXTERNA" emp,
        "MPP_AGREGAR_REPRESENTANTE" rep,
    (
        SELECT cart.cc_id,
            pr.pr_nombre,
            pr.pr_id
        FROM ("MPP_CARTA_COMPROMISO" cart
             LEFT JOIN
            "MPR_PROYECTO" pr ON ((pr.pr_id_programa = cart.cc_id_programa)))
        ) proy
    WHERE (((((((((((((((cc.cc_id_tutor = tutor.us_id) AND (cc.es_id =
        es.es_id)) AND (cc.cc_id_programa = programa.pa_id)) AND
        (cc.cc_tipo_actividad = tipo_act.pa_id)) AND (es.es_id_ciclo =
        ciclo.pa_id)) AND (es.es_id_carrera = carrera.pa_id)) AND
        (emp.ue_id = cc.ue_id)) AND (rep.ue_id = emp.ue_id)) AND
        (proy.cc_id = cc.cc_id)) AND (carrera.pa_tipo = 'CA'::bpchar)) AND
        (programa.pa_tipo = 'PR'::bpchar)) AND (tipo_act.pa_tipo =
        'AC'::bpchar)) AND (ciclo.pa_tipo = 'CI'::bpchar)) AND
        (cc.cc_estado = 'A'::bpchar)) AND (tutor.us_estado = 'A'::bpchar));

-- Definition for function f_devuelve_actividades (OID = 41483):
SET check_function_bodies = false;
CREATE FUNCTION f_devuelve_actividades (cc_cod text) RETURNS text
    AS '', '
DECLARE
curs1 CURSOR(orden integer) FOR select act.ae_descripcion actividades
 from  "MPP_CARTA_COMPROMISO" cc,"MPP_ASIGNAR_ELEMENTO" act
 where cc.cc_id = act.cc_id
   and act.ae_tipo = ''AC''
   and trim(cc.cc_id) = cc_cod
   and act.ae_orden = orden;

   actividades text;
   actividades1 text;
   actividades2 text;
   actividades3 text;
   actividades4 text;
   actividades5 text;
   actividades6 text;
   
BEGIN

OPEN curs1(1);
FETCH curs1 INTO actividades1;
CLOSE curs1;
OPEN curs1(2);
FETCH curs1 INTO actividades2;
CLOSE curs1;
OPEN curs1(3);
FETCH curs1 INTO actividades3;
CLOSE curs1;
OPEN curs1(4);
FETCH curs1 INTO actividades4;
CLOSE curs1;
OPEN curs1(5);
FETCH curs1 INTO actividades5;
CLOSE curs1;
OPEN curs1(6);
FETCH curs1 INTO actividades6;
CLOSE curs1;

actividades:= actividades1 || '' - '' || actividades2 || '' - '' || actividades3 || '' - '' || actividades4 || '' - '' || actividades5 || '' - '' || actividades6;


RETURN actividades;
	
END;
'
    LANGUAGE plpgsql;
--
-- Data for blobs (OID = 41106) (LIMIT 0,15)
--
INSERT INTO "MAU_MENU" (me_id, me_descripcion, me_nombre, me_menu_padre, me_pagina, me_icono, me_es_padre, me_estado) VALUES (8, 'Ficha del Estudiante', 'Ficha del Estudiante', 7, '/VCS/Administracion_de_Carrera/Ficha_del_Estudiante/ficha_estudiante.jsp', 'images/ficha_estudiante.png', 'N', 'A');
INSERT INTO "MAU_MENU" (me_id, me_descripcion, me_nombre, me_menu_padre, me_pagina, me_icono, me_es_padre, me_estado) VALUES (9, 'Peticion de Aprobacion', 'Peticion de Aprobacion', 7, 'peticion_aprobacion.jsp', 'images/peticion_aprobacion.png', 'N', 'A');
INSERT INTO "MAU_MENU" (me_id, me_descripcion, me_nombre, me_menu_padre, me_pagina, me_icono, me_es_padre, me_estado) VALUES (10, 'Oficio de Notificacion al Tutor', 'Oficio de Notificacion al Tutor', 7, 'oficion_notificacion_tutor.jsp', 'images/notificacion_tutor.png', 'N', 'A');
INSERT INTO "MAU_MENU" (me_id, me_descripcion, me_nombre, me_menu_padre, me_pagina, me_icono, me_es_padre, me_estado) VALUES (1, 'Menu de paginas', 'Menu Administrativo', 0, 'Home.jsp', 'N/A', 'N', 'A');
INSERT INTO "MAU_MENU" (me_id, me_descripcion, me_nombre, me_menu_padre, me_pagina, me_icono, me_es_padre, me_estado) VALUES (4, 'Informe de Peticion Verbal', 'Informe de Peticion Verbal', 2, 'informe_peticion_verbal.jsp', 'images/informe_peticion_verbal.jpg', 'N', 'A');
INSERT INTO "MAU_MENU" (me_id, me_descripcion, me_nombre, me_menu_padre, me_pagina, me_icono, me_es_padre, me_estado) VALUES (5, 'Carta de Aceptacion', 'Carta de Aceptacion', 2, 'carta_aceptacion.jsp', 'images/carta_aceptacion.png', 'N', 'A');
INSERT INTO "MAU_MENU" (me_id, me_descripcion, me_nombre, me_menu_padre, me_pagina, me_icono, me_es_padre, me_estado) VALUES (7, 'Administracion de Carrera', 'Administracion de Carrera', 1, '#', 'images/administracion_carrera.png', 'S', 'A');
INSERT INTO "MAU_MENU" (me_id, me_descripcion, me_nombre, me_menu_padre, me_pagina, me_icono, me_es_padre, me_estado) VALUES (6, 'Cronograma', 'Cronograma', 2, 'cronograma.jsp', 'images/cronograma_actividades.png', 'N', 'A');
INSERT INTO "MAU_MENU" (me_id, me_descripcion, me_nombre, me_menu_padre, me_pagina, me_icono, me_es_padre, me_estado) VALUES (2, 'Entidad Externa', 'Entidad Externa', 1, '#', 'images/entidad_externa.png', 'S', 'A');
INSERT INTO "MAU_MENU" (me_id, me_descripcion, me_nombre, me_menu_padre, me_pagina, me_icono, me_es_padre, me_estado) VALUES (11, 'Informe de Seguimiento', 'Informe de Seguimiento', 7, 'informe_seguimiento.jsp', 'images/informe_seguimiento.png', 'N', 'A');
INSERT INTO "MAU_MENU" (me_id, me_descripcion, me_nombre, me_menu_padre, me_pagina, me_icono, me_es_padre, me_estado) VALUES (12, 'Informe del Estudiante', 'Informe del Estudiante', 7, 'informe_estudiante.jsp', 'images/informe_estudiante.jpg', 'N', 'A');
INSERT INTO "MAU_MENU" (me_id, me_descripcion, me_nombre, me_menu_padre, me_pagina, me_icono, me_es_padre, me_estado) VALUES (13, 'Autoevaluacion del Estudiante', 'Autoevaluacion del Estudiante', 7, 'autoevaluacion_estudiante.jsp', 'images/Autoevaluacion_estudiante.jpg', 'N', 'A');
INSERT INTO "MAU_MENU" (me_id, me_descripcion, me_nombre, me_menu_padre, me_pagina, me_icono, me_es_padre, me_estado) VALUES (14, 'Informe de Tutor', 'Informe de Tutor', 7, 'informe_tutor.jsp', 'images/informe_tutor.png', 'N', 'A');
INSERT INTO "MAU_MENU" (me_id, me_descripcion, me_nombre, me_menu_padre, me_pagina, me_icono, me_es_padre, me_estado) VALUES (15, 'Acta de Finiquito', 'Acta de Finiquito', 7, 'acta_finiquito.jsp', 'images/acta_finiquito.png', 'N', 'A');
INSERT INTO "MAU_MENU" (me_id, me_descripcion, me_nombre, me_menu_padre, me_pagina, me_icono, me_es_padre, me_estado) VALUES (3, 'Carta de Compromiso', 'Carta de Compromiso', 2, '/VCS/Entidad_Externa/Carta_Compromiso/carta_compromiso.jsp', 'images/carta_compromiso.jpg', 'N', 'A');
COMMIT;
--
-- Data for blobs (OID = 41122) (LIMIT 0,1)
--
INSERT INTO "MAU_ROL" (ro_id, ro_descripcion, ro_estado) VALUES (1, 'Rol de Administrador', 'A');
COMMIT;
--
-- Data for blobs (OID = 41199) (LIMIT 0,3)
--
INSERT INTO "MAU_USUARIO" (us_id, us_cedula, us_nombre, us_apellido, us_direccion, us_cargo, us_fecha_nacimiento, us_celular, us_usuario, us_contrasena, ro_id, us_estado) VALUES (1, '0930012021', 'Geovanny', 'Barrera', 'Guayaquil', 'ADMINISTRADOR', '05/10/1992', '0993992846', 'GBARRERA', '202cb962ac59075b964b07152d234b70', 1, 'A');
INSERT INTO "MAU_USUARIO" (us_id, us_cedula, us_nombre, us_apellido, us_direccion, us_cargo, us_fecha_nacimiento, us_celular, us_usuario, us_contrasena, ro_id, us_estado) VALUES (2, '1234567892', 'Jorgue', 'Llaguno', 'Guayaquil', 'TUTOR', '13/01/1971', '12341231231', 'JLLAGUNO', '202cb962ac59075b964b07152d234b70', 1, 'A');
INSERT INTO "MAU_USUARIO" (us_id, us_cedula, us_nombre, us_apellido, us_direccion, us_cargo, us_fecha_nacimiento, us_celular, us_usuario, us_contrasena, ro_id, us_estado) VALUES (3, '23123123123', 'Wendy', 'Luna Ramos', 'Guayaquil', 'DIRECTOR TECNICO', NULL, NULL, 'WLUNA', '202cb962ac59075b964b07152d234b70', 1, 'A');
COMMIT;
--
-- Data for blobs (OID = 41209) (LIMIT 0,1)
--
INSERT INTO "MPP_AGREGAR_REPRESENTANTE" (ar_id, ar_nombre, ar_apellido, ar_cargo, ar_telefono, ue_id) VALUES (1, 'VICENTE', 'RIVAS', 'GERENTE GENERAL', '2693838', 1);
COMMIT;
--
-- Data for blobs (OID = 41220) (LIMIT 0,1)
--
INSERT INTO "MPP_UNIDAD_EXTERNA" (ue_id, ue_nombre, ue_direccion, ue_telefono, ue_actividad_principal, ue_tipo, ue_estado) VALUES (1, 'CORLASOSA S.A.', 'Carchi y 9 de octubre', '2693838', 'DESARROLLO SOFTWARE', 'PR', 'A');
COMMIT;
--
-- Data for blobs (OID = 41255) (LIMIT 0,35)
--
INSERT INTO "MPP_PARAMETROS" (pa_id, pa_descripcion, pa_valor, pa_tipo) VALUES ('CICLO_1', '1er. ciclo', '1er.', 'CI');
INSERT INTO "MPP_PARAMETROS" (pa_id, pa_descripcion, pa_valor, pa_tipo) VALUES ('CICLO_2', '2do. ciclo', '2do.', 'CI');
INSERT INTO "MPP_PARAMETROS" (pa_id, pa_descripcion, pa_valor, pa_tipo) VALUES ('CICLO_3', '3er. ciclo', '3er.', 'CI');
INSERT INTO "MPP_PARAMETROS" (pa_id, pa_descripcion, pa_valor, pa_tipo) VALUES ('CICLO_4', '4to. ciclo', '4to.', 'CI');
INSERT INTO "MPP_PARAMETROS" (pa_id, pa_descripcion, pa_valor, pa_tipo) VALUES ('CICLO_5', '5to. ciclo', '5to.', 'CI');
INSERT INTO "MPP_PARAMETROS" (pa_id, pa_descripcion, pa_valor, pa_tipo) VALUES ('CICLO_6', '6to. ciclo', '6to.', 'CI');
INSERT INTO "MPP_PARAMETROS" (pa_id, pa_descripcion, pa_valor, pa_tipo) VALUES ('CICLO_7', '7mo. ciclo', '7mo.', 'CI');
INSERT INTO "MPP_PARAMETROS" (pa_id, pa_descripcion, pa_valor, pa_tipo) VALUES ('CICLO_8', '8vo. ciclo', '8vo.', 'CI');
INSERT INTO "MPP_PARAMETROS" (pa_id, pa_descripcion, pa_valor, pa_tipo) VALUES ('CICLO_9', '9no. ciclo', '9no.', 'CI');
INSERT INTO "MPP_PARAMETROS" (pa_id, pa_descripcion, pa_valor, pa_tipo) VALUES ('CICLO_10', '10mo. ciclo', '10mo.', 'CI');
INSERT INTO "MPP_PARAMETROS" (pa_id, pa_descripcion, pa_valor, pa_tipo) VALUES ('CICLO_egre', 'Egresados', 'Egresados', 'CI');
INSERT INTO "MPP_PARAMETROS" (pa_id, pa_descripcion, pa_valor, pa_tipo) VALUES ('PROGRAMA_1', 'Programa 1', 'PROGRAMA DE VINCULACION DE ESTUDIANTES EN EL SECTOR PUBLICO Y PRODUCTIVO DEL PAIS', 'PR');
INSERT INTO "MPP_PARAMETROS" (pa_id, pa_descripcion, pa_valor, pa_tipo) VALUES ('PROGRAMA_2', 'Programa 2', 'PROGRAMA DE ATENCION A LOS SECTORES VULNERABLES CON EL INVOLUCRAMIENTO DE DOCENTES Y ESTUDIANTES', 'PR');
INSERT INTO "MPP_PARAMETROS" (pa_id, pa_descripcion, pa_valor, pa_tipo) VALUES ('PROGRAMA_4', 'Programa 4', 'PROGRAMA DE APOYO A DOCENTES Y ESTUDIANTES DE INSTITUCIONES EDUCATIVAS', 'PR');
INSERT INTO "MPP_PARAMETROS" (pa_id, pa_descripcion, pa_valor, pa_tipo) VALUES ('HORA_1', '64 Horas', '64', 'HO');
INSERT INTO "MPP_PARAMETROS" (pa_id, pa_descripcion, pa_valor, pa_tipo) VALUES ('HORA_2', '160 Horas', '160', 'HO');
INSERT INTO "MPP_PARAMETROS" (pa_id, pa_descripcion, pa_valor, pa_tipo) VALUES ('HORA_3', '200 Horas', '200', 'HO');
INSERT INTO "MPP_PARAMETROS" (pa_id, pa_descripcion, pa_valor, pa_tipo) VALUES ('HORA_4', '400 Horas', '400', 'HO');
INSERT INTO "MPP_PARAMETROS" (pa_id, pa_descripcion, pa_valor, pa_tipo) VALUES ('EX', 'Extenciones universitarias', 'EXTENCIONES', 'AC');
INSERT INTO "MPP_PARAMETROS" (pa_id, pa_descripcion, pa_valor, pa_tipo) VALUES ('PA', 'Pasantias universitarias', 'PASANTIAS', 'AC');
INSERT INTO "MPP_PARAMETROS" (pa_id, pa_descripcion, pa_valor, pa_tipo) VALUES ('PP', 'Practicas pre-profesionales', 'PRACTICAS PRE PROFESIONALES', 'AC');
INSERT INTO "MPP_PARAMETROS" (pa_id, pa_descripcion, pa_valor, pa_tipo) VALUES ('GCA', 'Contabilidad y Auditoria', 'CONTABILIDAD Y AUDITORIA', 'CA');
INSERT INTO "MPP_PARAMETROS" (pa_id, pa_descripcion, pa_valor, pa_tipo) VALUES ('GAE', 'Administracion de empresas', 'ADMINISTRACION DE EMPRESAS', 'CA');
INSERT INTO "MPP_PARAMETROS" (pa_id, pa_descripcion, pa_valor, pa_tipo) VALUES ('PROGRAMA_5', 'Programa 5', 'PROGRAMA DE ATENCIÓN ESPECIALIZADA A LOS SECTORES PRODUCTIVOS, PÚBLICOS Y COMUNITARIOS', 'PR');
INSERT INTO "MPP_PARAMETROS" (pa_id, pa_descripcion, pa_valor, pa_tipo) VALUES ('PROGRAMA_6', 'Programa 6', 'PROGRAMA DE INVESTIGACIÓN SOCIAL Y PRODUCTIVA', 'PR');
INSERT INTO "MPP_PARAMETROS" (pa_id, pa_descripcion, pa_valor, pa_tipo) VALUES ('PROGRAMA_8', 'Programa 8', 'PROGRAMA DE VINCULACIÓN DE ESTUDIANTES Y DOCENTES EN SECTORES SOCIALES', 'PR');
INSERT INTO "MPP_PARAMETROS" (pa_id, pa_descripcion, pa_valor, pa_tipo) VALUES ('PROGRAMA_9', 'Programa 9', 'PROGRAMA DE MOVILIDAD', 'PR');
INSERT INTO "MPP_PARAMETROS" (pa_id, pa_descripcion, pa_valor, pa_tipo) VALUES ('PROGRAMA_7', 'Programa 7', 'PROGRAMA DE PROFESIONALIZACIÓN DE JÓVENES INDÍGENAS, AFRO ECUATORIANOS  Y DE COMUNIDADES EN RIESGO', 'PR');
INSERT INTO "MPP_PARAMETROS" (pa_id, pa_descripcion, pa_valor, pa_tipo) VALUES ('GIS', 'Ingenieria de sistemas', 'INGENIERIA DE SISTEMAS', 'CA');
INSERT INTO "MPP_PARAMETROS" (pa_id, pa_descripcion, pa_valor, pa_tipo) VALUES ('GIE', 'Ingenieria electrica', 'INGENIERIA ELECTRICA', 'CA');
INSERT INTO "MPP_PARAMETROS" (pa_id, pa_descripcion, pa_valor, pa_tipo) VALUES ('GIT', 'Ingenieria electronica', 'INGENIERIA ELECTRONICA', 'CA');
INSERT INTO "MPP_PARAMETROS" (pa_id, pa_descripcion, pa_valor, pa_tipo) VALUES ('GIC', 'Ingenieria social', 'INGENIERIA SOCIAL', 'CA');
INSERT INTO "MPP_PARAMETROS" (pa_id, pa_descripcion, pa_valor, pa_tipo) VALUES ('GII', 'Ingenieria industrial', 'INGENIERIA INDUSTRIAL', 'CA');
INSERT INTO "MPP_PARAMETROS" (pa_id, pa_descripcion, pa_valor, pa_tipo) VALUES ('PROGRAMA_10', 'Programa 10', 'PROGRAMA DE VINCULACIÓN DE GRADUADOS EN EL SECTOR PÚBLICO Y PRODUCTIVO DEL PAIS', 'PR');
INSERT INTO "MPP_PARAMETROS" (pa_id, pa_descripcion, pa_valor, pa_tipo) VALUES ('PROGRAMA_3', 'Programa 3', 'PROGRAMA DE FORMACION CONTINUA PARA LOS SECTORES EMPRESARIAL, PUBLICO Y ORGANIZACIONES SOCIALES', 'PR');
COMMIT;
--
-- Data for blobs (OID = 41263) (LIMIT 0,1)
--
INSERT INTO "MPP_ESTUDIANTES" (es_id, es_nombre, es_apellido, es_correo, es_celular, es_cedula, es_id_carrera, es_id_ciclo) VALUES (1, 'Geovanny Francisco', 'Barrera Ordoñez', 'francisco_barrera.92@hotmail.com', '0993992846', '0930026091', 'GIS', 'CICLO_10');
COMMIT;
--
-- Data for blobs (OID = 41346) (LIMIT 0,1)
--
INSERT INTO "MPP_CARTA_COMPROMISO" (cc_id, es_id, cc_tipo_actividad, cc_total_horas, cc_objetivo_actividad, cc_fecha_inicio, cc_fecha_fin, cc_horario_previsto, cc_id_programa, cc_area_actividad, cc_responsable_area, cc_id_tutor, cc_id_director_tecnico, cc_fecha_sistema, cc_lugar_suscripcion, cc_fecha_suscripcion, cc_estado, ue_id) VALUES ('CC001.PA-GIS-033', 1, 'PA', 200, 'OBJETO DE LA ACTIVIDAD ACADÉMICA QUE DESARROLLARÁ EL ESTUDIANTE', '13/02/2016', '13/03/2016', 'Lun - Vie 
8:00 - 15:00', 'PROGRAMA_3', 'SISTEMAS', 'DORIS CRIOLLO CASTILLO', 2, 3, '19/02/2016', 'GUAYAQUIL', '13/02/2016', 'A', 1);
COMMIT;
--
-- Data for blobs (OID = 41388) (LIMIT 0,18)
--
INSERT INTO "MPP_ASIGNAR_ELEMENTO" (ae_id, ae_descripcion, ae_tipo, cc_id, ae_orden) VALUES (1, 'Elaboración de anexos para declaraciones de impuesto formulario 103 y 104.', 'AC', 'CC001.PA-GIS-033', 1);
INSERT INTO "MPP_ASIGNAR_ELEMENTO" (ae_id, ae_descripcion, ae_tipo, cc_id, ae_orden) VALUES (2, 'Ingreso de facturas de compras y emisión de retenciones.', 'AC', 'CC001.PA-GIS-033', 2);
INSERT INTO "MPP_ASIGNAR_ELEMENTO" (ae_id, ae_descripcion, ae_tipo, cc_id, ae_orden) VALUES (3, 'Revisión y liquidación de caja chica.', 'AC', 'CC001.PA-GIS-033', 3);
INSERT INTO "MPP_ASIGNAR_ELEMENTO" (ae_id, ae_descripcion, ae_tipo, cc_id, ae_orden) VALUES (4, 'Declaración de anexo transaccional simplificado.', 'AC', 'CC001.PA-GIS-033', 4);
INSERT INTO "MPP_ASIGNAR_ELEMENTO" (ae_id, ae_descripcion, ae_tipo, cc_id, ae_orden) VALUES (5, 'Preparación de flujo de caja según los requerimientos de la empresa.', 'AC', 'CC001.PA-GIS-033', 5);
INSERT INTO "MPP_ASIGNAR_ELEMENTO" (ae_id, ae_descripcion, ae_tipo, cc_id, ae_orden) VALUES (6, 'Preparación de flujo de caja según los requerimientos de la empresa.', 'AC', 'CC001.PA-GIS-033', 6);
INSERT INTO "MPP_ASIGNAR_ELEMENTO" (ae_id, ae_descripcion, ae_tipo, cc_id, ae_orden) VALUES (7, 'Resultado 1', 'RE', 'CC001.PA-GIS-033', 1);
INSERT INTO "MPP_ASIGNAR_ELEMENTO" (ae_id, ae_descripcion, ae_tipo, cc_id, ae_orden) VALUES (8, 'Mantener a la fecha los registros contables.', 'RE', 'CC001.PA-GIS-033', 2);
INSERT INTO "MPP_ASIGNAR_ELEMENTO" (ae_id, ae_descripcion, ae_tipo, cc_id, ae_orden) VALUES (9, 'Atender gastos de menor cuantía y una correcta contabilización.', 'RE', 'CC001.PA-GIS-033', 3);
INSERT INTO "MPP_ASIGNAR_ELEMENTO" (ae_id, ae_descripcion, ae_tipo, cc_id, ae_orden) VALUES (10, 'Presentar información vinculada con las transacciones efectuadas según lo exige la ley de régimen tributario interno art. 50.', 'RE', 'CC001.PA-GIS-033', 4);
INSERT INTO "MPP_ASIGNAR_ELEMENTO" (ae_id, ae_descripcion, ae_tipo, cc_id, ae_orden) VALUES (11, 'Programar adecuadamente los pagos a realizar semanalmente e identificar los ingresos a percibir.', 'RE', 'CC001.PA-GIS-033', 5);
INSERT INTO "MPP_ASIGNAR_ELEMENTO" (ae_id, ae_descripcion, ae_tipo, cc_id, ae_orden) VALUES (12, 'Confirmar que los saldos en libros coincidan con los saldos bancarios.', 'RE', 'CC001.PA-GIS-033', 6);
INSERT INTO "MPP_ASIGNAR_ELEMENTO" (ae_id, ae_descripcion, ae_tipo, cc_id, ae_orden) VALUES (13, 'Reporte de los Formularios 103 – 104', 'RC', 'CC001.PA-GIS-033', 1);
INSERT INTO "MPP_ASIGNAR_ELEMENTO" (ae_id, ae_descripcion, ae_tipo, cc_id, ae_orden) VALUES (14, 'Informe de los registros en el diario, junto con el registro directo en el sistema sap.', 'RC', 'CC001.PA-GIS-033', 2);
INSERT INTO "MPP_ASIGNAR_ELEMENTO" (ae_id, ae_descripcion, ae_tipo, cc_id, ae_orden) VALUES (15, 'Reporte de sustento caja chica, registro directo en el sistema sap.', 'RC', 'CC001.PA-GIS-033', 3);
INSERT INTO "MPP_ASIGNAR_ELEMENTO" (ae_id, ae_descripcion, ae_tipo, cc_id, ae_orden) VALUES (16, 'Talón de resumen de anexo transaccional simplificado.', 'RC', 'CC001.PA-GIS-033', 4);
INSERT INTO "MPP_ASIGNAR_ELEMENTO" (ae_id, ae_descripcion, ae_tipo, cc_id, ae_orden) VALUES (17, 'Flujo de caja.', 'RC', 'CC001.PA-GIS-033', 5);
INSERT INTO "MPP_ASIGNAR_ELEMENTO" (ae_id, ae_descripcion, ae_tipo, cc_id, ae_orden) VALUES (18, 'Reporte conciliaciones bancarias.', 'RC', 'CC001.PA-GIS-033', 6);
COMMIT;
-- Definition for index PK_MPP_PARAMETROS (OID = 41261):
ALTER TABLE ONLY "MPP_PARAMETROS"
    ADD CONSTRAINT "PK_MPP_PARAMETROS" PRIMARY KEY (pa_id);
-- Definition for index PK_MAU_MENU (OID = 41278):
ALTER TABLE ONLY "MAU_MENU"
    ADD CONSTRAINT "PK_MAU_MENU" PRIMARY KEY (me_id);
-- Definition for index PK_MAU_MENU_ROL (OID = 41280):
ALTER TABLE ONLY "MAU_MENU_ROL"
    ADD CONSTRAINT "PK_MAU_MENU_ROL" PRIMARY KEY (mr_id);
-- Definition for index PK_MAU_ROL (OID = 41282):
ALTER TABLE ONLY "MAU_ROL"
    ADD CONSTRAINT "PK_MAU_ROL" PRIMARY KEY (ro_id);
-- Definition for index PK_MAU_USUARIO (OID = 41284):
ALTER TABLE ONLY "MAU_USUARIO"
    ADD CONSTRAINT "PK_MAU_USUARIO" PRIMARY KEY (us_id);
-- Definition for index PK_MPP_AGREGAR_REPRESENTANTE (OID = 41286):
ALTER TABLE ONLY "MPP_AGREGAR_REPRESENTANTE"
    ADD CONSTRAINT "PK_MPP_AGREGAR_REPRESENTANTE" PRIMARY KEY (ar_id);
-- Definition for index PK_MPP_CRONOGRAMA_ACT (OID = 41292):
ALTER TABLE ONLY "MPP_CRONOGRAMA_ACT"
    ADD CONSTRAINT "PK_MPP_CRONOGRAMA_ACT" PRIMARY KEY (ca_id);
-- Definition for index PK_MPP_ESTUDIANTES (OID = 41294):
ALTER TABLE ONLY "MPP_ESTUDIANTES"
    ADD CONSTRAINT "PK_MPP_ESTUDIANTES" PRIMARY KEY (es_id);
-- Definition for index PK_MPP_FICHA_ESTUDIANTE (OID = 41296):
ALTER TABLE ONLY "MPP_FICHA_ESTUDIANTE"
    ADD CONSTRAINT "PK_MPP_FICHA_ESTUDIANTE" PRIMARY KEY (fe_id);
-- Definition for index PK_MPP_UNIDAD_EXTERNA (OID = 41298):
ALTER TABLE ONLY "MPP_UNIDAD_EXTERNA"
    ADD CONSTRAINT "PK_MPP_UNIDAD_EXTERNA" PRIMARY KEY (ue_id);
-- Definition for index FK_MENU_ROL_1 (OID = 41300):
ALTER TABLE ONLY "MAU_MENU_ROL"
    ADD CONSTRAINT "FK_MENU_ROL_1" FOREIGN KEY (me_id) REFERENCES "MAU_MENU"(me_id);
-- Definition for index FK_MENU_ROL_2 (OID = 41305):
ALTER TABLE ONLY "MAU_MENU_ROL"
    ADD CONSTRAINT "FK_MENU_ROL_2" FOREIGN KEY (ro_id) REFERENCES "MAU_ROL"(ro_id);
-- Definition for index FK_USUARIO_ROL (OID = 41310):
ALTER TABLE ONLY "MAU_USUARIO"
    ADD CONSTRAINT "FK_USUARIO_ROL" FOREIGN KEY (ro_id) REFERENCES "MAU_ROL"(ro_id);
-- Definition for index FK_UNIDAD_EXTERNA_REP1 (OID = 41315):
ALTER TABLE ONLY "MPP_AGREGAR_REPRESENTANTE"
    ADD CONSTRAINT "FK_UNIDAD_EXTERNA_REP1" FOREIGN KEY (ue_id) REFERENCES "MPP_UNIDAD_EXTERNA"(ue_id);
-- Definition for index PK_MPP_CARTA_COMPROMISO (OID = 41354):
ALTER TABLE ONLY "MPP_CARTA_COMPROMISO"
    ADD CONSTRAINT "PK_MPP_CARTA_COMPROMISO" PRIMARY KEY (cc_id);
-- Definition for index FK_MPP_CARTA_COMPROMISO (OID = 41356):
ALTER TABLE ONLY "MPP_CARTA_COMPROMISO"
    ADD CONSTRAINT "FK_MPP_CARTA_COMPROMISO" FOREIGN KEY (es_id) REFERENCES "MPP_ESTUDIANTES"(es_id);
-- Definition for index FK_MPP_CARTA_COMPROMISO2 (OID = 41361):
ALTER TABLE ONLY "MPP_CARTA_COMPROMISO"
    ADD CONSTRAINT "FK_MPP_CARTA_COMPROMISO2" FOREIGN KEY (cc_tipo_actividad) REFERENCES "MPP_PARAMETROS"(pa_id);
-- Definition for index FK_MPP_CARTA_COMPROMISO3 (OID = 41366):
ALTER TABLE ONLY "MPP_CARTA_COMPROMISO"
    ADD CONSTRAINT "FK_MPP_CARTA_COMPROMISO3" FOREIGN KEY (cc_id_programa) REFERENCES "MPP_PARAMETROS"(pa_id);
-- Definition for index FK_MPP_CARTA_COMPROMISO5 (OID = 41371):
ALTER TABLE ONLY "MPP_CARTA_COMPROMISO"
    ADD CONSTRAINT "FK_MPP_CARTA_COMPROMISO5" FOREIGN KEY (cc_id_director_tecnico) REFERENCES "MAU_USUARIO"(us_id);
-- Definition for index FK_MPP_CARTA_COMPROMISO4 (OID = 41376):
ALTER TABLE ONLY "MPP_CARTA_COMPROMISO"
    ADD CONSTRAINT "FK_MPP_CARTA_COMPROMISO4" FOREIGN KEY (cc_id_tutor) REFERENCES "MAU_USUARIO"(us_id);
-- Definition for index PK_MPP_ASIGNAR_ELEMENTO (OID = 41395):
ALTER TABLE ONLY "MPP_ASIGNAR_ELEMENTO"
    ADD CONSTRAINT "PK_MPP_ASIGNAR_ELEMENTO" PRIMARY KEY (ae_id);
-- Definition for index FK_MPP_ASIGNAR_ELEMENTO (OID = 41397):
ALTER TABLE ONLY "MPP_ASIGNAR_ELEMENTO"
    ADD CONSTRAINT "FK_MPP_ASIGNAR_ELEMENTO" FOREIGN KEY (cc_id) REFERENCES "MPP_CARTA_COMPROMISO"(cc_id);
-- Definition for index FK_MPP_CRONOGRAMA_ACT2 (OID = 41402):
ALTER TABLE ONLY "MPP_CRONOGRAMA_ACT"
    ADD CONSTRAINT "FK_MPP_CRONOGRAMA_ACT2" FOREIGN KEY (ae_id) REFERENCES "MPP_ASIGNAR_ELEMENTO"(ae_id);
-- Definition for index FK_MPP_FICHA_ESTUDIANTE (OID = 41412):
ALTER TABLE ONLY "MPP_FICHA_ESTUDIANTE"
    ADD CONSTRAINT "FK_MPP_FICHA_ESTUDIANTE" FOREIGN KEY (cc_id) REFERENCES "MPP_CARTA_COMPROMISO"(cc_id);
-- Definition for index PK_MPR_PROYECTO (OID = 41426):
ALTER TABLE ONLY "MPR_PROYECTO"
    ADD CONSTRAINT "PK_MPR_PROYECTO" PRIMARY KEY (pr_id);
-- Definition for index FK_MPR_PROYECTO (OID = 41428):
ALTER TABLE ONLY "MPR_PROYECTO"
    ADD CONSTRAINT "FK_MPR_PROYECTO" FOREIGN KEY (pr_id_programa) REFERENCES "MPP_PARAMETROS"(pa_id);
-- Definition for index PK_MPR_RESPONSABLE_PROYECTO (OID = 41439):
ALTER TABLE ONLY "MPR_RESPONSABLE_PROYECTO"
    ADD CONSTRAINT "PK_MPR_RESPONSABLE_PROYECTO" PRIMARY KEY (rp_id);
-- Definition for index FK_MPR_RESPONSABLE_PROYECTO (OID = 41441):
ALTER TABLE ONLY "MPR_RESPONSABLE_PROYECTO"
    ADD CONSTRAINT "FK_MPR_RESPONSABLE_PROYECTO" FOREIGN KEY (rp_id_responsable) REFERENCES "MAU_USUARIO"(us_id);
-- Definition for index FK_MPR_RESPONSABLE_PROYECTO2 (OID = 41446):
ALTER TABLE ONLY "MPR_RESPONSABLE_PROYECTO"
    ADD CONSTRAINT "FK_MPR_RESPONSABLE_PROYECTO2" FOREIGN KEY (rp_id_proyecto) REFERENCES "MPR_PROYECTO"(pr_id);
-- Definition for index FK_MPP_FICHA_ESTUDIANTE2 (OID = 41467):
ALTER TABLE ONLY "MPP_FICHA_ESTUDIANTE"
    ADD CONSTRAINT "FK_MPP_FICHA_ESTUDIANTE2" FOREIGN KEY (pr_id) REFERENCES "MPR_PROYECTO"(pr_id);
-- Definition for index FK_MPP_CARTA_COMPROMISO6 (OID = 41472):
ALTER TABLE ONLY "MPP_CARTA_COMPROMISO"
    ADD CONSTRAINT "FK_MPP_CARTA_COMPROMISO6" FOREIGN KEY (ue_id) REFERENCES "MPP_UNIDAD_EXTERNA"(ue_id);
SET search_path = pg_catalog, pg_catalog;
COMMENT ON SCHEMA public IS 'standard public schema';
--
-- Comments
--
SET search_path = public, pg_catalog;
COMMENT ON COLUMN "MAU_MENU".me_descripcion IS 'Descripcion de la opcion del menu';
COMMENT ON COLUMN "MAU_MENU".me_nombre IS 'Nombre de la opcion del menu';
COMMENT ON COLUMN "MAU_MENU".me_menu_padre IS 'Identificador del menu padre(Recursivo)';
COMMENT ON COLUMN "MAU_MENU".me_pagina IS 'Pagina a invocar con la ruta del servidor';
COMMENT ON COLUMN "MAU_MENU".me_icono IS 'Ruta del icono de la opcion del menu';
COMMENT ON COLUMN "MAU_MENU".me_es_padre IS 'Idenfica si es un menu padre - S - Si - N - No';
COMMENT ON COLUMN "MAU_MENU".me_estado IS 'Estado de la opcion A-Activo-I-Inactivo';
COMMENT ON TABLE "MAU_ROL" IS 'Contiene los roles de los usuarios';
COMMENT ON COLUMN "MAU_ROL".ro_id IS 'Identificador del rol';
COMMENT ON COLUMN "MAU_ROL".ro_descripcion IS 'Descripcion del rol';
COMMENT ON COLUMN "MAU_ROL".ro_estado IS 'Estado del rol';
COMMENT ON TABLE "MAU_MENU_ROL" IS 'TABLA RELACIONAL ENTRE EL MENU Y EL ROL';
COMMENT ON COLUMN "MAU_MENU_ROL".mr_id IS 'Identificador de la relacion entre el menu y su rol';
COMMENT ON COLUMN "MAU_MENU_ROL".me_id IS 'Identificador del id_menu';
COMMENT ON COLUMN "MAU_MENU_ROL".ro_id IS 'Identificador del rol';
COMMENT ON TABLE "MAU_USUARIO" IS 'Contiene los usuarios del sistema';
COMMENT ON COLUMN "MAU_USUARIO".us_id IS 'Identificador del usuario';
COMMENT ON COLUMN "MAU_USUARIO".us_cedula IS 'Cedula del Usuario';
COMMENT ON COLUMN "MAU_USUARIO".us_nombre IS 'Nombre del usuario';
COMMENT ON COLUMN "MAU_USUARIO".us_apellido IS 'Apellido del usuario';
COMMENT ON COLUMN "MAU_USUARIO".us_direccion IS 'Direccion del usuario';
COMMENT ON COLUMN "MAU_USUARIO".us_cargo IS 'Cargo del usuario';
COMMENT ON COLUMN "MAU_USUARIO".us_fecha_nacimiento IS 'Fecha de nacimiento del usuario';
COMMENT ON COLUMN "MAU_USUARIO".us_celular IS 'Celular del usuario';
COMMENT ON COLUMN "MAU_USUARIO".us_usuario IS 'Usuario con el cual se ingresa al sistema';
COMMENT ON COLUMN "MAU_USUARIO".us_contrasena IS 'Clave del usuario';
COMMENT ON COLUMN "MAU_USUARIO".ro_id IS 'Identificador del rol';
COMMENT ON COLUMN "MAU_USUARIO".us_estado IS 'Estado del usuario A-Activo-I-Inactivo';
COMMENT ON TABLE "MPP_AGREGAR_REPRESENTANTE" IS 'Contiene la informacion del representante de la unidad externa relacionada con la carta de compromiso';
COMMENT ON COLUMN "MPP_AGREGAR_REPRESENTANTE".ar_id IS 'Identificador del representante';
COMMENT ON COLUMN "MPP_AGREGAR_REPRESENTANTE".ar_nombre IS 'Nombre del representante';
COMMENT ON COLUMN "MPP_AGREGAR_REPRESENTANTE".ar_apellido IS 'Apellido del representante';
COMMENT ON COLUMN "MPP_AGREGAR_REPRESENTANTE".ar_cargo IS 'Cargo del representante';
COMMENT ON COLUMN "MPP_AGREGAR_REPRESENTANTE".ar_telefono IS 'Telefono del representante';
COMMENT ON COLUMN "MPP_AGREGAR_REPRESENTANTE".ue_id IS 'Identificador de la unidad externa a la que pertenece';
COMMENT ON TABLE "MPP_UNIDAD_EXTERNA" IS 'Contiene las unidad_externas aplicables a las diferentes actividades';
COMMENT ON COLUMN "MPP_UNIDAD_EXTERNA".ue_id IS 'Identificador de la unidad_externa';
COMMENT ON COLUMN "MPP_UNIDAD_EXTERNA".ue_nombre IS 'Nombre de la unidad_externa';
COMMENT ON COLUMN "MPP_UNIDAD_EXTERNA".ue_direccion IS 'Direccion de la unidad_externa';
COMMENT ON COLUMN "MPP_UNIDAD_EXTERNA".ue_telefono IS 'Telefono de la unidad_externa';
COMMENT ON COLUMN "MPP_UNIDAD_EXTERNA".ue_actividad_principal IS 'Actividad a la que se dedica la unidad_externa';
COMMENT ON COLUMN "MPP_UNIDAD_EXTERNA".ue_tipo IS 'Define el tipo de en unidad externa es como -PU-Publicas-PR-Privadas-MI-Mixtas-CO-Comunidades';
COMMENT ON COLUMN "MPP_UNIDAD_EXTERNA".ue_estado IS 'Estado de la unidad externa A-Activa-I-Inactiva';
COMMENT ON TABLE "MPP_FICHA_ESTUDIANTE" IS 'Contiene la informacion de la ficha del estudiante';
COMMENT ON COLUMN "MPP_FICHA_ESTUDIANTE".fe_id IS 'Identificador de la ficha del estudiante';
COMMENT ON COLUMN "MPP_FICHA_ESTUDIANTE".fe_nombre_proyecto IS 'Nombre del proyecto en el caso de que sean extensiones universitarias';
COMMENT ON COLUMN "MPP_FICHA_ESTUDIANTE".fe_twitter IS 'Twitter del estudiante';
COMMENT ON COLUMN "MPP_FICHA_ESTUDIANTE".fe_facebook IS 'Facebook del estudiante';
COMMENT ON COLUMN "MPP_FICHA_ESTUDIANTE".cc_id IS 'Identificador de la carta compromiso';
COMMENT ON COLUMN "MPP_FICHA_ESTUDIANTE".fe_tipo_documento IS 'Tipo de documento';
COMMENT ON COLUMN "MPP_FICHA_ESTUDIANTE".fe_direccion IS 'Direccion del estudiante';
COMMENT ON COLUMN "MPP_FICHA_ESTUDIANTE".pr_id IS 'Identificador del proyecto';
COMMENT ON TABLE "MPP_CRONOGRAMA_ACT" IS 'Contiene la informacion del cronograma de actividades';
COMMENT ON COLUMN "MPP_CRONOGRAMA_ACT".ca_id IS 'Identificador de la carta compromiso';
COMMENT ON COLUMN "MPP_CRONOGRAMA_ACT".ca_semana IS 'Numero de semana';
COMMENT ON COLUMN "MPP_CRONOGRAMA_ACT".ca_num_hora IS 'Numero de hora por semana';
COMMENT ON COLUMN "MPP_CRONOGRAMA_ACT".ae_id IS 'Identificador del elemento';
COMMENT ON TABLE "MPP_PARAMETROS" IS 'Contiene todos los parametros generales';
COMMENT ON COLUMN "MPP_PARAMETROS".pa_id IS 'Identificador del parametro';
COMMENT ON COLUMN "MPP_PARAMETROS".pa_descripcion IS 'Descripcion del parametro';
COMMENT ON COLUMN "MPP_PARAMETROS".pa_valor IS 'Contiene el valor parametrizado';
COMMENT ON COLUMN "MPP_PARAMETROS".pa_tipo IS 'Identifica el tipo de parametro';
COMMENT ON TABLE "MPP_ESTUDIANTES" IS 'Vista que contiene la informacion de los estudiantes';
COMMENT ON COLUMN "MPP_ESTUDIANTES".es_id IS 'Identificador del estudiante';
COMMENT ON COLUMN "MPP_ESTUDIANTES".es_nombre IS 'Nombres del estudiante';
COMMENT ON COLUMN "MPP_ESTUDIANTES".es_apellido IS 'Apellidos del estudiantes';
COMMENT ON COLUMN "MPP_ESTUDIANTES".es_correo IS 'Correo del estudiante';
COMMENT ON COLUMN "MPP_ESTUDIANTES".es_celular IS 'Celular del estudiante';
COMMENT ON COLUMN "MPP_ESTUDIANTES".es_cedula IS 'Cedula del estudiante';
COMMENT ON COLUMN "MPP_ESTUDIANTES".es_id_carrera IS 'Identificador de la carrera referenciada a la tabla de parametros con el tipo CA';
COMMENT ON COLUMN "MPP_ESTUDIANTES".es_id_ciclo IS 'Identificador de el ciclo referenciada a la tabla de parametros con el tipo CI';
COMMENT ON TABLE "MPP_CARTA_COMPROMISO" IS 'Contiene la informacion almacenada en el documento de carta compromiso';
COMMENT ON COLUMN "MPP_CARTA_COMPROMISO".cc_id IS 'Identificador de la carta compromiso';
COMMENT ON COLUMN "MPP_CARTA_COMPROMISO".es_id IS 'Identificador del estudiante';
COMMENT ON COLUMN "MPP_CARTA_COMPROMISO".cc_tipo_actividad IS 'Referenciado al id del parametro con tipo AC';
COMMENT ON COLUMN "MPP_CARTA_COMPROMISO".cc_total_horas IS 'Total de horas de la actividad';
COMMENT ON COLUMN "MPP_CARTA_COMPROMISO".cc_objetivo_actividad IS 'Objetivo de la actividad';
COMMENT ON COLUMN "MPP_CARTA_COMPROMISO".cc_fecha_inicio IS 'Fecha en la que inicia la actividad';
COMMENT ON COLUMN "MPP_CARTA_COMPROMISO".cc_fecha_fin IS 'Fecha en la que culmina la actividad';
COMMENT ON COLUMN "MPP_CARTA_COMPROMISO".cc_horario_previsto IS 'Horario previsto para la actividad';
COMMENT ON COLUMN "MPP_CARTA_COMPROMISO".cc_id_programa IS 'Identificador del programa referenciado con la tabla de parametros con tipo PR';
COMMENT ON COLUMN "MPP_CARTA_COMPROMISO".cc_area_actividad IS 'Area a la que va a emplear la actividad';
COMMENT ON COLUMN "MPP_CARTA_COMPROMISO".cc_responsable_area IS 'Responsable del area de la actividad';
COMMENT ON COLUMN "MPP_CARTA_COMPROMISO".cc_id_tutor IS 'Identificador del tutor referenciado a la tabla usuario';
COMMENT ON COLUMN "MPP_CARTA_COMPROMISO".cc_id_director_tecnico IS 'Identificador del director tecnico referenciado a la tabla usuario';
COMMENT ON COLUMN "MPP_CARTA_COMPROMISO".cc_fecha_sistema IS 'Fecha en la que fue ingresada';
COMMENT ON COLUMN "MPP_CARTA_COMPROMISO".cc_lugar_suscripcion IS 'Lugar donde se suscribio';
COMMENT ON COLUMN "MPP_CARTA_COMPROMISO".cc_fecha_suscripcion IS 'Fecha en la que se suscribio la actividad';
COMMENT ON COLUMN "MPP_CARTA_COMPROMISO".cc_estado IS 'Estado de la carta compromiso A-Activo-I-Inactivo';
COMMENT ON COLUMN "MPP_CARTA_COMPROMISO".ue_id IS 'Idenficador de la Unidad Externa';
COMMENT ON TABLE "MPP_ASIGNAR_ELEMENTO" IS 'Contiene los recursos RC - Resultados RE - Actividades AC';
COMMENT ON COLUMN "MPP_ASIGNAR_ELEMENTO".ae_id IS 'Identificador del elemento';
COMMENT ON COLUMN "MPP_ASIGNAR_ELEMENTO".ae_descripcion IS 'Descripcion del elemento';
COMMENT ON COLUMN "MPP_ASIGNAR_ELEMENTO".ae_tipo IS 'Tipo de elemento Recursos RC - Resultados RE - Actividades AC';
COMMENT ON COLUMN "MPP_ASIGNAR_ELEMENTO".cc_id IS 'Identificador de la carta compromiso';
COMMENT ON COLUMN "MPP_ASIGNAR_ELEMENTO".ae_orden IS 'Orden del elemento';
COMMENT ON TABLE "MPR_PROYECTO" IS 'Tabla de proyectos';
COMMENT ON COLUMN "MPR_PROYECTO".pr_id IS 'Identificador del proyecto';
COMMENT ON COLUMN "MPR_PROYECTO".pr_nombre IS 'Nombre del proyecto';
COMMENT ON COLUMN "MPR_PROYECTO".pr_fecha_inicio IS 'Fecha de inicio del proyecto';
COMMENT ON COLUMN "MPR_PROYECTO".pr_fecha_fin IS 'Fecha de finalizacion del proyecto';
COMMENT ON COLUMN "MPR_PROYECTO".pr_id_programa IS 'Identificador del programa al que va relacionado el proyecto Tipo de parametro PR';
COMMENT ON TABLE "MPR_RESPONSABLE_PROYECTO" IS 'Contiene la relacion entre los responsables del proyecto y el proyecto asociado';
COMMENT ON COLUMN "MPR_RESPONSABLE_PROYECTO".rp_id IS 'Idenficador PK';
COMMENT ON COLUMN "MPR_RESPONSABLE_PROYECTO".rp_id_responsable IS 'Identificador del responsable del proyecto asociado a la tabla usuario';
COMMENT ON COLUMN "MPR_RESPONSABLE_PROYECTO".rp_id_proyecto IS 'Identificador del proyecto';
