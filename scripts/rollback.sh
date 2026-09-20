#!/bin/bash

set -e

echo "========================================"
echo "Iniciando proceso de rollback"
echo "========================================"

STAGING_DIR="deployment/staging"
BACKUP_DIR="deployment/backup"

if [ ! -d "$BACKUP_DIR" ]; then
  echo "ERROR: No existe una version estable para restaurar."
  exit 1
fi

echo "Eliminando version actual del ambiente de prueba..."
rm -rf "$STAGING_DIR"

echo "Restaurando ultima version estable..."
mkdir -p "$STAGING_DIR"
cp -R "$BACKUP_DIR"/. "$STAGING_DIR"/

echo "Verificando restauracion..."

if find "$STAGING_DIR" -name "*.jar" -print -quit | grep -q .; then
  echo "Rollback realizado correctamente."
  echo "Version estable restaurada en $STAGING_DIR"
else
  echo "ERROR: No se pudo restaurar el artefacto."
  exit 1
fi