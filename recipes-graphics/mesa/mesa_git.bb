require ${BPN}.inc

SRC_URI = "git://gitlab.freedesktop.org/mesa/mesa.git \
           file://0001-meson.build-check-for-all-linux-host_os-combinations.patch"

SRCREV = "0325860e90f928b7022edfe2d0355cbf0c496463"

S = "${WORKDIR}/git"

#because we cannot rely on the fact that all apps will use pkgconfig,
#make eglplatform.h independent of MESA_EGL_NO_X11_HEADER
do_install_append() {
    if ${@bb.utils.contains('PACKAGECONFIG', 'egl', 'true', 'false', d)}; then
        sed -i -e 's/^#if defined(MESA_EGL_NO_X11_HEADERS)$/#if defined(MESA_EGL_NO_X11_HEADERS) || ${@bb.utils.contains('PACKAGECONFIG', 'x11', '0', '1', d)}/' ${D}${includedir}/EGL/eglplatform.h
    fi
}
