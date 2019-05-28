FILESEXTRAPATHS_prepend := "${THISDIR}/u-boot:"

SRC_URI += "file://boot.cmd"

do_compile_append() {
    ${B}/tools/mkimage -C none -A arm -T script -d ${WORKDIR}/boot.cmd ${WORKDIR}/${UBOOT_ENV_BINARY}
}
