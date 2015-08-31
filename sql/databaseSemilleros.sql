--
-- PostgreSQL database dump
--

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

SET search_path = public, pg_catalog;

--
-- Name: tipodoc; Type: TYPE; Schema: public; Owner: SuperAdministrador
--

CREATE TYPE tipodoc AS ENUM (
    'cc',
    'ce',
    'ti',
    'rc',
    'pp'
);


ALTER TYPE public.tipodoc OWNER TO "SuperAdministrador";

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: actividad; Type: TABLE; Schema: public; Owner: SuperAdministrador; Tablespace: 
--

CREATE TABLE actividad (
    idactividad integer NOT NULL,
    nombreactividad character varying(100) NOT NULL,
    descripcion character varying(500),
    idinforme integer NOT NULL
);


ALTER TABLE public.actividad OWNER TO "SuperAdministrador";

--
-- Name: actividad_idactividad_seq; Type: SEQUENCE; Schema: public; Owner: SuperAdministrador
--

CREATE SEQUENCE actividad_idactividad_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.actividad_idactividad_seq OWNER TO "SuperAdministrador";

--
-- Name: actividad_idactividad_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: SuperAdministrador
--

ALTER SEQUENCE actividad_idactividad_seq OWNED BY actividad.idactividad;


--
-- Name: areatematica; Type: TABLE; Schema: public; Owner: SuperAdministrador; Tablespace: 
--

CREATE TABLE areatematica (
    idarea integer NOT NULL,
    nombrearea character varying(100) NOT NULL,
    descripcion character varying(500)
);


ALTER TABLE public.areatematica OWNER TO "SuperAdministrador";

--
-- Name: areatematica_idarea_seq; Type: SEQUENCE; Schema: public; Owner: SuperAdministrador
--

CREATE SEQUENCE areatematica_idarea_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.areatematica_idarea_seq OWNER TO "SuperAdministrador";

--
-- Name: areatematica_idarea_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: SuperAdministrador
--

ALTER SEQUENCE areatematica_idarea_seq OWNED BY areatematica.idarea;


--
-- Name: categoria; Type: TABLE; Schema: public; Owner: SuperAdministrador; Tablespace: 
--

CREATE TABLE categoria (
    idcategoria integer NOT NULL,
    nombrecategoria character varying(100) NOT NULL,
    descripcion character varying(500)
);


ALTER TABLE public.categoria OWNER TO "SuperAdministrador";

--
-- Name: categoria_idcategoria_seq; Type: SEQUENCE; Schema: public; Owner: SuperAdministrador
--

CREATE SEQUENCE categoria_idcategoria_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.categoria_idcategoria_seq OWNER TO "SuperAdministrador";

--
-- Name: categoria_idcategoria_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: SuperAdministrador
--

ALTER SEQUENCE categoria_idcategoria_seq OWNED BY categoria.idcategoria;


--
-- Name: centroinvestigacion; Type: TABLE; Schema: public; Owner: SuperAdministrador; Tablespace: 
--

CREATE TABLE centroinvestigacion (
    idcentro integer NOT NULL,
    nombrecentro character varying(100) NOT NULL,
    descripcion character varying(100)
);


ALTER TABLE public.centroinvestigacion OWNER TO "SuperAdministrador";

--
-- Name: centroinvestigacion_idcentro_seq; Type: SEQUENCE; Schema: public; Owner: SuperAdministrador
--

CREATE SEQUENCE centroinvestigacion_idcentro_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.centroinvestigacion_idcentro_seq OWNER TO "SuperAdministrador";

--
-- Name: centroinvestigacion_idcentro_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: SuperAdministrador
--

ALTER SEQUENCE centroinvestigacion_idcentro_seq OWNED BY centroinvestigacion.idcentro;


--
-- Name: colaborador; Type: TABLE; Schema: public; Owner: SuperAdministrador; Tablespace: 
--

CREATE TABLE colaborador (
    idcolaborador integer NOT NULL,
    nombre character varying(100) NOT NULL,
    descripcion character varying(500),
    idinforme integer NOT NULL
);


ALTER TABLE public.colaborador OWNER TO "SuperAdministrador";

--
-- Name: colaborador_idcolaborador_seq; Type: SEQUENCE; Schema: public; Owner: SuperAdministrador
--

CREATE SEQUENCE colaborador_idcolaborador_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.colaborador_idcolaborador_seq OWNER TO "SuperAdministrador";

--
-- Name: colaborador_idcolaborador_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: SuperAdministrador
--

ALTER SEQUENCE colaborador_idcolaborador_seq OWNED BY colaborador.idcolaborador;


--
-- Name: contacto; Type: TABLE; Schema: public; Owner: SuperAdministrador; Tablespace: 
--

CREATE TABLE contacto (
    nombre character varying NOT NULL,
    telefono bigint,
    direccion character varying,
    mail character varying,
    idred integer,
    idcontacto integer NOT NULL
);


ALTER TABLE public.contacto OWNER TO "SuperAdministrador";

--
-- Name: contacto_idcontacto_seq; Type: SEQUENCE; Schema: public; Owner: SuperAdministrador
--

CREATE SEQUENCE contacto_idcontacto_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.contacto_idcontacto_seq OWNER TO "SuperAdministrador";

--
-- Name: contacto_idcontacto_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: SuperAdministrador
--

ALTER SEQUENCE contacto_idcontacto_seq OWNED BY contacto.idcontacto;


--
-- Name: documentosemillero; Type: TABLE; Schema: public; Owner: SuperAdministrador; Tablespace: 
--

CREATE TABLE documentosemillero (
    iddocumento integer NOT NULL,
    idsemillero integer NOT NULL,
    pathdocumento character varying(500) NOT NULL,
    descripcion character varying(500) NOT NULL
);


ALTER TABLE public.documentosemillero OWNER TO "SuperAdministrador";

--
-- Name: documentosemillero_iddocumento_seq; Type: SEQUENCE; Schema: public; Owner: SuperAdministrador
--

CREATE SEQUENCE documentosemillero_iddocumento_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.documentosemillero_iddocumento_seq OWNER TO "SuperAdministrador";

--
-- Name: documentosemillero_iddocumento_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: SuperAdministrador
--

ALTER SEQUENCE documentosemillero_iddocumento_seq OWNED BY documentosemillero.iddocumento;


--
-- Name: funcionalidad; Type: TABLE; Schema: public; Owner: SuperAdministrador; Tablespace: 
--

CREATE TABLE funcionalidad (
    idfuncionalidad integer NOT NULL,
    nombrefuncionalidad integer NOT NULL
);


ALTER TABLE public.funcionalidad OWNER TO "SuperAdministrador";

--
-- Name: funcionalidad_idfuncionalidad_seq; Type: SEQUENCE; Schema: public; Owner: SuperAdministrador
--

