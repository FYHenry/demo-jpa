#!/bin/bash
cd ${ROOT_DIR}/src/main/tools/ || exit 1
/usr/bin/mariadb --table < init.sql > init.tab
#cd ${ROOT_DIR}/src/main/tools/ ||
#  exit 1
#/usr/bin/mariadb --table < init_banque.sql > init_banque.tab