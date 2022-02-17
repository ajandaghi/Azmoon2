create table if not exists userProfile(
 id serial primary key,
 fullName varchar(280),
 userName varchar (280),
 pass varchar(280)
);

create table if not exists comment(
    id serial primary key,
    userId integer,
    text varchar(280),
    tweetId integer
);

create table if not exists tweet(
    id serial primary key,
    userId varchar(280),
    text varchar(280)
)