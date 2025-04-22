@CHCP 65001 > NUL
@ECHO OFF

REM Rev. 20221220000

SET nombre=DrumFest24-MVC
SET nombrepaquete=jcolonia.daw2024.rmd.drumfest
SET junit5lib=junit-platform-console-standalone-1.10.2.jar

SET oldpath=%PATH%
SET PATH=c:\java\jdk21\bin;%PATH%
SET CLASSPATH=bin
SET JAVA_TOOL_OPTIONS=-Dfile.encoding=UTF-8

ECHO %nombrepaquete%.%nombre%
ECHO ---
ECHO.

java -jar lib\%junit5lib% ^
	-cp bin ^
	--select-package %nombrepaquete% ^
	--include-classname .*Test.*

:FIN
ECHO.
SET PATH=%oldpath%
PAUSE
