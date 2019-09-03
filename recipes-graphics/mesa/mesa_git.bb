require ${BPN}.inc

SRC_URI = "git://gitlab.freedesktop.org/roman.stratiienko/mesa.git;branch=staging/android-q \
           file://0001-meson.build-check-for-all-linux-host_os-combinations.patch"

SRCREV = "0249d0611d79250804a493597e29848deefd9eea"

S = "${WORKDIR}/git"

#because we cannot rely on the fact that all apps will use pkgconfig,
#make eglplatform.h independent of MESA_EGL_NO_X11_HEADER
do_install_append() {
    if ${@bb.utils.contains('PACKAGECONFIG', 'egl', 'true', 'false', d)}; then
        sed -i -e 's/^#if defined(MESA_EGL_NO_X11_HEADERS)$/#if defined(MESA_EGL_NO_X11_HEADERS) || ${@bb.utils.contains('PACKAGECONFIG', 'x11', '0', '1', d)}/' ${D}${includedir}/EGL/eglplatform.h
    fi
}
