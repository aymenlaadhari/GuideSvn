-- Database: "baseGuide"

-- DROP DATABASE "baseGuide";

CREATE DATABASE "baseGuide"
  WITH OWNER = postgres
       ENCODING = 'UTF8'
       TABLESPACE = pg_default
       LC_COLLATE = 'French_France.1252'
       LC_CTYPE = 'French_France.1252'
       CONNECTION LIMIT = -1;
-- Table: centre_commercial

-- DROP TABLE centre_commercial;

CREATE TABLE centre_commercial
(
  id integer NOT NULL,
  telephone character varying(25),
  email character varying(25),
  nom character varying(25),
  description character varying(25),
  siteweb character varying(25),
  longitude bigint,
  latitude bigint,
  categorie character varying(258),
  CONSTRAINT centre_commercial_pkey PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE centre_commercial
  OWNER TO postgres;
-- Table: centre_medicale

-- DROP TABLE centre_medicale;

CREATE TABLE centre_medicale
(
  id integer NOT NULL,
  telephone character varying(25),
  email character varying(25),
  siteweb character varying(25),
  longitude bigint,
  latitude bigint,
  nom character varying(258),
  description character varying(258),
  categorie character varying(258),
  type character varying(258),
  CONSTRAINT centre_medicale_pkey PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE centre_medicale
  OWNER TO postgres;
-- Table: evenement

-- DROP TABLE evenement;

CREATE TABLE evenement
(
  id_event integer NOT NULL,
  type character varying(254),
  inscription character varying(254),
  prix integer,
  date date,
  CONSTRAINT evenement_pkey PRIMARY KEY (id_event)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE evenement
  OWNER TO postgres;
-- Table: garde

-- DROP TABLE garde;

CREATE TABLE garde
(
  id integer NOT NULL,
  debut date,
  fin date,
  CONSTRAINT garde_pkey PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE garde
  OWNER TO postgres;
-- Table: hotel

-- DROP TABLE hotel;

CREATE TABLE hotel
(
  id_hotel integer NOT NULL,
  nom_h character varying(254),
  categorie_h character varying(254),
  siteweb_h character varying(254),
  longitude double precision,
  latitude double precision,
  description character varying(254),
  nbreetoile integer NOT NULL,
  telephone_h character varying(254),
  email_h character varying(254),
  CONSTRAINT hotel_pkey PRIMARY KEY (id_hotel)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE hotel
  OWNER TO postgres;
-- Table: image

-- DROP TABLE image;

CREATE TABLE image
(
  id integer NOT NULL,
  nom character varying(25),
  description character varying(25),
  data bytea,
  CONSTRAINT image_pkey PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE image
  OWNER TO postgres;
-- Table: monument

-- DROP TABLE monument;

CREATE TABLE monument
(
  id_monument integer NOT NULL,
  nom_m character varying(254),
  categorie_m character varying(254),
  siteweb_m character varying(254),
  longitude double precision,
  latitude double precision,
  description character varying(254),
  type character varying(254),
  dateconstruction date,
  finconstruction date,
  historique character varying(258),
  CONSTRAINT monument_pkey PRIMARY KEY (id_monument)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE monument
  OWNER TO postgres;
-- Table: pay

-- DROP TABLE pay;

CREATE TABLE pay
(
  id integer NOT NULL,
  nom character varying(255),
  CONSTRAINT pay_pkey PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE pay
  OWNER TO postgres;
-- Table: pharmacie

-- DROP TABLE pharmacie;

CREATE TABLE pharmacie
(
  id integer NOT NULL,
  telephone character varying(25),
  email character varying(25),
  siteweb character varying(25),
  longitude bigint,
  latitude bigint,
  type character varying(25),
  nom character varying(258),
  description character varying(258),
  CONSTRAINT pharmacie_pkey PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE pharmacie
  OWNER TO postgres;
-- Table: restaurant

-- DROP TABLE restaurant;

CREATE TABLE restaurant
(
  id integer NOT NULL,
  telephone character varying(25),
  email character varying(25),
  siteweb character varying(25),
  longitude bigint,
  latitude bigint,
  nom character varying(258),
  description character varying(258),
  categorie character varying(258),
  horairehouverture date,
  horairefermeture date,
  CONSTRAINT restaurant_pkey PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE restaurant
  OWNER TO postgres;
-- Table: specialite

-- DROP TABLE specialite;

CREATE TABLE specialite
(
  id integer NOT NULL,
  nom character varying(25),
  description character varying(25),
  CONSTRAINT specialite_pkey PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE specialite
  OWNER TO postgres;
-- Table: utilisateur

-- DROP TABLE utilisateur;

CREATE TABLE utilisateur
(
  id integer NOT NULL,
  nom character varying(25),
  prenom character varying(25),
  adresse character varying(25),
  email character varying(25),
  password character varying(25),
  login character varying(258),
  telephone character varying(258),
  CONSTRAINT utilisateur_pkey PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE utilisateur
  OWNER TO postgres;
-- Table: ville

-- DROP TABLE ville;

CREATE TABLE ville
(
  id integer NOT NULL,
  gouvernorat character varying(25),
  nom character varying(25),
  rue character varying(25),
  CONSTRAINT ville_pkey PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE ville
  OWNER TO postgres;
