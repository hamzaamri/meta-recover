#!/bin/sh

BACKUP_IMG="/mnt/backup/rootfs-backup.tar.gz"
ROOT_PARTITION="/dev/mmcblk0p2"

echo "[INFO] Restoring root filesystem from backup..."

mkfs.ext4 -F $ROOT_PARTITION

mkdir -p /mnt/target
mount $ROOT_PARTITION /mnt/target

if [ -f "$BACKUP_IMG" ]; then
    echo "[INFO] Found backup image. Extracting..."
    tar -xzf $BACKUP_IMG -C /mnt/target
    sync
    umount /mnt/target
    echo "[INFO] Restore complete. Rebooting..."
    reboot -f
else
    echo "[ERROR] Backup image not found. Cannot recover."
    exit 1
fi
