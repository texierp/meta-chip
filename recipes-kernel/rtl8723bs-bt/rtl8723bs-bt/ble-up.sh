#!/bin/sh

/sbin/rtk_hciattach -n -s 115200 /dev/ttyS1 rtk_h5 2>&1 | logger -t rtk_hciattach &
hciconfig hci0 up
hciconfig hci0 name 'My C.H.I.P'
hciconfig hci0 piscan
