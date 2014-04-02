
    drop table public.centre_commercial cascade;

    drop table public.centre_medicale cascade;

    drop table public.evenement cascade;

    drop table public.garde cascade;

    drop table public.hotel cascade;

    drop table public.image cascade;

    drop table public.monument cascade;

    drop table public.pay cascade;

    drop table public.pharmacie cascade;

    drop table public.restaurant cascade;

    drop table public.specialite cascade;

    drop table public.utilisateur cascade;

    drop table public.ville cascade;

    create table public.centre_commercial (
        id int4 not null,
        telephone varchar(25),
        email varchar(25),
        siteweb varchar(25),
        longitude int8,
        latitude int8,
        primary key (id)
    );

    create table public.centre_medicale (
        id int4 not null,
        telephone varchar(25),
        email varchar(25),
        siteweb varchar(25),
        longitude int8,
        latitude int8,
        primary key (id)
    );

    create table public.evenement (
        id_event int4 not null,
        type varchar(254),
        inscription varchar(254),
        prix int4,
        date date,
        primary key (id_event)
    );

    create table public.garde (
        id int4 not null,
        debut date,
        fin date,
        primary key (id)
    );

    create table public.hotel (
        id_hotel int4 not null,
        nom_h varchar(254),
        categorie_h varchar(254),
        siteweb_h varchar(254),
        longitude float8,
        latitude float8,
        description varchar(254),
        nbreetoile int4 not null,
        telephone_h varchar(254),
        email_h varchar(254),
        primary key (id_hotel)
    );

    create table public.image (
        id int4 not null,
        nom varchar(25),
        description varchar(25),
        data bytea,
        primary key (id)
    );

    create table public.monument (
        id_monument int4 not null,
        nom_m varchar(254),
        categorie_m varchar(254),
        siteweb_m varchar(254),
        longitude float8,
        latitude float8,
        description varchar(254),
        type varchar(254),
        dateconstruction date,
        finconstruction date,
        primary key (id_monument)
    );

    create table public.pay (
        id int4 not null,
        nom varchar(255),
        primary key (id)
    );

    create table public.pharmacie (
        id int4 not null,
        telephone varchar(25),
        email varchar(25),
        siteweb varchar(25),
        longitude int8,
        latitude int8,
        type varchar(25),
        primary key (id)
    );

    create table public.restaurant (
        id int4 not null,
        telephone varchar(25),
        email varchar(25),
        siteweb varchar(25),
        longitude int8,
        latitude int8,
        primary key (id)
    );

    create table public.specialite (
        id int4 not null,
        nom varchar(25),
        description varchar(25),
        primary key (id)
    );

    create table public.utilisateur (
        id int4 not null,
        nom varchar(25),
        prenom varchar(25),
        adress varchar(25),
        email varchar(25),
        password varchar(25),
        primary key (id)
    );

    create table public.ville (
        id int4 not null,
        gouvernorat varchar(25),
        nom varchar(25),
        rue varchar(25),
        primary key (id)
    );
