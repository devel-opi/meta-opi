SUMMARY = "Mali-400 driver"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${S}/linux/license/gpl/mali_kernel_license.h;endline=9;md5=70163d3e370c9ce11ea3e6ace1e19481"

inherit module

PV = "r6p2+git${SRCPV}"

SRCREV = "46e10b12945cb9b06d336a0210590168db42bbdf"

SRC_URI = "git://github.com/mripard/sunxi-mali.git;protocol=git"

S = "${WORKDIR}/git/r6p2/src/devicedrv/mali"

do_patch() {
  cd ${WORKDIR}/git/r6p2/

  quilt push -a
}

MODULES_INSTALL_TARGET = "install"

EXTRA_OEMAKE_orange-pi-pc-plus = "USING_UMP=0 BUILD=release USING_PROFILING=0 MALI_PLATFORM=sunxi USING_DVFS=0 USING_DEVFREQ=0 KDIR=${STAGING_KERNEL_BUILDDIR}"
EXTRA_OEMAKE_orange-pi-pc = "USING_UMP=0 BUILD=release USING_PROFILING=0 MALI_PLATFORM=sunxi USING_DVFS=1 USING_DEVFREQ=1 KDIR=${STAGING_KERNEL_BUILDDIR}"
EXTRA_OEMAKE_orange-pi-one = "USING_UMP=0 BUILD=release USING_PROFILING=0 MALI_PLATFORM=sunxi USING_DVFS=1 USING_DEVFREQ=1 KDIR=${STAGING_KERNEL_BUILDDIR}"
