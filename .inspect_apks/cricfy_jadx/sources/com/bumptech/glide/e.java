package com.bumptech.glide;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import app.cricfy.tv.app.ProApplication;
import java.io.Closeable;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.MappedByteBuffer;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class e {
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object a(re.q r4, androidx.lifecycle.j0 r5, xd.c r6) throws java.lang.Throwable {
        /*
            boolean r0 = r6 instanceof re.n
            if (r0 == 0) goto L13
            r0 = r6
            re.n r0 = (re.n) r0
            int r1 = r0.A
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.A = r1
            goto L18
        L13:
            re.n r0 = new re.n
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.f11041z
            int r1 = r0.A
            r2 = 1
            if (r1 == 0) goto L31
            if (r1 != r2) goto L29
            androidx.lifecycle.j0 r5 = r0.f11040y
            com.bumptech.glide.c.C(r6)     // Catch: java.lang.Throwable -> L27
            goto L64
        L27:
            r4 = move-exception
            goto L6a
        L29:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L31:
            com.bumptech.glide.c.C(r6)
            vd.h r6 = r0.f14484w
            ge.i.b(r6)
            pe.t r1 = pe.t.f10271w
            vd.f r6 = r6.C(r1)
            if (r6 != r4) goto L6e
            r0.f11040y = r5     // Catch: java.lang.Throwable -> L27
            r0.A = r2     // Catch: java.lang.Throwable -> L27
            pe.h r6 = new pe.h     // Catch: java.lang.Throwable -> L27
            vd.c r0 = u8.a.t(r0)     // Catch: java.lang.Throwable -> L27
            r6.<init>(r2, r0)     // Catch: java.lang.Throwable -> L27
            r6.w()     // Catch: java.lang.Throwable -> L27
            re.o r0 = new re.o     // Catch: java.lang.Throwable -> L27
            r0.<init>(r6)     // Catch: java.lang.Throwable -> L27
            re.p r4 = (re.p) r4     // Catch: java.lang.Throwable -> L27
            r4.g0(r0)     // Catch: java.lang.Throwable -> L27
            java.lang.Object r4 = r6.v()     // Catch: java.lang.Throwable -> L27
            wd.a r6 = wd.a.f14143v
            if (r4 != r6) goto L64
            return r6
        L64:
            r5.b()
            rd.l r4 = rd.l.f11003a
            return r4
        L6a:
            r5.b()
            throw r4
        L6e:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "awaitClose() can only be invoked from the producer context"
            r4.<init>(r5)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.e.a(re.q, androidx.lifecycle.j0, xd.c):java.lang.Object");
    }

    public static final void b(Closeable closeable, Throwable th) throws IOException {
        if (closeable != null) {
            if (th == null) {
                closeable.close();
                return;
            }
            try {
                closeable.close();
            } catch (Throwable th2) {
                ab.b.c(th, th2);
            }
        }
    }

    public static long[] c(long[]... jArr) {
        long length = 0;
        for (long[] jArr2 : jArr) {
            length += (long) jArr2.length;
        }
        int i = (int) length;
        d.e(length, "the total number of elements (%s) in the arrays must fit in an int", length == ((long) i));
        long[] jArr3 = new long[i];
        int length2 = 0;
        for (long[] jArr4 : jArr) {
            System.arraycopy(jArr4, 0, jArr3, length2, jArr4.length);
            length2 += jArr4.length;
        }
        return jArr3;
    }

    public static final long d(long j4, oe.c cVar, oe.c cVar2) {
        ge.i.e(cVar, "sourceUnit");
        ge.i.e(cVar2, "targetUnit");
        return cVar2.f9774v.convert(j4, cVar.f9774v);
    }

    public static d e(int i) {
        return i != 0 ? i != 1 ? new ka.k() : new ka.e() : new ka.k();
    }

    public static final Object f(w4.m mVar, String str, xd.c cVar) {
        Object objC = mVar.c(str, new b6.a(7), cVar);
        return objC == wd.a.f14143v ? objC : rd.l.f11003a;
    }

    public static int g(long j4) {
        return (int) (j4 ^ (j4 >>> 32));
    }

    public static boolean h(String str) {
        return ("Connection".equalsIgnoreCase(str) || "Keep-Alive".equalsIgnoreCase(str) || "Proxy-Authenticate".equalsIgnoreCase(str) || "Proxy-Authorization".equalsIgnoreCase(str) || "TE".equalsIgnoreCase(str) || "Trailers".equalsIgnoreCase(str) || "Transfer-Encoding".equalsIgnoreCase(str) || "Upgrade".equalsIgnoreCase(str)) ? false : true;
    }

    public static String i(String str, Object... objArr) {
        int iIndexOf;
        String string;
        int i = 0;
        for (int i10 = 0; i10 < objArr.length; i10++) {
            Object obj = objArr[i10];
            if (obj == null) {
                string = "null";
            } else {
                try {
                    string = obj.toString();
                } catch (Exception e9) {
                    String str2 = obj.getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(obj));
                    Logger.getLogger("com.google.common.base.Strings").log(Level.WARNING, "Exception during lenientFormat for " + str2, (Throwable) e9);
                    string = "<" + str2 + " threw " + e9.getClass().getName() + ">";
                }
            }
            objArr[i10] = string;
        }
        StringBuilder sb = new StringBuilder((objArr.length * 16) + str.length());
        int i11 = 0;
        while (i < objArr.length && (iIndexOf = str.indexOf("%s", i11)) != -1) {
            sb.append((CharSequence) str, i11, iIndexOf);
            sb.append(objArr[i]);
            i11 = iIndexOf + 2;
            i++;
        }
        sb.append((CharSequence) str, i11, str.length());
        if (i < objArr.length) {
            sb.append(" [");
            sb.append(objArr[i]);
            for (int i12 = i + 1; i12 < objArr.length; i12++) {
                sb.append(", ");
                sb.append(objArr[i12]);
            }
            sb.append(']');
        }
        return sb.toString();
    }

    public static Typeface j(Configuration configuration, Typeface typeface) {
        if (Build.VERSION.SDK_INT < 31 || configuration.fontWeightAdjustment == Integer.MAX_VALUE || configuration.fontWeightAdjustment == 0 || typeface == null) {
            return null;
        }
        return Typeface.create(typeface, w8.e.d(configuration.fontWeightAdjustment + typeface.getWeight(), 1, 1000), typeface.isItalic());
    }

    public static y5.a k(Context context, ProApplication proApplication, JSONObject jSONObject) throws JSONException {
        y5.a aVar = new y5.a();
        aVar.f14906x = "https://t.me/playztv";
        aVar.f14907y = "Notice text will be show here.";
        aVar.f14908z = "https://playztv.online/";
        aVar.A = "https://playztv.online/";
        aVar.B = "PlayZ Tv, we are still working on it to provide more better result.";
        aVar.C = "https://t.me/playztv";
        aVar.D = "";
        aVar.E = "";
        aVar.F = "no";
        aVar.G = "no";
        aVar.H = "no";
        aVar.I = "no";
        aVar.J = "test@gmail.com";
        aVar.K = "no";
        aVar.L = "";
        aVar.M = "";
        aVar.N = "";
        aVar.O = 10;
        aVar.P = 12;
        aVar.Q = 1;
        aVar.Q = Integer.parseInt(jSONObject.getString("app_version"));
        aVar.K = jSONObject.optString("update_change_log", "no");
        String string = jSONObject.getString("download_url");
        aVar.A = string;
        proApplication.H = string;
        aVar.f14906x = jSONObject.getString("telegram_url");
        aVar.f14907y = jSONObject.optString("notice", "Notice text will be show here.");
        aVar.J = jSONObject.optString("email", "test@gmail.com");
        aVar.H = jSONObject.optString("start_ad", "no");
        aVar.I = jSONObject.optString("start_ad_action", "no");
        aVar.f14908z = jSONObject.getString("web_url");
        String string2 = jSONObject.getString("message");
        String string3 = jSONObject.getString("message_url");
        proApplication.E = string2;
        proApplication.F = string3;
        aVar.D = jSONObject.optString("foot_live_url", "");
        aVar.E = jSONObject.optString("cric_live_url", "");
        aVar.B = string2;
        aVar.C = string3;
        aVar.F = jSONObject.getString("banner_ad");
        aVar.G = jSONObject.getString("banner_ad_action");
        String string4 = jSONObject.getString("sports_slug");
        boolean zStartsWith = string4.startsWith("http");
        if (!zStartsWith) {
            string4 = d.s(context) + string4;
        }
        aVar.f14904v = string4;
        aVar.f14905w = zStartsWith ? "m3u" : "custom";
        d.t(context).edit().putBoolean("tv_external_ad_enabled", "true".equals(jSONObject.optString("tv_external_ad_enbled", "false"))).apply();
        d.t(context).edit().putBoolean("external_ad_enabled", "true".equals(jSONObject.getString("external_ad_enbled"))).apply();
        d.t(context).edit().putString("external_ad_url", jSONObject.getString("external_ad_url")).apply();
        d.t(context).edit().putInt("external_ad_repeat_after", Integer.parseInt(jSONObject.getString("external_ad_repeat_after"))).apply();
        aVar.L = jSONObject.optString("supportAd", "");
        aVar.M = jSONObject.optString("supportAdInstructions", "");
        aVar.N = jSONObject.optString("supportOpenTutorial", "");
        aVar.O = Integer.parseInt(jSONObject.optString("supportWaitSeconds", "10"));
        aVar.P = Integer.parseInt(jSONObject.optString("supportReopenHours", "12"));
        return aVar;
    }

    public static void l(AnimatorSet animatorSet, ArrayList arrayList) {
        int size = arrayList.size();
        long jMax = 0;
        for (int i = 0; i < size; i++) {
            Animator animator = (Animator) arrayList.get(i);
            jMax = Math.max(jMax, animator.getDuration() + animator.getStartDelay());
        }
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(0, 0);
        valueAnimatorOfInt.setDuration(jMax);
        arrayList.add(0, valueAnimatorOfInt);
        animatorSet.playTogether(arrayList);
    }

    /* JADX WARN: Code restructure failed: missing block: B:67:0x01e2, code lost:
    
        r0 = u8.a.d(r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x01e6, code lost:
    
        android.support.v4.media.session.b.d(r2, null);
        r10 = r0;
     */
    /* JADX WARN: Finally extract failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static a5.j m(c5.a r31, java.lang.String r32) {
        /*
            Method dump skipped, instruction units count: 524
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.e.m(c5.a, java.lang.String):a5.j");
    }

    public static l1.b n(MappedByteBuffer mappedByteBuffer) throws IOException {
        long j4;
        ByteBuffer byteBufferDuplicate = mappedByteBuffer.duplicate();
        byteBufferDuplicate.order(ByteOrder.BIG_ENDIAN);
        byteBufferDuplicate.position(byteBufferDuplicate.position() + 4);
        int i = byteBufferDuplicate.getShort() & 65535;
        if (i > 100) {
            throw new IOException("Cannot read metadata.");
        }
        byteBufferDuplicate.position(byteBufferDuplicate.position() + 6);
        int i10 = 0;
        while (true) {
            if (i10 >= i) {
                j4 = -1;
                break;
            }
            int i11 = byteBufferDuplicate.getInt();
            byteBufferDuplicate.position(byteBufferDuplicate.position() + 4);
            j4 = ((long) byteBufferDuplicate.getInt()) & 4294967295L;
            byteBufferDuplicate.position(byteBufferDuplicate.position() + 4);
            if (1835365473 == i11) {
                break;
            }
            i10++;
        }
        if (j4 != -1) {
            byteBufferDuplicate.position(byteBufferDuplicate.position() + ((int) (j4 - ((long) byteBufferDuplicate.position()))));
            byteBufferDuplicate.position(byteBufferDuplicate.position() + 12);
            long j7 = ((long) byteBufferDuplicate.getInt()) & 4294967295L;
            for (int i12 = 0; i12 < j7; i12++) {
                int i13 = byteBufferDuplicate.getInt();
                long j10 = ((long) byteBufferDuplicate.getInt()) & 4294967295L;
                byteBufferDuplicate.getInt();
                if (1164798569 == i13 || 1701669481 == i13) {
                    byteBufferDuplicate.position((int) (j10 + j4));
                    l1.b bVar = new l1.b();
                    byteBufferDuplicate.order(ByteOrder.LITTLE_ENDIAN);
                    int iPosition = byteBufferDuplicate.position() + byteBufferDuplicate.getInt(byteBufferDuplicate.position());
                    bVar.f7627y = byteBufferDuplicate;
                    bVar.f7624v = iPosition;
                    int i14 = iPosition - byteBufferDuplicate.getInt(iPosition);
                    bVar.f7625w = i14;
                    bVar.f7626x = ((ByteBuffer) bVar.f7627y).getShort(i14);
                    return bVar;
                }
            }
        }
        throw new IOException("Cannot read metadata.");
    }

    public static void o(ViewGroup viewGroup, float f) {
        Drawable background = viewGroup.getBackground();
        if (background instanceof ka.i) {
            ((ka.i) background).p(f);
        }
    }

    public static void p(View view, ka.i iVar) {
        z9.a aVar = iVar.f7334w.f7318c;
        if (aVar == null || !aVar.f15336a) {
            return;
        }
        float elevation = 0.0f;
        for (ViewParent parent = view.getParent(); parent instanceof View; parent = parent.getParent()) {
            elevation += ((View) parent).getElevation();
        }
        ka.g gVar = iVar.f7334w;
        if (gVar.f7326m != elevation) {
            gVar.f7326m = elevation;
            iVar.x();
        }
    }

    public static void q(ViewGroup viewGroup) {
        Drawable background = viewGroup.getBackground();
        if (background instanceof ka.i) {
            p(viewGroup, (ka.i) background);
        }
    }
}
