set -e

source .env

ssh "$REMOTE_USER@$REMOTE_HOST" <<EOF
    cd $REMOTE_PATH
    git pull
    bash deploy.sh
EOF