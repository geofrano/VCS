-- Function: f_inserta_cronograma(text, text, text, text, text, text, text, text, text, text, text, text, text, text, text, text, text, text, text, text, text, text, text, text, text, text, text, text, text, text, text, text, text, text, text, text, text, text, text, text, text, text, text, text, text, text, text, text, text, text)

-- DROP FUNCTION f_inserta_cronograma(text, text, text, text, text, text, text, text, text, text, text, text, text, text, text, text, text, text, text, text, text, text, text, text, text, text, text, text, text, text, text, text, text, text, text, text, text, text, text, text, text, text, text, text, text, text, text, text, text, text);

CREATE OR REPLACE FUNCTION f_inserta_cronograma(
    ps_cc_id text,
    ps_cod_act_1 text,
    ps_cod_act_2 text,
    ps_cod_act_3 text,
    ps_cod_act_4 text,
    ps_cod_act_5 text,
    ps_cod_act_6 text,
    ps_act1_sem1 text,
    ps_act1_sem2 text,
    ps_act1_sem3 text,
    ps_act1_sem4 text,
    ps_act1_sem5 text,
    ps_act1_sem6 text,
    ps_act1_sem7 text,
    ps_act1_sem8 text,
    ps_act1_sem9 text,
    ps_act1_sem10 text,
    ps_act1_sem11 text,
    ps_act1_sem12 text,
    ps_act1_sem13 text,
    ps_act1_sem14 text,
    ps_act1_sem15 text,
    ps_act2_sem1 text,
    ps_act2_sem2 text,
    ps_act2_sem3 text,
    ps_act2_sem4 text,
    ps_act2_sem5 text,
    ps_act2_sem6 text,
    ps_act2_sem7 text,
    ps_act2_sem8 text,
    ps_act2_sem9 text,
    ps_act2_sem10 text,
    ps_act2_sem11 text,
    ps_act2_sem12 text,
    ps_act2_sem13 text,
    ps_act2_sem14 text,
    ps_act2_sem15 text,
    ps_act3_sem1 text,
    ps_act3_sem2 text,
    ps_act3_sem3 text,
    ps_act3_sem4 text,
    ps_act3_sem5 text,
    ps_act3_sem6 text,
    ps_act3_sem7 text,
    ps_act3_sem8 text,
    ps_act3_sem9 text,
    ps_act3_sem10 text,
    ps_act3_sem11 text,
    ps_act3_sem12 text,
    ps_act3_sem13 text,
    ps_act3_sem14 text,
    ps_act3_sem15 text,
    ps_act4_sem1 text,
    ps_act4_sem2 text,
    ps_act4_sem3 text,
    ps_act4_sem4 text,
    ps_act4_sem5 text,
    ps_act4_sem6 text,
    ps_act4_sem7 text,
    ps_act4_sem8 text,
    ps_act4_sem9 text,
    ps_act4_sem10 text,
    ps_act4_sem11 text,
    ps_act4_sem12 text,
    ps_act4_sem13 text,
    ps_act4_sem14 text,
    ps_act4_sem15 text,
    ps_act5_sem1 text,
    ps_act5_sem2 text,
    ps_act5_sem3 text,
    ps_act5_sem4 text,
    ps_act5_sem5 text,
    ps_act5_sem6 text,
    ps_act5_sem7 text,
    ps_act5_sem8 text,
    ps_act5_sem9 text,
    ps_act5_sem10 text,
    ps_act5_sem11 text,
    ps_act5_sem12 text,
    ps_act5_sem13 text,
    ps_act5_sem14 text,
    ps_act5_sem15 text,
    ps_act6_sem1 text,
    ps_act6_sem2 text,
    ps_act6_sem3 text,
    ps_act6_sem4 text,
    ps_act6_sem5 text,
    ps_act6_sem6 text,
    ps_act6_sem7 text,
    ps_act6_sem8 text,
    ps_act6_sem9 text,
    ps_act6_sem10 text,
    ps_act6_sem11 text,
    ps_act6_sem12 text,
    ps_act6_sem13 text,
    ps_act6_sem14 text,
    ps_act6_sem15 text,
    ps_accion text)
  RETURNS text AS
$BODY$
DECLARE
   resultado text:= 'NO' ;
   
BEGIN

if ps_accion = 'I' then--Ingresar una nueva
 if CAST(ps_act1_sem1 AS integer) > 0 then	
	INSERT INTO "MPP_CRONOGRAMA_ACT"(
		    ca_semana, ca_num_hora, ae_id)
	    VALUES (1, CAST(ps_act1_sem1 AS integer), CAST(ps_cod_act_1 AS integer));
 end if;
 if CAST(ps_act1_sem2 AS integer) > 0 then
	INSERT INTO "MPP_CRONOGRAMA_ACT"(
		    ca_semana, ca_num_hora, ae_id)
	    VALUES (2, CAST(ps_act1_sem2 AS integer), CAST(ps_cod_act_1 AS integer));
 end if;
 if CAST(ps_act1_sem3 AS integer) > 0 then
	INSERT INTO "MPP_CRONOGRAMA_ACT"(
		    ca_semana, ca_num_hora, ae_id)
	    VALUES (3, CAST(ps_act1_sem3 AS integer), CAST(ps_cod_act_1 AS integer));
 end if;
 if CAST(ps_act1_sem4 AS integer) > 0 then
	INSERT INTO "MPP_CRONOGRAMA_ACT"(
		    ca_semana, ca_num_hora, ae_id)
	    VALUES (4, CAST(ps_act1_sem4 AS integer), CAST(ps_cod_act_1 AS integer));
 end if;
 if CAST(ps_act1_sem5 AS integer) > 0 then
	INSERT INTO "MPP_CRONOGRAMA_ACT"(
		    ca_semana, ca_num_hora, ae_id)
	    VALUES (5, CAST(ps_act1_sem5 AS integer), CAST(ps_cod_act_1 AS integer));
 end if;
 if CAST(ps_act1_sem6 AS integer) > 0 then
	INSERT INTO "MPP_CRONOGRAMA_ACT"(
		    ca_semana, ca_num_hora, ae_id)
	    VALUES (6, CAST(ps_act1_sem6 AS integer), CAST(ps_cod_act_1 AS integer));
 end if;
 if CAST(ps_act1_sem7 AS integer) > 0 then
	INSERT INTO "MPP_CRONOGRAMA_ACT"(
		    ca_semana, ca_num_hora, ae_id)
	    VALUES (7, CAST(ps_act1_sem7 AS integer), CAST(ps_cod_act_1 AS integer));
 end if;
 if CAST(ps_act1_sem8 AS integer) > 0 then
	INSERT INTO "MPP_CRONOGRAMA_ACT"(
		    ca_semana, ca_num_hora, ae_id)
	    VALUES (8, CAST(ps_act1_sem8 AS integer), CAST(ps_cod_act_1 AS integer));
 end if;
 if CAST(ps_act1_sem9 AS integer) > 0 then
	INSERT INTO "MPP_CRONOGRAMA_ACT"(
		    ca_semana, ca_num_hora, ae_id)
	    VALUES (9, CAST(ps_act1_sem9 AS integer), CAST(ps_cod_act_1 AS integer));
 end if;
 if CAST(ps_act1_sem10 AS integer) > 0 then
	INSERT INTO "MPP_CRONOGRAMA_ACT"(
		    ca_semana, ca_num_hora, ae_id)
	    VALUES (10, CAST(ps_act1_sem10 AS integer), CAST(ps_cod_act_1 AS integer));
 end if;
 if CAST(ps_act1_sem11 AS integer) > 0 then
	INSERT INTO "MPP_CRONOGRAMA_ACT"(
		    ca_semana, ca_num_hora, ae_id)
	    VALUES (11, CAST(ps_act1_sem11 AS integer), CAST(ps_cod_act_1 AS integer));
 end if;
 if CAST(ps_act1_sem12 AS integer) > 0 then
	INSERT INTO "MPP_CRONOGRAMA_ACT"(
		    ca_semana, ca_num_hora, ae_id)
	    VALUES (12, CAST(ps_act1_sem12 AS integer), CAST(ps_cod_act_1 AS integer));
 end if;
 if CAST(ps_act1_sem13 AS integer) > 0 then
	INSERT INTO "MPP_CRONOGRAMA_ACT"(
		    ca_semana, ca_num_hora, ae_id)
	    VALUES (13, CAST(ps_act1_sem13 AS integer), CAST(ps_cod_act_1 AS integer));
 end if;
 if CAST(ps_act1_sem14 AS integer) > 0 then
	INSERT INTO "MPP_CRONOGRAMA_ACT"(
		    ca_semana, ca_num_hora, ae_id)
	    VALUES (14, CAST(ps_act1_sem14 AS integer), CAST(ps_cod_act_1 AS integer));
 end if;
 if CAST(ps_act1_sem15 AS integer) > 0 then
	INSERT INTO "MPP_CRONOGRAMA_ACT"(
		    ca_semana, ca_num_hora, ae_id)
	    VALUES (15, CAST(ps_act1_sem15 AS integer), CAST(ps_cod_act_1 AS integer));
 end if;

