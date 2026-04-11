package uc;

import android.app.Activity;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.view.Window;
import android.view.WindowInsets;
import android.webkit.MimeTypeMap;
import android.widget.TextView;
import b8.h;
import com.playz.tv.app.ProApplication;
import gc.o;
import ic.j;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import oc.g;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p1.m0;
import p2.c;
import q0.e;
import q0.s1;
import q0.t1;
import q0.u1;
import q0.v1;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String[] f12921a = {"Default", "Chrome(Android)", "Chrome(PC)", "IE(PC)", "Firefox(PC)", "Iphone", "Nokia", "Custom"};

    public static void a(Context context, String str, String str2, String str3, String str4) {
        HashSet hashSet = new HashSet(f(context).getStringSet("list", new HashSet()));
        hashSet.add(str + "*" + str2 + "*" + str3 + "*" + str4);
        f(context).edit().putStringSet("list", hashSet).apply();
    }

    public static long b(String str, String str2) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss", Locale.getDefault());
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        return simpleDateFormat.parse(str + " " + str2).getTime();
    }

    public static SimpleDateFormat c(String str) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        return simpleDateFormat;
    }

    public static HashMap d(String str) {
        if (str == null) {
            return new HashMap();
        }
        String[] strArrSplit = str.split("\\&");
        HashMap map = new HashMap();
        for (String str2 : strArrSplit) {
            String[] strArrSplit2 = str2.split("\\=");
            if (strArrSplit2.length != 1) {
                String str3 = strArrSplit2[1];
                if (strArrSplit2.length > 2) {
                    for (int i = 2; strArrSplit2.length != i; i++) {
                        str3 = str3 + "=" + strArrSplit2[i];
                    }
                }
                if (strArrSplit2[0].equalsIgnoreCase("user-agent")) {
                    map.put("user-agent", str3);
                } else {
                    map.put(strArrSplit2[0], str3);
                }
            } else if (strArrSplit2[0].equalsIgnoreCase("user-agent")) {
                map.put("user-agent", "null");
            } else {
                map.put(strArrSplit2[0], "");
            }
        }
        return map;
    }

    public static String e(String str) {
        if (str == null || str.isEmpty()) {
            return null;
        }
        if (str.contains(".m3u8")) {
            return "application/x-mpegURL";
        }
        if (str.contains(".ts")) {
            return "video/mp2t";
        }
        if (str.contains(".mpd")) {
            return "application/dash+xml";
        }
        if (str.contains(".php") || str.contains(".js") || str.contains(".json")) {
            return (!str.contains("=m3u8") && str.contains("=ts")) ? "video/mp2t" : "application/x-mpegURL";
        }
        String fileExtensionFromUrl = MimeTypeMap.getFileExtensionFromUrl(str);
        return TextUtils.isEmpty(fileExtensionFromUrl) ? "application/x-mpegURL" : m0.e(fileExtensionFromUrl);
    }

    public static SharedPreferences f(Context context) {
        return context.getSharedPreferences("DataPreferences", 0);
    }

    public static SharedPreferences.Editor g(Context context) {
        return f(context).edit();
    }

    public static ArrayList h(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        StringBuilder sb2 = new StringBuilder();
        String str3 = "";
        boolean z2 = true;
        for (String str4 : str.split("&")) {
            String[] strArrSplit = str4.split("=");
            String str5 = strArrSplit[0];
            String strSubstring = strArrSplit.length > 1 ? str4.substring(str5.length() + 1) : "";
            if (str5.toLowerCase().equals(str2)) {
                str3 = strSubstring;
            } else if (z2) {
                sb2.append(str5);
                sb2.append("=");
                sb2.append(strSubstring);
                z2 = false;
            } else {
                sb2.append("&");
                sb2.append(str5);
                sb2.append("=");
                sb2.append(strSubstring);
            }
        }
        arrayList.add(sb2.toString());
        arrayList.add(str3);
        return arrayList;
    }

    public static String i(Context context) {
        CharSequence text;
        ClipboardManager clipboardManager = (ClipboardManager) context.getSystemService("clipboard");
        return (!clipboardManager.hasPrimaryClip() || clipboardManager.getPrimaryClip().getItemCount() <= 0 || (text = clipboardManager.getPrimaryClip().getItemAt(0).getText()) == null) ? "" : text.toString();
    }

    public static String j(String str) {
        try {
            int length = str.length();
            byte[] bArr = new byte[length / 2];
            for (int i = 0; i < length; i += 2) {
                bArr[i / 2] = (byte) ((Character.digit(str.charAt(i), 16) << 4) + Character.digit(str.charAt(i + 1), 16));
            }
            return Base64.encodeToString(bArr, 0);
        } catch (IllegalArgumentException e10) {
            return e10.getMessage();
        }
    }

    public static void k(Activity activity) {
        Window window = activity.getWindow();
        if (Build.VERSION.SDK_INT < 30) {
            window.setFlags(1024, 1024);
            window.getDecorView().setSystemUiVisibility(5638);
            return;
        }
        e eVar = new e(window.getDecorView());
        int i = Build.VERSION.SDK_INT;
        h v1Var = i >= 35 ? new v1(window, eVar) : i >= 30 ? new u1(window, eVar) : i >= 26 ? new t1(window, eVar) : new s1(window, eVar);
        v1Var.q(WindowInsets.Type.systemBars());
        v1Var.D();
        a.a.K(window, false);
    }

    public static boolean l(String str, String str2) {
        Date date;
        Date date2;
        Date date3;
        Date date4;
        try {
            SimpleDateFormat simpleDateFormatC = c("dd/MM/yyyy");
            SimpleDateFormat simpleDateFormatC2 = c("HH:mm:ss");
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy|HH:mm:ss");
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
            String[] strArrSplit = simpleDateFormat.format(new Date()).split("\\|");
            String str3 = strArrSplit[0];
            String str4 = strArrSplit[1];
            date = simpleDateFormatC.parse(str);
            date2 = simpleDateFormatC.parse(str3);
            date3 = simpleDateFormatC2.parse(str2);
            date4 = simpleDateFormatC2.parse(str4);
        } catch (ParseException unused) {
        }
        if (!date.before(date2)) {
            if (date.equals(date2)) {
                if (!date4.equals(date3)) {
                    if (date3.before(date4)) {
                    }
                }
            }
            return false;
        }
        return true;
    }

    public static boolean m(String str, String str2) {
        if (str != null && str2 != null) {
            try {
                SimpleDateFormat simpleDateFormatC = c("dd/MM/yyyy");
                SimpleDateFormat simpleDateFormatC2 = c("HH:mm:ss");
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy|HH:mm:ss");
                simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
                String[] strArrSplit = simpleDateFormat.format(new Date()).split("\\|");
                String str3 = strArrSplit[0];
                String str4 = strArrSplit[1];
                Date date = simpleDateFormatC.parse(str);
                Date date2 = simpleDateFormatC.parse(str3);
                Date date3 = simpleDateFormatC2.parse(str2);
                Date date4 = simpleDateFormatC2.parse(str4);
                if (!date.before(date2)) {
                    if (date.equals(date2)) {
                        if (date4.after(date3)) {
                        }
                    }
                }
                return true;
            } catch (ParseException unused) {
            }
        }
        return false;
    }

    public static String n(String str) {
        StringBuilder sb2 = new StringBuilder();
        String[] strArrSplit = str.split("\\:");
        for (int i = 0; i < strArrSplit.length; i += 2) {
            try {
                String strV = v(j(strArrSplit[i]).replaceAll("==", ""), j(strArrSplit[i + 1]).replaceAll("==", ""));
                if (sb2.length() > 0) {
                    sb2.append(",");
                }
                sb2.append(strV);
            } catch (ArrayIndexOutOfBoundsException unused) {
            }
        }
        return "{\"keys\":[" + sb2.toString() + "],\"type\":\"temporary\"}".replaceAll("\\n", "");
    }

    public static String o(String str, String str2, String str3, String str4, String str5) {
        if (str == null) {
            return null;
        }
        if (str2 == null && str3 == null && str4 == null && str5 == null) {
            return str;
        }
        StringBuilder sbB = v.e.b(str.split("\\|")[0]);
        sbB.append(str3 != null ? "|cookie=".concat(str3) : "");
        sbB.append(str5 != null ? "&origin=".concat(str5) : "");
        sbB.append(str4 != null ? "&referer=".concat(str4) : "");
        sbB.append(str2 != null ? "&user-agent=".concat(str2) : "");
        String string = sbB.toString();
        return !string.contains("|") ? string.contains("&origin") ? string.replaceAll("\\&origin", "|origin") : string.contains("&referer") ? string.replaceAll("\\&referer", "|referer") : string.contains("&user-agent") ? string.replaceAll("\\&user-agent", "|user-agent") : string : string;
    }

    public static oc.a p(Context context, ProApplication proApplication, JSONObject jSONObject) throws JSONException {
        oc.a aVar = new oc.a();
        aVar.I = Integer.parseInt(jSONObject.getString("app_version"));
        aVar.H = jSONObject.optString("update_change_log", "no");
        String string = jSONObject.getString("download_url");
        aVar.f9508x = string;
        proApplication.G = string;
        aVar.f9505u = jSONObject.getString("telegram_url");
        aVar.f9506v = jSONObject.optString("notice", "Notice text will be show here.");
        aVar.G = jSONObject.optString("email", "test@gmail.com");
        aVar.E = jSONObject.optString("start_ad", "no");
        aVar.F = jSONObject.optString("start_ad_action", "no");
        aVar.f9507w = jSONObject.getString("web_url");
        String string2 = jSONObject.getString("message");
        String string3 = jSONObject.getString("message_url");
        proApplication.D = string2;
        proApplication.E = string3;
        aVar.A = jSONObject.optString("foot_live_url", "");
        aVar.B = jSONObject.optString("cric_live_url", "");
        aVar.f9509y = string2;
        aVar.f9510z = string3;
        aVar.C = jSONObject.getString("banner_ad");
        aVar.D = jSONObject.getString("banner_ad_action");
        f(context).edit().putBoolean("tv_external_ad_enabled", "true".equals(jSONObject.optString("tv_external_ad_enbled", "false"))).apply();
        f(context).edit().putBoolean("external_ad_enabled", "true".equals(jSONObject.getString("external_ad_enbled"))).apply();
        f(context).edit().putString("external_ad_url", jSONObject.getString("external_ad_url")).apply();
        f(context).edit().putInt("external_ad_repeat_after", Integer.parseInt(jSONObject.getString("external_ad_repeat_after"))).apply();
        return aVar;
    }

    public static c q(String str) {
        try {
            return r(new JSONArray(str));
        } catch (JSONException unused) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add("All");
            String[] strArrSplit = str.split("\n");
            int length = strArrSplit.length;
            int i = 0;
            g gVar = null;
            while (true) {
                int i10 = 1;
                if (i >= length) {
                    break;
                }
                String str2 = strArrSplit[i];
                if (gVar == null) {
                    gVar = new g();
                    arrayList.add(gVar);
                }
                if (str2.contains("group-title=")) {
                    Matcher matcher = Pattern.compile("group-title=\"([^\"]+)\"").matcher(str2);
                    if (matcher.find()) {
                        String strReplaceAll = matcher.group(1).replaceAll("^\\s+|$", "");
                        gVar.f9546a = strReplaceAll;
                        if (!arrayList2.contains(strReplaceAll)) {
                            arrayList2.add(strReplaceAll);
                        }
                    }
                }
                if (str2.startsWith("#EXTINF")) {
                    String[] strArrSplit2 = str2.split(",");
                    gVar.f9547b = strArrSplit2[strArrSplit2.length - 1].replaceAll("^\\s+|$", "");
                    if (str2.contains("tvg-logo=")) {
                        Matcher matcher2 = Pattern.compile("tvg-logo=\"([^\"]+)\"").matcher(str2);
                        if (matcher2.find()) {
                            gVar.f9548c = matcher2.group(1).replaceAll("^\\s+|$", "");
                        }
                    }
                } else if (str2.startsWith("#KODIPROP:inputstream.adaptive.license_type=")) {
                    String lowerCase = str2.toLowerCase();
                    if (lowerCase.contains("clearkey")) {
                        i10 = 0;
                    } else if (!lowerCase.contains("widevine")) {
                        i10 = 2;
                    }
                    gVar.f9553j = i10;
                } else if (str2.startsWith("#KODIPROP:inputstream.adaptive.license_key=")) {
                    String[] strArrSplit3 = str2.split("#KODIPROP:inputstream.adaptive.license_key=");
                    if (strArrSplit3.length > 0) {
                        gVar.i = strArrSplit3[1].replaceAll("^\\s+|$", "");
                    }
                } else if (str2.startsWith("#EXTVLCOPT:http-user-agent=")) {
                    gVar.f9550e = str2.split("#EXTVLCOPT:http-user-agent=")[1];
                } else if (str2.startsWith("#EXTVLCOPT:http-referer=")) {
                    gVar.f9551g = str2.split("#EXTVLCOPT:http-referer=")[1];
                } else if (str2.startsWith("#EXTVLCOPT:http-referrer=")) {
                    gVar.f9551g = str2.split("#EXTVLCOPT:http-referrer=")[1];
                } else if (str2.startsWith("#EXTVLCOPT:http-origin=")) {
                    gVar.f9552h = str2.split("#EXTVLCOPT:http-origin=")[1];
                } else if (str2.startsWith("#EXTHTTP:")) {
                    String str3 = str2.split("#EXTHTTP:")[1];
                    try {
                        JSONObject jSONObject = new JSONObject(str3);
                        if (jSONObject.has("cookie")) {
                            gVar.f = jSONObject.getString("cookie");
                        } else if (jSONObject.has("Cookie")) {
                            gVar.f = jSONObject.getString("Cookie");
                        }
                    } catch (JSONException unused2) {
                        gVar.f = str3;
                    }
                } else if (str2.startsWith("http")) {
                    gVar.f9549d = str2.replaceAll("^[\\s\\r\\n]+|[\\s\\r\\n]+$", "");
                    gVar = null;
                }
                i++;
            }
            if (arrayList2.size() == 1) {
                arrayList2.clear();
            }
            return new c(arrayList, 19, arrayList2);
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:72:0x007e A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0023 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static p2.c r(org.json.JSONArray r10) {
        /*
            Method dump skipped, instruction units count: 312
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: uc.b.r(org.json.JSONArray):p2.c");
    }

    public static void s(Context context) {
        try {
            String string = context.getString(o.app_name);
            Intent intent = new Intent("android.intent.action.SEND");
            intent.setType("text/plain");
            intent.putExtra("android.intent.extra.SUBJECT", string);
            intent.putExtra("android.intent.extra.TEXT", (string + " is the world's Number 1 Sports app. You can watch free All Live Sports Events, Worldwide TV Channels and more....\n\nDownload Now! ") + ProApplication.I.G);
            context.startActivity(Intent.createChooser(intent, "choose one"));
        } catch (Exception unused) {
        }
    }

    public static void t(Activity activity) {
        Window window = activity.getWindow();
        if (Build.VERSION.SDK_INT < 30) {
            window.clearFlags(1024);
            window.getDecorView().setSystemUiVisibility(0);
        } else {
            e eVar = new e(window.getDecorView());
            int i = Build.VERSION.SDK_INT;
            (i >= 35 ? new v1(window, eVar) : i >= 30 ? new u1(window, eVar) : i >= 26 ? new t1(window, eVar) : new s1(window, eVar)).E(WindowInsets.Type.systemBars());
            a.a.K(window, true);
        }
    }

    public static String u(String str) {
        try {
            JSONArray jSONArray = new JSONObject(str).getJSONArray("keys");
            StringBuilder sb2 = new StringBuilder();
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                String strV = v(jSONObject.getString("kid"), jSONObject.getString("k"));
                if (sb2.length() > 0) {
                    sb2.append(",");
                }
                sb2.append(strV);
            }
            return "{\"keys\":[" + sb2.toString() + "],\"type\":\"temporary\"}".replaceAll("\\n", "");
        } catch (JSONException e10) {
            Log.e("Pro toClearkeyJson 1", e10.toString());
            return str;
        }
    }

    public static String v(String str, String str2) {
        return "{\"kty\":\"oct\",\"k\":\"" + str2.trim().replaceAll("\\n", "") + "\",\"kid\":\"" + str.trim().replaceAll("\\n", "") + "\"}";
    }

    public static ArrayList w(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        if (jSONArray != null && jSONArray.length() > 1) {
            for (int i = 0; i < jSONArray.length(); i++) {
                arrayList.add(jSONArray.getString(i));
            }
        }
        return arrayList;
    }

    public static void x(j jVar, long j5) {
        String str;
        TextView textView = jVar.E;
        long j8 = j5 / 86400000;
        long j10 = (j5 / 3600000) % 24;
        long j11 = (j5 / 60000) % 60;
        if (j8 > 0) {
            str = "Starts in " + j8 + " days";
        } else if (j10 > 0) {
            str = "Starts in " + j10 + " hours";
        } else {
            str = "Starts in " + j11 + " minutes";
        }
        if (str.equals(textView.getText().toString())) {
            return;
        }
        textView.setText(str);
    }
}
