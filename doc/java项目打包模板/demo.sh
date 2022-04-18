#!/bin/bash
##JVM OPTIONS -Xms -Xmx config
JAVA_OPTIONS_MIN="-Xms4096M"
JAVA_OPTIONS_MAX="-Xmx4096M"
APP_OPTIONS_CONFIG="-Dspring.config.location=config/ -Dlogging.file.path=logs/"

##application name
APP_NAME=`basename $0 .sh`

##application home dir
APP_HOME=$(dirname $(dirname $(readlink -f "$0")))

##jar文件
APP_JAR_NAME=`ls $APP_HOME|grep -v grep|grep -v patch|grep $APP_NAME.*\.jar|sort -r|sed -n '1p'`

##查询应用进程pid命令
PID=$(ps aux | grep ${APP_JAR_NAME} | grep -v grep | awk '{print $2}' )

##检查进程是否被启动方法
function check_if_process_is_running {
 if [ "$PID" = "" ]; then
 return 1
 fi
 ps -p $PID | grep "java"
 return $?
}
case "$1" in
 status)
 if check_if_process_is_running
 then
 echo -e "\033[32m $APP_NAME is running \033[0m"
 else
 echo -e "\033[32m $APP_NAME not running \033[0m"
 fi
 ;;
 stop)
 if ! check_if_process_is_running
 then
 echo -e "\033[32m $APP_NAME already stopped \033[0m"
 exit 0
 fi
 kill -9 $PID
 echo -e "\033[32m Waiting for process to stop \033[0m"
 NOT_KILLED=1
 for i in {1..20}; do
 if check_if_process_is_running
 then
 echo -ne "\033[32m . \033[0m"
 sleep 1
 else
 NOT_KILLED=0
 fi
 done
 echo
 if [ $NOT_KILLED = 1 ]
 then
 echo -e "\033[32m Cannot kill process \033[0m"
 exit 1
 fi
 echo -e "\033[32m $APP_NAME already stopped \033[0m"
 ;;
 start)
 if [ "$PID" != "" ] && check_if_process_is_running
 then
 echo -e "\033[32m $APP_NAME already running \033[0m"
 exit 1
 fi
 echo "Jump dir $APP_HOME"
 cd $APP_HOME
 echo "Execute shell cmd"
 nohup java -jar $JAVA_OPTIONS_MIN $JAVA_OPTIONS_MAX $APP_OPTIONS_CONFIG "./"$APP_JAR_NAME > "./"$APP_NAME".out" 2>&1 &
 echo -ne "\033[32m Starting \033[0m"
 for i in {1..20}; do
 echo -ne "\033[32m.\033[0m"
 sleep 1
 done
 if check_if_process_is_running
 then
 echo -e "\033[32m $APP_NAME fail \033[0m"
 else
 echo -e "\033[32m $APP_NAME started \033[0m"
 fi
 ;;
 restart)
 $0 stop
 if [ $? = 1 ]
 then
 exit 1
 fi
 $0 start
 ;;
 *)
 echo "Usage: `basename $0` {start|stop|restart|status}"
 exit 1
esac
exit 0
