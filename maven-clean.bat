@echo off

CD /D %~dp0

mvn clean eclipse:clean

pause