--ACTIVIDAD 2
 if CAST(ps_act2_sem1 AS integer) > 0 then
	INSERT INTO "MPP_CRONOGRAMA_ACT"(
		    ca_semana, ca_num_hora, ae_id)
	    VALUES (1, CAST(ps_act2_sem1 AS integer), CAST(ps_cod_act_2 AS integer));
 end if;
 if CAST(ps_act2_sem2 AS integer) > 0 then
	INSERT INTO "MPP_CRONOGRAMA_ACT"(
		    ca_semana, ca_num_hora, ae_id)
	    VALUES (2, CAST(ps_act2_sem2 AS integer), CAST(ps_cod_act_2 AS integer));
 end if;
 if CAST(ps_act2_sem3 AS integer) > 0 then
	INSERT INTO "MPP_CRONOGRAMA_ACT"(
		    ca_semana, ca_num_hora, ae_id)
	    VALUES (3, CAST(ps_act2_sem3 AS integer), CAST(ps_cod_act_2 AS integer));
 end if;
 if CAST(ps_act2_sem4 AS integer) > 0 then
	INSERT INTO "MPP_CRONOGRAMA_ACT"(
		    ca_semana, ca_num_hora, ae_id)
	    VALUES (4, CAST(ps_act2_sem4 AS integer), CAST(ps_cod_act_2 AS integer));
 end if;
 if CAST(ps_act2_sem5 AS integer) > 0 then
	INSERT INTO "MPP_CRONOGRAMA_ACT"(
		    ca_semana, ca_num_hora, ae_id)
	    VALUES (5, CAST(ps_act2_sem5 AS integer), CAST(ps_cod_act_2 AS integer));
 end if;
 if CAST(ps_act2_sem6 AS integer) > 0 then
	INSERT INTO "MPP_CRONOGRAMA_ACT"(
		    ca_semana, ca_num_hora, ae_id)
	    VALUES (6, CAST(ps_act2_sem6 AS integer), CAST(ps_cod_act_2 AS integer));
 end if;
 if CAST(ps_act2_sem7 AS integer) > 0 then
	INSERT INTO "MPP_CRONOGRAMA_ACT"(
		    ca_semana, ca_num_hora, ae_id)
	    VALUES (7, CAST(ps_act2_sem7 AS integer), CAST(ps_cod_act_2 AS integer));
 end if;
 if CAST(ps_act2_sem8 AS integer) > 0 then
	INSERT INTO "MPP_CRONOGRAMA_ACT"(
		    ca_semana, ca_num_hora, ae_id)
	    VALUES (8, CAST(ps_act2_sem8 AS integer), CAST(ps_cod_act_2 AS integer));
 end if;
 if CAST(ps_act2_sem9 AS integer) > 0 then
	INSERT INTO "MPP_CRONOGRAMA_ACT"(
		    ca_semana, ca_num_hora, ae_id)
	    VALUES (9, CAST(ps_act2_sem9 AS integer), CAST(ps_cod_act_2 AS integer));
 end if;
 if CAST(ps_act2_sem10 AS integer) > 0 then
	INSERT INTO "MPP_CRONOGRAMA_ACT"(
		    ca_semana, ca_num_hora, ae_id)
	    VALUES (10, CAST(ps_act2_sem10 AS integer), CAST(ps_cod_act_2 AS integer));
 end if;
 if CAST(ps_act2_sem11 AS integer) > 0 then
	INSERT INTO "MPP_CRONOGRAMA_ACT"(
		    ca_semana, ca_num_hora, ae_id)
	    VALUES (11, CAST(ps_act2_sem11 AS integer), CAST(ps_cod_act_2 AS integer));
 end if;
 if CAST(ps_act2_sem12 AS integer) > 0 then
	INSERT INTO "MPP_CRONOGRAMA_ACT"(
		    ca_semana, ca_num_hora, ae_id)
	    VALUES (12, CAST(ps_act2_sem12 AS integer), CAST(ps_cod_act_2 AS integer));
 end if;
 if CAST(ps_act2_sem13 AS integer) > 0 then
	INSERT INTO "MPP_CRONOGRAMA_ACT"(
		    ca_semana, ca_num_hora, ae_id)
	    VALUES (13, CAST(ps_act2_sem13 AS integer), CAST(ps_cod_act_2 AS integer));
 end if;
 if CAST(ps_act2_sem14 AS integer) > 0 then
	INSERT INTO "MPP_CRONOGRAMA_ACT"(
		    ca_semana, ca_num_hora, ae_id)
	    VALUES (14, CAST(ps_act2_sem14 AS integer), CAST(ps_cod_act_2 AS integer));
 end if;
 if CAST(ps_act2_sem15 AS integer) > 0 then
	INSERT INTO "MPP_CRONOGRAMA_ACT"(
		    ca_semana, ca_num_hora, ae_id)
	    VALUES (15, CAST(ps_act2_sem15 AS integer), CAST(ps_cod_act_2 AS integer));
 end if;

