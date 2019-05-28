MACHINE = "orange-pi-one"
DISTRO = ""
IMAGE_INSTALL_append = " mali mc glmark2 openssh v4l-utils libva-utils weston-xwayland libva-v4l2-request"
DISTRO_FEATURES_append = " x11 wayland fbdev opengl mali-blobs drm systemd"
CORE_IMAGE_EXTRA_INSTALL += "wayland weston weston-conf weston-init strace tzdata dhcp-client v4l-utils"

PACKAGECONFIG_append_pn-wayland = "xwayland"

PACKAGECONFIG_remove_pn-xserver-xorg = "glamor"

ERROR_QA_remove = "file-rdeps"
WARN_QA_append = "file-rdeps"

DISTRO_FEATURES_BACKFILL_CONSIDERED += "sysvinit"
VIRTUAL-RUNTIME_init_manager = "systemd"
VIRTUAL-RUNTIME_initscripts = "systemd-compat-units"

IMAGE_FEATURES_remove = "ssh-server-dropbear"
