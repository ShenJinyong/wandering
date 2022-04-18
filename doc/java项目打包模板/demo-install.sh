#!/bin/bash

SERVICE_NAME=`basename $0 -install.sh`
BASE_DIR=~
TGZ_DIR=${BASE_DIR}/devops/tgz
BACKUP_DIR=${BASE_DIR}/devops/backup
TGZ_FILE=`ls $TGZ_DIR|grep -v grep|grep -v patch|grep -w "$SERVICE_NAME"|sort -r|sed -n '1p'`

sudo rm -f /etc/systemd/system/multi-user.target.wants/${SERVICE_NAME}.service
sudo rm -f /usr/lib/systemd/system/${SERVICE_NAME}.service
sudo systemctl daemon-reload

pids=$(ps -ef|grep -v -E "grep|$0"|grep $SERVICE_NAME| awk '{print $2}')
for pid in $pids
do
    echo "kill -9 $pid"
    sudo kill -9 $pid
done


if [ -d ${BASE_DIR}/${SERVICE_NAME}/ ];then
    TODAY=`date "+%Y%m%d"`
    if [ ! -d ${BACKUP_DIR}/${TODAY}/${SERVICE_NAME}/ ];then
        mkdir -p ${BACKUP_DIR}/${TODAY}/
        sudo mv ${BASE_DIR}/${SERVICE_NAME}/ ${BACKUP_DIR}/${TODAY}/
    fi
fi

which java > /dev/null 2>&1
if [ ! $? -eq 0 ];then
    echo "未安装java，请先安装java"
    exit
fi

if [ ! $TGZ_FILE ];then
    echo "找不到安装包"
    exit
fi

tar zxf ${TGZ_DIR}/$TGZ_FILE -C $BASE_DIR

APP_HOME=${BASE_DIR}/${SERVICE_NAME}
APP_BIN=$APP_HOME/bin/${SERVICE_NAME}.sh

echo 'generate service'
echo "[Unit]
Description=$SERVICE_NAME.service
[Service]
StandardOutput=null
Type=forking
User=$USER
ExecStart=/bin/bash $APP_BIN start
ExecStop=/bin/bash $APP_BIN stop
Restart=always
RestartPreventExitStatus=0
RestartSec=20
[Install]
WantedBy=multi-user.target" | sudo tee /usr/lib/systemd/system/$SERVICE_NAME.service

sudo systemctl daemon-reload
sudo systemctl enable $SERVICE_NAME

echo 'start service'
sudo systemctl start $SERVICE_NAME
sudo systemctl status $SERVICE_NAME