--ACTIVIDAD 3
if CAST(ps_act3_sem1 AS integer) > 0 then
	INSERT INTO "MPP_CRONOGRAMA_ACT"(
		    ca_semana, ca_num_hora, ae_id)
	    VALUES (1, CAST(ps_act3_sem1 AS integer), CAST(ps_cod_act_3 AS integer));
 end if;
 if CAST(ps_act3_sem2 AS integer) > 0 then
	INSERT INTO "MPP_CRONOGRAMA_ACT"(
		    ca_semana, ca_num_hora, ae_id)
	    VALUES (2, CAST(ps_act3_sem2 AS integer), CAST(ps_cod_act_3 AS integer));
 end if;
 if CAST(ps_act3_sem3 AS integer) > 0 then
	INSERT INTO "MPP_CRONOGRAMA_ACT"(
		    ca_semana, ca_num_hora, ae_id)
	    VALUES (3, CAST(ps_act3_sem3 AS integer), CAST(ps_cod_act_3 AS integer));
 end if;
 if CAST(ps_act3_sem4 AS integer) > 0 then
	INSERT INTO "MPP_CRONOGRAMA_ACT"(
		    ca_semana, ca_num_hora, ae_id)
	    VALUES (4, CAST(ps_act3_sem4 AS integer), CAST(ps_cod_act_3 AS integer));
 end if;
 if CAST(ps_act3_sem5 AS integer) > 0 then
	INSERT INTO "MPP_CRONOGRAMA_ACT"(
		    ca_semana, ca_num_hora, ae_id)
	    VALUES (5, CAST(ps_act3_sem5 AS integer), CAST(ps_cod_act_3 AS integer));
 end if;
 if CAST(ps_act3_sem6 AS integer) > 0 then
	INSERT INTO "MPP_CRONOGRAMA_ACT"(
		    ca_semana, ca_num_hora, ae_id)
	    VALUES (6, CAST(ps_act3_sem6 AS integer), CAST(ps_cod_act_3 AS integer));
 end if;
 if CAST(ps_act3_sem7 AS integer) > 0 then
	INSERT INTO "MPP_CRONOGRAMA_ACT"(
		    ca_semana, ca_num_hora, ae_id)
	    VALUES (7, CAST(ps_act3_sem7 AS integer), CAST(ps_cod_act_3 AS integer));
 end if;
 if CAST(ps_act3_sem8 AS integer) > 0 then
	INSERT INTO "MPP_CRONOGRAMA_ACT"(
		    ca_semana, ca_num_hora, ae_id)
	    VALUES (8, CAST(ps_act3_sem8 AS integer), CAST(ps_cod_act_3 AS integer));
 end if;
 if CAST(ps_act3_sem9 AS integer) > 0 then
	INSERT INTO "MPP_CRONOGRAMA_ACT"(
		    ca_semana, ca_num_hora, ae_id)
	    VALUES (9, CAST(ps_act3_sem9 AS integer), CAST(ps_cod_act_3 AS integer));
 end if;
 if CAST(ps_act3_sem10 AS integer) > 0 then
	INSERT INTO "MPP_CRONOGRAMA_ACT"(
		    ca_semana, ca_num_hora, ae_id)
	    VALUES (10, CAST(ps_act3_sem10 AS integer), CAST(ps_cod_act_3 AS integer));
 end if;
 if CAST(ps_act3_sem11 AS integer) > 0 then
	INSERT INTO "MPP_CRONOGRAMA_ACT"(
		    ca_semana, ca_num_hora, ae_id)
	    VALUES (11, CAST(ps_act3_sem11 AS integer), CAST(ps_cod_act_3 AS integer));
 end if;
 if CAST(ps_act3_sem12 AS integer) > 0 then
	INSERT INTO "MPP_CRONOGRAMA_ACT"(
		    ca_semana, ca_num_hora, ae_id)
	    VALUES (12, CAST(ps_act3_sem12 AS integer), CAST(ps_cod_act_3 AS integer));
 end if;
 if CAST(ps_act3_sem13 AS integer) > 0 then
	INSERT INTO "MPP_CRONOGRAMA_ACT"(
		    ca_semana, ca_num_hora, ae_id)
	    VALUES (13, CAST(ps_act3_sem13 AS integer), CAST(ps_cod_act_3 AS integer));
 end if;
 if CAST(ps_act3_sem14 AS integer) > 0 then
	INSERT INTO "MPP_CRONOGRAMA_ACT"(
		    ca_semana, ca_num_hora, ae_id)
	    VALUES (14, CAST(ps_act3_sem14 AS integer), CAST(ps_cod_act_3 AS integer));
 end if;
 if CAST(ps_act3_sem15 AS integer) > 0 then
	INSERT INTO "MPP_CRONOGRAMA_ACT"(
		    ca_semana, ca_num_hora, ae_id)
	    VALUES (15, CAST(ps_act3_sem15 AS integer), CAST(ps_cod_act_3 AS integer));
 end if;

 ---ACTIVIDAD 4
 if CAST(ps_act4_sem1 AS integer) > 0 then
	INSERT INTO "MPP_CRONOGRAMA_ACT"(
		    ca_semana, ca_num_hora, ae_id)
	    VALUES (1, CAST(ps_act4_sem1 AS integer), CAST(ps_cod_act_4 AS integer));
 end if;
 if CAST(ps_act4_sem2 AS integer) > 0 then
	INSERT INTO "MPP_CRONOGRAMA_ACT"(
		    ca_semana, ca_num_hora, ae_id)
	    VALUES (2, CAST(ps_act4_sem2 AS integer), CAST(ps_cod_act_4 AS integer));
 end if;
 if CAST(ps_act4_sem3 AS integer) > 0 then
	INSERT INTO "MPP_CRONOGRAMA_ACT"(
		    ca_semana, ca_num_hora, ae_id)
	    VALUES (3, CAST(ps_act4_sem3 AS integer), CAST(ps_cod_act_4 AS integer));
 end if;
 if CAST(ps_act4_sem4 AS integer) > 0 then
	INSERT INTO "MPP_CRONOGRAMA_ACT"(
		    ca_semana, ca_num_hora, ae_id)
	    VALUES (4, CAST(ps_act4_sem4 AS integer), CAST(ps_cod_act_4 AS integer));
 end if;
 if CAST(ps_act4_sem5 AS integer) > 0 then
	INSERT INTO "MPP_CRONOGRAMA_ACT"(
		    ca_semana, ca_num_hora, ae_id)
	    VALUES (5, CAST(ps_act4_sem5 AS integer), CAST(ps_cod_act_4 AS integer));
 end if;
 if CAST(ps_act4_sem6 AS integer) > 0 then
	INSERT INTO "MPP_CRONOGRAMA_ACT"(
		    ca_semana, ca_num_hora, ae_id)
	    VALUES (6, CAST(ps_act4_sem6 AS integer), CAST(ps_cod_act_4 AS integer));
 end if;
 if CAST(ps_act4_sem7 AS integer) > 0 then
	INSERT INTO "MPP_CRONOGRAMA_ACT"(
		    ca_semana, ca_num_hora, ae_id)
	    VALUES (7, CAST(ps_act4_sem7 AS integer), CAST(ps_cod_act_4 AS integer));
 end if;
 if CAST(ps_act4_sem8 AS integer) > 0 then
	INSERT INTO "MPP_CRONOGRAMA_ACT"(
		    ca_semana, ca_num_hora, ae_id)
	    VALUES (8, CAST(ps_act4_sem8 AS integer), CAST(ps_cod_act_4 AS integer));
 end if;
 if CAST(ps_act4_sem9 AS integer) > 0 then
	INSERT INTO "MPP_CRONOGRAMA_ACT"(
		    ca_semana, ca_num_hora, ae_id)
	    VALUES (9, CAST(ps_act4_sem9 AS integer), CAST(ps_cod_act_4 AS integer));
 end if;
 if CAST(ps_act4_sem10 AS integer) > 0 then
	INSERT INTO "MPP_CRONOGRAMA_ACT"(
		    ca_semana, ca_num_hora, ae_id)
	    VALUES (10, CAST(ps_act4_sem10 AS integer), CAST(ps_cod_act_4 AS integer));
 end if;
 if CAST(ps_act4_sem11 AS integer) > 0 then
	INSERT INTO "MPP_CRONOGRAMA_ACT"(
		    ca_semana, ca_num_hora, ae_id)
	    VALUES (11, CAST(ps_act4_sem11 AS integer), CAST(ps_cod_act_4 AS integer));
 end if;
 if CAST(ps_act4_sem12 AS integer) > 0 then
	INSERT INTO "MPP_CRONOGRAMA_ACT"(
		    ca_semana, ca_num_hora, ae_id)
	    VALUES (12, CAST(ps_act4_sem12 AS integer), CAST(ps_cod_act_4 AS integer));
 end if;
 if CAST(ps_act4_sem13 AS integer) > 0 then
	INSERT INTO "MPP_CRONOGRAMA_ACT"(
		    ca_semana, ca_num_hora, ae_id)
	    VALUES (13, CAST(ps_act4_sem13 AS integer), CAST(ps_cod_act_4 AS integer));
 end if;
 if CAST(ps_act4_sem14 AS integer) > 0 then
	INSERT INTO "MPP_CRONOGRAMA_ACT"(
		    ca_semana, ca_num_hora, ae_id)
	    VALUES (14, CAST(ps_act4_sem14 AS integer), CAST(ps_cod_act_4 AS integer));
 end if;
 if CAST(ps_act4_sem15 AS integer) > 0 then
	INSERT INTO "MPP_CRONOGRAMA_ACT"(
		    ca_semana, ca_num_hora, ae_id)
	    VALUES (15, CAST(ps_act4_sem15 AS integer), CAST(ps_cod_act_4 AS integer));
 end if;

