SECTION = "kernel"
DESCRIPTION = "Mainline Linux kernel"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=bbea815ee2795b2f4230826c0c6b8814"
COMPATIBLE_MACHINE = "(sun4i|sun5i|sun7i|sun8i|sun50i)"

inherit kernel

require linux.inc

# Since we're not using git, this doesn't make a difference, but we need to fill
# in something or kernel-yocto.bbclass will fail.
KBRANCH ?= "master"

# Pull in the devicetree files into the rootfs
RDEPENDS_${KERNEL_PACKAGE_NAME}-base += "kernel-devicetree"

KERNEL_EXTRA_ARGS += "LOADADDR=${UBOOT_ENTRYPOINT}"

S = "${WORKDIR}/linux-${PV}"
	
SRC_URI[md5sum] = "d39dd4ba2d5861c54b90d49be19eaf31"

SRC_URI = "https://cdn.kernel.org/pub/linux/kernel/v4.x/linux-${PV}.tar.xz \
	file://0003-ARM-dts-nanopi-neo-air-Add-WiFi-eMMC.patch \
	file://0001-Squashed-sunxi-VPU-driver-from-bootlin-github-reposi.patch \
	file://defconfig \
        "

#KBUILD_DEFCONFIG_orange-pi-one = "sunxi_defconfig"
