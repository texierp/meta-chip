DESCRIPTION         = "rtl8723ss MP SDIO WiFi Driver"
LICENSE             = "GPLv2"
LIC_FILES_CHKSUM    = "file://core/rtw_bt_mp.c;md5=05099f911f5c256187a1236fe262ea34"
COMPATIBLE_MACHINE  = "(chippro)"
S                   = "${WORKDIR}/git"

inherit module update-rc.d

SRC_URI = " \
    git://github.com/nextthingco/rtl8723ds.git;protocol=git; \
    file://0001-rtl8723ds-add-modules_install-and-correct-depmod.patch \
    file://wifi.init \
"

SRCREV = "0d60107a4c0bdedf8cf7858f717226028501e6b5"

# Custom Make options
RTL8723DS_MAKE_FLAGS += " \
    -DCONFIG_IOCTL_CFG80211 \
    -DRTW_USE_CFG80211_STA_EVENT \
    -DCONFIG_CONCURRENT_MODE \
    -DCONFIG_AUTO_AP_MODE \
    -DCONFIG_MP_INCLUDED \
    -DCONFIG_WIFI_MONITOR \
"

EXTRA_OEMAKE += " \
    USER_EXTRA_CFLAGS='${RTL8723DS_MAKE_FLAGS}' \
    KSRC=${STAGING_KERNEL_DIR} \
    PREFIX=${D} \
"

do_install_append() {
	install -d ${D}${sysconfdir}/init.d/
	
        install -m 0755 ${WORKDIR}/wifi.init ${D}${sysconfdir}/init.d/wifi
}

FILES_${PN} += "${sysconfdir}/init.d/"

INITSCRIPT_NAME = "wifi"
INITSCRIPT_PARAMS = "start 20 5 2 . stop 19 0 1 6 ."
