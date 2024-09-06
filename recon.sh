#!/bin/bash

DOMAIN=$1
DIRECTORY=${DOMAIN}_recon
mkdir TARGET/$DIRECTORY

# Finding Subdomains and related domains

assetfinder $DOMAIN | anew /home/xbyte/TARGET/$DIRECTORY/subdomains.txt
subfinder -d $DOMAIN -all | anew /home/xbyte/TARGET/$DIRECTORY/subdomains.txt
curl -s https://crt.sh/\?q\=\%.$DOMAIN\&output\=json | jq -r '.[].name_value' | sed 's/\*\.//g' | sort -u | anew /home/xbyte/TARGET/$DIRECTORY/subdomains.txt
amass enum -d $DOMAIN -passive | anew /home/xbyte/TARGET/$DIRECTORY/output.txt
cd TARGET/$DIRECTORY && cat output.txt | sed 's/\x1b\[[0-9;]*m//g' | grep -oP '(?<=\s)[a-zA-Z0-9.-]*\.(com)' > cleaned_subdomains.txt
cat cleaned_subdomains.txt | anew subdomains.txt
cat subdomains.txt | uniq | anew uniq_sub.txt

# Filtering live subdomains

cat uniq_sub.txt | httprobe > live_sub.txt
EyeWitness.py -f /home/xbyte/TARGET/$DIRECTORY/live_sub.txt --web -d /home/xbyte/TARGET/$DIRECTORY/SS

# Extracting Endpoints

katana -u live_sub.txt -o endpoints.txt
cat live_sub.txt | gau > params.txt
paramspider -l uniq_sub.txt > urls.txt
waybackurls $DOMAIN > urls1.txt
cat params.txt | grep '.js$' | anew js.txt
curl -s "http://web.archive.org/cdx/search/cdx?url=$DOMAIN/*&output=text&fl=original&collapse=urlkey"| grep -E "^http"| sort -u >archive_endpoints.txt 

# extracting Secrets from JS files

cat js.txt | while read url; do SecretFinder.py -i $url -o cli >> secrets.txt; done

