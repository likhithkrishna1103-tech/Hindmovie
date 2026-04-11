package com.cncverse;

import android.util.Base64;
import java.io.ByteArrayInputStream;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.sequences.Sequence;
import kotlin.text.Charsets;
import kotlin.text.MatchGroup;
import kotlin.text.MatchGroupCollection;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.RegexOption;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: Cricify.kt */
/* JADX INFO: loaded from: /data/data/com.termux/files/home/hindmovie/cricifyliveevents/.inspect/cs3/classes.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u0004\u0018\u00010\u0005*\u00020\u0005H\u0002J\u000e\u0010\u0006\u001a\u0004\u0018\u00010\u0005*\u00020\u0005H\u0002J\u000e\u0010\u0007\u001a\u0004\u0018\u00010\u0005*\u00020\u0005H\u0002J\u001c\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\t2\u0006\u0010\n\u001a\u00020\u0005H\u0002J\"\u0010\u000b\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\f2\u0006\u0010\n\u001a\u00020\u0005H\u0002J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0005J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0011J\f\u0010\u0012\u001a\u00020\u0005*\u00020\u0005H\u0002J\f\u0010\u0013\u001a\u00020\u0014*\u00020\u0005H\u0002J\u000e\u0010\u0015\u001a\u0004\u0018\u00010\u0005*\u00020\u0005H\u0002J\u000e\u0010\u0016\u001a\u0004\u0018\u00010\u0005*\u00020\u0005H\u0002J\u0016\u0010\u0017\u001a\u0004\u0018\u00010\u0005*\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u0005H\u0002J\u0018\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\t*\u00020\u0005H\u0002J\u0016\u0010\u001a\u001a\u0004\u0018\u00010\u0005*\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u0005H\u0002¨\u0006\u001b"}, d2 = {"Lcom/cncverse/IptvPlaylistParser;", "", "<init>", "()V", "hexOrNull", "", "base64ToHexOrNull", "normalizeDrmHexOrNull", "parseLicenseKeysMap", "", "licenseKey", "parseLicenseKeyPair", "Lkotlin/Pair;", "parseM3U", "Lcom/cncverse/Playlist;", "content", "input", "Ljava/io/InputStream;", "replaceQuotesAndTrim", "isExtendedM3u", "", "getTitle", "getUrl", "getUrlParameter", "key", "getAttributes", "getTagValue", "CricifyProvider_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nCricify.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Cricify.kt\ncom/cncverse/IptvPlaylistParser\n+ 2 AppUtils.kt\ncom/lagradost/cloudstream3/utils/AppUtils\n+ 3 Extensions.kt\ncom/fasterxml/jackson/module/kotlin/ExtensionsKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 5 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 6 _Sequences.kt\nkotlin/sequences/SequencesKt___SequencesKt\n*L\n1#1,1068:1\n15#2:1069\n50#3:1070\n43#3:1071\n1642#4,10:1072\n1915#4:1082\n1916#4:1084\n1652#4:1085\n1642#4,10:1086\n1915#4:1096\n1916#4:1098\n1652#4:1099\n1#5:1083\n1#5:1097\n1342#6,2:1100\n*S KotlinDebug\n*F\n+ 1 Cricify.kt\ncom/cncverse/IptvPlaylistParser\n*L\n701#1:1069\n701#1:1070\n701#1:1071\n759#1:1072,10\n759#1:1082\n759#1:1084\n759#1:1085\n767#1:1086,10\n767#1:1096\n767#1:1098\n767#1:1099\n759#1:1083\n767#1:1097\n1024#1:1100,2\n*E\n"})
public final class IptvPlaylistParser {
    private final String hexOrNull(String $this$hexOrNull) {
        String normalizedHex = StringsKt.trim(StringsKt.replace$default($this$hexOrNull, "-", "", false, 4, (Object) null)).toString();
        if (StringsKt.isBlank(normalizedHex) || normalizedHex.length() % 2 != 0) {
            return null;
        }
        if (!new Regex("^[0-9a-fA-F]+$").matches(normalizedHex)) {
            return null;
        }
        String lowerCase = normalizedHex.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        return lowerCase;
    }

    private final String base64ToHexOrNull(String $this$base64ToHexOrNull) {
        String value = StringsKt.replace$default(StringsKt.replace$default(StringsKt.trim($this$base64ToHexOrNull).toString(), '-', '+', false, 4, (Object) null), '_', '/', false, 4, (Object) null);
        int padding = (4 - (value.length() % 4)) % 4;
        try {
            byte[] decoded = Base64.decode(value + StringsKt.repeat("=", padding), 0);
            return ArraysKt.joinToString$default(decoded, "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new Function1() { // from class: com.cncverse.IptvPlaylistParser$$ExternalSyntheticLambda0
                public final Object invoke(Object obj) {
                    return IptvPlaylistParser.base64ToHexOrNull$lambda$1(((Byte) obj).byteValue());
                }
            }, 30, (Object) null);
        } catch (Exception e) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence base64ToHexOrNull$lambda$1(byte b) {
        String str = String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(b)}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        return str;
    }

    private final String normalizeDrmHexOrNull(String $this$normalizeDrmHexOrNull) {
        String trimmed = StringsKt.trim($this$normalizeDrmHexOrNull).toString();
        if ((trimmed.length() == 0) || StringsKt.equals(trimmed, "null", true)) {
            return null;
        }
        String strHexOrNull = hexOrNull(trimmed);
        return strHexOrNull == null ? base64ToHexOrNull(trimmed) : strHexOrNull;
    }

    private final Map<String, String> parseLicenseKeysMap(String licenseKey) {
        String trimmedKey = StringsKt.trim(licenseKey).toString();
        if (!StringsKt.startsWith$default(trimmedKey, "{", false, 2, (Object) null)) {
            return MapsKt.emptyMap();
        }
        try {
            JSONObject json = new JSONObject(trimmedKey);
            JSONArray keys = json.optJSONArray("keys");
            if (keys == null) {
                return MapsKt.emptyMap();
            }
            Map parsed = new LinkedHashMap();
            int length = keys.length();
            for (int index = 0; index < length; index++) {
                JSONObject item = keys.optJSONObject(index);
                if (item != null) {
                    String kid = normalizeDrmHexOrNull(item.optString("kid"));
                    String key = normalizeDrmHexOrNull(item.optString("k"));
                    String str = kid;
                    boolean z = true;
                    if (!(str == null || str.length() == 0)) {
                        String str2 = key;
                        if (str2 != null && str2.length() != 0) {
                            z = false;
                        }
                        if (!z) {
                            parsed.put(kid, key);
                        }
                    }
                }
            }
            return parsed;
        } catch (Exception e) {
            return MapsKt.emptyMap();
        }
    }

    private final Pair<String, String> parseLicenseKeyPair(String licenseKey) {
        List parts;
        String trimmedKey = StringsKt.trim(licenseKey).toString();
        if (trimmedKey.length() == 0) {
            return null;
        }
        if (StringsKt.startsWith$default(trimmedKey, "{", false, 2, (Object) null)) {
            try {
                JSONObject json = new JSONObject(trimmedKey);
                JSONArray keys = json.optJSONArray("keys");
                if (keys == null) {
                    return null;
                }
                int length = keys.length();
                for (int index = 0; index < length; index++) {
                    JSONObject item = keys.optJSONObject(index);
                    if (item != null) {
                        String kid = normalizeDrmHexOrNull(item.optString("kid"));
                        String key = normalizeDrmHexOrNull(item.optString("k"));
                        if (kid == null && key == null) {
                        }
                        return TuplesKt.to(key, kid);
                    }
                }
            } catch (Exception e) {
            }
            return null;
        }
        if (StringsKt.contains$default(trimmedKey, ":", false, 2, (Object) null)) {
            parts = StringsKt.split$default(trimmedKey, new String[]{":"}, false, 2, 2, (Object) null);
        } else {
            parts = StringsKt.contains$default(trimmedKey, ",", false, 2, (Object) null) ? StringsKt.split$default(trimmedKey, new String[]{","}, false, 2, 2, (Object) null) : CollectionsKt.emptyList();
        }
        if (parts.size() != 2) {
            return null;
        }
        String keyId = normalizeDrmHexOrNull(StringsKt.trim((String) parts.get(0)).toString());
        return TuplesKt.to(normalizeDrmHexOrNull(StringsKt.trim((String) parts.get(1)).toString()), keyId);
    }

    @NotNull
    public final Playlist parseM3U(@NotNull String content) {
        byte[] bytes = content.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        return parseM3U(new ByteArrayInputStream(bytes));
    }

    /* JADX WARN: Incorrect condition in loop: B:8:0x004d */
    /* JADX WARN: Removed duplicated region for block: B:142:0x03b5  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x03bb  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x03ca  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x03ce  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x03df  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x03e4  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x03e7  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x03eb  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x03f9  */
    @org.jetbrains.annotations.NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.cncverse.Playlist parseM3U(@org.jetbrains.annotations.NotNull java.io.InputStream r41) throws com.cncverse.PlaylistParserException {
        /*
            Method dump skipped, instruction units count: 1425
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cncverse.IptvPlaylistParser.parseM3U(java.io.InputStream):com.cncverse.Playlist");
    }

    private final String replaceQuotesAndTrim(String $this$replaceQuotesAndTrim) {
        return StringsKt.trim(StringsKt.replace$default($this$replaceQuotesAndTrim, "\"", "", false, 4, (Object) null)).toString();
    }

    private final boolean isExtendedM3u(String $this$isExtendedM3u) {
        return StringsKt.startsWith$default($this$isExtendedM3u, Cricify.EXT_M3U, false, 2, (Object) null) || StringsKt.startsWith$default($this$isExtendedM3u, Cricify.EXT_INF, false, 2, (Object) null) || StringsKt.startsWith$default($this$isExtendedM3u, "#KODIPROP", false, 2, (Object) null);
    }

    private final String getTitle(String $this$getTitle) {
        Regex extInfRegex = new Regex("(#EXTINF:.?[0-9]+)", RegexOption.IGNORE_CASE);
        String afterExtInf = StringsKt.trim(extInfRegex.replace($this$getTitle, "")).toString();
        int lastCommaIndex = -1;
        boolean insideQuotes = false;
        int i = 0;
        int length = afterExtInf.length();
        while (true) {
            if (i < length) {
                switch (afterExtInf.charAt(i)) {
                    case '\"':
                        insideQuotes = insideQuotes ? false : true;
                        break;
                    case ',':
                        if (!insideQuotes) {
                            lastCommaIndex = i;
                        }
                        break;
                }
                i++;
            } else {
                if (lastCommaIndex != -1 && lastCommaIndex < afterExtInf.length() - 1) {
                    String strSubstring = afterExtInf.substring(lastCommaIndex + 1);
                    Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
                    return replaceQuotesAndTrim(StringsKt.trim(strSubstring).toString());
                }
                String str = (String) CollectionsKt.lastOrNull(StringsKt.split$default(afterExtInf, new String[]{","}, false, 0, 6, (Object) null));
                if (str != null) {
                    return replaceQuotesAndTrim(str);
                }
                return null;
            }
        }
    }

    private final String getUrl(String $this$getUrl) {
        String str = (String) CollectionsKt.firstOrNull(StringsKt.split$default($this$getUrl, new String[]{"|"}, false, 0, 6, (Object) null));
        if (str != null) {
            return replaceQuotesAndTrim(str);
        }
        return null;
    }

    private final String getUrlParameter(String $this$getUrlParameter, String key) {
        Regex urlRegex = new Regex("^(.*)\\|", RegexOption.IGNORE_CASE);
        String paramsString = replaceQuotesAndTrim(urlRegex.replace($this$getUrlParameter, ""));
        List<String> params = StringsKt.split$default(paramsString, new String[]{"&"}, false, 0, 6, (Object) null);
        for (String param : params) {
            List keyValuePair = StringsKt.split$default(param, new String[]{"="}, false, 2, 2, (Object) null);
            if (keyValuePair.size() == 2) {
                String paramKey = StringsKt.trim((String) keyValuePair.get(0)).toString();
                String paramValue = StringsKt.trim((String) keyValuePair.get(1)).toString();
                if (StringsKt.equals(paramKey, key, true)) {
                    return replaceQuotesAndTrim(paramValue);
                }
            }
        }
        return null;
    }

    private final Map<String, String> getAttributes(String $this$getAttributes) {
        String attributesString;
        String key;
        Regex extInfRegex;
        Regex extInfRegex2 = new Regex("(#EXTINF:.?[0-9]+)", RegexOption.IGNORE_CASE);
        String afterExtInf = StringsKt.trim(extInfRegex2.replace($this$getAttributes, "")).toString();
        int lastCommaIndex = -1;
        int i = 0;
        int i2 = 0;
        int length = afterExtInf.length();
        while (true) {
            if (i2 < length) {
                switch (afterExtInf.charAt(i2)) {
                    case '\"':
                        i = i != 0 ? 0 : 1;
                        break;
                    case ',':
                        if (i == 0) {
                            lastCommaIndex = i2;
                        }
                        break;
                }
                i2++;
            } else {
                if (lastCommaIndex != -1) {
                    String strSubstring = afterExtInf.substring(0, lastCommaIndex);
                    Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
                    attributesString = StringsKt.trim(strSubstring).toString();
                } else {
                    attributesString = StringsKt.trim(afterExtInf).toString();
                }
                Map attributes = new LinkedHashMap();
                Regex attributeRegex = new Regex("(\\w[-\\w]*)\\s*=\\s*(?:\"([^\"]*)\"|([^\\s,]+))", RegexOption.IGNORE_CASE);
                int i3 = 2;
                String str = null;
                Sequence $this$forEach$iv = Regex.findAll$default(attributeRegex, attributesString, 0, 2, (Object) null);
                for (Object element$iv : $this$forEach$iv) {
                    MatchResult matchResult = (MatchResult) element$iv;
                    MatchGroup matchGroup = matchResult.getGroups().get(i);
                    if (matchGroup == null || (key = matchGroup.getValue()) == null) {
                        key = "";
                    }
                    MatchGroup matchGroup2 = matchResult.getGroups().get(i3);
                    String quotedValue = matchGroup2 != null ? matchGroup2.getValue() : str;
                    MatchGroup matchGroup3 = matchResult.getGroups().get(3);
                    String unquotedValue = matchGroup3 != null ? matchGroup3.getValue() : null;
                    String value = quotedValue == null ? unquotedValue == null ? "" : unquotedValue : quotedValue;
                    if (!(key.length() > 0)) {
                        extInfRegex = extInfRegex2;
                    } else {
                        extInfRegex = extInfRegex2;
                        attributes.put(key, StringsKt.trim(value).toString());
                    }
                    extInfRegex2 = extInfRegex;
                    i = 1;
                    i3 = 2;
                    str = null;
                }
                return attributes;
            }
        }
    }

    private final String getTagValue(String $this$getTagValue, String key) {
        MatchGroupCollection groups;
        MatchGroup matchGroup;
        String value;
        Regex keyRegex = new Regex(key + "=(.*)", RegexOption.IGNORE_CASE);
        MatchResult matchResultFind$default = Regex.find$default(keyRegex, $this$getTagValue, 0, 2, (Object) null);
        if (matchResultFind$default == null || (groups = matchResultFind$default.getGroups()) == null || (matchGroup = groups.get(1)) == null || (value = matchGroup.getValue()) == null) {
            return null;
        }
        return replaceQuotesAndTrim(value);
    }
}
