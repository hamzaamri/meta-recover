DESCRIPTION = "Custom Raspberry Pi 3 image with bundled initramfs"

require recipes-core/images/core-image-base.bb
inherit core-image
IMAGE_INSTALL += " \
    packagegroup-core-boot \
    packagegroup-core-ssh-openssh \
    kernel-modules \
    u-boot \
    u-boot-fw-utils \
    kernel-image-initramfs \
"

IMAGE_FEATURES += "ssh-server-openssh debug-tweaks"

COMPATIBLE_MACHINE = "rpi3-recovery"