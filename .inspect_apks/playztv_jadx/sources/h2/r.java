package h2;

import android.util.Base64;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import p1.n0;
import s1.b0;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class r implements s2.o {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final o f5779u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final l f5780v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final Pattern f5771w = Pattern.compile("AVERAGE-BANDWIDTH=(\\d+)\\b");

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final Pattern f5773x = Pattern.compile("VIDEO=\"((?:.|\f)+?)\"");

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final Pattern f5775y = Pattern.compile("AUDIO=\"((?:.|\f)+?)\"");

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final Pattern f5777z = Pattern.compile("SUBTITLES=\"((?:.|\f)+?)\"");
    public static final Pattern A = Pattern.compile("CLOSED-CAPTIONS=\"((?:.|\f)+?)\"");
    public static final Pattern B = Pattern.compile("[^-]BANDWIDTH=(\\d+)\\b");
    public static final Pattern C = Pattern.compile("CHANNELS=\"((?:.|\f)+?)\"");
    public static final Pattern D = Pattern.compile("VIDEO-RANGE=(SDR|PQ|HLG)");
    public static final Pattern E = Pattern.compile("CODECS=\"((?:.|\f)+?)\"");
    public static final Pattern F = Pattern.compile("SUPPLEMENTAL-CODECS=\"((?:.|\f)+?)\"");
    public static final Pattern G = Pattern.compile("RESOLUTION=(\\d+x\\d+)");
    public static final Pattern H = Pattern.compile("FRAME-RATE=([\\d\\.]+)\\b");
    public static final Pattern I = Pattern.compile("#EXT-X-TARGETDURATION:(\\d+)\\b");
    public static final Pattern J = Pattern.compile("DURATION=([\\d\\.]+)\\b");
    public static final Pattern K = Pattern.compile("[:,]DURATION=([\\d\\.]+)\\b");
    public static final Pattern L = Pattern.compile("PART-TARGET=([\\d\\.]+)\\b");
    public static final Pattern M = Pattern.compile("#EXT-X-VERSION:(\\d+)\\b");
    public static final Pattern N = Pattern.compile("#EXT-X-PLAYLIST-TYPE:(.+)\\b");
    public static final Pattern O = Pattern.compile("CAN-SKIP-UNTIL=([\\d\\.]+)\\b");
    public static final Pattern P = a("CAN-SKIP-DATERANGES");
    public static final Pattern Q = Pattern.compile("SKIPPED-SEGMENTS=(\\d+)\\b");
    public static final Pattern R = Pattern.compile("[:|,]HOLD-BACK=([\\d\\.]+)\\b");
    public static final Pattern S = Pattern.compile("PART-HOLD-BACK=([\\d\\.]+)\\b");
    public static final Pattern T = a("CAN-BLOCK-RELOAD");
    public static final Pattern U = Pattern.compile("#EXT-X-MEDIA-SEQUENCE:(\\d+)\\b");
    public static final Pattern V = Pattern.compile("#EXTINF:([\\d\\.]+)\\b");
    public static final Pattern W = Pattern.compile("#EXTINF:[\\d\\.]+\\b,(.+)");
    public static final Pattern X = Pattern.compile("LAST-MSN=(\\d+)\\b");
    public static final Pattern Y = Pattern.compile("LAST-PART=(\\d+)\\b");
    public static final Pattern Z = Pattern.compile("TIME-OFFSET=(-?[\\d\\.]+)\\b");

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public static final Pattern f5750a0 = Pattern.compile("#EXT-X-BYTERANGE:(\\d+(?:@\\d+)?)\\b");

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public static final Pattern f5751b0 = Pattern.compile("BYTERANGE=\"(\\d+(?:@\\d+)?)\\b\"");

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public static final Pattern f5752c0 = Pattern.compile("BYTERANGE-START=(\\d+)\\b");

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public static final Pattern f5753d0 = Pattern.compile("BYTERANGE-LENGTH=(\\d+)\\b");

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public static final Pattern f5754e0 = Pattern.compile("METHOD=(NONE|AES-128|SAMPLE-AES|SAMPLE-AES-CENC|SAMPLE-AES-CTR)\\s*(?:,|$)");

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public static final Pattern f5755f0 = Pattern.compile("KEYFORMAT=\"((?:.|\f)+?)\"");

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public static final Pattern f5756g0 = Pattern.compile("KEYFORMATVERSIONS=\"((?:.|\f)+?)\"");

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public static final Pattern f5757h0 = Pattern.compile("URI=\"((?:.|\f)+?)\"");

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    public static final Pattern f5758i0 = Pattern.compile("IV=([^,.*]+)");

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    public static final Pattern f5759j0 = Pattern.compile("TYPE=(AUDIO|VIDEO|SUBTITLES|CLOSED-CAPTIONS)");

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public static final Pattern f5760k0 = Pattern.compile("TYPE=(PART|MAP)");
    public static final Pattern l0 = Pattern.compile("LANGUAGE=\"((?:.|\f)+?)\"");

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    public static final Pattern f5761m0 = Pattern.compile("NAME=\"((?:.|\f)+?)\"");

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    public static final Pattern f5762n0 = Pattern.compile("GROUP-ID=\"((?:.|\f)+?)\"");

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    public static final Pattern f5763o0 = Pattern.compile("CHARACTERISTICS=\"((?:.|\f)+?)\"");

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public static final Pattern f5764p0 = Pattern.compile("INSTREAM-ID=\"((?:CC|SERVICE)\\d+)\"");

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    public static final Pattern f5765q0 = a("AUTOSELECT");

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    public static final Pattern f5766r0 = a("DEFAULT");

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    public static final Pattern f5767s0 = a("FORCED");

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    public static final Pattern f5768t0 = a("INDEPENDENT");

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public static final Pattern f5769u0 = a("GAP");

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public static final Pattern f5770v0 = a("PRECISE");

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    public static final Pattern f5772w0 = Pattern.compile("VALUE=\"((?:.|\f)+?)\"");

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    public static final Pattern f5774x0 = Pattern.compile("IMPORT=\"((?:.|\f)+?)\"");

    /* JADX INFO: renamed from: y0, reason: collision with root package name */
    public static final Pattern f5776y0 = Pattern.compile("[:,]ID=\"((?:.|\f)+?)\"");

    /* JADX INFO: renamed from: z0, reason: collision with root package name */
    public static final Pattern f5778z0 = Pattern.compile("CLASS=\"((?:.|\f)+?)\"");
    public static final Pattern A0 = Pattern.compile("START-DATE=\"((?:.|\f)+?)\"");
    public static final Pattern B0 = Pattern.compile("CUE=\"((?:.|\f)+?)\"");
    public static final Pattern C0 = Pattern.compile("END-DATE=\"((?:.|\f)+?)\"");
    public static final Pattern D0 = Pattern.compile("PLANNED-DURATION=([\\d\\.]+)\\b");
    public static final Pattern E0 = a("END-ON-NEXT");
    public static final Pattern F0 = Pattern.compile("X-ASSET-URI=\"((?:.|\f)+?)\"");
    public static final Pattern G0 = Pattern.compile("X-ASSET-LIST=\"((?:.|\f)+?)\"");
    public static final Pattern H0 = Pattern.compile("X-RESUME-OFFSET=(-?[\\d\\.]+)\\b");
    public static final Pattern I0 = Pattern.compile("X-PLAYOUT-LIMIT=([\\d\\.]+)\\b");
    public static final Pattern J0 = Pattern.compile("X-SNAP=\"((?:.|\f)+?)\"");
    public static final Pattern K0 = Pattern.compile("X-RESTRICT=\"((?:.|\f)+?)\"");
    public static final Pattern L0 = Pattern.compile("X-CONTENT-MAY-VARY=\"((?:.|\f)+?)\"");
    public static final Pattern M0 = Pattern.compile("X-TIMELINE-OCCUPIES=\"((?:.|\f)+?)\"");
    public static final Pattern N0 = Pattern.compile("X-TIMELINE-STYLE=\"((?:.|\f)+?)\"");
    public static final Pattern O0 = Pattern.compile("\\{\\$([a-zA-Z0-9\\-_]+)\\}");
    public static final Pattern P0 = Pattern.compile("\\b(X-[A-Z0-9-]+)=");

    public r(o oVar, l lVar) {
        this.f5779u = oVar;
        this.f5780v = lVar;
    }

    public static Pattern a(String str) {
        return Pattern.compile(str.concat("=(NO|YES)"));
    }

    public static p1.m b(String str, p1.l[] lVarArr) {
        p1.l[] lVarArr2 = new p1.l[lVarArr.length];
        for (int i = 0; i < lVarArr.length; i++) {
            p1.l lVar = lVarArr[i];
            lVarArr2[i] = new p1.l(lVar.f9892v, lVar.f9893w, lVar.f9894x, null);
        }
        return new p1.m(str, true, lVarArr2);
    }

    public static p1.l c(String str, String str2, HashMap map) throws n0 {
        String strJ = j(str, f5756g0, "1", map);
        boolean zEquals = "urn:uuid:edef8ba9-79d6-4ace-a3c8-27dcd51d21ed".equals(str2);
        Pattern pattern = f5757h0;
        if (zEquals) {
            String strK = k(str, pattern, map);
            return new p1.l(p1.g.f9748d, null, "video/mp4", Base64.decode(strK.substring(strK.indexOf(44)), 0));
        }
        if ("com.widevine".equals(str2)) {
            UUID uuid = p1.g.f9748d;
            int i = b0.f11647a;
            return new p1.l(uuid, null, "hls", str.getBytes(StandardCharsets.UTF_8));
        }
        if (!"com.microsoft.playready".equals(str2) || !"1".equals(strJ)) {
            return null;
        }
        String strK2 = k(str, pattern, map);
        byte[] bArrDecode = Base64.decode(strK2.substring(strK2.indexOf(44)), 0);
        UUID uuid2 = p1.g.f9749e;
        return new p1.l(uuid2, null, "video/mp4", q3.q.a(uuid2, null, bArrDecode));
    }

    /*  JADX ERROR: Type inference failed with stack overflow
        jadx.core.utils.exceptions.JadxOverflowException
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:77)
        */
    public static h2.l d(h2.o r113, h2.l r114, a7.b r115, java.lang.String r116) {
        /*
            Method dump skipped, instruction units count: 4434
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: h2.r.d(h2.o, h2.l, a7.b, java.lang.String):h2.l");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:162:0x046b  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x01c6  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x01ce  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x01d0  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x020a  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x021e  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0228  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0241  */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v44 */
    /* JADX WARN: Type inference failed for: r0v45 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static h2.o f(a7.b r43, java.lang.String r44) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 1638
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: h2.r.f(a7.b, java.lang.String):h2.o");
    }

    public static boolean g(String str, Pattern pattern) {
        Matcher matcher = pattern.matcher(str);
        if (matcher.find()) {
            return "YES".equals(matcher.group(1));
        }
        return false;
    }

    public static double h(String str, Pattern pattern, double d10) {
        Matcher matcher = pattern.matcher(str);
        if (!matcher.find()) {
            return d10;
        }
        String strGroup = matcher.group(1);
        strGroup.getClass();
        return Double.parseDouble(strGroup);
    }

    public static long i(String str, Pattern pattern) {
        Matcher matcher = pattern.matcher(str);
        if (!matcher.find()) {
            return -1L;
        }
        String strGroup = matcher.group(1);
        strGroup.getClass();
        return Long.parseLong(strGroup);
    }

    public static String j(String str, Pattern pattern, String str2, Map map) {
        Matcher matcher = pattern.matcher(str);
        if (matcher.find()) {
            str2 = matcher.group(1);
            str2.getClass();
        }
        return (map.isEmpty() || str2 == null) ? str2 : l(str2, map);
    }

    public static String k(String str, Pattern pattern, Map map) throws n0 {
        String strJ = j(str, pattern, null, map);
        if (strJ != null) {
            return strJ;
        }
        throw n0.b("Couldn't match " + pattern.pattern() + " in " + str, null);
    }

    public static String l(String str, Map map) {
        Matcher matcher = O0.matcher(str);
        StringBuffer stringBuffer = new StringBuffer();
        while (matcher.find()) {
            String strGroup = matcher.group(1);
            if (map.containsKey(strGroup)) {
                matcher.appendReplacement(stringBuffer, Matcher.quoteReplacement((String) map.get(strGroup)));
            }
        }
        matcher.appendTail(stringBuffer);
        return stringBuffer.toString();
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x003f A[Catch: all -> 0x0096, TryCatch #0 {all -> 0x0096, blocks: (B:3:0x000f, B:5:0x0018, B:7:0x0020, B:10:0x0029, B:32:0x0069, B:34:0x006f, B:37:0x007a, B:39:0x0082, B:44:0x0098, B:46:0x00a0, B:48:0x00a8, B:50:0x00b0, B:52:0x00b8, B:54:0x00c0, B:56:0x00c8, B:58:0x00d0, B:61:0x00d9, B:62:0x00dd, B:67:0x00ff, B:68:0x0105, B:13:0x0030, B:15:0x0036, B:19:0x003f, B:22:0x0048, B:24:0x0051, B:26:0x0057, B:28:0x005d, B:29:0x0062), top: B:71:0x000f }] */
    /* JADX WARN: Removed duplicated region for block: B:90:0x004f A[SYNTHETIC] */
    @Override // s2.o
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object e(android.net.Uri r7, v1.k r8) throws p1.n0 {
        /*
            Method dump skipped, instruction units count: 266
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: h2.r.e(android.net.Uri, v1.k):java.lang.Object");
    }
}
