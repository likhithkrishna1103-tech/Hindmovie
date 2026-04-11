package h4;

import android.animation.Animator;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.graphics.ImageDecoder;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.LoudnessCodecController;
import android.media.MediaCodec;
import android.media.MediaFormat;
import android.media.session.MediaSession;
import android.media.session.PlaybackState;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import android.view.ActionMode;
import android.view.Menu;
import android.view.Surface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.n0;
import androidx.fragment.app.z0;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.internal.measurement.k4;
import com.playz.tv.activities.PlayerActivity;
import j9.j0;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.WeakHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import k8.g2;
import k8.k1;
import k8.r3;
import q0.o0;
import q0.r1;
import q0.t0;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class z implements m0.b, cb.a, com.google.android.gms.internal.measurement.c0, d4.b0, e7.b, com.bumptech.glide.load.data.d, h2.s, j2.m, q0.p, ea.s, c6.l, ne.b {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ int f5866u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public Object f5867v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public Object f5868w;

    public /* synthetic */ z(int i, Object obj, Object obj2, boolean z2) {
        this.f5866u = i;
        this.f5868w = obj;
        this.f5867v = obj2;
    }

    public static l6.y J(ImageDecoder.Source source, int i, int i10, c6.i iVar) throws IOException {
        Drawable drawableDecodeDrawable = ImageDecoder.decodeDrawable(source, new k6.b(i, i10, iVar));
        if (androidx.emoji2.text.b.w(drawableDecodeDrawable)) {
            return new l6.y(2, androidx.emoji2.text.b.j(drawableDecodeDrawable));
        }
        throw new IOException("Received unexpected drawable type for animated image, failing: " + drawableDecodeDrawable);
    }

    public static void Z(Bundle bundle) {
        if (bundle != null) {
            ClassLoader classLoader = z.class.getClassLoader();
            classLoader.getClass();
            bundle.setClassLoader(classLoader);
        }
    }

    @Override // j2.m
    public int A() {
        return ((MediaCodec) this.f5867v).dequeueInputBuffer(0L);
    }

    @Override // c6.b
    public boolean B(Object obj, File file, c6.i iVar) {
        return ((l6.b) this.f5868w).B(new l6.d(((BitmapDrawable) ((e6.b0) obj).get()).getBitmap(), (f6.a) this.f5867v), file, iVar);
    }

    @Override // q0.p
    public r1 C(View view, r1 r1Var) {
        j9.i0 i0Var = (j9.i0) this.f5867v;
        j0 j0Var = (j0) this.f5868w;
        j0 j0Var2 = new j0();
        j0Var2.f6887a = j0Var.f6887a;
        j0Var2.f6888b = j0Var.f6888b;
        j0Var2.f6889c = j0Var.f6889c;
        j0Var2.f6890d = j0Var.f6890d;
        return i0Var.b(view, r1Var, j0Var2);
    }

    public void D(int i, bd.b bVar) {
        synchronized (this.f5867v) {
            ((LinkedHashMap) this.f5868w).put(Integer.valueOf(i), bVar);
        }
    }

    public String E(c6.f fVar) {
        String str;
        g6.f fVar2 = (g6.f) ((kc.b) this.f5868w).i();
        try {
            fVar.b(fVar2.f5328u);
            byte[] bArrDigest = fVar2.f5328u.digest();
            char[] cArr = x6.m.f14292b;
            synchronized (cArr) {
                for (int i = 0; i < bArrDigest.length; i++) {
                    byte b10 = bArrDigest[i];
                    int i10 = i * 2;
                    char[] cArr2 = x6.m.f14291a;
                    cArr[i10] = cArr2[(b10 & 255) >>> 4];
                    cArr[i10 + 1] = cArr2[b10 & 15];
                }
                str = new String(cArr);
            }
            return str;
        } finally {
            ((kc.b) this.f5868w).b(fVar2);
        }
    }

    public void F() {
        this.f5867v = null;
        this.f5868w = null;
    }

    public void G() {
        synchronized (this.f5867v) {
            ((LinkedHashMap) this.f5868w).clear();
        }
    }

    public boolean H(int i) {
        boolean zContainsKey;
        synchronized (this.f5867v) {
            zContainsKey = ((LinkedHashMap) this.f5868w).containsKey(Integer.valueOf(i));
        }
        return zContainsKey;
    }

    public String I(String str, boolean z2) throws IOException {
        be.h.e(str, "file");
        Context context = (Context) this.f5867v;
        be.h.e(context, "context");
        if (!android.support.v4.media.session.b.F(str)) {
            return b8.h.g(str, z2);
        }
        Uri uri = Uri.parse(str);
        String scheme = uri.getScheme();
        if (scheme != null) {
            int iHashCode = scheme.hashCode();
            if (iHashCode != 3143036) {
                if (iHashCode == 951530617 && scheme.equals("content")) {
                    ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor = context.getContentResolver().openFileDescriptor(uri, "w");
                    if (parcelFileDescriptorOpenFileDescriptor == null) {
                        throw new IOException("FNC");
                    }
                    parcelFileDescriptorOpenFileDescriptor.close();
                    return str;
                }
            } else if (scheme.equals("file")) {
                String path = uri.getPath();
                if (path != null) {
                    str = path;
                }
                return b8.h.g(str, z2);
            }
        }
        throw new IOException("FNC");
    }

    public ea.y K(byte[] bArr) {
        byte[] bArr2;
        a7.b bVar = (a7.b) this.f5868w;
        if (bVar != null && (bArr2 = (byte[]) bVar.f618v) != null && Arrays.equals(bArr2, bArr)) {
            ea.y yVar = (ea.y) ((a7.b) this.f5868w).f620x;
            s1.d.h(yVar);
            return yVar;
        }
        v1.i iVar = (v1.i) this.f5867v;
        ea.y yVarA = ((ea.a0) iVar.f13140a).a(new l5.d(iVar, 2, bArr));
        this.f5868w = new a7.b(bArr, yVarA);
        return yVarA;
    }

    public void L(boolean z2) {
        androidx.fragment.app.v vVar = ((n0) this.f5868w).f1329v;
        if (vVar != null) {
            vVar.l().f1319l.L(true);
        }
        Iterator it = ((CopyOnWriteArrayList) this.f5867v).iterator();
        if (it.hasNext()) {
            if (it.next() != null) {
                throw new ClassCastException();
            }
            if (!z2) {
                throw null;
            }
            throw null;
        }
    }

    public void M(boolean z2) {
        n0 n0Var = (n0) this.f5868w;
        h.j jVar = n0Var.f1327t.f1423v;
        androidx.fragment.app.v vVar = n0Var.f1329v;
        if (vVar != null) {
            vVar.l().f1319l.M(true);
        }
        Iterator it = ((CopyOnWriteArrayList) this.f5867v).iterator();
        if (it.hasNext()) {
            if (it.next() != null) {
                throw new ClassCastException();
            }
            if (!z2) {
                throw null;
            }
            throw null;
        }
    }

    public void N(boolean z2) {
        androidx.fragment.app.v vVar = ((n0) this.f5868w).f1329v;
        if (vVar != null) {
            vVar.l().f1319l.N(true);
        }
        Iterator it = ((CopyOnWriteArrayList) this.f5867v).iterator();
        if (it.hasNext()) {
            if (it.next() != null) {
                throw new ClassCastException();
            }
            if (!z2) {
                throw null;
            }
            throw null;
        }
    }

    public void O(boolean z2) {
        androidx.fragment.app.v vVar = ((n0) this.f5868w).f1329v;
        if (vVar != null) {
            vVar.l().f1319l.O(true);
        }
        Iterator it = ((CopyOnWriteArrayList) this.f5867v).iterator();
        if (it.hasNext()) {
            if (it.next() != null) {
                throw new ClassCastException();
            }
            if (!z2) {
                throw null;
            }
            throw null;
        }
    }

    public void P(boolean z2) {
        androidx.fragment.app.v vVar = ((n0) this.f5868w).f1329v;
        if (vVar != null) {
            vVar.l().f1319l.P(true);
        }
        Iterator it = ((CopyOnWriteArrayList) this.f5867v).iterator();
        if (it.hasNext()) {
            if (it.next() != null) {
                throw new ClassCastException();
            }
            if (!z2) {
                throw null;
            }
            throw null;
        }
    }

    public void Q(boolean z2) {
        androidx.fragment.app.v vVar = ((n0) this.f5868w).f1329v;
        if (vVar != null) {
            vVar.l().f1319l.Q(true);
        }
        Iterator it = ((CopyOnWriteArrayList) this.f5867v).iterator();
        if (it.hasNext()) {
            if (it.next() != null) {
                throw new ClassCastException();
            }
            if (!z2) {
                throw null;
            }
            throw null;
        }
    }

    public void R(boolean z2) {
        n0 n0Var = (n0) this.f5868w;
        h.j jVar = n0Var.f1327t.f1423v;
        androidx.fragment.app.v vVar = n0Var.f1329v;
        if (vVar != null) {
            vVar.l().f1319l.R(true);
        }
        Iterator it = ((CopyOnWriteArrayList) this.f5867v).iterator();
        if (it.hasNext()) {
            if (it.next() != null) {
                throw new ClassCastException();
            }
            if (!z2) {
                throw null;
            }
            throw null;
        }
    }

    public void S(boolean z2) {
        androidx.fragment.app.v vVar = ((n0) this.f5868w).f1329v;
        if (vVar != null) {
            vVar.l().f1319l.S(true);
        }
        Iterator it = ((CopyOnWriteArrayList) this.f5867v).iterator();
        if (it.hasNext()) {
            if (it.next() != null) {
                throw new ClassCastException();
            }
            if (!z2) {
                throw null;
            }
            throw null;
        }
    }

    public void T(boolean z2) {
        androidx.fragment.app.v vVar = ((n0) this.f5868w).f1329v;
        if (vVar != null) {
            vVar.l().f1319l.T(true);
        }
        Iterator it = ((CopyOnWriteArrayList) this.f5867v).iterator();
        if (it.hasNext()) {
            if (it.next() != null) {
                throw new ClassCastException();
            }
            if (!z2) {
                throw null;
            }
            throw null;
        }
    }

    public void U(boolean z2) {
        androidx.fragment.app.v vVar = ((n0) this.f5868w).f1329v;
        if (vVar != null) {
            vVar.l().f1319l.U(true);
        }
        Iterator it = ((CopyOnWriteArrayList) this.f5867v).iterator();
        if (it.hasNext()) {
            if (it.next() != null) {
                throw new ClassCastException();
            }
            if (!z2) {
                throw null;
            }
            throw null;
        }
    }

    public void V(boolean z2) {
        androidx.fragment.app.v vVar = ((n0) this.f5868w).f1329v;
        if (vVar != null) {
            vVar.l().f1319l.V(true);
        }
        Iterator it = ((CopyOnWriteArrayList) this.f5867v).iterator();
        if (it.hasNext()) {
            if (it.next() != null) {
                throw new ClassCastException();
            }
            if (!z2) {
                throw null;
            }
            throw null;
        }
    }

    public void W(boolean z2) {
        androidx.fragment.app.v vVar = ((n0) this.f5868w).f1329v;
        if (vVar != null) {
            vVar.l().f1319l.W(true);
        }
        Iterator it = ((CopyOnWriteArrayList) this.f5867v).iterator();
        if (it.hasNext()) {
            if (it.next() != null) {
                throw new ClassCastException();
            }
            if (!z2) {
                throw null;
            }
            throw null;
        }
    }

    public void X(boolean z2) {
        androidx.fragment.app.v vVar = ((n0) this.f5868w).f1329v;
        if (vVar != null) {
            vVar.l().f1319l.X(true);
        }
        Iterator it = ((CopyOnWriteArrayList) this.f5867v).iterator();
        if (it.hasNext()) {
            if (it.next() != null) {
                throw new ClassCastException();
            }
            if (!z2) {
                throw null;
            }
            throw null;
        }
    }

    public void Y(boolean z2) {
        androidx.fragment.app.v vVar = ((n0) this.f5868w).f1329v;
        if (vVar != null) {
            vVar.l().f1319l.Y(true);
        }
        Iterator it = ((CopyOnWriteArrayList) this.f5867v).iterator();
        if (it.hasNext()) {
            if (it.next() != null) {
                throw new ClassCastException();
            }
            if (!z2) {
                throw null;
            }
            throw null;
        }
    }

    @Override // j2.m
    public void a(int i, y1.c cVar, long j5, int i10) {
        ((MediaCodec) this.f5867v).queueSecureInputBuffer(i, 0, cVar.i, j5, i10);
    }

    public boolean a0(String str) {
        be.h.e(str, "file");
        if (str.length() == 0) {
            return false;
        }
        try {
            ContentResolver contentResolver = ((Context) this.f5867v).getContentResolver();
            be.h.d(contentResolver, "getContentResolver(...)");
            b8.h.n(contentResolver, str).close();
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // j2.m
    public void b(Bundle bundle) {
        ((MediaCodec) this.f5867v).setParameters(bundle);
    }

    public Object b0(f6.h hVar) {
        HashMap map = (HashMap) this.f5868w;
        f6.c cVar = (f6.c) map.get(hVar);
        if (cVar == null) {
            cVar = new f6.c(hVar);
            map.put(hVar, cVar);
        } else {
            hVar.a();
        }
        f6.c cVar2 = cVar.f4762d;
        cVar2.f4761c = cVar.f4761c;
        cVar.f4761c.f4762d = cVar2;
        f6.c cVar3 = (f6.c) this.f5867v;
        cVar.f4762d = cVar3;
        f6.c cVar4 = cVar3.f4761c;
        cVar.f4761c = cVar4;
        cVar4.f4762d = cVar;
        cVar.f4762d.f4761c = cVar;
        ArrayList arrayList = cVar.f4760b;
        int size = arrayList != null ? arrayList.size() : 0;
        if (size > 0) {
            return cVar.f4760b.remove(size - 1);
        }
        return null;
    }

    @Override // ea.s
    public void c(Object obj) {
        r3 r3Var = (r3) this.f5867v;
        String str = r3Var.f7404u;
        g2 g2Var = (g2) this.f5868w;
        g2Var.p1();
        if (!((k1) g2Var.f2454v).A.A1(null, k8.w.N0)) {
            g2Var.D = false;
            g2Var.P1();
            g2Var.g().H.c(str, "registerTriggerAsync ran. uri");
            return;
        }
        SparseArray sparseArrayY1 = g2Var.n1().y1();
        sparseArrayY1.put(r3Var.f7406w, Long.valueOf(r3Var.f7405v));
        g2Var.n1().t1(sparseArrayY1);
        g2Var.D = false;
        g2Var.E = 1;
        g2Var.g().H.c(str, "Successfully registered trigger URI");
        g2Var.P1();
    }

    public String c0(c6.f fVar) {
        String strE;
        synchronized (((c2.b0) this.f5867v)) {
            strE = (String) ((c2.b0) this.f5867v).a(fVar);
        }
        if (strE == null) {
            strE = E(fVar);
        }
        synchronized (((c2.b0) this.f5867v)) {
            ((c2.b0) this.f5867v).d(fVar, strE);
        }
        return strE;
    }

    @Override // d4.b0
    public void d(s1.u uVar) {
        d4.f0 f0Var = (d4.f0) this.f5868w;
        SparseArray sparseArray = f0Var.f3850h;
        s1.t tVar = (s1.t) this.f5867v;
        if (uVar.x() == 0 && (uVar.x() & 128) != 0) {
            uVar.K(6);
            int iA = uVar.a() / 4;
            for (int i = 0; i < iA; i++) {
                uVar.h(tVar.f11703b, 0, 4);
                tVar.q(0);
                int i10 = tVar.i(16);
                tVar.t(3);
                if (i10 == 0) {
                    tVar.t(13);
                } else {
                    int i11 = tVar.i(13);
                    if (sparseArray.get(i11) == null) {
                        sparseArray.put(i11, new d4.c0(new d4.e0(f0Var, i11)));
                        f0Var.f3855n++;
                    }
                }
            }
            if (f0Var.f3844a != 2) {
                sparseArray.remove(0);
            }
        }
    }

    public void d0(l.a aVar) {
        ub.o oVar = (ub.o) this.f5867v;
        ((ActionMode.Callback) oVar.f12868v).onDestroyActionMode(oVar.s(aVar));
        h.b0 b0Var = (h.b0) this.f5868w;
        if (b0Var.Q != null) {
            b0Var.F.getDecorView().removeCallbacks(b0Var.R);
        }
        if (b0Var.P != null) {
            t0 t0Var = b0Var.S;
            if (t0Var != null) {
                t0Var.b();
            }
            t0 t0VarA = o0.a(b0Var.P);
            t0VarA.a(0.0f);
            b0Var.S = t0VarA;
            t0VarA.d(new h.s(2, this));
        }
        b0Var.O = null;
        ViewGroup viewGroup = b0Var.V;
        WeakHashMap weakHashMap = o0.f10475a;
        q0.d0.c(viewGroup);
        b0Var.L();
    }

    public boolean e0(l.a aVar, Menu menu) {
        ViewGroup viewGroup = ((h.b0) this.f5868w).V;
        WeakHashMap weakHashMap = o0.f10475a;
        q0.d0.c(viewGroup);
        ub.o oVar = (ub.o) this.f5867v;
        ActionMode.Callback callback = (ActionMode.Callback) oVar.f12868v;
        l.e eVarS = oVar.s(aVar);
        s.i iVar = (s.i) oVar.f12871y;
        Menu zVar = (Menu) iVar.get(menu);
        if (zVar == null) {
            zVar = new m.z((Context) oVar.f12869w, (m.k) menu);
            iVar.put(menu, zVar);
        }
        return callback.onPrepareActionMode(eVarS, zVar);
    }

    @Override // j2.m
    public void f(int i, int i10, long j5, int i11) {
        ((MediaCodec) this.f5867v).queueInputBuffer(i, 0, i10, j5, i11);
    }

    public void f0(String str, long j5) throws IOException {
        be.h.e(str, "file");
        if (str.length() == 0) {
            throw new FileNotFoundException(str.concat(" file_not_found"));
        }
        if (j5 < 1) {
            return;
        }
        Context context = (Context) this.f5867v;
        be.h.e(context, "context");
        if (!android.support.v4.media.session.b.F(str)) {
            b8.h.a(new File(str), j5);
            return;
        }
        Uri uri = Uri.parse(str);
        String scheme = uri.getScheme();
        if (scheme != null) {
            int iHashCode = scheme.hashCode();
            if (iHashCode != 3143036) {
                if (iHashCode == 951530617 && scheme.equals("content")) {
                    ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor = context.getContentResolver().openFileDescriptor(uri, "w");
                    if (parcelFileDescriptorOpenFileDescriptor == null) {
                        throw new IOException("file_allocation_error");
                    }
                    if (j5 > 0) {
                        try {
                            FileOutputStream fileOutputStream = new FileOutputStream(parcelFileDescriptorOpenFileDescriptor.getFileDescriptor());
                            if (fileOutputStream.getChannel().size() == j5) {
                                return;
                            }
                            fileOutputStream.getChannel().position(j5 - 1);
                            fileOutputStream.write(1);
                            return;
                        } catch (Exception unused) {
                            throw new IOException("file_allocation_error");
                        }
                    }
                    return;
                }
            } else if (scheme.equals("file")) {
                String path = uri.getPath();
                if (path != null) {
                    str = path;
                }
                b8.h.a(new File(str), j5);
                return;
            }
        }
        throw new IOException("file_allocation_error");
    }

    @Override // j2.m
    public void flush() {
        ((MediaCodec) this.f5867v).flush();
    }

    @Override // j2.m
    public int g(MediaCodec.BufferInfo bufferInfo) {
        int iDequeueOutputBuffer;
        do {
            iDequeueOutputBuffer = ((MediaCodec) this.f5867v).dequeueOutputBuffer(bufferInfo, 0L);
        } while (iDequeueOutputBuffer == -3);
        return iDequeueOutputBuffer;
    }

    public void g0(f6.h hVar, Object obj) {
        HashMap map = (HashMap) this.f5868w;
        f6.c cVar = (f6.c) map.get(hVar);
        if (cVar == null) {
            cVar = new f6.c(hVar);
            cVar.f4762d = cVar;
            f6.c cVar2 = (f6.c) this.f5867v;
            cVar.f4762d = cVar2.f4762d;
            cVar.f4761c = cVar2;
            cVar2.f4762d = cVar;
            cVar.f4762d.f4761c = cVar;
            map.put(hVar, cVar);
        } else {
            hVar.a();
        }
        if (cVar.f4760b == null) {
            cVar.f4760b = new ArrayList();
        }
        cVar.f4760b.add(obj);
    }

    @Override // md.a
    public Object get() {
        return new d7.d((Context) ((e7.c) this.f5867v).f4586u, (a7.b) ((wb.c) this.f5868w).get());
    }

    @Override // j2.m
    public /* synthetic */ boolean h(u5.c cVar) {
        return false;
    }

    public void h0(int i) {
        synchronized (this.f5867v) {
        }
    }

    @Override // j2.m
    public void i(int i) {
        ((MediaCodec) this.f5867v).releaseOutputBuffer(i, false);
    }

    public Object i0() {
        f6.c cVar = (f6.c) this.f5867v;
        f6.c cVar2 = cVar.f4762d;
        while (true) {
            boolean zEquals = cVar2.equals(cVar);
            Object obj = cVar2.f4759a;
            if (zEquals) {
                return null;
            }
            ArrayList arrayList = cVar2.f4760b;
            int size = arrayList != null ? arrayList.size() : 0;
            Object objRemove = size > 0 ? cVar2.f4760b.remove(size - 1) : null;
            if (objRemove != null) {
                return objRemove;
            }
            f6.c cVar3 = cVar2.f4762d;
            cVar3.f4761c = cVar2.f4761c;
            cVar2.f4761c.f4762d = cVar3;
            ((HashMap) this.f5868w).remove(obj);
            ((f6.h) obj).a();
            cVar2 = cVar2.f4762d;
        }
    }

    @Override // h2.s
    public s2.o j(h2.o oVar, h2.l lVar) {
        return new k4(((h2.s) this.f5867v).j(oVar, lVar), (List) this.f5868w);
    }

    public void j0(r rVar, Handler handler) {
        t tVar = (t) this.f5867v;
        synchronized (tVar.f5850d) {
            tVar.f5856l = rVar;
            tVar.f5847a.setCallback(rVar.f5841b, handler);
            rVar.C(tVar, handler);
        }
    }

    @Override // c6.l
    public int k(c6.i iVar) {
        return 2;
    }

    /* JADX WARN: Type inference failed for: r1v4, types: [java.util.AbstractCollection, java.util.List] */
    public void k0(h0 h0Var) {
        t tVar = (t) this.f5867v;
        tVar.f5852g = h0Var;
        synchronized (tVar.f5850d) {
            for (int iBeginBroadcast = tVar.f.beginBroadcast() - 1; iBeginBroadcast >= 0; iBeginBroadcast--) {
                try {
                    ((f) tVar.f.getBroadcastItem(iBeginBroadcast)).l(h0Var);
                } catch (RemoteException | SecurityException e10) {
                    Log.e("MediaSessionCompat", "Dead object in setPlaybackState.", e10);
                }
            }
            tVar.f.finishBroadcast();
        }
        MediaSession mediaSession = tVar.f5847a;
        if (h0Var.F == null) {
            PlaybackState.Builder builder = new PlaybackState.Builder();
            builder.setState(h0Var.f5811u, h0Var.f5812v, h0Var.f5814x, h0Var.B);
            builder.setBufferedPosition(h0Var.f5813w);
            builder.setActions(h0Var.f5815y);
            builder.setErrorMessage(h0Var.A);
            for (g0 g0Var : h0Var.C) {
                g0Var.getClass();
                PlaybackState.CustomAction.Builder builder2 = new PlaybackState.CustomAction.Builder(g0Var.f5807u, g0Var.f5808v, g0Var.f5809w);
                builder2.setExtras(g0Var.f5810x);
                PlaybackState.CustomAction customActionBuild = builder2.build();
                if (customActionBuild != null) {
                    builder.addCustomAction(customActionBuild);
                }
            }
            builder.setActiveQueueItemId(h0Var.D);
            builder.setExtras(h0Var.E);
            h0Var.F = builder.build();
        }
        mediaSession.setPlaybackState(h0Var.F);
    }

    @Override // com.bumptech.glide.load.data.d
    public void l(Exception exc) {
        e6.g0 g0Var = (e6.g0) this.f5868w;
        i6.q qVar = (i6.q) this.f5867v;
        i6.q qVar2 = g0Var.f4505z;
        if (qVar2 == null || qVar2 != qVar) {
            return;
        }
        e6.g0 g0Var2 = (e6.g0) this.f5868w;
        i6.q qVar3 = (i6.q) this.f5867v;
        e6.k kVar = g0Var2.f4501v;
        e6.e eVar = g0Var2.A;
        com.bumptech.glide.load.data.e eVar2 = qVar3.f6422c;
        kVar.c(eVar, exc, eVar2, eVar2.c());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:387:0x0c64  */
    /* JADX WARN: Removed duplicated region for block: B:388:0x0c68  */
    /* JADX WARN: Type inference failed for: r13v0, types: [java.lang.Object, ub.o] */
    /* JADX WARN: Type inference failed for: r13v114, types: [com.google.android.gms.internal.measurement.n] */
    /* JADX WARN: Type inference failed for: r13v146, types: [com.google.android.gms.internal.measurement.n] */
    /* JADX WARN: Type inference failed for: r14v102, types: [com.google.android.gms.internal.measurement.n] */
    /* JADX WARN: Type inference failed for: r14v108, types: [com.google.android.gms.internal.measurement.f] */
    /* JADX WARN: Type inference failed for: r14v112, types: [com.google.android.gms.internal.measurement.n] */
    /* JADX WARN: Type inference failed for: r14v18, types: [com.google.android.gms.internal.measurement.g] */
    /* JADX WARN: Type inference failed for: r14v196, types: [com.google.android.gms.internal.measurement.g] */
    /* JADX WARN: Type inference failed for: r14v199, types: [com.google.android.gms.internal.measurement.n] */
    /* JADX WARN: Type inference failed for: r14v210 */
    /* JADX WARN: Type inference failed for: r14v237, types: [com.google.android.gms.internal.measurement.e] */
    /* JADX WARN: Type inference failed for: r14v244, types: [com.google.android.gms.internal.measurement.m] */
    /* JADX WARN: Type inference failed for: r14v248 */
    /* JADX WARN: Type inference failed for: r14v293, types: [com.google.android.gms.internal.measurement.p] */
    /* JADX WARN: Type inference failed for: r14v299 */
    /* JADX WARN: Type inference failed for: r14v300 */
    /* JADX WARN: Type inference failed for: r14v39, types: [com.google.android.gms.internal.measurement.g] */
    /* JADX WARN: Type inference failed for: r14v61, types: [com.google.android.gms.internal.measurement.j, com.google.android.gms.internal.measurement.n, com.google.android.gms.internal.measurement.o] */
    /* JADX WARN: Type inference failed for: r14v73, types: [com.google.android.gms.internal.measurement.h] */
    /* JADX WARN: Type inference failed for: r2v32, types: [com.google.android.gms.internal.measurement.t] */
    /* JADX WARN: Type inference failed for: r2v39, types: [com.google.android.gms.internal.measurement.h] */
    /* JADX WARN: Type inference failed for: r2v40, types: [com.google.android.gms.internal.measurement.t] */
    /* JADX WARN: Type inference failed for: r2v50, types: [com.google.android.gms.internal.measurement.t] */
    /* JADX WARN: Type inference failed for: r2v57, types: [com.google.android.gms.internal.measurement.h] */
    /* JADX WARN: Type inference failed for: r2v58, types: [com.google.android.gms.internal.measurement.t] */
    /* JADX WARN: Type inference failed for: r2v76 */
    /* JADX WARN: Type inference failed for: r2v88, types: [com.google.android.gms.internal.measurement.h] */
    /* JADX WARN: Type inference failed for: r2v92, types: [com.google.android.gms.internal.measurement.h] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public com.google.android.gms.internal.measurement.n l0(ub.o r13, com.google.android.gms.internal.measurement.n r14) {
        /*
            Method dump skipped, instruction units count: 3848
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: h4.z.l0(ub.o, com.google.android.gms.internal.measurement.n):com.google.android.gms.internal.measurement.n");
    }

    @Override // j2.m
    public void m(int i) {
        ((MediaCodec) this.f5867v).setVideoScalingMode(i);
    }

    /* JADX WARN: Code restructure failed: missing block: B:49:0x0131, code lost:
    
        ((com.google.android.gms.internal.measurement.k5) r2.f2306j).getClass();
        r0 = com.google.android.gms.internal.measurement.k5.c(r0, r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x013c, code lost:
    
        if (r0 == null) goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0142, code lost:
    
        if (r0.equals(null) == false) goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0144, code lost:
    
        r0 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0145, code lost:
    
        monitor-enter(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0148, code lost:
    
        if (r3 != r2.f2305h) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x014a, code lost:
    
        ((java.util.HashMap) r2.f2301c).put(r1, r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0152, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0154, code lost:
    
        monitor-exit(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0155, code lost:
    
        if (r0 == null) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x0157, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0158, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x015a, code lost:
    
        throw r0;
     */
    /* JADX WARN: Removed duplicated region for block: B:45:0x012a A[Catch: all -> 0x0042, DONT_GENERATE, TryCatch #1 {all -> 0x0042, blocks: (B:5:0x0015, B:7:0x001d, B:13:0x007b, B:15:0x0088, B:18:0x0095, B:20:0x0097, B:22:0x009e, B:24:0x00a6, B:26:0x00aa, B:27:0x00ae, B:28:0x00bf, B:30:0x00c5, B:31:0x00f5, B:33:0x00fb, B:35:0x0105, B:36:0x0108, B:37:0x010f, B:38:0x0111, B:40:0x011b, B:43:0x0128, B:45:0x012a, B:47:0x012c, B:48:0x0130, B:10:0x0045, B:12:0x004f), top: B:75:0x0015 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object m0() {
        /*
            Method dump skipped, instruction units count: 361
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: h4.z.m0():java.lang.Object");
    }

    @Override // j2.m
    public void n(u2.i iVar, Handler handler) {
        ((MediaCodec) this.f5867v).setOnFrameRenderedListener(new j2.b(this, iVar, 1), handler);
    }

    public void n0(com.google.android.gms.internal.measurement.s sVar) {
        ArrayList arrayList = sVar.f3185a;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            ((HashMap) this.f5867v).put(((com.google.android.gms.internal.measurement.g0) obj).toString(), sVar);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0062, code lost:
    
        if (r1.h(r6, r7, r0) == r4) goto L24;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // ne.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object o(ne.c r6, td.c r7) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r7 instanceof ne.d
            if (r0 == 0) goto L13
            r0 = r7
            ne.d r0 = (ne.d) r0
            int r1 = r0.f8997y
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f8997y = r1
            goto L18
        L13:
            ne.d r0 = new ne.d
            r0.<init>(r5, r7)
        L18:
            java.lang.Object r7 = r0.f8996x
            int r1 = r0.f8997y
            r2 = 2
            r3 = 1
            sd.a r4 = sd.a.f11942u
            if (r1 == 0) goto L3a
            if (r1 == r3) goto L32
            if (r1 != r2) goto L2a
            i5.a.Q(r7)
            goto L65
        L2a:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L32:
            ne.c r6 = r0.B
            h4.z r1 = r0.A
            i5.a.Q(r7)
            goto L4f
        L3a:
            i5.a.Q(r7)
            java.lang.Object r7 = r5.f5867v
            ne.b r7 = (ne.b) r7
            r0.A = r5
            r0.B = r6
            r0.f8997y = r3
            java.io.Serializable r7 = ne.o.a(r7, r6, r0)
            if (r7 != r4) goto L4e
            goto L64
        L4e:
            r1 = r5
        L4f:
            java.lang.Throwable r7 = (java.lang.Throwable) r7
            if (r7 == 0) goto L65
            java.lang.Object r1 = r1.f5868w
            cc.a0 r1 = (cc.a0) r1
            r3 = 0
            r0.A = r3
            r0.B = r3
            r0.f8997y = r2
            java.lang.Object r6 = r1.h(r6, r7, r0)
            if (r6 != r4) goto L65
        L64:
            return r4
        L65:
            nd.k r6 = nd.k.f8990a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: h4.z.o(ne.c, td.c):java.lang.Object");
    }

    @Override // m0.b
    public void onCancel() {
        ((Animator) this.f5867v).end();
        if (n0.G(2)) {
            Log.v("FragmentManager", "Animator from operation " + ((z0) this.f5868w) + " has been canceled.");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0077  */
    @Override // ea.s
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void p(java.lang.Throwable r10) {
        /*
            Method dump skipped, instruction units count: 339
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: h4.z.p(java.lang.Throwable):void");
    }

    @Override // j2.m
    public MediaFormat q() {
        return ((MediaCodec) this.f5867v).getOutputFormat();
    }

    @Override // com.bumptech.glide.load.data.d
    public void r(Object obj) {
        e6.g0 g0Var = (e6.g0) this.f5868w;
        i6.q qVar = (i6.q) this.f5867v;
        i6.q qVar2 = g0Var.f4505z;
        if (qVar2 == null || qVar2 != qVar) {
            return;
        }
        e6.g0 g0Var2 = (e6.g0) this.f5868w;
        i6.q qVar3 = (i6.q) this.f5867v;
        e6.m mVar = g0Var2.f4500u.f4519p;
        if (obj != null && mVar.a(qVar3.f6422c.c())) {
            g0Var2.f4504y = obj;
            g0Var2.f4501v.o(2);
        } else {
            e6.k kVar = g0Var2.f4501v;
            c6.f fVar = qVar3.f6420a;
            com.bumptech.glide.load.data.e eVar = qVar3.f6422c;
            kVar.b(fVar, obj, eVar, eVar.c(), g0Var2.A);
        }
    }

    @Override // j2.m
    public void release() {
        a7.b bVar = (a7.b) this.f5868w;
        MediaCodec mediaCodec = (MediaCodec) this.f5867v;
        try {
            int i = Build.VERSION.SDK_INT;
            if (i >= 30 && i < 33) {
                mediaCodec.stop();
            }
            if (i >= 35 && bVar != null) {
                bVar.B(mediaCodec);
            }
            mediaCodec.release();
        } catch (Throwable th) {
            if (Build.VERSION.SDK_INT >= 35 && bVar != null) {
                bVar.B(mediaCodec);
            }
            mediaCodec.release();
            throw th;
        }
    }

    @Override // j2.m
    public void s() {
        ((MediaCodec) this.f5867v).detachOutputSurface();
    }

    @Override // j2.m
    public ByteBuffer t(int i) {
        return ((MediaCodec) this.f5867v).getInputBuffer(i);
    }

    public String toString() {
        switch (this.f5866u) {
            case 14:
                StringBuilder sb2 = new StringBuilder("GroupedLinkedMap( ");
                f6.c cVar = (f6.c) this.f5867v;
                f6.c cVar2 = cVar.f4761c;
                boolean z2 = false;
                while (!cVar2.equals(cVar)) {
                    sb2.append('{');
                    sb2.append(cVar2.f4759a);
                    sb2.append(':');
                    ArrayList arrayList = cVar2.f4760b;
                    sb2.append(arrayList != null ? arrayList.size() : 0);
                    sb2.append("}, ");
                    cVar2 = cVar2.f4761c;
                    z2 = true;
                }
                if (z2) {
                    sb2.delete(sb2.length() - 2, sb2.length());
                }
                sb2.append(" )");
                return sb2.toString();
            default:
                return super.toString();
        }
    }

    @Override // j2.m
    public void u(Surface surface) {
        ((MediaCodec) this.f5867v).setOutputSurface(surface);
    }

    @Override // j2.m
    public ByteBuffer v(int i) {
        return ((MediaCodec) this.f5867v).getOutputBuffer(i);
    }

    @Override // com.google.android.gms.internal.measurement.c0
    public ub.o w(com.google.android.gms.internal.measurement.n nVar) {
        ub.o oVarB0 = ((ub.o) this.f5867v).b0();
        oVarB0.d0((String) this.f5868w, nVar);
        return oVarB0;
    }

    @Override // h2.s
    public s2.o x() {
        return new k4(((h2.s) this.f5867v).x(), (List) this.f5868w);
    }

    @Override // cb.a
    public StackTraceElement[] y(StackTraceElement[] stackTraceElementArr) {
        if (stackTraceElementArr.length <= 1024) {
            return stackTraceElementArr;
        }
        cb.a[] aVarArr = (cb.a[]) this.f5867v;
        StackTraceElement[] stackTraceElementArrY = stackTraceElementArr;
        for (int i = 0; i < 1; i++) {
            cb.a aVar = aVarArr[i];
            if (stackTraceElementArrY.length <= 1024) {
                break;
            }
            stackTraceElementArrY = aVar.y(stackTraceElementArr);
        }
        return stackTraceElementArrY.length > 1024 ? ((t7.j) this.f5868w).y(stackTraceElementArrY) : stackTraceElementArrY;
    }

    @Override // j2.m
    public void z(int i, long j5) {
        ((MediaCodec) this.f5867v).releaseOutputBuffer(i, j5);
    }

    public /* synthetic */ z(int i, boolean z2) {
        this.f5866u = i;
    }

    public /* synthetic */ z(Object obj, int i, Object obj2) {
        this.f5866u = i;
        this.f5867v = obj;
        this.f5868w = obj2;
    }

    public z(int i) {
        this.f5866u = i;
        switch (i) {
            case 14:
                this.f5867v = new f6.c(null);
                this.f5868w = new HashMap();
                break;
            case 15:
            default:
                this.f5867v = new Object();
                this.f5868w = new LinkedHashMap();
                break;
            case 16:
                this.f5867v = new c2.b0(1000L);
                this.f5868w = y6.d.a(10, new pa.b(13));
                break;
        }
    }

    public z(Context context, String str) {
        this.f5866u = 19;
        be.h.e(context, "context");
        be.h.e(str, "defaultTempDir");
        this.f5867v = context;
        this.f5868w = str;
    }

    public z(q9.e eVar) {
        this.f5866u = 7;
        this.f5867v = new HashMap();
        this.f5868w = eVar;
    }

    public z(cb.a[] aVarArr) {
        this.f5866u = 6;
        this.f5867v = aVarArr;
        this.f5868w = new t7.j(5);
    }

    public z(RelativeLayout relativeLayout, TextView textView, RecyclerView recyclerView) {
        this.f5866u = 25;
        this.f5867v = textView;
        this.f5868w = recyclerView;
    }

    public z(v1.i iVar) {
        this.f5866u = 15;
        this.f5867v = iVar;
    }

    public z(n0 n0Var) {
        this.f5866u = 3;
        this.f5867v = new CopyOnWriteArrayList();
        this.f5868w = n0Var;
    }

    public z(Context context) {
        this.f5866u = 5;
        this.f5867v = context == null ? null : context.getApplicationContext();
    }

    public z(MediaCodec mediaCodec, a7.b bVar) {
        this.f5866u = 20;
        this.f5867v = mediaCodec;
        this.f5868w = bVar;
        if (Build.VERSION.SDK_INT < 35 || bVar == null) {
            return;
        }
        LoudnessCodecController loudnessCodecController = (LoudnessCodecController) bVar.f620x;
        if (loudnessCodecController == null || loudnessCodecController.addMediaCodec(mediaCodec)) {
            s1.d.g(((HashSet) bVar.f618v).add(mediaCodec));
        }
    }

    public z(PlayerActivity playerActivity, String str, ComponentName componentName, PendingIntent pendingIntent, Bundle bundle) {
        this.f5866u = 0;
        if (!TextUtils.isEmpty(str)) {
            if (componentName == null) {
                int i = i.f5817a;
                Intent intent = new Intent("android.intent.action.MEDIA_BUTTON");
                intent.setPackage(playerActivity.getPackageName());
                List<ResolveInfo> listQueryBroadcastReceivers = playerActivity.getPackageManager().queryBroadcastReceivers(intent, 0);
                if (listQueryBroadcastReceivers.size() == 1) {
                    ActivityInfo activityInfo = listQueryBroadcastReceivers.get(0).activityInfo;
                    componentName = new ComponentName(activityInfo.packageName, activityInfo.name);
                } else {
                    if (listQueryBroadcastReceivers.size() > 1) {
                        Log.w("MediaButtonReceiver", "More than one BroadcastReceiver that handles android.intent.action.MEDIA_BUTTON was found, returning null.");
                    }
                    componentName = null;
                }
                if (componentName == null) {
                    Log.i("MediaSessionCompat", "Couldn't find a unique registered media button receiver in the given context.");
                }
            }
            if (componentName != null && pendingIntent == null) {
                Intent intent2 = new Intent("android.intent.action.MEDIA_BUTTON");
                intent2.setComponent(componentName);
                pendingIntent = PendingIntent.getBroadcast(playerActivity, 0, intent2, Build.VERSION.SDK_INT >= 31 ? 33554432 : 0);
            }
            int i10 = Build.VERSION.SDK_INT;
            if (i10 >= 29) {
                this.f5867v = new v(playerActivity, str, bundle);
            } else if (i10 >= 28) {
                this.f5867v = new u(playerActivity, str, bundle);
            } else {
                this.f5867v = new t(playerActivity, str, bundle);
            }
            Looper looperMyLooper = Looper.myLooper();
            j0(new p(), new Handler(looperMyLooper == null ? Looper.getMainLooper() : looperMyLooper));
            ((t) this.f5867v).f5847a.setMediaButtonReceiver(pendingIntent);
            this.f5868w = new u5.d(playerActivity, this);
            return;
        }
        throw new IllegalArgumentException("tag must not be null or empty");
    }

    public z(d4.f0 f0Var) {
        this.f5866u = 11;
        this.f5868w = f0Var;
        this.f5867v = new s1.t(4, new byte[4]);
    }

    @Override // d4.b0
    public void e(s1.z zVar, w2.q qVar, d4.h0 h0Var) {
    }
}
