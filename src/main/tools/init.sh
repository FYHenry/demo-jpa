#!/bin/bash
cd ${HOME}/Git/FYHenry/demo-jpa/src/main/tools/ || exit 1
/usr/bin/mariadb --table < init.sql > init.tab
