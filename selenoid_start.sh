#!/bin/bash
echo "==============================> Pulling Chrome"
sudo docker pull selenoid/vnc_chrome:89.0
echo "==============================> Pulling Firefox"
sudo docker pull selenoid/vnc_firefox:87.0
echo "Starting Selenoid Service ... "
sudo docker-compose up --force-recreate -d