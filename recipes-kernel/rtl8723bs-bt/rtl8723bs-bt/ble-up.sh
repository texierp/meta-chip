#!/bin/sh

/usr/bin/rtk_hciattach -n -s 115200 /dev/ttyS1 rtk_h5 2>&1 | logger -t rtk_hciattach &
sleep 3
hciconfig hci0 up
sleep 3
hciconfig hci0 name 'C.H.I.P Powered By Yocto'
sleep 3
hciconfig hci0 piscan