CREATE SEQUENCE funcionalidad_idfuncionalidad_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.funcionalidad_idfuncionalidad_seq OWNER TO "SuperAdministrador";

--
-- Name: funcionalidad_idfuncionalidad_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: SuperAdministrador
--

ALTER SEQUENCE funcionalidad_idfuncionalidad_seq OWNED BY funcionalidad.idfuncionalidad;


--
-- Name: funcionalidad_nombrefuncionalidad_seq; Type: SEQUENCE; Schema: public; Owner: SuperAdministrador
--

CREATE SEQUENCE funcionalidad_nombrefuncionalidad_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.funcionalidad_nombrefuncionalidad_seq OWNER TO "SuperAdministrador";

--
-- Name: funcionalidad_nombrefuncionalidad_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: SuperAdministrador
--

ALTER SEQUENCE funcionalidad_nombrefuncionalidad_seq OWNED BY funcionalidad.nombrefuncionalidad;


--
-- Name: grupoinvestigacion; Type: TABLE; Schema: public; Owner: SuperAdministrador; Tablespace: 
--

CREATE TABLE grupoinvestigacion (
    idgrupo integer NOT NULL,
    nombregrupo character varying(500) NOT NULL,
    descripcion character varying(500),
    idcentro integer NOT NULL
);


ALTER TABLE public.grupoinvestigacion OWNER TO "SuperAdministrador";

--
-- Name: grupoinvestigacion_idgrupo_seq; Type: SEQUENCE; Schema: public; Owner: SuperAdministrador
--

CREATE SEQUENCE grupoinvestigacion_idgrupo_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.grupoinvestigacion_idgrupo_seq OWNER TO "SuperAdministrador";

--
-- Name: grupoinvestigacion_idgrupo_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: SuperAdministrador
--

ALTER SEQUENCE grupoinvestigacion_idgrupo_seq OWNED BY grupoinvestigacion.idgrupo;


--
-- Name: informe; Type: TABLE; Schema: public; Owner: SuperAdministrador; Tablespace: 
--

CREATE TABLE informe (
    idinforme integer NOT NULL,
    fecha date NOT NULL,
    idsemillero integer NOT NULL
);


ALTER TABLE public.informe OWNER TO "SuperAdministrador";

--
-- Name: informe_idinforme_seq; Type: SEQUENCE; Schema: public; Owner: SuperAdministrador
--

CREATE SEQUENCE informe_idinforme_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.informe_idinforme_seq OWNER TO "SuperAdministrador";

--
-- Name: informe_idinforme_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: SuperAdministrador
--

ALTER SEQUENCE informe_idinforme_seq OWNED BY informe.idinforme;


--
-- Name: lineainvestigacion; Type: TABLE; Schema: public; Owner: SuperAdministrador; Tablespace: 
--

CREATE TABLE lineainvestigacion (
    idlinea integer NOT NULL,
    nombrelinea character varying(100) NOT NULL,
    descripcion character varying(400),
    idgrupo integer NOT NULL
);


ALTER TABLE public.lineainvestigacion OWNER TO "SuperAdministrador";

--
-- Name: lineainvestigacion_idlinea_seq; Type: SEQUENCE; Schema: public; Owner: SuperAdministrador
--

CREATE SEQUENCE lineainvestigacion_idlinea_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.lineainvestigacion_idlinea_seq OWNER TO "SuperAdministrador";

--
-- Name: lineainvestigacion_idlinea_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: SuperAdministrador
--

ALTER SEQUENCE lineainvestigacion_idlinea_seq OWNED BY lineainvestigacion.idlinea;


--
-- Name: objetivos_proyecto; Type: TABLE; Schema: public; Owner: SuperAdministrador; Tablespace: 
--

CREATE TABLE objetivos_proyecto (
    idobjetivoproyecto integer NOT NULL,
    nombreobjetivo character varying(1000) NOT NULL,
    idproyecto integer NOT NULL
);


ALTER TABLE public.objetivos_proyecto OWNER TO "SuperAdministrador";

--
-- Name: objetivos_proyecto_idobjetivoproyecto_seq; Type: SEQUENCE; Schema: public; Owner: SuperAdministrador
--

CREATE SEQUENCE objetivos_proyecto_idobjetivoproyecto_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.objetivos_proyecto_idobjetivoproyecto_seq OWNER TO "SuperAdministrador";

--
-- Name: objetivos_proyecto_idobjetivoproyecto_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: SuperAdministrador
--

ALTER SEQUENCE objetivos_proyecto_idobjetivoproyecto_seq OWNED BY objetivos_proyecto.idobjetivoproyecto;


--
-- Name: persona; Type: TABLE; Schema: public; Owner: SuperAdministrador; Tablespace: 
--

CREATE TABLE persona (
    documento bigint NOT NULL,
    nombres character varying(100) NOT NULL,
    apellidos character varying(100) NOT NULL,
    telefono bigint NOT NULL,
    correo character varying(200) NOT NULL,
    foto character varying(500),
    usuario character varying(100) NOT NULL,
    contrasena character varying(500) NOT NULL,
    cvlac character varying(100),
    tipodocumento character varying(2) NOT NULL,
    rol integer NOT NULL
);


ALTER TABLE public.persona OWNER TO "SuperAdministrador";

--
-- Name: productos; Type: TABLE; Schema: public; Owner: SuperAdministrador; Tablespace: 
--

CREATE TABLE productos (
    idproducto integer NOT NULL,
    nombreproducto character varying(500) NOT NULL,
    idsemillero integer NOT NULL,
    descripcion character varying,
    tipoproducto integer NOT NULL
);


ALTER TABLE public.productos OWNER TO "SuperAdministrador";

--
-- Name: productos_idproducto_seq; Type: SEQUENCE; Schema: public; Owner: SuperAdministrador
--

CREATE SEQUENCE productos_idproducto_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.productos_idproducto_seq OWNER TO "SuperAdministrador";

--
-- Name: productos_idproducto_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: SuperAdministrador
--

ALTER SEQUENCE productos_idproducto_seq OWNED BY productos.idproducto;


--
-- Name: proyectos; Type: TABLE; Schema: public; Owner: SuperAdministrador; Tablespace: 
--

CREATE TABLE proyectos (
    idproyecto integer NOT NULL,
    nombreproyexto character varying(100) NOT NULL,
    idsemillero integer NOT NULL,
    idlinea integer NOT NULL,
    resumen character varying(500),
    justificacion character varying(10000) NOT NULL,
    introduccion character varying(10000) NOT NULL,
    metodologia character varying(10000) NOT NULL,
    planteamiento character varying(10000) NOT NULL,
    marco_teorico character varying(10000) NOT NULL,
    estado boolean NOT NULL,
    objetivogeneral character varying(1000) NOT NULL
);


