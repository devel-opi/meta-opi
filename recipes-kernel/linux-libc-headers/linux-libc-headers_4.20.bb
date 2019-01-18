require linux-libc-headers.inc

SRC_URI_append_libc-musl = "\
    file://0001-libc-compat.h-fix-some-issues-arising-from-in6.h.patch \
    file://0002-libc-compat.h-prevent-redefinition-of-struct-ethhdr.patch \
    file://0003-remove-inclusion-of-sysinfo.h-in-kernel.h.patch \
    file://0001-libc-compat.h-musl-_does_-define-IFF_LOWER_UP-DORMAN.patch \
    file://0001-if_ether-move-muslc-ethhdr-protection-to-uapi-file.patch \
    file://0001-include-linux-stddef.h-in-swab.h-uapi-header.patch \
   "

SRC_URI[md5sum] = "d39dd4ba2d5861c54b90d49be19eaf31"

