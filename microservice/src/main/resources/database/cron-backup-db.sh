#!/bin/bash

HOST="localhost"
DB="db_thelibrary"
USER="admin_thelibrary"
PGPASSWORD="123"
DATE=`date +%Y%m%d`
FILENAME="/opt/db_backup/${DB}_${DATE}.sql"
# -E UTF-8
PGPASSWORD=${PGPASSWORD} pg_dump -Fc -U ${USER} -h ${HOST} ${DB} > ${FILENAME}
#gzip ${FILENAME}
