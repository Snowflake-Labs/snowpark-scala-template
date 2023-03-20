
!variables;

CREATE STAGE IF NOT EXISTS artifacts;

PUT file://&artifact_name @artifacts AUTO_COMPRESS=FALSE OVERWRITE=TRUE;

CREATE OR REPLACE PROCEDURE HELLO_WORLD_PROC()
  RETURNS NUMBER
  LANGUAGE SCALA
  RUNTIME_VERSION = '2.12'
  IMPORTS = ('@artifacts/&artifact_name')
  HANDLER = 'org.example.procedure.App.run';

