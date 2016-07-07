
    alter table public.centre_commercial 
        drop constraint FKDB1A9C2E401A8744;

    alter table public.centre_medicale 
        drop constraint FK53AD01D8401A8744;

    alter table public.hotel 
        drop constraint FK5EDC1B4401A8744;

    alter table public.monument 
        drop constraint FKED0CB3C7401A8744;

    alter table public.pharmacie 
        drop constraint FKE55D5022401A8744;

    alter table public.restaurant 
        drop constraint FK965A4B3D401A8744;

    alter table public.ville 
        drop constraint FK6B033528E0D29F0;

    drop table public.centre_commercial cascade;

    drop table public.centre_medicale cascade;

    drop table public.clientmobile cascade;

    drop table public.clientweb cascade;

    drop table public.commentaire cascade;

    drop table public.evenement cascade;

    drop table public.feeds cascade;

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
        idCC int4 not null,
        idVille int4,
        telephone varchar(258),
        email varchar(258),
        nom varchar(258),
        description varchar(10000),
        siteweb varchar(258),
        longitude float8,
        latitude float8,
        type varchar(258),
        image varchar(258),
        imagemobile varchar(258),
        validation bool default false,
        archive bool default false,
        primary key (idCC)
    );

    create table public.centre_medicale (
        idCM int4 not null,
        idVille int4,
        telephone varchar(258),
        email varchar(258),
        siteweb varchar(258),
        longitude float8,
        latitude float8,
        nom varchar(258),
        description varchar(10000),
        type varchar(258),
        image varchar(258),
        imagemobile varchar(258),
        validation bool default false,
        archive bool default false,
        primary key (idCM)
    );

    create table public.clientmobile (
        idClientMobile int4 not null,
        nom varchar(258),
        prenom varchar(258),
        sexe varchar(258),
        adresse varchar(258),
        email varchar(258) unique,
        password varchar(258),
        login varchar(258),
        telephone varchar(258),
        primary key (idClientMobile)
    );

    create table public.clientweb (
        idClientWeb int4 not null,
        nom varchar(258),
        prenom varchar(258),
        sexe varchar(258),
        adresse varchar(258),
        email varchar(258) unique,
        password varchar(258),
        login varchar(258),
        telephone varchar(258),
        message varchar(10000),
        primary key (idClientWeb)
    );

    create table public.commentaire (
        idCommentaire int4 not null,
        commentaire varchar(10000),
        date date,
        vote int4,
        primary key (idCommentaire)
    );

    create table public.evenement (
        idEvent int4 not null,
        nom varchar(258),
        inscription varchar(1000),
        type varchar(258),
        prix int4,
        date date,
        validation bool default false,
        primary key (idEvent)
    );

    create table public.feeds (
        id int4 not null,
        timestamp timestamp not null,
        name varchar(50),
        image varchar(50),
        status varchar(200),
        profilepic varchar(50),
        url varchar(50),
        primary key (id)
    );

    create table public.hotel (
        idHotel int4 not null,
        idVille int4,
        nomH varchar(258),
        sitewebH varchar(258),
        longitude float8,
        latitude float8,
        description varchar(10000),
        nbreetoile int4,
        telephone_h varchar(258),
        emailH varchar(258),
        image varchar(258),
        imagemobile varchar(258),
        validation bool default false,
        archive bool default false,
        status varchar(10000),
        profilePic varchar(258),
        timeStamp varchar(258),
        url varchar(258),
        primary key (idHotel)
    );

    create table public.image (
        idImage int4 not null,
        nom varchar(258),
        description varchar(10000),
        data varchar(10000),
        primary key (idImage)
    );

    create table public.monument (
        idMonument int4 not null,
        idVille int4,
        nomM varchar(258),
        longitude float8,
        latitude float8,
        description varchar(10000),
        type varchar(258),
        dateconstruction date,
        image varchar(258),
        imagemobile varchar(258),
        primary key (idMonument)
    );

    create table public.pay (
        idPay int4 not null,
        nom varchar(258),
        primary key (idPay)
    );

    create table public.pharmacie (
        idPhar int4 not null,
        idVille int4,
        telephone varchar(258),
        email varchar(258),
        siteweb varchar(258),
        longitude float8,
        latitude float8,
        type varchar(258),
        nom varchar(258) unique,
        description varchar(10000),
        image varchar(258),
        validation bool default false,
        archive bool default false,
        imagemobile varchar(258),
        primary key (idPhar)
    );

    create table public.restaurant (
        idResto int4 not null,
        idVille int4,
        telephone varchar(258),
        email varchar(258),
        siteweb varchar(258),
        longitude float8,
        latitude float8,
        nom varchar(258),
        description varchar(10000),
        horairehouverture timestamp,
        horairefermeture timestamp,
        image varchar(258),
        validation bool default false,
        archive bool default false,
        imagemobile varchar(258),
        primary key (idResto)
    );

    create table public.specialite (
        idSpec int4 not null,
        nom varchar(258) unique,
        description varchar(10000),
        primary key (idSpec)
    );

    create table public.utilisateur (
        idUser int4 not null,
        nom varchar(258),
        prenom varchar(258),
        sexe varchar(258),
        adresse varchar(258),
        email varchar(500),
        password varchar(258),
        login varchar(258),
        telephone varchar(258),
        primary key (idUser)
    );

    create table public.ville (
        idVille int4 not null,
        idpay int4,
        gouvernorat varchar(258),
        nom varchar(258),
        rue varchar(258),
        primary key (idVille)
    );

    alter table public.centre_commercial 
        add constraint FKDB1A9C2E401A8744 
        foreign key (idVille) 
        references public.ville;

    alter table public.centre_medicale 
        add constraint FK53AD01D8401A8744 
        foreign key (idVille) 
        references public.ville;

    alter table public.hotel 
        add constraint FK5EDC1B4401A8744 
        foreign key (idVille) 
        references public.ville;

    alter table public.monument 
        add constraint FKED0CB3C7401A8744 
        foreign key (idVille) 
        references public.ville;

    alter table public.pharmacie 
        add constraint FKE55D5022401A8744 
        foreign key (idVille) 
        references public.ville;

    alter table public.restaurant 
        add constraint FK965A4B3D401A8744 
        foreign key (idVille) 
        references public.ville;

    alter table public.ville 
        add constraint FK6B033528E0D29F0 
        foreign key (idpay) 
        references public.pay;
