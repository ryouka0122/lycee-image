@echo off

cd /d %~dp0

mvn eclipse:clean eclipse:eclipse

pause
