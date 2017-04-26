require recipes-bsp/u-boot/u-boot.inc

DESCRIPTION = "U-Boot port for C.H.I.P. boards"

LIC_FILES_CHKSUM = "file://Licenses/README;md5=0507cd7da8e7ad6d6701926ec9b84c95"

DEPENDS += "dtc-native"
PROVIDES += "u-boot"

UBOOT_VERSION ?= "2016.01"
PV = "${UBOOT_VERSION}+git${SRCPV}"

SRCREV_chip ?= "ccd1de00d52ef6b09a2d0990d1bd9254ecc18f88"
SRCREV_chippro ?= "c2d284fbba74083eed8ae853a10f665f6febfdf1"

BRANCH_chip ?= "production-mlc"
BRANCH_chippro = "nextthing/2016.01/next"

SRC_URI = "git://github.com/NextThingCo/CHIP-u-boot.git;branch=${BRANCH}"
S = "${WORKDIR}/git"

do_deploy_append() {
    install ${B}/spl/sunxi-spl-with-ecc.bin ${DEPLOYDIR}/sunxi-spl-with-ecc.bin
}

COMPATIBLE_MACHINE = "(chip|chippro)"

