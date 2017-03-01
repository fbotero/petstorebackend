CREATE TABLE public."ADVERTISING"
(
  "ID" bigint NOT NULL DEFAULT nextval('"ADVERTISING_ID_seq"'::regclass),
  "NAME" text,
  "TIMES_TO_SHOW" numeric,
  "TIMES_SHOWED" numeric,
  "IMAGE" text,
  "ACTIVE" boolean,
  CONSTRAINT "ADVERTISING_pkey" PRIMARY KEY ("ID")
)
WITH (
  OIDS=FALSE
);

CREATE TABLE public."APPOINTMENT"
(
  "ID" integer NOT NULL DEFAULT nextval('"APPOINTMENT_ID_seq"'::regclass),
  "EMAIL" text,
  "EVENT_NAME" text,
  "APPOINTMENT_DATE" date,
  "LOCATION" text,
  "MINUTES_BEFORE" numeric,
  "PET_ID" integer
)
WITH (
  OIDS=FALSE
);

CREATE TABLE public."CITY"
(
  "ID" integer NOT NULL DEFAULT nextval('"CITY_ID_seq"'::regclass),
  "NAME_ES" text,
  "NAME_EN" text,
  "COUNTRY_ID" integer
)
WITH (
  OIDS=FALSE
);

CREATE TABLE public."COMMENT"
(
  "ID" integer NOT NULL DEFAULT nextval('"COMMENT_ID_seq"'::regclass),
  "NAME" text,
  "TOPIC_ID" integer,
  "LIKES" integer,
  "DATE" timestamp without time zone,
  "COMMENT_ID" integer,
  CONSTRAINT "COMMENT_pkey" PRIMARY KEY ("ID")
)
WITH (
  OIDS=FALSE
);

CREATE TABLE public."COUNTRY"
(
  "ID" integer NOT NULL DEFAULT nextval('"COUNTRY_ID_seq"'::regclass),
  "NAME_ES" text,
  "NAME_EN" text,
  CONSTRAINT primary_key PRIMARY KEY ("ID")
)
WITH (
  OIDS=FALSE
);

CREATE TABLE public."DIET"
(
  "ID" integer NOT NULL DEFAULT nextval('"DIET_ID_seq"'::regclass),
  "NAME_ES" text,
  "NAME_EN" text,
  "SPECIE_ID" integer,
  CONSTRAINT "DIET_pkey" PRIMARY KEY ("ID")
)
WITH (
  OIDS=FALSE
);

CREATE TABLE public."FOOD_BRAND"
(
  "ID" integer NOT NULL DEFAULT nextval('"FOOD_BRAND_ID_seq"'::regclass),
  "NAME_ES" text,
  "NAME_EN" text,
  "SPECIE" integer,
  CONSTRAINT "primary" PRIMARY KEY ("ID")
)
WITH (
  OIDS=FALSE
);

CREATE TABLE public."LOCATION"
(
  "ID" integer NOT NULL DEFAULT nextval('"LOCATION_ID_seq"'::regclass),
  "NAME" text,
  "ADDRESS" text,
  "TELEPHONE" text,
  "LONGITUDE" double precision,
  "LATITUDE" double precision,
  "HOURS" text,
  "CITY" text,
  "IMAGE" text,
  "STORE" text,
  "VET" text,
  "HOTEL" text,
  "SPA" text,
  "PET_FRIENDLY" text
)
WITH (
  OIDS=FALSE
);

CREATE TABLE public."PET"
(
  "ID" integer NOT NULL DEFAULT nextval('"PET_ID_seq"'::regclass),
  "NAME" text,
  "SPECIE" text,
  "RACE" text,
  "GENDER" text,
  "BIRTH_DATE" text,
  "FOOD_GRAMS" numeric,
  "FUR" text,
  "DIET" text,
  "DIET_NAME" text,
  "LAST_WORM" date,
  "LAST_VACCINE" date,
  "BATH_LOCATION" text,
  "EMAIL" text,
  "FOOD_BRAND" text,
  "FOOD_BRAND_NAME" text,
  "FOOD_BUY_REGULARITY" numeric,
  "LAST_FOOD_BUY_DATE" date,
  "VACCINE" text,
  "WOOPING_COUGH" text,
  "ANTI_FLEA" text,
  "LAST_VET_VISIT" date,
  "STERILIZED" text,
  "BATH_FRECUENCY" numeric,
  "LAST_BATH" date,
  "OTHERS" text,
  "EVENTS" text,
  "REGULARITY" text,
  "AIDS_LEUKEMIA_VACCINE" text,
  "AIDS_LEUKEMIA_VACCINE_DATE" date,
  "WOOPING_COUGH_DATE" date
)
WITH (
  OIDS=FALSE
);

CREATE TABLE public."RACE"
(
  "ID" integer NOT NULL DEFAULT nextval('"RACE_ID_seq"'::regclass),
  "NAME_ES" text,
  "NAME_EN" text,
  "SPECIE" integer,
  CONSTRAINT "Primary" PRIMARY KEY ("ID")
)
WITH (
  OIDS=FALSE
);

CREATE TABLE public."TOPIC"
(
  "ID" integer NOT NULL DEFAULT nextval('"TOPIC_ID_seq"'::regclass),
  "SPECIE" integer,
  "TITLE" text,
  "DESCRIPTION" text,
  "AUTHOR" text,
  "TOPIC_DATE" date,
  "LIKES" integer,
  "DATE" timestamp without time zone,
  CONSTRAINT "TOPIC_pkey" PRIMARY KEY ("ID")
)
WITH (
  OIDS=FALSE
);

CREATE TABLE public."USER"
(
  "EMAIL" text NOT NULL,
  "NAME" text,
  "PASSWORD" text,
  "TELEPHONE" text,
  CONSTRAINT "PRIMARY_KEY" PRIMARY KEY ("EMAIL")
)
WITH (
  OIDS=FALSE
);