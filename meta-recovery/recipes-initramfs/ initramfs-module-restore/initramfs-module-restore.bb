
SUMMARY = "Initramfs restore rootfilesystem"
DESCRIPTION = "system that check integrity and restore filesystem on case if corruption filesystem"
LICENSE = "MIT"

PR = "r0"

inherit allarch               
 
SRC_URI = "file://08-restore-rootfs.sh"

PACKAGE_INSTALL:append = " busybox bash coreutils e2fsprogs util-linux tar initramfs-module-restore"


S= "${WORKDIR}"

do_install(){

    install -d ${D}/init.d
    install -m 0755 ${S}/08-restore-rootfs ${D}/init.d/
}

