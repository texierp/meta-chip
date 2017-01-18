SUMMARY = "BS realtek BT"
# /sbin/rtk_hciattach -n -s 115200 $TTY_RTL8732BS rtk_h5 2>&1 | logger -t rtk_hciattach &


LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://hci_h4.c;beginline=5;endline=22;md5=d6e1c32aaea6d005ca63b785763df568"

SRCREV = "6f0add337eb8154ed3b1501bd62287416a4b2339"
SRC_URI = "git://github.com/NextThingCo/rtl8723bs_bt.git;protocol=https;branch=debian \
	   file://0001-Remove-CC.patch \
          "

S = "${WORKDIR}/git"

do_compile() {
	oe_runmake
}

do_install() {
	install -d ${D}/lib/firmware/rtl_bt
	install -d ${D}/sbin
	
        install -m0644 ${S}/rtlbt_* ${D}/lib/firmware/rtl_bt
        
        install -m0755 ${S}/rtk_hciattach ${D}/sbin
}

FILES_${PN} += "/lib/firmware"
