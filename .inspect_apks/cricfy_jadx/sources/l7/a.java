package l7;

import ag.o;
import ag.u;
import ag.v;
import ag.w;
import android.content.ClipDescription;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.LoudnessCodecController;
import android.media.MediaCodec;
import android.net.Uri;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.appcompat.widget.SwitchCompat;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import b6.f;
import com.google.android.gms.internal.measurement.j4;
import com.google.firebase.messaging.FirebaseMessagingService;
import d8.j;
import f9.a0;
import java.io.BufferedReader;
import java.io.IOException;
import java.lang.ref.ReferenceQueue;
import java.net.URLEncoder;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import l0.e;
import o.q0;
import o.r;
import p2.i;
import pe.x;
import q5.k;
import q5.l;
import v0.g;
import vc.e1;
import vc.h0;
import vc.p;
import w2.m;
import w4.s;
import x6.h;
import ya.q;
import yc.n;
import z6.b0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class a implements b, lb.b, lb.a, v, s0.c, g, xc.b, z7.b {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ int f7865v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public Object f7866w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public Object f7867x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public Object f7868y;

    public /* synthetic */ a(int i, boolean z10) {
        this.f7865v = i;
    }

    public static a B(LayoutInflater layoutInflater) {
        View viewInflate = layoutInflater.inflate(l.dialog_floating_player, (ViewGroup) null, false);
        int i = k.enable_sw;
        SwitchCompat switchCompat = (SwitchCompat) android.support.v4.media.session.b.l(viewInflate, i);
        if (switchCompat != null) {
            i = k.sp;
            Spinner spinner = (Spinner) android.support.v4.media.session.b.l(viewInflate, i);
            if (spinner != null) {
                return new a((LinearLayout) viewInflate, switchCompat, spinner, 16);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
    }

    public static a E(Context context, AttributeSet attributeSet, int[] iArr) {
        return new a(context, context.obtainStyledAttributes(attributeSet, iArr));
    }

    public static a F(Context context, AttributeSet attributeSet, int[] iArr, int i) {
        return new a(context, context.obtainStyledAttributes(attributeSet, iArr, i, 0));
    }

    public static a k(View view) {
        int i = k.swipeImageView;
        ImageView imageView = (ImageView) android.support.v4.media.session.b.l(view, i);
        if (imageView != null) {
            CardView cardView = (CardView) view;
            int i10 = k.swipeTextView;
            TextView textView = (TextView) android.support.v4.media.session.b.l(view, i10);
            if (textView != null) {
                return new a(imageView, cardView, textView, 18);
            }
            i = i10;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static String o(String str, HashMap map) {
        StringBuilder sb = new StringBuilder();
        Iterator it = map.entrySet().iterator();
        Map.Entry entry = (Map.Entry) it.next();
        sb.append((String) entry.getKey());
        sb.append("=");
        sb.append(entry.getValue() != null ? URLEncoder.encode((String) entry.getValue(), "UTF-8") : "");
        while (it.hasNext()) {
            Map.Entry entry2 = (Map.Entry) it.next();
            sb.append("&");
            sb.append((String) entry2.getKey());
            sb.append("=");
            sb.append(entry2.getValue() != null ? URLEncoder.encode((String) entry2.getValue(), "UTF-8") : "");
        }
        String string = sb.toString();
        if (string.isEmpty()) {
            return str;
        }
        if (str.contains("?")) {
            if (!str.endsWith("&")) {
                string = "&".concat(string);
            }
            return e.j(str, string);
        }
        return str + "?" + string;
    }

    @Override // lb.b
    public void A(String str, Bundle bundle) {
        CountDownLatch countDownLatch = (CountDownLatch) this.f7868y;
        if (countDownLatch != null && "_ae".equals(str)) {
            countDownLatch.countDown();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x005b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void C(b2.h r8, android.net.Uri r9, java.util.Map r10, long r11, long r13, s2.s0 r15) throws g3.d {
        /*
            Method dump skipped, instruction units count: 210
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: l7.a.C(b2.h, android.net.Uri, java.util.Map, long, long, s2.s0):void");
    }

    public String D() {
        if (!y()) {
            throw new NoSuchElementException();
        }
        String str = (String) this.f7868y;
        this.f7868y = null;
        return str;
    }

    public void G() {
        ((TypedArray) this.f7867x).recycle();
    }

    public void H(MediaCodec mediaCodec) {
        LoudnessCodecController loudnessCodecController;
        if (!((HashSet) this.f7866w).remove(mediaCodec) || (loudnessCodecController = (LoudnessCodecController) this.f7868y) == null) {
            return;
        }
        loudnessCodecController.removeMediaCodec(mediaCodec);
    }

    public void I(int i) {
        LoudnessCodecController loudnessCodecController = (LoudnessCodecController) this.f7868y;
        if (loudnessCodecController != null) {
            loudnessCodecController.close();
            this.f7868y = null;
        }
        LoudnessCodecController loudnessCodecControllerCreate = LoudnessCodecController.create(i, q.f15009v, new i(this));
        this.f7868y = loudnessCodecControllerCreate;
        Iterator it = ((HashSet) this.f7866w).iterator();
        while (it.hasNext()) {
            if (!loudnessCodecControllerCreate.addMediaCodec((MediaCodec) it.next())) {
                it.remove();
            }
        }
    }

    public void J(String str) {
        if (str == null) {
            throw new NullPointerException("Null backendName");
        }
        this.f7866w = str;
    }

    public void K() {
        synchronized (this) {
            ((AtomicInteger) this.f7867x).decrementAndGet();
            if (((AtomicInteger) this.f7867x).get() < 0) {
                throw new IllegalStateException("Unbalanced call to unblock() detected.");
            }
        }
    }

    @Override // v0.g
    public ClipDescription a() {
        return (ClipDescription) this.f7867x;
    }

    @Override // s0.c
    public boolean b(Object obj) {
        if (obj instanceof t7.b) {
            ((t7.b) obj).b().f11948a = true;
        }
        ((t7.c) this.f7867x).f(obj);
        return ((s0.e) this.f7868y).b(obj);
    }

    @Override // v0.g
    public Object c() {
        return null;
    }

    @Override // ag.v
    public w d() {
        return (ag.q) this.f7867x;
    }

    @Override // l7.b
    public b0 e(b0 b0Var, h hVar) {
        Drawable drawable = (Drawable) b0Var.get();
        if (drawable instanceof BitmapDrawable) {
            return ((o) this.f7867x).e(g7.d.b((a7.b) this.f7866w, ((BitmapDrawable) drawable).getBitmap()), hVar);
        }
        if (drawable instanceof k7.b) {
            return ((d) this.f7868y).e(b0Var, hVar);
        }
        return null;
    }

    @Override // v0.g
    public Uri f() {
        return (Uri) this.f7866w;
    }

    @Override // qd.a
    public Object get() {
        switch (this.f7865v) {
            case 22:
                Context context = (Context) ((ma.e) this.f7866w).f8417v;
                vd.h hVar = (vd.h) ((qd.a) this.f7867x).get();
                h0 h0Var = (h0) ((xc.c) this.f7868y).get();
                ge.i.e(context, "appContext");
                ge.i.e(hVar, "blockingDispatcher");
                ge.i.e(h0Var, "sessionDataSerializer");
                return vc.q.b(h0Var, new e1.a(new df.l(5, h0Var)), x.b(hVar), new p(context, 1));
            case 25:
                int i = 13;
                return new x7.p(new f9.b0(i), new a0(i), (c8.d) ((dd.c) this.f7866w).get(), (j) ((tb.c) this.f7867x).get(), (nc.p) ((f) this.f7868y).get());
            default:
                return new n((vd.h) ((qd.a) this.f7866w).get(), (e1) ((qd.a) this.f7867x).get(), (d1.i) ((xc.c) this.f7868y).get());
        }
    }

    @Override // v0.g
    public Uri h() {
        return (Uri) this.f7868y;
    }

    @Override // s0.c
    public Object i() {
        Object objI = ((s0.e) this.f7868y).i();
        if (objI == null) {
            objI = ((t7.a) this.f7866w).o();
            if (Log.isLoggable("FactoryPools", 2)) {
                Log.v("FactoryPools", "Created new " + objI.getClass());
            }
        }
        if (objI instanceof t7.b) {
            ((t7.b) objI).b().f11948a = false;
        }
        return objI;
    }

    public synchronized void j(x6.e eVar, z6.v vVar) {
        z6.a aVar = (z6.a) ((HashMap) this.f7866w).put(eVar, new z6.a(eVar, vVar, (ReferenceQueue) this.f7867x));
        if (aVar != null) {
            aVar.f15226c = null;
            aVar.clear();
        }
    }

    public boolean l() {
        synchronized (this) {
            if (((AtomicBoolean) this.f7868y).get()) {
                return false;
            }
            ((AtomicInteger) this.f7867x).incrementAndGet();
            return true;
        }
    }

    public x7.i m() {
        String strConcat = ((String) this.f7866w) == null ? " backendName" : "";
        if (((u7.d) this.f7868y) == null) {
            strConcat = strConcat.concat(" priority");
        }
        if (strConcat.isEmpty()) {
            return new x7.i((String) this.f7866w, (byte[]) this.f7867x, (u7.d) this.f7868y);
        }
        throw new IllegalStateException("Missing required properties:".concat(strConcat));
    }

    public void n(z6.a aVar) {
        b0 b0Var;
        synchronized (this) {
            ((HashMap) this.f7866w).remove(aVar.f15224a);
            if (aVar.f15225b && (b0Var = aVar.f15226c) != null) {
                ((z6.n) this.f7868y).f(aVar.f15224a, new z6.v(b0Var, true, false, aVar.f15224a, (z6.n) this.f7868y));
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00c2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public ag.o p() throws java.lang.Throwable {
        /*
            r8 = this;
            java.lang.String r0 = "FirebaseCrashlytics"
            java.lang.String r1 = "GET Request URL: "
            ob.c.b()
            r2 = 0
            java.lang.Object r3 = r8.f7866w     // Catch: java.lang.Throwable -> Lb9
            java.lang.String r3 = (java.lang.String) r3     // Catch: java.lang.Throwable -> Lb9
            java.lang.Object r4 = r8.f7867x     // Catch: java.lang.Throwable -> Lb9
            java.util.HashMap r4 = (java.util.HashMap) r4     // Catch: java.lang.Throwable -> Lb9
            java.lang.String r3 = o(r3, r4)     // Catch: java.lang.Throwable -> Lb4
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lb4
            r4.<init>(r1)     // Catch: java.lang.Throwable -> Lb4
            r4.append(r3)     // Catch: java.lang.Throwable -> Lb4
            java.lang.String r1 = r4.toString()     // Catch: java.lang.Throwable -> Lb4
            r4 = 2
            boolean r4 = android.util.Log.isLoggable(r0, r4)     // Catch: java.lang.Throwable -> L2b
            if (r4 == 0) goto L2e
            android.util.Log.v(r0, r1, r2)     // Catch: java.lang.Throwable -> L2b
            goto L2e
        L2b:
            r0 = move-exception
            goto Lb7
        L2e:
            java.net.URL r0 = new java.net.URL     // Catch: java.lang.Throwable -> Lb4
            r0.<init>(r3)     // Catch: java.lang.Throwable -> Lb4
            java.net.URLConnection r0 = r0.openConnection()     // Catch: java.lang.Throwable -> Lb4
            javax.net.ssl.HttpsURLConnection r0 = (javax.net.ssl.HttpsURLConnection) r0     // Catch: java.lang.Throwable -> Lb4
            r1 = 10000(0x2710, float:1.4013E-41)
            r0.setReadTimeout(r1)     // Catch: java.lang.Throwable -> L6e
            r0.setConnectTimeout(r1)     // Catch: java.lang.Throwable -> L6e
            java.lang.String r1 = "GET"
            r0.setRequestMethod(r1)     // Catch: java.lang.Throwable -> L6e
            java.lang.Object r1 = r8.f7868y     // Catch: java.lang.Throwable -> L6e
            java.util.HashMap r1 = (java.util.HashMap) r1     // Catch: java.lang.Throwable -> L6e
            java.util.Set r1 = r1.entrySet()     // Catch: java.lang.Throwable -> L6e
            java.util.Iterator r1 = r1.iterator()     // Catch: java.lang.Throwable -> L6e
        L52:
            boolean r3 = r1.hasNext()     // Catch: java.lang.Throwable -> L6e
            if (r3 == 0) goto L70
            java.lang.Object r3 = r1.next()     // Catch: java.lang.Throwable -> L6e
            java.util.Map$Entry r3 = (java.util.Map.Entry) r3     // Catch: java.lang.Throwable -> L6e
            java.lang.Object r4 = r3.getKey()     // Catch: java.lang.Throwable -> L6e
            java.lang.String r4 = (java.lang.String) r4     // Catch: java.lang.Throwable -> L6e
            java.lang.Object r3 = r3.getValue()     // Catch: java.lang.Throwable -> L6e
            java.lang.String r3 = (java.lang.String) r3     // Catch: java.lang.Throwable -> L6e
            r0.addRequestProperty(r4, r3)     // Catch: java.lang.Throwable -> L6e
            goto L52
        L6e:
            r1 = move-exception
            goto Lbb
        L70:
            r0.connect()     // Catch: java.lang.Throwable -> L6e
            int r1 = r0.getResponseCode()     // Catch: java.lang.Throwable -> L6e
            java.io.InputStream r3 = r0.getInputStream()     // Catch: java.lang.Throwable -> L6e
            if (r3 == 0) goto La6
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> La3
            java.io.InputStreamReader r4 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> La3
            java.lang.String r5 = "UTF-8"
            r4.<init>(r3, r5)     // Catch: java.lang.Throwable -> La3
            r2.<init>(r4)     // Catch: java.lang.Throwable -> La3
            r4 = 8192(0x2000, float:1.148E-41)
            char[] r4 = new char[r4]     // Catch: java.lang.Throwable -> La3
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> La3
            r5.<init>()     // Catch: java.lang.Throwable -> La3
        L92:
            int r6 = r2.read(r4)     // Catch: java.lang.Throwable -> La3
            r7 = -1
            if (r6 == r7) goto L9e
            r7 = 0
            r5.append(r4, r7, r6)     // Catch: java.lang.Throwable -> La3
            goto L92
        L9e:
            java.lang.String r2 = r5.toString()     // Catch: java.lang.Throwable -> La3
            goto La6
        La3:
            r1 = move-exception
            r2 = r3
            goto Lbb
        La6:
            if (r3 == 0) goto Lab
            r3.close()
        Lab:
            r0.disconnect()
            ag.o r0 = new ag.o
            r0.<init>(r1, r2)
            return r0
        Lb4:
            r1 = move-exception
        Lb5:
            r0 = r2
            goto Lbb
        Lb7:
            r1 = r0
            goto Lb5
        Lb9:
            r0 = move-exception
            goto Lb7
        Lbb:
            if (r2 == 0) goto Lc0
            r2.close()
        Lc0:
            if (r0 == 0) goto Lc5
            r0.disconnect()
        Lc5:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: l7.a.p():ag.o");
    }

    @Override // lb.a
    public void q(Bundle bundle) {
        synchronized (this.f7867x) {
            try {
                kb.c cVar = kb.c.f7396a;
                cVar.e("Logging event _ae to Firebase Analytics with params " + bundle);
                this.f7868y = new CountDownLatch(1);
                ((l4.a) this.f7866w).q(bundle);
                cVar.e("Awaiting app exception callback from Analytics...");
                try {
                    if (((CountDownLatch) this.f7868y).await(500, TimeUnit.MILLISECONDS)) {
                        cVar.e("App exception callback received from Analytics listener.");
                    } else {
                        cVar.f("Timeout exceeded while awaiting app exception callback from Analytics listener.", null);
                    }
                } catch (InterruptedException unused) {
                    Log.e("FirebaseCrashlytics", "Interrupted while awaiting app exception callback from Analytics listener.", null);
                }
                this.f7868y = null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public ColorStateList r(int i) {
        int resourceId;
        ColorStateList colorStateListC;
        TypedArray typedArray = (TypedArray) this.f7867x;
        return (!typedArray.hasValue(i) || (resourceId = typedArray.getResourceId(i, 0)) == 0 || (colorStateListC = i0.c.c((Context) this.f7866w, resourceId)) == null) ? typedArray.getColorStateList(i) : colorStateListC;
    }

    @Override // ag.v
    public u s() {
        return (ag.p) this.f7868y;
    }

    public long t() {
        a3.l lVar = (a3.l) this.f7868y;
        if (lVar != null) {
            return lVar.f215y;
        }
        return -1L;
    }

    public String toString() {
        switch (this.f7865v) {
            case 14:
                StringBuilder sb = new StringBuilder(32);
                sb.append((String) this.f7866w);
                sb.append('{');
                nb.w wVar = (nb.w) ((nb.w) this.f7867x).f9017x;
                String str = "";
                while (wVar != null) {
                    Object obj = wVar.f9016w;
                    sb.append(str);
                    if (obj == null || !obj.getClass().isArray()) {
                        sb.append(obj);
                    } else {
                        String strDeepToString = Arrays.deepToString(new Object[]{obj});
                        sb.append((CharSequence) strDeepToString, 1, strDeepToString.length() - 1);
                    }
                    wVar = (nb.w) wVar.f9017x;
                    str = ", ";
                }
                sb.append('}');
                return sb.toString();
            default:
                return super.toString();
        }
    }

    public Drawable u(int i) {
        int resourceId;
        TypedArray typedArray = (TypedArray) this.f7867x;
        return (!typedArray.hasValue(i) || (resourceId = typedArray.getResourceId(i, 0)) == 0) ? typedArray.getDrawable(i) : j4.i((Context) this.f7866w, resourceId);
    }

    public Drawable v(int i) {
        int resourceId;
        Drawable drawableG;
        if (!((TypedArray) this.f7867x).hasValue(i) || (resourceId = ((TypedArray) this.f7867x).getResourceId(i, 0)) == 0) {
            return null;
        }
        r rVarA = r.a();
        Context context = (Context) this.f7866w;
        synchronized (rVarA) {
            drawableG = rVarA.f9337a.g(context, resourceId, true);
        }
        return drawableG;
    }

    public Typeface w(int i, int i10, q0 q0Var) {
        int resourceId = ((TypedArray) this.f7867x).getResourceId(i, 0);
        if (resourceId == 0) {
            return null;
        }
        if (((TypedValue) this.f7868y) == null) {
            this.f7868y = new TypedValue();
        }
        Context context = (Context) this.f7866w;
        TypedValue typedValue = (TypedValue) this.f7868y;
        ThreadLocal threadLocal = k0.k.f6774a;
        if (context.isRestricted()) {
            return null;
        }
        return k0.k.b(context, resourceId, typedValue, i10, q0Var, true, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:159:0x03c7  */
    /* JADX WARN: Removed duplicated region for block: B:270:0x0202 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:281:0x03b9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0137  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0142  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0221  */
    /* JADX WARN: Type inference failed for: r0v123 */
    /* JADX WARN: Type inference failed for: r0v124, types: [int] */
    /* JADX WARN: Type inference failed for: r0v200 */
    /* JADX WARN: Type inference failed for: r0v201 */
    /* JADX WARN: Type inference failed for: r0v202 */
    /* JADX WARN: Type inference failed for: r0v203 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean x() {
        /*
            Method dump skipped, instruction units count: 1676
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: l7.a.x():boolean");
    }

    public boolean y() throws IOException {
        String strTrim;
        ArrayDeque arrayDeque = (ArrayDeque) this.f7867x;
        if (((String) this.f7868y) == null) {
            if (!arrayDeque.isEmpty()) {
                String str = (String) arrayDeque.poll();
                str.getClass();
                this.f7868y = str;
                return true;
            }
            do {
                String line = ((BufferedReader) this.f7866w).readLine();
                this.f7868y = line;
                if (line == null) {
                    return false;
                }
                strTrim = line.trim();
                this.f7868y = strTrim;
            } while (strTrim.isEmpty());
        }
        return true;
    }

    public void z(String str, String str2) {
        ((HashMap) this.f7868y).put(str, str2);
    }

    public /* synthetic */ a(Object obj, Object obj2, Object obj3, int i) {
        this.f7865v = i;
        this.f7866w = obj;
        this.f7867x = obj2;
        this.f7868y = obj3;
    }

    public a(Set set, String str, String str2) {
        this.f7865v = 7;
        Set setUnmodifiableSet = set == null ? Collections.EMPTY_SET : Collections.unmodifiableSet(set);
        Map map = Collections.EMPTY_MAP;
        this.f7867x = str2;
        this.f7868y = g9.a.f5233a;
        HashSet hashSet = new HashSet(setUnmodifiableSet);
        Iterator it = map.values().iterator();
        if (!it.hasNext()) {
            this.f7866w = Collections.unmodifiableSet(hashSet);
            return;
        }
        throw q4.a.l(it);
    }

    public a(f fVar) {
        this.f7865v = 8;
        this.f7866w = fVar;
        this.f7867x = vf.g.d((bg.d) fVar.f1802y);
        bg.c cVar = (bg.c) fVar.f1803z;
        ge.i.e(cVar, "<this>");
        this.f7868y = new ag.p(cVar);
    }

    public a(LinearLayout linearLayout, TextView textView, ProgressBar progressBar, RecyclerView recyclerView) {
        this.f7865v = 17;
        this.f7866w = textView;
        this.f7867x = progressBar;
        this.f7868y = recyclerView;
    }

    public a(s sVar) {
        this.f7865v = 23;
        this.f7866w = sVar;
        this.f7867x = new AtomicInteger(0);
        this.f7868y = new AtomicBoolean(false);
    }

    public a(String str, HashMap map) {
        this.f7865v = 11;
        this.f7866w = str;
        this.f7867x = map;
        this.f7868y = new HashMap();
    }

    public a(l4.a aVar) {
        this.f7865v = 1;
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        this.f7867x = new Object();
        this.f7866w = aVar;
    }

    public a(FirebaseMessagingService firebaseMessagingService, l4.q qVar, ExecutorService executorService) {
        this.f7865v = 3;
        this.f7866w = executorService;
        this.f7867x = firebaseMessagingService;
        this.f7868y = qVar;
    }

    @Override // v0.g
    public void g() {
    }

    public a(int i) {
        this.f7865v = i;
        switch (i) {
            case 29:
                ExecutorService executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor(new q0.k(1));
                this.f7866w = new HashMap();
                this.f7867x = new ReferenceQueue();
                executorServiceNewSingleThreadExecutor.execute(new m(3, this));
                break;
            default:
                p2.j jVar = p2.j.f9922v;
                this.f7866w = new HashSet();
                this.f7867x = jVar;
                break;
        }
    }

    public a(a3.s sVar) {
        this.f7865v = 10;
        this.f7866w = sVar;
    }

    public a(Context context, TypedArray typedArray) {
        this.f7865v = 5;
        this.f7866w = context;
        this.f7867x = typedArray;
    }

    public a(Runnable runnable) {
        this.f7865v = 12;
        this.f7867x = new CopyOnWriteArrayList();
        this.f7868y = new HashMap();
        this.f7866w = runnable;
    }

    public a(String str) {
        this.f7865v = 14;
        nb.w wVar = new nb.w(22, false);
        this.f7867x = wVar;
        this.f7868y = wVar;
        this.f7866w = str;
    }

    public a(s0.e eVar, t7.a aVar, t7.c cVar) {
        this.f7865v = 13;
        this.f7868y = eVar;
        this.f7866w = aVar;
        this.f7867x = cVar;
    }

    public a(Matcher matcher, CharSequence charSequence) {
        this.f7865v = 4;
        ge.i.e(charSequence, "input");
        this.f7866w = matcher;
        this.f7867x = new ne.f(this);
    }

    public a(ArrayDeque arrayDeque, BufferedReader bufferedReader) {
        this.f7865v = 2;
        this.f7867x = arrayDeque;
        this.f7866w = bufferedReader;
    }
}
