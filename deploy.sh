set -e

source .env

bash build.sh

rm -rf $STATIC_SITE_PATH
mv build $STATIC_SITE_PATH