ALTER TABLE public.proyectos OWNER TO "SuperAdministrador";

--
-- Name: proyectos_idproyecto_seq; Type: SEQUENCE; Schema: public; Owner: SuperAdministrador
--

CREATE SEQUENCE proyectos_idproyecto_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.proyectos_idproyecto_seq OWNER TO "SuperAdministrador";

--
-- Name: proyectos_idproyecto_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: SuperAdministrador
--

ALTER SEQUENCE proyectos_idproyecto_seq OWNED BY proyectos.idproyecto;


--
-- Name: red; Type: TABLE; Schema: public; Owner: SuperAdministrador; Tablespace: 
--

CREATE TABLE red (
    idred integer NOT NULL,
    nombrered character varying(100) NOT NULL,
    url character varying(100) NOT NULL,
    contexto character varying(1) NOT NULL,
    descripcion character varying(500)
);


ALTER TABLE public.red OWNER TO "SuperAdministrador";

--
-- Name: red_idred_seq; Type: SEQUENCE; Schema: public; Owner: SuperAdministrador
--

CREATE SEQUENCE red_idred_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.red_idred_seq OWNER TO "SuperAdministrador";

--
-- Name: red_idred_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: SuperAdministrador
--

ALTER SEQUENCE red_idred_seq OWNED BY red.idred;


--
-- Name: redareatematica; Type: TABLE; Schema: public; Owner: SuperAdministrador; Tablespace: 
--

CREATE TABLE redareatematica (
    idarea integer NOT NULL,
    idred integer NOT NULL
);


ALTER TABLE public.redareatematica OWNER TO "SuperAdministrador";

--
-- Name: resultado; Type: TABLE; Schema: public; Owner: SuperAdministrador; Tablespace: 
--

CREATE TABLE resultado (
    idresultado integer NOT NULL,
    idred integer NOT NULL,
    descripcion character varying(500) NOT NULL,
    idinforme integer NOT NULL
);


ALTER TABLE public.resultado OWNER TO "SuperAdministrador";

--
-- Name: resultado_idresultado_seq; Type: SEQUENCE; Schema: public; Owner: SuperAdministrador
--

CREATE SEQUENCE resultado_idresultado_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.resultado_idresultado_seq OWNER TO "SuperAdministrador";

--
-- Name: resultado_idresultado_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: SuperAdministrador
--

ALTER SEQUENCE resultado_idresultado_seq OWNED BY resultado.idresultado;


--
-- Name: rol; Type: TABLE; Schema: public; Owner: SuperAdministrador; Tablespace: 
--

CREATE TABLE rol (
    idrol integer NOT NULL,
    nombrerol character varying(200)
);


ALTER TABLE public.rol OWNER TO "SuperAdministrador";

--
-- Name: rol_idrol_seq; Type: SEQUENCE; Schema: public; Owner: SuperAdministrador
--

CREATE SEQUENCE rol_idrol_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.rol_idrol_seq OWNER TO "SuperAdministrador";

--
-- Name: rol_idrol_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: SuperAdministrador
--

ALTER SEQUENCE rol_idrol_seq OWNED BY rol.idrol;


--
-- Name: rolfuncionalidad; Type: TABLE; Schema: public; Owner: SuperAdministrador; Tablespace: 
--

CREATE TABLE rolfuncionalidad (
    idrol integer,
    idfuncionalidad integer
);


ALTER TABLE public.rolfuncionalidad OWNER TO "SuperAdministrador";

--
-- Name: semilleropersona; Type: TABLE; Schema: public; Owner: SuperAdministrador; Tablespace: 
--

CREATE TABLE semilleropersona (
    idsemillero integer NOT NULL,
    documento bigint NOT NULL
);


ALTER TABLE public.semilleropersona OWNER TO "SuperAdministrador";

--
-- Name: semillerored; Type: TABLE; Schema: public; Owner: SuperAdministrador; Tablespace: 
--

CREATE TABLE semillerored (
    idsemillero integer NOT NULL,
    idred integer NOT NULL
);


ALTER TABLE public.semillerored OWNER TO "SuperAdministrador";

--
-- Name: semilleros; Type: TABLE; Schema: public; Owner: SuperAdministrador; Tablespace: 
--

CREATE TABLE semilleros (
    idsemilleros integer NOT NULL,
    nombresemillero character varying(500) NOT NULL,
    idgrupo integer NOT NULL,
    idcategoria integer NOT NULL,
    pathacta character varying(5000),
    fechaacta date,
    mision character varying(1000) NOT NULL,
    vision character varying(1000) NOT NULL,
    estado boolean NOT NULL
);


ALTER TABLE public.semilleros OWNER TO "SuperAdministrador";

--
-- Name: semilleros_idsemilleros_seq; Type: SEQUENCE; Schema: public; Owner: SuperAdministrador
--

CREATE SEQUENCE semilleros_idsemilleros_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.semilleros_idsemilleros_seq OWNER TO "SuperAdministrador";

--
-- Name: semilleros_idsemilleros_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: SuperAdministrador
--

ALTER SEQUENCE semilleros_idsemilleros_seq OWNED BY semilleros.idsemilleros;


--
-- Name: tipoproducto; Type: TABLE; Schema: public; Owner: SuperAdministrador; Tablespace: 
--

CREATE TABLE tipoproducto (
    idtipo integer NOT NULL,
    nombreproducto character varying NOT NULL
);


ALTER TABLE public.tipoproducto OWNER TO "SuperAdministrador";

--
-- Name: tipoproducto_idtipo_seq; Type: SEQUENCE; Schema: public; Owner: SuperAdministrador
--

CREATE SEQUENCE tipoproducto_idtipo_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.tipoproducto_idtipo_seq OWNER TO "SuperAdministrador";

--
-- Name: tipoproducto_idtipo_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: SuperAdministrador
--

ALTER SEQUENCE tipoproducto_idtipo_seq OWNED BY tipoproducto.idtipo;


--
-- Name: idactividad; Type: DEFAULT; Schema: public; Owner: SuperAdministrador
--

ALTER TABLE ONLY actividad ALTER COLUMN idactividad SET DEFAULT nextval('actividad_idactividad_seq'::regclass);


--
-- Name: idarea; Type: DEFAULT; Schema: public; Owner: SuperAdministrador
--

ALTER TABLE ONLY areatematica ALTER COLUMN idarea SET DEFAULT nextval('areatematica_idarea_seq'::regclass);


--
-- Name: idcategoria; Type: DEFAULT; Schema: public; Owner: SuperAdministrador
--

ALTER TABLE ONLY categoria ALTER COLUMN idcategoria SET DEFAULT nextval('categoria_idcategoria_seq'::regclass);


--
-- Name: idcentro; Type: DEFAULT; Schema: public; Owner: SuperAdministrador
--

