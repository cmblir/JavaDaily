drop table if exists ITEM cascade;

create table ITEM
(
    ID        BIGINT auto_increment
        primary key,
    ITEM_NAME CHARACTER VARYING(10),
    PRICE     INTEGER,
    QUANTITY  INTEGER
);
