@CHCP 65001 > NUL
@ECHO OFF

REM Rev. 20221220000

SET nombre=DrumFest24-MVC

SET oldpath=%PATH%
SET PATH=c:\java\doxygen;c:\java\graphviz;%PATH%
SET CLASSPATH=bin
SET JAVA_TOOL_OPTIONS=-Dfile.encoding=UTF-8

ECHO %nombre%
ECHO ---
ECHO.

doxygen Doxyfile 2> doxumentar.log

ECHO.
DIR dox

ECHO.
ECHO No documentados: revisar el archivo «doxumentar.log»…
findstr /r /c:"not.*documented" < doxumentar.log | find /c "warning"

:FIN
ECHO.
SET PATH=%oldpath%
PAUSE
