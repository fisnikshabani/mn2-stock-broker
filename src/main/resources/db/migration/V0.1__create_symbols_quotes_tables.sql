CREATE table symbols(
    VALUE VARCHAR PRIMARY KEY
);

create table quotes(
    id SERIAL primary key,
    bid numeric,
    ask numeric,
    last_price numeric,
    volume numeric,
    symbol VARCHAR,
    foreign key (symbol) REFERENCES symbols(VALUE),
    constraint last_price_is_positive check ( last_price > 0 ),
    constraint volume_is_positive_or_zero check ( volume > 0 )
)