--ACTIVIDAD 5
if CAST(ps_act5_sem1 AS integer) > 0 then
	INSERT INTO "MPP_CRONOGRAMA_ACT"(
		    ca_semana, ca_num_hora, ae_id)
	    VALUES (1, CAST(ps_act5_sem1 AS integer), CAST(ps_cod_act_5 AS integer));
 end if;
 if CAST(ps_act5_sem2 AS integer) > 0 then
	INSERT INTO "MPP_CRONOGRAMA_ACT"(
		    ca_semana, ca_num_hora, ae_id)
	    VALUES (2, CAST(ps_act5_sem2 AS integer), CAST(ps_cod_act_5 AS integer));
 end if;
 if CAST(ps_act5_sem3 AS integer) > 0 then
	INSERT INTO "MPP_CRONOGRAMA_ACT"(
		    ca_semana, ca_num_hora, ae_id)
	    VALUES (3, CAST(ps_act5_sem3 AS integer), CAST(ps_cod_act_5 AS integer));
 end if;
 if CAST(ps_act5_sem4 AS integer) > 0 then
	INSERT INTO "MPP_CRONOGRAMA_ACT"(
		    ca_semana, ca_num_hora, ae_id)
	    VALUES (4, CAST(ps_act5_sem4 AS integer), CAST(ps_cod_act_5 AS integer));
 end if;
 if CAST(ps_act5_sem5 AS integer) > 0 then
	INSERT INTO "MPP_CRONOGRAMA_ACT"(
		    ca_semana, ca_num_hora, ae_id)
	    VALUES (5, CAST(ps_act5_sem5 AS integer), CAST(ps_cod_act_5 AS integer));
 end if;
 if CAST(ps_act5_sem6 AS integer) > 0 then
	INSERT INTO "MPP_CRONOGRAMA_ACT"(
		    ca_semana, ca_num_hora, ae_id)
	    VALUES (6, CAST(ps_act5_sem6 AS integer), CAST(ps_cod_act_5 AS integer));
 end if;
 if CAST(ps_act5_sem7 AS integer) > 0 then
	INSERT INTO "MPP_CRONOGRAMA_ACT"(
		    ca_semana, ca_num_hora, ae_id)
	    VALUES (7, CAST(ps_act5_sem7 AS integer), CAST(ps_cod_act_5 AS integer));
 end if;
 if CAST(ps_act5_sem8 AS integer) > 0 then
	INSERT INTO "MPP_CRONOGRAMA_ACT"(
		    ca_semana, ca_num_hora, ae_id)
	    VALUES (8, CAST(ps_act5_sem8 AS integer), CAST(ps_cod_act_5 AS integer));
 end if;
 if CAST(ps_act5_sem9 AS integer) > 0 then
	INSERT INTO "MPP_CRONOGRAMA_ACT"(
		    ca_semana, ca_num_hora, ae_id)
	    VALUES (9, CAST(ps_act5_sem9 AS integer), CAST(ps_cod_act_5 AS integer));
 end if;
 if CAST(ps_act5_sem10 AS integer) > 0 then
	INSERT INTO "MPP_CRONOGRAMA_ACT"(
		    ca_semana, ca_num_hora, ae_id)
	    VALUES (10, CAST(ps_act5_sem10 AS integer), CAST(ps_cod_act_5 AS integer));
 end if;
 if CAST(ps_act5_sem11 AS integer) > 0 then
	INSERT INTO "MPP_CRONOGRAMA_ACT"(
		    ca_semana, ca_num_hora, ae_id)
	    VALUES (11, CAST(ps_act5_sem11 AS integer), CAST(ps_cod_act_5 AS integer));
 end if;
 if CAST(ps_act5_sem12 AS integer) > 0 then
	INSERT INTO "MPP_CRONOGRAMA_ACT"(
		    ca_semana, ca_num_hora, ae_id)
	    VALUES (12, CAST(ps_act5_sem12 AS integer), CAST(ps_cod_act_5 AS integer));
 end if;
 if CAST(ps_act5_sem13 AS integer) > 0 then
	INSERT INTO "MPP_CRONOGRAMA_ACT"(
		    ca_semana, ca_num_hora, ae_id)
	    VALUES (13, CAST(ps_act5_sem13 AS integer), CAST(ps_cod_act_5 AS integer));
 end if;
 if CAST(ps_act5_sem14 AS integer) > 0 then
	INSERT INTO "MPP_CRONOGRAMA_ACT"(
		    ca_semana, ca_num_hora, ae_id)
	    VALUES (14, CAST(ps_act5_sem14 AS integer), CAST(ps_cod_act_5 AS integer));
 end if;
 if CAST(ps_act5_sem15 AS integer) > 0 then
	INSERT INTO "MPP_CRONOGRAMA_ACT"(
		    ca_semana, ca_num_hora, ae_id)
	    VALUES (15, CAST(ps_act5_sem15 AS integer), CAST(ps_cod_act_5 AS integer));
 end if;

 --ACTIVIDAD 6
 if CAST(ps_act6_sem1 AS integer) > 0 then
	INSERT INTO "MPP_CRONOGRAMA_ACT"(
		    ca_semana, ca_num_hora, ae_id)
	    VALUES (1, CAST(ps_act6_sem1 AS integer), CAST(ps_cod_act_6 AS integer));
 end if;
 if CAST(ps_act6_sem2 AS integer) > 0 then
	INSERT INTO "MPP_CRONOGRAMA_ACT"(
		    ca_semana, ca_num_hora, ae_id)
	    VALUES (2, CAST(ps_act6_sem2 AS integer), CAST(ps_cod_act_6 AS integer));
 end if;
 if CAST(ps_act6_sem3 AS integer) > 0 then
	INSERT INTO "MPP_CRONOGRAMA_ACT"(
		    ca_semana, ca_num_hora, ae_id)
	    VALUES (3, CAST(ps_act6_sem3 AS integer), CAST(ps_cod_act_6 AS integer));
 end if;
 if CAST(ps_act6_sem4 AS integer) > 0 then
	INSERT INTO "MPP_CRONOGRAMA_ACT"(
		    ca_semana, ca_num_hora, ae_id)
	    VALUES (4, CAST(ps_act6_sem4 AS integer), CAST(ps_cod_act_6 AS integer));
 end if;
 if CAST(ps_act6_sem5 AS integer) > 0 then
	INSERT INTO "MPP_CRONOGRAMA_ACT"(
		    ca_semana, ca_num_hora, ae_id)
	    VALUES (5, CAST(ps_act6_sem5 AS integer), CAST(ps_cod_act_6 AS integer));
 end if;
 if CAST(ps_act6_sem6 AS integer) > 0 then
	INSERT INTO "MPP_CRONOGRAMA_ACT"(
		    ca_semana, ca_num_hora, ae_id)
	    VALUES (6, CAST(ps_act6_sem6 AS integer), CAST(ps_cod_act_6 AS integer));
 end if;
 if CAST(ps_act6_sem7 AS integer) > 0 then
	INSERT INTO "MPP_CRONOGRAMA_ACT"(
		    ca_semana, ca_num_hora, ae_id)
	    VALUES (7, CAST(ps_act6_sem7 AS integer), CAST(ps_cod_act_6 AS integer));
 end if;
 if CAST(ps_act6_sem8 AS integer) > 0 then
	INSERT INTO "MPP_CRONOGRAMA_ACT"(
		    ca_semana, ca_num_hora, ae_id)
	    VALUES (8, CAST(ps_act6_sem8 AS integer), CAST(ps_cod_act_6 AS integer));
 end if;
 if CAST(ps_act6_sem9 AS integer) > 0 then
	INSERT INTO "MPP_CRONOGRAMA_ACT"(
		    ca_semana, ca_num_hora, ae_id)
	    VALUES (9, CAST(ps_act6_sem9 AS integer), CAST(ps_cod_act_6 AS integer));
 end if;
 if CAST(ps_act6_sem10 AS integer) > 0 then
	INSERT INTO "MPP_CRONOGRAMA_ACT"(
		    ca_semana, ca_num_hora, ae_id)
	    VALUES (10, CAST(ps_act6_sem10 AS integer), CAST(ps_cod_act_6 AS integer));
 end if;
 if CAST(ps_act6_sem11 AS integer) > 0 then
	INSERT INTO "MPP_CRONOGRAMA_ACT"(
		    ca_semana, ca_num_hora, ae_id)
	    VALUES (11, CAST(ps_act6_sem11 AS integer), CAST(ps_cod_act_6 AS integer));
 end if;
 if CAST(ps_act6_sem12 AS integer) > 0 then
	INSERT INTO "MPP_CRONOGRAMA_ACT"(
		    ca_semana, ca_num_hora, ae_id)
	    VALUES (12, CAST(ps_act6_sem12 AS integer), CAST(ps_cod_act_6 AS integer));
 end if;
 if CAST(ps_act6_sem13 AS integer) > 0 then
	INSERT INTO "MPP_CRONOGRAMA_ACT"(
		    ca_semana, ca_num_hora, ae_id)
	    VALUES (13, CAST(ps_act6_sem13 AS integer), CAST(ps_cod_act_6 AS integer));
 end if;
 if CAST(ps_act6_sem14 AS integer) > 0 then
	INSERT INTO "MPP_CRONOGRAMA_ACT"(
		    ca_semana, ca_num_hora, ae_id)
	    VALUES (14, CAST(ps_act6_sem14 AS integer), CAST(ps_cod_act_6 AS integer));
 end if;
 if CAST(ps_act6_sem15 AS integer) > 0 then
	INSERT INTO "MPP_CRONOGRAMA_ACT"(
		    ca_semana, ca_num_hora, ae_id)
	    VALUES (15, CAST(ps_act6_sem15 AS integer), CAST(ps_cod_act_6 AS integer));
 end if;

