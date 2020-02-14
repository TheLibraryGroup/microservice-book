#!/bin/bash

DB="db_thelibrary"
DATE=`date +%Y%m%d`
CONT_PATH="/opt/db_backup/${DB}_${DATE}.sql"
CONT_NAME="cont-db-thelibrary"
DESTINATION="/opt/thelibrary/${DB}_${DATE}.sql"
# -E UTF-8
docker cp ${CONT_NAME}:${CONT_PATH} ${DESTINATION}
