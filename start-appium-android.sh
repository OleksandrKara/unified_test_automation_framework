#!/bin/bash

function die {
    echo $1
    exit 1
}

#pkg_root_dir=`find $PWD | grep "/Config$" | head -n 1 | xargs dirname`
app_filename="D:/Git/coho-e2e/Config/app/app.apk"
ls -1 $app_filename || die "Did not find app in $pkg_root_dir"

appium --pre-launch --app-pkg com.quintech.mpers  --app-activity host.exp.exponent.MainActivity --platform-name Android --app $app_filename