ALTER TABLE ONLY centroinvestigacion ALTER COLUMN idcentro SET DEFAULT nextval('centroinvestigacion_idcentro_seq'::regclass);


--
-- Name: idcolaborador; Type: DEFAULT; Schema: public; Owner: SuperAdministrador
--

ALTER TABLE ONLY colaborador ALTER COLUMN idcolaborador SET DEFAULT nextval('colaborador_idcolaborador_seq'::regclass);


--
-- Name: idcontacto; Type: DEFAULT; Schema: public; Owner: SuperAdministrador
--

ALTER TABLE ONLY contacto ALTER COLUMN idcontacto SET DEFAULT nextval('contacto_idcontacto_seq'::regclass);


--
-- Name: iddocumento; Type: DEFAULT; Schema: public; Owner: SuperAdministrador
--

ALTER TABLE ONLY documentosemillero ALTER COLUMN iddocumento SET DEFAULT nextval('documentosemillero_iddocumento_seq'::regclass);


--
-- Name: idfuncionalidad; Type: DEFAULT; Schema: public; Owner: SuperAdministrador
--

ALTER TABLE ONLY funcionalidad ALTER COLUMN idfuncionalidad SET DEFAULT nextval('funcionalidad_idfuncionalidad_seq'::regclass);


--
-- Name: nombrefuncionalidad; Type: DEFAULT; Schema: public; Owner: SuperAdministrador
--

ALTER TABLE ONLY funcionalidad ALTER COLUMN nombrefuncionalidad SET DEFAULT nextval('funcionalidad_nombrefuncionalidad_seq'::regclass);


--
-- Name: idgrupo; Type: DEFAULT; Schema: public; Owner: SuperAdministrador
--

ALTER TABLE ONLY grupoinvestigacion ALTER COLUMN idgrupo SET DEFAULT nextval('grupoinvestigacion_idgrupo_seq'::regclass);


--
-- Name: idinforme; Type: DEFAULT; Schema: public; Owner: SuperAdministrador
--

ALTER TABLE ONLY informe ALTER COLUMN idinforme SET DEFAULT nextval('informe_idinforme_seq'::regclass);


--
-- Name: idlinea; Type: DEFAULT; Schema: public; Owner: SuperAdministrador
--

ALTER TABLE ONLY lineainvestigacion ALTER COLUMN idlinea SET DEFAULT nextval('lineainvestigacion_idlinea_seq'::regclass);


--
-- Name: idobjetivoproyecto; Type: DEFAULT; Schema: public; Owner: SuperAdministrador
--

ALTER TABLE ONLY objetivos_proyecto ALTER COLUMN idobjetivoproyecto SET DEFAULT nextval('objetivos_proyecto_idobjetivoproyecto_seq'::regclass);


--
-- Name: idproducto; Type: DEFAULT; Schema: public; Owner: SuperAdministrador
--

ALTER TABLE ONLY productos ALTER COLUMN idproducto SET DEFAULT nextval('productos_idproducto_seq'::regclass);


--
-- Name: idproyecto; Type: DEFAULT; Schema: public; Owner: SuperAdministrador
--

ALTER TABLE ONLY proyectos ALTER COLUMN idproyecto SET DEFAULT nextval('proyectos_idproyecto_seq'::regclass);


--
-- Name: idred; Type: DEFAULT; Schema: public; Owner: SuperAdministrador
--

ALTER TABLE ONLY red ALTER COLUMN idred SET DEFAULT nextval('red_idred_seq'::regclass);


--
-- Name: idresultado; Type: DEFAULT; Schema: public; Owner: SuperAdministrador
--

ALTER TABLE ONLY resultado ALTER COLUMN idresultado SET DEFAULT nextval('resultado_idresultado_seq'::regclass);


--
-- Name: idrol; Type: DEFAULT; Schema: public; Owner: SuperAdministrador
--

ALTER TABLE ONLY rol ALTER COLUMN idrol SET DEFAULT nextval('rol_idrol_seq'::regclass);


--
-- Name: idsemilleros; Type: DEFAULT; Schema: public; Owner: SuperAdministrador
--

ALTER TABLE ONLY semilleros ALTER COLUMN idsemilleros SET DEFAULT nextval('semilleros_idsemilleros_seq'::regclass);


--
-- Name: idtipo; Type: DEFAULT; Schema: public; Owner: SuperAdministrador
--

ALTER TABLE ONLY tipoproducto ALTER COLUMN idtipo SET DEFAULT nextval('tipoproducto_idtipo_seq'::regclass);


--
-- Data for Name: actividad; Type: TABLE DATA; Schema: public; Owner: SuperAdministrador
--



--
-- Name: actividad_idactividad_seq; Type: SEQUENCE SET; Schema: public; Owner: SuperAdministrador
--

SELECT pg_catalog.setval('actividad_idactividad_seq', 1, false);


--
-- Data for Name: areatematica; Type: TABLE DATA; Schema: public; Owner: SuperAdministrador
--

INSERT INTO areatematica VALUES (1, 'area1', 'area1');
INSERT INTO areatematica VALUES (2, 'area2', 'area2');
INSERT INTO areatematica VALUES (3, 'area3', 'area3');
INSERT INTO areatematica VALUES (4, 'area4', 'area4');
INSERT INTO areatematica VALUES (5, 'area5', 'area5');
INSERT INTO areatematica VALUES (6, 'area6', 'area6');
INSERT INTO areatematica VALUES (7, 'area7', 'area7');
INSERT INTO areatematica VALUES (8, 'area8', 'area8');


--
-- Name: areatematica_idarea_seq; Type: SEQUENCE SET; Schema: public; Owner: SuperAdministrador
--

SELECT pg_catalog.setval('areatematica_idarea_seq', 28, true);


--
-- Data for Name: categoria; Type: TABLE DATA; Schema: public; Owner: SuperAdministrador
--

INSERT INTO categoria VALUES (1, 'categoria 1', 'categoria 1');
INSERT INTO categoria VALUES (2, 'categoria 2', 'categoria 2');


--
-- Name: categoria_idcategoria_seq; Type: SEQUENCE SET; Schema: public; Owner: SuperAdministrador
--

SELECT pg_catalog.setval('categoria_idcategoria_seq', 2, true);


--
-- Data for Name: centroinvestigacion; Type: TABLE DATA; Schema: public; Owner: SuperAdministrador
--

INSERT INTO centroinvestigacion VALUES (1, 'CIIAM', ' Centro de Investigaciones de Ingeniería Alberto Magno');
INSERT INTO centroinvestigacion VALUES (2, 'CIFA', 'Centro de Investigaciones Facultad de Arquitectura');
INSERT INTO centroinvestigacion VALUES (20, 'PRUEBA', 'prueba');
INSERT INTO centroinvestigacion VALUES (21, 'PRUEBA', 'prueba');
INSERT INTO centroinvestigacion VALUES (23, 'h', 't');
INSERT INTO centroinvestigacion VALUES (24, 'hgh', 'hghg');


