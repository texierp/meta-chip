SUMMARY = "A series of scripts for communicating with the axp209 power unit "

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.GPLv2;md5=751419260aa954499f7abaabaa882bbe"

SRC_URI = " \ 
	file://axp209 \
	"
	
PACKAGE_ARCH = "${MACHINE_ARCH}"

do_install() {
	install -d ${D}${bindir}
	install -d ${D}${sysconfdir}/init.d

        install -m 0755 ${WORKDIR}/axp209 ${D}${bindir}
}
