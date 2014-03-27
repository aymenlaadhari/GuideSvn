-- Database: postgres

-- DROP DATABASE postgres;

CREATE DATABASE postgres
  WITH OWNER = postgres
       ENCODING = 'UTF8'
       TABLESPACE = pg_default
       LC_COLLATE = 'French_France.1252'
       LC_CTYPE = 'French_France.1252'
       CONNECTION LIMIT = -1;

COMMENT ON DATABASE postgres
  IS 'default administrative connection database';
-- Table: centre_commercial

-- DROP TABLE centre_commercial;

CREATE TABLE centre_commercial
(
  telephone character varying(25),
  email character varying(25),
  id integer NOT NULL,
  siteweb character varying(25),
  longitude bigint,
  latitude bigint,
  CONSTRAINT ck_id PRIMARY KEY (id)
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
  telephone character varying(25),
  email character varying(25),
  id integer NOT NULL,
  siteweb character varying(25),
  longitude bigint,
  latitude bigint,
  CONSTRAINT ckm_id PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE centre_medicale
  OWNER TO postgres;

  -- Table: garde

-- DROP TABLE garde;

CREATE TABLE garde
(
  debut date,
  fin date,
  id integer NOT NULL,
  CONSTRAINT "ckG_prime" PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE garde
  OWNER TO postgres;

  -- Table: image

-- DROP TABLE image;

CREATE TABLE image
(
  nom character varying(25),
  description character varying(25),
  data bytea,
  id integer NOT NULL,
  CONSTRAINT "ckI_prim" PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE image
  OWNER TO postgres;
  
  -- Table: pay

-- DROP TABLE pay;

CREATE TABLE pay
(
  id integer NOT NULL,
  nom character varying,
  CONSTRAINT ck_pay PRIMARY KEY (id)
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
  telephone character varying(25),
  email character varying(25),
  id integer NOT NULL,
  siteweb character varying(25),
  longitude bigint,
  latitude bigint,
  type character varying(25),
  CONSTRAINT ckp_id PRIMARY KEY (id)
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
  telephone character varying(25),
  email character varying(25),
  id integer NOT NULL,
  siteweb character varying(25),
  longitude bigint,
  latitude bigint,
  CONSTRAINT ckr_id PRIMARY KEY (id)
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
  nom character varying(25),
  description character varying(25),
  id integer NOT NULL,
  CONSTRAINT "ckS_prime" PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE specialite
  OWNER TO postgres;
  
  
  -- Table: ville

-- DROP TABLE ville;

CREATE TABLE ville
(
  id integer NOT NULL,
  gouvernorat character varying(25),
  nom character varying(25),
  rue character varying(25),
  CONSTRAINT "ckV_prim" PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE ville
  OWNER TO postgres;