--
-- Name: centroinvestigacion_idcentro_seq; Type: SEQUENCE SET; Schema: public; Owner: SuperAdministrador
--

SELECT pg_catalog.setval('centroinvestigacion_idcentro_seq', 26, true);


--
-- Data for Name: colaborador; Type: TABLE DATA; Schema: public; Owner: SuperAdministrador
--



--
-- Name: colaborador_idcolaborador_seq; Type: SEQUENCE SET; Schema: public; Owner: SuperAdministrador
--

SELECT pg_catalog.setval('colaborador_idcolaborador_seq', 1, false);


--
-- Data for Name: contacto; Type: TABLE DATA; Schema: public; Owner: SuperAdministrador
--

INSERT INTO contacto VALUES ('con2@con2.com', 234987654, 'con2retret', 'con2@con2.com', 1, 2);
INSERT INTO contacto VALUES ('conredx', 123123, 'dir red x', 'redx@mail.com', 5, 9);


--
-- Name: contacto_idcontacto_seq; Type: SEQUENCE SET; Schema: public; Owner: SuperAdministrador
--

SELECT pg_catalog.setval('contacto_idcontacto_seq', 9, true);


--
-- Data for Name: documentosemillero; Type: TABLE DATA; Schema: public; Owner: SuperAdministrador
--



--
-- Name: documentosemillero_iddocumento_seq; Type: SEQUENCE SET; Schema: public; Owner: SuperAdministrador
--

SELECT pg_catalog.setval('documentosemillero_iddocumento_seq', 1, false);


--
-- Data for Name: funcionalidad; Type: TABLE DATA; Schema: public; Owner: SuperAdministrador
--



--
-- Name: funcionalidad_idfuncionalidad_seq; Type: SEQUENCE SET; Schema: public; Owner: SuperAdministrador
--

SELECT pg_catalog.setval('funcionalidad_idfuncionalidad_seq', 1, false);


--
-- Name: funcionalidad_nombrefuncionalidad_seq; Type: SEQUENCE SET; Schema: public; Owner: SuperAdministrador
--

SELECT pg_catalog.setval('funcionalidad_nombrefuncionalidad_seq', 1, false);


--
-- Data for Name: grupoinvestigacion; Type: TABLE DATA; Schema: public; Owner: SuperAdministrador
--

INSERT INTO grupoinvestigacion VALUES (1, 'GIDINT', 'Grupo de Investigación y Desarrollo de Ingeniería en Nuevas Tecnologías', 1);
INSERT INTO grupoinvestigacion VALUES (2, 'ACIB', 'Ambiental, Civil y Ciencias Básicas en Investigación', 1);
INSERT INTO grupoinvestigacion VALUES (4, 'PRUEBAGRUPO', 'pruebagrupo', 20);
INSERT INTO grupoinvestigacion VALUES (5, 'OTRO', 'otro', 21);
INSERT INTO grupoinvestigacion VALUES (9, 'otra prueba', 'otra prueba', 20);
INSERT INTO grupoinvestigacion VALUES (13, 'cvb', 'cvb', 20);


--
-- Name: grupoinvestigacion_idgrupo_seq; Type: SEQUENCE SET; Schema: public; Owner: SuperAdministrador
--

SELECT pg_catalog.setval('grupoinvestigacion_idgrupo_seq', 13, true);


--
-- Data for Name: informe; Type: TABLE DATA; Schema: public; Owner: SuperAdministrador
--



--
-- Name: informe_idinforme_seq; Type: SEQUENCE SET; Schema: public; Owner: SuperAdministrador
--

SELECT pg_catalog.setval('informe_idinforme_seq', 1, false);


--
-- Data for Name: lineainvestigacion; Type: TABLE DATA; Schema: public; Owner: SuperAdministrador
--

INSERT INTO lineainvestigacion VALUES (3, 'jghjgh', 'ghjghjgh', 4);
INSERT INTO lineainvestigacion VALUES (6, 'linea', 'linea', 2);
INSERT INTO lineainvestigacion VALUES (7, 'lineaere', 'linearere', 2);
INSERT INTO lineainvestigacion VALUES (8, 'lineaerewrew', 'linearereewrwe', 2);
INSERT INTO lineainvestigacion VALUES (2, 'Instrumentación y control', 'instrumentación y control', 1);


--
-- Name: lineainvestigacion_idlinea_seq; Type: SEQUENCE SET; Schema: public; Owner: SuperAdministrador
--

SELECT pg_catalog.setval('lineainvestigacion_idlinea_seq', 8, true);


--
-- Data for Name: objetivos_proyecto; Type: TABLE DATA; Schema: public; Owner: SuperAdministrador
--

INSERT INTO objetivos_proyecto VALUES (1, 'obj esp1 pro1', 1);
INSERT INTO objetivos_proyecto VALUES (2, 'obj esp2 pro1', 1);
INSERT INTO objetivos_proyecto VALUES (3, 'obj esp3 pro1', 1);
INSERT INTO objetivos_proyecto VALUES (4, 'dsf sdfwerwer', 2);
INSERT INTO objetivos_proyecto VALUES (5, 'dsf sdf ', 2);
INSERT INTO objetivos_proyecto VALUES (6, 'sdfdsf', 3);
INSERT INTO objetivos_proyecto VALUES (7, 'jhgjhg', 3);


--
-- Name: objetivos_proyecto_idobjetivoproyecto_seq; Type: SEQUENCE SET; Schema: public; Owner: SuperAdministrador
--

SELECT pg_catalog.setval('objetivos_proyecto_idobjetivoproyecto_seq', 7, true);


--
-- Data for Name: persona; Type: TABLE DATA; Schema: public; Owner: SuperAdministrador
--



--
-- Data for Name: productos; Type: TABLE DATA; Schema: public; Owner: SuperAdministrador
--

INSERT INTO productos VALUES (1, 'dsf', 1, 'sdf', 2);
INSERT INTO productos VALUES (2, 'sdf', 1, 'sdfd', 3);
INSERT INTO productos VALUES (3, 'sfd', 1, 'sdf', 6);
INSERT INTO productos VALUES (4, 'f sdf dsf sd fsdf ', 1, 'sdfsdf sdf sd', 2);
INSERT INTO productos VALUES (5, 'dsf', 1, 'sdf', 7);


--
-- Name: productos_idproducto_seq; Type: SEQUENCE SET; Schema: public; Owner: SuperAdministrador
--

SELECT pg_catalog.setval('productos_idproducto_seq', 5, true);


--
-- Data for Name: proyectos; Type: TABLE DATA; Schema: public; Owner: SuperAdministrador
--

