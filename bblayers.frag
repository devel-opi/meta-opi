YOCTOROOT = "${@os.path.abspath(os.path.join("${TOPDIR}", os.pardir))}"

BBLAYERS += " \
  ${YOCTOROOT}/oe-core/meta \
  ${YOCTOROOT}/meta-openembedded/meta-oe \
  ${YOCTOROOT}/meta-openembedded/meta-networking \
  ${YOCTOROOT}/meta-openembedded/meta-python \
  ${YOCTOROOT}/meta-openembedded/meta-multimedia \
  ${YOCTOROOT}/meta-opi \
  "
