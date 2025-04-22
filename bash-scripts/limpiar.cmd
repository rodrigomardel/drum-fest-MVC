@CHCP 65001 > NUL
@ECHO OFF

REM Rev. 20221220000

SET nombre=Borrando bin + doc + dox + dist

ECHO %nombre%
ECHO ---
ECHO.

FOR %%d IN (bin,doc,dox,dist) DO (
	IF EXIST %%d (
		RMDIR /S /Q %%d
		ECHO Borrado %%d
	)
)

:FIN
ECHO.
PAUSE