INSERT INTO proyectos VALUES (1, 'pro1', 1, 6, NULL, 'intro pro1', 'intro pro1', '<span style="font-family: Arial, sans-serif; font-weight: bold; background-color: rgb(255, 255, 255);">Metodologia pro| df dsf sd fdsf dsf&nbsp;</span>', 'planteamiento pro1', 'sd sf sdf sdf sdfsdf sdf sdf dsf sd', false, 'obj pro1');
INSERT INTO proyectos VALUES (2, 'ds f', 1, 8, NULL, ' fsd fsd', 'ds fds sd', 'dsfsdf dsf&nbsp;', 'sdf sdf dsf', 'sdf sdf dsf&nbsp;', false, 'sdfsdf ');
INSERT INTO proyectos VALUES (3, 'sdfsdf', 1, 8, NULL, 'sdfsdf', 'sdfsdf', 'sdfs df dsf dsf dsf dsf dsf dsf&nbsp;', 'sdfdsf', 'fd f dsf sdf sdf dsf sdf sdf dsf dsf d&nbsp;', false, 'sdfdsf');


--
-- Name: proyectos_idproyecto_seq; Type: SEQUENCE SET; Schema: public; Owner: SuperAdministrador
--

SELECT pg_catalog.setval('proyectos_idproyecto_seq', 3, true);


--
-- Data for Name: red; Type: TABLE DATA; Schema: public; Owner: SuperAdministrador
--

INSERT INTO red VALUES (1, 'red1', 'www.red1.com', 'N', 'red1');
INSERT INTO red VALUES (2, 'red2', 'red2.com', 'I', 'red2');
INSERT INTO red VALUES (3, 'red3', 'red3.com', 'A', 'red3');
INSERT INTO red VALUES (4, 'pr', 'www.google.com', 'A', 'sdfds');
INSERT INTO red VALUES (5, 'redx', 'redx.com', 'I', 'red x');


--
-- Name: red_idred_seq; Type: SEQUENCE SET; Schema: public; Owner: SuperAdministrador
--

SELECT pg_catalog.setval('red_idred_seq', 5, true);


--
-- Data for Name: redareatematica; Type: TABLE DATA; Schema: public; Owner: SuperAdministrador
--

INSERT INTO redareatematica VALUES (1, 1);
INSERT INTO redareatematica VALUES (5, 1);
INSERT INTO redareatematica VALUES (8, 1);
INSERT INTO redareatematica VALUES (3, 2);
INSERT INTO redareatematica VALUES (5, 2);
INSERT INTO redareatematica VALUES (6, 2);
INSERT INTO redareatematica VALUES (2, 3);
INSERT INTO redareatematica VALUES (6, 3);
INSERT INTO redareatematica VALUES (8, 3);
INSERT INTO redareatematica VALUES (3, 4);
INSERT INTO redareatematica VALUES (5, 4);
INSERT INTO redareatematica VALUES (6, 4);
INSERT INTO redareatematica VALUES (8, 4);
INSERT INTO redareatematica VALUES (2, 5);
INSERT INTO redareatematica VALUES (5, 5);
INSERT INTO redareatematica VALUES (7, 5);


--
-- Data for Name: resultado; Type: TABLE DATA; Schema: public; Owner: SuperAdministrador
--



--
-- Name: resultado_idresultado_seq; Type: SEQUENCE SET; Schema: public; Owner: SuperAdministrador
--

SELECT pg_catalog.setval('resultado_idresultado_seq', 1, false);


--
-- Data for Name: rol; Type: TABLE DATA; Schema: public; Owner: SuperAdministrador
--



--
-- Name: rol_idrol_seq; Type: SEQUENCE SET; Schema: public; Owner: SuperAdministrador
--

SELECT pg_catalog.setval('rol_idrol_seq', 1, false);


--
-- Data for Name: rolfuncionalidad; Type: TABLE DATA; Schema: public; Owner: SuperAdministrador
--



--
-- Data for Name: semilleropersona; Type: TABLE DATA; Schema: public; Owner: SuperAdministrador
--



--
-- Data for Name: semillerored; Type: TABLE DATA; Schema: public; Owner: SuperAdministrador
--

INSERT INTO semillerored VALUES (1, 1);


--
-- Data for Name: semilleros; Type: TABLE DATA; Schema: public; Owner: SuperAdministrador
--

INSERT INTO semilleros VALUES (1, 'sem1', 2, 1, '/acta_1_sem1.pdf', '2014-08-01', 'mision sem1', 'vision sem1', false);


--
-- Name: semilleros_idsemilleros_seq; Type: SEQUENCE SET; Schema: public; Owner: SuperAdministrador
--

SELECT pg_catalog.setval('semilleros_idsemilleros_seq', 1, true);


--
-- Data for Name: tipoproducto; Type: TABLE DATA; Schema: public; Owner: SuperAdministrador
--

INSERT INTO tipoproducto VALUES (1, 'Diseño industrial');
INSERT INTO tipoproducto VALUES (2, 'Software');
INSERT INTO tipoproducto VALUES (3, 'Consultoria');
INSERT INTO tipoproducto VALUES (4, 'Evento cientifico');
INSERT INTO tipoproducto VALUES (5, 'Contenido multimedia');
INSERT INTO tipoproducto VALUES (6, 'Informe investigacion');
INSERT INTO tipoproducto VALUES (7, 'Tesis');
INSERT INTO tipoproducto VALUES (8, 'Libros');
INSERT INTO tipoproducto VALUES (9, 'Articulos');


--
-- Name: tipoproducto_idtipo_seq; Type: SEQUENCE SET; Schema: public; Owner: SuperAdministrador
--

SELECT pg_catalog.setval('tipoproducto_idtipo_seq', 1, false);


--
-- Name: actividad_pkey; Type: CONSTRAINT; Schema: public; Owner: SuperAdministrador; Tablespace: 
--

ALTER TABLE ONLY actividad
    ADD CONSTRAINT actividad_pkey PRIMARY KEY (idactividad);


--
-- Name: areatematica_pkey; Type: CONSTRAINT; Schema: public; Owner: SuperAdministrador; Tablespace: 
--

ALTER TABLE ONLY areatematica
    ADD CONSTRAINT areatematica_pkey PRIMARY KEY (idarea);


--
-- Name: categoria_pkey; Type: CONSTRAINT; Schema: public; Owner: SuperAdministrador; Tablespace: 
--

ALTER TABLE ONLY categoria
    ADD CONSTRAINT categoria_pkey PRIMARY KEY (idcategoria);


--
-- Name: centroinvestigacion_pkey; Type: CONSTRAINT; Schema: public; Owner: SuperAdministrador; Tablespace: 
--

ALTER TABLE ONLY centroinvestigacion
    ADD CONSTRAINT centroinvestigacion_pkey PRIMARY KEY (idcentro);