elsif ps_accion = 'M' THEN


UPDATE "MPP_CRONOGRAMA_ACT"
   SET ca_num_hora=CAST(ps_act1_sem1 AS integer)
 WHERE ae_id = CAST(ps_cod_act_1 AS integer)
  and ca_semana = 1;
  UPDATE "MPP_CRONOGRAMA_ACT"
   SET ca_num_hora=CAST(ps_act1_sem2 AS integer)
 WHERE ae_id = CAST(ps_cod_act_1 AS integer)
  and ca_semana = 2;
  UPDATE "MPP_CRONOGRAMA_ACT"
   SET ca_num_hora=CAST(ps_act1_sem3 AS integer)
 WHERE ae_id = CAST(ps_cod_act_1 AS integer)
  and ca_semana = 3;
  UPDATE "MPP_CRONOGRAMA_ACT"
   SET ca_num_hora=CAST(ps_act1_sem4 AS integer)
 WHERE ae_id = CAST(ps_cod_act_1 AS integer)
  and ca_semana = 4;
  UPDATE "MPP_CRONOGRAMA_ACT"
   SET ca_num_hora=CAST(ps_act1_sem5 AS integer)
 WHERE ae_id = CAST(ps_cod_act_1 AS integer)
  and ca_semana = 5;
UPDATE "MPP_CRONOGRAMA_ACT"
   SET ca_num_hora=CAST(ps_act1_sem6 AS integer)
 WHERE ae_id = CAST(ps_cod_act_1 AS integer)
  and ca_semana = 6;
