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

To get the BSP you need to have repo installed and use it as:

1. Install the repo utility:
```
$: mkdir ~/bin
$: curl http://commondatastorage.googleapis.com/git-repo-downloads/repo > ~/bin/repo
$: chmod a+x ~/bin/repo
```

2. Download the BSP source:

```
$: PATH=${PATH}:~/bin
$: mkdir chip-bsp
$: cd chip-bsp
$: repo init -u https://github.com/texierp/yocto-chip-bsp -b master
$: repo sync
```

At the end of the commands you have every metadata you need to start work with.

To start a simple image build :

```
$: cd sources
$: export TEMPLATECONF="$PWD/meta-chip/conf"
$: source poky/oe-init-build-env chip-build

### Shell environment set up for builds. ###

You can now run 'bitbake <target>'

Common targets are:
    chip-hwup-image
    meta-toolchain-qt5

You can also run generated qemu images with a command like 'runqemu qemuarm'
   ____   _   _   ___   ____  
  / ___| | | | | |_ _| |  _ \ 
 | |     | |_| |  | |  | |_) |
 | |___ _|  _  |_ | | _|  __/ 
  \____(_)_| |_(_)___(_)_|       
``` 
```  
$: MACHINE=chip bitbake chip-hwup-image
```

### 2. Flashing a C.H.I.P. board

1. Clone SDK :
```
$: cd SDK/CHIP-SDK
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



