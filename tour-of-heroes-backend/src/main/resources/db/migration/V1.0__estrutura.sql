CREATE TABLE "hero"(
    "id_hero" Serial NOT NULL,
    "nm_hero" Character varying(100) NOT NULL
);

ALTER TABLE "hero" ADD CONSTRAINT "pk_hero" PRIMARY KEY ("id_hero");