UPDATE "MPP_CRONOGRAMA_ACT"
   SET ca_num_hora=CAST(ps_act1_sem7 AS integer)
 WHERE ae_id = CAST(ps_cod_act_1 AS integer)
  and ca_semana = 7;
UPDATE "MPP_CRONOGRAMA_ACT"
   SET ca_num_hora=CAST(ps_act1_sem8 AS integer)
 WHERE ae_id = CAST(ps_cod_act_1 AS integer)
  and ca_semana = 8;
  UPDATE "MPP_CRONOGRAMA_ACT"
   SET ca_num_hora=CAST(ps_act1_sem9 AS integer)
 WHERE ae_id = CAST(ps_cod_act_1 AS integer)
  and ca_semana = 9;
  UPDATE "MPP_CRONOGRAMA_ACT"
   SET ca_num_hora=CAST(ps_act1_sem10 AS integer)
 WHERE ae_id = CAST(ps_cod_act_1 AS integer)
  and ca_semana = 10;
  UPDATE "MPP_CRONOGRAMA_ACT"
   SET ca_num_hora=CAST(ps_act1_sem11 AS integer)
 WHERE ae_id = CAST(ps_cod_act_1 AS integer)
  and ca_semana = 11;
  UPDATE "MPP_CRONOGRAMA_ACT"
   SET ca_num_hora=CAST(ps_act1_sem12 AS integer)
 WHERE ae_id = CAST(ps_cod_act_1 AS integer)
  and ca_semana = 12;
UPDATE "MPP_CRONOGRAMA_ACT"
   SET ca_num_hora=CAST(ps_act1_sem13 AS integer)
 WHERE ae_id = CAST(ps_cod_act_1 AS integer)
  and ca_semana = 13;
UPDATE "MPP_CRONOGRAMA_ACT"
   SET ca_num_hora=CAST(ps_act1_sem14 AS integer)
 WHERE ae_id = CAST(ps_cod_act_1 AS integer)
  and ca_semana = 14;
UPDATE "MPP_CRONOGRAMA_ACT"
   SET ca_num_hora=CAST(ps_act1_sem15 AS integer)
 WHERE ae_id = CAST(ps_cod_act_1 AS integer)
  and ca_semana = 15;


UPDATE "MPP_CRONOGRAMA_ACT"
   SET ca_num_hora=CAST(ps_act2_sem1 AS integer)
 WHERE ae_id = CAST(ps_cod_act_2 AS integer)
  and ca_semana = 1;
  UPDATE "MPP_CRONOGRAMA_ACT"
   SET ca_num_hora=CAST(ps_act2_sem2 AS integer)
 WHERE ae_id = CAST(ps_cod_act_2 AS integer)
  and ca_semana = 2;
  UPDATE "MPP_CRONOGRAMA_ACT"
   SET ca_num_hora=CAST(ps_act2_sem3 AS integer)
 WHERE ae_id = CAST(ps_cod_act_2 AS integer)
  and ca_semana = 3;
  UPDATE "MPP_CRONOGRAMA_ACT"
   SET ca_num_hora=CAST(ps_act2_sem4 AS integer)
 WHERE ae_id = CAST(ps_cod_act_2 AS integer)
  and ca_semana = 4;
  UPDATE "MPP_CRONOGRAMA_ACT"
   SET ca_num_hora=CAST(ps_act2_sem5 AS integer)
 WHERE ae_id = CAST(ps_cod_act_2 AS integer)
  and ca_semana = 5;
UPDATE "MPP_CRONOGRAMA_ACT"
   SET ca_num_hora=CAST(ps_act2_sem6 AS integer)
 WHERE ae_id = CAST(ps_cod_act_2 AS integer)
  and ca_semana = 6;
UPDATE "MPP_CRONOGRAMA_ACT"
   SET ca_num_hora=CAST(ps_act2_sem7 AS integer)
 WHERE ae_id = CAST(ps_cod_act_2 AS integer)
  and ca_semana = 7;
UPDATE "MPP_CRONOGRAMA_ACT"
   SET ca_num_hora=CAST(ps_act2_sem8 AS integer)
 WHERE ae_id = CAST(ps_cod_act_2 AS integer)
  and ca_semana = 8;
  UPDATE "MPP_CRONOGRAMA_ACT"
   SET ca_num_hora=CAST(ps_act2_sem9 AS integer)
 WHERE ae_id = CAST(ps_cod_act_2 AS integer)
  and ca_semana = 9;
  UPDATE "MPP_CRONOGRAMA_ACT"
   SET ca_num_hora=CAST(ps_act2_sem10 AS integer)
 WHERE ae_id = CAST(ps_cod_act_2 AS integer)
  and ca_semana = 10;
  UPDATE "MPP_CRONOGRAMA_ACT"
   SET ca_num_hora=CAST(ps_act2_sem11 AS integer)
 WHERE ae_id = CAST(ps_cod_act_2 AS integer)
  and ca_semana = 11;
  UPDATE "MPP_CRONOGRAMA_ACT"
   SET ca_num_hora=CAST(ps_act2_sem12 AS integer)
 WHERE ae_id = CAST(ps_cod_act_2 AS integer)
  and ca_semana = 12;
UPDATE "MPP_CRONOGRAMA_ACT"
   SET ca_num_hora=CAST(ps_act2_sem13 AS integer)
 WHERE ae_id = CAST(ps_cod_act_2 AS integer)
  and ca_semana = 13;
UPDATE "MPP_CRONOGRAMA_ACT"
   SET ca_num_hora=CAST(ps_act2_sem14 AS integer)
 WHERE ae_id = CAST(ps_cod_act_2 AS integer)
  and ca_semana = 14;
UPDATE "MPP_CRONOGRAMA_ACT"
   SET ca_num_hora=CAST(ps_act2_sem15 AS integer)
 WHERE ae_id = CAST(ps_cod_act_2 AS integer)
  and ca_semana = 15;


UPDATE "MPP_CRONOGRAMA_ACT"
   SET ca_num_hora=CAST(ps_act3_sem1 AS integer)
 WHERE ae_id = CAST(ps_cod_act_3 AS integer)
  and ca_semana = 1;
  UPDATE "MPP_CRONOGRAMA_ACT"
   SET ca_num_hora=CAST(ps_act3_sem2 AS integer)
 WHERE ae_id = CAST(ps_cod_act_3 AS integer)
  and ca_semana = 2;
  UPDATE "MPP_CRONOGRAMA_ACT"
   SET ca_num_hora=CAST(ps_act3_sem3 AS integer)
 WHERE ae_id = CAST(ps_cod_act_3 AS integer)
  and ca_semana = 3;
  UPDATE "MPP_CRONOGRAMA_ACT"
   SET ca_num_hora=CAST(ps_act3_sem4 AS integer)
 WHERE ae_id = CAST(ps_cod_act_3 AS integer)
  and ca_semana = 4;
  UPDATE "MPP_CRONOGRAMA_ACT"
   SET ca_num_hora=CAST(ps_act3_sem5 AS integer)
 WHERE ae_id = CAST(ps_cod_act_3 AS integer)
  and ca_semana = 5;
