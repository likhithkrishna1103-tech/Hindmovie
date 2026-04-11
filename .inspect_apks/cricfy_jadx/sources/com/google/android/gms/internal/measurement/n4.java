package com.google.android.gms.internal.measurement;

import android.net.Uri;
import android.util.Log;
import androidx.media3.decoder.DecoderInputBuffer;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class n4 {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Object f2543g = new Object();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static volatile d4 f2544h;
    public static final AtomicInteger i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final o4 f2545a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f2546b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f2547c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile int f2548d = -1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile Object f2549e;
    public final /* synthetic */ int f;

    static {
        new AtomicReference();
        i = new AtomicInteger();
    }

    public /* synthetic */ n4(o4 o4Var, String str, Object obj, int i10) {
        this.f = i10;
        if (((Uri) o4Var.f2561w) == null) {
            throw new IllegalArgumentException("Must pass a valid SharedPreferences file name or ContentProvider URI");
        }
        this.f2545a = o4Var;
        this.f2546b = str;
        this.f2547c = obj;
    }

    public final Object a(Object obj) {
        switch (this.f) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                if (!(obj instanceof Long)) {
                    if (obj instanceof String) {
                        try {
                            break;
                        } catch (NumberFormatException unused) {
                        }
                    }
                    String string = obj.toString();
                    String str = this.f2546b;
                    StringBuilder sb = new StringBuilder(str.length() + 25 + string.length());
                    sb.append("Invalid long value for ");
                    sb.append(str);
                    sb.append(": ");
                    sb.append(string);
                    Log.e("PhenotypeFlag", sb.toString());
                }
                break;
            case 1:
                if (!(obj instanceof Boolean)) {
                    if (obj instanceof String) {
                        String str2 = (String) obj;
                        if (!y3.f2732b.matcher(str2).matches()) {
                            if (y3.f2733c.matcher(str2).matches()) {
                            }
                        }
                    }
                    String string2 = obj.toString();
                    String str3 = this.f2546b;
                    StringBuilder sb2 = new StringBuilder(str3.length() + 28 + string2.length());
                    sb2.append("Invalid boolean value for ");
                    sb2.append(str3);
                    sb2.append(": ");
                    sb2.append(string2);
                    Log.e("PhenotypeFlag", sb2.toString());
                    break;
                }
                break;
            case 2:
                if (!(obj instanceof Double)) {
                    if (!(obj instanceof Float)) {
                        if (obj instanceof String) {
                            try {
                                break;
                            } catch (NumberFormatException unused2) {
                            }
                        }
                        String string3 = obj.toString();
                        String str4 = this.f2546b;
                        StringBuilder sb3 = new StringBuilder(str4.length() + 27 + string3.length());
                        sb3.append("Invalid double value for ");
                        sb3.append(str4);
                        sb3.append(": ");
                        sb3.append(string3);
                        Log.e("PhenotypeFlag", sb3.toString());
                    }
                }
                break;
            default:
                if (obj instanceof String) {
                }
                break;
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x005a A[PHI: r2
      0x005a: PHI (r2v1 ta.g) = (r2v0 ta.g), (r2v0 ta.g), (r2v4 ta.g), (r2v4 ta.g) binds: [B:8:0x0014, B:10:0x0018, B:12:0x0024, B:18:0x0049] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x006d A[Catch: all -> 0x0057, TryCatch #0 {all -> 0x0057, blocks: (B:5:0x000b, B:7:0x000f, B:9:0x0016, B:11:0x001a, B:13:0x0026, B:15:0x0036, B:19:0x004a, B:26:0x0060, B:28:0x006d, B:30:0x0075, B:33:0x0085, B:35:0x0093, B:47:0x00b8, B:50:0x00c0, B:51:0x00c3, B:52:0x00c7, B:39:0x009c, B:41:0x00a0, B:43:0x00ae, B:45:0x00b4, B:53:0x00cc, B:54:0x00ce, B:16:0x0043, B:55:0x00cf), top: B:61:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00cc A[Catch: all -> 0x0057, TryCatch #0 {all -> 0x0057, blocks: (B:5:0x000b, B:7:0x000f, B:9:0x0016, B:11:0x001a, B:13:0x0026, B:15:0x0036, B:19:0x004a, B:26:0x0060, B:28:0x006d, B:30:0x0075, B:33:0x0085, B:35:0x0093, B:47:0x00b8, B:50:0x00c0, B:51:0x00c3, B:52:0x00c7, B:39:0x009c, B:41:0x00a0, B:43:0x00ae, B:45:0x00b4, B:53:0x00cc, B:54:0x00ce, B:16:0x0043, B:55:0x00cf), top: B:61:0x000b }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object b() {
        /*
            Method dump skipped, instruction units count: 214
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.n4.b():java.lang.Object");
    }
}