--
-- Name: colaborador_pkey; Type: CONSTRAINT; Schema: public; Owner: SuperAdministrador; Tablespace: 
--

ALTER TABLE ONLY colaborador
    ADD CONSTRAINT colaborador_pkey PRIMARY KEY (idcolaborador);


--
-- Name: contacto_pkey; Type: CONSTRAINT; Schema: public; Owner: SuperAdministrador; Tablespace: 
--

ALTER TABLE ONLY contacto
    ADD CONSTRAINT contacto_pkey PRIMARY KEY (idcontacto);


--
-- Name: documentosemillero_pkey; Type: CONSTRAINT; Schema: public; Owner: SuperAdministrador; Tablespace: 
--

ALTER TABLE ONLY documentosemillero
    ADD CONSTRAINT documentosemillero_pkey PRIMARY KEY (iddocumento);


--
-- Name: funcionalidad_pkey; Type: CONSTRAINT; Schema: public; Owner: SuperAdministrador; Tablespace: 
--

ALTER TABLE ONLY funcionalidad
    ADD CONSTRAINT funcionalidad_pkey PRIMARY KEY (idfuncionalidad);


--
-- Name: grupoinvestigacion_pkey; Type: CONSTRAINT; Schema: public; Owner: SuperAdministrador; Tablespace: 
--

ALTER TABLE ONLY grupoinvestigacion
    ADD CONSTRAINT grupoinvestigacion_pkey PRIMARY KEY (idgrupo);


--
-- Name: informe_pkey; Type: CONSTRAINT; Schema: public; Owner: SuperAdministrador; Tablespace: 
--

ALTER TABLE ONLY informe
    ADD CONSTRAINT informe_pkey PRIMARY KEY (idinforme);


--
-- Name: lineainvestigacion_pkey; Type: CONSTRAINT; Schema: public; Owner: SuperAdministrador; Tablespace: 
--

ALTER TABLE ONLY lineainvestigacion
    ADD CONSTRAINT lineainvestigacion_pkey PRIMARY KEY (idlinea);


--
-- Name: objetivos_proyecto_pkey; Type: CONSTRAINT; Schema: public; Owner: SuperAdministrador; Tablespace: 
--

ALTER TABLE ONLY objetivos_proyecto
    ADD CONSTRAINT objetivos_proyecto_pkey PRIMARY KEY (idobjetivoproyecto);


--
-- Name: persona_correo_key; Type: CONSTRAINT; Schema: public; Owner: SuperAdministrador; Tablespace: 
--

ALTER TABLE ONLY persona
    ADD CONSTRAINT persona_correo_key UNIQUE (correo);


--
-- Name: persona_pkey; Type: CONSTRAINT; Schema: public; Owner: SuperAdministrador; Tablespace: 
--

ALTER TABLE ONLY persona
    ADD CONSTRAINT persona_pkey PRIMARY KEY (documento);


--
-- Name: productos_pkey; Type: CONSTRAINT; Schema: public; Owner: SuperAdministrador; Tablespace: 
--

ALTER TABLE ONLY productos
    ADD CONSTRAINT productos_pkey PRIMARY KEY (idproducto);


--
-- Name: proyectos_pkey; Type: CONSTRAINT; Schema: public; Owner: SuperAdministrador; Tablespace: 
--

ALTER TABLE ONLY proyectos
    ADD CONSTRAINT proyectos_pkey PRIMARY KEY (idproyecto);


--
-- Name: red_pkey; Type: CONSTRAINT; Schema: public; Owner: SuperAdministrador; Tablespace: 
--

ALTER TABLE ONLY red
    ADD CONSTRAINT red_pkey PRIMARY KEY (idred);


--
-- Name: resultado_pkey; Type: CONSTRAINT; Schema: public; Owner: SuperAdministrador; Tablespace: 
--

ALTER TABLE ONLY resultado
    ADD CONSTRAINT resultado_pkey PRIMARY KEY (idresultado);


--
-- Name: rol_pkey; Type: CONSTRAINT; Schema: public; Owner: SuperAdministrador; Tablespace: 
--

ALTER TABLE ONLY rol
    ADD CONSTRAINT rol_pkey PRIMARY KEY (idrol);


--
-- Name: semilleros_pkey; Type: CONSTRAINT; Schema: public; Owner: SuperAdministrador; Tablespace: 
--

ALTER TABLE ONLY semilleros
    ADD CONSTRAINT semilleros_pkey PRIMARY KEY (idsemilleros);


--
-- Name: tipoproducto_nombreproducto_key; Type: CONSTRAINT; Schema: public; Owner: SuperAdministrador; Tablespace: 
--

ALTER TABLE ONLY tipoproducto
    ADD CONSTRAINT tipoproducto_nombreproducto_key UNIQUE (nombreproducto);


--
-- Name: tipoproducto_pkey; Type: CONSTRAINT; Schema: public; Owner: SuperAdministrador; Tablespace: 
--

ALTER TABLE ONLY tipoproducto
    ADD CONSTRAINT tipoproducto_pkey PRIMARY KEY (idtipo);


--
-- Name: uk_usuario; Type: CONSTRAINT; Schema: public; Owner: SuperAdministrador; Tablespace: 
--

ALTER TABLE ONLY persona
    ADD CONSTRAINT uk_usuario UNIQUE (usuario);


--
-- Name: actividad_idinforme_fkey; Type: FK CONSTRAINT; Schema: public; Owner: SuperAdministrador
--

ALTER TABLE ONLY actividad
    ADD CONSTRAINT actividad_idinforme_fkey FOREIGN KEY (idinforme) REFERENCES informe(idinforme);


--
-- Name: colaborador_idinforme_fkey; Type: FK CONSTRAINT; Schema: public; Owner: SuperAdministrador
--

ALTER TABLE ONLY colaborador
    ADD CONSTRAINT colaborador_idinforme_fkey FOREIGN KEY (idinforme) REFERENCES informe(idinforme);


--
-- Name: contacto_idred_fkey; Type: FK CONSTRAINT; Schema: public; Owner: SuperAdministrador
--

ALTER TABLE ONLY contacto
    ADD CONSTRAINT contacto_idred_fkey FOREIGN KEY (idred) REFERENCES red(idred);


--
-- Name: documentosemillero_idsemillero_fkey; Type: FK CONSTRAINT; Schema: public; Owner: SuperAdministrador
--

ALTER TABLE ONLY documentosemillero
    ADD CONSTRAINT documentosemillero_idsemillero_fkey FOREIGN KEY (idsemillero) REFERENCES semilleros(idsemilleros);


--
-- Name: grupoinvestigacion_idcentro_fkey; Type: FK CONSTRAINT; Schema: public; Owner: SuperAdministrador
--

ALTER TABLE ONLY grupoinvestigacion
    ADD CONSTRAINT grupoinvestigacion_idcentro_fkey FOREIGN KEY (idcentro) REFERENCES centroinvestigacion(idcentro);


