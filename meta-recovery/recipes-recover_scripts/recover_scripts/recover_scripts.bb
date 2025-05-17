SUMMARY = " Recover script for initramfs image"
DESCRIPTION = "these scripts will check the state of the actual rootfs o,if it is corrupted or something wrong it will recover a backup image as imergency act"
LICENSE = "MIT"

SRC_URI = "file://check_rootfs.sh \
           file://restore_from_backup.sh"

S = "${WORKDIR}"

do_install(){
    install -d ${D}/etc/init.d 
    install -m 0755 ${WORKDIR}/check_rootfs.sh ${D}/etc/init.d/check_rootfs.sh
    install -m 0755 ${WORKDIR}/restore_from_backup.sh ${D}/etc/init.d/restore_from_backup.sh

}
