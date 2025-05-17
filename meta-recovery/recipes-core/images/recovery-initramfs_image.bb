DESCRIPTION = "Custom minimal initramfs image for custom-raspberrypi3-64"

require recipes-core/images/core-image-minimal-initramfs.bb

PACKAGE_INSTALL += " \
    bash \
    busybox \
    udev \
    e2fsprogs \
    util-linux \
    mtd-utils \
    tar \
    coreutils \
"

INITRAMFS_FSTYPES = "cpio.gz"
IMAGE_FSTYPES:remove = "rpi-sdimg"

IMAGE_FSTYPES:pn-${INITRAMFS_IMAGE} = "${INITRAMFS_FSTYPES}"

BOOT_SPACE = "1073741"
INITRAMFS_MAXSIZE = "315400"

IMAGE_FSTYPES:remove = "wic.qcow2"
IMAGE_INSTALL += "recover_scripts"