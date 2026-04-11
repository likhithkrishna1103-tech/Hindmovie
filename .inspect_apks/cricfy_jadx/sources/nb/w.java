package nb;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.media.LoudnessCodecController;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Trace;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.Surface;
import android.view.View;
import android.view.WindowInsetsAnimation;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import f9.m2;
import g6.i0;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import s2.z0;
import t0.m0;
import t0.p1;
import v4.c1;
import v4.e1;
import v4.f1;
import v4.x0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public class w implements ag.v, p2.k, p2.l, t0.o, w2.q, se.c {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ int f9015v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public Object f9016w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public Object f9017x;

    public /* synthetic */ w(int i, Object obj, Object obj2) {
        this.f9015v = i;
        this.f9016w = obj;
        this.f9017x = obj2;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x003a A[Catch: IOException -> 0x006d, TryCatch #0 {IOException -> 0x006d, blocks: (B:2:0x0000, B:3:0x000a, B:5:0x000d, B:7:0x001e, B:9:0x0026, B:21:0x0042, B:19:0x003a, B:20:0x003d, B:23:0x0047, B:24:0x004a, B:25:0x005b), top: B:30:0x0000 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static nb.w I(java.lang.String... r12) {
        /*
            int r0 = r12.length     // Catch: java.io.IOException -> L6d
            ag.h[] r0 = new ag.h[r0]     // Catch: java.io.IOException -> L6d
            ag.e r1 = new ag.e     // Catch: java.io.IOException -> L6d
            r1.<init>()     // Catch: java.io.IOException -> L6d
            r2 = 0
            r3 = r2
        La:
            int r4 = r12.length     // Catch: java.io.IOException -> L6d
            if (r3 >= r4) goto L5b
            r4 = r12[r3]     // Catch: java.io.IOException -> L6d
            java.lang.String[] r5 = r6.a.f10886z     // Catch: java.io.IOException -> L6d
            r6 = 34
            r1.i0(r6)     // Catch: java.io.IOException -> L6d
            int r7 = r4.length()     // Catch: java.io.IOException -> L6d
            r8 = r2
            r9 = r8
        L1c:
            if (r8 >= r7) goto L45
            char r10 = r4.charAt(r8)     // Catch: java.io.IOException -> L6d
            r11 = 128(0x80, float:1.8E-43)
            if (r10 >= r11) goto L2b
            r10 = r5[r10]     // Catch: java.io.IOException -> L6d
            if (r10 != 0) goto L38
            goto L42
        L2b:
            r11 = 8232(0x2028, float:1.1535E-41)
            if (r10 != r11) goto L32
            java.lang.String r10 = "\\u2028"
            goto L38
        L32:
            r11 = 8233(0x2029, float:1.1537E-41)
            if (r10 != r11) goto L42
            java.lang.String r10 = "\\u2029"
        L38:
            if (r9 >= r8) goto L3d
            r1.n0(r9, r8, r4)     // Catch: java.io.IOException -> L6d
        L3d:
            r1.o0(r10)     // Catch: java.io.IOException -> L6d
            int r9 = r8 + 1
        L42:
            int r8 = r8 + 1
            goto L1c
        L45:
            if (r9 >= r7) goto L4a
            r1.n0(r9, r7, r4)     // Catch: java.io.IOException -> L6d
        L4a:
            r1.i0(r6)     // Catch: java.io.IOException -> L6d
            r1.readByte()     // Catch: java.io.IOException -> L6d
            long r4 = r1.f429w     // Catch: java.io.IOException -> L6d
            ag.h r4 = r1.k(r4)     // Catch: java.io.IOException -> L6d
            r0[r3] = r4     // Catch: java.io.IOException -> L6d
            int r3 = r3 + 1
            goto La
        L5b:
            nb.w r1 = new nb.w     // Catch: java.io.IOException -> L6d
            java.lang.Object r12 = r12.clone()     // Catch: java.io.IOException -> L6d
            java.lang.String[] r12 = (java.lang.String[]) r12     // Catch: java.io.IOException -> L6d
            ag.m r0 = w1.d.o(r0)     // Catch: java.io.IOException -> L6d
            r2 = 10
            r1.<init>(r2, r12, r0)     // Catch: java.io.IOException -> L6d
            return r1
        L6d:
            r12 = move-exception
            java.lang.AssertionError r0 = new java.lang.AssertionError
            r0.<init>(r12)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: nb.w.I(java.lang.String[]):nb.w");
    }

    @Override // p2.k
    /* JADX INFO: renamed from: A, reason: merged with bridge method [inline-methods] */
    public p2.d u(c2.o oVar) throws Exception {
        MediaCodec mediaCodecCreateByCodecName;
        String str = ((p2.o) oVar.f2035b).f9925a;
        p2.d dVar = null;
        try {
            Trace.beginSection("createCodec:" + str);
            mediaCodecCreateByCodecName = MediaCodec.createByCodecName(str);
            try {
                p2.d dVar2 = new p2.d(mediaCodecCreateByCodecName, (HandlerThread) ((p2.c) this.f9016w).get(), new p2.f(mediaCodecCreateByCodecName, (HandlerThread) ((p2.c) this.f9017x).get()), (l7.a) oVar.f2039g);
                try {
                    Trace.endSection();
                    Surface surface = (Surface) oVar.f2038e;
                    p2.d.d(dVar2, (MediaFormat) oVar.f2036c, surface, (MediaCrypto) oVar.f, (surface == null && ((p2.o) oVar.f2035b).f9931h && Build.VERSION.SDK_INT >= 35) ? 8 : 0);
                    return dVar2;
                } catch (Exception e9) {
                    e = e9;
                    dVar = dVar2;
                    if (dVar != null) {
                        dVar.release();
                    } else if (mediaCodecCreateByCodecName != null) {
                        mediaCodecCreateByCodecName.release();
                    }
                    throw e;
                }
            } catch (Exception e10) {
                e = e10;
            }
        } catch (Exception e11) {
            e = e11;
            mediaCodecCreateByCodecName = null;
        }
    }

    public void B(int i) {
        int[] iArr = (int[]) this.f9016w;
        if (iArr == null) {
            int[] iArr2 = new int[Math.max(i, 10) + 1];
            this.f9016w = iArr2;
            Arrays.fill(iArr2, -1);
        } else if (i >= iArr.length) {
            int length = iArr.length;
            while (length <= i) {
                length *= 2;
            }
            int[] iArr3 = new int[length];
            this.f9016w = iArr3;
            System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
            int[] iArr4 = (int[]) this.f9016w;
            Arrays.fill(iArr4, iArr.length, iArr4.length, -1);
        }
    }

    public View C(int i, int i10, int i11, int i12) {
        u3.d dVar = (u3.d) this.f9017x;
        e1 e1Var = (e1) this.f9016w;
        int iU = e1Var.u();
        int i13 = e1Var.i();
        int i14 = i10 > i ? 1 : -1;
        View view = null;
        while (i != i10) {
            View viewT = e1Var.t(i);
            int iM = e1Var.m(viewT);
            int iV = e1Var.v(viewT);
            dVar.f12087b = iU;
            dVar.f12088c = i13;
            dVar.f12089d = iM;
            dVar.f12090e = iV;
            if (i11 != 0) {
                dVar.f12086a = i11;
                if (dVar.a()) {
                    return viewT;
                }
            }
            if (i12 != 0) {
                dVar.f12086a = i12;
                if (dVar.a()) {
                    view = viewT;
                }
            }
            i += i14;
        }
        return view;
    }

    public uc.d D(rc.e eVar) throws qc.c {
        String string;
        JSONArray jSONArray = eVar.f10945g;
        long j4 = eVar.f;
        HashSet hashSet = new HashSet();
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                String string2 = jSONObject.getString("rolloutId");
                JSONArray jSONArray2 = jSONObject.getJSONArray("affectedParameterKeys");
                if (jSONArray2.length() > 1) {
                    Log.w("FirebaseRemoteConfig", String.format("Rollout has multiple affected parameter keys.Only the first key will be included in RolloutsState. rolloutId: %s, affectedParameterKeys: %s", string2, jSONArray2));
                }
                String strOptString = jSONArray2.optString(0, "");
                rc.e eVarC = ((rc.c) this.f9016w).c();
                String string3 = null;
                if (eVarC == null) {
                    string = null;
                } else {
                    try {
                        string = eVarC.f10941b.getString(strOptString);
                    } catch (JSONException unused) {
                        string = null;
                    }
                }
                if (string == null) {
                    rc.e eVarC2 = ((rc.c) this.f9017x).c();
                    if (eVarC2 != null) {
                        try {
                            string3 = eVarC2.f10941b.getString(strOptString);
                        } catch (JSONException unused2) {
                        }
                    }
                    string = string3 != null ? string3 : "";
                }
                int i10 = uc.e.f12449a;
                uc.b bVar = new uc.b();
                if (string2 == null) {
                    throw new NullPointerException("Null rolloutId");
                }
                bVar.f12439a = string2;
                String string4 = jSONObject.getString("variantId");
                if (string4 == null) {
                    throw new NullPointerException("Null variantId");
                }
                bVar.f12440b = string4;
                if (strOptString == null) {
                    throw new NullPointerException("Null parameterKey");
                }
                bVar.f12441c = strOptString;
                bVar.f12442d = string;
                bVar.f12443e = j4;
                bVar.f = (byte) (bVar.f | 1);
                hashSet.add(bVar.a());
            } catch (JSONException e9) {
                throw new qc.c("Exception parsing rollouts metadata to create RolloutsState.", e9);
            }
        }
        return new uc.d(hashSet);
    }

    public String E(String str) {
        String str2 = (String) this.f9017x;
        Resources resources = (Resources) this.f9016w;
        int identifier = resources.getIdentifier(str, "string", str2);
        if (identifier == 0) {
            return null;
        }
        return resources.getString(identifier);
    }

    public Object F(ka.v vVar) {
        return (i0) this.f9017x;
    }

    public Object G(float f, float f10, Object obj, Object obj2, float f11, float f12, float f13) {
        ka.v vVar = (ka.v) this.f9016w;
        vVar.f7378a = f;
        vVar.f7379b = f10;
        vVar.f = obj;
        vVar.f7383g = obj2;
        vVar.f7380c = f11;
        vVar.f7381d = f12;
        vVar.f7382e = f13;
        return F(vVar);
    }

    public boolean H(View view) {
        u3.d dVar = (u3.d) this.f9017x;
        e1 e1Var = (e1) this.f9016w;
        int iU = e1Var.u();
        int i = e1Var.i();
        int iM = e1Var.m(view);
        int iV = e1Var.v(view);
        dVar.f12087b = iU;
        dVar.f12088c = i;
        dVar.f12089d = iM;
        dVar.f12090e = iV;
        dVar.f12086a = 24579;
        return dVar.a();
    }

    public void J(int i, int i10) {
        int[] iArr = (int[]) this.f9016w;
        if (iArr == null || i >= iArr.length) {
            return;
        }
        int i11 = i + i10;
        B(i11);
        int[] iArr2 = (int[]) this.f9016w;
        System.arraycopy(iArr2, i, iArr2, i11, (iArr2.length - i) - i10);
        Arrays.fill((int[]) this.f9016w, i, i11, -1);
        ArrayList arrayList = (ArrayList) this.f9017x;
        if (arrayList == null) {
            return;
        }
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            c1 c1Var = (c1) ((ArrayList) this.f9017x).get(size);
            int i12 = c1Var.f13193v;
            if (i12 >= i) {
                c1Var.f13193v = i12 + i10;
            }
        }
    }

    public void K(int i, int i10) {
        int[] iArr = (int[]) this.f9016w;
        if (iArr == null || i >= iArr.length) {
            return;
        }
        int i11 = i + i10;
        B(i11);
        int[] iArr2 = (int[]) this.f9016w;
        System.arraycopy(iArr2, i11, iArr2, i, (iArr2.length - i) - i10);
        int[] iArr3 = (int[]) this.f9016w;
        Arrays.fill(iArr3, iArr3.length - i10, iArr3.length, -1);
        ArrayList arrayList = (ArrayList) this.f9017x;
        if (arrayList == null) {
            return;
        }
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            c1 c1Var = (c1) ((ArrayList) this.f9017x).get(size);
            int i12 = c1Var.f13193v;
            if (i12 >= i) {
                if (i12 < i11) {
                    ((ArrayList) this.f9017x).remove(size);
                } else {
                    c1Var.f13193v = i12 - i10;
                }
            }
        }
    }

    public void L(q0.g gVar) {
        m2 m2Var = (m2) this.f9017x;
        kf.i iVar = (kf.i) this.f9016w;
        int i = gVar.f10339b;
        if (i != 0) {
            m2Var.execute(new androidx.emoji2.text.k(i, 3, iVar));
        } else {
            m2Var.execute(new k8.j(4, iVar, gVar.f10338a));
        }
    }

    public d4.e M(x0 x0Var, int i) {
        f1 f1Var;
        d4.e eVar;
        v.k kVar = (v.k) this.f9016w;
        int iD = kVar.d(x0Var);
        if (iD >= 0 && (f1Var = (f1) kVar.j(iD)) != null) {
            int i10 = f1Var.f13223a;
            if ((i10 & i) != 0) {
                int i11 = i10 & (~i);
                f1Var.f13223a = i11;
                if (i == 4) {
                    eVar = f1Var.f13224b;
                } else {
                    if (i != 8) {
                        throw new IllegalArgumentException("Must provide flag PRE or POST");
                    }
                    eVar = f1Var.f13225c;
                }
                if ((i11 & 12) == 0) {
                    kVar.h(iD);
                    f1Var.f13223a = 0;
                    f1Var.f13224b = null;
                    f1Var.f13225c = null;
                    f1.f13222d.b(f1Var);
                }
                return eVar;
            }
        }
        return null;
    }

    public void N(x0 x0Var) {
        f1 f1Var = (f1) ((v.k) this.f9016w).get(x0Var);
        if (f1Var == null) {
            return;
        }
        f1Var.f13223a &= -2;
    }

    public void O(x0 x0Var) {
        v.h hVar = (v.h) this.f9017x;
        int i = hVar.i() - 1;
        while (true) {
            if (i < 0) {
                break;
            }
            if (x0Var == hVar.j(i)) {
                Object[] objArr = hVar.f12530x;
                Object obj = objArr[i];
                Object obj2 = v.i.f12532a;
                if (obj != obj2) {
                    objArr[i] = obj2;
                    hVar.f12528v = true;
                }
            } else {
                i--;
            }
        }
        f1 f1Var = (f1) ((v.k) this.f9016w).remove(x0Var);
        if (f1Var != null) {
            f1Var.f13223a = 0;
            f1Var.f13224b = null;
            f1Var.f13225c = null;
            f1.f13222d.b(f1Var);
        }
    }

    public void P(int i, int i10, int i11, int i12) {
        CardView cardView = (CardView) this.f9017x;
        cardView.f636y.set(i, i10, i11, i12);
        Rect rect = cardView.f635x;
        super/*android.widget.FrameLayout*/.setPadding(i + rect.left, i10 + rect.top, i11 + rect.right, i12 + rect.bottom);
    }

    public a3.i0 Q(int i) {
        int i10 = 0;
        while (true) {
            int[] iArr = (int[]) this.f9016w;
            if (i10 >= iArr.length) {
                y1.b.g("BaseMediaChunkOutput", "Unmatched track of type: " + i);
                return new a3.o();
            }
            if (i == iArr[i10]) {
                return ((z0[]) this.f9017x)[i10];
            }
            i10++;
        }
    }

    @Override // p2.l
    public void a(Bundle bundle) {
        ((MediaCodec) this.f9016w).setParameters(bundle);
    }

    @Override // p2.l
    public void b(int i, e2.c cVar, long j4, int i10) {
        ((MediaCodec) this.f9016w).queueSecureInputBuffer(i, 0, cVar.i, j4, i10);
    }

    @Override // p2.l
    public void c(int i, int i10, long j4, int i11) {
        ((MediaCodec) this.f9016w).queueInputBuffer(i, 0, i10, j4, i11);
    }

    @Override // ag.v
    public ag.w d() {
        return (of.g) this.f9017x;
    }

    @Override // p2.l
    public int e(MediaCodec.BufferInfo bufferInfo) {
        int iDequeueOutputBuffer;
        do {
            iDequeueOutputBuffer = ((MediaCodec) this.f9016w).dequeueOutputBuffer(bufferInfo, 0L);
        } while (iDequeueOutputBuffer == -3);
        return iDequeueOutputBuffer;
    }

    @Override // p2.l
    public void f(int i) {
        ((MediaCodec) this.f9016w).releaseOutputBuffer(i, false);
    }

    @Override // p2.l
    public void flush() {
        ((MediaCodec) this.f9016w).flush();
    }

    @Override // w2.q
    public Object g(Uri uri, b2.m mVar) {
        r2.a aVar = (r2.a) ((w2.q) this.f9016w).g(uri, mVar);
        List list = (List) this.f9017x;
        return (list == null || list.isEmpty()) ? aVar : (r2.a) aVar.a(list);
    }

    @Override // p2.l
    public void h(int i) {
        ((MediaCodec) this.f9016w).setVideoScalingMode(i);
    }

    @Override // p2.l
    public /* synthetic */ boolean i(m2.e eVar) {
        return false;
    }

    @Override // t0.o
    public p1 k(View view, p1 p1Var) {
        p5.g gVar = (p5.g) this.f9017x;
        p1 p1VarI = m0.i(view, p1Var);
        if (p1VarI.f11791a.n()) {
            return p1VarI;
        }
        Rect rect = (Rect) this.f9016w;
        rect.left = p1VarI.b();
        rect.top = p1VarI.d();
        rect.right = p1VarI.c();
        rect.bottom = p1VarI.a();
        int childCount = gVar.getChildCount();
        for (int i = 0; i < childCount; i++) {
            p1 p1VarB = m0.b(gVar.getChildAt(i), p1VarI);
            rect.left = Math.min(p1VarB.b(), rect.left);
            rect.top = Math.min(p1VarB.d(), rect.top);
            rect.right = Math.min(p1VarB.c(), rect.right);
            rect.bottom = Math.min(p1VarB.a(), rect.bottom);
        }
        return p1VarI.f(rect.left, rect.top, rect.right, rect.bottom);
    }

    @Override // p2.l
    public void l(y2.i iVar, Handler handler) {
        ((MediaCodec) this.f9016w).setOnFrameRenderedListener(new p2.b(this, iVar, 1), handler);
    }

    @Override // p2.l
    public MediaFormat m() {
        return ((MediaCodec) this.f9016w).getOutputFormat();
    }

    @Override // p2.l
    public void n() {
        ((MediaCodec) this.f9016w).detachOutputSurface();
    }

    @Override // p2.l
    public ByteBuffer o(int i) {
        return ((MediaCodec) this.f9016w).getInputBuffer(i);
    }

    @Override // p2.l
    public void p(Surface surface) {
        ((MediaCodec) this.f9016w).setOutputSurface(surface);
    }

    @Override // p2.l
    public ByteBuffer q(int i) {
        return ((MediaCodec) this.f9016w).getOutputBuffer(i);
    }

    @Override // p2.l
    public void r(int i, long j4) {
        ((MediaCodec) this.f9016w).releaseOutputBuffer(i, j4);
    }

    @Override // p2.l
    public void release() {
        l7.a aVar = (l7.a) this.f9017x;
        MediaCodec mediaCodec = (MediaCodec) this.f9016w;
        try {
            int i = Build.VERSION.SDK_INT;
            if (i >= 30 && i < 33) {
                mediaCodec.stop();
            }
            if (i >= 35 && aVar != null) {
                aVar.H(mediaCodec);
            }
            mediaCodec.release();
        } catch (Throwable th) {
            if (Build.VERSION.SDK_INT >= 35 && aVar != null) {
                aVar.H(mediaCodec);
            }
            mediaCodec.release();
            throw th;
        }
    }

    @Override // ag.v
    public ag.u s() {
        return (of.f) this.f9016w;
    }

    @Override // p2.l
    public int t() {
        return ((MediaCodec) this.f9016w).dequeueInputBuffer(0L);
    }

    public String toString() {
        switch (this.f9015v) {
            case 1:
                StringBuilder sb = new StringBuilder(100);
                sb.append(this.f9017x.getClass().getSimpleName());
                sb.append('{');
                ArrayList arrayList = (ArrayList) this.f9016w;
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    sb.append((String) arrayList.get(i));
                    if (i < size - 1) {
                        sb.append(", ");
                    }
                }
                sb.append('}');
                return sb.toString();
            case 19:
                return "Bounds{lower=" + ((l0.c) this.f9016w) + " upper=" + ((l0.c) this.f9017x) + "}";
            default:
                return super.toString();
        }
    }

    public void v(Object obj, String str) {
        int length = str.length();
        String strValueOf = String.valueOf(obj);
        StringBuilder sb = new StringBuilder(length + 1 + strValueOf.length());
        sb.append(str);
        sb.append("=");
        sb.append(strValueOf);
        ((ArrayList) this.f9016w).add(sb.toString());
    }

    public void w(x0 x0Var, d4.e eVar) {
        v.k kVar = (v.k) this.f9016w;
        f1 f1VarA = (f1) kVar.get(x0Var);
        if (f1VarA == null) {
            f1VarA = f1.a();
            kVar.put(x0Var, f1VarA);
        }
        f1VarA.f13225c = eVar;
        f1VarA.f13223a |= 8;
    }

    public synchronized void x() {
        if (!((LinkedHashSet) this.f9016w).isEmpty()) {
            ((rc.j) this.f9017x).e(0L);
        }
    }

    public void y() {
        int[] iArr = (int[]) this.f9016w;
        if (iArr != null) {
            Arrays.fill(iArr, -1);
        }
        this.f9017x = null;
    }

    /* JADX WARN: Removed duplicated region for block: B:107:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0018  */
    @Override // se.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object z(se.d r7, xd.c r8) {
        /*
            Method dump skipped, instruction units count: 368
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: nb.w.z(se.d, xd.c):java.lang.Object");
    }

    public /* synthetic */ w(int i, boolean z10) {
        this.f9015v = i;
    }

    public w(Context context) {
        this.f9015v = 2;
        o8.u.g(context);
        Resources resources = context.getResources();
        this.f9016w = resources;
        this.f9017x = resources.getResourcePackageName(l8.j.common_google_play_services_unknown_issue);
    }

    public /* synthetic */ w(Object obj) {
        this.f9015v = 1;
        this.f9017x = obj;
        this.f9016w = new ArrayList();
    }

    public w(int i) {
        this.f9015v = i;
        switch (i) {
            case 3:
                l8.e eVar = l8.e.f7888d;
                this.f9016w = new SparseIntArray();
                this.f9017x = eVar;
                break;
            case 21:
                this.f9016w = new ka.v();
                this.f9017x = null;
                break;
            case 29:
                this.f9016w = new v.k(0);
                this.f9017x = new v.h();
                break;
            default:
                this.f9016w = new AtomicInteger();
                this.f9017x = new AtomicInteger();
                break;
        }
    }

    public w(RelativeLayout relativeLayout, TextView textView, RecyclerView recyclerView) {
        this.f9015v = 25;
        this.f9016w = textView;
        this.f9017x = recyclerView;
    }

    public w(i0 i0Var) {
        this.f9015v = 21;
        this.f9016w = new ka.v();
        this.f9017x = i0Var;
    }

    public w(hc.b bVar) {
        this.f9015v = 12;
        this.f9017x = Collections.synchronizedMap(new HashMap());
        this.f9016w = bVar;
    }

    public w(ab.g gVar, ic.d dVar, rc.g gVar2, rc.c cVar, Context context, rc.l lVar, ScheduledExecutorService scheduledExecutorService) {
        this.f9015v = 11;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        this.f9016w = linkedHashSet;
        this.f9017x = new rc.j(gVar, dVar, gVar2, cVar, context, linkedHashSet, lVar, scheduledExecutorService);
    }

    public w(MediaCodec mediaCodec, l7.a aVar) {
        this.f9015v = 6;
        this.f9016w = mediaCodec;
        this.f9017x = aVar;
        if (Build.VERSION.SDK_INT < 35 || aVar == null) {
            return;
        }
        LoudnessCodecController loudnessCodecController = (LoudnessCodecController) aVar.f7868y;
        if (loudnessCodecController == null || loudnessCodecController.addMediaCodec(mediaCodec)) {
            y1.d.g(((HashSet) aVar.f7866w).add(mediaCodec));
        }
    }

    public w(e1 e1Var) {
        this.f9015v = 28;
        this.f9016w = e1Var;
        u3.d dVar = new u3.d();
        dVar.f12086a = 0;
        this.f9017x = dVar;
    }

    public w(com.bumptech.glide.l lVar) {
        this.f9015v = 4;
        pf.f fVar = (pf.f) lVar.f2225y;
        this.f9016w = new of.f(lVar, fVar.e().s(), -1L, true);
        this.f9017x = new of.g(lVar, fVar.e().d(), -1L, true);
    }

    public w(WindowInsetsAnimation.Bounds bounds) {
        this.f9015v = 19;
        this.f9016w = l0.c.d(bounds.getLowerBound());
        this.f9017x = l0.c.d(bounds.getUpperBound());
    }

    public w(p5.g gVar) {
        this.f9015v = 7;
        this.f9017x = gVar;
        this.f9016w = new Rect();
    }

    public w(CardView cardView) {
        this.f9015v = 23;
        this.f9017x = cardView;
    }
}
