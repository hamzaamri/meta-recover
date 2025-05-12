require recipes-core/images/core-image-minimal-initramfs.bb

INITRAMFS_IMAGE = "initramfs-recovery"
INITRAMFS_IMAGE_BUNDLE = "1"
INITRAMFS_FSTYPES = "cpio.gz"
IMAGE_FSTYPES:pn-${INITRAMFS_IMAGE} = "${INITRAMFS_FSTYPES}"

BOOT_SPACE = "1073741"
INITRAMFS_MAXSIZE = "315400"

PACKAGE_INSTALL:append = " busybox bash coreutils e2fsprogs util-linux tar"

