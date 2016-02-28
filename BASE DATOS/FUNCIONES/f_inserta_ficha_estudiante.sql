-- Function: f_inserta_ficha_est(text, text, text, text, text, text, text, text, text)

-- DROP FUNCTION f_inserta_ficha_est(text, text, text, text, text, text, text, text, text);

CREATE OR REPLACE FUNCTION f_inserta_ficha_est(
    ps_nombre_proy text,
    ps_twitter text,
    ps_facebook text,
    ps_linked_in text,
    ps_cc_id text,
    ps_tipo_doc text,
    ps_direccion text,
    ps_cod_proy text,
    ps_accion text)
  RETURNS text AS
$BODY$
DECLARE
   resultado text:= 'NO' ;
   cod_proy integer;
   
BEGIN

if ps_accion = 'I' then

if ps_cod_proy = '0' then
INSERT INTO "MPP_FICHA_ESTUDIANTE"(
             fe_nombre_proyecto, fe_twitter, fe_facebook, fe_linked_in, 
            cc_id, fe_tipo_documento, fe_direccion)
    VALUES (ps_nombre_proy, ps_twitter,ps_facebook, ps_linked_in, 
            ps_cc_id, ps_tipo_doc, ps_direccion);

else
INSERT INTO "MPP_FICHA_ESTUDIANTE"(
             fe_nombre_proyecto, fe_twitter, fe_facebook, fe_linked_in, 
            cc_id, fe_tipo_documento, fe_direccion, pr_id)
    VALUES (ps_nombre_proy, ps_twitter,ps_facebook, ps_linked_in, 
            ps_cc_id, ps_tipo_doc, ps_direccion, CAST(coalesce(ps_cod_proy, '0') AS integer));
end if;

elsif ps_accion = 'M' THEN

UPDATE "MPP_FICHA_ESTUDIANTE" set fe_twitter = ps_twitter, fe_facebook=ps_facebook, fe_linked_in=ps_linked_in, fe_direccion=ps_direccion
WHERE trim(cc_id) = trim(ps_cc_id);


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
ALTER FUNCTION f_inserta_ficha_est(text, text, text, text, text, text, text, text, text)
  OWNER TO postgres;
