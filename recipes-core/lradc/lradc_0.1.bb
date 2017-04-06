SUMMARY = "lradc script "

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.GPLv2;md5=751419260aa954499f7abaabaa882bbe"

SRC_URI = " \ 
	file://lradc \
	"
	
PACKAGE_ARCH = "${MACHINE_ARCH}"

do_install() {
	install -d ${D}${bindir}

        install -m 0755 ${WORKDIR}/lradc ${D}${bindir}
}

