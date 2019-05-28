SUMMARY = "LibVA implementation for the Linux Video4Linux2 Request API"
LICENSE = "LGPL-2.1|MIT"
LIC_FILES_CHKSUM="\
    file://COPYING;md5=a1e2dca59574fd1939ef9d63e2b58249\
    file://COPYING.LGPL;md5=4fbd65380cdd255951079008b364516c\
    file://COPYING.MIT;md5=0fdfbe4b63f3b713a3427cec241e05a4\
    "

inherit autotools pkgconfig

PV = "git${SRCPV}"

DEPENDS = "libva libdrm"

SRCREV = "7f359be748a755b1250f42d3ff6f5729c01bc85a"

SRC_URI = "git://github.com/bootlin/libva-v4l2-request.git;branch=master \
	file://libva-v4l2-request-env.sh \
	"

S = "${WORKDIR}/git"

do_install_append() {
	install -d ${D}${sysconfdir}/profile.d
	install -m 0755 ${WORKDIR}/libva-v4l2-request-env.sh ${D}${sysconfdir}/profile.d
}

CFLAGS += " -I${S}/include"

FILES_${PN} = "${libdir}/* ${sysconfdir}/*"
FILES_${PN}-dev = "${includedir}/*"
