#!/bin/sh
set -eu
base="$1"
ott="$2"
id="$3"
title="$4"
work=/data/data/com.termux/files/home/hindmovie/movies4u/.tmp_probe_$$
mkdir -p "$work"
headers_mobile="$work/headers_mobile.txt"
body_mobile="$work/body_mobile.html"
ua='Mozilla/5.0 (Linux; Android 12; RMX2117 Build/SP1A.210812.016; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/147.0.7727.55 Mobile Safari/537.36 /OS.Gatu v3.0'
curl -sSL -D "$headers_mobile" -o "$body_mobile" -H "User-Agent: $ua" -H 'X-Requested-With: app.netmirror.netmirrornew' "$base/mobile/home?app=1" >/dev/null
addhash=$(sed -n 's/.*data-addhash="\([^"]*\)".*/\1/p' "$body_mobile" | head -n1)
[ -n "$addhash" ]
curl -sSL "https://userver.net52.cc/?jjoii=$addhash&a=y&t=$(date +%s)" >/dev/null
cookie=''
count=0
while [ $count -lt 7 ]; do
  sleep 1
  resp=$(curl -sSL -D - -H 'User-Agent: Mozilla/5.0 (X11; Linux x86_64; rv:139.0) Gecko/20100101 Firefox/139.0' -H 'X-Requested-With: XMLHttpRequest' -d "verify=$addhash" "$base/mobile/verify2.php")
  body=$(printf '%s' "$resp" | awk 'BEGIN{p=0} /^\r?$/{p=1; next} { if(p) print }')
  setcookie=$(printf '%s' "$resp" | tr -d '\r' | sed -n 's/^set-cookie: t_hash_t=\([^;]*\).*/\1/p' | tail -n1)
  if printf '%s' "$body" | grep -q 'All Done'; then
    cookie="$setcookie"
    break
  fi
  count=$((count+1))
done
[ -n "$cookie" ]
now=$(date +%s)
common_cookies="t_hash_t=$cookie; ott=$ott; hd=on"
post=$(curl -sSL -H 'X-Requested-With: XMLHttpRequest' -H "Referer: $base/tv/home" -b "$common_cookies" "$base/post.php?id=$id&t=$now")
printf 'POST\n%s\n' "$post" | sed -n '1,120p'
if [ "$ott" = nf ]; then
  play=$(curl -sSL -H 'Accept: */*' -H 'Accept-Language: en-US,en;q=0.5' -H 'Connection: keep-alive' -H 'Content-Length: 11' -H 'Content-Type: application/x-www-form-urlencoded; charset=UTF-8' -H 'Host: net22.cc' -H "Origin: $base/" -H 'Priority: u=0' -H "Referer: $base/home" -H 'Sec-Fetch-Dest: empty' -H 'Sec-Fetch-Mode: cors' -H 'Sec-Fetch-Site: same-origin' -H 'User-Agent: Mozilla/5.0 (X11; Linux x86_64; rv:139.0) Gecko/20100101 Firefox/139.0' -H 'X-Requested-With: XMLHttpRequest' -b "$common_cookies; user_token=233123f803cf02184bf6c67e149cdd50" -d "id=$id" "$base/play.php")
  printf 'PLAY\n%s\n' "$play"
fi
rm -rf "$work"
