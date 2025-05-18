#!/bin/sh

ROOT_PARTITION="/dev/mmcblk0p2"
MOUNT_POINT="/mnt/rootfs"

echo "[INFO] Checking rootfs at ${ROOT_PARTITION}..."

mkdir -p $MOUNT_POINT
if mount $ROOT_PARTITION $MOUNT_POINT 2>/dev/null; then
    echo "[INFO] Root filesystem found. Proceeding with normal boot."
    umount $MOUNT_POINT
    exit 0
else
    echo "[ERROR] Root filesystem missing or corrupt. Initiating recovery..."
    /etc/init.d/restore_from_backup.sh
fi
