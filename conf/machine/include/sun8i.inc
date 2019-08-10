require conf/machine/include/tune-cortexa7.inc

SOC_FAMILY ??= ""
include conf/machine/include/soc-family.inc

# Sub-architecture support
MACHINE_SOCARCH_SUFFIX ?= ""

KERNEL_IMAGETYPE ?= "uImage"

IMAGE_FSTYPES += "ext4 tar.gz"

MACHINE_EXTRA_RRECOMMENDS = "kernel-modules"

UBOOT_LOCALVERSION = "-g${@d.getVar('SRCPV', True).partition('+')[2][0:7]}"

UBOOT_ENTRYPOINT ?= "0x40008000"
UBOOT_LOADADDRESS ?= "0x400080OB00"

SERIAL_CONSOLE ?= "115200 ttyS0"
MACHINE_FEATURES ?= "alsa apm keyboard rtc serial screen usbgadget usbhost vfat"

PREFERRED_PROVIDER_virtual/mesa = "mesa"
PREFERRED_PROVIDER_virtual/libgl = "mesa"
PREFERRED_PROVIDER_virtual/libgles1 = "mesa"
PREFERRED_PROVIDER_virtual/libgles2 = "mesa"
PREFERRED_PROVIDER_virtual/libegl = "mesa"
PREFERRED_PROVIDER_virtual/egl = "mesa"
PREFERRED_PROVIDER_virtual/gbm = "mesa"
PREFERRED_PROVIDER_virtual/libgbm = "mesa"

PREFERRED_PROVIDER_virtual/kernel = "linux-mainline"
PREFERRED_VERSION_linux-libc-headers = "5.1%"

XSERVER += "mesa"

SOC_FAMILY = "sun8i"
