package ab;

import android.content.Context;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Base64;
import android.util.SparseBooleanArray;
import android.view.ViewGroup;
import android.webkit.MimeTypeMap;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.window.BackEvent;
import androidx.emoji2.text.n;
import androidx.media3.decoder.DecoderInputBuffer;
import fe.l;
import java.io.File;
import java.lang.reflect.Method;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import k4.t;
import kf.p;
import kf.s;
import kf.x;
import l5.w;
import ne.o;
import org.json.JSONException;
import org.json.JSONObject;
import qb.t1;
import ua.i0;
import v1.g0;
import v1.s0;
import v1.w0;
import w4.y;
import z5.k;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f380a = true;

    public static void B(w0 w0Var, t tVar) {
        int i = tVar.f7165b;
        long j4 = tVar.f7166c;
        i0 i0Var = tVar.f7164a;
        if (i == -1) {
            if (w0Var.Z(20)) {
                w0Var.Q0(i0Var);
                return;
            } else {
                if (i0Var.isEmpty()) {
                    return;
                }
                w0Var.K((g0) i0Var.get(0));
                return;
            }
        }
        if (w0Var.Z(20)) {
            w0Var.g(i0Var, tVar.f7165b, j4);
        } else {
            if (i0Var.isEmpty()) {
                return;
            }
            w0Var.n((g0) i0Var.get(0), j4);
        }
    }

    public static void E(ViewGroup viewGroup, boolean z10) {
        if (Build.VERSION.SDK_INT >= 29) {
            w.b(viewGroup, z10);
        } else if (f380a) {
            try {
                w.b(viewGroup, z10);
            } catch (NoSuchMethodError unused) {
                f380a = false;
            }
        }
    }

    public static boolean a(String str, String str2) {
        String host;
        String fileExtensionFromUrl = MimeTypeMap.getFileExtensionFromUrl(str2);
        if ((!fileExtensionFromUrl.equals("php") || !str2.contains(".m3u8")) && !fileExtensionFromUrl.equals("m3u8") && !fileExtensionFromUrl.equals("mpd") && !fileExtensionFromUrl.equals("ts") && !fileExtensionFromUrl.equals("mp4") && !fileExtensionFromUrl.equals("webm") && !fileExtensionFromUrl.equals("mkv")) {
            return false;
        }
        if (!TextUtils.isEmpty(str)) {
            try {
                host = new URI(str2).getHost();
                if (host != null && host.startsWith("www.")) {
                    host = host.substring(4);
                }
            } catch (URISyntaxException unused) {
                host = null;
            }
            if (!str.equals(host)) {
                return false;
            }
        }
        return true;
    }

    public static final o4.b b(BackEvent backEvent) {
        float touchX = backEvent.getTouchX();
        float touchY = backEvent.getTouchY();
        return new o4.b(backEvent.getSwipeEdge(), backEvent.getProgress(), touchX, touchY, Build.VERSION.SDK_INT >= 36 ? backEvent.getFrameTimeMillis() : 0L);
    }

    public static void c(Throwable th, Throwable th2) {
        ge.i.e(th, "<this>");
        ge.i.e(th2, "exception");
        if (th != th2) {
            Integer num = ae.a.f416a;
            if (num == null || num.intValue() >= 19) {
                th.addSuppressed(th2);
                return;
            }
            Method method = zd.a.f15341a;
            if (method != null) {
                method.invoke(th, th2);
            }
        }
    }

    public static final long d() {
        return Thread.currentThread().getId();
    }

    public static final File e(Context context, String str) {
        ge.i.e(str, "fileName");
        return new File(context.getApplicationContext().getFilesDir(), "datastore/".concat(str));
    }

    public static String g(String str) {
        try {
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            Charset charset = StandardCharsets.UTF_8;
            cipher.init(2, new SecretKeySpec("l2K5wB8xC1wP7rK1".getBytes(charset), "AES"), new IvParameterSpec("n0K4nP8uB8hH1l18".getBytes(charset)));
            return new String(cipher.doFinal(Base64.decode(str, 0)), charset);
        } catch (Exception e9) {
            e9.printStackTrace();
            return e9.getMessage();
        }
    }

    public static final void h(c5.a aVar) throws Exception {
        ge.i.e(aVar, "connection");
        td.c cVarH = n5.a.h();
        c5.c cVarC0 = aVar.c0("SELECT name FROM sqlite_master WHERE type = 'trigger'");
        while (cVarC0.V()) {
            try {
                cVarH.add(cVarC0.j(0));
            } finally {
            }
        }
        android.support.v4.media.session.b.d(cVarC0, null);
        ListIterator listIterator = n5.a.a(cVarH).listIterator(0);
        while (true) {
            td.a aVar2 = (td.a) listIterator;
            if (!aVar2.hasNext()) {
                return;
            }
            String str = (String) aVar2.next();
            if (o.Z(str, "room_fts_content_sync_", false)) {
                android.support.v4.media.session.b.k(aVar, "DROP TRIGGER IF EXISTS ".concat(str));
            }
        }
    }

    public static void j(String str, z5.i iVar) {
        Matcher matcher = Pattern.compile("player\\.load\\(\\{[^}]*source:\\s*([a-zA-Z0-9_]+)\\(\\)").matcher(str);
        if (!matcher.find()) {
            y("http://error.com", null, iVar);
            return;
        }
        String strGroup = matcher.group(1);
        if (strGroup.contains("://")) {
            x(strGroup, iVar);
            return;
        }
        Matcher matcher2 = Pattern.compile("function\\s+" + Pattern.quote(strGroup) + "\\s*\\(\\)\\s*\\{([\\s\\S]*?)\\}").matcher(str);
        if (!matcher2.find()) {
            y("http://error.com", null, iVar);
            return;
        }
        String[] strArrSplit = matcher2.group(1).split("\\[")[1].split("\\.join")[0].split("\",\"|\"");
        StringBuilder sb = new StringBuilder();
        for (String str2 : strArrSplit) {
            String strTrim = str2.trim();
            if (!strTrim.isEmpty()) {
                if (strTrim.startsWith("\"") && strTrim.endsWith("\"")) {
                    strTrim = strTrim.substring(1, strTrim.length() - 1);
                }
                sb.append(strTrim.replace("\\/", "/"));
            }
        }
        x(sb.toString(), iVar);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v13, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v14, types: [java.util.HashMap] */
    /* JADX WARN: Type inference failed for: r0v15, types: [java.util.HashMap] */
    /* JADX WARN: Type inference failed for: r0v6, types: [java.lang.Object, java.util.HashMap] */
    /* JADX WARN: Type inference failed for: r0v7, types: [java.util.HashMap] */
    /* JADX WARN: Type inference failed for: r11v0 */
    /* JADX WARN: Type inference failed for: r11v1, types: [z5.i] */
    /* JADX WARN: Type inference failed for: r11v12 */
    /* JADX WARN: Type inference failed for: r11v14, types: [z5.i] */
    /* JADX WARN: Type inference failed for: r11v15 */
    /* JADX WARN: Type inference failed for: r11v17 */
    /* JADX WARN: Type inference failed for: r11v22 */
    /* JADX WARN: Type inference failed for: r11v23 */
    /* JADX WARN: Type inference failed for: r11v24 */
    /* JADX WARN: Type inference failed for: r11v25 */
    /* JADX WARN: Type inference failed for: r11v26 */
    /* JADX WARN: Type inference failed for: r11v27 */
    /* JADX WARN: Type inference failed for: r11v28 */
    /* JADX WARN: Type inference failed for: r11v29 */
    /* JADX WARN: Type inference failed for: r11v4 */
    /* JADX WARN: Type inference failed for: r11v5 */
    /* JADX WARN: Type inference failed for: r11v8, types: [z5.i] */
    /* JADX WARN: Type inference failed for: r2v6, types: [java.lang.Object] */
    public static void k(Context context, String str, z5.i iVar) {
        ?? r11;
        ?? r112;
        String str2;
        HashMap mapM;
        try {
            JSONObject jSONObject = new JSONObject(str);
            String strOptString = jSONObject.optString("url", null);
            String strOptString2 = jSONObject.optString("api", null);
            String strOptString3 = jSONObject.optString("type", "token");
            final String strOptString4 = jSONObject.optString("link_key", "playback_url");
            String strOptString5 = jSONObject.optString("default_string", "9HY(#b1q6");
            String strOptString6 = jSONObject.optString("request_type", "get");
            String strOptString7 = jSONObject.optString("request_body_type", "normal");
            String strOptString8 = jSONObject.optString("request_body", null);
            String strOptString9 = jSONObject.optString("ip_api", null);
            HashMap map = new HashMap();
            if ("daddy".equals(strOptString3)) {
                if (strOptString.contains("|")) {
                    String[] strArrSplit = strOptString.split("\\|");
                    str2 = strArrSplit[0];
                    mapM = m(strArrSplit[1]);
                } else {
                    str2 = strOptString;
                    mapM = map;
                }
                String[] strArrSplit2 = strOptString2.split("\\|");
                String str3 = strArrSplit2[0];
                String strB = a6.a.b(strArrSplit2[1]);
                p pVarN = n(mapM);
                android.support.v4.media.session.b.J(null, str2, false, null, pVarN, new z5.f(strOptString, str3, strB, pVarN, iVar, 0));
            }
            ?? M = map;
            if (strOptString2.contains("|")) {
                String[] strArrSplit3 = strOptString2.split("\\|");
                String str4 = strArrSplit3[0];
                M = m(strArrSplit3[1]);
                strOptString2 = str4;
            }
            try {
                switch (strOptString3.hashCode()) {
                    case 3463:
                        ?? r02 = M;
                        z5.i iVar2 = iVar;
                        r112 = iVar2;
                        if (strOptString3.equals("ls")) {
                            if (strOptString9 == null) {
                                strOptString9 = new String(Base64.decode("aHR0cHM6Ly9pcC1hcGkuc3RyZWFtaW5ndWNtcy5jb20v", 0));
                            }
                            String str5 = strOptString9;
                            boolean zEquals = "post".equals(strOptString6);
                            android.support.v4.media.session.b.J(null, str5, zEquals, zEquals ? o(strOptString7, strOptString8) : null, n(r02), new androidx.fragment.app.f(iVar2, strOptString2, strOptString5, r02));
                        }
                        r112.j("https://invalid_type", null);
                        break;
                    case 3677:
                        final ?? r03 = M;
                        final z5.i iVar3 = iVar;
                        r112 = iVar3;
                        if (strOptString3.equals("sp")) {
                            boolean zEquals2 = "post".equals(strOptString6);
                            final int i = 0;
                            android.support.v4.media.session.b.J(null, strOptString2, zEquals2, zEquals2 ? o(strOptString7, strOptString8) : null, n(r03), new k() { // from class: z5.d
                                @Override // z5.k
                                public final void f(String str6, boolean z10) throws JSONException {
                                    String string;
                                    String string2;
                                    switch (i) {
                                        case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                                            String str7 = strOptString4;
                                            i iVar4 = iVar3;
                                            if (z10) {
                                                try {
                                                    string = new JSONObject(str6).getString(str7);
                                                } catch (JSONException unused) {
                                                    string = null;
                                                }
                                                if (string == null) {
                                                    try {
                                                        String[] strArrSplit4 = new String(Base64.decode(new StringBuilder(str6).reverse().toString(), 0)).split("\\|", 2);
                                                        int i10 = Integer.parseInt(strArrSplit4[0]);
                                                        String str8 = strArrSplit4[1];
                                                        StringBuilder sb = new StringBuilder();
                                                        for (char c9 : str8.toCharArray()) {
                                                            if (Character.isLetter(c9)) {
                                                                char c10 = Character.isUpperCase(c9) ? 'A' : 'a';
                                                                sb.append((char) (((((c9 - c10) - i10) + 26) % 26) + c10));
                                                            } else {
                                                                sb.append(c9);
                                                            }
                                                        }
                                                        try {
                                                            string = new JSONObject(sb.toString()).getString(str7);
                                                        } catch (JSONException unused2) {
                                                            string = null;
                                                        }
                                                        if (string == null) {
                                                            string = "https://error";
                                                        }
                                                    } catch (Exception e9) {
                                                        string = "https://" + e9.getMessage();
                                                    }
                                                }
                                                iVar4.j(string, string.contains("|") ? null : r03);
                                            } else {
                                                iVar4.j("http://error", null);
                                            }
                                            break;
                                        default:
                                            String str9 = strOptString4;
                                            i iVar5 = iVar3;
                                            if (z10) {
                                                try {
                                                    string2 = new JSONObject(str6).getString(str9);
                                                } catch (JSONException unused3) {
                                                    string2 = null;
                                                }
                                                if (string2 == null) {
                                                    iVar5.j("https://error", null);
                                                } else {
                                                    iVar5.j(string2, string2.contains("|") ? null : r03);
                                                }
                                            } else {
                                                iVar5.j("http://error", null);
                                            }
                                            break;
                                    }
                                }
                            });
                        }
                        r112.j("https://invalid_type", null);
                        break;
                    case 3867:
                        M = iVar;
                        r112 = M;
                        if (strOptString3.equals("yt")) {
                            try {
                                kf.o oVar = new kf.o(0);
                                oVar.a("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/123.0.0.0 Safari/537.36");
                                android.support.v4.media.session.b.J(null, strOptString2, false, null, oVar.b(), new z5.e(M, 1));
                            } catch (Exception unused) {
                                M.j("https://error.m3u8", null);
                                return;
                            }
                        }
                        r112.j("https://invalid_type", null);
                        break;
                    case 3213227:
                        ?? r04 = M;
                        z5.i iVar4 = iVar;
                        r112 = iVar4;
                        if (strOptString3.equals("html")) {
                            Executors.newSingleThreadScheduledExecutor().execute(new n(strOptString2, r04, iVar4, 10));
                        }
                        r112.j("https://invalid_type", null);
                        break;
                    case 3271912:
                        final ?? r05 = M;
                        final z5.i iVar5 = iVar;
                        r112 = iVar5;
                        if (strOptString3.equals("json")) {
                            boolean zEquals3 = "post".equals(strOptString6);
                            final int i10 = 1;
                            android.support.v4.media.session.b.J(null, strOptString2, zEquals3, zEquals3 ? o(strOptString7, strOptString8) : null, n(r05), new k() { // from class: z5.d
                                @Override // z5.k
                                public final void f(String str6, boolean z10) throws JSONException {
                                    String string;
                                    String string2;
                                    switch (i10) {
                                        case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                                            String str7 = strOptString4;
                                            i iVar42 = iVar5;
                                            if (z10) {
                                                try {
                                                    string = new JSONObject(str6).getString(str7);
                                                } catch (JSONException unused2) {
                                                    string = null;
                                                }
                                                if (string == null) {
                                                    try {
                                                        String[] strArrSplit4 = new String(Base64.decode(new StringBuilder(str6).reverse().toString(), 0)).split("\\|", 2);
                                                        int i102 = Integer.parseInt(strArrSplit4[0]);
                                                        String str8 = strArrSplit4[1];
                                                        StringBuilder sb = new StringBuilder();
                                                        for (char c9 : str8.toCharArray()) {
                                                            if (Character.isLetter(c9)) {
                                                                char c10 = Character.isUpperCase(c9) ? 'A' : 'a';
                                                                sb.append((char) (((((c9 - c10) - i102) + 26) % 26) + c10));
                                                            } else {
                                                                sb.append(c9);
                                                            }
                                                        }
                                                        try {
                                                            string = new JSONObject(sb.toString()).getString(str7);
                                                        } catch (JSONException unused22) {
                                                            string = null;
                                                        }
                                                        if (string == null) {
                                                            string = "https://error";
                                                        }
                                                    } catch (Exception e9) {
                                                        string = "https://" + e9.getMessage();
                                                    }
                                                }
                                                iVar42.j(string, string.contains("|") ? null : r05);
                                            } else {
                                                iVar42.j("http://error", null);
                                            }
                                            break;
                                        default:
                                            String str9 = strOptString4;
                                            i iVar52 = iVar5;
                                            if (z10) {
                                                try {
                                                    string2 = new JSONObject(str6).getString(str9);
                                                } catch (JSONException unused3) {
                                                    string2 = null;
                                                }
                                                if (string2 == null) {
                                                    iVar52.j("https://error", null);
                                                } else {
                                                    iVar52.j(string2, string2.contains("|") ? null : r05);
                                                }
                                            } else {
                                                iVar52.j("http://error", null);
                                            }
                                            break;
                                    }
                                }
                            });
                        }
                        r112.j("https://invalid_type", null);
                        break;
                    case 96620249:
                        ?? r06 = M;
                        z5.i iVar6 = iVar;
                        r112 = iVar6;
                        if (strOptString3.equals("embed")) {
                            l(context, strOptString, strOptString2, r06, iVar6);
                        }
                        r112.j("https://invalid_type", null);
                        break;
                    case 110541305:
                        if (strOptString3.equals("token")) {
                            try {
                                Executors.newSingleThreadScheduledExecutor().execute(new c8.a(strOptString2, M, strOptString, iVar, 10));
                            } catch (JSONException e9) {
                                e = e9;
                                r11 = iVar;
                                r11.j("https://" + e.getMessage(), null);
                                return;
                            }
                            break;
                        }
                    default:
                        r112 = iVar;
                        r112.j("https://invalid_type", null);
                        break;
                }
            } catch (JSONException e10) {
                e = e10;
                r11 = M;
            }
        } catch (JSONException e11) {
            e = e11;
            r11 = iVar;
        }
    }

    public static void l(Context context, String str, String str2, HashMap map, z5.i iVar) {
        WebView webView = new WebView(context);
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setLoadsImagesAutomatically(true);
        settings.setDomStorageEnabled(true);
        settings.setAllowContentAccess(true);
        settings.setAllowFileAccess(true);
        settings.setMixedContentMode(0);
        settings.setMediaPlaybackRequiresUserGesture(false);
        webView.setWebViewClient(new z5.g(str, iVar));
        webView.setWebChromeClient(new z5.h());
        webView.loadUrl(str2, map);
    }

    public static HashMap m(String str) {
        HashMap map = new HashMap();
        for (String str2 : str.split("\\&")) {
            String[] strArrSplit = str2.split("\\=");
            if (strArrSplit.length != 1) {
                String str3 = strArrSplit[1];
                if (strArrSplit.length > 2) {
                    for (int i = 2; strArrSplit.length != i; i++) {
                        str3 = str3 + "=" + strArrSplit[i];
                    }
                }
                if (strArrSplit[0].equalsIgnoreCase("user-agent")) {
                    map.put("User-Agent", str3);
                } else {
                    map.put(strArrSplit[0], str3);
                }
            } else if (strArrSplit[0].equalsIgnoreCase("user-agent")) {
                map.put("User-Agent", "");
            } else {
                map.put(strArrSplit[0], "");
            }
        }
        return map;
    }

    public static p n(HashMap map) {
        if (map.isEmpty()) {
            return null;
        }
        kf.o oVar = new kf.o(0);
        for (Map.Entry entry : map.entrySet()) {
            oVar.a((String) entry.getKey(), (String) entry.getValue());
        }
        return oVar.b();
    }

    public static kf.w o(String str, String str2) {
        s sVarG;
        s sVarG2 = null;
        if ("json".equals(str)) {
            if (str2 != null && !str2.isEmpty()) {
                ne.g gVar = s.f7522c;
                try {
                    sVarG = t1.g("application/json; charset=utf-8");
                } catch (IllegalArgumentException unused) {
                    sVarG = null;
                }
                int i = x.f7580a;
                Charset charset = ne.a.f9126a;
                if (sVarG != null) {
                    Charset charsetA = s.a(sVarG);
                    if (charsetA == null) {
                        String str3 = sVarG + "; charset=utf-8";
                        ge.i.e(str3, "<this>");
                        try {
                            sVarG2 = t1.g(str3);
                        } catch (IllegalArgumentException unused2) {
                        }
                        sVarG = sVarG2;
                    } else {
                        charset = charsetA;
                    }
                }
                byte[] bytes = str2.getBytes(charset);
                ge.i.d(bytes, "getBytes(...)");
                int length = bytes.length;
                lf.d.a(bytes.length, 0, length);
                return new kf.w(sVarG, length, bytes);
            }
        } else if (str2 != null && !str2.isEmpty()) {
            return x.c(str2.getBytes());
        }
        return null;
    }

    public static s0 q(s0 s0Var, s0 s0Var2) {
        if (s0Var != null) {
            v1.n nVar = s0Var.f12990a;
            if (s0Var2 != null) {
                SparseBooleanArray sparseBooleanArray = new SparseBooleanArray();
                for (int i = 0; i < nVar.f12877a.size(); i++) {
                    if (s0Var2.a(nVar.b(i))) {
                        int iB = nVar.b(i);
                        y1.d.g(!false);
                        sparseBooleanArray.append(iB, true);
                    }
                }
                y1.d.g(!false);
                return new s0(new v1.n(sparseBooleanArray));
            }
        }
        return s0.f12988b;
    }

    public static final boolean r(Context context) {
        NetworkCapabilities networkCapabilities;
        ge.i.e(context, "<this>");
        Object systemService = context.getSystemService("connectivity");
        ge.i.c(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
        ConnectivityManager connectivityManager = (ConnectivityManager) systemService;
        Network activeNetwork = connectivityManager.getActiveNetwork();
        return activeNetwork != null && (networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork)) != null && networkCapabilities.hasCapability(12) && networkCapabilities.hasCapability(16);
    }

    public static final Object s(w4.t tVar, boolean z10, boolean z11, l lVar) {
        ge.i.e(tVar, "db");
        tVar.a();
        tVar.b();
        vd.h hVar = (vd.h) tVar.f13996h.get();
        if (hVar == null) {
            hVar = vd.i.f13722v;
        }
        return n5.a.J(new a5.d(hVar, tVar, z11, z10, lVar, null));
    }

    public static final Cursor t(w4.t tVar, y yVar) {
        ge.i.e(tVar, "db");
        tVar.a();
        tVar.b();
        return tVar.j().Y().f0(yVar);
    }

    public static long u(y1.t tVar, int i, int i10) {
        tVar.J(i);
        if (tVar.a() < 5) {
            return -9223372036854775807L;
        }
        int iJ = tVar.j();
        if ((8388608 & iJ) != 0 || ((2096896 & iJ) >> 8) != i10 || (iJ & 32) == 0 || tVar.x() < 7 || tVar.a() < 7 || (tVar.x() & 16) != 16) {
            return -9223372036854775807L;
        }
        byte[] bArr = new byte[6];
        tVar.h(bArr, 0, 6);
        return ((((long) bArr[0]) & 255) << 25) | ((((long) bArr[1]) & 255) << 17) | ((((long) bArr[2]) & 255) << 9) | ((((long) bArr[3]) & 255) << 1) | ((255 & ((long) bArr[4])) >> 7);
    }

    public static Uri v(Uri uri) {
        if (uri.getQueryParameter("CMCD") == null) {
            return uri;
        }
        Uri.Builder builderBuildUpon = uri.buildUpon();
        builderBuildUpon.clearQuery();
        for (String str : uri.getQueryParameterNames()) {
            if (!str.equals("CMCD")) {
                Iterator<String> it = uri.getQueryParameters(str).iterator();
                while (it.hasNext()) {
                    builderBuildUpon.appendQueryParameter(str, it.next());
                }
            }
        }
        return builderBuildUpon.build();
    }

    public static d4.h w(d4.h hVar, String[] strArr, Map map) {
        int i = 0;
        if (hVar == null) {
            if (strArr == null) {
                return null;
            }
            if (strArr.length == 1) {
                return (d4.h) map.get(strArr[0]);
            }
            if (strArr.length > 1) {
                d4.h hVar2 = new d4.h();
                int length = strArr.length;
                while (i < length) {
                    hVar2.a((d4.h) map.get(strArr[i]));
                    i++;
                }
                return hVar2;
            }
        } else {
            if (strArr != null && strArr.length == 1) {
                hVar.a((d4.h) map.get(strArr[0]));
                return hVar;
            }
            if (strArr != null && strArr.length > 1) {
                int length2 = strArr.length;
                while (i < length2) {
                    hVar.a((d4.h) map.get(strArr[i]));
                    i++;
                }
            }
        }
        return hVar;
    }

    public static void x(String str, z5.i iVar) {
        if (str.startsWith("https:////")) {
            str = str.replaceFirst("https:////", "https://");
        }
        if (str.endsWith("]")) {
            str = str.substring(0, str.length() - 1);
        }
        y(str, null, iVar);
    }

    public static void y(String str, HashMap map, z5.i iVar) {
        new Handler(Looper.getMainLooper()).post(new n(str, iVar, map, 11));
    }

    public abstract void A(boolean z10);

    public abstract void C();

    public abstract void D(int i);

    public abstract String f(byte[] bArr, int i, int i10);

    public abstract int i(String str, byte[] bArr, int i, int i10);

    public abstract void p(int i);

    public void z(boolean z10) {
    }
}