UPDATE "MPP_CRONOGRAMA_ACT"
   SET ca_num_hora=CAST(ps_act3_sem6 AS integer)
 WHERE ae_id = CAST(ps_cod_act_3 AS integer)
  and ca_semana = 6;
UPDATE "MPP_CRONOGRAMA_ACT"
   SET ca_num_hora=CAST(ps_act3_sem7 AS integer)
 WHERE ae_id = CAST(ps_cod_act_3 AS integer)
  and ca_semana = 7;
UPDATE "MPP_CRONOGRAMA_ACT"
   SET ca_num_hora=CAST(ps_act3_sem8 AS integer)
 WHERE ae_id = CAST(ps_cod_act_3 AS integer)
  and ca_semana = 8;
  UPDATE "MPP_CRONOGRAMA_ACT"
   SET ca_num_hora=CAST(ps_act3_sem9 AS integer)
 WHERE ae_id = CAST(ps_cod_act_3 AS integer)
  and ca_semana = 9;
  UPDATE "MPP_CRONOGRAMA_ACT"
   SET ca_num_hora=CAST(ps_act3_sem10 AS integer)
 WHERE ae_id = CAST(ps_cod_act_3 AS integer)
  and ca_semana = 10;
  UPDATE "MPP_CRONOGRAMA_ACT"
   SET ca_num_hora=CAST(ps_act3_sem11 AS integer)
 WHERE ae_id = CAST(ps_cod_act_3 AS integer)
  and ca_semana = 11;
  UPDATE "MPP_CRONOGRAMA_ACT"
   SET ca_num_hora=CAST(ps_act3_sem12 AS integer)
 WHERE ae_id = CAST(ps_cod_act_3 AS integer)
  and ca_semana = 12;
UPDATE "MPP_CRONOGRAMA_ACT"
   SET ca_num_hora=CAST(ps_act3_sem13 AS integer)
 WHERE ae_id = CAST(ps_cod_act_3 AS integer)
  and ca_semana = 13;
UPDATE "MPP_CRONOGRAMA_ACT"
   SET ca_num_hora=CAST(ps_act3_sem14 AS integer)
 WHERE ae_id = CAST(ps_cod_act_3 AS integer)
  and ca_semana = 14;
UPDATE "MPP_CRONOGRAMA_ACT"
   SET ca_num_hora=CAST(ps_act3_sem15 AS integer)
 WHERE ae_id = CAST(ps_cod_act_3 AS integer)
  and ca_semana = 15;

UPDATE "MPP_CRONOGRAMA_ACT"
   SET ca_num_hora=CAST(ps_act4_sem1 AS integer)
 WHERE ae_id = CAST(ps_cod_act_4 AS integer)
  and ca_semana = 1;
  UPDATE "MPP_CRONOGRAMA_ACT"
   SET ca_num_hora=CAST(ps_act4_sem2 AS integer)
 WHERE ae_id = CAST(ps_cod_act_4 AS integer)
  and ca_semana = 2;
  UPDATE "MPP_CRONOGRAMA_ACT"
   SET ca_num_hora=CAST(ps_act4_sem3 AS integer)
 WHERE ae_id = CAST(ps_cod_act_4 AS integer)
  and ca_semana = 3;
  UPDATE "MPP_CRONOGRAMA_ACT"
   SET ca_num_hora=CAST(ps_act4_sem4 AS integer)
 WHERE ae_id = CAST(ps_cod_act_4 AS integer)
  and ca_semana = 4;
  UPDATE "MPP_CRONOGRAMA_ACT"
   SET ca_num_hora=CAST(ps_act4_sem5 AS integer)
 WHERE ae_id = CAST(ps_cod_act_4 AS integer)
  and ca_semana = 5;
UPDATE "MPP_CRONOGRAMA_ACT"
   SET ca_num_hora=CAST(ps_act4_sem6 AS integer)
 WHERE ae_id = CAST(ps_cod_act_4 AS integer)
  and ca_semana = 6;
UPDATE "MPP_CRONOGRAMA_ACT"
   SET ca_num_hora=CAST(ps_act4_sem7 AS integer)
 WHERE ae_id = CAST(ps_cod_act_4 AS integer)
  and ca_semana = 7;
UPDATE "MPP_CRONOGRAMA_ACT"
   SET ca_num_hora=CAST(ps_act4_sem8 AS integer)
 WHERE ae_id = CAST(ps_cod_act_4 AS integer)
  and ca_semana = 8;
  UPDATE "MPP_CRONOGRAMA_ACT"
   SET ca_num_hora=CAST(ps_act4_sem9 AS integer)
 WHERE ae_id = CAST(ps_cod_act_4 AS integer)
  and ca_semana = 9;
  UPDATE "MPP_CRONOGRAMA_ACT"
   SET ca_num_hora=CAST(ps_act4_sem10 AS integer)
 WHERE ae_id = CAST(ps_cod_act_4 AS integer)
  and ca_semana = 10;
  UPDATE "MPP_CRONOGRAMA_ACT"
   SET ca_num_hora=CAST(ps_act4_sem11 AS integer)
 WHERE ae_id = CAST(ps_cod_act_4 AS integer)
  and ca_semana = 11;
  UPDATE "MPP_CRONOGRAMA_ACT"
   SET ca_num_hora=CAST(ps_act4_sem12 AS integer)
 WHERE ae_id = CAST(ps_cod_act_4 AS integer)
  and ca_semana = 12;
UPDATE "MPP_CRONOGRAMA_ACT"
   SET ca_num_hora=CAST(ps_act4_sem13 AS integer)
 WHERE ae_id = CAST(ps_cod_act_4 AS integer)
  and ca_semana = 13;
UPDATE "MPP_CRONOGRAMA_ACT"
   SET ca_num_hora=CAST(ps_act4_sem14 AS integer)
 WHERE ae_id = CAST(ps_cod_act_4 AS integer)
  and ca_semana = 14;
UPDATE "MPP_CRONOGRAMA_ACT"
   SET ca_num_hora=CAST(ps_act4_sem15 AS integer)
 WHERE ae_id = CAST(ps_cod_act_4 AS integer)
  and ca_semana = 15;