--
-- Name: informe_idsemillero_fkey; Type: FK CONSTRAINT; Schema: public; Owner: SuperAdministrador
--

ALTER TABLE ONLY informe
    ADD CONSTRAINT informe_idsemillero_fkey FOREIGN KEY (idsemillero) REFERENCES semilleros(idsemilleros);


--
-- Name: lineainvestigacion_idgrupo_fkey; Type: FK CONSTRAINT; Schema: public; Owner: SuperAdministrador
--

ALTER TABLE ONLY lineainvestigacion
    ADD CONSTRAINT lineainvestigacion_idgrupo_fkey FOREIGN KEY (idgrupo) REFERENCES grupoinvestigacion(idgrupo);


--
-- Name: objetivos_proyecto_idproyecto_fkey; Type: FK CONSTRAINT; Schema: public; Owner: SuperAdministrador
--

ALTER TABLE ONLY objetivos_proyecto
    ADD CONSTRAINT objetivos_proyecto_idproyecto_fkey FOREIGN KEY (idproyecto) REFERENCES proyectos(idproyecto);


--
-- Name: persona_rol_fkey; Type: FK CONSTRAINT; Schema: public; Owner: SuperAdministrador
--

ALTER TABLE ONLY persona
    ADD CONSTRAINT persona_rol_fkey FOREIGN KEY (rol) REFERENCES rol(idrol);


--
-- Name: productos_idsemillero_fkey; Type: FK CONSTRAINT; Schema: public; Owner: SuperAdministrador
--

ALTER TABLE ONLY productos
    ADD CONSTRAINT productos_idsemillero_fkey FOREIGN KEY (idsemillero) REFERENCES semilleros(idsemilleros);


--
-- Name: productos_tipoproducto_fkey; Type: FK CONSTRAINT; Schema: public; Owner: SuperAdministrador
--

ALTER TABLE ONLY productos
    ADD CONSTRAINT productos_tipoproducto_fkey FOREIGN KEY (tipoproducto) REFERENCES tipoproducto(idtipo);


--
-- Name: proyectos_idlinea_fkey; Type: FK CONSTRAINT; Schema: public; Owner: SuperAdministrador
--

ALTER TABLE ONLY proyectos
    ADD CONSTRAINT proyectos_idlinea_fkey FOREIGN KEY (idlinea) REFERENCES lineainvestigacion(idlinea);


--
-- Name: proyectos_idsemillero_fkey; Type: FK CONSTRAINT; Schema: public; Owner: SuperAdministrador
--

ALTER TABLE ONLY proyectos
    ADD CONSTRAINT proyectos_idsemillero_fkey FOREIGN KEY (idsemillero) REFERENCES semilleros(idsemilleros);


--
-- Name: redareatematica_idarea_fkey; Type: FK CONSTRAINT; Schema: public; Owner: SuperAdministrador
--

ALTER TABLE ONLY redareatematica
    ADD CONSTRAINT redareatematica_idarea_fkey FOREIGN KEY (idarea) REFERENCES areatematica(idarea);


--
-- Name: redareatematica_idred_fkey; Type: FK CONSTRAINT; Schema: public; Owner: SuperAdministrador
--

ALTER TABLE ONLY redareatematica
    ADD CONSTRAINT redareatematica_idred_fkey FOREIGN KEY (idred) REFERENCES red(idred);


--
-- Name: resultado_idinforme_fkey; Type: FK CONSTRAINT; Schema: public; Owner: SuperAdministrador
--

ALTER TABLE ONLY resultado
    ADD CONSTRAINT resultado_idinforme_fkey FOREIGN KEY (idinforme) REFERENCES informe(idinforme);


--
-- Name: resultado_idred_fkey; Type: FK CONSTRAINT; Schema: public; Owner: SuperAdministrador
--

ALTER TABLE ONLY resultado
    ADD CONSTRAINT resultado_idred_fkey FOREIGN KEY (idred) REFERENCES red(idred);


--
-- Name: rolfuncionalidad_idfuncionalidad_fkey; Type: FK CONSTRAINT; Schema: public; Owner: SuperAdministrador
--

ALTER TABLE ONLY rolfuncionalidad
    ADD CONSTRAINT rolfuncionalidad_idfuncionalidad_fkey FOREIGN KEY (idfuncionalidad) REFERENCES funcionalidad(idfuncionalidad);


--
-- Name: rolfuncionalidad_idrol_fkey; Type: FK CONSTRAINT; Schema: public; Owner: SuperAdministrador
--

ALTER TABLE ONLY rolfuncionalidad
    ADD CONSTRAINT rolfuncionalidad_idrol_fkey FOREIGN KEY (idrol) REFERENCES rol(idrol);


--
-- Name: semilleropersona_documento_fkey; Type: FK CONSTRAINT; Schema: public; Owner: SuperAdministrador
--

ALTER TABLE ONLY semilleropersona
    ADD CONSTRAINT semilleropersona_documento_fkey FOREIGN KEY (documento) REFERENCES persona(documento);


--
-- Name: semilleropersona_idsemillero_fkey; Type: FK CONSTRAINT; Schema: public; Owner: SuperAdministrador
--

ALTER TABLE ONLY semilleropersona
    ADD CONSTRAINT semilleropersona_idsemillero_fkey FOREIGN KEY (idsemillero) REFERENCES semilleros(idsemilleros);


--
-- Name: semillerored_idred_fkey; Type: FK CONSTRAINT; Schema: public; Owner: SuperAdministrador
--

ALTER TABLE ONLY semillerored
    ADD CONSTRAINT semillerored_idred_fkey FOREIGN KEY (idred) REFERENCES red(idred);


--
-- Name: semillerored_idsemillero_fkey; Type: FK CONSTRAINT; Schema: public; Owner: SuperAdministrador
--

ALTER TABLE ONLY semillerored
    ADD CONSTRAINT semillerored_idsemillero_fkey FOREIGN KEY (idsemillero) REFERENCES semilleros(idsemilleros);


--
-- Name: semilleros_idcategoria_fkey; Type: FK CONSTRAINT; Schema: public; Owner: SuperAdministrador
--

ALTER TABLE ONLY semilleros
    ADD CONSTRAINT semilleros_idcategoria_fkey FOREIGN KEY (idcategoria) REFERENCES categoria(idcategoria);


--
-- Name: semilleros_idgrupo_fkey; Type: FK CONSTRAINT; Schema: public; Owner: SuperAdministrador
--

ALTER TABLE ONLY semilleros
    ADD CONSTRAINT semilleros_idgrupo_fkey FOREIGN KEY (idgrupo) REFERENCES grupoinvestigacion(idgrupo);


--
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


--
-- PostgreSQL database dump complete
--
