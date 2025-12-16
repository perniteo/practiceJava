#!/bin/bash

ROOT="/c/Users/perni/git/practice/src/BaekAlgo"

echo "Monitoring $ROOT for DONE files..."

while true; do
    DONE_FILES=$(find "$ROOT" -name "DONE" 2>/dev/null)

    for FILE in $DONE_FILES; do
        DIR=$(dirname "$FILE")
        FOLDER_NAME=$(basename "$DIR")

        echo "[FOUND] DONE in: $DIR"

        git -C "$ROOT" add .
        git -C "$ROOT" commit -m "auto: solved $FOLDER_NAME"
        git -C "$ROOT" push

        rm "$FILE"
        echo "[PUSHED] Uploaded & deleted DONE for $FOLDER_NAME"
    done

    sleep 3
done