UPDATE "MPP_CRONOGRAMA_ACT"
   SET ca_num_hora=CAST(ps_act5_sem1 AS integer)
 WHERE ae_id = CAST(ps_cod_act_5 AS integer)
  and ca_semana = 1;
  UPDATE "MPP_CRONOGRAMA_ACT"
   SET ca_num_hora=CAST(ps_act5_sem2 AS integer)
 WHERE ae_id = CAST(ps_cod_act_5 AS integer)
  and ca_semana = 2;
  UPDATE "MPP_CRONOGRAMA_ACT"
   SET ca_num_hora=CAST(ps_act5_sem3 AS integer)
 WHERE ae_id = CAST(ps_cod_act_5 AS integer)
  and ca_semana = 3;
  UPDATE "MPP_CRONOGRAMA_ACT"
   SET ca_num_hora=CAST(ps_act5_sem4 AS integer)
 WHERE ae_id = CAST(ps_cod_act_5 AS integer)
  and ca_semana = 4;
  UPDATE "MPP_CRONOGRAMA_ACT"
   SET ca_num_hora=CAST(ps_act5_sem5 AS integer)
 WHERE ae_id = CAST(ps_cod_act_5 AS integer)
  and ca_semana = 5;
UPDATE "MPP_CRONOGRAMA_ACT"
   SET ca_num_hora=CAST(ps_act5_sem6 AS integer)
 WHERE ae_id = CAST(ps_cod_act_5 AS integer)
  and ca_semana = 6;
UPDATE "MPP_CRONOGRAMA_ACT"
   SET ca_num_hora=CAST(ps_act5_sem7 AS integer)
 WHERE ae_id = CAST(ps_cod_act_5 AS integer)
  and ca_semana = 7;
UPDATE "MPP_CRONOGRAMA_ACT"
   SET ca_num_hora=CAST(ps_act5_sem8 AS integer)
 WHERE ae_id = CAST(ps_cod_act_5 AS integer)
  and ca_semana = 8;
  UPDATE "MPP_CRONOGRAMA_ACT"
   SET ca_num_hora=CAST(ps_act5_sem9 AS integer)
 WHERE ae_id = CAST(ps_cod_act_5 AS integer)
  and ca_semana = 9;
  UPDATE "MPP_CRONOGRAMA_ACT"
   SET ca_num_hora=CAST(ps_act5_sem10 AS integer)
 WHERE ae_id = CAST(ps_cod_act_5 AS integer)
  and ca_semana = 10;
  UPDATE "MPP_CRONOGRAMA_ACT"
   SET ca_num_hora=CAST(ps_act5_sem11 AS integer)
 WHERE ae_id = CAST(ps_cod_act_5 AS integer)
  and ca_semana = 11;
  UPDATE "MPP_CRONOGRAMA_ACT"
   SET ca_num_hora=CAST(ps_act5_sem12 AS integer)
 WHERE ae_id = CAST(ps_cod_act_5 AS integer)
  and ca_semana = 12;
UPDATE "MPP_CRONOGRAMA_ACT"
   SET ca_num_hora=CAST(ps_act5_sem13 AS integer)
 WHERE ae_id = CAST(ps_cod_act_5 AS integer)
  and ca_semana = 13;
UPDATE "MPP_CRONOGRAMA_ACT"
   SET ca_num_hora=CAST(ps_act5_sem14 AS integer)
 WHERE ae_id = CAST(ps_cod_act_5 AS integer)
  and ca_semana = 14;
UPDATE "MPP_CRONOGRAMA_ACT"
   SET ca_num_hora=CAST(ps_act5_sem15 AS integer)
 WHERE ae_id = CAST(ps_cod_act_5 AS integer)
  and ca_semana = 15;

UPDATE "MPP_CRONOGRAMA_ACT"
   SET ca_num_hora=CAST(ps_act6_sem1 AS integer)
 WHERE ae_id = CAST(ps_cod_act_6 AS integer)
  and ca_semana = 1;
  UPDATE "MPP_CRONOGRAMA_ACT"
   SET ca_num_hora=CAST(ps_act6_sem2 AS integer)
 WHERE ae_id = CAST(ps_cod_act_6 AS integer)
  and ca_semana = 2;
  UPDATE "MPP_CRONOGRAMA_ACT"
   SET ca_num_hora=CAST(ps_act6_sem3 AS integer)
 WHERE ae_id = CAST(ps_cod_act_6 AS integer)
  and ca_semana = 3;
  UPDATE "MPP_CRONOGRAMA_ACT"
   SET ca_num_hora=CAST(ps_act6_sem4 AS integer)
 WHERE ae_id = CAST(ps_cod_act_6 AS integer)
  and ca_semana = 4;
  UPDATE "MPP_CRONOGRAMA_ACT"
   SET ca_num_hora=CAST(ps_act6_sem5 AS integer)
 WHERE ae_id = CAST(ps_cod_act_6 AS integer)
  and ca_semana = 5;
UPDATE "MPP_CRONOGRAMA_ACT"
   SET ca_num_hora=CAST(ps_act6_sem6 AS integer)
 WHERE ae_id = CAST(ps_cod_act_6 AS integer)
  and ca_semana = 6;
UPDATE "MPP_CRONOGRAMA_ACT"
   SET ca_num_hora=CAST(ps_act6_sem7 AS integer)
 WHERE ae_id = CAST(ps_cod_act_6 AS integer)
  and ca_semana = 7;
UPDATE "MPP_CRONOGRAMA_ACT"
   SET ca_num_hora=CAST(ps_act6_sem8 AS integer)
 WHERE ae_id = CAST(ps_cod_act_6 AS integer)
  and ca_semana = 8;
  UPDATE "MPP_CRONOGRAMA_ACT"
   SET ca_num_hora=CAST(ps_act6_sem9 AS integer)
 WHERE ae_id = CAST(ps_cod_act_6 AS integer)
  and ca_semana = 9;
  UPDATE "MPP_CRONOGRAMA_ACT"
   SET ca_num_hora=CAST(ps_act6_sem10 AS integer)
 WHERE ae_id = CAST(ps_cod_act_6 AS integer)
  and ca_semana = 10;
  UPDATE "MPP_CRONOGRAMA_ACT"
   SET ca_num_hora=CAST(ps_act6_sem11 AS integer)
 WHERE ae_id = CAST(ps_cod_act_6 AS integer)
  and ca_semana = 11;
  UPDATE "MPP_CRONOGRAMA_ACT"
   SET ca_num_hora=CAST(ps_act6_sem12 AS integer)
 WHERE ae_id = CAST(ps_cod_act_6 AS integer)
  and ca_semana = 12;
UPDATE "MPP_CRONOGRAMA_ACT"
   SET ca_num_hora=CAST(ps_act6_sem13 AS integer)
 WHERE ae_id = CAST(ps_cod_act_6 AS integer)
  and ca_semana = 13;
UPDATE "MPP_CRONOGRAMA_ACT"
   SET ca_num_hora=CAST(ps_act6_sem14 AS integer)
 WHERE ae_id = CAST(ps_cod_act_6 AS integer)
  and ca_semana = 14;
UPDATE "MPP_CRONOGRAMA_ACT"
   SET ca_num_hora=CAST(ps_act6_sem15 AS integer)
 WHERE ae_id = CAST(ps_cod_act_6 AS integer)
  and ca_semana = 15;

end if;

resultado:= 'SI';
	RETURN resultado;
EXCEPTION
WHEN OTHERS THEN
resultado:=sqlerrm;
RETURN resultado;
END;
$BODY$
  LANGUAGE plpgsql VOLATILE
  COST 100;
