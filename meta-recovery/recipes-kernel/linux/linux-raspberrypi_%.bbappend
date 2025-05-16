FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI += "file://initramfs.cfg"


do_configure:append() {
    echo "Appending kernel configuration for initramfs..."
}
