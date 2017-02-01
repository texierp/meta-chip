SUMMARY = "A series of scripts for communicating with the axp209 power unit "

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.GPLv2;md5=751419260aa954499f7abaabaa882bbe"

SRC_URI = " \ 
	file://axp209 \
	file://enable-no-limit \
	file://axp209.init \
	"
	
PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit update-rc.d

do_install() {
	install -d ${D}${bindir}
	install -d ${D}${sysconfdir}/init.d

        install -m 0755 ${WORKDIR}/axp209 ${D}${bindir}
        install -m 0755 ${WORKDIR}/enable-no-limit ${D}${bindir}
        install -m 0755 ${WORKDIR}/axp209.init ${D}${sysconfdir}/init.d/axp209
}

INITSCRIPT_NAME = "axp209"
INITSCRIPT_PARAMS = "start 99 S ."
