set -e

TARGET_DIR=build
POSTS_DIR=resources/posts

rm -rf $TARGET_DIR
mkdir -p $TARGET_DIR
cp -r template/* $TARGET_DIR

mkdir -p $TARGET_DIR/blog
clj -Mtest:run $TARGET_DIR/ $POSTS_DIR/
clj -Mtest:css once
cp resources/public/styles.css $TARGET_DIR