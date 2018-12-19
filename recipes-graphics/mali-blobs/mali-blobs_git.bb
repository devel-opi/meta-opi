SUMMARY = "Mali-400 userspace blobs"
LICENSE = "CLOSED"

PROVIDES = "virtual/egl virtual/libegl virtual/libgles1 virtual/libgles2 virtual/libgbm"
DEPENDS = "${@bb.utils.contains("DISTRO_FEATURES", "x11", " virtual/libx11 libxext libdrm libxfixes libxdamage", " ", d)}"
DEPENDS += "${@bb.utils.contains("DISTRO_FEATURES", "wayland", " wayland", " ", d)}"

RPROVIDES_${PN} = "libegl"

INSANE_SKIP_${PN} = "dev-so"

INHIBIT_PACKAGE_STRIP = "1"

SRC_URI = " \
  git://github.com/free-electrons/mali-blobs.git;branch=master \
  file://wayland-egl.pc \
  file://egl.pc \
  file://gbm.pc \
  file://glesv1_cm.pc \
  file://glesv2.pc \
"

PV = "r6p2+git${SRCPV}"

SRCREV = "418f55585e76f375792dbebb3e97532f0c1c556d"

S= "${WORKDIR}/git"

do_install() {
  install -d ${D}${libdir}
#  cp -m 0644 ${S}/r6p2/arm/wayland/lib* ${D}${libdir}
  cp -P ${S}/r6p2/arm/wayland/lib* ${D}${libdir}

  install -d ${D}${libdir}/pkgconfig
  install -m 0644 ${WORKDIR}/*.pc ${D}${libdir}/pkgconfig/

  install -d ${D}${includedir}/EGL
  install -d ${D}${includedir}/GLES
  install -d ${D}${includedir}/GLES2
  install -d ${D}${includedir}/KHR

  install -m 0644 ${S}/include/wayland/EGL/* ${D}${includedir}/EGL/
  install -m 0644 ${S}/include/wayland/GLES/* ${D}${includedir}/GLES/
  install -m 0644 ${S}/include/wayland/GLES2/* ${D}${includedir}/GLES2/
  install -m 0644 ${S}/include/wayland/KHR/* ${D}${includedir}/KHR/
  install -m 0644 ${S}/include/wayland/gbm.h ${D}${includedir}/
}

FILES_${PN} = "${libdir}/*"
FILES_${PN}-dev = "${includedir}/*"

PACKAGE_ARCH_$MACHINE = "${SOC_FAMILY_PKGARCH}"
