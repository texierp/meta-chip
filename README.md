# meta-chip

This README file contains information on building the meta-chip BSP layer.
Please see the corresponding sections below for details.

[![Gitter chat](https://badges.gitter.im/gitterHQ/gitter.png)](https://gitter.im/meta-chip/Lobby)


## Contents
```
1. Building the meta-chip BSP layer
2. Flashing a C.H.I.P. board
```

### 1. Building the meta-chip BSP layer

To build a machine supported by this BSP layer follow the next steps:

1. source poky/oe-init-build-env chip-build
2. Add needed layer to bblayers.conf:
    - meta-chip
3. Set MACHINE in local.conf to one of the supported boards
    - chip
    - chippro
4. bitbake chip-hwup-image

### 2. Flashing a C.H.I.P. board

1. Clone SDK :
```
$: git clone https://github.com/NextThingCo/CHIP-SDK.git
$: cd CHIP-SDK
$ ./setup_ubuntu1404.sh
```

2. NAND Image creation :	
```
$: ./chip-create-nand-images.sh <patch to>/chip-build/tmp/work/chip-poky-linux-gnueabi/u-boot-chip/2016.01*/git <patch to>/chip-build/tmp/deploy/images/chip/<image>.tar my-chip-image 
```

3. Flashing (Fastboot) :
```
$: sudo chown -R username:username my-chip-image/ 
$: sudo ./chip-flash-nand-images.sh my-chip-image/ 
```



