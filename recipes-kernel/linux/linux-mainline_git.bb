SECTION = "kernel"
DESCRIPTION = "Mainline Linux kernel"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=bbea815ee2795b2f4230826c0c6b8814"
COMPATIBLE_MACHINE = "(sun4i|sun5i|sun7i|sun8i|sun50i)"

inherit kernel

# Since we're not using git, this doesn't make a difference, but we need to fill
# in something or kernel-yocto.bbclass will fail.
KBRANCH ?= "master"

# Pull in the devicetree files into the rootfs
RDEPENDS_${KERNEL_PACKAGE_NAME}-base += "kernel-devicetree"

KERNEL_EXTRA_ARGS += "LOADADDR=${UBOOT_ENTRYPOINT}"

S = "${WORKDIR}/git"

SRC_URI = " \
    git://git.kernel.org/pub/scm/linux/kernel/git/torvalds/linux.git;branch=master \
    file://sunxi-append.cfg \
    file://armbian-orange.cfg \
    "

SRCREV = "e21a712a9685488f5ce80495b37b9fdbe96c230d"

do_configure_prepend() {
    bbnote "Copying defconfig"
#    cp ${S}/arch/${ARCH}/configs/sunxi_defconfig ${WORKDIR}/defconfig
    cp  ${WORKDIR}/armbian-orange.cfg ${WORKDIR}/defconfig
}

do_configure_append () {
    bbnote "Merging fragment"
    ${S}/scripts/kconfig/merge_config.sh -m -O ${B} ${B}/.config ${WORKDIR}/sunxi-append.cfg
    ${KERNEL_CONFIG_COMMAND}
}
