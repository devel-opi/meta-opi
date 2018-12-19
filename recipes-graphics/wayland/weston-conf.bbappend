do_install_arm() {
	mkdir -p ${D}/${sysconfdir}/xdg/weston
	cat << EOF > ${D}/${sysconfdir}/xdg/weston/weston.ini
[core]
backend=drm-backend.so
modules=xwayland.so
require-input=false
EOF
}
