SUMMARY = "A standalone tool to test the Linux Video4Linux2 Request API"
LICENSE = "LGPL-2.1"
LIC_FILES_CHKSUM="file://README;md5=3bbda33c326bb4ff869ef408ea70911e"

DEPENDS = "libdrm"

PV = "git${SRCPV}"
S = "${WORKDIR}/git"

SRCREV = "cc1e56721dbf31069d863d5a3e81012d8af47922"

SRC_URI = "git://github.com/bootlin/v4l2-request-test.git;branch=master"

inherit lib_package pkgconfig

CFLAGS += "-D_GNU_SOURCE"
# Override SYSTEM (via PACKAGECONFIG_CONFARGS) to avoid calling config.guess,
# we're cross-compiling. Pass our CFLAGS via POPT as that's the optimisation
# variable and safely overwritten.
EXTRA_OEMAKE = "${PACKAGECONFIG_CONFARGS} \
                CC='${CC}' LD='${CC}' STRIP='' \
                LDFLAGS.EXTRA='${LDFLAGS}' \
                POPT='${CFLAGS}' \
                GLEW_PREFIX='${prefix}' BINDIR='${bindir}' \
                LIBDIR='${libdir}' PKGDIR='${libdir}/pkgconfig'"

do_compile() {
	oe_runmake
}

do_install() {
	install -d ${D}${bindir} ${D}${datadir}/v4l2-request-test/data
	install -m 755 ${S}/v4l2-request-test ${D}${datadir}/v4l2-request-test
	cp -R ${S}/data/* ${D}${datadir}/v4l2-request-test/data
}
