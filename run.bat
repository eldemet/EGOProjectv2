@echo off
echo Compiling...
if not exist bin mkdir bin
javac -d bin -sourcepath src src\egoproject\*.java
if %errorlevel% neq 0 (
    echo Compilation failed.
    pause
    exit /b %errorlevel%
)
echo Launching game...
java -cp "bin;res" egoproject.Game
pause
