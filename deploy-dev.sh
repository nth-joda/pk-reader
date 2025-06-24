#!/usr/bin/env bash
set -e

# Thư mục chứa docker-compose.dev.yml trên server
APP_DIR="/opt/library-management"

# Nhận TAG từ workflow
TAG=$1
if [ -z "$TAG" ]; then
  echo "Usage: deploy-dev.sh <image-tag>"
  exit 1
fi

ssh -o StrictHostKeyChecking=no $SSH_USER@$SSH_HOST << EOF
  cd $APP_DIR
  git pull origin main
  export TAG=${TAG}
  docker-compose -f docker-compose.dev.yml pull
  docker-compose -f docker-compose.dev.yml up -d
EOF