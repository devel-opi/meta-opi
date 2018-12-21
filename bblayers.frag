YOCTOROOT = "${@os.path.abspath(os.path.join("${TOPDIR}", os.pardir))}"

BBLAYERS += " \
  ${YOCTOROOT}/oe-core/meta \
  ${YOCTOROOT}/oe-core/meta-openembedded/meta-oe \
  ${YOCTOROOT}/oe-core/meta-openembedded/meta-networking \
  ${YOCTOROOT}/oe-core/meta-openembedded/meta-python \
  ${YOCTOROOT}/oe-core/meta-openembedded/meta-multimedia \
  ${YOCTOROOT}/meta-opi \
  "
